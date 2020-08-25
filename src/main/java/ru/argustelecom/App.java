package ru.argustelecom;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import ru.argustelecom.soap.NodeSoapService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String soapServiceUrl = "http://localhost:8080/soap/NodeSoapService";

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(NodeSoapService.class);
        factoryBean.setAddress(soapServiceUrl);

        NodeSoapService nodeSoapService = (NodeSoapService) factoryBean.create();

        String result = nodeSoapService.testService()+" "
                +nodeSoapService.sayHelloTo("argus");

        System.out.println("Result: " + result);
    }
}
