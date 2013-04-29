/**
 * SquareMatrixValidatorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.memphis.ehands.service1;

public class SquareMatrixValidatorServiceLocator extends org.apache.axis.client.Service implements
        SquareMatrixValidatorService {

    public SquareMatrixValidatorServiceLocator() {
    }


    public SquareMatrixValidatorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SquareMatrixValidatorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SquareMatrixValidator
    private java.lang.String SquareMatrixValidator_address = "http://localhost:8080/services/SquareMatrixValidator";

    public java.lang.String getSquareMatrixValidatorAddress() {
        return SquareMatrixValidator_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SquareMatrixValidatorWSDDServiceName = "SquareMatrixValidator";

    public java.lang.String getSquareMatrixValidatorWSDDServiceName() {
        return SquareMatrixValidatorWSDDServiceName;
    }

    public void setSquareMatrixValidatorWSDDServiceName(java.lang.String name) {
        SquareMatrixValidatorWSDDServiceName = name;
    }

    public SquareMatrixValidator_PortType getSquareMatrixValidator() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SquareMatrixValidator_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSquareMatrixValidator(endpoint);
    }

    public SquareMatrixValidator_PortType getSquareMatrixValidator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            SquareMatrixValidatorSoapBindingStub _stub = new SquareMatrixValidatorSoapBindingStub(portAddress, this);
            _stub.setPortName(getSquareMatrixValidatorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSquareMatrixValidatorEndpointAddress(java.lang.String address) {
        SquareMatrixValidator_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (SquareMatrixValidator_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                SquareMatrixValidatorSoapBindingStub _stub = new SquareMatrixValidatorSoapBindingStub(new java.net.URL(SquareMatrixValidator_address), this);
                _stub.setPortName(getSquareMatrixValidatorWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SquareMatrixValidator".equals(inputPortName)) {
            return getSquareMatrixValidator();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ehands.memphis.edu", "SquareMatrixValidatorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ehands.memphis.edu", "SquareMatrixValidator"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SquareMatrixValidator".equals(portName)) {
            setSquareMatrixValidatorEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
