package com.initflow.ddistore.repository;

import com.initflow.ddistore.domain.Document;
import com.initflow.ddistore.projection.DocumentProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@SuppressWarnings("unused")
@RepositoryRestResource(collectionResourceRel = "document", path = "document",
    excerptProjection = DocumentProjection.class)
public interface DocumentRepository extends PagingAndSortingRepository<Document, String> {

}