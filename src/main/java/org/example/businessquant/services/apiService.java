package org.example.businessquant.services;

import org.example.businessquant.models.CompanyData;
import org.example.businessquant.repositories.CompanyDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class apiService {

    private CompanyDataRepository companyDataRepository;

    public apiService(CompanyDataRepository companyDataRepository){
        this.companyDataRepository = companyDataRepository ;
    }


    public List<CompanyData> getData(String ticker , Long time){

        List<CompanyData> companyData = companyDataRepository.findAllByTickerAndDatesBetween(ticker , LocalDate.now().minusYears(time) , LocalDate.now()) ;
        return companyData;
    }


}
