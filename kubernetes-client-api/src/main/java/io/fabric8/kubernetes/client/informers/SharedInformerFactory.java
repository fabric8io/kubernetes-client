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

package io.fabric8.kubernetes.client.informers;

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.dsl.Informable;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;

import java.util.concurrent.Future;

public interface SharedInformerFactory {

    /**
     * Configure Namespace for {@link SharedInformerFactory}
     *
     * @param namespace namespace to configure
     * @return {@link SharedInformerFactory} with namespace configured
     * @deprecated use {@link Informable} instead
     */
    @Deprecated
    SharedInformerFactory inNamespace(String namespace);

    /**
     * Configure Name for {@link SharedInformerFactory}
     *
     * @param name name to be configured
     * @return {@link SharedInformerFactory} with name configured
     * @deprecated use {@link Informable} instead
     */
    @Deprecated
    SharedInformerFactory withName(String name);

    /**
     * Constructs and returns a shared index informer with resync period specified. And the
     * informer cache will be overwritten.
     *
     * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
     *
     * @param apiTypeClass apiType class
     * @param resyncPeriodInMillis resync period in milliseconds
     * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced}) if Namespace scoped resource
     * @return the shared index informer
     */
    <T extends HasMetadata> SharedIndexInformer<T> sharedIndexInformerFor(Class<T> apiTypeClass,
            long resyncPeriodInMillis);

    /**
     * Constructs and returns a shared index informer with resync period specified for custom resources.
     *
     * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
     *
     * @param customResourceContext basic information about the Custom Resource Definition corresponding to that custom resource
     * @param apiTypeClass apiType class
     * @param apiListTypeClass api list type class
     * @param resyncPeriodInMillis resync period in milliseconds
     * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
     * @param <L> the type's list parameter (should extend {@link io.fabric8.kubernetes.api.model.KubernetesResourceList}
     * @return the shared index informer
     * @deprecated Since 5.x versions of client {@link CustomResourceDefinitionContext} are configured via annotations in CustomResource implementations, please use any of the alternative sharedIndexInformerForCustomResource methods
     */
    @Deprecated
    <T extends CustomResource<?, ?>, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
            CustomResourceDefinitionContext customResourceContext, Class<T> apiTypeClass, Class<L> apiListTypeClass,
            long resyncPeriodInMillis);

    /**
     * Constructs and returns a shared index informer with resync period specified for a Custom Resource. You
     * can use it for scenarios where you don't have a POJO for your custom type by specifying group, version and plural in
     * {@link CustomResourceDefinitionContext}
     *
     * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
     *
     * @param genericResourceContext object containing details about resource like apiGroup, version and plural, etc.
     * @param resyncPeriodInMillis resync period in milliseconds.
     * @return {@link SharedIndexInformer} for GenericKubernetesResource
     * @deprecated use {@link #sharedIndexInformerFor(Class, long)}
     */
    @Deprecated
    SharedIndexInformer<GenericKubernetesResource> sharedIndexInformerForCustomResource(
            ResourceDefinitionContext genericResourceContext, long resyncPeriodInMillis);

    /**
     * Constructs and returns a shared index informer with resync period specified for custom resources.
     * POJO
     *
     * @param apiTypeClass apiType class
     * @param resyncPeriodInMillis  resync period in milliseconds
     * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
     * @return the shared index informer
     * @deprecated use {@link #sharedIndexInformerFor(Class, long)} instead
     */
    @Deprecated
    <T extends CustomResource<?, ?>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
            Class<T> apiTypeClass, long resyncPeriodInMillis);

    /**
     * Constructs and returns a shared index informer with resync period specified for custom resources.
     *
     * <b>Note:</b>It watches for events in <b>ALL NAMESPACES</b>.
     *
     * @param apiTypeClass apiType class
     * @param apiListTypeClass api list type class
     * @param resyncPeriodInMillis resync period in milliseconds
     * @param <T> the type parameter (should extend {@link io.fabric8.kubernetes.api.model.HasMetadata} and implement {@link io.fabric8.kubernetes.api.model.Namespaced})
     * @param <L> the type's list parameter (should extend {@link io.fabric8.kubernetes.api.model.KubernetesResourceList}
     * @return the shared index informer
     * @deprecated use {@link #sharedIndexInformerFor(Class, long)}
     */
    @Deprecated
    <T extends CustomResource<?, ?>, L extends KubernetesResourceList<T>> SharedIndexInformer<T> sharedIndexInformerForCustomResource(
            Class<T> apiTypeClass, Class<L> apiListTypeClass, long resyncPeriodInMillis);

    /**
     * Gets existing shared index informer, return null if the requesting informer
     * is never constructed. If there are multiple SharedIndexInformer objects corresponding
     * to a Kubernetes resource, then it returns the first one
     *
     * @param apiTypeClass API type class
     * @param <T> type of API type
     * @return SharedIndexInformer object
     */
    <T> SharedIndexInformer<T> getExistingSharedIndexInformer(Class<T> apiTypeClass);

    /**
     * Starts all registered informers in an asynchronous fashion.
     *
     * @return {@link Future} for status of all started informer tasks.
     */
    Future<Void> startAllRegisteredInformers();

    /**
     * Stop all registered informers and shut down thread pool.
     */
    void stopAllRegisteredInformers();

    /**
     * Stop all registered informers
     *
     * @param shutDownThreadPool Whether to shut down thread pool or not.
     */
    void stopAllRegisteredInformers(boolean shutDownThreadPool);

    void addSharedInformerEventListener(SharedInformerEventListener event);

}
