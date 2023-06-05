package org.apache.camel.example.mention;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.apache.camel.impl.DefaultCamelContext;

public class SalesforceCamelIntegrationExample {

/*    public static void main(String[] args) throws Exception {
        // Create Camel context
        CamelContext context = new DefaultCamelContext();

        // Configure Salesforce component
       *//* SalesforceComponent salesforce = new SalesforceComponent();
        salesforce.setClientId("3MVG9wt4IL4O5wvKO.hNSPJbTOlzZ5fKQb0N_t1RSAzVRInBYPSDfauztVqPqINMMqHKCxiGpuFmfzoMo_F_X");
        salesforce.setClientSecret("B5019C05A31DA04788D0BBCA23FA125E1E92A89BE4F78D014EF07C6A7845DB49");
        salesforce.setUserName("ramya88ranjan-drn6@force.com");
        salesforce.setPassword("Hari4905");*//*

          SalesforceComponent salesforce = new SalesforceComponent();
        salesforce.setClientId("3MVG9wt4IL4O5wvKJ8IE.qlGdRKXNW7YgarMdD7_QzwmHRT5oVRdTvWmNzDxp9Um.GRXmxyZYGPqLsI67BfNZ");
        salesforce.setClientSecret("75C4DD50C959B3201DD014350B7D2BDFCBBAE0E31E0547F26C029051B8FC1777");
        salesforce.setUserName("abinas88rout@gmail.com");
        salesforce.setPassword("Hari4905");

        // Add Salesforce component to Camel context
        context.addComponent("salesforce", salesforce);

       // Define Camel routes
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // Route from Salesforce to some other endpoint
                getContext().getComponent("salesforce", SalesforceComponent.class)
                        .setLoginUrl("https://login.salesforce.com");
               *//* from("timer:myTimer?period=500")
                        .setBody(constant("Hello, Camel!"))
                        .to("stream:out");*//*
               *//* from("direct:queryContacts")
                        .setHeader("sObjectName", constant("Contact"))
                        .setHeader("sObjectQuery", constant("SELECT Id, Name, Email FROM Contact"))
                        .to("salesforce:query?sObjectQuery=${header.sObjectQuery}")
                        .log("Queried Salesforce contacts: ${body}");*//*
               from("direct:addContact")
                        .setHeader("sObjectName", constant("Contact"))
                        .setHeader("sObjectFields", constant("FirstName, LastName, Email"))
                        .setBody(simple("{\"FirstName\":\"John\", \"LastName\":\"Doe\", \"Email\":\"john.doe@example.com\"}"))
                        .to("salesforce:createSObject")
                        .log("Added Salesforce contact with Id: ${body.Id}");

            }



        });

        // Start Camel context
        context.start();

        // Keep the application running for some time
        Thread.sleep(50);


        // Define Camel routes
       *//* context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                getContext().getComponent("salesforce", SalesforceComponent.class)
                        .setLoginUrl("https://login.salesforce.com");
                from("direct:addContact")
                        .to("salesforce:createSObject?sObjectName=Contact")
                        .log("Added Salesforce contact with Id: ${body.Id}");
            }
        });

        // Start Camel context
        context.start();
        System.out.println("Camel context started. Press Ctrl+C to terminate.");

        // Add a contact
        ProducerTemplate template = context.createProducerTemplate();
        Map<String, Object> contact = new HashMap<>();
        contact.put("FirstName", "John");
        contact.put("LastName", "Doe");
        //contact.put("Email", "johndoe@example.com");
        template.sendBody("direct:addContact", contact);

        // Wait for a few seconds to allow the record to be created
        Thread.sleep(5000);

        // Stop Camel context
        context.stop();
*//*
        // Stop Camel context
        context.stop();
    }*/


    public static void main(String[] args) throws Exception {
        // Create Camel context
        CamelContext context = new DefaultCamelContext();

        // Add Salesforce component to the Camel context
        SalesforceComponent salesforceComponent = new SalesforceComponent();
        salesforceComponent.setLoginConfig(getLoginConfig());
        context.addComponent("salesforce", salesforceComponent);

        // Define the Camel routes
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:addContact")
                        .setHeader("sObjectName", constant("Contact"))
                        .setBody(simple("{\"FirstName\":\"Johnae\", \"LastName\":\"Doee\", \"Email\":\"johna.doe@example.com\"}"))
                        .to("salesforce:createSObject")
                        .log("Added Salesforce contact with Id: ${body.id}");
            }
        });

        // Start the Camel context
        context.start();

        // Trigger the route by sending a message to the direct:addContact endpoint
        context.createProducerTemplate().sendBody("direct:addContact", null);

        // Wait for some time to see the logs
        Thread.sleep(5000);

        // Stop the Camel context
        context.stop();
    }

    private static SalesforceLoginConfig getLoginConfig() {
        SalesforceLoginConfig loginConfig = new SalesforceLoginConfig();
        loginConfig.setClientId("3MVG9wt4IL4O5wvKJ8IE.qlGdRKXNW7YgarMdD7_QzwmHRT5oVRdTvWmNzDxp9Um.GRXmxyZYGPqLsI67BfNZ");
        loginConfig.setClientSecret("75C4DD50C959B3201DD014350B7D2BDFCBBAE0E31E0547F26C029051B8FC1777");
        loginConfig.setUserName("abinas88rout@gmail.com");
        loginConfig.setPassword("Hari4905");
        return loginConfig;
    }
}
