package io.fabric8.autoscaling.api.model.v1;

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
public class StartupBoostFluent<A extends io.fabric8.autoscaling.api.model.v1.StartupBoostFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GenericStartupBoostBuilder cpu;

  public StartupBoostFluent() {
  }
  
  public StartupBoostFluent(StartupBoost instance) {
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
  
  public GenericStartupBoost buildCpu() {
    return this.cpu != null ? this.cpu.build() : null;
  }
  
  protected void copyInstance(StartupBoost instance) {
    instance = instance != null ? instance : new StartupBoost();
    if (instance != null) {
        this.withCpu(instance.getCpu());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CpuNested<A> editCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(null));
  }
  
  public CpuNested<A> editOrNewCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(new GenericStartupBoostBuilder().build()));
  }
  
  public CpuNested<A> editOrNewCpuLike(GenericStartupBoost item) {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(item));
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
    StartupBoostFluent that = (StartupBoostFluent) o;
    if (!(Objects.equals(cpu, that.cpu))) {
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
  
  public boolean hasCpu() {
    return this.cpu != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpu, additionalProperties);
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
    if (!(cpu == null)) {
        sb.append("cpu:");
        sb.append(cpu);
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
  
  public A withCpu(GenericStartupBoost cpu) {
    this._visitables.remove("cpu");
    if (cpu != null) {
        this.cpu = new GenericStartupBoostBuilder(cpu);
        this._visitables.get("cpu").add(this.cpu);
    } else {
        this.cpu = null;
        this._visitables.get("cpu").remove(this.cpu);
    }
    return (A) this;
  }
  
  public CpuNested<A> withNewCpu() {
    return new CpuNested(null);
  }
  
  public CpuNested<A> withNewCpuLike(GenericStartupBoost item) {
    return new CpuNested(item);
  }
  public class CpuNested<N> extends GenericStartupBoostFluent<CpuNested<N>> implements Nested<N>{
  
    GenericStartupBoostBuilder builder;
  
    CpuNested(GenericStartupBoost item) {
      this.builder = new GenericStartupBoostBuilder(this, item);
    }
  
    public N and() {
      return (N) StartupBoostFluent.this.withCpu(builder.build());
    }
    
    public N endCpu() {
      return and();
    }
    
  }
}