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
import io.fabric8.openshift.api.model.DoneableRoute;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteBuilder;
import io.fabric8.openshift.api.model.RouteFluent;
import io.fabric8.openshift.api.model.RouteFluentImpl;
import io.fabric8.openshift.api.model.RouteStatus;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableRoute extends RouteFluentImpl<MockDoneableRoute> implements MockDoneable<Route> {

  private interface DelegateInterface extends Doneable<Route>, RouteFluent<DoneableRoute> {}
  private final Function<Route, Route> visitor = new Function<Route, Route>() {
    @Override
    public Route apply(Route item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableRoute() {
    super(new RouteBuilder()
      .withNewMetadata().endMetadata()
      .withNewSpec().endSpec()
      .withStatus(new RouteStatus())
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<Route> done() {
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
  public Doneable<Route> getDelegate() {
    return new DoneableRoute(new RouteBuilder(this).build(), visitor) {
      @Override
      public Route done() {
        return delegate.done();
      }
    };
  }
}
