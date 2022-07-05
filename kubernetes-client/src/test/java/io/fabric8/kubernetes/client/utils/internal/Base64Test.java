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
package io.fabric8.kubernetes.client.utils.internal;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Base64Test {

  @Test
  void testSkip() throws IOException {
    Base64.InputStream is = new Base64.InputStream(
        new ByteArrayInputStream(Base64.encodeBytesToBytes("hello".getBytes(StandardCharsets.UTF_8))));
    assertEquals(104, is.read());
    assertEquals(3, is.skip(3));
    assertEquals(111, is.read());
    assertEquals(-1, is.read());
  }
}
