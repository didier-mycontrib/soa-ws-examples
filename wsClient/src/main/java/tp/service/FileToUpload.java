
package tp.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fileToUpload complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fileToUpload">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileDataHandler" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="fileName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fileToUpload", propOrder = {
    "fileDataHandler",
    "fileName"
})
public class FileToUpload {

    protected byte[] fileDataHandler;
    protected String fileName;

    /**
     * Gets the value of the fileDataHandler property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileDataHandler() {
        return fileDataHandler;
    }

    /**
     * Sets the value of the fileDataHandler property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileDataHandler(byte[] value) {
        this.fileDataHandler = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

}
