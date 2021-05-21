package member.model;

import db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HONG
 */
public class MemberDAO {
    
    public static final int LOGIN_OK = 1;       
    public static final int PWD_DISAGREE = 2;   
    public static final int USERID_NONE = 3;    
    
    public static final int USABLE_ID = 1;      
    public static final int UNUSABLE_ID = 2;
    
    public int loginCheck(String userid, String pwd) throws SQLException {
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int result = 0;
        try {

            conn = DBUtil.getConnection();
            
            String sql = "select pwd from bike_member where userid = ?";
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, userid);
            
            rs = ps.executeQuery();
            if(rs.next()) {
                String dbPwd = rs.getString(1);
                if(dbPwd.equals(pwd)) {
                    result = LOGIN_OK;
                } else {
                    result = PWD_DISAGREE;
                }
            } else {
                result = USERID_NONE;
            }

            System.out.println("로그인 처리 결과 result = " + result);
            return result;
            
        } finally {
            DBUtil.dbClose(rs, ps, conn);
        }
    }
    
    
    public int insertMember(MemberDTO dto) throws SQLException {
        Connection conn  = null;
        PreparedStatement ps = null;
        
        try {
            conn = DBUtil.getConnection();

            String sql = "insert into bike_member(userid, pwd, email, mobile, weight)" +
                         " values(?, ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);

            ps.setString(1, dto.getUserid());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getEmail());
            ps.setString(4, dto.getMobile());
            ps.setFloat(5, dto.getWeight());
            
            int cnt = ps.executeUpdate();
            System.out.println("회원가입 결과, cnt = " + cnt + ", 매개변수 dto = " + dto);
            return cnt;
            
        } finally {
            DBUtil.dbClose(ps, conn);
        }
    }
    
    
    public int duplicateUserid(String userid) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int result = 0;
        try {
            //1,2 conn
            conn = DBUtil.getConnection();
            
            //3. ps
            String sql = "select count(*) from bike_member where userid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userid);
            
            //4. rs
            rs = ps.executeQuery();
            if(rs.next()) {
                int count = rs.getInt(1);
                if(count>0) {
                    result = UNUSABLE_ID;   //사용 불가
                } else {
                    result = USABLE_ID;     //사용 가능
                }
                System.out.println("아이디 중복확인 결과, result = " + result + ", 매개변수 userid = " + count);
            }
            return result;
            
        } finally {
            DBUtil.dbClose(rs, ps, conn);
        }
    }
}
