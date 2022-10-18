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
package io.fabric8.openshift.client.impl;

import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.extension.ClientAdapter;
import io.fabric8.openshift.api.model.tuned.v1.Profile;
import io.fabric8.openshift.api.model.tuned.v1.ProfileList;
import io.fabric8.openshift.api.model.tuned.v1.Tuned;
import io.fabric8.openshift.api.model.tuned.v1.TunedList;
import io.fabric8.openshift.client.dsl.OpenShiftTunedAPIGroupDSL;

public class OpenShiftTunedAPIGroupClient extends ClientAdapter<OpenShiftTunedAPIGroupClient>
    implements OpenShiftTunedAPIGroupDSL {

  @Override
  public MixedOperation<Tuned, TunedList, Resource<Tuned>> tuneds() {
    return resources(Tuned.class, TunedList.class);
  }

  @Override
  public MixedOperation<Profile, ProfileList, Resource<Profile>> profiles() {
    return resources(Profile.class, ProfileList.class);
  }

  @Override
  public OpenShiftTunedAPIGroupClient newInstance() {
    return new OpenShiftTunedAPIGroupClient();
  }
}
