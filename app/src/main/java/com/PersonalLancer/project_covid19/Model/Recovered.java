package com.PersonalLancer.project_covid19.Model;

import com.google.gson.annotations.SerializedName;

public class Recovered{

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
			"Recovered{" + 
			"value = '" + value + '\'' + 
			"}";
		}
}