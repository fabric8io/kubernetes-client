/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.fabric8.kubernetes.client.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResourceCompare {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    private static TypeReference<HashMap<String, Object>> TYPE_REF = new TypeReference<HashMap<String, Object>>(){};

    private static final String METADATA = "metadata";
    private static final String STATUS = "status";
    private static final String LABELS = "labels";


    public static <T>  boolean equals(T left, T right) {
        Map<String, Object> leftJson = (Map<String, Object>) JSON_MAPPER.convertValue(left, TYPE_REF);
        Map<String, Object> rightJson = (Map<String, Object>) JSON_MAPPER.convertValue(right, TYPE_REF);

        Map<String, Object> leftLabels = fetchLabels(leftJson);
        Map<String, Object> rightLabels = fetchLabels(rightJson);

        HashMap<String, Object> leftMap = trim(leftJson);
        HashMap<String, Object> rightMap = trim(rightJson);

        return leftMap.equals(rightMap) && leftLabels.equals(rightLabels);
    }

    private static HashMap<String, Object> trim(Map<String, Object> map) {
        HashMap<String, Object> result = new HashMap<>(map);
        result.remove(STATUS);
        result.remove(METADATA);
        return result;
    }

    private static Map<String, Object> fetchLabels(Map<String, Object> map){
        if (!map.containsKey(METADATA) || !((Map<Object, Object>)map.get(METADATA)).containsKey(LABELS)){
            return Collections.emptyMap();
        }
        return (Map<String, Object>) ((Map<Object, Object>)map.get(METADATA)).get(LABELS);
    }
}
