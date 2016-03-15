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

package io.fabric8.kubernetes.client.mock.impl;

import io.fabric8.kubernetes.api.model.extensions.DoneableConfigMap;
import io.fabric8.kubernetes.api.model.extensions.ConfigMap;
import io.fabric8.kubernetes.api.model.extensions.ConfigMapList;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableConfigMap;
import org.easymock.EasyMock;

public class MockConfigMap extends BaseMockOperation<ConfigMap, ConfigMapList, DoneableConfigMap, MockDoneableConfigMap,
  ClientResource<ConfigMap, DoneableConfigMap>, MockResource<ConfigMap, MockDoneableConfigMap, Boolean>>
  implements MockResource<ConfigMap, MockDoneableConfigMap, Boolean> {

  //Dummy interface to use for mocking.
  private interface ConfigMapDelegate
    extends ClientMixedOperation<ConfigMap, ConfigMapList, DoneableConfigMap,
    ClientRollableScallableResource<ConfigMap, DoneableConfigMap>>,
    ClientResource<ConfigMap, DoneableConfigMap> {

  }

  public MockConfigMap() {
    super(EasyMock.createMock(ConfigMapDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockConfigMap();
  }
}
