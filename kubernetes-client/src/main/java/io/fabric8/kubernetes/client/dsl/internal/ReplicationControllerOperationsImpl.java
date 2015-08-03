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
import io.fabric8.kubernetes.api.model.DoneableReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.Scaleable;
import io.fabric8.kubernetes.client.dsl.ScaleableResource;

import java.net.URL;

public class ReplicationControllerOperationsImpl extends BaseScaleableOperation<ReplicationController, ReplicationControllerList, DoneableReplicationController, ScaleableResource<ReplicationController, DoneableReplicationController, Boolean>> {

  public ReplicationControllerOperationsImpl(AsyncHttpClient httpClient, URL rootUrl) {
    super(httpClient, rootUrl, "replicationcontrollers", null, null, ReplicationController.class, ReplicationControllerList.class, DoneableReplicationController.class);
  }

  public ReplicationControllerOperationsImpl(AsyncHttpClient httpClient, URL rootUrl, String namespace, String name) {
    super(httpClient, rootUrl, "replicationcontrollers", namespace, name);
  }

  @Override
  public void scale(int count) {
    scale(count, false);
  }

  @Override
  public void scale(int count, boolean wait) {
    edit(false).editSpec().withReplicas(count).endSpec().done();
    if (wait) {
      while(get().getStatus().getReplicas() != count) {
        try {
          Thread.sleep(Scaleable.POLL_INTERVAL_MS);
        } catch (InterruptedException e) {
          throw new KubernetesClientException("Interrupted sleep", e);
        }
      }
    }
  }
}
