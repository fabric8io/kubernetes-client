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

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Utility class to configure log levels of underlying components.
 */
class LoggingConfiguration {

  private LoggingConfiguration() {
  }

  static void configureLogger(List<Boolean> verbose) {
    configureLogger(getBaseLogLevel(verbose));
  }

  private static void configureLogger(LogLevel baseLogLevel) {
    setLogLevel("io.fabric8.crd.generator.cli", baseLogLevel.toLogbackLevel());
    setLogLevel("io.fabric8.crd.generator.collector", baseLogLevel.toLogbackLevel());
    setLogLevel("io.fabric8.crdv2.generator", baseLogLevel.toLogbackLevel());
  }

  private static void setLogLevel(String packageName, Level level) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    ch.qos.logback.classic.Logger logger = loggerContext.getLogger(packageName);
    logger.setLevel(level);
  }

  /**
   * Derive the base log level from a list of verbose options.
   *
   * @return the base log level.
   */
  static LogLevel getBaseLogLevel(List<Boolean> verbose) {
    switch (verbose.size()) {
      case 1:
        return LogLevel.INFO;
      case 2:
        return LogLevel.DEBUG;
      default:
        if (verbose.size() >= 3) {
          return LogLevel.TRACE;
        } else {
          return LogLevel.WARN;
        }
    }
  }

  enum LogLevel {
    WARN,
    INFO,
    DEBUG,
    TRACE;

    Level toLogbackLevel() {
      return Level.toLevel(name());
    }
  }
}
