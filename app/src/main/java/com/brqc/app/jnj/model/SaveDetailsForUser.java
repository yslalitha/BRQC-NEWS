package com.brqc.app.jnj.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SLaksh12 on 1/16/2018.
 */

public class SaveDetailsForUser implements Parcelable {

        @SerializedName("Status")
        @Expose
        private String status;
        @SerializedName("Msg")
        @Expose
        private String msg;
        @SerializedName("ProfilePictureUrl")
        @Expose
        private String profilePictureUrl;
        @SerializedName("UserName")
        @Expose
        private String userName;


        public final static Parcelable.Creator<com.brqc.app.jnj.model.SaveDetailsForUser> CREATOR = new Creator<SaveDetailsForUser>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public com.brqc.app.jnj.model.SaveDetailsForUser createFromParcel(Parcel in) {
                return new com.brqc.app.jnj.model.SaveDetailsForUser(in);
            }

            public com.brqc.app.jnj.model.SaveDetailsForUser[] newArray(int size) {
                return (new com.brqc.app.jnj.model.SaveDetailsForUser[size]);
            }

        };

        protected SaveDetailsForUser(Parcel in) {
            this.status = ((String) in.readValue((String.class.getClassLoader())));
            this.msg = ((String) in.readValue((String.class.getClassLoader())));
            this.profilePictureUrl = ((String) in.readValue((String.class.getClassLoader())));
            this.userName = ((String) in.readValue((String.class.getClassLoader())));
        }

        /**
         * No args constructor for use in serialization
         */
        public SaveDetailsForUser() {
        }

        /**
         * @param msg
         * @param profilePictureUrl
         * @param status
         * @param userName
         */
        public SaveDetailsForUser(String msg,String profilePictureUrl, String status, String  userName ) {
            super();
            this.status = status;
            this.msg = msg;
            this.profilePictureUrl = profilePictureUrl;
            this.userName = userName;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
         public String getProfilePictureUrl() {
           return profilePictureUrl;
        }

        public void setProfilePictureUrl(String profilePictureUrl) {
          this.profilePictureUrl = profilePictureUrl;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
          this.userName = userName;
        }



        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(status);
            dest.writeValue(msg);
            dest.writeValue(profilePictureUrl);
            dest.writeValue(userName);
        }

        public int describeContents() {
            return 0;
        }

}
