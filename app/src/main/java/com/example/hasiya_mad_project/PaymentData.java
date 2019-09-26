package com.example.hasiya_mad_project;

public class PaymentData
{
    String name;
    String cardNo;

    public PaymentData(String name, String cardNo) {
        this.name = name;
        this.cardNo = cardNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
