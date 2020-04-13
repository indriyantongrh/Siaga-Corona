package com.PersonalLancer.project_covid19.Model.ResponseCovid19;

import com.google.gson.annotations.SerializedName;

public class ResponseCovid19{

	@SerializedName("attributes")
	private Attributes attributes;

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}
}