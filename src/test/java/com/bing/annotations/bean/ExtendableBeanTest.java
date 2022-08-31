package com.bing.annotations.bean;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bing
 * @summary
 * @date 8/22/2022
 */
class ExtendableBeanTest {

    private static final Logger logger = LoggerFactory.getLogger(ExtendableBeanTest.class);

    @Test
    public void testJsonAnyGetter() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean();
        bean.setName("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(bean);
       logger.debug("result :{}",result);
        assertThat(result, containsString("attr1"));
        assertThat(result, containsString("val1"));
    }

}