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

import io.fabric8.kubernetes.api.model.extensions.DoneableIngress;
import io.fabric8.kubernetes.api.model.extensions.Ingress;
import io.fabric8.kubernetes.api.model.extensions.IngressList;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableIngress;
import org.easymock.EasyMock;

public class MockIngress extends BaseMockOperation<Ingress, IngressList, DoneableIngress, MockDoneableIngress,
  ClientResource<Ingress, DoneableIngress>, MockResource<Ingress, MockDoneableIngress, Boolean>>
  implements MockResource<Ingress, MockDoneableIngress, Boolean> {

  //Dummy interface to use for mocking.
  private interface IngressDelegate
    extends ClientMixedOperation<Ingress, IngressList, DoneableIngress,
    ClientRollableScallableResource<Ingress, DoneableIngress>>,
    ClientResource<Ingress, DoneableIngress> {

  }

  public MockIngress() {
    super(EasyMock.createMock(IngressDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockIngress();
  }
}
