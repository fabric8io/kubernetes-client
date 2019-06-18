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

import io.fabric8.kubernetes.api.model.Config;

public class ConfigMapper extends PropertyMapper<Config> {

    private final NamedClusterMapper namedClusterMapper = new NamedClusterMapper();
    private final NamedContextMapper namedContextMapper = new NamedContextMapper();
    private final NamedExtensionsMapper namedExtensionsMapper = new NamedExtensionsMapper();
    private final PreferencesMapper preferencesMapper = new PreferencesMapper();
    private final NamedAuthInfoMapper namedAuthInfoMapper = new NamedAuthInfoMapper();

    @Override
    public Config map(Map<String, Object> mappedBean) {
        final Config config = new Config();
        config.setApiVersion(get("apiVersion", mappedBean, String.class));
        config.setClusters(getList("clusters", mappedBean, namedClusterMapper));
        config.setContexts(getList("contexts", mappedBean, namedContextMapper));
        config.setCurrentContext(get("current-context", mappedBean, String.class));
        config.setExtensions(getList("extensions", mappedBean, namedExtensionsMapper));
        config.setKind(get("kind", mappedBean, String.class));
        config.setPreferences(get("preferences", mappedBean, preferencesMapper));
        config.setUsers(getList("users", mappedBean, namedAuthInfoMapper));
        return config;
    }

}
