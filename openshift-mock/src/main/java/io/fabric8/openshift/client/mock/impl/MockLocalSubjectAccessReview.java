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

package io.fabric8.openshift.client.mock.impl;

import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.mock.Mockable;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.client.dsl.CreateableLocalSubjectAccessReview;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableSubjectAccessReviewResponse;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import java.util.HashSet;
import java.util.Set;

import static org.easymock.EasyMock.expect;

public class MockLocalSubjectAccessReview implements
  Createable<LocalSubjectAccessReview, IExpectationSetters<SubjectAccessReviewResponse>, MockDoneableSubjectAccessReviewResponse>,
  Mockable {

  private final Set<Mockable> nested = new HashSet<Mockable>();
  private final MockSubjectAccessReview.LocalSubjectAccessReviewDelegate delegate;

  public MockLocalSubjectAccessReview() {
    this(EasyMock.createMock(MockSubjectAccessReview.LocalSubjectAccessReviewDelegate.class));
  }

  public MockLocalSubjectAccessReview(MockSubjectAccessReview.LocalSubjectAccessReviewDelegate delegate) {
    this.delegate = delegate;
  }


  public Void replay() {
    for (Mockable mockable : nested) {
      mockable.replay();
    }
    EasyMock.replay(delegate);
    return null;
  }

  public void verify() {
    for (Mockable mockable : nested) {
      mockable.verify();
    }
    EasyMock.verify(delegate);
  }

  public MockSubjectAccessReview.LocalSubjectAccessReviewDelegate getDelegate() {
    return delegate;
  }

  @Override
  public IExpectationSetters<SubjectAccessReviewResponse> create(LocalSubjectAccessReview... item) {
    return expect(delegate.create(item));
  }

  @Override
  public MockDoneableSubjectAccessReviewResponse createNew() {
    MockDoneableSubjectAccessReviewResponse mock = new MockDoneableSubjectAccessReviewResponse();
    try {
      expect(delegate.createNew()).andReturn((CreateableLocalSubjectAccessReview) mock.getDelegate()).once();
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }
    nested.add(mock);
    return mock;
  }
}
