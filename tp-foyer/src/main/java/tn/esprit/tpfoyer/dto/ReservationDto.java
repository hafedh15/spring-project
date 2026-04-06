package tn.esprit.tpfoyer.dto;

import lombok.Data;

@Data
public class ReservationDto {

    private String idReservation;
    private String anneUniversitaire;
    private Boolean estValide;
}