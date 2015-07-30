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

import com.ning.http.client.ws.WebSocket;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.ClientOperation;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeleteable;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.easymock.EasyMock;
import org.easymock.IExpectationSetters;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

public class BaseMockOperation<T, L extends KubernetesResourceList, D extends Doneable<T>,
  R extends Resource<T, D, Void, Boolean>,
  E extends Resource<IExpectationSetters<T>, D, IExpectationSetters<Void>, IExpectationSetters<Boolean>>>
  implements MockOperation<T, L, D, E>, Mockable {

  private final String name;
  private final String namespace;

  private final Map<String, String> labels;
  private final Map<String, String> labelsNot;
  private final Map<String, String[]> labelsIn;
  private final Map<String, String[]> labelsNotIn;
  private final Map<String, String> fields;

  private final ClientOperation<T, L, D, R> delegate = EasyMock.createMock(ClientOperation.class);
  
  private final Set<Mockable> nested = new LinkedHashSet<>();

  public BaseMockOperation() {
    this(null, null, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public BaseMockOperation(String name, String namespace) {
    this(name, namespace, new TreeMap<String, String>(), new TreeMap<String, String>(), new TreeMap<String, String[]>(), new TreeMap<String, String[]>(), new TreeMap<String, String>());
  }

  public BaseMockOperation(String name, String namespace, Map<String, String> labels, Map<String, String> labelsNot, Map<String, String[]> labelsIn, Map<String, String[]> labelsNotIn, Map<String, String> fields) {
    this.name = name;
    this.namespace = namespace;
    this.labels = labels;
    this.labelsNot = labelsNot;
    this.labelsIn = labelsIn;
    this.labelsNotIn = labelsNotIn;
    this.fields = fields;
  }

  public void replay() {
    for (Mockable mockable : nested) {
      mockable.replay();
    }
    EasyMock.replay(delegate);
  }

  public void verify() {
    EasyMock.verify(delegate);
  }

  public ClientOperation<T, L, D, R> getDelegate() {
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
  public IExpectationSetters<Void> delete() {
    return expect(delegate.delete());
  }

  @Override
  public IExpectationSetters<Boolean> deleteIfExists() {
    return expect(delegate.deleteIfExists());
  }

  @Override
  public D edit() {
    throw new UnsupportedOperationException("Mock client doesn't support inline edit. Please use update(T item) instead.");
  }

  @Override
  public E withName(String name) {
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withName(name)).andReturn((R) op.getDelegate()).once();
    nested.add(op);
    return (E) op;
  }

  @Override
  public MockNonNamespaceOperation<T, L, D, E> inNamespace(String namespace) {
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.inNamespace(namespace)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public IExpectationSetters<T> update(IExpectationSetters<T> item) {
    return null;
  }

  @Override
  public IExpectationSetters<T> get() {
    return expect(delegate.get());
  }

  @Override
  public IExpectationSetters<T> getIfExists() {
    return expect(delegate.getIfExists());
  }


  @Override
  public WebSocket watch(Watcher<IExpectationSetters<T>> watcher) throws KubernetesClientException {
    throw new UnsupportedOperationException();
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withLabels(Map<String, String> l) {
    labels.putAll(l);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withLabels(labels)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withoutLabels(Map<String, String> l) {
    labelsNot.putAll(l);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withoutLabels(labels)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withLabelIn(String key, String... values) {
    labelsIn.put(key, values);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withLabelIn(key, values)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withLabelNotIn(String key, String... values) {
    labelsNotIn.put(key, values);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withLabelNotIn(key, values)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withLabel(String key, String value) {
    labels.put(key, value);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withLabel(key, value)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withoutLabel(String key, String value) {
    labelsNot.put(key, value);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withoutLabel(key, value)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withFields(Map<String, String> f) {
    fields.putAll(f);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withFields(f)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public FilterWatchListDeleteable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Void>, IExpectationSetters<Boolean>> withField(String key, String value) {
    fields.put(key, value);
    BaseMockOperation<T, L, D, R, E> op = new BaseMockOperation<>(name, namespace, labels, labelsNot, labelsIn, labelsNotIn, fields);
    expect(delegate.withField(key, value)).andReturn(op.getDelegate()).once();
    nested.add(op);
    return op;
  }

  @Override
  public IExpectationSetters<L> list() {
    return expect(delegate.list());
  }

  public String getName() {
    return name;
  }

  public String getNamespace() {
    return namespace;
  }

  public Map<String, String> getLabels() {
    return labels;
  }

  public Map<String, String> getLabelsNot() {
    return labelsNot;
  }

  public Map<String, String[]> getLabelsIn() {
    return labelsIn;
  }

  public Map<String, String[]> getLabelsNotIn() {
    return labelsNotIn;
  }

  public Map<String, String> getFields() {
    return fields;
  }

  public Set<Mockable> getNested() {
    return nested;
  }
}
