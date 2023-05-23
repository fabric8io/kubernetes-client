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

import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.client.ParameterValue;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public interface TemplateResource extends Resource<Template> {

  /**
   * Process a template reading parameter values from a {@link File} in json or yml format.
   *
   * @param f The specified {@link File}.
   * @return
   */
  KubernetesList process(File f);

  /**
   * Process a template reading parameter values from an {@link InputStream} in json or yml format.
   *
   * @param is The specified {@link InputStream}.
   * @return
   */
  KubernetesList process(InputStream is);

  /**
   * Process a template reading parameter values from am {@link Map}.
   *
   * @param map The specified {@link Map}.
   * @return
   */
  KubernetesList process(Map<String, String> map);

  /**
   * Process a template with the specified {@link ParameterValue}s.
   *
   * @param values The specified {@link ParameterValue}s.
   * @return
   */
  KubernetesList process(ParameterValue... values);

  /**
   * Process a template locally reading parameter values from a {@link File} in json or yml format.
   * This kind of processing is performed locally, without communicating with the server (e.g for generating values using
   * expressions).
   *
   * @param f The specified {@link File}.
   * @return
   */
  KubernetesList processLocally(File f);

  /**
   * Process a template locally reading parameter values from an {@link InputStream} in json or yml format.
   * This kind of processing is performed locally, without communicating with the server (e.g for generating values using
   * expressions).
   *
   * @param is The specified {@link InputStream}.
   * @return
   */
  KubernetesList processLocally(InputStream is);

  /**
   * Process a template locally reading parameter values from am {@link Map}.
   * This kind of processing is performed locally, without communicating with the server (e.g for generating values using
   * expressions).
   *
   * @param map The specified {@link Map}.
   * @return
   */
  KubernetesList processLocally(Map<String, String> map);

  /**
   * Process a template with the specified {@link ParameterValue}s.
   * This kind of processing is performed locally, without communicating with the server (e.g for generating values using
   * expressions).
   *
   * @param values The specified {@link ParameterValue}s.
   * @return
   */
  KubernetesList processLocally(ParameterValue... values);

}
