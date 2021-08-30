package com.strategy.dove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	int sno;
	@Column
	int iteration;
	@Column
	int apiScore;
	@Column
	int userScore;
	
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score(int sno, int iteration, int apiScore, int userScore) {
		super();
		this.sno = sno;
		this.iteration = iteration;
		this.apiScore = apiScore;
		this.userScore = userScore;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
		return "Score [sno=" + sno + ", iteration=" + iteration + ", apiScore=" + apiScore + ", userScore=" + userScore
				+ "]";
	}
	
	
	
}
