package com.websocket02.websocket02.dto;

public class ClientMessageDTO {

    private String clientName;
    private String clientAlert;
    private String clientMsg;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAlert() {
        return clientAlert;
    }

    public void setClientAlert(String clientAlert) {
        this.clientAlert = clientAlert;
    }

    public String getClientMSG() {
        return clientMsg;
    }

    public void setClientMSG(String clientMSG) {
        this.clientMsg = clientMSG;
    }

    public ClientMessageDTO(String clientName, String clientAlert, String clientMSG) {
        this.clientName = clientName;
        this.clientAlert = clientAlert;
        this.clientMsg = clientMSG;
    }
}
