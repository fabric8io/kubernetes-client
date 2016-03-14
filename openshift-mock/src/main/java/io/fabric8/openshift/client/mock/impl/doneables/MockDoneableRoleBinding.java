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
import io.fabric8.openshift.api.model.DoneableRoleBinding;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingBuilder;
import io.fabric8.openshift.api.model.RoleBindingFluent;
import io.fabric8.openshift.api.model.RoleBindingFluentImpl;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableRoleBinding extends RoleBindingFluentImpl<MockDoneableRoleBinding> implements MockDoneable<RoleBinding> {

  private interface DelegateInterface extends Doneable<RoleBinding>, RoleBindingFluent<DoneableRoleBinding> {}
  private final Function<RoleBinding, RoleBinding> visitor = new Function<RoleBinding, RoleBinding>() {
    @Override
    public RoleBinding apply(RoleBinding item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableRoleBinding() {
    super(new RoleBindingBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<RoleBinding> done() {
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
  public Doneable<RoleBinding> getDelegate() {
    return new DoneableRoleBinding(new RoleBindingBuilder(this).build(), visitor) {
      @Override
      public RoleBinding done() {
        return delegate.done();
      }
    };
  }
}
