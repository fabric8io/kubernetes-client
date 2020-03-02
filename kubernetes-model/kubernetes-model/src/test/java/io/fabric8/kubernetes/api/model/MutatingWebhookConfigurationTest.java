/**
 * Copyright (C) 2015 Fabric8 Authors.
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

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.fabric8.kubernetes.api.model.admissionregistration.MutatingWebhookConfiguration;

public class MutatingWebhookConfigurationTest {
 
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void kubernetesMutatingWebhookConfigurationTest() throws Exception {
        // given
        final String originalJson = Helper.loadJson("/valid-mutating-webhook-configuration.json");

        // when
        final MutatingWebhookConfiguration kubernetesMutatingWebhookConfiguration = mapper.readValue(originalJson, MutatingWebhookConfiguration.class);
        final String serializedJson = mapper.writeValueAsString(kubernetesMutatingWebhookConfiguration);

        // then
        assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
                .isEqualTo(originalJson);
    }
}