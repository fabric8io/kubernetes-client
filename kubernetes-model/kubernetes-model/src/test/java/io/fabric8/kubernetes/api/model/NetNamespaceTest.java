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
package io.fabric8.kubernetes.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.openshift.api.model.NetNamespace;
import io.fabric8.openshift.api.model.NetNamespaceBuilder;
import org.junit.Test;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class NetNamespaceTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void netNamespaceTest() throws Exception {
        // given
        final String originalJson = Helper.loadJson("/valid-netnamespace.json");

        // when
        final NetNamespace netNamespace = mapper.readValue(originalJson, NetNamespace.class);
        final String serializedJson = mapper.writeValueAsString(netNamespace);

        // then
        assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
                .isEqualTo(originalJson);
    }

    @Test
    public void netNamespaceBuilderTest() throws Exception {

        // given
        final String originalJson = Helper.loadJson("/valid-netnamespace.json");

        // when
        NetNamespace netNamespace = new NetNamespaceBuilder()
                .withNewMetadata()
                    .withName("test-netnamespace")
                    .withNamespace("default")
                .endMetadata()
                .withNetid(1066587)
                .withNetname("test")
                .addToEgressIPs(0, "192.168.17.9")
                .addToEgressIPs(1, "192.169.18.4")
                .build();

        final String serializedJson = mapper.writeValueAsString(netNamespace);

        // then
        assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
                .isEqualTo(originalJson);

    }
}

