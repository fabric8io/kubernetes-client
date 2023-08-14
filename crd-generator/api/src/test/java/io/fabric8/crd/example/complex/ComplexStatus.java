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
package io.fabric8.crd.example.complex;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.crd.generator.annotation.PrinterColumn;

@SuppressWarnings("LombokGetterMayBeUsed")
public class ComplexStatus {

  public enum State {
    CREATED,
    STARTING,
    RUNNING,
    ROLLING_UPDATE,
    SCALING,
    ERROR
  }

  public ComplexStatus() {
    this.state = State.CREATED;
    this.message = "Deployment was created";
  }

  @JsonProperty("state")
  @PrinterColumn(name = "State")
  private State state;

  @JsonProperty("message")
  @PrinterColumn(name = "Message")
  private String message;

  public State getState() {
    return state;
  }

  public void setState(final State state) {
    this.state = state;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
