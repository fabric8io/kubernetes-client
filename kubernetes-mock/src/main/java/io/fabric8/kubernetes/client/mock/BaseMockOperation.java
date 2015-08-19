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

package io.fabric8.kubernetes.client.mock;

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ClientMixedOperation;
import io.fabric8.kubernetes.client.dsl.ClientNonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.ClientResource;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeleteable;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;
import org.easymock.IExpectationSetters;
import org.easymock.internal.matchers.And;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static io.fabric8.kubernetes.client.mock.util.MockUtils.getArgument;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;

public class BaseMockOperation<C extends KubernetesClient, T, L extends KubernetesResourceList, D extends Doneable<T>,
  R extends ClientResource<T, D>,
  E extends Resource<T, IExpectationSetters<T>, D, IExpectationSetters<Boolean>>>
  implements MockOperation<T, L, D, E>, Mockable {

  private final ClientMixedOperation<C, T, L, D, R> delegate;
  private final Set<Mockable> nested = new LinkedHashSet<>();

  public BaseMockOperation() {
    this(EasyMock.createMock(ClientMixedOperation.class));
  }

  public BaseMockOperation(ClientMixedOperation delegate) {
    this.delegate = delegate;
  }


  private Map<IArgumentMatcher, BaseMockOperation> nameMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> namespaceMap = new HashMap<>();

  private Map<IArgumentMatcher, BaseMockOperation> labelMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> labelNotMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> labelsMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> labelsNotMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> labelInsMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> labelNotInMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> fieldMap = new HashMap<>();
  private Map<IArgumentMatcher, BaseMockOperation> filedsMap = new HashMap<>();

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

  public BaseMockOperation newInstance() {
    return new BaseMockOperation();
  }

  public ClientMixedOperation<C, T, L, D, R> getDelegate() {
    return delegate;
  }

  @Override
  public IExpectationSetters<T> create(T item) {
    return expect(delegate.create(eq(item)));
  }

  @Override
  public D createNew() {
    throw new UnsupportedOperationException("Mock client doesn't support inline create. Please use create(T item) instead");
  }

  @Override
  public IExpectationSetters<Boolean> delete() {
    return expect(delegate.delete(true));
  }

  @Override
  public IExpectationSetters<Boolean> delete(boolean cascade) {
    return expect(delegate.delete(cascade));
  }

  @Override
  public D edit() {
    return edit(true);
  }

  @Override
  public D edit(boolean cascade) {
    throw new UnsupportedOperationException("Mock client doesn't support inline edit. Please use replace(T item) instead.");
  }

  @Override
  public E withName(String name) {
    IArgumentMatcher matcher = getArgument(name);
    BaseMockOperation<C, T, L, D, R, E> op = nameMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withName(name)).andReturn((R) op.getDelegate()).anyTimes();
      nested.add(op);
      nameMap.put(matcher, op);
    }
    return (E) op;
  }

  @Override
  public MockNonNamespaceOperation<T, L, D, E> inNamespace(String namespace) {
    IArgumentMatcher matcher = getArgument(namespace);
    BaseMockOperation<C, T, L, D, R, E> op = namespaceMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.inNamespace(namespace)).andReturn((ClientNonNamespaceOperation<C, T, L, D, R>) op.getDelegate()).anyTimes();
      nested.add(op);
      namespaceMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public IExpectationSetters<T> update(T item) {
    return replace(item);
  }

  @Override
  public IExpectationSetters<T> update(T item, boolean cascade) {
    return replace(item, cascade);
  }

  @Override
  public IExpectationSetters<T> replace(T item) {
    return replace(item, true);
  }

  @Override
  public IExpectationSetters<T> replace(T item, boolean cascade) {
    return null;
  }

  @Override
  public IExpectationSetters<T> get() {
    return expect(delegate.get());
  }

  @Override
  public Watch watch(Watcher<IExpectationSetters<T>> watcher) throws KubernetesClientException {
    return watch(null, watcher);
  }

  @Override
  public Watch watch(String resourceVersion, Watcher<IExpectationSetters<T>> watcher) throws KubernetesClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withLabels(Map<String, String> l) {
    IArgumentMatcher matcher = getArgument(l);
    BaseMockOperation<C, T, L, D, R, E> op = labelsMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withLabels(l)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      labelsMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withoutLabels(Map<String, String> l) {
    IArgumentMatcher matcher = getArgument(l);
    BaseMockOperation<C, T, L, D, R, E> op = labelsNotMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withoutLabels(l)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      labelsNotMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withLabelIn(String key, String... values) {
    IArgumentMatcher keyMatcher = getArgument(key);
    IArgumentMatcher valueMatcher = getArgument(values);
    IArgumentMatcher matcher = new And(Arrays.asList(keyMatcher, valueMatcher));

    BaseMockOperation<C, T, L, D, R, E> op = labelInsMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withLabelIn(key, values)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      labelInsMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withLabelNotIn(String key, String... values) {
    IArgumentMatcher keyMatcher = getArgument(key);
    IArgumentMatcher valueMatcher = getArgument(values);
    IArgumentMatcher matcher = new And(Arrays.asList(keyMatcher, valueMatcher));

    BaseMockOperation<C, T, L, D, R, E> op = labelNotInMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withLabelNotIn(key, values)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      labelNotInMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withLabel(String key, String value) {
    IArgumentMatcher keyMatcher = getArgument(key);
    IArgumentMatcher valueMatcher = getArgument(value);
    IArgumentMatcher matcher = new And(Arrays.asList(keyMatcher, valueMatcher));

    BaseMockOperation<C, T, L, D, R, E> op = labelMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withLabel(key, value)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      labelMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withoutLabel(String key, String value) {
    IArgumentMatcher keyMatcher = getArgument(key);
    IArgumentMatcher valueMatcher = getArgument(value);
    IArgumentMatcher matcher = new And(Arrays.asList(keyMatcher, valueMatcher));

    BaseMockOperation<C, T, L, D, R, E> op = labelNotMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withoutLabel(key, value)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      labelNotMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withFields(Map<String, String> f) {
    IArgumentMatcher matcher = getArgument(f);
    BaseMockOperation<C, T, L, D, R, E> op = filedsMap.get(matcher);
    if (op == null) {
      op = newInstance();
      expect(delegate.withFields(f)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      filedsMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>> withField(String key, String value) {
    IArgumentMatcher keyMatcher = getArgument(key);
    IArgumentMatcher valueMatcher = getArgument(value);
    IArgumentMatcher matcher = new And(Arrays.asList(keyMatcher, valueMatcher));

    BaseMockOperation<C, T, L, D, R, E> op = fieldMap.get(matcher);
    if (op == null) {
      op = new BaseMockOperation<>();
      expect(delegate.withField(key, value)).andReturn(op.getDelegate()).anyTimes();
      nested.add(op);
      fieldMap.put(matcher, op);
    }
    return op;
  }

  @Override
  public IExpectationSetters<L> list() {
    return expect(delegate.list());
  }


  public Set<Mockable> getNested() {
    return nested;
  }
}
