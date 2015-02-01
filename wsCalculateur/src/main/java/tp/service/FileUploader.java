package tp.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.data.FileToUpload;

@WebService
public interface FileUploader {
	
	void uploadFile(@WebParam(name="fileToUpload") FileToUpload fileToUpdload);

}
