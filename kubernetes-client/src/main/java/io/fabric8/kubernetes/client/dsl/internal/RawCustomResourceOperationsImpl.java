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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.fabric8.kubernetes.api.model.DeleteOptions;
import io.fabric8.kubernetes.api.model.DeletionPropagation;
import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.api.model.GenericKubernetesResourceList;
import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.api.model.ListOptionsBuilder;
import io.fabric8.kubernetes.client.ClientState;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.GracePeriodConfigurable;
import io.fabric8.kubernetes.client.PropagationPolicyConfigurable;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.WatcherException;
import io.fabric8.kubernetes.client.dsl.AnyNamespaceable;
import io.fabric8.kubernetes.client.dsl.Deletable;
import io.fabric8.kubernetes.client.dsl.DryRunable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.Listable;
import io.fabric8.kubernetes.client.dsl.Nameable;
import io.fabric8.kubernetes.client.dsl.Namespaceable;
import io.fabric8.kubernetes.client.dsl.base.CustomResourceDefinitionContext;
import io.fabric8.kubernetes.client.dsl.base.OperationContext;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.client.utils.Utils;
import io.fabric8.kubernetes.model.Scope;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import static io.fabric8.kubernetes.client.dsl.base.HasMetadataOperation.DEFAULT_PROPAGATION_POLICY;

/**
 * This class simple does basic operations for custom defined resources without
 * demanding the POJOs for custom resources. It is serializing/deserializing
 * objects to plain hash map(String, Object).
 *
 * Right now it supports basic operations like GET, POST, PUT, DELETE.
 *
 */
