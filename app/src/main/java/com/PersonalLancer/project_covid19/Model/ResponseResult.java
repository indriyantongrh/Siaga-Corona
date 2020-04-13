package com.PersonalLancer.project_covid19.Model;

import com.google.gson.annotations.SerializedName;

public class ResponseResult{

	@SerializedName("cluster")
	private Cluster cluster;

	@SerializedName("recovered")
	private Recovered recovered;

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("nationality")
	private Nationality nationality;

	@SerializedName("province")
	private Province province;

	@SerializedName("gender")
	private Gender gender;

	@SerializedName("activeCare")
	private ActiveCare activeCare;

	@SerializedName("confirmed")
	private Confirmed confirmed;

	@SerializedName("deaths")
	private Deaths deaths;

	public void setCluster(Cluster cluster){
		this.cluster = cluster;
	}

	public Cluster getCluster(){
		return cluster;
	}

	public void setRecovered(Recovered recovered){
		this.recovered = recovered;
	}

	public Recovered getRecovered(){
		return recovered;
	}

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setNationality(Nationality nationality){
		this.nationality = nationality;
	}

	public Nationality getNationality(){
		return nationality;
	}

	public void setProvince(Province province){
		this.province = province;
	}

	public Province getProvince(){
		return province;
	}

	public void setGender(Gender gender){
		this.gender = gender;
	}

	public Gender getGender(){
		return gender;
	}

	public void setActiveCare(ActiveCare activeCare){
		this.activeCare = activeCare;
	}

	public ActiveCare getActiveCare(){
		return activeCare;
	}

	public void setConfirmed(Confirmed confirmed){
		this.confirmed = confirmed;
	}

	public Confirmed getConfirmed(){
		return confirmed;
	}

	public void setDeaths(Deaths deaths){
		this.deaths = deaths;
	}

	public Deaths getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"ResponseResult{" + 
			"cluster = '" + cluster + '\'' + 
			",recovered = '" + recovered + '\'' + 
			",metadata = '" + metadata + '\'' + 
			",nationality = '" + nationality + '\'' + 
			",province = '" + province + '\'' + 
			",gender = '" + gender + '\'' + 
			",activeCare = '" + activeCare + '\'' + 
			",confirmed = '" + confirmed + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}