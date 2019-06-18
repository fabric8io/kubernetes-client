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

import java.util.Map;

import io.fabric8.kubernetes.api.model.NamedAuthInfo;

public class NamedAuthInfoMapper extends PropertyMapper<NamedAuthInfo> {
    
    private final AuthInfoMapper authInfoMapper = new AuthInfoMapper();

    @Override
    public NamedAuthInfo map(Map<String, Object> mappedBean) {
        final NamedAuthInfo bean = new NamedAuthInfo();
        bean.setName(get("name", mappedBean, String.class));
        bean.setUser(get("user", mappedBean, authInfoMapper));
        return bean;
    }
    
}
