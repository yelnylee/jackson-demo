package com.bing.annotations.jsongetter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

import com.bing.annotations.bean.MyBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bing
 * @summary
 * @date 9/2/2022
 */
class MyBeanTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {

        MyBean myBean = new MyBean(1,"My Bean");


        String result = new ObjectMapper().writeValueAsString(myBean);

        logger.debug("result {}",result);

        assertThat(result,containsString("My Bean Test"));

    }

}