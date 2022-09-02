/*
 * © Copyright 2022 Micro Focus or one of its affiliates.
 *
 * The only warranties for products and services of Micro Focus and its
 * affiliates and licensors (“Micro Focus”) are as may be set forth in
 * the express warranty statements accompanying such products and services.
 * Nothing herein should be construed as constituting an additional warranty.
 * Micro Focus shall not be liable for technical or editorial errors or
 * omissions contained herein. The information contained herein is subject
 * to change without notice.
 *
 * Except as specifically indicated otherwise, this document contains
 * confidential information and a valid license is required for possession,
 * use or copying. If this work is provided to the U.S. Government, consistent
 * with FAR 12.211 and 12.212, Commercial Computer Software, Computer Software
 * Documentation, and Technical Data for Commercial Items are licensed to the
 * U.S. Government under vendor's standard commercial license.
 */

package com.bing.annotations.bean;

import com.bing.annotations.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

/**
 * @author Bing
 * @summary
 * @date 9/2/2022
 */
public class EventWithSerializer {

    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public EventWithSerializer(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public EventWithSerializer(String name, Date eventDate, Date createDate) {
        this.name = name;
        this.eventDate = eventDate;
        this.createDate = createDate;
    }

    public EventWithSerializer() {
    }
}
