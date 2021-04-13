package com.udacity.PlantDelivery.projection;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String recipient_name;
    private BigDecimal price;

    //You'll probably need a constructor like this so CriteriaBuilder can create
    public RecipientAndPrice(String recipientName, BigDecimal price) {
        this.recipient_name = recipientName;
        this.price = price;
    }

    public RecipientAndPrice() {
    }

    public String getRecipient_name() {
        return recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        this.recipient_name = recipient_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
