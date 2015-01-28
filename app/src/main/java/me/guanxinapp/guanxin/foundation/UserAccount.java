package me.guanxinapp.guanxin.foundation;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Towry Wang on 2015/1/28.
 */
public class UserAccount implements Parcelable {

    private String access_token;
    private long expire_time;
    // private UserInfo userInfo;

    public String getUid() {
        return "";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Parcelable.Creator<UserAccount> CREATOR = new Parcelable.Creator<UserAccount>() {
        public UserAccount createFromParcel(Parcel in) {
            UserAccount account = new UserAccount();

            return account;
        }

        public UserAccount[] newArray(int size) {
            return new UserAccount[size];
        }
    };
}
