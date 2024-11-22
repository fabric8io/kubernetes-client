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
package io.fabric8.kubernetes.schema.validator;

import com.atlassian.oai.validator.report.ValidationReport;
import lombok.Getter;

import java.util.Map;

/**
 * Represents a message returned by the Validator validation process.
 * <p>
 * Each message contains a level and a message.
 * <p>
 * If a message is of level ERROR, it means that the validation process failed.
 */
@Getter
public class ValidationMessage {

  public enum Level {
    ERROR,
    WARNING,
    INFO,
    IGNORE
  }

  private static final Map<ValidationReport.Level, Level> levelMappings = Map.of(
      ValidationReport.Level.ERROR, Level.ERROR,
      ValidationReport.Level.WARN, Level.WARNING,
      ValidationReport.Level.INFO, Level.INFO,
      ValidationReport.Level.IGNORE, Level.IGNORE);

  /**
   * The validation message level.
   */
  private final Level level;
  /**
   * The validation message.
   */
  private final String message;

  public ValidationMessage(Level level, String message) {
    this.level = level;
    this.message = message;
  }

  static ValidationMessage from(ValidationReport.Message message) {
    return new ValidationMessage(levelMappings.getOrDefault(message.getLevel(), Level.INFO), message.getMessage());
  }
}
