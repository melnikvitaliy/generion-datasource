package com.initflow.ddistore.projection;

import com.initflow.ddistore.domain.Document;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "document", types = Document.class)
public interface DocumentProjection {

    String getAddress();
    String getContent();
}
