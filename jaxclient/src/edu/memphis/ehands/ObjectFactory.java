
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

    private final static QName _CalculateDetResponse_QNAME = new QName("http://ehands.memphis.edu/", "calculateDetResponse");
    private final static QName _CalculateDet_QNAME = new QName("http://ehands.memphis.edu/", "calculateDet");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.memphis.ehands
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoubleArray }
     * 
     */
    public DoubleArray createDoubleArray() {
        return new DoubleArray();
    }

    /**
     * Create an instance of {@link CalculateDet }
     * 
     */
    public CalculateDet createCalculateDet() {
        return new CalculateDet();
    }

    /**
     * Create an instance of {@link CalculateDetResponse }
     * 
     */
    public CalculateDetResponse createCalculateDetResponse() {
        return new CalculateDetResponse();
    }

    /**
     * Create an instance of {@link DecomposedMatrix }
     * 
     */
    public DecomposedMatrix createDecomposedMatrix() {
        return new DecomposedMatrix();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDetResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ehands.memphis.edu/", name = "calculateDetResponse")
    public JAXBElement<CalculateDetResponse> createCalculateDetResponse(CalculateDetResponse value) {
        return new JAXBElement<CalculateDetResponse>(_CalculateDetResponse_QNAME, CalculateDetResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateDet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ehands.memphis.edu/", name = "calculateDet")
    public JAXBElement<CalculateDet> createCalculateDet(CalculateDet value) {
        return new JAXBElement<CalculateDet>(_CalculateDet_QNAME, CalculateDet.class, null, value);
    }

}
