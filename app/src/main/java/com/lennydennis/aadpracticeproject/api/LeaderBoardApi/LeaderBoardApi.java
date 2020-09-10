package com.lennydennis.aadpracticeproject.api.LeaderBoardApi;

import com.lennydennis.aadpracticeproject.model.LearningHoursLeaders;
import com.lennydennis.aadpracticeproject.model.SkillIQScoresLeaders;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeaderBoardApi {

    @GET("/api/hours")
    Call<List<LearningHoursLeaders>> getLearningHoursLeaders();

    @GET("/api/skilliq")
    Call<List<SkillIQScoresLeaders>> getSkillIQScoresLeaders();

}
