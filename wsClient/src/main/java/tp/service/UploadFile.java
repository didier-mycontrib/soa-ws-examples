
package tp.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uploadFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uploadFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileToUpload" type="{http://service.tp/}fileToUpload" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uploadFile", propOrder = {
    "fileToUpload"
})
public class UploadFile {

    protected FileToUpload fileToUpload;

    /**
     * Gets the value of the fileToUpload property.
     * 
     * @return
     *     possible object is
     *     {@link FileToUpload }
     *     
     */
    public FileToUpload getFileToUpload() {
        return fileToUpload;
    }

    /**
     * Sets the value of the fileToUpload property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileToUpload }
     *     
     */
    public void setFileToUpload(FileToUpload value) {
        this.fileToUpload = value;
    }

}
