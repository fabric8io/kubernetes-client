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
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntOrStringTest {

    @Test
    public void testIntOrStringJson() throws IOException {
        IntOrString is = new IntOrString(3000);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(is);
        IntOrString is2 = mapper.readValue(json, IntOrString.class);
        assertEquals(is, is2);

        is = new IntOrString("3000");
        json = mapper.writeValueAsString(is);
        is2 = mapper.readValue(json, IntOrString.class);
        assertEquals(is, is2);
    }
}
