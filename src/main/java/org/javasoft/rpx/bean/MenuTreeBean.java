/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javasoft.rpx.bean;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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

    @Getter
    @Setter
    private TreeNode root, selectedNode;

    private FacesContext facesContext;

    private ResourceBundle bundle;

    @PostConstruct
    public void init() {
        initMsgBundle();
        root = new DefaultTreeNode("root", null);

        TreeNode applications = new DefaultTreeNode("folder", bundle.getString("tree.applications"), root);

        TreeNode primefacesApp = new DefaultTreeNode("primefaces", bundle.getString("tree.primefaces"), applications);
        TreeNode richfacesApp = new DefaultTreeNode("richfaces", bundle.getString("tree.richfaces"), applications);
        TreeNode liferayApp = new DefaultTreeNode("liferay", bundle.getString("tree.liferay"), applications);

        TreeNode webServices = new DefaultTreeNode("webservices",bundle.getString("tree.webServices"), root);

        TreeNode jbi = new DefaultTreeNode("folder", bundle.getString("tree.jbi"), root);
        TreeNode jax = new DefaultTreeNode("xml", bundle.getString("tree.jax"), jbi);
        TreeNode stax = new DefaultTreeNode("xml", bundle.getString("tree.stax"), jbi);

        TreeNode customMBeans = new DefaultTreeNode("mbeans", bundle.getString("tree.customMbeans"), root);

        TreeNode resources = new DefaultTreeNode("resources", bundle.getString("tree.resources"), root);

        TreeNode jdbc = new DefaultTreeNode("database",  bundle.getString("tree.jdbc"), resources);

        TreeNode mySql = new DefaultTreeNode("settings",  bundle.getString("tree.mysql"), jdbc);
        TreeNode h2 = new DefaultTreeNode("settings",  bundle.getString("tree.h2"), jdbc);
        TreeNode PostGRE = new DefaultTreeNode("settings",  bundle.getString("tree.postGre"), jdbc);

        TreeNode jmsResources = new DefaultTreeNode("square-arrow", bundle.getString("tree.jmsResources"), resources);
        TreeNode internal = new DefaultTreeNode("settings", bundle.getString("tree.internal"), jmsResources);
        TreeNode external = new DefaultTreeNode("settings", bundle.getString("tree.external"), jmsResources);

        TreeNode javaMailSessions = new DefaultTreeNode("email", bundle.getString("tree.javaMailSessions"), resources);

        TreeNode jndi = new DefaultTreeNode("jndi", bundle.getString("tree.jndi"), resources);
        TreeNode localJNDI = new DefaultTreeNode("settings", bundle.getString("tree.localJNDI"), jndi);
        TreeNode remoteJNDI = new DefaultTreeNode("settings", bundle.getString("tree.remoteJNDI"), jndi);

        TreeNode connectors = new DefaultTreeNode("connector",bundle.getString("tree.connectors"), resources);
        TreeNode dataConnectors = new DefaultTreeNode("settings",bundle.getString("tree.dataConnectors"), connectors);
        TreeNode webConnectors = new DefaultTreeNode("settings",bundle.getString("tree.webConnectors"), connectors);
        TreeNode logicConnectors = new DefaultTreeNode("settings", bundle.getString("tree.logicConnectors"), connectors);

        TreeNode clusters = new DefaultTreeNode("cluster", bundle.getString("tree.clusters"), resources);

        TreeNode standAloneInstances = new DefaultTreeNode("standalone",  bundle.getString("tree.standAloneInstances"), root);
        TreeNode instance1 = new DefaultTreeNode("settings",  bundle.getString("tree.instance1"), standAloneInstances);
        TreeNode instance2 = new DefaultTreeNode("settings", bundle.getString("tree.instance2"), standAloneInstances);
        TreeNode instance3 = new DefaultTreeNode("settings",  bundle.getString("tree.instance3"), standAloneInstances);

        TreeNode httpLoadBalancers = new DefaultTreeNode("balance", bundle.getString("tree.httpLoadBalancers"), root);

        TreeNode nodeAgents = new DefaultTreeNode("agents", bundle.getString("tree.nodeAgents"), root);

        TreeNode configurations = new DefaultTreeNode(bundle.getString("tree.configurations"), root);

        TreeNode defaultConfig = new DefaultTreeNode(bundle.getString("tree.defaultConfig"), configurations);

        TreeNode jvmSettings = new DefaultTreeNode("settings", bundle.getString("tree.jvmSettings"), defaultConfig);
        TreeNode loggerSettings = new DefaultTreeNode("settings",bundle.getString("tree.loggerSettings"), defaultConfig);
        TreeNode webContainer = new DefaultTreeNode("settings", bundle.getString("tree.webContainer"), defaultConfig);
        TreeNode ejbContainer = new DefaultTreeNode("settings", bundle.getString("tree.ejbContainer"), defaultConfig);

    }

    void initMsgBundle() {
        facesContext = FacesContext.getCurrentInstance();
        Locale locale = facesContext.getViewRoot().getLocale();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String baseName = "org.javasoft.rpx.resource.rpxMsg";
        bundle = ResourceBundle.getBundle(baseName, locale, loader);
    }

    public void onNodeSelect(NodeSelectEvent event) {

        try {
            Client client = ClientBuilder.newClient();
            Response response = client.target(DUMMY_URL).path("response").request(MediaType.APPLICATION_JSON).get();
            System.out.println("Response Code ::: " + response.getStatus());
            if (Response.Status.OK.getStatusCode() == response.getStatus()) {
                Messages.addGlobalInfo("Response [ " + response.getStatus() + " ]\n from  [ " + DUMMY_URL + "response " + " ]\n");
            }
            response.close();
        } catch (Exception ex) {
            Messages.addGlobalError("An Error Has occured");
            System.out.println("Error :::: " + ex);
        }
    }

}
