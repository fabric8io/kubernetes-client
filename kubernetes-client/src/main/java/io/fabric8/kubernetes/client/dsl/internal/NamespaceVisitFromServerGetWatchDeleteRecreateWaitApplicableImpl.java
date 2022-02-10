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

import io.fabric8.kubernetes.api.builder.TypedVisitor;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.ClientContext;
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
import io.fabric8.kubernetes.client.dsl.Resource;
import io.fabric8.kubernetes.client.dsl.VisitFromServerGetWatchDeleteRecreateWaitApplicable;
import io.fabric8.kubernetes.client.dsl.VisitFromServerWritable;
import io.fabric8.kubernetes.client.dsl.Waitable;
import io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.readiness.Readiness;
import io.fabric8.kubernetes.client.utils.KubernetesResourceUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static io.fabric8.kubernetes.client.utils.DeleteAndCreateHelper.deleteAndCreateItem;

/**
 * Resource like operation with specific namespace rules.
 * <br>If the item has a namespace, it is the default (unlike other operations)
 * <br>If the user call inNamespace, that will be used
 * <br>else the default namespace from the config will be used
 */
public class NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl implements
  NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata>,
  Waitable<HasMetadata, HasMetadata>,
  Readiable {

  private final NamespaceVisitOperationContext namespaceVisitOperationContext;
  private final OperationContext context;

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

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(OperationContext context, NamespaceVisitOperationContext namespaceVisitOperationContext) {
    this.context = context;
    this.namespaceVisitOperationContext = namespaceVisitOperationContext;
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(ClientContext clientContext, HasMetadata item) {
    this(HasMetadataOperationsImpl.defaultContext(clientContext).withItem(item), new NamespaceVisitOperationContext());
    handlerOf(item, this.context); // validate the handler
  }

  @Override
  public HasMetadata apply() {
    return createOrReplace();
  }

  @Override
  public HasMetadata createOrReplace() {
    if (namespaceVisitOperationContext.isDeletingExisting()) {
      return deleteAndCreateItem(get(), getResource());
    }
    return getResource().createOrReplace(get());
  }

  @Override
  public Waitable<HasMetadata, HasMetadata> createOrReplaceAnd() {
    HasMetadata item = createOrReplace();
    return newInstance(context.withItem(item), namespaceVisitOperationContext);
  }

  @Override
  public Boolean delete() {
    return getResource().delete();
  }

  @Override
  public HasMetadata get() {
    if (!context.isReloadingFromServer()) {
      return (HasMetadata) context.getItem();
    }
    return getResource().get();
  }

  @Override
  public VisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> inNamespace(String explicitNamespace) {
    HasMetadata item = acceptVisitors(get(), Collections.emptyList(), explicitNamespace, this.context);
    return newInstance(context.withItem(item).withNamespace(explicitNamespace), namespaceVisitOperationContext.withExplicitNamespace(explicitNamespace));
  }

  @Override
  public Gettable<HasMetadata> fromServer() {
    return getResource().fromServer();
  }

  @Override
  public Applicable<HasMetadata> deletingExisting() {
    return newInstance(context, namespaceVisitOperationContext.withDeletingExisting(true));
  }

  @Override
  public VisitFromServerGetWatchDeleteRecreateWaitApplicable<HasMetadata> accept(Visitor... visitors) {
    HasMetadata item = acceptVisitors(get(), Arrays.asList(visitors), namespaceVisitOperationContext.getExplicitNamespace(), this.context);
    return newInstance(context.withItem(item), namespaceVisitOperationContext);
  }

  @Override
  public CascadingDeletable<HasMetadata> withGracePeriod(long gracePeriodSeconds) {
    return newInstance(context.withGracePeriodSeconds(gracePeriodSeconds), namespaceVisitOperationContext);
  }

  @Override
  public CascadingDeletable<HasMetadata> withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return newInstance(context.withPropagationPolicy(propagationPolicy), namespaceVisitOperationContext);
  }

  @Override
  public Deletable cascading(boolean cascading) {
    return getResource().cascading(cascading);
  }

  @Override
  public Waitable<HasMetadata, HasMetadata> withWaitRetryBackoff(long initialBackoff, TimeUnit backoffUnit, double backoffMultiplier) {
    return this;
  }

  @Override
  public Watch watch(Watcher<HasMetadata> watcher) {
    return getResource().watch(watcher);
  }

  @Override
  public Watch watch(String resourceVersion, Watcher<HasMetadata> watcher) {
    return getResource().watch(resourceVersion, watcher);
  }

  @Override
  public Watch watch(ListOptions options, Watcher<HasMetadata> watcher) {
    return getResource().watch(options, watcher);
  }
  
  Resource<HasMetadata> getResource() {
    HasMetadata meta = (HasMetadata) context.getItem();
    ResourceHandler<HasMetadata, ?> handler = handlerOf(meta, context);
    HasMetadataOperation<HasMetadata, ?, Resource<HasMetadata>> operation = handler.operation(context, null);
    return operation.newInstance(context).inNamespace(KubernetesResourceUtil.getNamespace(meta)).withName(KubernetesResourceUtil.getName(meta));
  }

  protected Readiness getReadiness() {
    return Readiness.getInstance();
  }

  @Override
  public final boolean isReady() {
    HasMetadata meta = fromServer().get();
    if (meta == null) {
      return false;
    }
    return getReadiness().isReady(meta);
  }

  @Override
  public HasMetadata waitUntilReady(long amount, TimeUnit timeUnit) {
    return getResource().waitUntilReady(amount, timeUnit);
  }

  @Override
  public VisitFromServerWritable<HasMetadata> dryRun(boolean isDryRun) {
    return newInstance(context.withDryRun(isDryRun), namespaceVisitOperationContext);
  }

  public NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl newInstance(OperationContext context, NamespaceVisitOperationContext namespaceVisitOperationContext) {
    return new NamespaceVisitFromServerGetWatchDeleteRecreateWaitApplicableImpl(context, namespaceVisitOperationContext);
  }
  
  @Override
  public HasMetadata waitUntilCondition(Predicate<HasMetadata> condition, long amount, TimeUnit timeUnit) {
    return getResource().waitUntilCondition(condition, amount, timeUnit);
  }
  
  @Override
  public <V> HasMetadata edit(Class<V> visitorType, Visitor<V> visitor) {
    return getResource().edit(visitorType, visitor);
  }
  
  @Override
  public HasMetadata edit(UnaryOperator<HasMetadata> function) {
    return getResource().edit(function);
  }
  
  @Override
  public HasMetadata edit(Visitor... visitors) {
    return getResource().edit(visitors);
  }
  
  @Override
  public HasMetadata accept(Consumer<HasMetadata> function) {
    return getResource().accept(function);
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
    ResourceHandler<T, V> result = Handlers.get(item, new BaseClient(context));
    if (result == null) {
      throw new KubernetesClientException("Could not find a registered handler for item: [" + item + "].");
    }
    return result;
  }

}
