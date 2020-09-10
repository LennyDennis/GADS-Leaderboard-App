package com.lennydennis.aadpracticeproject.api.LeaderBoardApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LeaderBoardApiRetrofitInstance {

    private static Retrofit sRetrofit = null;
    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    public static LeaderBoardApi getLeaderBoardApiRetrofitInstance(){

        if(sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sRetrofit.create(LeaderBoardApi.class);
    }
}
