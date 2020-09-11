package com.lennydennis.aadpracticeproject.views;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lennydennis.aadpracticeproject.R;
import com.lennydennis.aadpracticeproject.adapter.SectionsPagerAdapter;
import com.lennydennis.aadpracticeproject.databinding.HomeFragmentBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private HomeFragmentBinding mHomeFragmentBinding;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mHomeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.home_fragment, container, false);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getChildFragmentManager());
        mHomeFragmentBinding.viewPager.setAdapter(sectionsPagerAdapter);
        mHomeFragmentBinding.tabs.setupWithViewPager(mHomeFragmentBinding.viewPager);

        return mHomeFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new HomeViewModel(getContext());

        // TODO: Use the ViewModel
    }

}