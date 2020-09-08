package com.lennydennis.aadpracticeproject.api;

import com.lennydennis.aadpracticeproject.model.LearningHours;
import com.lennydennis.aadpracticeproject.model.SkillIQScores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardApi {

    @GET("/api/hours")
    Call<List<LearningHours>> getLearningHours();

    @GET("/api/skilliq")
    Call<List<SkillIQScores>> getSkillIQScores();

}
