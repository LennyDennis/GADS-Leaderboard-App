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
import com.lennydennis.aadpracticeproject.adapter.SkillIQLeadersAdapter;
import com.lennydennis.aadpracticeproject.databinding.SkilliqLeadersFragmentBinding;
import com.lennydennis.aadpracticeproject.model.SkillIQScoresLeaders;
import com.lennydennis.aadpracticeproject.viewmodels.SkillIQLeadersViewModel;

import java.util.ArrayList;

public class SkillIQLeaders extends Fragment {

    private SkillIQLeadersViewModel mViewModel;
    private SkilliqLeadersFragmentBinding mSkillIQLeadersFragmentBinding;

    private ArrayList<SkillIQScoresLeaders> mSkillIQScoresLeaders = new ArrayList<>();
    private SkillIQLeadersAdapter mSkillIQLeadersAdapter;

    public static SkillIQLeaders newInstance() {
        return new SkillIQLeaders();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mSkillIQLeadersFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.skilliq_leaders_fragment, container, false);
        final View view = mSkillIQLeadersFragmentBinding.getRoot();
        intializeSkillIQFragment();
        return view;
    }

    private void intializeSkillIQFragment() {
        mSkillIQLeadersFragmentBinding.skillIqRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        mSkillIQLeadersAdapter = new SkillIQLeadersAdapter(getContext(), mSkillIQScoresLeaders);
        mSkillIQLeadersFragmentBinding.skillIqRecyclerview.setAdapter(mSkillIQLeadersAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SkillIQLeadersViewModel.class);

        mViewModel.getSkillIQLeaders().observe(getActivity(), skillIQScoresLeaders -> {
            if(skillIQScoresLeaders != null){
                mSkillIQScoresLeaders.addAll(skillIQScoresLeaders);
                mSkillIQLeadersAdapter.notifyDataSetChanged();
            }
        });
    }

}