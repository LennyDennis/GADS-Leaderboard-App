package com.lennydennis.aadpracticeproject.views;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.adapter.LearningLeadersAdapter;
import com.lennydennis.aadpracticeproject.databinding.LearningLeadersFragmentBinding;
import com.lennydennis.aadpracticeproject.model.LearningHoursLeaders;
import com.lennydennis.aadpracticeproject.viewmodels.LearningLeaderViewModels;

import java.util.ArrayList;
import java.util.Objects;

public class LearningLeaders extends Fragment {

    private LearningLeaderViewModels mViewModel;
    private LearningLeadersFragmentBinding mLearningLeadersFragmentBinding;
    private ArrayList<LearningHoursLeaders> mLearningHoursLeaders = new ArrayList<>();
    private LearningLeadersAdapter mLearningLeadersAdapter;


    public static LearningLeaders newInstance() {
        return new LearningLeaders();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mLearningLeadersFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.learning_leaders_fragment, container, false);
        View view = mLearningLeadersFragmentBinding.getRoot();
        initializeFragment();

        return view;
    }

    private void initializeFragment() {
        mLearningLeadersFragmentBinding.learningRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mLearningLeadersAdapter = new LearningLeadersAdapter(getContext(),mLearningHoursLeaders);
        mLearningLeadersFragmentBinding.learningRecyclerview.setAdapter(mLearningLeadersAdapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LearningLeaderViewModels.class);

        mViewModel.getLearningHoursLeaders().observe(requireActivity(), learningLeaders ->{
            if(learningLeaders != null){
                mLearningHoursLeaders.addAll(learningLeaders);
                mLearningLeadersAdapter.notifyDataSetChanged();
            }
        });
    }

}