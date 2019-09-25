package com.example.hasiya_mad_project;

public class paymentDBClass {
    private String cno;
    private String cname;
    private String cvcNo;

    public paymentDBClass() {

    }

    public String getCno() {
        return cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCvcNo(String cvcNo) {
        return cvcNo;
    }

    public void setCvcNo(String cvcNo) {
        this.cvcNo = cvcNo;
    }

}
