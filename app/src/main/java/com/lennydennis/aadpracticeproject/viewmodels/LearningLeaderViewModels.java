package com.lennydennis.aadpracticeproject.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lennydennis.aadpracticeproject.model.LearningHoursLeaders;
import com.lennydennis.aadpracticeproject.repository.LeaderBoardRepository;

import java.util.List;

public class LearningLeaderViewModels extends AndroidViewModel {
    private LeaderBoardRepository mLeaderBoardRepository;
    private LiveData<List<LearningHoursLeaders>> mLearningHoursLeaders;


    public LearningLeaderViewModels(@NonNull Application application) {
        super(application);

        mLeaderBoardRepository = new LeaderBoardRepository();
        mLearningHoursLeaders = mLeaderBoardRepository.getLearningHoursLeaders();
    }

    public LiveData<List<LearningHoursLeaders>> getLearningHoursLeaders(){
        return mLearningHoursLeaders;
    }
}