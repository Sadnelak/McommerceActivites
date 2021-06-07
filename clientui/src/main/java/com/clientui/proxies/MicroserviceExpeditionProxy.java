package com.clientui.proxies;

import com.clientui.beans.CommandeBean;
import com.clientui.beans.ExpeditionBean;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-expedition")
public interface MicroserviceExpeditionProxy {

    
    @PostMapping(value = "/microservice-expedition/Expeditions")
	public ResponseEntity<ExpeditionBean> ajouterExpedition(@RequestBody ExpeditionBean exp);
	
    @PutMapping(value = "/microservice-expedition/Expeditions")
	public ResponseEntity<ExpeditionBean> majExpedition(@RequestBody ExpeditionBean exp);
	
	@GetMapping(value = "/microservice-expedition/Expeditions/{id}")
	public ExpeditionBean reccupererExpeditionParId(@PathVariable int id);
}
