package com.tang.springbootdocker.repository;

import com.tang.springbootdocker.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tangxiao
 * @create 2019-04-04 11:39
 * @Since --
 **/
@Repository
public interface OnnRepository extends ElasticsearchRepository<User, String> {

    User queryUserById(Integer id);
}
