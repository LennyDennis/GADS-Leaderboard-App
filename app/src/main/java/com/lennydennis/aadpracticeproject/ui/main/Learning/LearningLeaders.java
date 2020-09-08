package com.lennydennis.aadpracticeproject.ui.main.Learning;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lennydennis.aadpracticeproject.R;

public class LearningLeaders extends Fragment {

    private LearningLeaderViewModels mViewModel;

    public static LearningLeaders newInstance() {
        return new LearningLeaders();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learning_leaders_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LearningLeaderViewModels.class);
        // TODO: Use the ViewModel
    }

}