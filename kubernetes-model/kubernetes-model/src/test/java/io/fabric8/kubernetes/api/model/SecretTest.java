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
import org.junit.Test;

import java.util.HashMap;

import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.Option.TREATING_NULL_AS_ABSENT;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SecretTest {
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void secretTest() throws Exception {
        // given
        final String originalJson = Helper.loadJson("/valid-secret.json");

        // when
        final Secret secret = mapper.readValue(originalJson, Secret.class);
        final String serializedJson = mapper.writeValueAsString(secret);

        // then
        assertThatJson(serializedJson).when(IGNORING_ARRAY_ORDER, TREATING_NULL_AS_ABSENT, IGNORING_EXTRA_FIELDS)
                .isEqualTo(originalJson);
    }

    @Test
    public void secretBuilderTest(){

        Secret secret = new io.fabric8.kubernetes.api.model.SecretBuilder()
                .withNewMetadata()
                .withName("test-secret")
                .withNamespace("my-namespace")
                .endMetadata()
                .withType("opaque")
                .withData(new HashMap<String, String>() {{
                    put("username", "dmFsdWUtMQ0K");
                    put("password", "dmFsdWUtMg0KDQo=");
                    put(".secret-file", "dmFsdWUtMg0KDQo=");
                    }}
                )
                .withStringData(new HashMap<String, String>() {{
                    put("hostname", "myapp.mydomain.com");
                    put("secret.properties", "property1=valueA\nproperty2=valueB");
                    }}
                )
                .build();

        assertNotNull(secret);
        assertEquals("test-secret", secret.getMetadata().getName());
        assertEquals("my-namespace",secret.getMetadata().getNamespace());
        assertEquals("opaque", secret.getType());
        assertEquals(3,secret.getData().size());
        assertTrue(secret.getData().get("username").equals("dmFsdWUtMQ0K"));
        assertTrue(secret.getData().get("password").equals("dmFsdWUtMg0KDQo="));
        assertTrue(secret.getData().get(".secret-file").equals("dmFsdWUtMg0KDQo="));
        assertEquals(2,secret.getStringData().size());
        assertTrue(secret.getStringData().get("hostname").equals("myapp.mydomain.com"));
        assertTrue(secret.getStringData().get("secret.properties").equals("property1=valueA\nproperty2=valueB"));
    }
}
