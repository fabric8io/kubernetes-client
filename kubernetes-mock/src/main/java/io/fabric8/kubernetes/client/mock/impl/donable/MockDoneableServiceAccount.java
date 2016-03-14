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
import io.fabric8.kubernetes.api.model.DoneableServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccount;
import io.fabric8.kubernetes.api.model.ServiceAccountBuilder;
import io.fabric8.kubernetes.api.model.ServiceAccountFluent;
import io.fabric8.kubernetes.api.model.ServiceAccountFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableServiceAccount extends ServiceAccountFluentImpl<MockDoneableServiceAccount> implements MockDoneable<ServiceAccount> {

  private interface DelegateInterface extends Doneable<ServiceAccount>, ServiceAccountFluent<DoneableServiceAccount> {}
  private final Function<ServiceAccount, ServiceAccount> visitor = new Function<ServiceAccount, ServiceAccount>() {
    @Override
    public ServiceAccount apply(ServiceAccount item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableServiceAccount() {
    super(new ServiceAccountBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<ServiceAccount> done() {
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
  public Doneable<ServiceAccount> getDelegate() {
    return new DoneableServiceAccount(new ServiceAccountBuilder(this).build(), visitor) {
      @Override
      public ServiceAccount done() {
        return delegate.done();
      }
    };
  }
}
