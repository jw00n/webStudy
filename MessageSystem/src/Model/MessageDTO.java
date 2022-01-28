package Model;

public class MessageDTO {
	private int num;
	private String sendName;
	private String receiveEmail;
	private String message;
	private String m_date;
	
	public MessageDTO(int num, String sendName, String receiveEmail, String message, String m_date) {
		this.num = num;
		this.sendName = sendName;
		this.receiveEmail = receiveEmail;
		this.message = message;
		this.m_date = m_date;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getReceiveEmail() {
		return receiveEmail;
	}
	public void setReceiveEmail(String receiveEmail) {
		this.receiveEmail = receiveEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}

	
}
