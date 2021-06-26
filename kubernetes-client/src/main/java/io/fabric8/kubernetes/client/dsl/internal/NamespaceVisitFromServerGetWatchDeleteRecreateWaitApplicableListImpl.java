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

import com.fasterxml.jackson.databind.ObjectMapper;

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesList;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.*;
import io.fabric8.kubernetes.client.dsl.base.OperationSupport;
import io.fabric8.kubernetes.client.internal.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;

import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static io.fabric8.kubernetes.client.utils.CreateOrReplaceHelper.createOrReplaceItem;
import static io.fabric8.kubernetes.client.utils.DeleteAndCreateHelper.deleteAndCreateItem;
import static io.fabric8.kubernetes.client.dsl.internal.NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl.handlerOf;

public class NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl extends OperationSupport implements ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata>,
Waitable<List<HasMetadata>, HasMetadata>, Readiable {

    private static final Logger LOGGER = LoggerFactory.getLogger(NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl.class);
    protected static final String EXPRESSION = "expression";
    protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String fallbackNamespace;
    private final String explicitNamespace;

    private final Boolean fromServer;
    private final Boolean deletingExisting;
    private final List<Visitor> visitors;
    private final long watchRetryInitialBackoffMillis;
    private final double watchRetryBackoffMultiplier;
    private final Object item;
    private final InputStream inputStream;

    private final long gracePeriodSeconds;
    private final DeletionPropagation propagationPolicy;
    private final Boolean cascading;

  @Override
  public List<HasMetadata> waitUntilReady(final long amount, final TimeUnit timeUnit) throws InterruptedException {
    return waitUntilCondition(resource -> Objects.nonNull(resource) && getReadiness().isReady(resource), amount, timeUnit);
  }

  @Override
  public List<HasMetadata> waitUntilCondition(Predicate<HasMetadata> condition,
                                              long amount,
                                              TimeUnit timeUnit) throws InterruptedException {
    List<HasMetadata> items = acceptVisitors(asHasMetadata(item, true), visitors);
    if (items.isEmpty()) {
      return Collections.emptyList();
    }
    // this strategy is very costly in terms of threads - by not exposing the underlying futures
    // we have to create a thread for each item that mostly waits
    final ExecutorService executor = Executors.newFixedThreadPool(items.size(), Utils.daemonThreadFactory(this));
    try {
      final List<CompletableFuture<HasMetadata>> futures = new ArrayList<>(items.size());
      for (final HasMetadata meta : items) {
        final ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
        futures.add(CompletableFuture.supplyAsync(() -> {
          try {
            return h.waitUntilCondition(client, config, meta.getMetadata().getNamespace(), meta, condition, amount, timeUnit);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
          }
        }, executor));
      }
  
      final List<HasMetadata> results = new ArrayList<>();
      final List<HasMetadata> itemsWithConditionNotMatched = new ArrayList<>();
  
      // Iterate over the items because we don't know what kind of List it is.
      // But the futures use an ArrayList, so accessing by index is efficient.
      int i = 0;
      for (final HasMetadata meta : items) {
        try {
          CompletableFuture<HasMetadata> future = futures.get(i);
          // just get each result as the timeout is enforced below
          results.add(future.get());
        } catch (ExecutionException e) {
          itemsWithConditionNotMatched.add(meta);
          logAsNotReady(e.getCause(), meta);
        }
        ++i;
      }
  
      if (!itemsWithConditionNotMatched.isEmpty()) {
        throw new KubernetesClientTimeoutException(itemsWithConditionNotMatched, amount, timeUnit);
      }
  
      return results;
    } finally {
      executor.shutdownNow();
    }
  }

  private static void logAsNotReady(Throwable t, HasMetadata meta) {
    LOGGER.warn("Error while waiting for: [{}] with name: [{}] in namespace: [{}]: {}. The resource will be considered not ready.", meta.getKind(), meta.getMetadata().getName(), meta.getMetadata().getNamespace(), t.getMessage());
    LOGGER.debug("The error stack trace:", t);
  }

  @Override
  public Boolean isReady() {
    for (final HasMetadata meta : acceptVisitors(get(), visitors)) {
      if (!getReadiness().isReady(meta)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> withParameters(Map<String, String> parameters) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, null, inputStream, parameters, -1, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public ListVisitFromServerWritable<HasMetadata> dryRun(boolean isDryRun) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, item, inputStream, null, -1, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, isDryRun);
  }

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

    public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, InputStream is, Map<String, String> parameters, Boolean cascading, DeletionPropagation propagationPolicy, boolean dryRun) {
        this(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, null, is, parameters, -1, propagationPolicy, cascading, Waitable.DEFAULT_INITIAL_BACKOFF_MILLIS, Waitable.DEFAULT_BACKOFF_MULTIPLIER, dryRun);
    }

    public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, Map<String, String> parameters, DeletionPropagation propagationPolicy, Boolean cascading, boolean dryRun) {
      this(client, config, namespace, explicitNamespace, fromServer, deletingExisting, visitors, item, null, parameters, -1, propagationPolicy, cascading, Waitable.DEFAULT_INITIAL_BACKOFF_MILLIS, Waitable.DEFAULT_BACKOFF_MULTIPLIER, dryRun);
    }

    public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OkHttpClient client, Config config, String namespace, String explicitNamespace, Boolean fromServer, Boolean deletingExisting, List<Visitor> visitors, Object item, InputStream inputStream, Map<String, String> parameters, long gracePeriodSeconds, DeletionPropagation propagationPolicy, Boolean cascading, long watchRetryInitialBackoffMillis, double watchRetryBackoffMultiplier, boolean dryRun) {
        super(client, config);
        this.fallbackNamespace = namespace;
        this.explicitNamespace = explicitNamespace;
        this.fromServer = fromServer;
        this.deletingExisting = deletingExisting;
        this.visitors = visitors != null ? new ArrayList<>(visitors) : new ArrayList<>();
        this.watchRetryInitialBackoffMillis = watchRetryInitialBackoffMillis;
        this.watchRetryBackoffMultiplier = watchRetryBackoffMultiplier;

      if (item != null) {
          this.item = item;
        } else if (inputStream != null) {
          this.item = Serialization.unmarshal(inputStream, parameters);
        } else {
          throw new IllegalArgumentException("Need to either specify an Object or an InputStream.");
        }

        this.inputStream = inputStream;
        this.cascading = cascading;
        this.gracePeriodSeconds = gracePeriodSeconds;
        this.propagationPolicy = propagationPolicy;
        this.dryRun = dryRun;
        this.visitors.add(new ChangeNamespace(explicitNamespace, fallbackNamespace));
    }

  @Override
  public List<HasMetadata> apply() {
       return createOrReplace();
    }

  @Override
  public List<HasMetadata> createOrReplace() {
    List<HasMetadata> result = new ArrayList<>();
    for (HasMetadata meta : acceptVisitors(asHasMetadata(item, true), visitors)) {
      ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
      String namespaceToUse = meta.getMetadata().getNamespace();

      HasMetadata createdItem = createOrReplaceOrDeleteExisting(meta, h, namespaceToUse, dryRun);
      if (createdItem != null) {
        result.add(createdItem);
      }
    }
    return result;
  }

  @Override
  public Waitable<List<HasMetadata>, HasMetadata> createOrReplaceAnd() {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, createOrReplace(), inputStream, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
    public Boolean delete() {
        //First pass check before deleting
        for (HasMetadata meta : acceptVisitors(asHasMetadata(item, true), visitors)) {
            if (handlerOf(meta) == null) {
                return false;
            }
        }

        //Second pass do delete
        for (HasMetadata meta :  acceptVisitors(asHasMetadata(item, true), visitors)) {
            ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
            if (!h.delete(client, config, meta.getMetadata().getNamespace(), propagationPolicy, gracePeriodSeconds, meta, dryRun)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<HasMetadata> get() {
        if (fromServer) {
            List<HasMetadata> result = new ArrayList<>();
            for (HasMetadata meta : acceptVisitors(asHasMetadata(item, true), visitors)) {
                ResourceHandler<HasMetadata, ?> h = handlerOf(meta);
                HasMetadata reloaded = h.reload(client, config, meta.getMetadata().getNamespace(), meta);
                if (reloaded != null) {
                    HasMetadata edited = reloaded;
                    //Let's apply any visitor that might have been specified.
                    for (Visitor v : visitors) {
                        h.edit(edited).accept(v).build();
                    }
                    result.add(reloaded);
                }
            }
            return result;
        } else {
            return acceptVisitors(asHasMetadata(item, true), visitors);
        }
    }

    private static List<HasMetadata> acceptVisitors(List<HasMetadata> list, List<Visitor> visitors) {
        List<HasMetadata> result = new ArrayList<>();
        for (HasMetadata item : list) {
            ResourceHandler<HasMetadata, ?> h = handlerOf(item);
            VisitableBuilder<HasMetadata, ?> builder = h.edit(item);

            //Let's apply any visitor that might have been specified.
            for (Visitor v : visitors) {
                builder.accept(v);
            }
            result.add(builder.build());
        }
        return result;
    }


    @Override
    public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> inNamespace(String explicitNamespace) {
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, deletingExisting, visitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
    }

    @Override
    public Gettable<List<HasMetadata>> fromServer() {
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, true, deletingExisting, visitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
    }

    @Override
    public Applicable<List<HasMetadata>> deletingExisting() {
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
    }

    @Override
    public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> accept(Visitor... visitors) {
        List<Visitor> newVisitors = new ArrayList<>(this.visitors);
        for (Visitor v : visitors) {
          newVisitors.add(v);
        }
        return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, newVisitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
    }

  @Override public CascadingDeletable<List<HasMetadata>> withGracePeriod(long gracePeriodSeconds)
  {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override public CascadingDeletable<List<HasMetadata>> withPropagationPolicy(DeletionPropagation propagationPolicy)
  {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  @Override
  public Waitable<List<HasMetadata>, HasMetadata> withWaitRetryBackoff(long initialBackoff, TimeUnit backoffUnit, double backoffMultiplier) {
    long watchRetryInitialBackoffMillis = backoffUnit.toMillis(initialBackoff);
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, backoffMultiplier, dryRun);
  }

  @Override
  public Deletable cascading(boolean cascading) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(client, config, fallbackNamespace, explicitNamespace, fromServer, true, visitors, item, null, null, gracePeriodSeconds, propagationPolicy, cascading, watchRetryInitialBackoffMillis, watchRetryBackoffMultiplier, dryRun);
  }

  protected Readiness getReadiness() {
    return Readiness.getInstance();
  }

  protected <T> List<HasMetadata> asHasMetadata(T item, Boolean enableProcessing) {
    List<HasMetadata> result = new ArrayList<>();
    if (item instanceof KubernetesList) {
      result.addAll(((KubernetesList) item).getItems());
    } else if (item instanceof KubernetesResourceList) {
      result.addAll(((KubernetesResourceList) item).getItems());
    } else if (item instanceof HasMetadata) {
      result.add((HasMetadata) item);
    }  else if (item instanceof String) {
      try (InputStream is = new ByteArrayInputStream(((String)item).getBytes(StandardCharsets.UTF_8))) {
        return asHasMetadata(unmarshal(is), enableProcessing);
      } catch (IOException e) {
        throw KubernetesClientException.launderThrowable(e);
      }
    } else if (item instanceof Collection) {
      for (Object o : (Collection)item) {
        if (o instanceof HasMetadata) {
          result.add((HasMetadata) o);
        }
      }
    }
    return result;
  }

  private HasMetadata createOrReplaceOrDeleteExisting(HasMetadata meta, ResourceHandler<HasMetadata, ?> h, String namespaceToUse, boolean dryRun) {
      if (Boolean.TRUE.equals(deletingExisting)) {
        return deleteAndCreateItem(client, config, meta, h, namespaceToUse, propagationPolicy, gracePeriodSeconds, dryRun);
      }
      return createOrReplaceItem(client, config, meta, h, namespaceToUse, dryRun);
  }

}
