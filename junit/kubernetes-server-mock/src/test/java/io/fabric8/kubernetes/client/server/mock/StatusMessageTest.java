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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusMessageTest {

  @Test
  void successExitCode() {
    assertEquals("\u0003{\"apiVersion\":\"v1\",\"kind\":\"Status\",\"code\":0,\"status\":\"Success\"}",
        new StatusMessage(0).getBody());
  }

  @ParameterizedTest(name = "exitCode, with code = ''{0}'', should create valid HTTP body")
  @ValueSource(ints = { 1, -1 })
  void exitCode(int exitCode) {
    assertEquals("\u0003{\"apiVersion\":\"v1\",\"kind\":\"Status\",\"code\":" + exitCode + ",\"status\":\"Failure\"}",
        new StatusMessage(exitCode).getBody());
  }
}
