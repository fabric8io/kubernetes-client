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
package io.fabric8.kubernetes.client.dsl;

public interface FieldValidateable<T> {

  public enum Validation {
    WARN("Warn"),
    IGNORE("Ignore"),
    STRICT("Strict");

    String parameterValue;

    private Validation(String parameterValue) {
      this.parameterValue = parameterValue;
    }

    public String parameterValue() {
      return parameterValue;
    }
  }

  /**
   * Instructs the server on how to handle objects in the request (POST/PUT/PATCH) containing unknown or duplicate fields,
   * provided that the `ServerSideFieldValidation` feature gate is also enabled.
   *
   * @param fieldValidation
   * @return write operations where field validation is applicable.
   */
  T fieldValidation(Validation fieldValidation);

}
