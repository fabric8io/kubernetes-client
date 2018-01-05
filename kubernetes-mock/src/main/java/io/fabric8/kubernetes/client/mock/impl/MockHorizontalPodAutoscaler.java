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

import io.fabric8.kubernetes.api.model.DoneableHorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.HorizontalPodAutoscalerList;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.ClientRollableScallableResource;
import io.fabric8.kubernetes.client.mock.BaseMockOperation;
import io.fabric8.kubernetes.client.mock.MockResource;
import io.fabric8.kubernetes.client.mock.impl.donable.MockDoneableHorizontalPodAutoscaler;

import org.easymock.EasyMock;

public class MockHorizontalPodAutoscaler extends BaseMockOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, DoneableHorizontalPodAutoscaler, MockDoneableHorizontalPodAutoscaler,
  ClientResource<HorizontalPodAutoscaler, DoneableHorizontalPodAutoscaler>, MockResource<HorizontalPodAutoscaler, MockDoneableHorizontalPodAutoscaler, Boolean>>
  implements MockResource<HorizontalPodAutoscaler, MockDoneableHorizontalPodAutoscaler, Boolean> {

  //Dummy interface to use for mocking.
  private interface HorizontalPodAutoscalerDelegate
    extends ClientMixedOperation<HorizontalPodAutoscaler, HorizontalPodAutoscalerList, DoneableHorizontalPodAutoscaler,
    ClientRollableScallableResource<HorizontalPodAutoscaler, DoneableHorizontalPodAutoscaler>>,
    ClientResource<HorizontalPodAutoscaler, DoneableHorizontalPodAutoscaler> {

  }

  public MockHorizontalPodAutoscaler() {
    super(EasyMock.createMock(HorizontalPodAutoscalerDelegate.class));
  }

  @Override
  public BaseMockOperation newInstance() {
    return new MockHorizontalPodAutoscaler();
  }
}
