package com.PersonalLancer.project_covid19.Api;



import com.PersonalLancer.project_covid19.Model.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;


public interface BaseApiService {

    /*API Data*/
    @GET("summary")
    Call<ResponseResult> getDataIndonesia();

/*    @GET("indonesia")
    Call<ResponseIndonesia> getDataIndonesia();*/


}
