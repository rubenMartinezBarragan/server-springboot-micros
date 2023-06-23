package com.ccsw.tutorialclient.client;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorialclient.client.model.Client;

/**
 * @author ruben martinez barragan
 *
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

}