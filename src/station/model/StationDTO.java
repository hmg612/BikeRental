/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package station.model;

/**
 *
 * @author HONG
 */
public class StationDTO {
    
    private int no;
    private String stName;
    private String gu;
    private String address;
    private int cnt_bike;

    public StationDTO() {
        super();
    }

    public StationDTO(int no, String stName, String gu, String address, int cnt_bike) {
        super();
        this.no = no;
        this.stName = stName;
        this.gu = gu;
        this.address = address;
        this.cnt_bike = cnt_bike;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getGu() {
        return gu;
    }

    public void setGu(String gu) {
        this.gu = gu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCnt_bike() {
        return cnt_bike;
    }

    public void setCnt_bike(int cnt_bike) {
        this.cnt_bike = cnt_bike;
    }

    @Override
    public String toString() {
        return "StationDTO{" + "no=" + no + ", stName=" + stName + ", gu=" + gu + ", address=" + address + ", cnt_bike=" + cnt_bike + '}';
    }    
    
}
