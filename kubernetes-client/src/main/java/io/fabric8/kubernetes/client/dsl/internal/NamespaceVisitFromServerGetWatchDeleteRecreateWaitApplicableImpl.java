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

import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.dsl.VisitFromServerWritable;
import io.fabric8.kubernetes.client.utils.Utils;

import java.util.function.Predicate;

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
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import okhttp3.OkHttpClient;

import static io.fabric8.kubernetes.client.utils.CreateOrReplaceHelper.createOrReplaceItem;
import static io.fabric8.kubernetes.client.utils.DeleteAndCreateHelper.deleteAndCreateItem;

public class NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl extends OperationSupport implements
  NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata>,
  Waitable<HasMetadata, HasMetadata>,
  Readiable {

  private final String fallbackNamespace;
  private final String explicitNamespace;

  private final Boolean fromServer;
  private final Boolean deletingExisting;
  private final List<Visitor> visitors;
  private final Object item;
  private final long gracePeriodSeconds;
  private final DeletionPropagation propagationPolicy;
  private final Boolean cascading;
  private final long watchRetryInitialBackoffMillis;
  private final double watchRetryBackoffMultiplier;

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
      if (Utils.isNotNullOrEmpty(explicitNamespace)) {
        builder.withNamespace(explicitNamespace);
      } else if (Utils.isNullOrEmpty(builder.getNamespace())) {
        builder.withNamespace(fallbackNamespace);
      }
    }
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is, Boolean cascading, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean dryRun) {
    this(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, unmarshal(is), -1, null, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, long gracePeriodSeconds, DeletionPropagation propagationPolicy, Boolean cascading, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean dryRun) {
    super(client, config);
    this.fallbackNamespace = namespace;
    this.explicitNamespace = explicitNamespace;
    this.fromServer = fromServer;
    this.deletingExisting = deletingExisting;
    this.visitors = visitors != null ? new ArrayList<>(visitors) : new ArrayList<>();
    this.item = item;
    checkForHandlerOf(item);
    this.cascading = cascading;
    this.watchRetryInitialBackoffMillis = watchRetryInitialBackoffMillis;
    this.watchRetryBackoffMultiplier = watchRetryBackoffMultiplier;
    this.gracePeriodSeconds = gracePeriodSeconds;
    this.propagationPolicy = propagationPolicy;
    this.dryRun = dryRun;
    this.visitors.add(new ChangeNamespace(explicitNamespace, fallbackNamespace));
  }

  @Override
  public HasMetadata apply() {
    return createOrReplace();
  }

  @Override
  public HasMetadata createOrReplace() {
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
    String namespaceToUse = meta.getMetadata().getNamespace();
    if (Boolean.TRUE.equals(deletingExisting)) {
      return deleteAndCreateItem(client, config, meta, h, namespaceToUse, propagationPolicy, gracePeriodSeconds, dryRun);
    }
    return createOrReplaceItem(client, config, meta, h, namespaceToUse, dryRun);
  }

  @Override
  public Waitable<HasMetadata, HasMetadata> createOrReplaceAnd() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, createOrReplace(), gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public Boolean delete() {
    //First pass check before deleting
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
    return h.delete(client, config, meta.getMetadata().getNamespace(), propagationPolicy, gracePeriodSeconds, meta, dryRun);
  }

  @Override
  public HasMetadata get() {
    if (fromServer) {
      HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
      ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
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
  public VisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> inNamespace(String explicitNamespace) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public Gettable<HasMetadata> fromServer() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, true, deletingExisting, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public Applicable<HasMetadata> deletingExisting() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public VisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> accept(Visitor... visitors) {
    List<Visitor> newVisitors = new ArrayList<>(this.visitors);
    for (Visitor v : visitors) {
      newVisitors.add(v);
    }
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, newVisitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public CascadingDeletable<HasMetadata> withGracePeriod(long gracePeriodSeconds) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public CascadingDeletable<HasMetadata> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }


  @Override
  public Deletable cascading(boolean cascading) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public Waitable<HasMetadata, HasMetadata> withWaitRetryBackoff(long initialBackoff, TimeUnit backoffUnit, double backoffMultiplier) {
    long watchRetryInitialBackoffMillis = backoffUnit.toMillis(initialBackoff);
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, backoffMultiplier, dryRun);
  }

  @Override
  public Watch watch(Watcher<HasMetadata> watcher) {
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
    return h.watch(client, config, meta.getMetadata().getNamespace(), meta, watcher);
  }

  @Override
  public Watch watch(String resourceVersion, Watcher<HasMetadata> watcher) {
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
    return h.watch(client, config, meta.getMetadata().getNamespace(), meta, resourceVersion, watcher);
  }

  @Override
  public Watch watch(ListOptions options, Watcher<HasMetadata> watcher) {
    HasMetadata meta = acceptVisitors(asHasMetadata(item), visitors);
    ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
    return h.watch(client, config, meta.getMetadata().getNamespace(), meta, options, watcher);
  }

  protected Readiness getReadiness() {
    return Readiness.getInstance();
  }

  @Override
  public final Boolean isReady() {
    return getReadiness().isReady(get());
  }

  @Override
  public HasMetadata waitUntilReady(long amount, TimeUnit timeUnit) {
    HasMetadata meta = acceptVisitors(asHasMetadata(get()), visitors);
    ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
    try {
      return h.waitUntilReady(client, config, meta.getMetadata().getNamespace(), meta, amount, timeUnit);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(e);
    }
  }

  @Override
  public VisitFromServerWritable<HasMetadata> dryRun(boolean isDryRun) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, isDryRun);
  }

  @Override
  public HasMetadata waitUntilCondition(Predicate<HasMetadata> condition, long amount,
    TimeUnit timeUnit) {
    HasMetadata meta = acceptVisitors(asHasMetadata(get()), visitors);
    ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
    try {
      return h.waitUntilCondition(client, config, meta.getMetadata().getNamespace(), meta, condition, amount, timeUnit);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw KubernetesClientException.launderThrowable(e);
    }
  }


  private static HasMetadata acceptVisitors(HasMetadata item, List<Visitor> visitors) {
    ResourceHandler<HasMetadata, ?> h = handlerOf(item);
    VisitableBuilder<HasMetadata, ?> builder = h.edit(item);

    //Let's apply any visitor that might have been specified.
    for (Visitor v : visitors) {
      builder.accept(v);
    }
    return builder.build();
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

  static <T> void checkForHandlerOf(T item) {
    if (item instanceof HasMetadata) {
      if (handlerOf((HasMetadata)item) == null) {
        throw new KubernetesClientException("No handler found for object:" + item);
      }
    } else if (!(item instanceof KubernetesList)) {
      throw new IllegalArgumentException("Could not find a registered handler for item: [" + item + "].");
    }
  }
  
  static <T extends HasMetadata> ResourceHandler<HasMetadata, ?> handlerOf(T item) {
    return Handlers.get(item.getKind(), item.getApiVersion());
  }
}
