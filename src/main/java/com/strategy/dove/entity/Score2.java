package com.strategy.dove.entity;

public class Score2 {

	int iteration;

	int apiScore;

	int userScore;
	
	public Score2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score2(int iteration, int apiScore, int userScore) {
		super();
		this.iteration = iteration;
		this.apiScore = apiScore;
		this.userScore = userScore;
	}

	public int getIteration() {
		return iteration;
	}
	public void setIteration(int iteration) {
		this.iteration = iteration;
	}
	public int getApiScore() {
		return apiScore;
	}
	public void setApiScore(int apiScore) {
		this.apiScore = apiScore;
	}
	public int getUserScore() {
		return userScore;
	}
	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}
	@Override
	public String toString() {
		return "Score [iteration=" + iteration + ", apiScore=" + apiScore + ", userScore=" + userScore
				+ "]";
	}
	
	
	
}
