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

import io.fabric8.kubernetes.api.model.extensions.DoneableDeployment;
import io.fabric8.kubernetes.api.model.extensions.Deployment;
import io.fabric8.kubernetes.api.model.extensions.DeploymentList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.ClientLoggableResource;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockLoggableResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableDeployment;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import static org.easymock.EasyMock.expect;

public class MockDeployment<C extends Client>  extends BaseMockOperation<Deployment, DeploymentList, DoneableDeployment, MockDoneableDeployment,
  ClientLoggableResource<Deployment, DoneableDeployment>,
  MockLoggableResource<Deployment, MockDoneableDeployment, Boolean>>
  implements MockLoggableResource<Deployment, MockDoneableDeployment, Boolean> {

  //Dummy interface to use for mocking.
  private interface DeploymentDelegate
    extends ClientMixedOperation<Deployment, DeploymentList, DoneableDeployment, ClientRollableScallableResource<Deployment, DoneableDeployment>>,
    ClientLoggableResource<Deployment, DoneableDeployment> {

  }

  public MockDeployment() {
    super(EasyMock.createMock(DeploymentDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockDeployment();
  }

  @Override
  public IExpectationSetters<String> getLog() {
    return expect(((ClientLoggableResource<Deployment, DoneableDeployment>) getDelegate()).getLog());
  }

  @Override
  public IExpectationSetters<String> getLog(String id) {
    return expect(((ClientLoggableResource<Deployment, DoneableDeployment>) getDelegate()).getLog(id));
  }

  @Override
  public IExpectationSetters<String> getLog(Boolean isPretty) {
    return expect(((ClientLoggableResource<Deployment, DoneableDeployment>) getDelegate()).getLog(isPretty));
  }

  @Override
  public IExpectationSetters<String> getLog(String id, Boolean isPretty) {
    return expect(((ClientLoggableResource<Deployment, DoneableDeployment>) getDelegate()).getLog(id, isPretty));
  }
}
