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

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class AdditionalPropertiesTest {

  @Test
  void podBuilderDirectTest() throws Exception {
    // given new method due to setter
    PodBuilder builder = new PodBuilder().withNewMetadata().addToAdditionalProperties("x", "y").endMetadata();

    // then
    Map<String, String> expected = new HashMap<>();
    expected.put("x", "y");
    org.junit.jupiter.api.Assertions.assertEquals(expected, builder.build().getMetadata().getAdditionalProperties());
  }

  @Test
  void podBuilderIndirectTest() throws Exception {
    // given new method due to setter
    ObjectMeta meta = new ObjectMeta();
    meta.setAdditionalProperty("x", "y");
    PodBuilder builder = new PodBuilder().withMetadata(meta);

    // then
    Map<String, String> expected = new HashMap<>();
    expected.put("x", "y");
    org.junit.jupiter.api.Assertions.assertEquals(expected, builder.build().getMetadata().getAdditionalProperties());
  }

}
