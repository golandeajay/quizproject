package com.quiz.feedback;

import java.sql.SQLException;

public interface Feedback {
	
	void UpdateFeedback(int userid, String feedback, String rate) throws SQLException;
}

