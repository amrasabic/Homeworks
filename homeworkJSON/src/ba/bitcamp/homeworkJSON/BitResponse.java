package ba.bitcamp.homeworkJSON;

import java.util.Date;

public class BitResponse {

	private String message;
	private String timestamp;
	
	/**
	 * Empty constructor
	 */
	public BitResponse() {
		this.message = null;
		this.timestamp = null;
	}
	
	/**
	 * Constructor
	 * @param message
	 * @param timestamp
	 */
	public BitResponse(String message) {
		super();
		this.message = message;
		Date date = new Date();
		this.timestamp = date.toString();
	}

	// auto-generated getters and setters
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
