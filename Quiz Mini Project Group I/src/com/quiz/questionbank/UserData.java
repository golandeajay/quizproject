package com.quiz.questionbank;

public class UserData {
	private int userid;
	private String correctanswer;
	private String wronganswer;
	private String score;
	private String grade;

	public UserData(int userid, String correctanswer, String wronganswer, String score, String grade) {
		super();
		this.userid = userid;
		this.correctanswer = correctanswer;
		this.wronganswer = wronganswer;
		this.score = score;
		this.grade = grade;
	}
	public int getUserid() {
		return userid;
	}
	public String getCorrectanswer() {
		return correctanswer;
	}
	public String getWronganswer() {
		return wronganswer;
	}
	public String getScore() {
		return score;
	}
	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "UserData [userid=" + userid + ", correctanswer=" + correctanswer + ", wronganswer=" + wronganswer
				+ ", score=" + score + ", grade=" + grade + "]";
	}

}
