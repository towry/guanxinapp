package me.guanxinapp.guanxin.foundation;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Towry Wang on 2015/1/28.
 */
public class UserInfo implements Parcelable {

    private String id;
    private String screen_name;
    private String name;
    private String avatar;
    private String cover_image;
    private String gender;
    private String created_at;
    private String geo_enabled;
    private String online_status;

    public String getUid() {
        return id;
    }

    public void setUid(String id) {
        this.id = id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String name) {
        this.screen_name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(screen_name);
    }

    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() {
        public UserInfo createFromParcel(Parcel in) {
            UserInfo userInfo = new UserInfo();

            return userInfo;
        }

        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
