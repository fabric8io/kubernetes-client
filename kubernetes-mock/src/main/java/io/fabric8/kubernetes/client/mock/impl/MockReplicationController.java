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
import io.fabric8.kubernetes.client.dsl.ImageEditReplaceable;
import io.fabric8.kubernetes.client.dsl.Rollable;
import io.fabric8.kubernetes.client.dsl.RollableScallableClientResource;
import io.fabric8.kubernetes.client.dsl.Scaleable;
import io.fabric8.kubernetes.client.dsl.internal.ReplicationControllerOperationsImpl;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockRollableScaleableResource;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import static org.easymock.EasyMock.expect;

public class MockReplicationController extends BaseMockOperation<KubernetesClient, ReplicationController, ReplicationControllerList, DoneableReplicationController,
  RollableScallableClientResource<ReplicationController, DoneableReplicationController>,
  MockRollableScaleableResource<ReplicationController, DoneableReplicationController, Boolean>>
  implements MockRollableScaleableResource<ReplicationController, DoneableReplicationController, Boolean>,
  ImageEditReplaceable<ReplicationController, IExpectationSetters<ReplicationController>, DoneableReplicationController> {


  private MockReplicationController rolling;

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

  @Override
  public IExpectationSetters<ReplicationController> updateImage(String image) {
    return expect(((ImageEditReplaceable<ReplicationController, ReplicationController, DoneableReplicationController>) getDelegate()).updateImage(image));
  }

  @Override
  public ImageEditReplaceable<ReplicationController, IExpectationSetters<ReplicationController>, DoneableReplicationController> rolling() {
    if (rolling == null) {
      rolling = (MockReplicationController) newInstance();
      expect(((Rollable<ReplicationController, ReplicationController, DoneableReplicationController>) getDelegate()).rolling())
        .andReturn((ImageEditReplaceable<ReplicationController, ReplicationController, DoneableReplicationController>) rolling.getDelegate())
        .anyTimes();
      getNested().add(rolling);
    }
    return rolling;
  }
}

