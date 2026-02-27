package com.vibol.api.ResourceServer.response;

public class UserRest {

    private String userFristName;
    private String userLastName;
    private String userId;

    public UserRest(String userFristName, String userLastName, String userId) {
        this.userFristName = userFristName;
        this.userLastName = userLastName;
        this.userId = userId;
    }

    public String getUserFristName() {
        return userFristName;
    }

    public void setUserFristName(String userFristName) {
        this.userFristName = userFristName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
