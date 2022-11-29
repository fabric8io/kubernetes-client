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

package io.fabric8.kubernetes.api.model.admission.v1;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.GroupVersionKind;
import io.fabric8.kubernetes.api.model.GroupVersionResource;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.authentication.UserInfo;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * AdmissionRequest describes the admission.Attributes for the admission request.
 *
 * This POJO is derived from https://github.com/kubernetes/api/blob/master/admission/v1beta1/types.go
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize
@ToString
@EqualsAndHashCode
public class AdmissionRequest implements KubernetesResource {

  /*
   * DryRun indicates that modifications will definitely not be persisted for this request.
   * Defaults to false.
   */
  @JsonProperty("dryRun")
  private Boolean dryRun;

  /*
   * Kind is fully-qualified resource being requested (for example, v1.Pods)
   */
  @JsonProperty("kind")
  private GroupVersionKind kind;

  /*
   * Name is the name of the object as presented in the request. On a CREATE operation, the client may omit name and
   * rely on the server to generate the name. If that is the case, this field will contain an empty string.
   */
  @JsonProperty("name")
  private String name;

  /*
   * Namespace is the namespace associated with the request (if any).
   */
  @JsonProperty("namespace")
  private String namespace;

  /*
   * Object is the object from the incoming request.
   */
  @JsonProperty("object")
  private KubernetesResource object;

  /*
   * OldObject is the existing object. Only populated for DELETE and UPDATE requests.
   */
  @JsonProperty("oldObject")
  private KubernetesResource oldObject;

  /*
   * Operation is the operation being performed. This may be different than the operation
   * requested. e.g. a patch can result in either a CREATE or UPDATE Operation.
   */
  @JsonProperty("operation")
  private String operation;

  @JsonProperty("options")
  private KubernetesResource options;

  /*
   * RequestResource is the fully-qualified resource of the original API request (for example, v1.pods).
   * If this is specified and differs from the value in "resource", an equivalent match and conversion was performed.
   *
   * For example, if deployments can be modified via apps/v1 and apps/v1beta1, and a webhook registered a rule of
   * `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]` and `matchPolicy: Equivalent`,
   * an API request to apps/v1beta1 deployments would be converted and sent to the webhook
   * with `resource: {group:"apps", version:"v1", resource:"deployments"}` (matching the resource the webhook registered for),
   * and `requestResource: {group:"apps", version:"v1beta1", resource:"deployments"}` (indicating the resource of the original
   * API request).
   */
  @JsonProperty("requestKind")
  private GroupVersionKind requestKind;

  /*
   * RequestResource is the fully-qualified resource of the original API request (for example, v1.pods).
   * If this is specified and differs from the value in "resource", an equivalent match and conversion was performed.
   *
   * For example, if deployments can be modified via apps/v1 and apps/v1beta1, and a webhook registered a rule of
   * `apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]` and `matchPolicy: Equivalent`,
   * an API request to apps/v1beta1 deployments would be converted and sent to the webhook
   * with `resource: {group:"apps", version:"v1", resource:"deployments"}` (matching the resource the webhook registered for),
   * and `requestResource: {group:"apps", version:"v1beta1", resource:"deployments"}` (indicating the resource of the original
   * API request).
   *
   * See documentation for the "matchPolicy" field in the webhook configuration type.
   */
  @JsonProperty("requestResource")
  private GroupVersionResource requestResource;

  /*
   * RequestSubResource is the name of the subresource of the original API request, if any (for example, "status" or "scale")
   * If this is specified and differs from the value in "subResource", an equivalent match and conversion was performed.
   * See documentation for the "matchPolicy" field in the webhook configuration type.
   */
  @JsonProperty("requestSubResource")
  private String requestSubResource;

  /*
   * Resource is the fully-qualified resource being requested (for example, v1.pods)
   */
  @JsonProperty("resource")
  private GroupVersionResource resource;

  /*
   * SubResource is the subresource being requested (for example, "status" or "scale")
   */
  @JsonProperty("subResource")
  private String subResource;

  /*
   * UID is identifier for individual request/response. It allows us to distinguish instances of
   * requests which otherwise identical (parallel requests, requests when earlier requests did not
   * modify etc). The UID is meant to track the round trip (request/response) between KAS and
   * the WebHook, not the user request.
   * It is suitable for correlating log entries between the webhook and apiserver, for either
   * auditing or debugging.
   */
  @JsonProperty("uid")
  private String uid;

  /*
   * UserInfo is information about the requesting user
   */
  @JsonProperty("userInfo")
  private UserInfo userInfo;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<>();

  public AdmissionRequest() {
  }

  public AdmissionRequest(Boolean dryRun, GroupVersionKind kind, String name, String namespace, KubernetesResource object,
      KubernetesResource oldObject, String operation, KubernetesResource options, GroupVersionKind requestKind,
      GroupVersionResource requestResource, String requestSubResource, GroupVersionResource resource, String subResource,
      String uid, UserInfo userInfo) {
    this.dryRun = dryRun;
    this.kind = kind;
    this.name = name;
    this.namespace = namespace;
    this.object = object;
    this.oldObject = oldObject;
    this.operation = operation;
    this.options = options;
    this.requestKind = requestKind;
    this.requestResource = requestResource;
    this.requestSubResource = requestSubResource;
    this.resource = resource;
    this.subResource = subResource;
    this.uid = uid;
    this.userInfo = userInfo;
  }

