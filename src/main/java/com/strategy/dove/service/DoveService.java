package com.strategy.dove.service;

import com.strategy.dove.entity.Moves;
import com.strategy.dove.entity.Score;
import com.strategy.dove.entity.Score2;

public interface DoveService {

	String getIteration(int iteration);

	Score2 getIterationMoves(Moves m);

	Score2 getIterationMovesEagle(Moves m);

	Score2 getIterationMovesWin(Moves m);

	Score getDataFromDB();



}
