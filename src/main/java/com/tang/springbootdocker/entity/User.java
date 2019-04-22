package com.tang.springbootdocker.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.util.Date;

/**
 * @author tangxiao
 * @create 2019-04-18 11:27
 * @Since --
 **/
@Document(indexName = "shakespeare", type = "shakespeare", shards = 1, replicas = 0, refreshInterval = "-1")
@Data
public class User {
    @Id
    private Integer id;
    @Field
    private String userId;
    @Field
    private Integer groupId;
    @Field
    private Date createTime;
}
