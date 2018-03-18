package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.payment_gateway.model;

import java.util.List;

/**
 * Created by samveg on 26/8/17.
 */

public class NgoPaymentList {

    String key,productinfo,firstname,email,txnid,furl,surl,amount,hash,service_provider;

    public NgoPaymentList(String key, String productinfo, String firstname, String email, String txnid, String furl, String surl, String amount, String hash, String service_provider) {
        this.key = key;
        this.productinfo = productinfo;
        this.firstname = firstname;
        this.email = email;
        this.txnid = txnid;
        this.furl = furl;
        this.surl = surl;
        this.amount = amount;
        this.hash = hash;
        this.service_provider = service_provider;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProductinfo() {
        return productinfo;
    }

    public void setProductinfo(String productinfo) {
        this.productinfo = productinfo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTxnid() {
        return txnid;
    }

    public void setTxnid(String txnid) {
        this.txnid = txnid;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getService_provider() {
        return service_provider;
    }

    public void setService_provider(String service_provider) {
        this.service_provider = service_provider;
    }
}
