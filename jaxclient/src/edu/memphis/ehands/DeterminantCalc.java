
package edu.memphis.ehands;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DeterminantCalc", targetNamespace = "http://ehands.memphis.edu/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DeterminantCalc {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "calculateDet", targetNamespace = "http://ehands.memphis.edu/", className = "edu.memphis.ehands.CalculateDet")
    @ResponseWrapper(localName = "calculateDetResponse", targetNamespace = "http://ehands.memphis.edu/", className = "edu.memphis.ehands.CalculateDetResponse")
    @Action(input = "http://ehands.memphis.edu/DeterminantCalc/calculateDetRequest", output = "http://ehands.memphis.edu/DeterminantCalc/calculateDetResponse")
    public double calculateDet(
        @WebParam(name = "arg0", targetNamespace = "")
        DecomposedMatrix arg0);

}
