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
package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.model.DoneablePod;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.ClientLoggableResource;
import io.fabric8.kubernetes.client.internal.URLUtils;

import java.net.URL;
import java.util.concurrent.Future;

public class PodOperationsImpl<C extends Client>  extends HasMetadataOperation<C, Pod, PodList, DoneablePod, ClientLoggableResource<Pod, DoneablePod>> implements ClientLoggableResource<Pod,DoneablePod> {

  public PodOperationsImpl(C client) {
    this(client, client.getNamespace(), null, true, null);
  }

  public PodOperationsImpl(C client, String namespace, String name, Boolean cascading, Pod item) {
    super(client, "pods", namespace, name, cascading, item);
  }

  @Override
  public String getLog() {
    return getLog(true);
  }

  @Override
  public String getLog(Boolean isPretty) {
    return getLog(null, isPretty);
  }

  @Override
  public String getLog(String containerId) {
    return getLog(containerId, true);
  }

  @Override
  public String getLog(String containerId, Boolean isPretty) {
    StringBuilder sb = new StringBuilder();
    sb.append("log?pretty=").append(isPretty);
    if (containerId != null && !containerId.isEmpty()) {
      sb.append("&container=").append(containerId);
    }

    try {
      URL url = new URL(URLUtils.join(getResourceUrl().toString(), sb.toString()));
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getClient().getHttpClient().prepareGet(url.toString());
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      assertResponseCode(r, 200);
      return r.getResponseBody();
    } catch (Throwable t) {
      throw KubernetesClientException.launderThrowable(t);
    }
  }
}

