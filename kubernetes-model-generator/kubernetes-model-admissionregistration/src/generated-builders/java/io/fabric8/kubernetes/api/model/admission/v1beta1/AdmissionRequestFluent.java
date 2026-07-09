package io.fabric8.kubernetes.api.model.admission.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.GroupVersionKind;
import io.fabric8.kubernetes.api.model.GroupVersionResource;
import io.fabric8.kubernetes.api.model.authentication.UserInfo;
import io.fabric8.kubernetes.api.model.authentication.UserInfoBuilder;
import io.fabric8.kubernetes.api.model.authentication.UserInfoFluent;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AdmissionRequestFluent<A extends io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionRequestFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean dryRun;
  private GroupVersionKind kind;
  private String name;
  private String namespace;
  private Object object;
  private Object oldObject;
  private String operation;
  private Object options;
  private GroupVersionKind requestKind;
  private GroupVersionResource requestResource;
  private String requestSubResource;
  private GroupVersionResource resource;
  private String subResource;
  private String uid;
  private UserInfoBuilder userInfo;

  public AdmissionRequestFluent() {
  }
  
  public AdmissionRequestFluent(AdmissionRequest instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public UserInfo buildUserInfo() {
    return this.userInfo != null ? this.userInfo.build() : null;
  }
  
  protected void copyInstance(AdmissionRequest instance) {
    instance = instance != null ? instance : new AdmissionRequest();
    if (instance != null) {
        this.withDryRun(instance.getDryRun());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withObject(instance.getObject());
        this.withOldObject(instance.getOldObject());
        this.withOperation(instance.getOperation());
        this.withOptions(instance.getOptions());
        this.withRequestKind(instance.getRequestKind());
        this.withRequestResource(instance.getRequestResource());
        this.withRequestSubResource(instance.getRequestSubResource());
        this.withResource(instance.getResource());
        this.withSubResource(instance.getSubResource());
        this.withUid(instance.getUid());
        this.withUserInfo(instance.getUserInfo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UserInfoNested<A> editOrNewUserInfo() {
    return this.withNewUserInfoLike(Optional.ofNullable(this.buildUserInfo()).orElse(new UserInfoBuilder().build()));
  }
  
  public UserInfoNested<A> editOrNewUserInfoLike(UserInfo item) {
    return this.withNewUserInfoLike(Optional.ofNullable(this.buildUserInfo()).orElse(item));
  }
  
  public UserInfoNested<A> editUserInfo() {
    return this.withNewUserInfoLike(Optional.ofNullable(this.buildUserInfo()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    AdmissionRequestFluent that = (AdmissionRequestFluent) o;
    if (!(Objects.equals(dryRun, that.dryRun))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(object, that.object))) {
      return false;
    }
    if (!(Objects.equals(oldObject, that.oldObject))) {
      return false;
    }
    if (!(Objects.equals(operation, that.operation))) {
      return false;
    }
    if (!(Objects.equals(options, that.options))) {
      return false;
    }
    if (!(Objects.equals(requestKind, that.requestKind))) {
      return false;
    }
    if (!(Objects.equals(requestResource, that.requestResource))) {
      return false;
    }
    if (!(Objects.equals(requestSubResource, that.requestSubResource))) {
      return false;
    }
    if (!(Objects.equals(resource, that.resource))) {
      return false;
    }
    if (!(Objects.equals(subResource, that.subResource))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
      return false;
    }
    if (!(Objects.equals(userInfo, that.userInfo))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Boolean getDryRun() {
    return this.dryRun;
  }
  
  public GroupVersionKind getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public Object getObject() {
    return this.object;
  }
  
  public Object getOldObject() {
    return this.oldObject;
  }
  
  public String getOperation() {
    return this.operation;
  }
  
  public Object getOptions() {
    return this.options;
  }
  
  public GroupVersionKind getRequestKind() {
    return this.requestKind;
  }
  
  public GroupVersionResource getRequestResource() {
    return this.requestResource;
  }
  
  public String getRequestSubResource() {
    return this.requestSubResource;
  }
  
  public GroupVersionResource getResource() {
    return this.resource;
  }
  
  public String getSubResource() {
    return this.subResource;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDryRun() {
    return this.dryRun != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasObject() {
    return this.object != null;
  }
  
  public boolean hasOldObject() {
    return this.oldObject != null;
  }
  
  public boolean hasOperation() {
    return this.operation != null;
  }
  
  public boolean hasOptions() {
    return this.options != null;
  }
  
  public boolean hasRequestKind() {
    return this.requestKind != null;
  }
  
  public boolean hasRequestResource() {
    return this.requestResource != null;
  }
  
  public boolean hasRequestSubResource() {
    return this.requestSubResource != null;
  }
  
  public boolean hasResource() {
    return this.resource != null;
  }
  
  public boolean hasSubResource() {
    return this.subResource != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public boolean hasUserInfo() {
    return this.userInfo != null;
  }
  
  public int hashCode() {
    return Objects.hash(dryRun, kind, name, namespace, object, oldObject, operation, options, requestKind, requestResource, requestSubResource, resource, subResource, uid, userInfo, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dryRun == null)) {
        sb.append("dryRun:");
        sb.append(dryRun);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(object == null)) {
        sb.append("object:");
        sb.append(object);
        sb.append(",");
    }
    if (!(oldObject == null)) {
        sb.append("oldObject:");
        sb.append(oldObject);
        sb.append(",");
    }
    if (!(operation == null)) {
        sb.append("operation:");
        sb.append(operation);
        sb.append(",");
    }
    if (!(options == null)) {
        sb.append("options:");
        sb.append(options);
        sb.append(",");
    }
    if (!(requestKind == null)) {
        sb.append("requestKind:");
        sb.append(requestKind);
        sb.append(",");
    }
    if (!(requestResource == null)) {
        sb.append("requestResource:");
        sb.append(requestResource);
        sb.append(",");
    }
    if (!(requestSubResource == null)) {
        sb.append("requestSubResource:");
        sb.append(requestSubResource);
        sb.append(",");
    }
    if (!(resource == null)) {
        sb.append("resource:");
        sb.append(resource);
        sb.append(",");
    }
    if (!(subResource == null)) {
        sb.append("subResource:");
        sb.append(subResource);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
        sb.append(",");
    }
    if (!(userInfo == null)) {
        sb.append("userInfo:");
        sb.append(userInfo);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withDryRun() {
    return withDryRun(true);
  }
  
  public A withDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
    return (A) this;
  }
  
  public A withKind(GroupVersionKind kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withNewKind(String group,String kind,String version) {
    return (A) this.withKind(new GroupVersionKind(group, kind, version));
  }
  
  public A withNewRequestKind(String group,String kind,String version) {
    return (A) this.withRequestKind(new GroupVersionKind(group, kind, version));
  }
  
  public A withNewRequestResource(String group,String resource,String version) {
    return (A) this.withRequestResource(new GroupVersionResource(group, resource, version));
  }
  
  public A withNewResource(String group,String resource,String version) {
    return (A) this.withResource(new GroupVersionResource(group, resource, version));
  }
  
  public UserInfoNested<A> withNewUserInfo() {
    return new UserInfoNested(null);
  }
  
  public UserInfoNested<A> withNewUserInfoLike(UserInfo item) {
    return new UserInfoNested(item);
  }
  
  public A withObject(Object object) {
    this.object = object;
    return (A) this;
  }
  
  public A withOldObject(Object oldObject) {
    this.oldObject = oldObject;
    return (A) this;
  }
  
  public A withOperation(String operation) {
    this.operation = operation;
    return (A) this;
  }
  
  public A withOptions(Object options) {
    this.options = options;
    return (A) this;
  }
  
  public A withRequestKind(GroupVersionKind requestKind) {
    this.requestKind = requestKind;
    return (A) this;
  }
  
  public A withRequestResource(GroupVersionResource requestResource) {
    this.requestResource = requestResource;
    return (A) this;
  }
  
  public A withRequestSubResource(String requestSubResource) {
    this.requestSubResource = requestSubResource;
    return (A) this;
  }
  
  public A withResource(GroupVersionResource resource) {
    this.resource = resource;
    return (A) this;
  }
  
  public A withSubResource(String subResource) {
    this.subResource = subResource;
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  
  public A withUserInfo(UserInfo userInfo) {
    this._visitables.remove("userInfo");
    if (userInfo != null) {
        this.userInfo = new UserInfoBuilder(userInfo);
        this._visitables.get("userInfo").add(this.userInfo);
    } else {
        this.userInfo = null;
        this._visitables.get("userInfo").remove(this.userInfo);
    }
    return (A) this;
  }
  public class UserInfoNested<N> extends UserInfoFluent<UserInfoNested<N>> implements Nested<N>{
  
    UserInfoBuilder builder;
  
    UserInfoNested(UserInfo item) {
      this.builder = new UserInfoBuilder(this, item);
    }
  
    public N and() {
      return (N) AdmissionRequestFluent.this.withUserInfo(builder.build());
    }
    
    public N endUserInfo() {
      return and();
    }
    
  }
}