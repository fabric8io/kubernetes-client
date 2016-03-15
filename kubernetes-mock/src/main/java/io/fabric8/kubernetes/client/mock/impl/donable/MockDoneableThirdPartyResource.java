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
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResource;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceBuilder;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceFluent;
import io.fabric8.kubernetes.api.model.extensions.ThirdPartyResourceFluentImpl;
import io.fabric8.kubernetes.api.model.extensions.DoneableThirdPartyResource;
import io.fabric8.kubernetes.client.mock.MockDoneable;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableThirdPartyResource extends ThirdPartyResourceFluentImpl<MockDoneableThirdPartyResource> implements MockDoneable<ThirdPartyResource> {
  private interface DelegateInterface extends Doneable<ThirdPartyResource>, ThirdPartyResourceFluent<DoneableThirdPartyResource> {}
  private final Function<ThirdPartyResource, ThirdPartyResource> visitor = new Function<ThirdPartyResource, ThirdPartyResource>() {
    @Override
    public ThirdPartyResource apply(ThirdPartyResource item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableThirdPartyResource() {
    super(new ThirdPartyResourceBuilder()
      .withNewMetadata().endMetadata()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface .class);
  }

  @Override
  public IExpectationSetters<ThirdPartyResource> done() {
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
  public Doneable<ThirdPartyResource> getDelegate() {
    return new DoneableThirdPartyResource(new ThirdPartyResourceBuilder(this).build(), visitor) {
      @Override
      public ThirdPartyResource done() {
        return delegate.done();
      }
    };
  }
}
