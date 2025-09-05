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

package io.fabric8.openshift.client;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.SundrioConfig;

public class OpenShiftConfigBuilder extends OpenShiftConfigFluent<OpenShiftConfigBuilder>
    implements VisitableBuilder<OpenShiftConfig, OpenShiftConfigBuilder> {
  public OpenShiftConfigBuilder() {
    this(new SundrioOpenShiftConfig());
  }

  public OpenShiftConfigBuilder(OpenShiftConfigFluent<?> fluent) {
    this(fluent, new SundrioOpenShiftConfig());
  }

  public OpenShiftConfigBuilder(OpenShiftConfigFluent<?> fluent, SundrioOpenShiftConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OpenShiftConfigBuilder(SundrioOpenShiftConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }

  OpenShiftConfigFluent<?> fluent;

  @Override
  public OpenShiftConfig build() {
    // build the config state from the generated builder, then use that
    // to construct the full state
    SundrioConfig config = ConfigBuilder.toSundrioConfig(fluent);
    OpenShiftConfig buildable = new OpenShiftConfig(config, fluent.getOpenShiftUrl(),
        fluent.getOapiVersion(), fluent.getBuildTimeout(), fluent.getDisableApiGroupCheck());
    return buildable;
  }

}