package com.quiz.questionbank;

import java.sql.SQLException;

public interface ScoreUpdateInterface {
	
	void insert(int userid,int correctans_C,int wrongans_c,int score) throws SQLException;

}

