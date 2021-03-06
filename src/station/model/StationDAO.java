/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package station.model;

import db.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HONG
 */
public class StationDAO {
    
    public List<StationDTO> selectAll() throws SQLException {
        
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
            
        try {
            List<StationDTO> list = new ArrayList<StationDTO>();

            conn = DBUtil.getConnection();

            String sql = "select no, name, gu, addr, cnt_bike from bike_station";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()) {
                int no = rs.getInt(1);
                String stName = rs.getString(2);
                String gu = rs.getString(3);
                String address = rs.getString(4);
                int cnt_bike = rs.getInt(5);

                StationDTO dto = new StationDTO(no, stName, gu, address, cnt_bike);

                list.add(dto);
            }
            System.out.println("상품 전체 조회 결과, list.size=" + list.size());
            return list;
            
        } finally {
         DBUtil.dbClose(rs, ps, conn);
      }
    }
}
