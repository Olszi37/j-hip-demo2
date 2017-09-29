package com.olszi.jhip.service.impl;

import com.olszi.jhip.service.ReservationService;
import com.olszi.jhip.domain.Reservation;
import com.olszi.jhip.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Reservation.
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

    private final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * Save a reservation.
     *
     * @param reservation the entity to save
     * @return the persisted entity
     */
    @Override
    public Reservation save(Reservation reservation) {
        log.debug("Request to save Reservation : {}", reservation);
        return reservationRepository.save(reservation);
    }

    /**
     *  Get all the reservations.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Reservation> findAll(Pageable pageable) {
        log.debug("Request to get all Reservations");
        return reservationRepository.findAll(pageable);
    }

    /**
     *  Get one reservation by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Reservation findOne(Long id) {
        log.debug("Request to get Reservation : {}", id);
        return reservationRepository.findOne(id);
    }

    /**
     *  Delete the  reservation by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reservation : {}", id);
        reservationRepository.delete(id);
    }
}
