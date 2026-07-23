package io.fabric8.openshift.api.model.hive.gcp.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PrivateServiceConnectFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.PrivateServiceConnectFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean enabled;
  private ServiceAttachmentBuilder serviceAttachment;

  public PrivateServiceConnectFluent() {
  }
  
  public PrivateServiceConnectFluent(PrivateServiceConnect instance) {
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
  
  public ServiceAttachment buildServiceAttachment() {
    return this.serviceAttachment != null ? this.serviceAttachment.build() : null;
  }
  
  protected void copyInstance(PrivateServiceConnect instance) {
    instance = instance != null ? instance : new PrivateServiceConnect();
    if (instance != null) {
        this.withEnabled(instance.getEnabled());
        this.withServiceAttachment(instance.getServiceAttachment());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceAttachmentNested<A> editOrNewServiceAttachment() {
    return this.withNewServiceAttachmentLike(Optional.ofNullable(this.buildServiceAttachment()).orElse(new ServiceAttachmentBuilder().build()));
  }
  
  public ServiceAttachmentNested<A> editOrNewServiceAttachmentLike(ServiceAttachment item) {
    return this.withNewServiceAttachmentLike(Optional.ofNullable(this.buildServiceAttachment()).orElse(item));
  }
  
  public ServiceAttachmentNested<A> editServiceAttachment() {
    return this.withNewServiceAttachmentLike(Optional.ofNullable(this.buildServiceAttachment()).orElse(null));
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
    PrivateServiceConnectFluent that = (PrivateServiceConnectFluent) o;
    if (!(Objects.equals(enabled, that.enabled))) {
      return false;
    }
    if (!(Objects.equals(serviceAttachment, that.serviceAttachment))) {
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
  
  public Boolean getEnabled() {
    return this.enabled;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnabled() {
    return this.enabled != null;
  }
  
  public boolean hasServiceAttachment() {
    return this.serviceAttachment != null;
  }
  
  public int hashCode() {
    return Objects.hash(enabled, serviceAttachment, additionalProperties);
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
    if (!(enabled == null)) {
        sb.append("enabled:");
        sb.append(enabled);
        sb.append(",");
    }
    if (!(serviceAttachment == null)) {
        sb.append("serviceAttachment:");
        sb.append(serviceAttachment);
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
  
  public A withEnabled() {
    return withEnabled(true);
  }
  
  public A withEnabled(Boolean enabled) {
    this.enabled = enabled;
    return (A) this;
  }
  
  public ServiceAttachmentNested<A> withNewServiceAttachment() {
    return new ServiceAttachmentNested(null);
  }
  
  public ServiceAttachmentNested<A> withNewServiceAttachmentLike(ServiceAttachment item) {
    return new ServiceAttachmentNested(item);
  }
  
  public A withServiceAttachment(ServiceAttachment serviceAttachment) {
    this._visitables.remove("serviceAttachment");
    if (serviceAttachment != null) {
        this.serviceAttachment = new ServiceAttachmentBuilder(serviceAttachment);
        this._visitables.get("serviceAttachment").add(this.serviceAttachment);
    } else {
        this.serviceAttachment = null;
        this._visitables.get("serviceAttachment").remove(this.serviceAttachment);
    }
    return (A) this;
  }
  public class ServiceAttachmentNested<N> extends ServiceAttachmentFluent<ServiceAttachmentNested<N>> implements Nested<N>{
  
    ServiceAttachmentBuilder builder;
  
    ServiceAttachmentNested(ServiceAttachment item) {
      this.builder = new ServiceAttachmentBuilder(this, item);
    }
  
    public N and() {
      return (N) PrivateServiceConnectFluent.this.withServiceAttachment(builder.build());
    }
    
    public N endServiceAttachment() {
      return and();
    }
    
  }
}