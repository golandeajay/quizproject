package com.quiz.result;

class Student implements Comparable<Student> {

	private int id;
	private String firstname;
	private String lastname;
	private int score;
	private String grade;

	public Student(int id, String firstname, String lastname, int score, String grade) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.score = score;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getScore() {
		return score;
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", score=" + score
				+ ", grade=" + grade + "]";
	}

	@Override
	public int compareTo(Student s) {
		if (score == s.score) {
			return 0;
		} else if (score > s.score) {
			return 1;
		}
		return -1;
	}
}
