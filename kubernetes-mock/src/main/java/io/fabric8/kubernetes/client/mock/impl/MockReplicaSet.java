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

import io.fabric8.kubernetes.api.model.extensions.DoneableReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSet;
import io.fabric8.kubernetes.api.model.extensions.ReplicaSetList;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.dsl.ImageEditReplacePatchable;
import io.fabric8.kubernetes.client.dsl.Rollable;
import io.fabric8.kubernetes.client.dsl.Scaleable;
import io.fabric8.kubernetes.client.dsl.TimeoutImageEditReplacePatchable;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockRollableScaleableResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableReplicaSet;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import java.util.concurrent.TimeUnit;

import static org.easymock.EasyMock.expect;

public class MockReplicaSet extends BaseMockOperation<ReplicaSet, ReplicaSetList, DoneableReplicaSet,
  MockDoneableReplicaSet, ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet>,
  MockRollableScaleableResource<ReplicaSet, MockDoneableReplicaSet, Boolean>>
  implements MockRollableScaleableResource<ReplicaSet, MockDoneableReplicaSet, Boolean>,
  TimeoutImageEditReplacePatchable<ReplicaSet, IExpectationSetters<ReplicaSet>, MockDoneableReplicaSet> {

  private MockReplicaSet rolling;

  @Override
  public TimeoutImageEditReplacePatchable<ReplicaSet, IExpectationSetters<ReplicaSet>, MockDoneableReplicaSet> rolling() {
    if (rolling == null) {
      rolling = (MockReplicaSet) newInstance();
      expect(((Rollable<?>)getDelegate()).rolling())
        .andReturn(rolling.getDelegate())
        .anyTimes();
      getNested().add(rolling);
    }
    return rolling;
  }

  @Override
  public IExpectationSetters<ReplicaSet> scale(int count) {
    return expect(((Scaleable<ReplicaSet>) getDelegate()).scale(count));
  }

  @Override
  public IExpectationSetters<ReplicaSet> scale(int count, boolean wait) {
    return expect(((Scaleable<ReplicaSet>) getDelegate()).scale(count, wait));
  }

  @Override
  public IExpectationSetters<ReplicaSet> updateImage(String image) {
    return expect(((ImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet>) getDelegate()).updateImage(image));
  }

  @Override
  public ImageEditReplacePatchable<ReplicaSet, IExpectationSetters<ReplicaSet>, MockDoneableReplicaSet> withTimeout(long timeout, TimeUnit unit) {
    return null;
  }

  @Override
  public ImageEditReplacePatchable<ReplicaSet, IExpectationSetters<ReplicaSet>, MockDoneableReplicaSet> withTimeoutInMillis(long timeoutInMillis) {
    return null;
  }

  //Dummy interface to use for mocking.
  private interface ReplicaSetDelegate
    extends ClientMixedOperation<ReplicaSet, ReplicaSet, DoneableReplicaSet, ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet>>,
    ClientRollableScallableResource<ReplicaSet, DoneableReplicaSet>,
    TimeoutImageEditReplacePatchable<ReplicaSet, ReplicaSet, DoneableReplicaSet> {

  }

  public MockReplicaSet() {
    super(EasyMock.createMock(ReplicaSetDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockReplicaSet();
  }
}
