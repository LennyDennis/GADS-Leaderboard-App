package com.lennydennis.aadpracticeproject.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lennydennis.aadpracticeproject.api.SubmissionApi.SubmissionApi;
import com.lennydennis.aadpracticeproject.api.SubmissionApi.SubmissionApiRetrofitInstance;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionRepository {
    private SubmissionApi mSubmissionApi;

    public SubmissionRepository() {
        mSubmissionApi = SubmissionApiRetrofitInstance.getSubmissionApiRetrofitInstance();
    }

    public LiveData<String> submitProject(String firstName, String lastName, String emailAddress, String githubLink) {
        MutableLiveData<String> submissionResponse = new MutableLiveData<>();
        mSubmissionApi.submitProject(firstName, lastName, emailAddress, githubLink)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            submissionResponse.setValue(response.body().toString());
                        }else{
                            submissionResponse.setValue(response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        submissionResponse.setValue(t.getMessage());
                    }
                });
        return submissionResponse;
    }

}
