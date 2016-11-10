/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.rpx.model.Country;
import org.javasoft.rpx.model.TransferDTO;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ayojava
 */
@Slf4j
@Named("homePageBean")
@ViewScoped
public class HomePageBean implements Serializable {

    @Inject
    private StartupBean startUpBean;

    @Getter
    private List<Country> allCountries;
    
    @Getter
    private List<TransferDTO> transferDTO;
    
    @Getter @Setter
    private TransferDTO selectedTransferDTO;

    @Getter @Setter
    private Country selectedCountry;

    @Getter @Setter
    private boolean displayTab;

    @Getter @Setter
    private String borders, altSpellings , firstName , lastName;

    @PostConstruct
    public void init() {
        loadTable();
        displayTab = false;
        firstName ="xxxx";
        lastName ="yyyy";
    }

    private void loadTable_() {
        startUpBean.loadCountries();
        if (startUpBean.getAllCountries().isEmpty()) {
            allCountries = startUpBean.getAllCountries();
        } else {
            allCountries = startUpBean.getAllCountries().stream().limit(80).collect(toList());
        }
    }
    
    private void loadTable() {
        transferDTO = new ArrayList<>();
    }

    public void onRowSelect(SelectEvent event) {
        
//        System.out.println("=== Country ==== " + ((Country) event.getObject()).getName());
//        selectedCountry = (Country) event.getObject();
//        displayTab = true;
       // borders = Arrays.stream(selectedCountry.getBorders()).collect(joining(", "));
        //altSpellings = Arrays.stream(selectedCountry.getAltSpellings()).collect(joining(", "));

    }

    public void onRowUnSelect(SelectEvent event) {
        log.info("=== Country ==== {} ", ((Country) event.getObject()).getName());
    }
    
    public void viewSelection(TransferDTO domain){
        selectedTransferDTO = domain;
    }
}
