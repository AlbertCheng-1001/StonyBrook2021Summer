package cs.homework5;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Creates information for email
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class Email implements Serializable{

	private static final long serialVersionUID = 1L;
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private GregorianCalendar timestamp;
	
	/**
	 * Creates email
	 * @param to
	 * 		email property
	 * @param cc
	 * 		cc property
	 * @param bcc
	 * 		bcc property
	 * @param subject
	 * 		subject property
	 * @param body
	 * 		body property
	 */
	public Email(String to, String cc, String bcc, String subject, String body) {
		setTo(to);
		setCc(cc);
		setBcc(bcc);
		setSubject(subject);
		setBody(body);
		setTimestamp(new GregorianCalendar());
		
		
	}
	
	/**
	 * Retrieves the to of email
	 * @return
	 * 		to of email
	 */
	public String getTo() {
		return to;
	}
	
	/**
	 * Sets the to of email
	 * @param to
	 * 		to of email
	 */
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * Retrieves the cc of email
	 * @return
	 * 		cc of email
	 */
	public String getCc() {
		return cc;
	}
	
	/**
	 * Sets the cc of email
	 * @param cc
	 * 		cc of email
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}
	
	/**
	 * Retrieves the bcc of email
	 * @return
	 * 		bcc of email
	 */
	public String getBcc() {
		return bcc;
	}
	
	/**
	 * Sets the bcc of email
	 * @param bcc
	 * 		bcc of email
	 */
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	
	/**
	 * Retrieves the subject of email
	 * @return
	 * 		subject of email
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Sets the subject of email
	 * @param subject
	 * 		subject of email
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Retrieves the body of email
	 * @return
	 * 		body of email
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * Sets the body of email
	 * @param body
	 * 		body of email
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * Gets the timestamp of when email is created
	 * @return
	 * 		current time created
	 */
	public Date getTimestamp() {
		return timestamp.getTime();
	}
	
	/**
	 * Sets the timestamp of when email is created
	 * @param timestamp
	 * 		timestamp of email created
	 */
	public void setTimestamp(GregorianCalendar timestamp) {
		this.timestamp = timestamp;
	}
	
}
