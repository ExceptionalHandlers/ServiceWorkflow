
package edu.memphis.ehands;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.memphis.ehands package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Validate_QNAME = new QName("http://ehands.memphis.edu/", "validate");
    private final static QName _ValidateResponse_QNAME = new QName("http://ehands.memphis.edu/", "validateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.memphis.ehands
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidateResponse }
     * 
     */
    public ValidateResponse createValidateResponse() {
        return new ValidateResponse();
    }

    /**
     * Create an instance of {@link Validate }
     * 
     */
    public Validate createValidate() {
        return new Validate();
    }

    /**
     * Create an instance of {@link Matrix }
     * 
     */
    public Matrix createMatrix() {
        return new Matrix();
    }

    /**
     * Create an instance of {@link DoubleArray }
     * 
     */
    public DoubleArray createDoubleArray() {
        return new DoubleArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Validate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ehands.memphis.edu/", name = "validate")
    public JAXBElement<Validate> createValidate(Validate value) {
        return new JAXBElement<Validate>(_Validate_QNAME, Validate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ehands.memphis.edu/", name = "validateResponse")
    public JAXBElement<ValidateResponse> createValidateResponse(ValidateResponse value) {
        return new JAXBElement<ValidateResponse>(_ValidateResponse_QNAME, ValidateResponse.class, null, value);
    }

}
