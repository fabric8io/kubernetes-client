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
package io.fabric8.kubernetes.schema.generator;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ApiVersion {
  private final String group;
  private final String version;
  private final boolean namespaced;

  @Override
  public String toString() {
    if (group == null || group.isBlank()) {
      return version;
    }
    return group + "/" + version;
  }
}
