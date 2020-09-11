package com.lennydennis.aadpracticeproject.views;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.databinding.SubmissionFragmentBinding;
import com.lennydennis.aadpracticeproject.viewmodels.SubmissionButtonListener;
import com.lennydennis.aadpracticeproject.viewmodels.SubmissionViewModel;

public class SubmissionFragment extends Fragment {

    private SubmissionViewModel mViewModel;
    private SubmissionFragmentBinding mSubmissionFragmentBinding;
    private SubmissionButtonListener mSubmissionButtonListener;

    public static SubmissionFragment newInstance() {
        return new SubmissionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mSubmissionFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.submission_fragment, container, false);
        return mSubmissionFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SubmissionViewModel.class);

        mSubmissionButtonListener = new SubmissionButtonListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onFailure() {

            }
        };
        mViewModel.setListener(mSubmissionButtonListener);
    }
}