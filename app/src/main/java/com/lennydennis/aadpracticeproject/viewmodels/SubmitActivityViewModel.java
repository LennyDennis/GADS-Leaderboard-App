package com.lennydennis.aadpracticeproject.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lennydennis.aadpracticeproject.model.Submission;
import com.lennydennis.aadpracticeproject.repository.SubmissionRepository;

public class SubmitActivityViewModel extends ViewModel {
    public static final int STATUS_NEUTRAL = 0;
    public static final int STATUS_OK = 1;
    public static final int STATUS_ERROR = -1;
    private MutableLiveData<Integer> status = new MutableLiveData<>(STATUS_NEUTRAL);

    private SubmissionRepository mSubmissionRepository;

    public SubmitActivityViewModel() {
        mSubmissionRepository = new SubmissionRepository();
    }

    public void submitProject(Submission submission){
        status.setValue(STATUS_NEUTRAL);
        mSubmissionRepository.submitProject(submission, new SubmissionButtonListener() {
            @Override
            public void onResponse(Object response) {
                status.postValue(STATUS_OK);
            }

            @Override
            public void onFailure(Throwable error) {
                status.postValue(STATUS_ERROR);

            }
        });
    }

    public LiveData<Integer> getStatus() {
        return status;
    }
}

