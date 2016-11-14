/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.model;

import java.io.Serializable;
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
public class TransferDTO implements Serializable{
    
    private Long id;
    
    private String name;
    
    private String instanceID ;
    
    private String instanceType;
    
    private String availabilityZone;
    
    private String instanceState;
    
    private String statusChecks;
    
    private String alarmStatus;
    
    private String publicDNS;
    
    private String publicIP;
    
    private String privateIPs;
    
    private String privateDNS;
    
    private String secondaryprivateIPs;
    
    private String vpcID;
    
    private String subnetID;
    
    private String networkInterfaces;
    
    private String srcDestChecks;
    
    private String ebsOptimized;
    
    private String rootDeviceType;
    
    private String rootDevice;
    
    private String blockDevices;
    
    private String elasticIPs;
    
    private String scheduledEvents;
    
    private String amiID;
    
    private String platform;
    
    private String keyPairName;
    
    private String launchTime;
    
    private String terminationProtection;
    
    private String lifecycle;
    
    private String monitoring;
    
    private String securityGroups;
    
    private String iamRole;
    
    private String owner;
    
    
    
    
}
