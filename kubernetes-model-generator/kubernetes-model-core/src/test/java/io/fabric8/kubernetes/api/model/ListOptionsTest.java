/*
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
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOptionsTest {
  @Test
  void testBuilder() {
    ListOptions listOptions = new io.fabric8.kubernetes.api.model.ListOptionsBuilder()
        .withLimit(100L)
        .withContinue("23243434")
        .withFieldSelector("metadata.name=my-service")
        .build();

    assertEquals(100L, listOptions.getLimit());
    assertEquals("23243434", listOptions.getContinue());
    assertEquals("metadata.name=my-service", listOptions.getFieldSelector());
  }

  @Test
  void preservesLombokObjectMethodBehavior() throws Exception {
    final ListOptions original = new ListOptionsBuilder()
        .withAllowWatchBookmarks(false)
        .withContinue("token")
        .withFieldSelector("metadata.name=example")
        .withLabelSelector("app=example")
        .withLimit(25L)
        .withResourceVersion("7")
        .withResourceVersionMatch("Exact")
        .withSendInitialEvents(true)
        .withShardSelector("shard-a")
        .withTimeoutSeconds(3L)
        .withWatch(false)
        .withAdditionalProperties(Map.of("custom", "value"))
        .build();
    final ListOptions copy = new ObjectMapper().readValue(new ObjectMapper().writeValueAsBytes(original), ListOptions.class);

    assertThat(copy)
        .isEqualTo(original)
        .hasSameHashCodeAs(original)
        .hasToString(
            "ListOptions(allowWatchBookmarks=false, apiVersion=v1, _continue=token, fieldSelector=metadata.name=example, kind=ListOptions, labelSelector=app=example, limit=25, resourceVersion=7, resourceVersionMatch=Exact, sendInitialEvents=true, shardSelector=shard-a, timeoutSeconds=3, watch=false, additionalProperties={custom=value})");
  }
}
