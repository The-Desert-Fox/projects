/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 *
 * @author Roshen
 */
public class Message
{
    private String fromAddress;
    private String toAddress;
    private String subject;

   
    //private int date;
    private String priority;
    private String messageBody;
    private int messageID;
    
    public Message()
    {
        fromAddress = "";
        toAddress = "";
        subject = "";
        priority = "";
        messageBody = "";
        messageID = 0; 
    }
//CONSTRUCTORS 
    public Message(String fromAddress, String toAddress, String subject, String priority, String messageBody, int messageID)
    {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.subject = subject;
        this.priority = priority;
        this.messageBody = messageBody;
        this.messageID = messageID;
    }
//GETTER METHODS
    public String getFromAddress()
    {
        return fromAddress;
    }

    public String getToAddress()
    {
        return toAddress;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getPriority()
    {
        return priority;
    }

    public String getMessageBody()
    {
        return messageBody;
    }

    public int getMessageID()
    {
        return messageID;
    }
    
    
// SETTER METHODS 
    public void setFromAddress(String fromAddress)
    {
        this.fromAddress = fromAddress;
    }

    public void setToAddress(String toAddress)
    {
        this.toAddress = toAddress;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public void setPriority(String priority)
    {
        this.priority = priority;
    }

    public void setMessageBody(String messageBody)
    {
        this.messageBody = messageBody;
    }

    public void setMessageID(int messageID)
    {
        this.messageID = messageID;
    }
    
    
    @Override
    public String toString()
    {
        return "+--------------------------------------------+" 
                + "\nFrom: " + fromAddress 
                + "\nTo: " + toAddress 
                + "\nSubject: " + subject 
                + "\nPriority: " + priority 
                + "\nMessageBody: " + messageBody 
                + "\nMessageID: " + messageID +
               "\n+--------------------------------------------+" ;
    }
}
 