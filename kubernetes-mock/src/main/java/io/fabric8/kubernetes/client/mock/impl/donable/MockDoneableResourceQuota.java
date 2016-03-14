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
import io.fabric8.kubernetes.api.model.DoneableResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuota;
import io.fabric8.kubernetes.api.model.ResourceQuotaBuilder;
import io.fabric8.kubernetes.api.model.ResourceQuotaFluent;
import io.fabric8.kubernetes.api.model.ResourceQuotaFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableResourceQuota extends ResourceQuotaFluentImpl<MockDoneableResourceQuota> implements MockDoneable<ResourceQuota> {


  private interface DelegateInterface extends Doneable<ResourceQuota>, ResourceQuotaFluent<DoneableResourceQuota> {}
  private final Function<ResourceQuota, ResourceQuota> visitor = new Function<ResourceQuota, ResourceQuota>() {
    @Override
    public ResourceQuota apply(ResourceQuota item) { return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableResourceQuota() {
    super(new ResourceQuotaBuilder()
      .withNewMetadata().endMetadata()
      .withNewSpec().endSpec()
      .withNewStatus().endStatus()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<ResourceQuota> done() {
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
  public Doneable<ResourceQuota> getDelegate() {
    return new DoneableResourceQuota(new ResourceQuotaBuilder(this).build(), visitor) {
      @Override
      public ResourceQuota done() {
        return delegate.done();
      }
    };
  }

}
