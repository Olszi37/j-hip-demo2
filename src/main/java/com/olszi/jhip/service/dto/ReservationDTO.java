package com.olszi.jhip.service.dto;

import com.olszi.jhip.domain.Client;
import com.olszi.jhip.domain.Room;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.time.ZonedDateTime;

@Data
public class ReservationDTO {

    private Long id;

    @NotBlank
    private ZonedDateTime date_from;

    @NotBlank
    private ZonedDateTime date_to;

    @NotBlank
    private Client client;

    @NotBlank
    private Room room;
}
