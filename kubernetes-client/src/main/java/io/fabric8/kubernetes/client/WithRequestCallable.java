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
package io.fabric8.kubernetes.client;

import io.fabric8.kubernetes.api.builder.Function;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;

public class WithRequestCallable<C extends Client> implements FunctionCallable<C> {

  private final C client;
  private final RequestConfig requestConfig;

  public WithRequestCallable(C client, RequestConfig requestConfig) {
    this.client = client;
    this.requestConfig = requestConfig;
  }

  @Override
  public <O> O call(Function<C, O> function) {
    try {
      RequestConfigHolder.set(requestConfig);
      return function.apply(client);
    } finally {
      RequestConfigHolder.remove();
    }
  }
}
