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
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
import io.fabric8.kubernetes.client.Handlers;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.NamespaceableResourceAdapter;
import io.fabric8.kubernetes.client.ResourceHandler;
import io.fabric8.kubernetes.client.dsl.Applicable;
import io.fabric8.kubernetes.client.dsl.CascadingDeletable;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.ListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.ListVisitFromServerWritable;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Readiable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Waitable;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.stream.Collectors;

public class NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl implements ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata>,
Waitable<List<HasMetadata>, HasMetadata>, Readiable {
  
  static class ChangeNamespace extends TypedVisitor<ObjectMetaBuilder> {

    private final String explicitNamespace;

    ChangeNamespace(String explicitNamespace) {
      this.explicitNamespace = explicitNamespace;
    }

    @Override
    public void visit(ObjectMetaBuilder builder) {
      builder.withNamespace(explicitNamespace);
    }
  }

  private static final Logger LOGGER = LoggerFactory.getLogger(NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl.class);
  protected static final String EXPRESSION = "expression";
  protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private final NamespaceVisitOperationContext namespaceVisitOperationContext;
  private OperationContext context;
  
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OperationContext context, NamespaceVisitOperationContext namespaceVisitOperationContext) {
    this.namespaceVisitOperationContext = namespaceVisitOperationContext;
    this.context = context;
  }
  
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(ClientContext clientContext, Object item) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext).withItem(item), new NamespaceVisitOperationContext());
  }

  @Override
  public List<HasMetadata> waitUntilReady(final long amount, final TimeUnit timeUnit) {
    return waitUntilCondition(resource -> Objects.nonNull(resource) && getReadiness().isReady(resource), amount, timeUnit);
  }
  
  List<HasMetadata> getItems() {
    Object item = context.getItem();
    
    if (item instanceof InputStream) {
      item = Serialization.unmarshal((InputStream)item, Collections.emptyMap());
      context = context.withItem(item); // late realization of the inputstream
    } 
    
    return asHasMetadata(item).stream()
        .map(meta -> acceptVisitors(meta,
            Collections.emptyList(), namespaceVisitOperationContext.getExplicitNamespace(), this.context))
        .collect(Collectors.toList());
  }
  
  @Override
  public List<NamespaceableResource<io.fabric8.kubernetes.api.model.HasMetadata>> getResources() {
    return getItems().stream()
        .map(this::getResource)
        .collect(Collectors.toList());
  }
  
  /**
   * similar to {@link KubernetesClient#resource(HasMetadata)}, but we want to inherit the context
   * The namespacing is the same - use the item namespace if available 
   */
  NamespaceableResource<HasMetadata> getResource(HasMetadata meta) {
    OperationContext ctx = context.withItem(null);
    ResourceHandler<HasMetadata, ?> handler = handlerOf(meta, context);
    return new NamespaceableResourceAdapter<>(meta, handler.operation(ctx, null).newInstance(ctx));
  }

  @Override
  public List<HasMetadata> waitUntilCondition(Predicate<HasMetadata> condition,
                                              long amount,
                                              TimeUnit timeUnit) {
    List<? extends Resource<HasMetadata>> operations = getResources();
    if (operations.isEmpty()) {
      return Collections.emptyList();
    }
    // this strategy is very costly in terms of threads - by not exposing the underlying futures
    // we have to create a thread for each item that mostly waits
    final ExecutorService executor = Executors.newFixedThreadPool(operations.size(), Utils.daemonThreadFactory(this));
    try {
      List<HasMetadata> items = operations.stream().map(Resource::get).collect(Collectors.toList());
      final List<CompletableFuture<HasMetadata>> futures = new ArrayList<>(items.size());
      for (final Resource<HasMetadata> impl : operations) {
        futures.add(CompletableFuture.supplyAsync(() -> impl.waitUntilCondition(condition, amount, timeUnit)));
      }
  
      final List<HasMetadata> results = new ArrayList<>();
      final List<HasMetadata> itemsWithConditionNotMatched = new ArrayList<>();
  
      for (int i = 0; i < items.size(); i++) {
        final HasMetadata meta = items.get(i);
        try {
          CompletableFuture<HasMetadata> future = futures.get(i);
          // just get each result as the timeout is enforced below
          results.add(future.get());
        } catch (ExecutionException e) {
          itemsWithConditionNotMatched.add(meta);
          logAsNotReady(e.getCause(), meta);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw KubernetesClientException.launderThrowable(e);
        }
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
  public boolean isReady() {
    return getResources().stream().map(impl -> impl.get()).allMatch(meta -> getReadiness().isReady(meta));
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> withParameters(Map<String, String> parameters) {
    Object item = Serialization.unmarshal((InputStream)context.getItem(), parameters);
    return newInstance(context.withItem(item), namespaceVisitOperationContext);
  }

  @Override
  public ListVisitFromServerWritable<HasMetadata> dryRun(boolean isDryRun) {
    return newInstance(this.context.withDryRun(isDryRun), namespaceVisitOperationContext);
  }

  @Override
  public List<HasMetadata> apply() {
    return createOrReplace();
  }

  @Override
  public List<HasMetadata> createOrReplace() {
    List<? extends Resource<HasMetadata>> operations = getResources();

    if (!namespaceVisitOperationContext.isDeletingExisting()) {
      return operations.stream()
          .map(Resource::createOrReplace)
          .filter(Objects::nonNull)
          .collect(Collectors.toList());
    }
    operations.stream().forEach(Resource::delete);
    waitUntilCondition(Objects::isNull, 30, TimeUnit.SECONDS);
    return operations.stream()
        .map(Resource::create)
        .collect(Collectors.toList());
  }

  @Override
  public Waitable<List<HasMetadata>, HasMetadata> createOrReplaceAnd() {
    return newInstance(context.withItem(createOrReplace()), namespaceVisitOperationContext);
  }

  @Override
  public Boolean delete() {
    for (Resource<HasMetadata> impl :  getResources()) {
      if (Boolean.FALSE.equals(impl.delete())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<HasMetadata> get() {
    return getResources().stream().map(Resource::get).collect(Collectors.toList());
  }

  @Override
  public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> inNamespace(String explicitNamespace) {
    return newInstance(context.withNamespace(explicitNamespace), namespaceVisitOperationContext.withExplicitNamespace(explicitNamespace));
  }

  @Override
  public Gettable<List<HasMetadata>> fromServer() {
    return newInstance(context.withReloadingFromServer(true), namespaceVisitOperationContext);
  }

  @Override
  public Applicable<List<HasMetadata>> deletingExisting() {
    return newInstance(context, namespaceVisitOperationContext.withDeletingExisting(true));
  }
  
  @Override
  public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> accept(Visitor... visitors) {
    return newInstance(context.withItem(getItems().stream()
        .map(i -> acceptVisitors(i, Arrays.asList(visitors), namespaceVisitOperationContext.getExplicitNamespace(), context))
        .collect(Collectors.toList())), namespaceVisitOperationContext);
  }

  @Override public CascadingDeletable<List<HasMetadata>> withGracePeriod(long gracePeriodSeconds)
  {
    return newInstance(context.withGracePeriodSeconds(gracePeriodSeconds), namespaceVisitOperationContext);
  }

  @Override public CascadingDeletable<List<HasMetadata>> withPropagationPolicy(DeletionPropagation propagationPolicy)
  {
    return newInstance(context.withPropagationPolicy(propagationPolicy), namespaceVisitOperationContext);
  }

  @Override
  public Waitable<List<HasMetadata>, HasMetadata> withWaitRetryBackoff(long initialBackoff, TimeUnit backoffUnit, double backoffMultiplier) {
    return this;
  }

  @Override
  public Deletable cascading(boolean cascading) {
    return newInstance(context.withCascading(cascading), namespaceVisitOperationContext);
  }

  protected Readiness getReadiness() {
    return Readiness.getInstance();
  }

  protected List<HasMetadata> asHasMetadata(Object item) {
    List<HasMetadata> result = new ArrayList<>();
    if (item instanceof KubernetesList) {
      result.addAll(((KubernetesList) item).getItems());
    } else if (item instanceof KubernetesResourceList) {
      result.addAll(((KubernetesResourceList) item).getItems());
    } else if (item instanceof HasMetadata) {
      result.add((HasMetadata) item);
    } else if (item instanceof String) {
      return asHasMetadata(Serialization.unmarshal((String)item));
    } else if (item instanceof Collection) {
      for (Object o : (Collection)item) {
        if (o instanceof HasMetadata) {
          result.add((HasMetadata) o);
        }
      }
    } else if (item != null) {
      throw new IllegalArgumentException("Could not convert item to a list of HasMetadata");
    }
    return result;
  }
  
  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl newInstance(OperationContext context, NamespaceVisitOperationContext namespaceVisitOperationContext) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(context, namespaceVisitOperationContext);
  }
  
  static HasMetadata acceptVisitors(HasMetadata item, List<Visitor> visitors, String explicitNamespace, OperationContext context) {
    ResourceHandler<HasMetadata, ?> h = handlerOf(item, context);
    VisitableBuilder<HasMetadata, ?> builder = h.edit(item);

    //Let's apply any visitor that might have been specified.
    for (Visitor v : visitors) {
      builder.accept(v);
    }
    if (explicitNamespace != null) {
      builder.accept(new ChangeNamespace(explicitNamespace));
    }
    return builder.build();
  }

  static <T extends HasMetadata, V extends VisitableBuilder<T, V>> ResourceHandler<T, V> handlerOf(T item, OperationContext context) {
    return Handlers.get(item, new BaseClient(context));
  }

}
