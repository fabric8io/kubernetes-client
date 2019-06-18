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

import io.fabric8.kubernetes.api.model.Cluster;

public class ClusterMapper extends PropertyMapper<Cluster> {

    private final NamedExtensionsMapper namedExtensionsMapper = new NamedExtensionsMapper();

    @Override
    public Cluster map(Map<String, Object> mappedBean) {
        final Cluster cluster = new Cluster();
        cluster.setCertificateAuthority(get("certificate-authority", mappedBean, String.class));
        cluster.setCertificateAuthorityData(get("certificate-authority-data", mappedBean, String.class));
        cluster.setExtensions(getList("extensions", mappedBean, namedExtensionsMapper));
        cluster.setInsecureSkipTlsVerify(get("insecure-skip-tls-verify", mappedBean, Boolean.class));
        cluster.setServer(get("server", mappedBean, String.class));
        return cluster;
    }

}
