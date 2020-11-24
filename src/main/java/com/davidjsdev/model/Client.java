package com.davidjsdev.model;

public class Client {
    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNum;
    private String address;

    public Client(){
        this.firstName = "RONALD";
        this.lastName = "HUAMANI ORTEGA";
        this.documentType = "RUC";
        this.documentNum = "32165498721";
        this.address = "TAMBOPATA 510, PUERTO MADLDONADO, TAMBOPATA, TAMBOPATA";
    }

    public Client(String firstName, String lastName, String documentType, String documentNum, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNum = documentNum;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentNum='" + documentNum + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
