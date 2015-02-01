package client;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import tp.service.Calculateur;
import tp.service.CalculateurImplService;
import tp.service.FileToUpload;
import tp.service.FileUploader;
import tp.service.FileUploaderImplService;

public class FileUploaderClientSoapApp {
	
public static void main(String[] args) {
	//code qui s'appuie sur le résultat  de wsimport du jdk >= 1.6
	//(src/script/lancerWsImport.sh depuis linux + Refresh eclipse)
	FileUploader uploader = 
			new FileUploaderImplService().getFileUploaderImplPort();
	
	FileToUpload file=new FileToUpload();
	
	file.setFileName("maven-2012.pdf");

	
	DataSource source = new FileDataSource(new File("/home/formation/Bureau/docs/maven-2012.pdf"));
	DataHandler dataHandler = new DataHandler(source);
	try {
		file.setFileDataHandler(toBytes(dataHandler));
	} catch (IOException e) {
		e.printStackTrace();
	}
	uploader.uploadFile(file);
	
}

private static final int INITIAL_SIZE = 1024 * 1024;
private static final int BUFFER_SIZE = 1024;

public static byte[] toBytes(DataHandler dh) throws IOException {
    ByteArrayOutputStream bos = new ByteArrayOutputStream(INITIAL_SIZE);
    InputStream in = dh.getInputStream();
    byte[] buffer = new byte[BUFFER_SIZE];
    int bytesRead;
    while ( (bytesRead = in.read(buffer)) >= 0 ) {
        bos.write(buffer, 0, bytesRead);
    }
    return bos.toByteArray();
}


}
