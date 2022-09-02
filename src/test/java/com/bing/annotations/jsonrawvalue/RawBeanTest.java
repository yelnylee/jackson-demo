package com.bing.annotations.jsonrawvalue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

import com.bing.annotations.bean.RawBean;
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
class RawBeanTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void whenSerializingUsingJsonRawValue_thenCorrect() throws JsonProcessingException {
        RawBean rawBean = new RawBean("My Bean","{\"attr\":false}","{\"attr\":false}");

        String result = new ObjectMapper().writeValueAsString(rawBean);

        logger.debug("result: \n {}",result);

        assertThat(result,containsString("My Bean"));


    }

}