package com.lennydennis.aadpracticeproject.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.lennydennis.aadpracticeproject.model.LearningHoursLeaders;
import com.lennydennis.aadpracticeproject.model.SkillIQScoresLeaders;
import com.lennydennis.aadpracticeproject.repository.LeaderBoardRepository;
import com.lennydennis.aadpracticeproject.views.SkillIQLeaders;

import java.util.List;

public class SkillIQLeadersViewModel extends AndroidViewModel {
    private LeaderBoardRepository mLeaderBoardRepository;
    private LiveData<List<SkillIQScoresLeaders>> mSkillIQLeaders;


    public SkillIQLeadersViewModel(@NonNull Application application) {
        super(application);

        mLeaderBoardRepository = new LeaderBoardRepository();
        mSkillIQLeaders = mLeaderBoardRepository.getSkillIQLeaders();
    }

    public LiveData<List<SkillIQScoresLeaders>> getSkillIQLeaders(){
        return  mSkillIQLeaders;
    }
}