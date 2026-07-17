package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class HardwareDataSpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.HardwareDataSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HardwareDetailsBuilder hardware;

  public HardwareDataSpecFluent() {
  }
  
  public HardwareDataSpecFluent(HardwareDataSpec instance) {
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
  
  public HardwareDetails buildHardware() {
    return this.hardware != null ? this.hardware.build() : null;
  }
  
  protected void copyInstance(HardwareDataSpec instance) {
    instance = instance != null ? instance : new HardwareDataSpec();
    if (instance != null) {
        this.withHardware(instance.getHardware());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HardwareNested<A> editHardware() {
    return this.withNewHardwareLike(Optional.ofNullable(this.buildHardware()).orElse(null));
  }
  
  public HardwareNested<A> editOrNewHardware() {
    return this.withNewHardwareLike(Optional.ofNullable(this.buildHardware()).orElse(new HardwareDetailsBuilder().build()));
  }
  
  public HardwareNested<A> editOrNewHardwareLike(HardwareDetails item) {
    return this.withNewHardwareLike(Optional.ofNullable(this.buildHardware()).orElse(item));
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
    HardwareDataSpecFluent that = (HardwareDataSpecFluent) o;
    if (!(Objects.equals(hardware, that.hardware))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHardware() {
    return this.hardware != null;
  }
  
  public int hashCode() {
    return Objects.hash(hardware, additionalProperties);
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
    if (!(hardware == null)) {
        sb.append("hardware:");
        sb.append(hardware);
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
  
  public A withHardware(HardwareDetails hardware) {
    this._visitables.remove("hardware");
    if (hardware != null) {
        this.hardware = new HardwareDetailsBuilder(hardware);
        this._visitables.get("hardware").add(this.hardware);
    } else {
        this.hardware = null;
        this._visitables.get("hardware").remove(this.hardware);
    }
    return (A) this;
  }
  
  public HardwareNested<A> withNewHardware() {
    return new HardwareNested(null);
  }
  
  public HardwareNested<A> withNewHardwareLike(HardwareDetails item) {
    return new HardwareNested(item);
  }
  public class HardwareNested<N> extends HardwareDetailsFluent<HardwareNested<N>> implements Nested<N>{
  
    HardwareDetailsBuilder builder;
  
    HardwareNested(HardwareDetails item) {
      this.builder = new HardwareDetailsBuilder(this, item);
    }
  
    public N and() {
      return (N) HardwareDataSpecFluent.this.withHardware(builder.build());
    }
    
    public N endHardware() {
      return and();
    }
    
  }
}