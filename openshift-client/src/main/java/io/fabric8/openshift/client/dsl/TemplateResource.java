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
package io.fabric8.openshift.client.dsl;

import java.util.Map;

public interface TemplateResource<T, L, D> extends ProcessableResource<T, L, D> {

  /**
   * Returns a new template resource which replaces the given template parameter values so that the template can be
   * loaded if the template contains parameterized expressions for numeric values on resources such as the Service
   * port number or the Deployment replicas
   *
   * @param valuesMap a map of template parameter names to their values to be used in any expressions in the templates
   */
  TemplateResource<T, L, D> replaceParameters(Map<String, String> valuesMap);
}
