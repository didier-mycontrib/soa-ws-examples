package tp.data;

import javax.activation.DataHandler;

public class FileToUpload {

	private String fileName;
	private DataHandler fileDataHandler;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public DataHandler getFileDataHandler() {
		return fileDataHandler;
	}
	public void setFileDataHandler(DataHandler fileDataHandler) {
		this.fileDataHandler = fileDataHandler;
	}

	
}
