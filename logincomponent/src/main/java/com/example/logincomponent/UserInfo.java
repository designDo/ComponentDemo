package com.example.logincomponent;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apple on 2019/2/27.
 */
public class UserInfo implements Parcelable {

  private String nickName;
  private int age;

  public UserInfo(String nickName, int age) {
    this.nickName = nickName;
    this.age = age;
  }

  protected UserInfo(Parcel in) {
    nickName = in.readString();
    age = in.readInt();
  }

  public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
    @Override public UserInfo createFromParcel(Parcel in) {
      return new UserInfo(in);
    }

    @Override public UserInfo[] newArray(int size) {
      return new UserInfo[size];
    }
  };

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(nickName);
    dest.writeInt(age);
  }

  @Override public String toString() {
    return "{nickName:" + nickName + ", age:" + age + "}";
  }
}
