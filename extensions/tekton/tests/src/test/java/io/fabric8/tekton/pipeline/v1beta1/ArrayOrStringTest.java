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
package io.fabric8.tekton.pipeline.v1beta1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOrStringTest {

  @Test
  void testArrayOrStringJson() throws IOException {
    ArrayOrString is = new ArrayOrString("string-value");
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(is);
    ArrayOrString is2 = mapper.readValue(json, ArrayOrString.class);
    assertEquals(is, is2);

    is = new ArrayOrString(Arrays.asList("a", "b"));
    json = mapper.writeValueAsString(is);
    is2 = mapper.readValue(json, ArrayOrString.class);
    assertEquals(is, is2);
  }

}