  /**
   * Get Dry Run
   *
   * @return The dryRun
   */
  @JsonProperty("dryRun")
  public Boolean getDryRun() {
    return dryRun;
  }

  /**
   * Set Dry run
   * 
   * @param dryRun The dryRun
   */
  @JsonProperty("dryRun")
  public void setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
  }

  /**
   * Get Kind
   *
   * @return The kind
   */
  @JsonProperty("kind")
  public GroupVersionKind getKind() {
    return kind;
  }

  /**
   * Set Kind
   *
   * @param kind The kind
   */
  @JsonProperty("kind")
  public void setKind(GroupVersionKind kind) {
    this.kind = kind;
  }

  /**
   * Get Name
   *
   * @return The name
   */
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  /**
   * Set Name
   *
   * @param name The name
   */
  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get Namespace
   *
   * @return The namespace
   */
  @JsonProperty("namespace")
  public String getNamespace() {
    return namespace;
  }

  /**
   * Set Namespace
   *
   * @param namespace The namespace
   */
  @JsonProperty("namespace")
  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  /**
   * Get Object
   *
   * @return The object
   */
  @JsonProperty("object")
  public KubernetesResource getObject() {
    return object;
  }

  /**
   * Set Object
   *
   * @param object The object
   */
  @JsonProperty("object")
  public void setObject(KubernetesResource object) {
    this.object = object;
  }

  /**
   * Get old object.
   *
   * @return The oldObject
   */
  @JsonProperty("oldObject")
  public KubernetesResource getOldObject() {
    return oldObject;
  }

  /**
   * Set old object.
   *
   * @param oldObject The oldObject
   */
  @JsonProperty("oldObject")
  public void setOldObject(KubernetesResource oldObject) {
    this.oldObject = oldObject;
  }

  /**
   * Get operation.
   *
   * @return The operation
   */
  @JsonProperty("operation")
  public String getOperation() {
    return operation;
  }

  /**
   * Set operation.
   *
   * @param operation The operation
   */
  @JsonProperty("operation")
  public void setOperation(String operation) {
    this.operation = operation;
  }

  /**
   * Get options.
   *
   * @return The options
   */
  @JsonProperty("options")
  public KubernetesResource getOptions() {
    return options;
  }

  /**
   * Set options.
   *
   * @param options The options
   */
  @JsonProperty("options")
  public void setOptions(KubernetesResource options) {
    this.options = options;
  }

  /**
   * Get Request Kind.
   *
   * @return The requestKind
   */
  @JsonProperty("requestKind")
  public GroupVersionKind getRequestKind() {
    return requestKind;
  }

  /**
   * Set RequestKind
   *
   * @param requestKind The requestKind
   */
  @JsonProperty("requestKind")
  public void setRequestKind(GroupVersionKind requestKind) {
    this.requestKind = requestKind;
  }

  /**
   * Get RequestResource
   *
   * @return The requestResource
   */
  @JsonProperty("requestResource")
  public GroupVersionResource getRequestResource() {
    return requestResource;
  }

  /**
   * Set RequestResource
   *
   * @param requestResource The requestResource
   */
  @JsonProperty("requestResource")
  public void setRequestResource(GroupVersionResource requestResource) {
    this.requestResource = requestResource;
  }

  /**
   * Get RequestSubResource
   *
   * @return The requestSubResource
   */
  @JsonProperty("requestSubResource")
  public String getRequestSubResource() {
    return requestSubResource;
  }

  /**
   * Set RequestSubResource
   *
   * @param requestSubResource The requestSubResource
   */
  @JsonProperty("requestSubResource")
  public void setRequestSubResource(String requestSubResource) {
    this.requestSubResource = requestSubResource;
  }

  /**
   * Get Resource
   *
   * @return The resource
   */
  @JsonProperty("resource")
  public GroupVersionResource getResource() {
    return resource;
  }

  /**
   * Set Resource.
   *
   * @param resource The resource
   */
  @JsonProperty("resource")
  public void setResource(GroupVersionResource resource) {
    this.resource = resource;
  }

  /**
   * Get SubResource
   *
   * @return The subResource
   */
  @JsonProperty("subResource")
  public String getSubResource() {
    return subResource;
  }

  /**
   * Set SubResource
   *
   * @param subResource The subResource
   */
  @JsonProperty("subResource")
  public void setSubResource(String subResource) {
    this.subResource = subResource;
  }

  /**
   * Get Uid
   *
   * @return The uid
   */
  @JsonProperty("uid")
  public String getUid() {
    return uid;
  }

  /**
   * Set Uid
   *
   * @param uid The uid
   */
  @JsonProperty("uid")
  public void setUid(String uid) {
    this.uid = uid;
  }

  /**
   * Get UserInfo
   *
   * @return The userInfo
   */
  @JsonProperty("userInfo")
  public UserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * Set UserInfo
   *
   * @param userInfo The userInfo
   */
  @JsonProperty("userInfo")
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}
