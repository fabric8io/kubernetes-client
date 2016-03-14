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
import io.fabric8.openshift.api.model.DoneableOAuthClient;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientBuilder;
import io.fabric8.openshift.api.model.OAuthClientFluent;
import io.fabric8.openshift.api.model.OAuthClientFluentImpl;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableOAuthClient extends OAuthClientFluentImpl<MockDoneableOAuthClient> implements MockDoneable<OAuthClient> {

  private interface DelegateInterface extends Doneable<OAuthClient>, OAuthClientFluent<DoneableOAuthClient> {}
  private final Function<OAuthClient, OAuthClient> visitor = new Function<OAuthClient, OAuthClient>() {
    @Override
    public OAuthClient apply(OAuthClient item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableOAuthClient() {
    super(new OAuthClientBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<OAuthClient> done() {
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
  public Doneable<OAuthClient> getDelegate() {
    return new DoneableOAuthClient(new OAuthClientBuilder(this).build(), visitor) {
      @Override
      public OAuthClient done() {
        return delegate.done();
      }
    };
  }
}
