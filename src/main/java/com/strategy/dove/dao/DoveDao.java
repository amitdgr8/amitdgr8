package com.strategy.dove.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strategy.dove.entity.Score;



@Repository
public interface DoveDao extends JpaRepository<Score, Integer>{

}
