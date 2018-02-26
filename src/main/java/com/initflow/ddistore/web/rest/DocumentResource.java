package com.initflow.ddistore.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.initflow.ddistore.domain.Document;
import com.initflow.ddistore.repository.DocumentRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DocumentResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private DocumentRepositoryImpl documentRepository;

    @GetMapping("/documents")
    @Timed
    public ResponseEntity<List<Document>> getAll() {
        List<Document> documents = documentRepository.findAll();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @GetMapping("/document/{address}")
    @Timed
    public ResponseEntity<Document> getOne(@PathVariable String address) {
        Document document = documentRepository.findOne(address);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @PostMapping("/document")
    @Timed
    public ResponseEntity<Document> insert(@RequestBody Document document) {
        documentRepository.insert(document);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }

    @DeleteMapping("/document/{address}")
    @Timed
    public ResponseEntity delete(@PathVariable String address) {
        documentRepository.delete(address);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/documents")
    @Timed
    public ResponseEntity<List<Document>> getAll(@RequestBody List<String> addresses) {
        List<Document> documents = documentRepository.findAll(addresses);
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }
}
