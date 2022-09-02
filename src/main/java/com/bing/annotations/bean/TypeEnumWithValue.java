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

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Bing
 * @summary
 * @date 9/2/2022
 */
public enum TypeEnumWithValue {
    TYPE1(1,"TYPE 1"),
    TYPE2(2,"TYPE 2");


    TypeEnumWithValue(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private Integer id;

    @JsonValue
    private String name;

}
