package com.lennydennis.aadpracticeproject.viewmodels;

public interface SubmissionButtonListener<T> {

    void onResponse(T response);

    void onFailure(Throwable error);
}
