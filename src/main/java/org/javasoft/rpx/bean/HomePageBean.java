/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.rpx.model.Country;
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
    @Setter
    private Country selectedCountry;

    @Getter
    @Setter
    private boolean displayTab;

    @Getter
    private String borders, altSpellings;

    @PostConstruct
    public void init() {
        loadTable();
        displayTab = false;
    }

    private void loadTable() {
        startUpBean.loadCountries();
        if (startUpBean.getAllCountries().isEmpty()) {
            allCountries = startUpBean.getAllCountries();
        } else {
            allCountries = startUpBean.getAllCountries().stream().limit(80).collect(toList());
        }
    }

    public void onRowSelect(SelectEvent event) {
        
        System.out.println("=== Country ==== " + ((Country) event.getObject()).getName());
        selectedCountry = (Country) event.getObject();
        displayTab = true;
       // borders = Arrays.stream(selectedCountry.getBorders()).collect(joining(", "));
        //altSpellings = Arrays.stream(selectedCountry.getAltSpellings()).collect(joining(", "));

    }

    public void onRowUnSelect(SelectEvent event) {
        log.info("=== Country ==== {} ", ((Country) event.getObject()).getName());
    }
}
