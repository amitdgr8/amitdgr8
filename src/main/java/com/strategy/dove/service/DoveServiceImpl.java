package com.strategy.dove.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strategy.dove.controller.DoveController;
import com.strategy.dove.dao.DoveDao;
import com.strategy.dove.entity.Moves;
import com.strategy.dove.entity.Score;
import com.strategy.dove.entity.Score2;

@Service
public class DoveServiceImpl implements DoveService {

	@Autowired
	DoveDao doveDao;
	
	final char apiMove = 'D';
	final char apiEagle='E';
	@Override
	public String getIteration(int iteration) {
		String result = "Something went Wrong";
		try {
			Score sc = new Score();
			sc.setApiScore(0);
			sc.setIteration(iteration);
			sc.setUserScore(0);
			sc.setSno(1);
			doveDao.save(sc);
			result= "New Game Initiated with "+iteration+" Iterations .\nHit /doveApiMove  OR /eagleApiMove OR /winApiMove API "+iteration+" times to See Final Result. \nUntill all the required iterations are completed RESPONSE will show the number of Iterations pending";
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Score2 getIterationMoves(Moves m) {
		char userMove = m.getMove();
		Score dbScore = doveDao.findById(1).get();
		if(dbScore.getIteration()<=0) {
			Score2 score = new Score2(DoveController.globalIteration,dbScore.getApiScore(), dbScore.getUserScore() );
			return score;
		}else {
			if(userMove == apiMove) {
				dbScore.setApiScore(dbScore.getApiScore()+2);
				dbScore.setUserScore(dbScore.getUserScore()+2);
			}else if(userMove == 'E'){
				dbScore.setApiScore(dbScore.getApiScore()-1);
				dbScore.setUserScore(dbScore.getUserScore()+3);
			}
			dbScore.setIteration(dbScore.getIteration()-1);
			doveDao.save(dbScore);
			int newIteration = dbScore.getIteration()==0?DoveController.globalIteration:dbScore.getIteration();
			Score2 score = new Score2(newIteration, dbScore.getApiScore(), dbScore.getUserScore() );
			return score;
		}
		
	}

	@Override
	public Score2 getIterationMovesEagle(Moves m) {

		System.out.println("service");
		char userMove = m.getMove();
		Score dbScore = doveDao.findById(1).get();
		
		if(dbScore.getIteration()<=0) {
			Score2 score = new Score2(DoveController.globalIteration,dbScore.getApiScore(), dbScore.getUserScore() );
			return score;
		}else {
			if(userMove == apiEagle) {
				dbScore.setApiScore(dbScore.getApiScore()+0);
				dbScore.setUserScore(dbScore.getUserScore()+0);
			}else if(userMove == 'D'){
				dbScore.setApiScore(dbScore.getApiScore()+3);
				dbScore.setUserScore(dbScore.getUserScore()-1);
			}
			dbScore.setIteration(dbScore.getIteration()-1);
			doveDao.save(dbScore);
			int newIteration = dbScore.getIteration()==0?DoveController.globalIteration:dbScore.getIteration();
			Score2 score = new Score2(newIteration, dbScore.getApiScore(), dbScore.getUserScore() );
			return score;
		}
		
	
	}

	@Override
	public Score2 getIterationMovesWin(Moves m) {

		char userMove = m.getMove();
		Score dbScore = doveDao.findById(1).get();
		if(dbScore.getIteration()<=0) {
			Score2 score = new Score2(DoveController.globalIteration,dbScore.getApiScore(), dbScore.getUserScore() );
			return score;
		}else {
			if(userMove == 'E') {
				dbScore.setApiScore(dbScore.getApiScore()+0);
				dbScore.setUserScore(dbScore.getUserScore()+0);
			}else if(userMove == 'D'){
				dbScore.setApiScore(dbScore.getApiScore()+3);
				dbScore.setUserScore(dbScore.getUserScore()-1);
			}
			dbScore.setIteration(dbScore.getIteration()-1);
			doveDao.save(dbScore);
			int newIteration = dbScore.getIteration()==0?DoveController.globalIteration:dbScore.getIteration();
			Score2 score = new Score2(newIteration, dbScore.getApiScore(), dbScore.getUserScore() );
			return score;
	}

}
	@Override
	public Score getDataFromDB() {
		return doveDao.findById(1).get();
	}
}
