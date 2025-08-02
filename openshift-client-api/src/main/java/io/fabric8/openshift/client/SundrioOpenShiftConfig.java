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

import io.fabric8.kubernetes.client.Config;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.Getter;
import lombok.Setter;

/**
 * Add new Openshift options here instead of {@link OpenShiftConfig}, then add the mapping logic
 * to additional properties in {@link OpenShiftConfig} and a new parameter to the {@link OpenShiftConfig} constructor
 */
@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", editableEnabled = false, refs = {
    @BuildableReference(Config.class) })
@Getter
@Setter
class SundrioOpenShiftConfig extends OpenShiftConfig {

  // for the fluent generation - mapped to additional properties
  private String oapiVersion;
  private String openShiftUrl;
  private Long buildTimeout;
  private Boolean disableApiGroupCheck; //If group hasn't been explicitly set.

}
