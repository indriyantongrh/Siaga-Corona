package com.PersonalLancer.project_covid19.Model;

import com.google.gson.annotations.SerializedName;

public class ActiveCare{

	@SerializedName("value")
	private int value;

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"ActiveCare{" + 
			"value = '" + value + '\'' + 
			"}";
		}
}