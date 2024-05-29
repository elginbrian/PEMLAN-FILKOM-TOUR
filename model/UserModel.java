package model;

import java.util.Arrays;
import java.util.UUID;

public class UserModel {
    private String userID = UUID.randomUUID().toString();
    private String username;
    private String password;
    private String type;

    public UserModel(String username, String password, String type){
        this.username = username;
        this.password = password;
        this.type     = type;
    }

    public UserModel(String userID, String username, String password, String type){
        this.userID   = userID;
        this.username = username;
        this.password = password;
        this.type     = type;
    }

    public String getUserID(){
        return this.userID;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getType() { return  this.type; }

    public void updateData(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getStringArray(){
        String[] userArr = {this.userID, this.username, this.password, this.type};
        String userStringArr = Arrays.toString(userArr);

        return userStringArr;
    }
}