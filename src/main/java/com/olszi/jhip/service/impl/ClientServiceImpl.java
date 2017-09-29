package com.olszi.jhip.service.impl;

import com.olszi.jhip.service.ClientService;
import com.olszi.jhip.domain.Client;
import com.olszi.jhip.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Client.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    private final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Save a client.
     *
     * @param client the entity to save
     * @return the persisted entity
     */
    @Override
    public Client save(Client client) {
        log.debug("Request to save Client : {}", client);
        return clientRepository.save(client);
    }

    /**
     *  Get all the clients.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Client> findAll(Pageable pageable) {
        log.debug("Request to get all Clients");
        return clientRepository.findAll(pageable);
    }

    /**
     *  Get one client by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Client findOne(Long id) {
        log.debug("Request to get Client : {}", id);
        return clientRepository.findOne(id);
    }

    /**
     *  Delete the  client by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Client : {}", id);
        clientRepository.delete(id);
    }
}
