package com.lennydennis.aadpracticeproject.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.lennydennis.aadpracticeproject.api.LeaderBoardApi.LeaderBoardApi;
import com.lennydennis.aadpracticeproject.api.LeaderBoardApi.LeaderBoardApiRetrofitInstance;
import com.lennydennis.aadpracticeproject.model.LearningHoursLeaders;
import com.lennydennis.aadpracticeproject.model.SkillIQScoresLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardRepository {

    private LeaderBoardApi mLeaderBoardApi;

    public LeaderBoardRepository() {
        mLeaderBoardApi = LeaderBoardApiRetrofitInstance.getLeaderBoardApiRetrofitInstance();
    }

    public LiveData<List<LearningHoursLeaders>> getLearningHoursLeaders() {
        final MutableLiveData<List<LearningHoursLeaders>> learningHoursLeadersMutableLiveData = new MutableLiveData<>();
        mLeaderBoardApi.getLearningHoursLeaders()
                .enqueue(new Callback<List<LearningHoursLeaders>>() {
                    @Override
                    public void onResponse(Call<List<LearningHoursLeaders>> call, Response<List<LearningHoursLeaders>> response) {
                        if (response.body() != null) {
                            learningHoursLeadersMutableLiveData.setValue(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<List<LearningHoursLeaders>> call, Throwable t) {
                        learningHoursLeadersMutableLiveData.setValue(null);
                    }
                });
        return learningHoursLeadersMutableLiveData;
    }

    public LiveData<List<SkillIQScoresLeaders>> getSkillIQLeaders() {
        final MutableLiveData<List<SkillIQScoresLeaders>> skillIQScoresLeadersMutableLiveData = new MutableLiveData<>();
        mLeaderBoardApi.getSkillIQScoresLeaders()
                .enqueue(new Callback<List<SkillIQScoresLeaders>>() {
                    @Override
                    public void onResponse(Call<List<SkillIQScoresLeaders>> call, Response<List<SkillIQScoresLeaders>> response) {
                        skillIQScoresLeadersMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<SkillIQScoresLeaders>> call, Throwable t) {
                        skillIQScoresLeadersMutableLiveData.setValue(null);
                    }
                });
        return skillIQScoresLeadersMutableLiveData;
    }
}
