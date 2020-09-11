package com.lennydennis.aadpracticeproject.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lennydennis.aadpracticeproject.api.ApiResponseError;
import com.lennydennis.aadpracticeproject.api.SubmissionApi.SubmissionApi;
import com.lennydennis.aadpracticeproject.api.SubmissionApi.SubmissionApiRetrofitInstance;
import com.lennydennis.aadpracticeproject.model.Submission;
import com.lennydennis.aadpracticeproject.viewmodels.SubmissionButtonListener;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionRepository {
    private SubmissionApi mSubmissionApi;

    public SubmissionRepository() {
        mSubmissionApi = SubmissionApiRetrofitInstance.getSubmissionApiRetrofitInstance();
    }

    public void submitProject(Submission submission, SubmissionButtonListener callback) {
        mSubmissionApi.submitProject(submission.getFirstName(), submission.getLastName(), submission.getEmailAddress(), submission.getGithubLink())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            callback.onResponse(null);
                        } else {
                            callback.onFailure(new ApiResponseError(response));
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        callback.onFailure(t);
                    }
                });
    }
}
