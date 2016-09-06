package com.exastax.ws.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/services/*");
    }

    @Bean(name = "poiservice")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema poiSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setTargetNamespace(environment.getProperty("namespaceUri"));
        wsdl11Definition.setSchema(poiSchema);
        wsdl11Definition.setLocationUri("/services/");
        wsdl11Definition.setPortTypeName("poiservice");
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema poiSchema() {
        return new SimpleXsdSchema(new ClassPathResource("poiservice.xsd"));
    }
}
