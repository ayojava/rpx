/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import static org.javasoft.rpx.rest.RestURL.DUMMY_URL;
import org.omnifaces.util.Messages;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author ayojava
 */
@Slf4j
@Named("menuTreeBean")
@ViewScoped
public class MenuTreeBean implements Serializable {
    
    @Getter @Setter
    private TreeNode root,selectedNode;
        
    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("root", null);
        
        TreeNode applications = new DefaultTreeNode("folder","Applications", root);
        
        TreeNode primefacesApp = new DefaultTreeNode("primefaces","Primefaces", applications);
        TreeNode richfacesApp = new DefaultTreeNode("richfaces","Richfaces", applications);
        TreeNode liferayApp = new DefaultTreeNode("liferay","Liferay", applications);
        
        TreeNode webServices = new DefaultTreeNode("webservices","Web Services", root);
        
        TreeNode jbi = new DefaultTreeNode("folder","JBI", root);
        TreeNode jax = new DefaultTreeNode("xml","JAX", jbi);
        TreeNode stax = new DefaultTreeNode("xml","STAX", jbi);
        
        TreeNode customMBeans = new DefaultTreeNode("mbeans","Custom MBeans", root);
        
        TreeNode resources = new DefaultTreeNode("resources","Resources", root);
        
        TreeNode jdbc = new DefaultTreeNode("database","JDBC", resources);
        
        TreeNode mySql = new DefaultTreeNode("settings","MySQL", jdbc);
        TreeNode h2 = new DefaultTreeNode("settings","H2", jdbc);
        TreeNode PostGRE = new DefaultTreeNode("settings","PostGre", jdbc);
        
        
        TreeNode jmsResources = new DefaultTreeNode("square-arrow","JMS Resources", resources);
        TreeNode internal = new DefaultTreeNode("settings","Internal", jmsResources);
        TreeNode external = new DefaultTreeNode("settings","External", jmsResources);
        
        TreeNode javaMailSessions = new DefaultTreeNode("email","JavaMail Sessions", resources);
        
        
        TreeNode jndi = new DefaultTreeNode("jndi","JNDI", resources);
        TreeNode localJNDI = new DefaultTreeNode("settings","Local JNDI", jndi);
        TreeNode remoteJNDI = new DefaultTreeNode("settings","Remote JNDI", jndi);
        
        TreeNode connectors = new DefaultTreeNode("connector","Connectors", resources);
        TreeNode dataConnectors = new DefaultTreeNode("settings","Data Connectors", connectors);
        TreeNode webConnectors = new DefaultTreeNode("settings","Web Connectors", connectors);
        TreeNode logicConnectors = new DefaultTreeNode("settings","Logic Connectors", connectors);
        
        TreeNode clusters = new DefaultTreeNode("cluster","Clusters", resources);
        
        
        TreeNode standAloneInstances = new DefaultTreeNode("standalone","Stand Alone Instances", root);
        TreeNode instance1 = new DefaultTreeNode("settings","Instance 1", standAloneInstances);
        TreeNode instance2 = new DefaultTreeNode("settings","Instance 2", standAloneInstances);
        TreeNode instance3 = new DefaultTreeNode("settings","Instance 3", standAloneInstances);
        
        TreeNode httpLoadBalancers = new DefaultTreeNode("balance","Http Load Balancers", root);
        
        TreeNode nodeAgents = new DefaultTreeNode("agents","Node Agents", root);
        
        TreeNode configurations = new DefaultTreeNode("Configurations", root);
        
        TreeNode defaultConfig = new DefaultTreeNode("Default Config", configurations);
        
        TreeNode jvmSettings = new DefaultTreeNode("settings", "JVM Settings",defaultConfig);
        TreeNode loggerSettings = new DefaultTreeNode("settings", "Logger Settings",defaultConfig);
        TreeNode webContainer = new DefaultTreeNode("settings", "Web Container",defaultConfig);
        TreeNode ejbContainer = new DefaultTreeNode("settings", "EJB Container",defaultConfig);
                
    }
    
    public void onNodeSelect(NodeSelectEvent event) {
        System.out.println("::: Node Selected Method :::");
        try{
            Client client = ClientBuilder.newClient();
            Response response =client.target(DUMMY_URL).path("response").request(MediaType.APPLICATION_JSON).get();
            System.out.println("Response Code ::: " +response.getStatus());
            if (Response.Status.OK.getStatusCode() == response.getStatus()) {
                Messages.addGlobalInfo("Response [ "+ response.getStatus() +" ]\n from  [ " + DUMMY_URL + "response " + " ]\n");
            }
            response.close();
        }catch(Exception ex){
            Messages.addGlobalError("An Error Has occured");
            System.out.println("Error :::: " + ex);
        }
    }
    
    
    
}
