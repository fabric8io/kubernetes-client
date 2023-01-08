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
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.StatusDetails;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.KubernetesClientTimeoutException;
import io.fabric8.kubernetes.client.dsl.DeletableWithOptions;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.ListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.ListVisitFromServerWritable;
import io.fabric8.kubernetes.client.dsl.NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.NamespaceableResource;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.Waitable;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.Serialization;
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
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl
    implements ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata>,
    Waitable<List<HasMetadata>, HasMetadata> {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl.class);
  protected static final String EXPRESSION = "expression";
  protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private OperationContext context;

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(OperationContext context) {
    this.context = context;
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(Client client, Object item) {
    this(HasMetadataOperationsImpl.defaultContext(client).withItem(item));
  }

  @Override
  public List<HasMetadata> waitUntilReady(final long amount, final TimeUnit timeUnit) {
    return waitUntilCondition(resource -> Objects.nonNull(resource) && getReadiness().isReady(resource), amount, timeUnit);
  }

  List<HasMetadata> getItems() {
    Object item = context.getItem();

    return asHasMetadata(item).stream()
        .map(meta -> acceptVisitors(meta,
            Collections.emptyList(), this.context))
        .collect(Collectors.toList());
  }

  @Override
  public List<HasMetadata> items() {
    return getItems();
  }

  @Override
  public Stream<NamespaceableResource<HasMetadata>> resources() {
    return getItems().stream()
        .map(this::getResource);
  }

  public List<NamespaceableResource<io.fabric8.kubernetes.api.model.HasMetadata>> getResources() {
    return resources().collect(Collectors.toList());
  }

  /**
   * similar to {@link KubernetesClient#resource(HasMetadata)}, but we want to inherit the context
   * The namespacing is the same - use the item namespace if available
   */
  NamespaceableResource<HasMetadata> getResource(HasMetadata meta) {
    return context.clientInWriteContext(KubernetesClient.class).resource(meta);
  }

  @Override
  public List<HasMetadata> waitUntilCondition(Predicate<HasMetadata> condition,
      long amount,
      TimeUnit timeUnit) {
    List<? extends Resource<HasMetadata>> operations = getResources();
    if (operations.isEmpty()) {
      return Collections.emptyList();
    }
    List<HasMetadata> items = operations.stream().map(Resource::item).collect(Collectors.toList());
    final List<CompletableFuture<List<HasMetadata>>> futures = new ArrayList<>(items.size());
    for (final Resource<HasMetadata> impl : operations) {
      CompletableFuture<List<HasMetadata>> futureCondition = impl.informOnCondition(l -> {
        if (l.isEmpty()) {
          return condition.test(null);
        }
        return condition.test(l.get(0));
      });

      futures.add(futureCondition);
    }

    final List<HasMetadata> results = new ArrayList<>();
    final List<HasMetadata> itemsWithConditionNotMatched = new ArrayList<>();

    long finish = System.nanoTime() + timeUnit.toNanos(amount);

    for (int i = 0; i < items.size(); i++) {
      final HasMetadata meta = items.get(i);
      CompletableFuture<List<HasMetadata>> future = futures.get(i);
      try {
        results.add(future.thenApply(l -> l.isEmpty() ? null : l.get(0)).get(Math.max(0, finish - System.nanoTime()),
            TimeUnit.NANOSECONDS));
      } catch (TimeoutException e) {
        itemsWithConditionNotMatched.add(meta);
        logAsNotReady(e, meta);
      } catch (ExecutionException e) {
        itemsWithConditionNotMatched.add(meta);
        logAsNotReady(e.getCause(), meta);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw KubernetesClientException.launderThrowable(e);
      } finally {
        future.cancel(true);
      }
    }

    if (!itemsWithConditionNotMatched.isEmpty()) {
      throw new KubernetesClientTimeoutException(itemsWithConditionNotMatched, amount, timeUnit);
    }

    return results;
  }

  private static void logAsNotReady(Throwable t, HasMetadata meta) {
    LOGGER.warn(
        "Error while waiting for: [{}] with name: [{}] in namespace: [{}]: {}. The resource will be considered not ready.",
        meta.getKind(), meta.getMetadata().getName(), meta.getMetadata().getNamespace(), t.getMessage());
    LOGGER.debug("The error stack trace:", t);
  }

  @Override
  public NamespaceListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> withParameters(
      Map<String, String> parameters) {
    Object item = Serialization.unmarshal((InputStream) context.getItem(), parameters);
    return newInstance(context.withItem(item));
  }

  @Override
  public ListVisitFromServerWritable<HasMetadata> dryRun(boolean isDryRun) {
    return newInstance(this.context.withDryRun(isDryRun));
  }

  @Override
  public ListVisitFromServerWritable<HasMetadata> fieldValidation(Validation fieldValidation) {
    return newInstance(this.context.withFieldValidation(fieldValidation));
  }

  @Override
  public List<HasMetadata> createOrReplace() {
    List<? extends Resource<HasMetadata>> operations = getResources();

    return operations.stream()
        .map(Resource::createOrReplace)
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
  }

  @Override
  public List<StatusDetails> delete() {
    List<StatusDetails> deleted = resources().flatMap(r -> r.delete().stream()).collect(Collectors.toList());
    BaseOperation.waitForDelete(deleted, this.context, this);
    return deleted;
  }

  @Override
  public List<HasMetadata> get() {
    return performOperation(Resource::get);
  }

  @Override
  public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> inNamespace(String explicitNamespace) {
    if (explicitNamespace == null) {
      throw new KubernetesClientException("namespace cannot be null");
    }
    return newInstance(context.withNamespace(explicitNamespace));
  }

  @Override
  public Gettable<List<HasMetadata>> fromServer() {
    return this;
  }

  @Override
  public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> accept(Visitor... visitors) {
    return newInstance(context.withItem(getItems().stream()
        .map(i -> acceptVisitors(i, Arrays.asList(visitors), context))
        .collect(Collectors.toList())));
  }

  @Override
  public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> withGracePeriod(long gracePeriodSeconds) {
    return newInstance(context.withGracePeriodSeconds(gracePeriodSeconds));
  }

  @Override
  public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> withPropagationPolicy(
      DeletionPropagation propagationPolicy) {
    return newInstance(context.withPropagationPolicy(propagationPolicy));
  }

  protected Readiness getReadiness() {
    return Readiness.getInstance();
  }

  protected List<HasMetadata> asHasMetadata(Object item) {
    List<HasMetadata> result = new ArrayList<>();
    if (item instanceof KubernetesResourceList) {
      result.addAll(((KubernetesResourceList) item).getItems());
    } else if (item instanceof HasMetadata) {
      result.add((HasMetadata) item);
    } else if (item instanceof Collection) {
      for (Object o : (Collection) item) {
        if (o != null) {
          result.add((HasMetadata) o);
        }
      }
    } else if (item != null) {
      throw new IllegalArgumentException("Could not convert item to a list of HasMetadata");
    }
    return result;
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl newInstance(OperationContext context) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableListImpl(context);
  }

  static HasMetadata acceptVisitors(HasMetadata item, List<Visitor> visitors, OperationContext context) {
    if (!visitors.isEmpty()) {
      VisitableBuilder<HasMetadata, ?> builder = context.getHandler(item).edit(item);

      //Let's apply any visitor that might have been specified.
      for (Visitor v : visitors) {
        builder.accept(v);
      }
      item = builder.build();
    }
    return item;
  }

  @Override
  public List<HasMetadata> create() {
    return performOperation(Resource::create);
  }

  @Override
  public ListVisitFromServerWritable<HasMetadata> dryRun() {
    return dryRun(true);
  }

  @Override
  public ListVisitFromServerGetDeleteRecreateWaitApplicable<HasMetadata> inAnyNamespace() {
    return newInstance(context.withNamespace(null));
  }

  @Override
  public List<HasMetadata> replace() {
    return performOperation(Resource::replace);
  }

  private List<HasMetadata> performOperation(
      Function<? super NamespaceableResource<HasMetadata>, ? extends HasMetadata> operation) {
    return getResources().stream().map(operation).collect(Collectors.toList());
  }

  @Override
  public List<HasMetadata> replaceStatus() {
    return performOperation(Resource::replaceStatus);
  }

  @Override
  public DeletableWithOptions withTimeout(long timeout, TimeUnit unit) {
    return newInstance(context.withTimeout(timeout, unit));
  }

  @Override
  public DeletableWithOptions withTimeoutInMillis(long timeoutInMillis) {
    return this.withTimeout(timeoutInMillis, TimeUnit.MILLISECONDS);
  }

}
