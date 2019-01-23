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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.model.settings.DoneablePodPreset;
import io.fabric8.kubernetes.api.model.settings.PodPreset;
import io.fabric8.kubernetes.api.model.settings.PodPresetList;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.SettingsAPIGroupDSL;
import io.fabric8.kubernetes.client.dsl.internal.PodPresetOperationsImpl;
import okhttp3.OkHttpClient;

public class SettingsAPIGroupClient extends BaseClient implements SettingsAPIGroupDSL {
  public SettingsAPIGroupClient(OkHttpClient httpClient, final Config config) throws KubernetesClientException {
    super(httpClient, config);
  }
  @Override
  public MixedOperation<PodPreset, PodPresetList, DoneablePodPreset, Resource<PodPreset, DoneablePodPreset>> podPresets() {
    return new PodPresetOperationsImpl(httpClient, getConfiguration());
  }
}
