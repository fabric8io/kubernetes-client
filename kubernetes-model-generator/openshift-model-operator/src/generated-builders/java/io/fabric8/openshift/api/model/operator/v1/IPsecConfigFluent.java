package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class IPsecConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.IPsecConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IPsecFullModeConfigBuilder full;
  private String mode;

  public IPsecConfigFluent() {
  }
  
  public IPsecConfigFluent(IPsecConfig instance) {
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
  
  public IPsecFullModeConfig buildFull() {
    return this.full != null ? this.full.build() : null;
  }
  
  protected void copyInstance(IPsecConfig instance) {
    instance = instance != null ? instance : new IPsecConfig();
    if (instance != null) {
        this.withFull(instance.getFull());
        this.withMode(instance.getMode());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FullNested<A> editFull() {
    return this.withNewFullLike(Optional.ofNullable(this.buildFull()).orElse(null));
  }
  
  public FullNested<A> editOrNewFull() {
    return this.withNewFullLike(Optional.ofNullable(this.buildFull()).orElse(new IPsecFullModeConfigBuilder().build()));
  }
  
  public FullNested<A> editOrNewFullLike(IPsecFullModeConfig item) {
    return this.withNewFullLike(Optional.ofNullable(this.buildFull()).orElse(item));
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
    IPsecConfigFluent that = (IPsecConfigFluent) o;
    if (!(Objects.equals(full, that.full))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFull() {
    return this.full != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public int hashCode() {
    return Objects.hash(full, mode, additionalProperties);
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
    if (!(full == null)) {
        sb.append("full:");
        sb.append(full);
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
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withFull(IPsecFullModeConfig full) {
    this._visitables.remove("full");
    if (full != null) {
        this.full = new IPsecFullModeConfigBuilder(full);
        this._visitables.get("full").add(this.full);
    } else {
        this.full = null;
        this._visitables.get("full").remove(this.full);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public FullNested<A> withNewFull() {
    return new FullNested(null);
  }
  
  public A withNewFull(String encapsulation) {
    return (A) this.withFull(new IPsecFullModeConfig(encapsulation));
  }
  
  public FullNested<A> withNewFullLike(IPsecFullModeConfig item) {
    return new FullNested(item);
  }
  public class FullNested<N> extends IPsecFullModeConfigFluent<FullNested<N>> implements Nested<N>{
  
    IPsecFullModeConfigBuilder builder;
  
    FullNested(IPsecFullModeConfig item) {
      this.builder = new IPsecFullModeConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) IPsecConfigFluent.this.withFull(builder.build());
    }
    
    public N endFull() {
      return and();
    }
    
  }
}