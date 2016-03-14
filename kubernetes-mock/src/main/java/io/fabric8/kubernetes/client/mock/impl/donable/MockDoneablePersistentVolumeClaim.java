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
import io.fabric8.kubernetes.api.model.DoneablePersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimFluent;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneablePersistentVolumeClaim extends PersistentVolumeClaimFluentImpl<MockDoneablePersistentVolumeClaim> implements MockDoneable<PersistentVolumeClaim> {

  private interface DelegateInterface extends Doneable<PersistentVolumeClaim>, PersistentVolumeClaimFluent<DoneablePersistentVolumeClaim> {}
  private final Function<PersistentVolumeClaim, PersistentVolumeClaim> visitor = new Function<PersistentVolumeClaim, PersistentVolumeClaim>() {
    @Override
    public PersistentVolumeClaim apply(PersistentVolumeClaim item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneablePersistentVolumeClaim() {
    super(new PersistentVolumeClaimBuilder()
      .withNewMetadata().endMetadata()
      .withNewSpec().endSpec()
      .withNewStatus().endStatus()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<PersistentVolumeClaim> done() {
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
  public Doneable<PersistentVolumeClaim> getDelegate() {
    return new DoneablePersistentVolumeClaim(new PersistentVolumeClaimBuilder(this).build(), visitor) {
      @Override
      public PersistentVolumeClaim done() {
        return delegate.done();
      }
    };
  }
}
