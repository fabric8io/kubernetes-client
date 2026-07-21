package io.fabric8.chaosmesh.v1alpha1;

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
public class StressorsFluent<A extends io.fabric8.chaosmesh.v1alpha1.StressorsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CPUStressorBuilder cpu;
  private MemoryStressorBuilder memory;

  public StressorsFluent() {
  }
  
  public StressorsFluent(Stressors instance) {
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
  
  public CPUStressor buildCpu() {
    return this.cpu != null ? this.cpu.build() : null;
  }
  
  public MemoryStressor buildMemory() {
    return this.memory != null ? this.memory.build() : null;
  }
  
  protected void copyInstance(Stressors instance) {
    instance = instance != null ? instance : new Stressors();
    if (instance != null) {
        this.withCpu(instance.getCpu());
        this.withMemory(instance.getMemory());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CpuNested<A> editCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(null));
  }
  
  public MemoryNested<A> editMemory() {
    return this.withNewMemoryLike(Optional.ofNullable(this.buildMemory()).orElse(null));
  }
  
  public CpuNested<A> editOrNewCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(new CPUStressorBuilder().build()));
  }
  
  public CpuNested<A> editOrNewCpuLike(CPUStressor item) {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(item));
  }
  
  public MemoryNested<A> editOrNewMemory() {
    return this.withNewMemoryLike(Optional.ofNullable(this.buildMemory()).orElse(new MemoryStressorBuilder().build()));
  }
  
  public MemoryNested<A> editOrNewMemoryLike(MemoryStressor item) {
    return this.withNewMemoryLike(Optional.ofNullable(this.buildMemory()).orElse(item));
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
    StressorsFluent that = (StressorsFluent) o;
    if (!(Objects.equals(cpu, that.cpu))) {
      return false;
    }
    if (!(Objects.equals(memory, that.memory))) {
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
  
  public boolean hasMemory() {
    return this.memory != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpu, memory, additionalProperties);
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
    if (!(memory == null)) {
        sb.append("memory:");
        sb.append(memory);
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
  
  public A withCpu(CPUStressor cpu) {
    this._visitables.remove("cpu");
    if (cpu != null) {
        this.cpu = new CPUStressorBuilder(cpu);
        this._visitables.get("cpu").add(this.cpu);
    } else {
        this.cpu = null;
        this._visitables.get("cpu").remove(this.cpu);
    }
    return (A) this;
  }
  
  public A withMemory(MemoryStressor memory) {
    this._visitables.remove("memory");
    if (memory != null) {
        this.memory = new MemoryStressorBuilder(memory);
        this._visitables.get("memory").add(this.memory);
    } else {
        this.memory = null;
        this._visitables.get("memory").remove(this.memory);
    }
    return (A) this;
  }
  
  public CpuNested<A> withNewCpu() {
    return new CpuNested(null);
  }
  
  public CpuNested<A> withNewCpuLike(CPUStressor item) {
    return new CpuNested(item);
  }
  
  public MemoryNested<A> withNewMemory() {
    return new MemoryNested(null);
  }
  
  public MemoryNested<A> withNewMemoryLike(MemoryStressor item) {
    return new MemoryNested(item);
  }
  public class CpuNested<N> extends CPUStressorFluent<CpuNested<N>> implements Nested<N>{
  
    CPUStressorBuilder builder;
  
    CpuNested(CPUStressor item) {
      this.builder = new CPUStressorBuilder(this, item);
    }
  
    public N and() {
      return (N) StressorsFluent.this.withCpu(builder.build());
    }
    
    public N endCpu() {
      return and();
    }
    
  }
  public class MemoryNested<N> extends MemoryStressorFluent<MemoryNested<N>> implements Nested<N>{
  
    MemoryStressorBuilder builder;
  
    MemoryNested(MemoryStressor item) {
      this.builder = new MemoryStressorBuilder(this, item);
    }
  
    public N and() {
      return (N) StressorsFluent.this.withMemory(builder.build());
    }
    
    public N endMemory() {
      return and();
    }
    
  }
}