package core.exeption;

import java.io.IOException;

public class GeoPayClientErrorException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	
	private String errorDescription;

    public GeoPayClientErrorException(String message) {
        super(message);
    }
    
    public GeoPayClientErrorException(String errorCode, String errorDescription) {
    	this.errorCode = errorCode;
    	this.errorDescription = errorDescription;
    }

	public GeoPayClientErrorException(String message, IOException e) {
		super(message, e);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

}
