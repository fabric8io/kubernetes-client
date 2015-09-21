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

package io.fabric8.kubernetes.client.mock.impl;

import io.fabric8.kubernetes.api.model.DoneableKubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.dsl.ClientKubernetesListMixedOperation;
import io.fabric8.kubernetes.client.dsl.CreateGettable;
import io.fabric8.kubernetes.client.mock.MockKubernetesListNonNamesapceOperation;
import io.fabric8.kubernetes.client.mock.MockKubernetesListOperation;
import io.fabric8.kubernetes.client.mock.Mockable;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static io.fabric8.kubernetes.client.mock.util.MockUtils.getArgument;
import static org.easymock.EasyMock.expect;

public class MockKubernetesListOperationImpl<C extends Client>  implements
  MockKubernetesListNonNamesapceOperation,
  MockKubernetesListOperation,
  CreateGettable<KubernetesList, IExpectationSetters<KubernetesList>, DoneableKubernetesList>,
  Mockable {

  //Dummy interface to use for mocking.
  private interface KubernetesListDelegate<C extends Client>  extends ClientKubernetesListMixedOperation<C>,
    CreateGettable<KubernetesList,KubernetesList,DoneableKubernetesList> {
  }

  private final KubernetesListDelegate<C> delegate;
  private final Set<Mockable> nested = new LinkedHashSet<>();

  private MockKubernetesListOperationImpl loadedMockOp;
  private Map<IArgumentMatcher, MockKubernetesListOperationImpl> namespaceMap = new HashMap<>();

  public MockKubernetesListOperationImpl() {
    this(EasyMock.createMock(KubernetesListDelegate.class));
  }

  public MockKubernetesListOperationImpl(KubernetesListDelegate delegate) {
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

  public MockKubernetesListOperationImpl newInstance() {
    return new MockKubernetesListOperationImpl();
  }

  public KubernetesListDelegate getDelegate() {
    return delegate;
  }


  @Override
  public IExpectationSetters<KubernetesList> create(KubernetesList... item) {
    return expect(delegate.create(item));
  }


  @Override
  public DoneableKubernetesList createNew() {
    throw new UnsupportedOperationException("Mock client doesn't support inline create. Please use create(T item) instead");
  }

  @Override
  public CreateGettable<KubernetesList, IExpectationSetters<KubernetesList>, DoneableKubernetesList> load(InputStream input) {
    if (loadedMockOp == null) {
      loadedMockOp = newInstance();
    }
    expect(delegate.load(input)).andReturn(loadedMockOp.getDelegate()).anyTimes();
    nested.add(loadedMockOp);
    return loadedMockOp;
  }

  @Override
  public MockKubernetesListNonNamesapceOperation inNamespace(String namespace) {
    IArgumentMatcher matcher = getArgument(namespace);
    MockKubernetesListOperationImpl op = namespaceMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.inNamespace(namespace)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      namespaceMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public IExpectationSetters<KubernetesList> get() {
    return expect(delegate.get());
  }
}
