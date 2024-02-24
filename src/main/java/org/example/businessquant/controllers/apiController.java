package org.example.businessquant.controllers;

import org.example.businessquant.dtos.apiResponseDto;
import org.example.businessquant.models.CompanyData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.businessquant.services.apiService ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/Api")
public class apiController {
   private apiService apiService ;
  // private apiResponseDto responseDto ;

   public apiController(apiService apiService){
       this.apiService = apiService ;
   }


    @GetMapping("/ticker={tikerName}&column={columnList}&period={timePeriod}")
    public List<apiResponseDto> getData(@PathVariable String tikerName ,
                                     @PathVariable HashSet<String> columnList ,
                                     @PathVariable Long timePeriod){
        List<CompanyData> companydata =
                apiService.getData(tikerName , timePeriod) ;

     List<apiResponseDto> responseDtos = new ArrayList<>();

        for(int i=0 ;i<companydata.size() ;i++){

            apiResponseDto dto = new apiResponseDto() ;

            CompanyData curr = companydata.get(i) ;

            dto.setTicker(curr.getTicker());
            dto.setDates(curr.getDates());

            if (columnList.contains("revenue")){
                dto.setRevenue(curr.getRevenue());
            }
            if(columnList.contains("gp")){
                dto.setGp(curr.getGp());
            }


            responseDtos.add(dto) ;
        }
        return responseDtos ;
    }




}
