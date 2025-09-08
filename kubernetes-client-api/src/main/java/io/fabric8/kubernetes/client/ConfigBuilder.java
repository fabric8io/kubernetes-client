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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;

import java.util.Optional;

import static io.fabric8.kubernetes.client.Config.disableAutoConfig;

public class ConfigBuilder extends ConfigFluent<ConfigBuilder> implements VisitableBuilder<Config, ConfigBuilder> {
  /**
   * Note: differs from the typical generated builder - the fluent state is
   * preserved whole
   */
  public ConfigBuilder() {
    this.fluent = this;
  }

  /**
   * Note: differs from the typical generated builder - the fluent state is
   * preserved whole
   */
  public ConfigBuilder(ConfigFluent<?> fluent) {
    this.fluent = fluent;
  }

  public ConfigBuilder(ConfigFluent<?> fluent, Config instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConfigBuilder(Config instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }

  ConfigFluent<?> fluent;

  @Override
  public Config build() {
    // build the config state from the generated builder, then use that
    // to construct the full state
    SundrioConfig config = toSundrioConfig(fluent);
    return new Config(config, true);
  }

  public static SundrioConfig toSundrioConfig(SundrioConfigFluent<?> fluent) {
    SundrioConfigBuilder builder = new SundrioConfigBuilder();
    builder.fluent = fluent;
    SundrioConfig config = builder.build();
    config.setAutoConfigure(Optional.ofNullable(config.getAutoConfigure()).orElse(!disableAutoConfig()));
    return config;
  }
}
