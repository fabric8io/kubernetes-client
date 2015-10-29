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

import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.ClientLoggableResource;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockLoggableResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneablePod;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import static org.easymock.EasyMock.expect;

public class MockPod<C extends Client>  extends BaseMockOperation<Pod, PodList, DoneablePod, MockDoneablePod,
  ClientLoggableResource<Pod, DoneablePod>,
  MockLoggableResource<Pod, MockDoneablePod, Boolean>>
  implements MockLoggableResource<Pod, MockDoneablePod, Boolean> {

  //Dummy interface to use for mocking.
  private interface PodDelegate
    extends ClientMixedOperation<Pod, PodList, DoneablePod, ClientRollableScallableResource<Pod, DoneablePod>>,
    ClientLoggableResource<Pod, DoneablePod> {

  }

  public MockPod() {
    super(EasyMock.createMock(PodDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockPod();
  }

  @Override
  public IExpectationSetters<String> getLog() {
    return expect(((ClientLoggableResource<Pod, DoneablePod>) getDelegate()).getLog());
  }

  @Override
  public IExpectationSetters<String> getLog(String id) {
    return expect(((ClientLoggableResource<Pod, DoneablePod>) getDelegate()).getLog(id));
  }

  @Override
  public IExpectationSetters<String> getLog(Boolean isPretty) {
    return expect(((ClientLoggableResource<Pod, DoneablePod>) getDelegate()).getLog(isPretty));
  }

  @Override
  public IExpectationSetters<String> getLog(String id, Boolean isPretty) {
    return expect(((ClientLoggableResource<Pod, DoneablePod>) getDelegate()).getLog(id, isPretty));
  }
}
