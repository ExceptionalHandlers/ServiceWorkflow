
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
@WebService(name = "SquareMatrixValidator", targetNamespace = "http://ehands.memphis.edu/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SquareMatrixValidator {


    /**
     * 
     * @param arg0
     * @return
     *     returns edu.memphis.ehands.Matrix
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validate", targetNamespace = "http://ehands.memphis.edu/", className = "edu.memphis.ehands.Validate")
    @ResponseWrapper(localName = "validateResponse", targetNamespace = "http://ehands.memphis.edu/", className = "edu.memphis.ehands.ValidateResponse")
    @Action(input = "http://ehands.memphis.edu/SquareMatrixValidator/validateRequest", output = "http://ehands.memphis.edu/SquareMatrixValidator/validateResponse")
    public Matrix validate(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}