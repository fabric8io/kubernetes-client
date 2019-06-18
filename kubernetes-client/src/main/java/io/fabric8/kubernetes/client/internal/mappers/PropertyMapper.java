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
package io.fabric8.kubernetes.client.internal.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class PropertyMapper<T> {

    public abstract T map(Map<String, Object> mappedBean);

    protected String get(final String prop, final Map<String, Object> mappedBean) {
        final Object value = mappedBean.get(prop);
        if (value instanceof String && value != null) {
            return (String) value;
        }
        return null;
    }

    protected <V> V get(final String prop, final Map<String, Object> mappedBean, final Class<V> clazz) {
        final Object value = mappedBean.get(prop);
        if (clazz.isInstance(value) && value != null) {
            return (V) value;
        }
        return null;
    }

    protected <V> V get(final String prop, final Map<String, Object> mappedBean, final PropertyMapper<?> mapper) {
        final Object value = mappedBean.get(prop);
        if (value instanceof Map<?, ?>) {
            return (V) mapper.map((Map<String, Object>) value);
        }
        return null;
    }

    protected <V> List<V> getList(final String prop, final Map<String, Object> mappedBean) {
        final Object value = mappedBean.get(prop);
        if (value instanceof List<?> && value != null) {
            return (List<V>) value;
        }
        return null;
    }

    protected <V> List<V> getList(final String prop, final Map<String, Object> mappedBean, final PropertyMapper<V> mapper) {
        final Object value = mappedBean.get(prop);
        List<V> mappedList = new ArrayList<>();
        if (value instanceof List<?> && value != null) {
            ((List<V>) value).forEach(v -> {
                if (v instanceof Map<?, ?> && v != null) {
                    mappedList.add(mapper.map((Map<String, Object>) v));
                }
            });
        }
        return mappedList;
    }

}
