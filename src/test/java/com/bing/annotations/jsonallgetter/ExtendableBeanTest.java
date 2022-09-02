package com.bing.annotations.jsonallgetter;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import cn.hutool.core.io.resource.ResourceUtil;
import com.bing.annotations.bean.ExtendableBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
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
    public static final String TEST_EXTENDABLE_JSON = "test/extendable.json";

    @Test
    public void testJsonAnyGetter() throws JsonProcessingException {
        ExtendableBean bean = new ExtendableBean();
        bean.setName("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");
        bean.setUnStandardProperties(bean.getProperties());

        String result = new ObjectMapper().writeValueAsString(bean);
        logger.debug("result :{}",result);
        assertThat(result, containsString("attr1"));
        assertThat(result, containsString("val1"));
    }


    @Test
    public void testJsonAnySetter() throws IOException {

        URL url = ResourceUtil.getResource(TEST_EXTENDABLE_JSON);

        ExtendableBean result = new ObjectMapper().readValue(url,ExtendableBean.class);
        logger.debug("result :{}",result);
        assertThat(result.getName(), containsString("My bean"));
        assertThat(result.getProperties().get("attr1"), containsString("val1"));
        assertThat(result.getUnStandardProperties().get("attr2"), containsString("val2"));
    }

}