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
public class MachineManagerSelectorFluent<A extends io.fabric8.openshift.api.model.operator.v1.MachineManagerSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mode;
  private PartialSelectorBuilder partial;

  public MachineManagerSelectorFluent() {
  }
  
  public MachineManagerSelectorFluent(MachineManagerSelector instance) {
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
  
  public PartialSelector buildPartial() {
    return this.partial != null ? this.partial.build() : null;
  }
  
  protected void copyInstance(MachineManagerSelector instance) {
    instance = instance != null ? instance : new MachineManagerSelector();
    if (instance != null) {
        this.withMode(instance.getMode());
        this.withPartial(instance.getPartial());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PartialNested<A> editOrNewPartial() {
    return this.withNewPartialLike(Optional.ofNullable(this.buildPartial()).orElse(new PartialSelectorBuilder().build()));
  }
  
  public PartialNested<A> editOrNewPartialLike(PartialSelector item) {
    return this.withNewPartialLike(Optional.ofNullable(this.buildPartial()).orElse(item));
  }
  
  public PartialNested<A> editPartial() {
    return this.withNewPartialLike(Optional.ofNullable(this.buildPartial()).orElse(null));
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
    MachineManagerSelectorFluent that = (MachineManagerSelectorFluent) o;
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(partial, that.partial))) {
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
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasPartial() {
    return this.partial != null;
  }
  
  public int hashCode() {
    return Objects.hash(mode, partial, additionalProperties);
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
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(partial == null)) {
        sb.append("partial:");
        sb.append(partial);
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
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public PartialNested<A> withNewPartial() {
    return new PartialNested(null);
  }
  
  public PartialNested<A> withNewPartialLike(PartialSelector item) {
    return new PartialNested(item);
  }
  
  public A withPartial(PartialSelector partial) {
    this._visitables.remove("partial");
    if (partial != null) {
        this.partial = new PartialSelectorBuilder(partial);
        this._visitables.get("partial").add(this.partial);
    } else {
        this.partial = null;
        this._visitables.get("partial").remove(this.partial);
    }
    return (A) this;
  }
  public class PartialNested<N> extends PartialSelectorFluent<PartialNested<N>> implements Nested<N>{
  
    PartialSelectorBuilder builder;
  
    PartialNested(PartialSelector item) {
      this.builder = new PartialSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineManagerSelectorFluent.this.withPartial(builder.build());
    }
    
    public N endPartial() {
      return and();
    }
    
  }
}