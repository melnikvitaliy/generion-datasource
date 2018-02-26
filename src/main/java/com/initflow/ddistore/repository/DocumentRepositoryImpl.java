package com.initflow.ddistore.repository;

import com.datastax.driver.core.*;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.initflow.ddistore.domain.Document;
import com.initflow.ddistore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DocumentRepositoryImpl {

    private Session session;
    private Mapper<Document> mapper;

    private PreparedStatement insert;

    private PreparedStatement delete;
    private PreparedStatement findAll;
    private PreparedStatement findAllIn;

    public DocumentRepositoryImpl(Session session) {
        this.session = session;
        mapper = new MappingManager(session).mapper(Document.class);


        insert = session.prepare(
            "INSERT INTO user_by_activation_key (activation_key, id) " +
                "VALUES (:activation_key, :id)");

        delete = session.prepare(
            "DELETE FROM document " +
                "WHERE address = :address");

        findAll = session.prepare("SELECT * FROM document");

        findAllIn = session.prepare("SELECT * FROM document where address in ?");
    }

    public Document findOne(String address) {
        return mapper.get(address);
    }


    public void insert(Document document){
        BatchStatement batch = new BatchStatement();
        batch.add(mapper.saveQuery(document));
        session.execute(batch);
    }

    public void delete(String address){
        BoundStatement truncate = delete.bind().setString("address", address);
        session.execute(truncate);
    }

    public List<Document> findAll() {
        return mapper.map(session.execute(findAll.bind())).all();
    }

    public List<Document> findAll(List<String> addresses) {
        return mapper.map(session.execute(findAllIn.bind(addresses))).all();
    }
}
