/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notice.model;

import db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HONG
 */
public class NoticeDAO {
    
    public List<NoticeDTO> selectAll() throws SQLException {
        
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
            
        try {
            List<NoticeDTO> list = new ArrayList<NoticeDTO>();

            conn = DBUtil.getConnection();

            String sql = "select * from notice";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()) {
                int no = rs.getInt(1);
                String title = rs.getString(2);
                String contents = rs.getString(3);
                Timestamp regdate = rs.getTimestamp(4);

                NoticeDTO dto = new NoticeDTO(no, title, contents, regdate);

                list.add(dto);
            }
            System.out.println("상품 전체 조회 결과, list.size=" + list.size());
            return list;
            
        } finally {
         DBUtil.dbClose(rs, ps, conn);
      }
    }
}
