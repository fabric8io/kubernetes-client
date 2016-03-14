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

package io.fabric8.openshift.client.mock.impl.doneables;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import io.fabric8.openshift.api.model.DoneablePolicy;
import io.fabric8.openshift.api.model.Policy;
import io.fabric8.openshift.api.model.PolicyBuilder;
import io.fabric8.openshift.api.model.PolicyFluent;
import io.fabric8.openshift.api.model.PolicyFluentImpl;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneablePolicy extends PolicyFluentImpl<MockDoneablePolicy> implements MockDoneable<Policy> {

  private interface DelegateInterface extends Doneable<Policy>, PolicyFluent<DoneablePolicy> {}
  private final Function<Policy, Policy> visitor = new Function<Policy, Policy>() {
    @Override
    public Policy apply(Policy item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneablePolicy() {
    super(new PolicyBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<Policy> done() {
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
  public Doneable<Policy> getDelegate() {
    return new DoneablePolicy(new PolicyBuilder(this).build(), visitor) {
      @Override
      public Policy done() {
        return delegate.done();
      }
    };
  }
}
