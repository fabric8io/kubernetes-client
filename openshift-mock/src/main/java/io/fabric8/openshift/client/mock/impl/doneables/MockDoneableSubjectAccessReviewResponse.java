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
import io.fabric8.openshift.api.model.DoneableSubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponseFluent;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponseFluentImpl;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

public class MockDoneableSubjectAccessReviewResponse extends SubjectAccessReviewResponseFluentImpl<MockDoneableSubjectAccessReviewResponse> implements MockDoneable<SubjectAccessReviewResponse> {

  private interface DelegateInterface extends Doneable<SubjectAccessReviewResponse>, SubjectAccessReviewResponseFluent<DoneableSubjectAccessReviewResponse> {}

  private final Function<SubjectAccessReviewResponse, SubjectAccessReviewResponse> visitor = new Function<SubjectAccessReviewResponse, SubjectAccessReviewResponse>() {
    @Override
    public SubjectAccessReviewResponse apply(SubjectAccessReviewResponse item) {return item;}
  };

  private final DelegateInterface delegate;

  public MockDoneableSubjectAccessReviewResponse()
  {
    super(new SubjectAccessReviewResponse());
    this.delegate = EasyMock.createMock(DelegateInterface.class);
  }

  @Override
  public IExpectationSetters<SubjectAccessReviewResponse> done() {
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
  public Doneable<SubjectAccessReviewResponse> getDelegate() {
    return new DoneableSubjectAccessReviewResponse(new SubjectAccessReviewResponse(), visitor) {
      @Override
      public SubjectAccessReviewResponse done() {
        return delegate.done();
      }
    };
  }
}
