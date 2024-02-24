package org.example.businessquant.repositories;

import org.example.businessquant.models.CompanyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompanyDataRepository extends JpaRepository<CompanyData , Long> {


    @Query("select c from CompanyData c where c.ticker = ?1 and (c.dates >= ?2 and c.dates <= ?3)" )
    List<CompanyData> findAllByTickerAndDatesBetween(String ticker , LocalDate sdate , LocalDate ndate );


}
