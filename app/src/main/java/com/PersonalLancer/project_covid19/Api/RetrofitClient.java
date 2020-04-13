package com.PersonalLancer.project_covid19.Api;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitClient {



    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }


//    private static OkHttpClient client = new OkHttpClient();
//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient(String baseUrl){
//        TokenAuthenticator interceptor = new TokenAuthenticator();
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .build();
//
//        if (retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(client)
//                    .build();
//        }
//        return retrofit;
//    }


//    private static OkHttpClient client = new OkHttpClient();
//    private static Retrofit retrofit = null;
//
//    public static Retrofit getClient(Context context, String baseUrl){
//        TokenAuthenticator interceptor = new TokenAuthenticator(context);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(interceptor)
//                .build();
//
//        if (retrofit == null){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl(baseUrl)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(client)
//                    .build();
//        }
//        return retrofit;
//    }


/* ini yang bisa */
 /*   private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl){

        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder()
                .readTimeout(240, TimeUnit.SECONDS)
                .connectTimeout(240, TimeUnit.SECONDS);
        okhttpBuilder.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {

                    Request request = chain.request();
                    Request.Builder newRequest = request.newBuilder();

                    return chain.proceed(newRequest.build());

            }
        });



        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder()
//                                    .addInterceptor(interceptor)
//                                    //.addInterceptor(new TokenAuthenticator(ontext))
//                                    .build();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okhttpBuilder.build())
                    .build();
        }
        return retrofit;
    }*/
}
