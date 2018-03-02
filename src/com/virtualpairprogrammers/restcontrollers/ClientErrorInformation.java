package com.virtualpairprogrammers.restcontrollers;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClientErrorInformation
{
    private String message;

    public ClientErrorInformation() {
    }

    public ClientErrorInformation(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
