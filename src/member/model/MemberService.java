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
public class MemberService {
    
    private static String userid;

    public static String getUserid() {
        return userid;
    }

    public static void setUserid(String userid) {
        MemberService.userid = userid;
    }
}
