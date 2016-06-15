package helloWorld.repository;


import helloWorld.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Query.query;
import static sun.misc.MessageUtils.where;

/**
 * Created by arnavagarwal on 15/06/16.
 */
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public boolean existsByPan(String pan) {
        Query query = query(Criteria.where("pan").is(pan));
        return mongoTemplate.exists(query, Customer.class);

    }
}
