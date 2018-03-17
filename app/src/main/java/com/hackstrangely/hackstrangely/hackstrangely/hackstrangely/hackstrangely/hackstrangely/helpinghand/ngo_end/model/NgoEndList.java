package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.model;

/**
 * Created by vrihas on 17/3/18.
 */

public class NgoEndList {
    private String ngoDetails;
    private boolean success;
    private String message;


    public NgoEndList(String ngoDetails, boolean success, String message) {
        this.ngoDetails = ngoDetails;
        this.success = success;
        this.message = message;
    }

    public String getNgoDetails() {
        return ngoDetails;
    }

    public void setNgoDetails(String ngoDetails) {
        this.ngoDetails = ngoDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
