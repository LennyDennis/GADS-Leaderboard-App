package com.lennydennis.aadpracticeproject.viewmodels;

import android.view.View;

import androidx.lifecycle.ViewModel;

public class SubmissionViewModel extends ViewModel {
    String firstName = null,
            lastName = null,
            emailAddress = null,
            githubLink = null;

    public SubmissionButtonListener mSubmissionButtonListener;

    public void submitProjectButtonClick(SubmissionButtonListener submissionButtonListener){
        submissionButtonListener.onStarted();
        if(firstName.isEmpty() || lastName.isEmpty() || emailAddress.isEmpty() || githubLink.isEmpty()){

            submissionButtonListener.onFailure();
            return;
        }
        submissionButtonListener.onSuccess();
    }

    public void setListener(SubmissionButtonListener submissionButtonListener){
        mSubmissionButtonListener = submissionButtonListener;
    }

    public SubmissionButtonListener getSubmissionButtonListener(){
        return mSubmissionButtonListener;
    }
}