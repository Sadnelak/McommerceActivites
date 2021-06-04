package com.mexpedition.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mexpedition.dao.ExpeditionRepository;
import com.mexpedition.exeptions.ExpeditionInexistanteException;
import com.mexpedition.exeptions.ImpossibleAjouterExpeditionException;
import com.mexpedition.model.Expedition;

@RestController
public class ExpeditionController {
	
	@Autowired
	private ExpeditionRepository expeditionRepository;
	
	@PostMapping("/expeditions")
	public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition exp){
		Expedition nouvelleCommande = expeditionRepository.save(exp);

	    if(nouvelleCommande == null) throw new ImpossibleAjouterExpeditionException("Impossible d'ajouter cette expedition");
	
	    return new ResponseEntity<Expedition>(exp, HttpStatus.CREATED);
	}

	@PutMapping("/expeditions")
	public ResponseEntity<Expedition> majExpedition(@RequestBody Expedition exp){
		Optional<Expedition> existingExpedition = expeditionRepository.findById(exp.getId());
		if(existingExpedition.isEmpty()) {
			throw new ExpeditionInexistanteException("Cette expedition n'existe pas.");
		}
		Expedition nouvelleCommande = expeditionRepository.save(exp);

	    if(nouvelleCommande == null) {
	    	throw new ImpossibleAjouterExpeditionException("Impossible de mettre à jour cette expedition");
	    }
	
	    return new ResponseEntity<Expedition>(exp, HttpStatus.OK);
	}

	@GetMapping("/expeditions/{id}")
	public Expedition reccupererExpeditionParId(@PathVariable int id) {
		Optional<Expedition> existingExpedition = expeditionRepository.findById(id);
		if(existingExpedition.isEmpty()) {
			throw new ExpeditionInexistanteException("Cette expedition n'existe pas.");
		}
	    return existingExpedition.get();
	}
	
}
