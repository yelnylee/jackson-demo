package com.bing.annotations.jsonrootname;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import com.bing.annotations.bean.UserWithRoot;
import com.bing.annotations.bean.UserWithRootNameSpace;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bing
 * @summary
 * @date 9/2/2022
 */
class UserWithRootTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(new UserWithRoot(1,"bing"));
        logger.debug("result: {} {} ",System.lineSeparator(),result);
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        result = objectMapper.writeValueAsString(new UserWithRoot(1,"bing"));
        logger.debug("result: {} {} ",System.lineSeparator(),result);
        assertThat(result,containsString("bing"));
    }


    @Test
    public void whenSerializingUsingJsonRootNameSpace_thenCorrect() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String result = xmlMapper.writeValueAsString(new UserWithRootNameSpace(1,"bing"));
        logger.debug("result: {} {} ",System.lineSeparator(),result);
        xmlMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        result = xmlMapper.writeValueAsString(new UserWithRootNameSpace(1,"bing"));
        logger.debug("result: {} {} ",System.lineSeparator(),result);
        assertThat(result,is("<user xmlns=\"users\"><id xmlns=\"\">1</id><name xmlns=\"\">bing</name></user>"));

    }


}