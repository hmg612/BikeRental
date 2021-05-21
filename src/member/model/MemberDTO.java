/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package member.model;

/**
 *
 * @author HONG
 */
public class MemberDTO {
    private String userid;
    private String pwd;
    private String email;
    private String mobile;
    private float weight;
    private int ticket;

    public MemberDTO() {
    }

    public MemberDTO(String userid, String pwd, String email, String mobile, float weight, int ticket) {
        this.userid = userid;
        this.pwd = pwd;
        this.email = email;
        this.mobile = mobile;
        this.weight = weight;
        this.ticket = ticket;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "MemberDTO{" + "userid = " + userid + ", pwd=" + pwd + ", email=" + email + ", mobile =" + mobile + ", weight=" + weight + ", ticket = " + ticket + "}";
    }
    
    
}
