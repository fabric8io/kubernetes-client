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

package io.fabric8.kubernetes.client.mock.impl.donable;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.extensions.DoneableHorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscaler;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscalerBuilder;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscalerFluent;
import io.fabric8.kubernetes.api.model.extensions.HorizontalPodAutoscalerFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;

import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableHorizontalPodAutoscaler extends HorizontalPodAutoscalerFluentImpl<MockDoneableHorizontalPodAutoscaler> implements MockDoneable<HorizontalPodAutoscaler> {
  private interface DelegateInterface extends Doneable<HorizontalPodAutoscaler>, HorizontalPodAutoscalerFluent<DoneableHorizontalPodAutoscaler> {}
  private final Function<HorizontalPodAutoscaler, HorizontalPodAutoscaler> visitor = new Function<HorizontalPodAutoscaler, HorizontalPodAutoscaler>() {
    @Override
    public HorizontalPodAutoscaler apply(HorizontalPodAutoscaler item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableHorizontalPodAutoscaler() {
    super(new HorizontalPodAutoscalerBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<HorizontalPodAutoscaler> done() {
    return EasyMock.expect(delegate.done());
  }

  @Override
  public Void replay() {
    EasyMock.replay(delegate);
    return null;
  }

  @Override
  public void verify() {
    EasyMock.verify(delegate);
  }

  @Override
  public Doneable<HorizontalPodAutoscaler> getDelegate() {
    return new DoneableHorizontalPodAutoscaler(new HorizontalPodAutoscalerBuilder(this).build(), visitor) {
      @Override
      public HorizontalPodAutoscaler done() {
        return delegate.done();
      }
    };
  }
}
