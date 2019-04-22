package com.tang.springbootdocker.controller;

import com.google.common.collect.Lists;
import com.tang.springbootdocker.entity.User;
import com.tang.springbootdocker.repository.OnnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author tangxiao
 * @create 2019-04-04 11:31
 * @Since --
 **/
@Validated
@RestController
public class ElasticSearchController {

    @Autowired
    private OnnRepository onnRepository;

    @GetMapping("search")
    public List search(@NotNull Integer id) {
/*        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", name);
        Iterable search = onnRepository.search(matchQueryBuilder);
        ArrayList arrayList = Lists.newArrayList(search);
        return arrayList;*/
        User user = onnRepository.queryUserById(id);
        return Lists.newArrayList(user);
    }

}
