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

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * A ValidationReport consists of a collection of {@link ValidationMessage} produced by the {@link Validator#validate(JsonNode)}
 * process.
 * <p>
 * If the report contains at least one message of level {@link ValidationMessage.Level#ERROR}, the validation process is
 * considered failed.
 */
public class ValidationReport {

  static final ValidationReport EMPTY = new ValidationReport(Collections.emptyList());
  static final ValidationReport MISSING_KIND = new ValidationReport(Collections.singletonList(
      new ValidationMessage(ValidationMessage.Level.ERROR, "[Path '/'] Object has missing required properties ([\"kind\"])")));
  static final ValidationReport MISSING_API_VERSION = new ValidationReport(Collections.singletonList(new ValidationMessage(
      ValidationMessage.Level.ERROR, "[Path '/'] Object has missing or invalid required properties ([\"apiVersion\"])")));

  @Getter
  private final Collection<ValidationMessage> messages;
  private final boolean hasErrors;

  public ValidationReport(Collection<ValidationMessage> messages) {
    this.messages = Collections.unmodifiableCollection(messages);
    this.hasErrors = messages.stream().anyMatch(m -> m.getLevel() == ValidationMessage.Level.ERROR);
  }

  public boolean hasErrors() {
    return hasErrors;
  }

  static ValidationReport from(Collection<com.atlassian.oai.validator.report.ValidationReport.Message> messages) {
    return new ValidationReport(messages.stream().map(ValidationMessage::from).collect(Collectors.toList()));
  }
}
