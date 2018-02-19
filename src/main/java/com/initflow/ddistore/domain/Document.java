package com.initflow.ddistore.domain;

import com.datastax.driver.mapping.annotations.*;

@Table(name = "document")
public class Document {

    @PartitionKey
    private String address;
    private String content;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
