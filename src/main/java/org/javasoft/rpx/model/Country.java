/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.model;

import java.io.Serializable;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ayojava
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    
    private String name ;
    
    private String[] topLevelDomain;
    
    private String alpha2Code;
    
    private String alpha3Code;
    
    private String[] callingCodes;
    
    private String capital;
    
    private String[] altSpellings;
    
    private String relevance;
    
    private String region;
    
    private String subregion;
    
    private Map<String, String> translations;
    
    private long population;
    
    private long[] latlng;
    
    private String demonym;
    
    private long area;
    
    private double gini;
    
    private String[] timezones;
    
    private String[] borders;
    
    private String nativeName;
    
    private String numericCode;
    
    private String[] currencies;
    
    private String[] languages;

    public Country(String name, String alpha2Code, String alpha3Code, String capital, String region, String subregion, 
            long population, String demonym) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.demonym = demonym;
    }
    
    
}

