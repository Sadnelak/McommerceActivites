package com.mexpedition.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mexpedition.model.Expedition;

@Repository
public interface ExpeditionRepository extends JpaRepository<Expedition, Integer>{

}
