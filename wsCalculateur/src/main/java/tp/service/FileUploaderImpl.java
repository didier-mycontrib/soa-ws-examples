package tp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

import tp.data.FileToUpload;

@WebService(endpointInterface="tp.service.FileUploader")
public class FileUploaderImpl implements FileUploader {
	
	private String uploadDir = "/tmp/upload/";

	@Override
	public void uploadFile(FileToUpload fileToUpdload) {
		DataHandler handler = fileToUpdload.getFileDataHandler();
		try {
		    InputStream is = handler.getInputStream();

		    OutputStream os = new FileOutputStream(new File(uploadDir
			    + fileToUpdload.getFileName()));
		    byte[] b = new byte[100000];
		    int bytesRead = 0;
		    while ((bytesRead = is.read(b)) != -1) {
			os.write(b, 0, bytesRead);
		    }
		    os.flush();
		    os.close();
		    is.close();

		} catch (IOException e) {
		    e.printStackTrace();
		}


	}

}
