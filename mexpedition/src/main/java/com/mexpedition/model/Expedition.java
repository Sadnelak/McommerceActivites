package com.mexpedition.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Expedition {
	@Id
	@GeneratedValue
	private int id;
	
	private int indCommande;
	
	private int etat;
}
