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
import io.fabric8.kubernetes.api.model.rbac.ClusterRole;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBuilder;
import io.fabric8.kubernetes.api.model.rbac.PolicyRuleBuilder;
import org.junit.Test;

import static net.javacrumbs.jsonunit.core.Option.*;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class ClusterRoleTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void kubernetesClusterRoleTest() throws Exception {
        // given
        final String originalJson = Helper.loadJson("/valid-clusterRole.json");

        // when
        final ClusterRole clusterRole = mapper.readValue(originalJson, ClusterRole.class);
        final String serializedJson = mapper.writeValueAsString(clusterRole);

        // then
        assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
                .isEqualTo(originalJson);
    }

    @Test
    public void kubernetesClusterRoleBuilderTest() throws Exception {

        // given
        final String originalJson = Helper.loadJson("/valid-clusterRole.json");

        // when
        ClusterRole clusterRole = new ClusterRoleBuilder()
                .withNewMetadata()
                    .withName("node-reader")
                .endMetadata()
                .addToRules(0, new PolicyRuleBuilder()
                        .addToApiGroups(0,"")
                        .addToNonResourceURLs(0,"/healthz")
                        .addToResourceNames(0,"my-node")
                        .addToResources(0,"nodes")
                        .addToVerbs(0, "get")
                        .addToVerbs(1, "watch")
                        .addToVerbs(2, "list")
                        .build()
                    )
                .build();

        final String serializedJson = mapper.writeValueAsString(clusterRole);

        // then
        assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
                .isEqualTo(originalJson);

    }
}
