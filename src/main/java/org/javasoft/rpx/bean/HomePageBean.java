/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import static org.javasoft.rpx.model.Constants.PASSED;
import static org.javasoft.rpx.model.Constants.RUNNING;
import static org.javasoft.rpx.model.Constants.STOPPED;
import static org.javasoft.rpx.model.Constants.UNSTABLE;
import org.javasoft.rpx.model.Country;
import org.javasoft.rpx.model.StatusIntf;
import org.javasoft.rpx.model.TransferDTO;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ayojava
 */
@Slf4j
@Named("homePageBean")
@SessionScoped
public class HomePageBean implements Serializable {

    @Inject
    private StartupBean startUpBean;
    
    @Getter
    private List<TransferDTO> transferDTO;
    
    @Getter @Setter
    private List<TransferDTO> selectTransferDTOs;
    
    @Getter @Setter
    private TransferDTO selectedTransferDTO;

    @Getter @Setter
    private Country selectedCountry;

    @Getter @Setter
    private boolean displayTab;

    @Getter @Setter
    private String borders, altSpellings , firstName , lastName;
    
    private int selection;

    @PostConstruct
    public void init() {
        loadTable();
        displayTab = false;
        firstName ="xxxx";
        lastName ="yyyy";
        selection= 0;
        selectTransferDTOs = new ArrayList<>();
    }
    
    private void loadTable() {
        startUpBean.loadTransferDTO();
        transferDTO = startUpBean.getTransferDTOs();
    }

    public void onRowSelect(SelectEvent event) {
        selection++;
        System.out.println("Selection After onRowSelect ::: " + selection);
        displayTab =(selection == 1)? true :false;
        
    }

    public void onRowUnSelect(SelectEvent event) {
        selection--;
        System.out.println("Selection After onRowUnSelect ::: " + selection);
        if(selection == 1){
            displayTab = true;
        }
    }
    
    public void onToggleSelect(SelectEvent event) {
        selection = selectTransferDTOs.size();
        System.out.println("Selection After onToggleSelect ::: " + selection);
        displayTab =false;
    }
    
    public void viewSelection(TransferDTO domain){    
        selectedTransferDTO = domain;
        displayTab = true;
    }
    
    public String abbreviate(String value){
        return StringUtils.abbreviate(value, 15);
    }
    public String iconColor(String type){
        StatusIntf intf = (s) -> {
            if( StringUtils.equalsIgnoreCase(s, RUNNING) || StringUtils.equalsIgnoreCase(s, PASSED)){
                return "color: #00FF00";
            }else if(StringUtils.equalsIgnoreCase(s, UNSTABLE)){
                return "color: #FFA500";
            }else if(StringUtils.equalsIgnoreCase(s, STOPPED)){
                return "color: #FF0000";
            }
            return "";
        };
        return intf.statusCheck(type);
    }
    
    
}
