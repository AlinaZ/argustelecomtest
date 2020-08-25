package ru.argustelecom.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "NodeSoapService", serviceName = "NodeSoapService",
        portName = "NodeSoapServicePort",
        targetNamespace = "http://account.swhp.id")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class NodeSoapService {

    @WebMethod
    public String testService() {
        return "Hello from SOAP Webservice!";
    }
    
    @WebMethod
    public String sayHelloTo(@WebParam(name = "text") String text) {
        return "Hello to " + text;
    }
}
