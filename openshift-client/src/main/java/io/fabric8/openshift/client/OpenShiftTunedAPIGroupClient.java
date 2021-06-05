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
package io.fabric8.openshift.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.openshift.api.model.tuned.v1.Profile;
import io.fabric8.openshift.api.model.tuned.v1.ProfileList;
import io.fabric8.openshift.api.model.tuned.v1.Tuned;
import io.fabric8.openshift.api.model.tuned.v1.TunedList;
import io.fabric8.openshift.client.dsl.OpenShiftTunedAPIGroupDSL;
import io.fabric8.openshift.client.dsl.internal.tuned.ProfileOperationsImpl;
import io.fabric8.openshift.client.dsl.internal.tuned.TunedOperationsImpl;
import okhttp3.OkHttpClient;

public class OpenShiftTunedAPIGroupClient extends BaseClient implements OpenShiftTunedAPIGroupDSL {
  public OpenShiftTunedAPIGroupClient() {
    super();
  }

  public OpenShiftTunedAPIGroupClient(OkHttpClient httpClient, final Config config) {
    super(httpClient, config);
  }

  @Override
  public MixedOperation<Tuned, TunedList, Resource<Tuned>> tuneds() {
    return new TunedOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }

  @Override
  public MixedOperation<Profile, ProfileList, Resource<Profile>> profiles() {
    return new ProfileOperationsImpl(httpClient, OpenShiftConfig.wrap(getConfiguration()));
  }
}
