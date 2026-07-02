package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class APIServiceSpecFluent<A extends io.fabric8.kubernetes.api.model.APIServiceSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String caBundle;
  private String group;
  private Integer groupPriorityMinimum;
  private Boolean insecureSkipTLSVerify;
  private ServiceReferenceBuilder service;
  private String version;
  private Integer versionPriority;

  public APIServiceSpecFluent() {
  }
  
  public APIServiceSpecFluent(APIServiceSpec instance) {
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
  
  public ServiceReference buildService() {
    return this.service != null ? this.service.build() : null;
  }
  
  protected void copyInstance(APIServiceSpec instance) {
    instance = instance != null ? instance : new APIServiceSpec();
    if (instance != null) {
        this.withCaBundle(instance.getCaBundle());
        this.withGroup(instance.getGroup());
        this.withGroupPriorityMinimum(instance.getGroupPriorityMinimum());
        this.withInsecureSkipTLSVerify(instance.getInsecureSkipTLSVerify());
        this.withService(instance.getService());
        this.withVersion(instance.getVersion());
        this.withVersionPriority(instance.getVersionPriority());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceNested<A> editOrNewService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(new ServiceReferenceBuilder().build()));
  }
  
  public ServiceNested<A> editOrNewServiceLike(ServiceReference item) {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(item));
  }
  
  public ServiceNested<A> editService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(null));
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
    APIServiceSpecFluent that = (APIServiceSpecFluent) o;
    if (!(Objects.equals(caBundle, that.caBundle))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(groupPriorityMinimum, that.groupPriorityMinimum))) {
      return false;
    }
    if (!(Objects.equals(insecureSkipTLSVerify, that.insecureSkipTLSVerify))) {
      return false;
    }
    if (!(Objects.equals(service, that.service))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
      return false;
    }
    if (!(Objects.equals(versionPriority, that.versionPriority))) {
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
  
  public String getCaBundle() {
    return this.caBundle;
  }
  
  public String getGroup() {
    return this.group;
  }
  
  public Integer getGroupPriorityMinimum() {
    return this.groupPriorityMinimum;
  }
  
  public Boolean getInsecureSkipTLSVerify() {
    return this.insecureSkipTLSVerify;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public Integer getVersionPriority() {
    return this.versionPriority;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCaBundle() {
    return this.caBundle != null;
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasGroupPriorityMinimum() {
    return this.groupPriorityMinimum != null;
  }
  
  public boolean hasInsecureSkipTLSVerify() {
    return this.insecureSkipTLSVerify != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public boolean hasVersionPriority() {
    return this.versionPriority != null;
  }
  
  public int hashCode() {
    return Objects.hash(caBundle, group, groupPriorityMinimum, insecureSkipTLSVerify, service, version, versionPriority, additionalProperties);
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
    if (!(caBundle == null)) {
        sb.append("caBundle:");
        sb.append(caBundle);
        sb.append(",");
    }
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(groupPriorityMinimum == null)) {
        sb.append("groupPriorityMinimum:");
        sb.append(groupPriorityMinimum);
        sb.append(",");
    }
    if (!(insecureSkipTLSVerify == null)) {
        sb.append("insecureSkipTLSVerify:");
        sb.append(insecureSkipTLSVerify);
        sb.append(",");
    }
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
        sb.append(",");
    }
    if (!(versionPriority == null)) {
        sb.append("versionPriority:");
        sb.append(versionPriority);
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
  
  public A withCaBundle(String caBundle) {
    this.caBundle = caBundle;
    return (A) this;
  }
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withGroupPriorityMinimum(Integer groupPriorityMinimum) {
    this.groupPriorityMinimum = groupPriorityMinimum;
    return (A) this;
  }
  
  public A withInsecureSkipTLSVerify() {
    return withInsecureSkipTLSVerify(true);
  }
  
  public A withInsecureSkipTLSVerify(Boolean insecureSkipTLSVerify) {
    this.insecureSkipTLSVerify = insecureSkipTLSVerify;
    return (A) this;
  }
  
  public ServiceNested<A> withNewService() {
    return new ServiceNested(null);
  }
  
  public A withNewService(String name,String namespace,Integer port) {
    return (A) this.withService(new ServiceReference(name, namespace, port));
  }
  
  public ServiceNested<A> withNewServiceLike(ServiceReference item) {
    return new ServiceNested(item);
  }
  
  public A withService(ServiceReference service) {
    this._visitables.remove("service");
    if (service != null) {
        this.service = new ServiceReferenceBuilder(service);
        this._visitables.get("service").add(this.service);
    } else {
        this.service = null;
        this._visitables.get("service").remove(this.service);
    }
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  
  public A withVersionPriority(Integer versionPriority) {
    this.versionPriority = versionPriority;
    return (A) this;
  }
  public class ServiceNested<N> extends ServiceReferenceFluent<ServiceNested<N>> implements Nested<N>{
  
    ServiceReferenceBuilder builder;
  
    ServiceNested(ServiceReference item) {
      this.builder = new ServiceReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServiceSpecFluent.this.withService(builder.build());
    }
    
    public N endService() {
      return and();
    }
    
  }
}