public class RawCustomResourceOperationsImpl implements Nameable<RawCustomResourceOperationsImpl>,
  Namespaceable<RawCustomResourceOperationsImpl>,
  AnyNamespaceable<RawCustomResourceOperationsImpl>,
  Listable<Map<String, Object>>,
  Gettable<Map<String, Object>>,
  GracePeriodConfigurable<RawCustomResourceOperationsImpl>,
  PropagationPolicyConfigurable<RawCustomResourceOperationsImpl>,
  DryRunable<RawCustomResourceOperationsImpl>,
  Deletable {

  private final GenericKubernetesResourceOperationsImpl delegate;
  private final CustomResourceDefinitionContext customResourceDefinition;

  private RawCustomResourceOperationsImpl(GenericKubernetesResourceOperationsImpl delegate, CustomResourceDefinitionContext crdContext) {
    this.delegate = delegate;
    this.customResourceDefinition = crdContext;
  }

  public RawCustomResourceOperationsImpl(ClientState clientState, CustomResourceDefinitionContext customResourceDefinition) {
    this(
      new GenericKubernetesResourceOperationsImpl(
        new OperationContext()
          .withHttpClient(clientState.getHttpClient())
          .withConfig(clientState.getConfiguration())
          .withNamespace(null)
          .withName(null)
          .withGracePeriodSeconds(-1L)
          .withCascading(false)
          .withDryRun(false)
          .withPropagationPolicy(DEFAULT_PROPAGATION_POLICY)
          .withApiGroupName(customResourceDefinition.getGroup())
          .withApiGroupVersion(customResourceDefinition.getVersion())
          .withPlural(customResourceDefinition.getPlural()),
        Scope.NAMESPACED.value().equals(customResourceDefinition.getScope())
      ),
      customResourceDefinition
    );
  }

  @Override
  public RawCustomResourceOperationsImpl withName(String name) {
    return new RawCustomResourceOperationsImpl((GenericKubernetesResourceOperationsImpl) delegate.withName(name), customResourceDefinition);
  }

  @Override
  public RawCustomResourceOperationsImpl inNamespace(String namespace) {
    return new RawCustomResourceOperationsImpl((GenericKubernetesResourceOperationsImpl) delegate.inNamespace(namespace), customResourceDefinition);
  }

  @Override
  public RawCustomResourceOperationsImpl inAnyNamespace() {
    return new RawCustomResourceOperationsImpl((GenericKubernetesResourceOperationsImpl) delegate.inAnyNamespace(), customResourceDefinition);
  }

  @Override
  public RawCustomResourceOperationsImpl withGracePeriod(long gracePeriodSeconds) {
    return new RawCustomResourceOperationsImpl((GenericKubernetesResourceOperationsImpl) delegate.withGracePeriod(gracePeriodSeconds), customResourceDefinition);
  }

  @Override
  public RawCustomResourceOperationsImpl withPropagationPolicy(DeletionPropagation propagationPolicy) {
    return new RawCustomResourceOperationsImpl((GenericKubernetesResourceOperationsImpl) delegate.withPropagationPolicy(propagationPolicy), customResourceDefinition);
  }

  @Override
  public RawCustomResourceOperationsImpl dryRun(boolean isDryRun) {
    return new RawCustomResourceOperationsImpl((GenericKubernetesResourceOperationsImpl) delegate.dryRun(isDryRun), customResourceDefinition);
  }

  public Config getConfig() {
    return delegate.getConfig();
  }

  private RawCustomResourceOperationsImpl withDeleteOptions(DeleteOptions deleteOptions) {
    return new RawCustomResourceOperationsImpl((GenericKubernetesResourceOperationsImpl) delegate.withGracePeriod(resolveGracePeriod(deleteOptions.getGracePeriodSeconds())).withPropagationPolicy(resolvePropagationPolicy(deleteOptions.getPropagationPolicy())), customResourceDefinition);
  }

  /**
   * Load a custom resource object from an InputStream into a HashMap
   *
   * @param inputStream input stream
   * @return custom resource as HashMap
   * @throws IOException exception in case any read operation fails.
   */
  public Map<String, Object> load(InputStream inputStream) throws IOException {
    return toMap(delegate.load(inputStream).get());
  }

  /**
   * Load a custom resource object from a JSON string into a HashMap
   *
   * @param objectAsJsonString object as JSON string
   * @return custom resource as HashMap
   * @throws IOException exception in case any problem in reading json.
   */
  public Map<String, Object> load(String objectAsJsonString) throws IOException {
    return toMap(delegate.load(new ByteArrayInputStream(objectAsJsonString.getBytes(StandardCharsets.UTF_8))).get());
  }

  /**
   * Create a custom resource which is a non-namespaced object.
   *
   * @param objectAsString object as JSON string
   * @return Object as HashMap
   * @throws IOException exception in case of any network/read problems
   */
  public Map<String, Object> create(String objectAsString) throws IOException {
    return toMap(delegate.create(
      Serialization.jsonMapper().readValue(objectAsString, GenericKubernetesResource.class)));
  }

  /**
   * Create a custom resource which is non-namespaced.
   *
   * @param object object a HashMap
   * @return Object as HashMap
   * @throws IOException in case of problems while reading HashMap
   */
  public Map<String, Object> create(Map<String, Object> object) throws IOException {
    return toMap(delegate.create(Serialization.jsonMapper().convertValue(object, GenericKubernetesResource.class)));
  }

  /**
   * Create a custom resource which is a namespaced object.
   *
   * @param namespace      namespace in which we want object to be created.
   * @param objectAsString Object as JSON string
   * @return Object as HashMap
   * @throws IOException in case of problems while reading JSON object
   * @deprecated Use {@link #inNamespace(String)}.{@link #create(String)} instead.
   */
  @Deprecated
  public Map<String, Object> create(String namespace, String objectAsString) throws IOException {
    return toMap(delegate.inNamespace(namespace)
      .create(Serialization.unmarshal(objectAsString, GenericKubernetesResource.class)));
  }

  /**
   * Create a custom resource which is non-namespaced object.
   *
   * @param objectAsStream object as a file input stream
   * @return Object as HashMap
   * @throws IOException in case of problems while reading file
   */
  public Map<String, Object> create(InputStream objectAsStream) throws IOException {
    return toMap(delegate
      .create(Serialization.unmarshal(objectAsStream, GenericKubernetesResource.class)));
  }

  /**
   * Create a custom resource which is a namespaced object.
   *
   * @param namespace      namespace in which we want object to be created
   * @param objectAsStream object as file input stream
   * @return Object as HashMap
   * @throws IOException in case of problems while reading file
   * @deprecated Use {@link #inNamespace(String)}.{@link #create(InputStream)} instead.
   */
  @Deprecated
  public Map<String, Object> create(String namespace, InputStream objectAsStream) throws IOException {
    return toMap(delegate.inNamespace(namespace)
      .create(Serialization.unmarshal(objectAsStream, GenericKubernetesResource.class)));
  }

  /**
   * Create a custom resource which is a namespaced object.
   *
   * @param namespace namespace in which we want object to be created.
   * @param object    object as a HashMap
   * @return Object as HashMap
   * @throws IOException in case of problems faced while serializing HashMap
   * @deprecated Use {@link #inNamespace(String)}.{@link #create(Map)} instead.
   */
  @Deprecated
  public Map<String, Object> create(String namespace, Map<String, Object> object) throws IOException {
    return toMap(delegate.inNamespace(namespace)
      .create(Serialization.jsonMapper().convertValue(object, GenericKubernetesResource.class)));
  }

  /**
   * Create or replace a custom resource which is a non-namespaced object.
   *
   * @param objectAsString object as JSON string
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   */
  public Map<String, Object> createOrReplace(String objectAsString) throws IOException {
    return toMap(delegate
      .createOrReplace(Serialization.unmarshal(objectAsString, GenericKubernetesResource.class)));
  }

  /**
   * Create or replace a custom resource which is a non-namespced object.
   *
   * @param customResourceObject object as HashMap
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   */
  public Map<String, Object> createOrReplace(Map<String, Object> customResourceObject) throws IOException {
    return toMap(delegate
      .createOrReplace(Serialization.jsonMapper().convertValue(customResourceObject, GenericKubernetesResource.class)));
  }

  /**
   * Create or replace a custom resource which is non-namespaced object.
   *
   * @param inputStream object as file input stream
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   */
  public Map<String, Object> createOrReplace(InputStream inputStream) throws IOException {
    return toMap(delegate.createOrReplace(Serialization.unmarshal(inputStream, GenericKubernetesResource.class)));
  }

  /**
   * Create or replace a custom resource which is namespaced object.
   *
   * @param namespace      desired namespace
   * @param objectAsString object as JSON String
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   * @deprecated Use {@link #inNamespace(String)}.{@link #createOrReplace(String)} instead.
   */
  @Deprecated
  public Map<String, Object> createOrReplace(String namespace, String objectAsString) throws IOException {
    return toMap(delegate.inNamespace(namespace)
      .createOrReplace(Serialization.unmarshal(objectAsString, GenericKubernetesResource.class)));
  }

  /**
   * Create or replace a custom resource which is namespaced object.
   *
   * @param namespace            desired namespace
   * @param customResourceObject object as HashMap
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   * @deprecated Use {@link #inNamespace(String)}.{@link #createOrReplace(Map)} instead.
   */
  @Deprecated
  public Map<String, Object> createOrReplace(String namespace, Map<String, Object> customResourceObject) throws IOException {
    return toMap(delegate.inNamespace(namespace)
      .createOrReplace(Serialization.jsonMapper().convertValue(customResourceObject, GenericKubernetesResource.class)));
  }

  /**
   * Create or replace a custom resource which is namespaced object.
   *
   * @param namespace      desired namespace
   * @param objectAsStream object as file input stream
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   * @deprecated Use {@link #inNamespace(String)}.{@link #createOrReplace(InputStream)} instead.
   */
  @Deprecated
  public Map<String, Object> createOrReplace(String namespace, InputStream objectAsStream) throws IOException {
    return toMap(delegate.inNamespace(namespace)
      .createOrReplace(Serialization.unmarshal(objectAsStream, GenericKubernetesResource.class)));
  }

  /**
   * Edit a custom resource object which is a non-namespaced object.
   *
   * @param name   name of the custom resource
   * @param object new object as a HashMap
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   * @deprecated Use {@link #withName(String)}.{@link #edit(Map)} instead.
   */
  @Deprecated
  public Map<String, Object> edit(String name, Map<String, Object> object) throws IOException {
    return toMap(delegate.withName(name)
      .edit(gkr -> Serialization.jsonMapper().convertValue(object, GenericKubernetesResource.class)));
  }

  /**
   * Edit a custom resource object which is a non-namespaced object.
   *
   * @param name           name of the custom resource
   * @param objectAsString new object as a JSON String
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   * @deprecated Use {@link #withName(String)}.{@link #edit(String)} instead.
   */
  @Deprecated
  public Map<String, Object> edit(String name, String objectAsString) throws IOException {
    final GenericKubernetesResource edited = Serialization.jsonMapper()
      .readValue(objectAsString, GenericKubernetesResource.class);
    return toMap(delegate.withName(name).edit(gkr -> edited));
  }

  /**
   * Edit a custom resource object which is a namespaced object.
   *
   * @param namespace desired namespace
   * @param name      name of the custom resource
   * @param object    new object as a HashMap
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   * @deprecated Use {@link #inNamespace(String)}.{@link #withName(String)}.{@link #edit(Map)} instead.
   */
  @Deprecated
  public Map<String, Object> edit(String namespace, String name, Map<String, Object> object) throws IOException {
    return toMap(delegate.inNamespace(namespace).withName(name)
      .edit(gkr -> Serialization.jsonMapper().convertValue(object, GenericKubernetesResource.class)));
  }

  /**
   * Edit a custom resource object which is a namespaced object.
   *
   * @param namespace      desired namespace
   * @param name           name of the custom resource
   * @param objectAsString new object as a JSON string
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   * @deprecated Use {@link #inNamespace(String)}.{@link #withName(String)}.{@link #edit(String)} instead.
   */
  @Deprecated
  public Map<String, Object> edit(String namespace, String name, String objectAsString) throws IOException {
    final GenericKubernetesResource edited = Serialization.jsonMapper()
      .readValue(objectAsString, GenericKubernetesResource.class);
    return toMap(delegate.inNamespace(namespace).withName(name).edit(gkr -> edited));
  }

  /**
   * Edit a custom resource object.
   *
   * @param objectAsString new object as JSON string
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   */
  public Map<String, Object> edit(String objectAsString) throws IOException {
    final GenericKubernetesResource edited = Serialization.jsonMapper()
      .readValue(objectAsString, GenericKubernetesResource.class);
    return toMap(delegate.edit(gkr -> edited));
  }

  /**
   * Edit a custom resource object.
   *
   * @param object new object as Map
   * @return Object as HashMap
   * @throws IOException in case of network/serialization failures or failures from Kubernetes API
   */
  public Map<String, Object> edit(Map<String, Object> object) throws IOException {
    return toMap(delegate
      .edit(gkr -> Serialization.jsonMapper().convertValue(object, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param name        name of custom resource
   * @param objectAsMap custom resource as a HashMap
   * @return updated CustomResource as HashMap
   * @throws IOException in case any failure to parse Map
   * @deprecated Use {@link #withName(String)}.{@link #updateStatus(Map)} instead.
   */
  @Deprecated
  public Map<String, Object> updateStatus(String name, Map<String, Object> objectAsMap) throws IOException {
    return toMap(delegate.withName(name)
      .updateStatus(Serialization.jsonMapper().convertValue(objectAsMap, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param name               name of CustomResource
   * @param objectAsJsonString CustomResource as a JSON string
   * @return updated CustomResource as a HashMap
   * @throws IOException in case any failure to parse Map
   * @deprecated Use {@link #withName(String)}.{@link #updateStatus(String)} instead.
   */
  @Deprecated
  public Map<String, Object> updateStatus(String name, String objectAsJsonString) throws IOException {
    return toMap(delegate.withName(name)
      .updateStatus(Serialization.unmarshal(objectAsJsonString, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param namespace   namespace of CustomResource
   * @param name        name of CustomResource
   * @param objectAsMap CustomResource as a HashMap
   * @return updated CustomResource as a HashMap
   * @throws IOException in case any failure to parse Map
   * @deprecated Use {@link #inNamespace(String)}.{@link #withName(String)}.{@link #updateStatus(Map)} instead.
   */
  @Deprecated
  public Map<String, Object> updateStatus(String namespace, String name, Map<String, Object> objectAsMap) throws IOException {
    return toMap(delegate.inNamespace(namespace).withName(name)
      .updateStatus(Serialization.jsonMapper().convertValue(objectAsMap, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param name           name of CustomResource
   * @param objectAsStream stream pointing to CustomResource
   * @return updated CustomResource as a HashMap
   * @throws IOException in case any failure to parse Map
   * @deprecated Use {@link #withName(String)}.{@link #updateStatus(InputStream)} instead.
   */
  @Deprecated
  public Map<String, Object> updateStatus(String name, InputStream objectAsStream) throws IOException {
    return toMap(delegate.withName(name)
      .updateStatus(Serialization.unmarshal(objectAsStream, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param namespace      namespace of CustomResource
   * @param name           name of CustomResource
   * @param objectAsStream CustomResource object as a stream
   * @return updated CustomResource as a HashMap
   * @throws IOException in case any failure to parse Map
   * @deprecated Use {@link #inNamespace(String)}.{@link #withName(String)}.{@link #updateStatus(InputStream)} instead.
   */
  @Deprecated
  public Map<String, Object> updateStatus(String namespace, String name, InputStream objectAsStream) throws IOException {
    return toMap(delegate.inNamespace(namespace).withName(name)
      .updateStatus(Serialization.unmarshal(objectAsStream, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param namespace          namespace of CustomResource
   * @param name               name of CustomResource
   * @param objectAsJsonString CustomResource object as a JSON string
   * @return updated CustomResource as a HashMap
   * @throws IOException in case any failure to parse Map
   * @deprecated Use {@link #inNamespace(String)}.{@link #withName(String)}.{@link #updateStatus(String)} instead.
   */
  @Deprecated
  public Map<String, Object> updateStatus(String namespace, String name, String objectAsJsonString) throws IOException {
    return toMap(delegate.inNamespace(namespace).withName(name)
      .updateStatus(Serialization.unmarshal(objectAsJsonString, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param objectAsJsonString CustomResource object as a JSON string
   * @return updated CustomResource as HashMap
   * @throws IOException in case any failures to parse provided object or failure from Kubernetes API
   */
  public Map<String, Object> updateStatus(String objectAsJsonString) throws IOException {
    return toMap(delegate
      .updateStatus(Serialization.unmarshal(objectAsJsonString, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param objectAsMap CustomResource object as a HashMap
   * @return updated CustomResource as HashMap
   * @throws IOException in case any failures to parse provided object or failure from Kubernetes API
   */
  public Map<String, Object> updateStatus(Map<String, Object> objectAsMap) throws IOException {
    return toMap(delegate
      .updateStatus(Serialization.jsonMapper().convertValue(objectAsMap, GenericKubernetesResource.class)));
  }

  /**
   * Update status related to a CustomResource, this method does a PATCH request on /status endpoint related
   * to the CustomResource
   *
   * @param objectAsInputStream CustomResource object as a InputStream
   * @return updated CustomResource as HashMap
   * @throws IOException in case any failures to parse provided object or failure from Kubernetes API
   */
  public Map<String, Object> updateStatus(InputStream objectAsInputStream) throws IOException {
    return toMap(delegate
      .updateStatus(Serialization.unmarshal(objectAsInputStream, GenericKubernetesResource.class)));
  }

  @Override
  public Map<String, Object> get() {
    return toMap(delegate.get());
  }

  /**
   * Get a custom resource from the cluster which is non-namespaced.
   *
   * @param name name of custom resource
   * @return Object as HashMap
   * @deprecated Use {@link #withName(String)}.{@link #get()} instead.
   */
  @Deprecated
  public Map<String, Object> get(String name) {
    return toMap(delegate.withName(name).get());
  }

  /**
   * Get a custom resource from the cluster which is namespaced.
   *
   * @param namespace desired namespace
   * @param name      name of custom resource
   * @return Object as HashMap
   * @deprecated Use {@link #inNamespace(String)}.{@link #withName(String)}.{@link #get()} instead.
   */
  @Deprecated
  public Map<String, Object> get(String namespace, String name) {
    return toMap(delegate.inNamespace(namespace).withName(name).get());
  }

  /**
   * List all custom resources in all namespaces
   *
   * @return list of custom resources as HashMap
   */
  @Override
  public Map<String, Object> list() {
    return toMap(delegate.list());
  }

  @Override
  public Map<String, Object> list(Integer limitVal, String continueVal) {
    return toMap(delegate
      .list(new ListOptionsBuilder().withLimit(limitVal.longValue()).withContinue(continueVal).build()));
  }

  @Override
  public Map<String, Object> list(ListOptions listOptions) {
    return toMap(delegate.list(listOptions));
  }

  /**
   * List all custom resources in a specific namespace
   *
   * @param namespace desired namespace
   * @return list of custom resources as HashMap
   */
  public Map<String, Object> list(String namespace) {
    return toMap(delegate.inNamespace(namespace).list());
  }

  /**
   * List all custom resources in a specific namespace with some labels
   *
   * @param namespace desired namespace
   * @param labels    labels as a HashMap
   * @return list of custom resources as HashMap
   */
  public Map<String, Object> list(String namespace, Map<String, String> labels) {
    return toMap(delegate.inNamespace(namespace)
      .list(new ListOptionsBuilder().withLabelSelector(getLabelsQueryParam(labels)).build()));
  }

  /**
   * Delete all Namespaced Scoped Custom Resources in a specified namespace
   * <b>OR</b>
   * Delete a Cluster Scoped Custom Resource with specified name
   *
   * <p>
   * Note: This method behaves differently based on the scope of CRD:
   * <p>
   * If specified CRD is of Namespaced scope, this method would delete all Custom Resources in namespace which is
   * specified as parameter.
   * If specified CRD is of Cluster scope, this method would delete a Custom Resource matching the name which is
   * specified as parameter
   * </p>
   *
   * @param namespaceOrName desired namespace(if CRD is Namespaced) or name(If CRD is Cluster)
   * @return deleted objects as HashMap
   * @deprecated Use {@link #inNamespace(String)}.{@link #delete()} or {@link #withName(String)}.{@link #delete()} instead.
   */
  @Deprecated
  public boolean delete(String namespaceOrName) {
    if (delegate.isResourceNamespaced()) {
      return delegate.inNamespace(namespaceOrName).delete();
    }
    return delegate.withName(namespaceOrName).delete();
  }

  /**
   * Delete all Namespaced Scoped Custom Resources in a specified namespace
   * <b>OR</b>
   * Delete a Cluster Scoped Custom Resource with specified name
   *
   * <p>
   * Note: This method behaves differently based on the scope of CRD:
   * <p>
   * If specified CRD is of Namespaced scope, this method would delete all Custom Resources in namespace which is
   * specified as parameter.
   * If specified CRD is of Cluster scope, this method would delete a Custom Resource matching the name which is
   * specified as parameter
   * </p>
   *
   * @param namespaceOrName desired namespace(If CRD is Namespaced) or name(If CRD is Cluster)
   * @param cascading       whether dependent object need to be orphaned or not.  If true/false, the "orphan"
   *                        finalizer will be added to/removed from the object's finalizers list.
   * @return a boolean value whether item was deleted or item didn't exist in server
   * @throws IOException in case of any network/parsing exception
   */
  public boolean delete(String namespaceOrName, boolean cascading) throws IOException {
    if (delegate.isResourceNamespaced()) {
      return delegate.inNamespace(namespaceOrName).delete();
    }
    return delegate.withName(namespaceOrName).cascading(cascading).delete();
  }

  /**
   * Delete all Namespaced Scoped Custom Resources in a specified namespace
   * <b>OR</b>
   * Delete a Cluster Scoped Custom Resource with specified name
   *
   * <p>
   * Note: This method behaves differently based on the scope of CRD:
   * <p>
   * If specified CRD is of Namespaced scope, this method would delete all Custom Resources in namespace which is
   * specified as parameter.
   * If specified CRD is of Cluster scope, this method would delete a Custom Resource matching the name which is
   * specified as parameter
   * </p>
   *
   * @param namespaceOrName desired namespace(If CRD is Namespaced) or name(If CRD is Cluster)
   * @param deleteOptions   object provided by Kubernetes API for more fine grained control over deletion.
   *                        For more information please see https://kubernetes.io/docs/reference/generated/kubernetes-api/v1.16/#deleteoptions-v1-meta
   * @return a boolean value whether item was deleted or item didn't exist in server
   * @throws IOException in case of any network/object parse problems
   */
  public boolean delete(String namespaceOrName, DeleteOptions deleteOptions) throws IOException {
    if (delegate.isResourceNamespaced()) {
      return withDeleteOptions(deleteOptions).inNamespace(namespaceOrName).delete();
    }
    return withDeleteOptions(deleteOptions).withName(namespaceOrName).delete();
  }

  /**
   * Delete a custom resource in a specific namespace
   *
   * @param namespace desired namespace
   * @param name      custom resource's name
   * @return a boolean value whether item was deleted or item didn't exist in server
   * @throws IOException in case of any network/object parse problems
   * @deprecated Use {@link #inNamespace(String)}.{@link #withName(String)}.{@link #delete()} instead.
   */
  @Deprecated
  public boolean delete(String namespace, String name) throws IOException {
    return delegate.inNamespace(namespace).withName(name).delete();
  }

  /**
   * Delete a custom resource in a specific namespace
   *
   * @param namespace required namespace
   * @param name      required name of custom resource
   * @param cascading whether dependent object need to be orphaned or not.  If true/false, the "orphan"
   *                  finalizer will be added to/removed from the object's finalizers list.
   * @return a boolean value whether item was deleted or item didn't exist in server
   * @throws IOException exception related to network/object parsing
   */
  public boolean delete(String namespace, String name, boolean cascading) throws IOException {
    return delegate.inNamespace(namespace).withName(name).cascading(cascading).delete();
  }

  /**
   * Delete a custom resource in a specific namespace
   *
   * @param namespace         required namespace
   * @param name              required name of custom resource
   * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents
   *                          may be set, but not both. The default policy is decided by the existing finalizer set in
   *                          the metadata.finalizers and the resource-specific default policy.
   *                          Acceptable values are:
   *                          'Orphan' - orphan the dependents;
   *                          'Background' - allow the garbage collector to delete the dependents in the background;
   *                          'Foreground' - a cascading policy that deletes all dependents in the foreground.
   * @return a boolean value whether item was deleted or item didn't exist in server
   * @throws IOException in case of network/object parse exception
   */
  public boolean delete(String namespace, String name, String propagationPolicy) throws IOException {
    return delegate.inNamespace(namespace).withName(name)
      .withPropagationPolicy(resolveDeletionPropagation(propagationPolicy)).delete();
  }

  /**
   * Delete a custom resource in a specific namespace
   *
   * @param namespace     required namespace
   * @param name          name of custom resource
   * @param deleteOptions object provided by Kubernetes API for more fine grained control over deletion.
   *                      For more information please see https://kubernetes.io/docs/reference/generated/kubernetes-api/v1.16/#deleteoptions-v1-meta
   * @return a boolean value whether item was deleted or item didn't exist in server
   * @throws IOException in case of any network/object parse exception
   */
  public boolean delete(String namespace, String name, DeleteOptions deleteOptions) throws IOException {
    return withDeleteOptions(deleteOptions).inNamespace(namespace).withName(name).delete();
  }

  @Override
  public Boolean delete() {
    return delegate.delete();
  }


  /**
   * Watch custom resources across all namespaces. Here watcher is provided
   * for string type only. User has to deserialize object itself.
   *
   * @param watcher watcher object which reports events
   * @return watch object for watching resource
   * @throws IOException in case of network error
   */
  public Watch watch(Watcher<String> watcher) throws IOException {
    return delegate.watch(new DelegateWatcher(watcher));
  }

  /**
   * Watch custom resources in the parameters specified.
   * <p>
   * Most of the parameters except watcher are optional, they would be
   * skipped if passed null. Here watcher is provided for string type
   * only. User has to deserialize the object itself.
   *
   * @param namespace namespace to watch (optional
   * @param name      name of custom resource (optional)
   * @param labels    HashMap containing labels (optional)
   * @param options   {@link ListOptions} list options for watch
   * @param watcher   watcher object which reports events
   * @return watch object for watching resource
   * @throws IOException in case of network error
   */
  public Watch watch(String namespace, String name, Map<String, String> labels, ListOptions options, Watcher<String> watcher) throws IOException {
    GenericKubernetesResourceOperationsImpl ops = delegate;
    if (Utils.isNotNullOrEmpty(namespace)) {
      ops = (GenericKubernetesResourceOperationsImpl) ops.inNamespace(namespace);
    }
    if (Utils.isNotNullOrEmpty(name)) {
      ops = (GenericKubernetesResourceOperationsImpl) ops.withName(name);
    }
    return ops.watch(
      listOptionsBuilder(options).withLabelSelector(getLabelsQueryParam(labels)).build(),
      new DelegateWatcher(watcher));
  }

  /**
   * Watch custom resources in the parameters specified.
   * <p>
   * Most of the parameters except watcher are optional, they would be
   * skipped if passed null. Here watcher is provided for string type
   * only. User has to deserialize the object itself.
   *
   * @param namespace       namespace to watch (optional
   * @param name            name of custom resource (optional)
   * @param labels          HashMap containing labels (optional)
   * @param resourceVersion resource version to start watch from
   * @param watcher         watcher object which reports events
   * @return watch object for watching resource
   * @throws IOException in case of network error
   */
  public Watch watch(String namespace, String name, Map<String, String> labels, String resourceVersion, Watcher<String> watcher) throws IOException {
    return watch(namespace, name, labels, new ListOptionsBuilder().withResourceVersion(resourceVersion).build(), watcher);
  }

  /**
   * Watch custom resources in a specific namespace. Here Watcher is provided
   * for string type only. User has to deserialize object itself.
   *
   * @param namespace namespace to watch
   * @param watcher   watcher object which reports updates with object
   * @return watch object for watching resource
   * @throws IOException in case of network error
   */
  public Watch watch(String namespace, Watcher<String> watcher) throws IOException {
    return watch(namespace, null, null, (ListOptions) null, watcher);
  }

  /**
   * Watch a custom resource in a specific namespace with some resourceVersion. Here
   * watcher is provided from string type only. User has to deserialize object itself.
   *
   * @param namespace       namespace to watch
   * @param resourceVersion resource version since when to watch
   * @param watcher         watcher object which reports updates
   * @return watch object for watching resource
   * @throws IOException in case of network error
   */
  public Watch watch(String namespace, String resourceVersion, Watcher<String> watcher) throws IOException {
    return watch(namespace, null, null, resourceVersion, watcher);
  }

  /**
   * Watch a custom resource in a specific namespace with some resourceVersion. Here
   * watcher is provided from string type only. User has to deserialize object itself.
   *
   * @param namespace namespace to watch
   * @param options   {@link ListOptions} list options for watching
   * @param watcher   watcher object which reports updates
   * @return watch object for watching resource
   * @throws IOException in case of network error
   */
  public Watch watch(String namespace, ListOptions options, Watcher<String> watcher) throws IOException {
    return watch(namespace, null, null, options, watcher);
  }

  /**
   * Watch custom resources in the parameters specified.
   * <p>
   * Most of the parameters except watcher are optional, they would be
   * skipped if passed null. Here watcher is provided for string type
   * only. User has to deserialize the object itself.
   *
   * @param labels  HashMap containing labels (optional)
   * @param options {@link ListOptions} list options for watch
   * @param watcher watcher object which reports events
   * @return watch object for watching resource
   * @throws IOException in case of network error
   */
  public Watch watch(Map<String, String> labels, ListOptions options, Watcher<String> watcher) throws IOException {
    return delegate.watch(
      listOptionsBuilder(options).withLabelSelector(getLabelsQueryParam(labels)).build(),
      new DelegateWatcher(watcher));
  }

  private String getLabelsQueryParam(Map<String, String> labels) {
    if (labels == null) {
      return null;
    }
    StringBuilder labelQueryBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : labels.entrySet()) {
      if (labelQueryBuilder.length() > 0) {
        labelQueryBuilder.append(",");
      }
      labelQueryBuilder.append(entry.getKey()).append("=").append(entry.getValue());
    }
    return labelQueryBuilder.toString();
  }

  private static DeletionPropagation resolveDeletionPropagation(String propagationPolicy) {
    return Stream.of(DeletionPropagation.values())
      .filter(dp -> dp.name().toUpperCase(Locale.ENGLISH).equals(propagationPolicy.toUpperCase(Locale.ENGLISH)))
      .findFirst()
      .orElse(DEFAULT_PROPAGATION_POLICY);
  }

  private long resolveGracePeriod(Long gracePeriodInSeconds) {
    return gracePeriodInSeconds != null ? gracePeriodInSeconds : delegate.getGracePeriodSeconds();
  }

  private DeletionPropagation resolvePropagationPolicy(String deletionPropagation) {
    return deletionPropagation != null ? resolveDeletionPropagation(deletionPropagation) : delegate.getPropagationPolicy();
  }

  private static ListOptionsBuilder listOptionsBuilder(ListOptions options) {
    return options == null ? new ListOptionsBuilder() : new ListOptionsBuilder(options);
  }

  private static Map<String, Object> toMap(GenericKubernetesResource gkr) {
    return Serialization.jsonMapper().convertValue(gkr, new TypeReference<Map<String, Object>>() {
    });
  }

  private static Map<String, Object> toMap(GenericKubernetesResourceList gkrl) {
    return Serialization.jsonMapper().convertValue(gkrl, new TypeReference<Map<String, Object>>() {
    });
  }

  private static final class DelegateWatcher implements Watcher<GenericKubernetesResource> {

    private final Watcher<String> delegate;

    public DelegateWatcher(Watcher<String> delegate) {
      this.delegate = delegate;
    }

    @Override
    public boolean reconnecting() {
      return delegate.reconnecting();
    }

    @Override
    public void eventReceived(Action action, GenericKubernetesResource resource) {
      try {
        delegate.eventReceived(action, Serialization.jsonMapper().writeValueAsString(resource));
      } catch (JsonProcessingException e) {
        delegate.eventReceived(action, resource.toString());
      }
    }

    @Override
    public void onClose() {
      delegate.onClose();
    }

    @Override
    public void onClose(WatcherException cause) {
      delegate.onClose(cause);
    }
  }
}
