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
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.mock.Mockable;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.client.dsl.ClientSubjectAccessReviewOperation;
import io.fabric8.openshift.client.dsl.CreateableLocalSubjectAccessReview;
import io.fabric8.openshift.client.dsl.CreateableSubjectAccessReview;
import io.fabric8.openshift.client.mock.impl.doneables.MockDoneableSubjectAccessReviewResponse;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static io.fabric8.kubernetes.client.mock.util.MockUtils.getArgument;
import static org.easymock.EasyMock.expect;

public class MockSubjectAccessReview implements
  Createable<SubjectAccessReview, IExpectationSetters<SubjectAccessReviewResponse>, MockDoneableSubjectAccessReviewResponse>,
  Namespaceable<Createable<LocalSubjectAccessReview, IExpectationSetters<SubjectAccessReviewResponse>, MockDoneableSubjectAccessReviewResponse>>,
  Mockable {

  interface SubjectAccessReviewDelegate extends ClientSubjectAccessReviewOperation<CreateableSubjectAccessReview, CreateableLocalSubjectAccessReview>{}

  interface LocalSubjectAccessReviewDelegate extends Createable<LocalSubjectAccessReview, SubjectAccessReviewResponse, CreateableLocalSubjectAccessReview> {
  }

  private final SubjectAccessReviewDelegate delegate;
  private final Set<Mockable> nested = new LinkedHashSet<>();

  public MockSubjectAccessReview() {
    this(EasyMock.createMock(SubjectAccessReviewDelegate.class));
  }

  public MockSubjectAccessReview(SubjectAccessReviewDelegate delegate) {
    this.delegate = delegate;
  }

  private Map<IArgumentMatcher, MockLocalSubjectAccessReview> namespaceMap = new HashMap<>();

  public SubjectAccessReviewDelegate getDelegate() {
    return delegate;
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

  @Override
  public Createable<LocalSubjectAccessReview, IExpectationSetters<SubjectAccessReviewResponse>, MockDoneableSubjectAccessReviewResponse> inNamespace(String namespace) {
    IArgumentMatcher matcher = getArgument(namespace);
    MockLocalSubjectAccessReview op = namespaceMap.get(matcher);
    if (op == null) {
      op = new MockLocalSubjectAccessReview();
      expect(delegate.inNamespace(namespace)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      namespaceMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public IExpectationSetters<SubjectAccessReviewResponse> create(SubjectAccessReview... item) {
    return expect(delegate.create(item));
  }

  @Override
  public MockDoneableSubjectAccessReviewResponse createNew() {
    MockDoneableSubjectAccessReviewResponse mock = new MockDoneableSubjectAccessReviewResponse();
    try {
      expect(delegate.createNew()).andReturn((CreateableSubjectAccessReview) mock.getDelegate()).once();
    } catch (Throwable t) {
      throw new RuntimeException(t);
    }
    nested.add(mock);
    return mock;
  }

}
