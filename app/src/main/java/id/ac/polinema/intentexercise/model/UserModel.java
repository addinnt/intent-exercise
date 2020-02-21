package id.ac.polinema.intentexercise.model;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String fullName;
    private String email;
    private String password;
    private String homepage;
    private String about;
    private Bitmap profileImage;

    //, Image profileImage
    public UserModel(String fullName, String email, String password, String homepage, String about) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.homepage = homepage;
        this.about = about;
        //this.profileImage = profileImage;
    }

    public Bitmap getProfileImage() {
        return profileImage;
    }

    public void setImageBitmap(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public static Creator<UserModel> getCREATOR() {
        return CREATOR;
    }

    public UserModel(Parcel in) {
        fullName = in.readString();
        email = in.readString();
        password = in.readString();
        homepage = in.readString();
        about = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fullName);
        parcel.writeString(email);
        parcel.writeString(password);
        parcel.writeString(homepage);
        parcel.writeString(about);
    }
}
