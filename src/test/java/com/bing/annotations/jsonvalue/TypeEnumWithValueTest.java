package com.bing.annotations.jsonvalue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.bing.annotations.bean.JsonValueDemo;
import com.bing.annotations.bean.TypeEnumWithValue;
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
class TypeEnumWithValueTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void whenSerializingUsingJsonValue_thenCorrect() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String enumValue =  objectMapper.writeValueAsString(TypeEnumWithValue.TYPE1);

        logger.debug("enum value:{}",enumValue);

        assertThat(enumValue,is("\"TYPE 1\""));
    }


    @Test
    public void whenSerializingUsingJsonValue_inToString_thenCorrect() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String result =  objectMapper.writeValueAsString(new JsonValueDemo("Bing",34));

        logger.debug("value:\n{}",result);

        assertThat(result,is("{\"name\":\"test Test @JsonGetter\",\"id\":1}"));
    }

}