package me.guanxinapp.guanxin.entity;

import android.os.Parcelable;
import android.os.Parcel;

/**
 * Created by Towry Wang on 2015/1/26.
 */
public class People extends Entity implements Parcelable {

    private String uid;     // user id
    private String avatar;  // user avatar
    private String name;    // user name
    // private int gender;     // user gender
    // private int genderId;
    // private int genderBgId;
    private int age;
    private String time;

    private String distance;

    /**
     * Get user id
     * @return String
     */
    public String getUid() {
        return uid;
    }

    /**
     * Set the user id
     * @return void
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Get user avatar
     * @return String
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Set user av atar
     * @return void
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Get user name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set user name
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /********************
     * Gender ignored
     * @return nil
     */

    /**
     * Get age
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * Set age
     * @return void
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get time
     * @return String
     */
    public String getTime() {
        return time;
    }

    /**
     * Set time
     * @return void
     */
    public void setTime(String time) {
        this.time = time;
    }

    public static final Parcelable.Creator<People> CREATOR = new Parcelable.Creator<People>() {

        @SuppressWarnings("unchecked")
        @Override
        public People createFromParcel(Parcel source) {
            People p = new People();
            p.setUid(source.readString());
            p.setAvatar(source.readString());
            p.setName(source.readString());
            p.setAge(source.readInt());
            p.setTime(source.readString());

            return p;
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    /**
     * ?
     * @return
     */
    public static Parcelable.Creator<People> getCreator() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uid);
        dest.writeString(avatar);
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(time);
    }
}
