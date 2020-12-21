/**
 * Copyright 2018 The original authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.dekorate.crd.generator;

import java.util.Map;

import io.dekorate.Generator;
import io.dekorate.Session;
import io.dekorate.config.ConfigurationSupplier;
import io.dekorate.crd.config.CustomResourceConfig;
import io.dekorate.crd.handler.CustomResourceHandler;

public interface CustomResourceGenerator extends Generator {

  @Override
  default void addAnnotationConfiguration(Map map) {
  }

  @Override
  default void addPropertyConfiguration(Map map) {
  }

  default void on(ConfigurationSupplier<CustomResourceConfig> config) {
    Session session = getSession();
    session.configurators().add(config);
    session.handlers().add(new CustomResourceHandler(session.resources()));
  }
}
