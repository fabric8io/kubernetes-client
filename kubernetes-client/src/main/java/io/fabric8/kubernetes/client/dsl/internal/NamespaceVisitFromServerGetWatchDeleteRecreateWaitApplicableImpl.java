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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.HasMetadataVisitiableBuilder;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.Applicable;
import io.fabric8.kubernetes.client.dsl.CascadingDeletable;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Readiable;
import io.fabric8.kubernetes.client.dsl.VisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Waitable;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.handlers.KubernetesListHandler;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.ResourceCompare;
import okhttp3.OkHttpClient;

import static io.fabric8.kubernetes.client.utils.Utils.isNotNullOrEmpty;
import static io.fabric8.kubernetes.client.utils.Utils.isNullOrEmpty;

public class NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl extends OperationSupport implements NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata, Boolean>,
Waitable<HasMetadata>,
  Readiable {

  private static final Logger LOGGER = LoggerFactory.getLogger(NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl.class);

  private final String fallbackNamespace;
  private final String explicitNamespace;

  private final Boolean fromServer;
  private final Boolean deletingExisting;
  private final List<Visitor> visitors;
  private final Object item;
  private final ResourceHandler handler;
  private final long gracePeriodSeconds;
  private final Boolean cascading;

  /**
   * We need to be able to either use an explicit namespace or fallback to the client default.
   * Either-way we need to update the object itself or the client will complain about a mismatch.
   * And this is how we its done.
   */
  private class ChangeNamespace extends TypedVisitor<ObjectMetaBuilder> {

    private final String explicitNamespace;
    private final String fallbackNamespace;

    private ChangeNamespace(String explicitNamespace, String fallbackNamespace) {
      this.explicitNamespace = explicitNamespace;
      this.fallbackNamespace = fallbackNamespace;
    }

    @Override
    public void visit(ObjectMetaBuilder builder) {
      if (isNotNullOrEmpty(explicitNamespace)) {
        builder.withNamespace(explicitNamespace);
      } else if (isNullOrEmpty(builder.getNamespace())) {
        builder.withNamespace(fallbackNamespace);
      }
    }
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is, Boolean cascading) {
    this(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, unmarshal(is), -1, cascading);
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, long gracePeriodSeconds, Boolean cascading) {
    super(client, config, null, null, null, null, null);
    this.fallbackNamespace = namespace;
    this.explicitNamespace = explicitNamespace;
    this.fromServer = fromServer;
    this.deletingExisting = deletingExisting;
    this.visitors = visitors != null ? new ArrayList<>(visitors) : new ArrayList<Visitor>();
    this.item = item;
    this.handler = handlerOf(item);
    this.cascading = cascading;
    if (handler == null) {
      throw new KubernetesClientException("No handler found for object:" + item);
    }
    this.gracePeriodSeconds = gracePeriodSeconds;
    this.visitors.add(new ChangeNamespace(explicitNamespace, fallbackNamespace));
  }

  @Override
  public HasMetadata apply() {
    return createOrReplace();
  }

  @Override
  public HasMetadata createOrReplace() {
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
    HasMetadata r = h.reload(client, config, meta.getMetadata().getNamespace(), meta);
    String namespaceToUse = meta.getMetadata().getNamespace();

    if (r == null) {
      return h.create(client, config, namespaceToUse, meta);
    } else if (deletingExisting) {
      Boolean deleted = h.delete(client, config, namespaceToUse, meta);
      if (!deleted) {
        throw new KubernetesClientException("Failed to delete existing item:" + meta);
      }
      return h.create(client, config, namespaceToUse, meta);
    } else if (ResourceCompare.equals(r, meta)) {
      LOGGER.debug("Item has not changed. Skipping");
      return meta;
    } else {
      return h.replace(client, config, namespaceToUse, meta);
    }
  }

  @Override
  public Waitable<HasMetadata> createOrReplaceAnd() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, createOrReplace(), gracePeriodSeconds, cascading);
  }

  @Override
  public Boolean delete() {
    //First pass check before deleting
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
    return h.delete(client, config, meta.getMetadata().getNamespace(), meta);
  }

  @Override
  public HasMetadata get() {
    if (fromServer) {
      HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
      ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
      HasMetadata reloaded = h.reload(client, config, meta.getMetadata().getNamespace(), meta);
      if (reloaded != null) {
        HasMetadata edited = reloaded;
        //Let's apply any visitor that might have been specified.
        for (Visitor v : visitors) {
          edited = h.edit(edited).accept(v).build();
        }
        return edited;
      }
      return null;
    } else {
      return acceptVisitors(asHasMetadata(item), visitors);
    }
  }

  @Override
  public VisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata, Boolean> inNamespace(String explicitNamespace) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, item, gracePeriodSeconds, cascading);
  }

  @Override
  public Gettable<HasMetadata> fromServer() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, true, deletingExisting, visitors, item, gracePeriodSeconds, cascading);
  }

  @Override
  public Applicable<HasMetadata> deletingExisting() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, cascading);
  }

  @Override
  public VisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata, Boolean> accept(Visitor visitor) {
    List<Visitor> newVisitors = new ArrayList<>(visitors);
    newVisitors.add(visitor);
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, newVisitors, item, gracePeriodSeconds, cascading);
  }

  @Override
  public CascadingDeletable<Boolean> withGracePeriod(long gracePeriodSeconds) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, cascading);
  }


  @Override
  public Deletable<Boolean> cascading(boolean cascading) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, cascading);
  }

  @Override
  public Watch watch(Watcher<HasMetadata> watcher) {
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
    return h.watch(client, config, meta.getMetadata().getNamespace(), meta, watcher);
  }

  @Override
  public Watch watch(String resourceVersion, Watcher<HasMetadata> watcher) {
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
    return h.watch(client, config, meta.getMetadata().getNamespace(), meta, watcher);
  }

  @Override
  public Boolean isReady() {
    return Readiness.isReady(get());
  }

  @Override
  public HasMetadata waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
    HasMetadata meta = acceptVisitors(asHasMetadata(get()), visitors);
    ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(meta);
    return h.waitUntilReady(client, config, meta.getMetadata().getNamespace(), meta, amount, timeUnit);
  }


  private static HasMetadata acceptVisitors(HasMetadata item, List<Visitor> visitors) {
    ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(item);
    VisitableBuilder<HasMetadata, ?> builder = h.edit(item);

    //Let's apply any visitor that might have been specified.
    for (Visitor v : visitors) {
      builder.accept(v);
    }
    return builder.build();
  }

  private static List<HasMetadata> acceptVisitors(List<HasMetadata> list, List<Visitor> visitors) {
    List<HasMetadata> result = new ArrayList<>();
    for (HasMetadata item : list) {
      ResourceHandler<HasMetadata, HasMetadataVisitiableBuilder> h = handlerOf(item);
      VisitableBuilder<HasMetadata, ?> builder = h.edit(item);

      //Let's apply any visitor that might have been specified.
      for (Visitor v : visitors) {
        builder.accept(v);
      }
      result.add(builder.build());
    }
    return result;
  }

  private static <T> HasMetadata asHasMetadata(T item) {
    if (item instanceof HasMetadata) {
      return (HasMetadata) item;
    } else if (item instanceof String) {
      try (InputStream is = new ByteArrayInputStream(((String) item).getBytes(StandardCharsets.UTF_8))) {
        return asHasMetadata(unmarshal(is));
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    }
    throw new IllegalArgumentException("Item needs to be an instance of HasMetadata or String.");
  }

  private static <T> ResourceHandler handlerOf(T item) {
    if (item instanceof HasMetadata) {
      return Handlers.<HasMetadata, HasMetadataVisitiableBuilder>get(((HasMetadata) item).getKind());
    } else if (item instanceof KubernetesList) {
      return new KubernetesListHandler();
    } else {
      throw new IllegalArgumentException("Could not find a registered handler for item: [" + item + "].");
    }
  }

}
