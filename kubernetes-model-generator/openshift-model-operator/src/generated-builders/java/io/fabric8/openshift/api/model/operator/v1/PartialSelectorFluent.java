package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class PartialSelectorFluent<A extends io.fabric8.openshift.api.model.operator.v1.PartialSelectorFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LabelSelectorBuilder machineResourceSelector;

  public PartialSelectorFluent() {
  }
  
  public PartialSelectorFluent(PartialSelector instance) {
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
  
  public LabelSelector buildMachineResourceSelector() {
    return this.machineResourceSelector != null ? this.machineResourceSelector.build() : null;
  }
  
  protected void copyInstance(PartialSelector instance) {
    instance = instance != null ? instance : new PartialSelector();
    if (instance != null) {
        this.withMachineResourceSelector(instance.getMachineResourceSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MachineResourceSelectorNested<A> editMachineResourceSelector() {
    return this.withNewMachineResourceSelectorLike(Optional.ofNullable(this.buildMachineResourceSelector()).orElse(null));
  }
  
  public MachineResourceSelectorNested<A> editOrNewMachineResourceSelector() {
    return this.withNewMachineResourceSelectorLike(Optional.ofNullable(this.buildMachineResourceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public MachineResourceSelectorNested<A> editOrNewMachineResourceSelectorLike(LabelSelector item) {
    return this.withNewMachineResourceSelectorLike(Optional.ofNullable(this.buildMachineResourceSelector()).orElse(item));
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
    PartialSelectorFluent that = (PartialSelectorFluent) o;
    if (!(Objects.equals(machineResourceSelector, that.machineResourceSelector))) {
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
  
  public boolean hasMachineResourceSelector() {
    return this.machineResourceSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(machineResourceSelector, additionalProperties);
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
    if (!(machineResourceSelector == null)) {
        sb.append("machineResourceSelector:");
        sb.append(machineResourceSelector);
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
  
  public A withMachineResourceSelector(LabelSelector machineResourceSelector) {
    this._visitables.remove("machineResourceSelector");
    if (machineResourceSelector != null) {
        this.machineResourceSelector = new LabelSelectorBuilder(machineResourceSelector);
        this._visitables.get("machineResourceSelector").add(this.machineResourceSelector);
    } else {
        this.machineResourceSelector = null;
        this._visitables.get("machineResourceSelector").remove(this.machineResourceSelector);
    }
    return (A) this;
  }
  
  public MachineResourceSelectorNested<A> withNewMachineResourceSelector() {
    return new MachineResourceSelectorNested(null);
  }
  
  public MachineResourceSelectorNested<A> withNewMachineResourceSelectorLike(LabelSelector item) {
    return new MachineResourceSelectorNested(item);
  }
  public class MachineResourceSelectorNested<N> extends LabelSelectorFluent<MachineResourceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    MachineResourceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PartialSelectorFluent.this.withMachineResourceSelector(builder.build());
    }
    
    public N endMachineResourceSelector() {
      return and();
    }
    
  }
}