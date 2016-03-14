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
import io.fabric8.kubernetes.api.model.DoneableEndpoints;
import io.fabric8.kubernetes.api.model.Endpoints;
import io.fabric8.kubernetes.api.model.EndpointsBuilder;
import io.fabric8.kubernetes.api.model.EndpointsFluent;
import io.fabric8.kubernetes.api.model.EndpointsFluentImpl;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableEndpoints extends EndpointsFluentImpl<MockDoneableEndpoints> implements MockDoneable<Endpoints> {

  private interface DelegateInterface extends Doneable<Endpoints>, EndpointsFluent<DoneableEndpoints> {}
  private final Function<Endpoints, Endpoints> visitor = new Function<Endpoints, Endpoints>() {
    @Override
    public Endpoints apply(Endpoints item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableEndpoints() {
    super(new EndpointsBuilder().withNewMetadata().and().build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<Endpoints> done() {
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
  public Doneable<Endpoints> getDelegate() {
    return new DoneableEndpoints(new EndpointsBuilder(this).build(), visitor) {
      @Override
      public Endpoints done() {
        return delegate.done();
      }
    };
  }

}
