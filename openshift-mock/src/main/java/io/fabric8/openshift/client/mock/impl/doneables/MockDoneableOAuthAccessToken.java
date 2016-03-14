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
import io.fabric8.openshift.api.model.DoneableOAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenBuilder;
import io.fabric8.openshift.api.model.OAuthAccessTokenFluent;
import io.fabric8.openshift.api.model.OAuthAccessTokenFluentImpl;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableOAuthAccessToken extends OAuthAccessTokenFluentImpl<MockDoneableOAuthAccessToken> implements MockDoneable<OAuthAccessToken> {

  private interface DelegateInterface extends Doneable<OAuthAccessToken>, OAuthAccessTokenFluent<DoneableOAuthAccessToken> {}
  private final Function<OAuthAccessToken, OAuthAccessToken> visitor = new Function<OAuthAccessToken, OAuthAccessToken>() {
    @Override
    public OAuthAccessToken apply(OAuthAccessToken pod) {return pod;}
  };

  private final DelegateInterface delegate;

  public MockDoneableOAuthAccessToken() {
    super(new OAuthAccessTokenBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<OAuthAccessToken> done() {
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
  public Doneable<OAuthAccessToken> getDelegate() {
    return new DoneableOAuthAccessToken(new OAuthAccessTokenBuilder(this).build(), visitor) {
      @Override
      public OAuthAccessToken done() {
        return delegate.done();
      }
    };
  }
}
