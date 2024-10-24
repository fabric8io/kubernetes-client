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
package io.fabric8.crd.generator.cli;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggingConfigurationTest {

  @Test
  void givenNoVerbosity_thenLevelWarn() {
    LoggingConfiguration.LogLevel level = LoggingConfiguration.getBaseLogLevel(Collections.emptyList());
    assertEquals(LoggingConfiguration.LogLevel.WARN, level);
  }

  @Test
  void given1Verbosity_thenLevelInfo() {
    LoggingConfiguration.LogLevel level = LoggingConfiguration.getBaseLogLevel(Collections.singletonList(true));

    assertEquals(LoggingConfiguration.LogLevel.INFO, level);
  }

  @Test
  void given2Verbosity_thenLevelDebug() {
    LoggingConfiguration.LogLevel level = LoggingConfiguration.getBaseLogLevel(Arrays.asList(true, true));

    assertEquals(LoggingConfiguration.LogLevel.DEBUG, level);
  }

  @Test
  void given3orMoreVerbosity_thenLevelTrace() {
    LoggingConfiguration.LogLevel level = LoggingConfiguration.getBaseLogLevel(Arrays.asList(true, true, true));
    assertEquals(LoggingConfiguration.LogLevel.TRACE, level);

    level = LoggingConfiguration.getBaseLogLevel(Arrays.asList(true, true, true, true));
    assertEquals(LoggingConfiguration.LogLevel.TRACE, level);

    level = LoggingConfiguration.getBaseLogLevel(Arrays.asList(true, true, true, true, true));
    assertEquals(LoggingConfiguration.LogLevel.TRACE, level);
  }

}
