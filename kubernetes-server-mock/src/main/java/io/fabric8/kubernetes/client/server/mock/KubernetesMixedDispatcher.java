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
package io.fabric8.kubernetes.client.server.mock;

import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.mockwebserver.dsl.HttpMethod;
import io.fabric8.mockwebserver.internal.MockDispatcher;
import io.fabric8.mockwebserver.internal.SimpleRequest;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * A composite dispatcher consistent of a {@link MockDispatcher} and a {@link KubernetesCrudDispatcher}.
 *
 * <p> Any request matching a pre-recorded response for the MockDispatcher is handled by the MockDispatcher.
 * The rest of requests are forwarded to the KubernetesCrudDispatcher.
 *
 * <p> This dispatcher is useful to use the KubernetesMockServer in a mixed CRUD mode.
 */
public class KubernetesMixedDispatcher extends Dispatcher {

  private final Map<ServerRequest, Queue<ServerResponse>> responses;
  private final MockDispatcher mockDispatcher;
  private final KubernetesCrudDispatcher kubernetesCrudDispatcher;

  public KubernetesMixedDispatcher(Map<ServerRequest, Queue<ServerResponse>> responses) {
    this(responses, Collections.emptyList());
  }

  public KubernetesMixedDispatcher(
    Map<ServerRequest, Queue<ServerResponse>> responses, List<CustomResourceDefinitionContext> crdContexts) {
    this.responses = responses;
    mockDispatcher = new MockDispatcher(responses);
    kubernetesCrudDispatcher = new KubernetesCrudDispatcher(crdContexts);
  }

  @Override
  public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
    final Queue<ServerResponse> responseQueue = responses.get(
      new SimpleRequest(HttpMethod.valueOf(request.getMethod()), request.getPath()));
    if (responseQueue != null && !responseQueue.isEmpty()) {
      return mockDispatcher.dispatch(request);
    }
    return kubernetesCrudDispatcher.dispatch(request);
  }
}
