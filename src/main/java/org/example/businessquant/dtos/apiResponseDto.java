package org.example.businessquant.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class apiResponseDto {
    private String ticker;
    private LocalDate dates;
    private String revenue;
    private String gp;

}
