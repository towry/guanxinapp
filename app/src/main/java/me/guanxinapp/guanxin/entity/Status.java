package me.guanxinapp.guanxin.entity;

/**
 * Created by Towry Wang on 2015/2/3.
 */
public class Status extends Entity {

    private String avatar;
    private long time;
    private String content;
    private String userName;
    private People person;

    public Status(String avatar, long time, String content, String userName) {
        super();
        this.avatar = avatar;
        this.time = time;
        this.content = content;
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() { return userName; }

    public void setUserName(String name) { this.userName = name; }
}
