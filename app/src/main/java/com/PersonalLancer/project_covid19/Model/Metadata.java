package com.PersonalLancer.project_covid19.Model;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("lastUpdatedAt")
	private String lastUpdatedAt;

	public void setLastUpdatedAt(String lastUpdatedAt){
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getLastUpdatedAt(){
		return lastUpdatedAt;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"lastUpdatedAt = '" + lastUpdatedAt + '\'' + 
			"}";
		}
}