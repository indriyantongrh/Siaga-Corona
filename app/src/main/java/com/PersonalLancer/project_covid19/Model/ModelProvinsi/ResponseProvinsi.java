package com.PersonalLancer.project_covid19.Model.ModelProvinsi;

import com.google.gson.annotations.SerializedName;

public class ResponseProvinsi{

	@SerializedName("attributes")
	private Attributes attributes;

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}
}