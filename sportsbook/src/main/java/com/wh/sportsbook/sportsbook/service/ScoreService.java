package com.wh.sportsbook.sportsbook.service;

import com.wh.sportsbook.sportsbook.model.Score;

import java.util.List;

public interface ScoreService {

    public Score createScore(Score score);

    public Score updateScore(Integer id, Score score);

    public List<Score> getScores();

    public Score getScoreById(Integer id);

    public void deleteScore(Integer id);

}
