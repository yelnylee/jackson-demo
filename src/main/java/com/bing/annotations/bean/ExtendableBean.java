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

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Bing
 * @summary
 * @date 8/22/2022
 */
public class ExtendableBean {

    public String name;
    private Map<String, String> properties;
    private Map<String, String> unStandardProperties = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void add(String key, String value) {

        if(properties==null){
            properties = new HashMap<>();
        }
        properties.put(key,value);
    }

    public Map<String, String> getUnStandardProperties() {
        return unStandardProperties;
    }

    public void setUnStandardProperties(
        Map<String, String> unStandardProperties) {
        this.unStandardProperties = unStandardProperties;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ExtendableBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", properties=").append(properties);
        sb.append(", unStandardProperties=").append(unStandardProperties);
        sb.append('}');
        return sb.toString();
    }
}