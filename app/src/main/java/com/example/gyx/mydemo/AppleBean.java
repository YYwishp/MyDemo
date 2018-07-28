package com.example.gyx.mydemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by gyx on 2018/6/26.
 */
public class AppleBean implements Parcelable {
	private String color;
	private String eat;

	public AppleBean(String color, String eat) {
		this.color = color;
		this.eat = eat;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEat() {
		return eat;
	}

	public void setEat(String eat) {
		this.eat = eat;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.color);
		dest.writeString(this.eat);
	}

	public AppleBean() {
	}

	protected AppleBean(Parcel in) {
		this.color = in.readString();
		this.eat = in.readString();
	}

	public static final Parcelable.Creator<AppleBean> CREATOR = new Parcelable.Creator<AppleBean>() {
		@Override
		public AppleBean createFromParcel(Parcel source) {
			return new AppleBean(source);
		}

		@Override
		public AppleBean[] newArray(int size) {
			return new AppleBean[size];
		}
	};
}
