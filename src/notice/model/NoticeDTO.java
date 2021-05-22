/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notice.model;

import java.sql.Timestamp;

/**
 *
 * @author HONG
 */
public class NoticeDTO {
    private int no;
    private String title;
    private String contents;
    private Timestamp regdate;

    public NoticeDTO() {
        super();
    }

    public NoticeDTO(int no, String title, String contents, Timestamp regdate) {
        this.no = no;
        this.title = title;
        this.contents = contents;
        this.regdate = regdate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" + "no=" + no + ", title=" + title + ", contents=" + contents + ", regdate=" + regdate + '}';
    }
    
    
}
