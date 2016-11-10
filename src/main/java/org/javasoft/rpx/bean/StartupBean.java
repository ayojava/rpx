/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.javasoft.rpx.model.Country;
import static org.javasoft.rpx.rest.RestURL.COUNTRIES_URL;
import org.omnifaces.cdi.Eager;

/**
 *
 * @author ayojava
 */
//@Slf4j
//@Eager
@Named("startUpBean")
@ApplicationScoped
public class StartupBean {

    @Getter
    private List<Country> allCountries;
    
    private Country aCountry;

    @Inject
    private ServletContext context;

    @PostConstruct
    public void init() {
        //log.info("Real Path ::: {} ", context.getRealPath("/"));
        System.out.println("real Path ::: " + context.getRealPath("/"));
        //loadCountries();
    }

    public void loadCountries_() {
        try {
            Client client = ClientBuilder.newClient();
            allCountries = client.target(COUNTRIES_URL).path("all").
                    request(MediaType.APPLICATION_JSON).get(new GenericType<List<Country>>() {
            });
        } catch (Exception ex) {
            System.out.println("Exception ::: " + ex);
            allCountries = new ArrayList<>();
        }
    }
    
    public void loadCountries() {
        allCountries = new ArrayList<>();
        
        aCountry = new Country("Afghanistan", "AF", "AFG", "Kabul", "Asia", "Southern Asia", 26023100, "Afghan");
        allCountries.add(aCountry);
        aCountry = new Country("Åland Islands", "AX", "ALA", "Mariehamn", "Europe", "Southern Europe", 28875, "Ålandish");
        allCountries.add(aCountry);
        aCountry = new Country("American Samoa", "AS", "ASM", "Pago Pago", "Oceania", "Polynesia", 55519, "American Samoan");
        allCountries.add(aCountry);
        aCountry = new Country("Andorra", "AD", "AND", "Andorra la Vella", "Europe", "Southern Europe", 76949, "Andorran");
        allCountries.add(aCountry);
        aCountry = new Country("Angola", "AO", "AGO", "Luanda", "Africa", "Southern Africa", 24383301, "Angolan");  
        allCountries.add(aCountry);
        aCountry = new Country("Anguilla", "AI", "AIA", "The Valley", "Americas", "Caribbean", 76949, "Anguillian");
        allCountries.add(aCountry);
        aCountry = new Country("Antarctica", "AQ", "ATA", "", "Polar", "", 1000, "");
        allCountries.add(aCountry);
        aCountry = new Country("Antigua and Barbuda", "AG", "ATG", "Saint John's", "Americas", "Caribbean", 86295, "Antiguan, Barbudan");
        allCountries.add(aCountry);
        
        
        aCountry = new Country("Belarus", "BY", "BLR", "Minsk", "Europe", "Eastern Europe", 9485300, "Belarusian");
        allCountries.add(aCountry);
        aCountry = new Country("Belgium", "BE", "BEL", "Brussels", "Europe", "Eastern Europe", 11248330, "Belarusian");
        allCountries.add(aCountry);
                
        aCountry = new Country("Botswana", "BW", "BWA", "Gaborone", "Africa", "Eastern Africa", 2070984, "Motswana");
        allCountries.add(aCountry);
        aCountry = new Country("United States Minor Outlying Islands", "UM", "UMI", "", "Americas", "Eastern Americas", 300, "American");
        allCountries.add(aCountry);
        aCountry = new Country("Virgin Islands (British)", "VG", "VGB", "Road Town", "Americas", "Caribbean", 28054, "Virgin Islander");
        allCountries.add(aCountry);
        
        aCountry = new Country("Brunei", "BN", "BRN", "Bandar Seri Begawan", "Asia", "South-Eastern Asia", 393372, "Bruneian");
        allCountries.add(aCountry);
        aCountry = new Country("Bulgaria", "BG", "BGR", "Sofia", "Europe", "Eastern Europe", 7202198, "Bulgarian");
        allCountries.add(aCountry);
        
        
        aCountry = new Country("Vanuatu", "VU", "VUT", "Port Vila", "Oceania", "Melanesia", 264652, "Ni-Vanuatu");
        allCountries.add(aCountry);
        
        aCountry = new Country("Venezuela", "VE", "VEN", "Caracas", "Americas", "Eastern Americas", 30620404, "Venezuelan");
        allCountries.add(aCountry);
        aCountry = new Country("Portugal", "PT", "PRT", "Lisbon", "Europe", "Southern Europe", 10374822, "Portuguese");
        allCountries.add(aCountry);
        aCountry = new Country("Niger", "NE", "NER", "Niamey", "Africa", "Western Africa", 19899000, "Nigerien");
        allCountries.add(aCountry);
        aCountry = new Country("Mongolia", "MN", "MNG", "Ulan Bator", "Asia", "Eastern Asia", 3031099, "Mongolian");
        allCountries.add(aCountry);
    }
}
