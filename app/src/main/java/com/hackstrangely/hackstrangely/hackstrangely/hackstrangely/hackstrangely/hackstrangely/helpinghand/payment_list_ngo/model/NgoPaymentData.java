package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_list_ngo.model;

/**
 * Created by samveg on 26/8/17.
 */

public class NgoPaymentData {

    int id,fund;
    String name;

    public NgoPaymentData(int id, int fund, String name) {
        this.id = id;
        this.fund = fund;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFund() {
        return fund;
    }

    public void setFund(int fund) {
        this.fund = fund;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
