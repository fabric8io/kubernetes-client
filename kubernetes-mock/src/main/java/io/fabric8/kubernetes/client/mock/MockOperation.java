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

import io.fabric8.kubernetes.client.dsl.AnyNamespaceable;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Loadable;
import io.fabric8.kubernetes.client.dsl.MultiDeleteable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.easymock.IExpectationSetters;

import java.io.InputStream;

public interface MockOperation<T, L, D, R extends Resource<T, IExpectationSetters<T>, D, IExpectationSetters<Boolean>>> extends
  Namespaceable<MockNonNamespaceOperation<T, L, D, R>>,
  AnyNamespaceable<FilterWatchListDeletable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>>>,
  FilterWatchListDeletable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>>,
  MultiDeleteable<T, IExpectationSetters<Boolean>>,
  MockNonNamespaceOperation<T, L, D, R>,
  Loadable<InputStream, MockResource<T, D, Boolean>> {
}
