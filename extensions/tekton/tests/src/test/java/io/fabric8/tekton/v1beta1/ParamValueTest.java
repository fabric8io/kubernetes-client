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
package io.fabric8.tekton.v1beta1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParamValueTest {

  @Test
  void testParamValueJson() throws IOException {
    ParamValue is = new ParamValue("string-value");
    ObjectMapper mapper = new JsonMapper();
    String json = mapper.writeValueAsString(is);
    ParamValue is2 = mapper.readValue(json, ParamValue.class);
    assertEquals(is, is2);

    is = new ParamValue(Arrays.asList("a", "b"));
    json = mapper.writeValueAsString(is);
    is2 = mapper.readValue(json, ParamValue.class);
    assertEquals(is, is2);
  }

  @Test
  @DisplayName("object-typed values are deserialized into objectVal and serialized back as a JSON object")
  void objectValueRoundTrip() {
    final ObjectMapper mapper = new JsonMapper();
    final String json = "{\"url\":\"https://example.com/repo.git\",\"commit\":\"abc123\"}";
    final ParamValue value = mapper.readValue(json, ParamValue.class);
    assertEquals(new ParamValue(Map.of("url", "https://example.com/repo.git", "commit", "abc123")), value);
    assertEquals(json, mapper.writeValueAsString(value));
  }

}
