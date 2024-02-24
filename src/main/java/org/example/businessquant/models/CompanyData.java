package org.example.businessquant.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "companydata", indexes = {
        @Index(name = "idx_companydata_ticker", columnList = "ticker")
})
public class CompanyData {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "dates")
    private LocalDate dates;

    @Column(name = "revenue")
    private String revenue;

    @Column(name = "gp")
    private String gp;

    @Column(name = "fcf")
    private String fcf;

    @Column(name = "capex")
    private String capex;

}