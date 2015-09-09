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

import io.fabric8.kubernetes.client.dsl.Createable;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Loadable;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.Resource;
import org.easymock.IExpectationSetters;

import java.io.InputStream;

public interface MockNonNamespaceOperation<T, L, D, R extends Resource<T, IExpectationSetters<T>, D, IExpectationSetters<Boolean>>> extends
  Nameable<R>,
  FilterWatchListDeletable<IExpectationSetters<T>, IExpectationSetters<L>, IExpectationSetters<Boolean>>,
  Createable<T, IExpectationSetters<T>, D>,
  Loadable<InputStream, MockResource<T, D, Boolean>> {

}
