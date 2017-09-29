package com.olszi.jhip.service.dto;

import com.olszi.jhip.enums.BedTypes;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Data
public class RoomDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Integer capacity;

    @NotBlank
    private BedTypes bed;

    @NotBlank
    private String description;

    @NotBlank
    private BigDecimal price;
}
