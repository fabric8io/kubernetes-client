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
import io.fabric8.kubernetes.api.model.extensions.DoneableDaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSet;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetBuilder;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetFluent;
import io.fabric8.kubernetes.api.model.extensions.DaemonSetFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableDaemonSet extends DaemonSetFluentImpl<MockDoneableDaemonSet> implements MockDoneable<DaemonSet> {
  private interface DelegateInterface extends Doneable<DaemonSet>, DaemonSetFluent<DoneableDaemonSet> {}
  private final Function<DaemonSet, DaemonSet> visitor = new Function<DaemonSet, DaemonSet>() {
    @Override
    public DaemonSet apply(DaemonSet item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableDaemonSet() {
    super(new DaemonSetBuilder()
      .withNewMetadata().endMetadata()
      .withNewSpec().endSpec()
      .withNewStatus().endStatus()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<DaemonSet> done() {
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
  public Doneable<DaemonSet> getDelegate() {
    return new DoneableDaemonSet(new DaemonSetBuilder(this).build(), visitor) {
      @Override
      public DaemonSet done() {
        return delegate.done();
      }
    };
  }
}
