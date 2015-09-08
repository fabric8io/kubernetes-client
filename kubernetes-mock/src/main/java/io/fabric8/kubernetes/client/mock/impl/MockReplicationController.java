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

import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.ReplicationControllerClientResource;
import io.fabric8.kubernetes.client.dsl.Scaleable;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockScaleableResource;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import static org.easymock.EasyMock.expect;

public class MockReplicationController extends BaseMockOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController,
  ReplicationControllerClientResource<ReplicationController, DoneableReplicationController>,
  MockScaleableResource<ReplicationController, DoneableReplicationController, Boolean>>
  implements MockScaleableResource<ReplicationController, DoneableReplicationController, Boolean> {


  public MockReplicationController() {
    super(EasyMock.createMock(ReplicationControllerOperationsImpl.class));
  }

  @Override
  public IExpectationSetters<ReplicationController> scale(int count) {
    return expect(((Scaleable<ReplicationController>) getDelegate()).scale(count));
  }

  @Override
  public IExpectationSetters<ReplicationController> scale(int count, boolean wait) {
    return expect(((Scaleable<ReplicationController>) getDelegate()).scale(count, wait));
  }


  public BaseMockOperation newInstance() {
    return new MockReplicationController();
  }

}

