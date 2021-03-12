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
package io.fabric8.kubernetes.client.handlers;

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import java.util.function.Predicate;
import okhttp3.OkHttpClient;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesListBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.HasMetadataVisitiableBuilder;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.internal.KubernetesListOperationsImpl;
import org.apache.felix.scr.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation.DEFAULT_GRACE_PERIOD_IN_SECONDS;
import static io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation.DEFAULT_PROPAGATION_POLICY;

@Component
@org.apache.felix.scr.annotations.Service
public class KubernetesListHandler implements ResourceHandler<KubernetesList, KubernetesListBuilder> {

  private static final Logger LOGGER = LoggerFactory.getLogger(KubernetesListHandler.class);

  private static final String KIND = new KubernetesList().getKind();
  
  @Override
  public String getKind() {
    return KIND;
  }

  @Override
  public String getApiVersion() {
    return "v1";
  }

  @Override
  public KubernetesList create(OkHttpClient client, Config config, String namespace, KubernetesList item, boolean dryRun) {
    return new KubernetesListOperationsImpl(client, config, namespace, null, DEFAULT_PROPAGATION_POLICY, DEFAULT_GRACE_PERIOD_IN_SECONDS, false, false, item, null, dryRun).create();
  }

  @Override
  public KubernetesList replace(OkHttpClient client, Config config, String namespace, KubernetesList item, boolean dryRun) {
    List<HasMetadata> replacedItems = new ArrayList<>();

    for (HasMetadata metadata : item.getItems()) {
      ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> handler = Handlers.get(item.getKind(), item.getApiVersion());
      if (handler == null) {
        LOGGER.warn("No handler found for:" + item.getKind() + ". Ignoring");
      } else {
        replacedItems.add(handler.replace(client, config, namespace, metadata, dryRun));
      }
    }
    return new KubernetesListBuilder(item).withItems(replacedItems).build();
  }

  @Override
  public KubernetesList reload(OkHttpClient client, Config config, String namespace, KubernetesList item) {
    List<HasMetadata> replacedItems = new ArrayList<>();

    for (HasMetadata metadata : item.getItems()) {
      ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> handler = Handlers.get(item.getKind(), item.getApiVersion());
      if (handler == null) {
        LOGGER.warn("No handler found for:" + item.getKind() + ". Ignoring");
      } else {
        replacedItems.add(handler.reload(client, config, namespace, metadata));
      }
    }
    return new KubernetesListBuilder(item).withItems(replacedItems).build();
  }

  @Override
  public KubernetesListBuilder edit(KubernetesList item) {
    return new KubernetesListBuilder(item);
  }

  @Override
  public Boolean delete(OkHttpClient client, Config config, String namespace, DeletionPropagation propagationPolicy, long gracePeriodSeconds, KubernetesList item, boolean dryRun) {
    return new KubernetesListOperationsImpl(client, config, namespace, null, propagationPolicy, gracePeriodSeconds, false, false, item, null, dryRun).delete(item);
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, KubernetesList item, Watcher<KubernetesList> watcher) {
    throw new UnsupportedOperationException("Watch is not supported on KubernetesList.");
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, KubernetesList item, String resourceVersion, Watcher<KubernetesList> watcher) {
    throw new UnsupportedOperationException("Watch is not supported on KubernetesList.");
  }

  @Override
  public Watch watch(OkHttpClient client, Config config, String namespace, KubernetesList item, ListOptions listOptions, Watcher<KubernetesList> watcher) {
    throw new UnsupportedOperationException("Watch is not supported on KubernetesList.");
  }

  @Override
  public KubernetesList waitUntilReady(OkHttpClient client, Config config, String namespace, KubernetesList item, long amount, TimeUnit timeUnit) throws InterruptedException {
    throw new UnsupportedOperationException("Watch is not supported on KubernetesList.");
  }

  @Override
  public KubernetesList waitUntilCondition(OkHttpClient client, Config config, String namespace, KubernetesList item, Predicate<KubernetesList> condition, long amount, TimeUnit timeUnit) throws InterruptedException {
    throw new UnsupportedOperationException("Watch is not supported on KubernetesList.");
  }
}
