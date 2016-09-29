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
import io.fabric8.openshift.api.model.DoneableImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTag;
import io.fabric8.openshift.api.model.ImageStreamTagBuilder;
import io.fabric8.openshift.api.model.ImageStreamTagFluent;
import io.fabric8.openshift.api.model.ImageStreamTagFluentImpl;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableImageStreamTag extends ImageStreamTagFluentImpl<MockDoneableImageStreamTag> implements MockDoneable<ImageStreamTag> {

  private interface DelegateInterface extends Doneable<ImageStreamTag>, ImageStreamTagFluent<DoneableImageStreamTag> {}
  private final Function<ImageStreamTag, ImageStreamTag> visitor = new Function<ImageStreamTag, ImageStreamTag>() {
    @Override
    public ImageStreamTag apply(ImageStreamTag item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableImageStreamTag() {
    super(new ImageStreamTagBuilder()
      .withNewMetadata()
      .endMetadata()
      .withNewTag().endTag()
      .build());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<ImageStreamTag> done() {
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
  public Doneable<ImageStreamTag> getDelegate() {
    return new DoneableImageStreamTag(new ImageStreamTagBuilder(this).build(), visitor) {
      @Override
      public ImageStreamTag done() {
        return delegate.done();
      }
    };
  }
}
