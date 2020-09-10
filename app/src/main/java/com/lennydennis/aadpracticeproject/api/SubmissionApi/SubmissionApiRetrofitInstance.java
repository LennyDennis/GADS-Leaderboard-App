package com.lennydennis.aadpracticeproject.api.SubmissionApi;

import retrofit2.Retrofit;

public class SubmissionApiRetrofitInstance {

    private static Retrofit sRetrofit;
    public static final String SUBMISSION_BASE_URL = "https://docs.google.com/forms/d/e/";

    public static SubmissionApi getSubmissionApiRetrofitInstance(){

        if(sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(SUBMISSION_BASE_URL)
                    .build();
        }
        return sRetrofit.create(SubmissionApi.class);
    }
}
