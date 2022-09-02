package com.bing.annotations.jsonserialize;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

import com.bing.annotations.bean.EventWithSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bing
 * @summary
 * @date 9/2/2022
 */
class EventWithSerializerTest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException {
        LocalDateTime date = LocalDateTime.of(2022, Month.SEPTEMBER,2,14,32,50);

        Date eventTime = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());


        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(new EventWithSerializer("bing",eventTime,eventTime));
        logger.debug("result {}{}",System.lineSeparator(),result);
        assertThat(result,containsString("02-09-2022 02:32:50"));
    }

}