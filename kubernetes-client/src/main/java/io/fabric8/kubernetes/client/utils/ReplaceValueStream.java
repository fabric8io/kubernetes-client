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

import io.fabric8.kubernetes.client.KubernetesClientException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static io.fabric8.kubernetes.client.utils.Utils.replaceAllWithoutRegex;

/**
 * Replaces template parameter values in the stream to avoid
 * parsing issues of templates with numeric expressions
 */
public class ReplaceValueStream {
    private final Map<String, String> valuesMap;

    /**
     * Returns a stream with the template parameter expressions replaced
     */
    public static InputStream replaceValues(InputStream is, Map<String, String> valuesMap) {
        return new ReplaceValueStream(valuesMap).createInputStream(is);
    }

    public ReplaceValueStream(Map<String, String> valuesMap) {
        this.valuesMap = valuesMap;
    }

    public InputStream createInputStream(InputStream is) {
        try {
            String json = IOHelpers.readFully(is);
            String replaced = replaceValues(json);
            return new ByteArrayInputStream(replaced.getBytes());
        } catch (IOException e) {
          throw KubernetesClientException.launderThrowable(e);
        }
    }

    private String replaceValues(String json) {
        String answer = json;
        for (Map.Entry<String, String> entry : valuesMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            answer = replaceAllWithoutRegex(answer, "${" + key + "}", value);
        }
        return answer;
    }
}
