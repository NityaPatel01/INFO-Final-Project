/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Order {
    int orderid;
    String orderstatus;
    int creatorid;
    String productname;
    String address;
    String Placedate;
    int agentid;
    String notes;

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public void setCreatorid(int creatorid) {
        this.creatorid = creatorid;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPlacedate(String Placedate) {
        this.Placedate = Placedate;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getOrderid() {
        return orderid;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public int getCreatorid() {
        return creatorid;
    }

    public String getProductname() {
        return productname;
    }

    public String getAddress() {
        return address;
    }

    public String getPlacedate() {
        return Placedate;
    }

    public int getAgentid() {
        return agentid;
    }

    public String getNotes() {
        return notes;
    }

    
}
