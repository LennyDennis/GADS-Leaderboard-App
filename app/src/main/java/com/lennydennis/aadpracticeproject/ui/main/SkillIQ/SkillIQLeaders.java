package com.lennydennis.aadpracticeproject.ui.main.SkillIQ;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lennydennis.aadpracticeproject.R;

public class SkillIQLeaders extends Fragment {

    private SkillIQLeadersViewModel mViewModel;

    public static SkillIQLeaders newInstance() {
        return new SkillIQLeaders();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.skilliq_leaders_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SkillIQLeadersViewModel.class);
        // TODO: Use the ViewModel
    }

}