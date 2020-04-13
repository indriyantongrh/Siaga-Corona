package com.PersonalLancer.project_covid19.Api;


public class UtilsApi {

    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "https://kawalcovid19.harippe.id/api/";
    ///public static final String BASE_URL_API = "https://api.kawalcorona.com/";



    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
