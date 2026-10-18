package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class VLANConfigFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.VLANConfigFluent<A>> extends BaseFluent<A>{

  private AccessVLANConfigBuilder access;
  private Map<String,Object> additionalProperties;
  private String mode;

  public VLANConfigFluent() {
  }
  
  public VLANConfigFluent(VLANConfig instance) {
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
  
  public AccessVLANConfig buildAccess() {
    return this.access != null ? this.access.build() : null;
  }
  
  protected void copyInstance(VLANConfig instance) {
    instance = instance != null ? instance : new VLANConfig();
    if (instance != null) {
        this.withAccess(instance.getAccess());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccessNested<A> editAccess() {
    return this.withNewAccessLike(Optional.ofNullable(this.buildAccess()).orElse(null));
  }
  
  public AccessNested<A> editOrNewAccess() {
    return this.withNewAccessLike(Optional.ofNullable(this.buildAccess()).orElse(new AccessVLANConfigBuilder().build()));
  }
  
  public AccessNested<A> editOrNewAccessLike(AccessVLANConfig item) {
    return this.withNewAccessLike(Optional.ofNullable(this.buildAccess()).orElse(item));
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
    VLANConfigFluent that = (VLANConfigFluent) o;
    if (!(Objects.equals(access, that.access))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAccess() {
    return this.access != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(access, mode, additionalProperties);
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
    if (!(access == null)) {
        sb.append("access:");
        sb.append(access);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccess(AccessVLANConfig access) {
    this._visitables.remove("access");
    if (access != null) {
        this.access = new AccessVLANConfigBuilder(access);
        this._visitables.get("access").add(this.access);
    } else {
        this.access = null;
        this._visitables.get("access").remove(this.access);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public AccessNested<A> withNewAccess() {
    return new AccessNested(null);
  }
  
  public A withNewAccess(Integer id) {
    return (A) this.withAccess(new AccessVLANConfig(id));
  }
  
  public AccessNested<A> withNewAccessLike(AccessVLANConfig item) {
    return new AccessNested(item);
  }
  public class AccessNested<N> extends AccessVLANConfigFluent<AccessNested<N>> implements Nested<N>{
  
    AccessVLANConfigBuilder builder;
  
    AccessNested(AccessVLANConfig item) {
      this.builder = new AccessVLANConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) VLANConfigFluent.this.withAccess(builder.build());
    }
    
    public N endAccess() {
      return and();
    }
    
  }
}