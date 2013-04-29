
package edu.memphis.ehands;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for decomposedMatrix complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="decomposedMatrix">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LU" type="{http://jaxb.dev.java.net/array}doubleArray" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="m" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="n" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pivsign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "decomposedMatrix", propOrder = {
    "lu",
    "m",
    "n",
    "pivsign"
})
public class DecomposedMatrix {

    @XmlElement(name = "LU", nillable = true)
    protected List<DoubleArray> lu;
    protected int m;
    protected int n;
    protected int pivsign;

    /**
     * Gets the value of the lu property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lu property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLU().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DoubleArray }
     * 
     * 
     */
    public List<DoubleArray> getLU() {
        if (lu == null) {
            lu = new ArrayList<DoubleArray>();
        }
        return this.lu;
    }

    /**
     * Gets the value of the m property.
     * 
     */
    public int getM() {
        return m;
    }

    /**
     * Sets the value of the m property.
     * 
     */
    public void setM(int value) {
        this.m = value;
    }

    /**
     * Gets the value of the n property.
     * 
     */
    public int getN() {
        return n;
    }

    /**
     * Sets the value of the n property.
     * 
     */
    public void setN(int value) {
        this.n = value;
    }

    /**
     * Gets the value of the pivsign property.
     * 
     */
    public int getPivsign() {
        return pivsign;
    }

    /**
     * Sets the value of the pivsign property.
     * 
     */
    public void setPivsign(int value) {
        this.pivsign = value;
    }

}
