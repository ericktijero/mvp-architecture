package erick.android.mvp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by erick on 8/8/17.
 */

public class User {
    @SerializedName("name")
    private Name name;
    @SerializedName("email")
    private String email;
    @SerializedName("picture")
    private Picture picture;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
