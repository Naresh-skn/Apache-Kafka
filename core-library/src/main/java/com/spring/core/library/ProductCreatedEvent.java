package com.spring.core.library;

public class ProductCreatedEvent {
    private String productId;
    private String title;
    private Long quantity;
    private Double price;

    public ProductCreatedEvent() {
    }

    public ProductCreatedEvent(String productId, String title, Long quantity, Double price) {
        this.productId = productId;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
