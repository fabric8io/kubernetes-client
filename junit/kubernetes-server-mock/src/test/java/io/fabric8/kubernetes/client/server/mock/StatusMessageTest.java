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
package io.fabric8.kubernetes.client.server.mock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusMessageTest {

  @Test
  void exitCode() {
    assertEquals("\u0003{\"apiVersion\":\"v1\",\"kind\":\"Status\",\"code\":0,\"status\":\"Success\"}",
        new StatusMessage(0).getBody());
    assertEquals("\u0003{\"apiVersion\":\"v1\",\"kind\":\"Status\",\"code\":1,\"status\":\"Failure\"}",
        new StatusMessage(1).getBody());
    assertEquals("\u0003{\"apiVersion\":\"v1\",\"kind\":\"Status\",\"code\":-1,\"status\":\"Failure\"}",
        new StatusMessage(-1).getBody());
  }
}
