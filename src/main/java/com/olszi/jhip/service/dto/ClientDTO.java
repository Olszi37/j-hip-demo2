package com.olszi.jhip.service.dto;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class ClientDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private String fullName;

    @NotBlank
    private String phoneNumber;

    @Email
    @NotBlank
    private String email;
}
