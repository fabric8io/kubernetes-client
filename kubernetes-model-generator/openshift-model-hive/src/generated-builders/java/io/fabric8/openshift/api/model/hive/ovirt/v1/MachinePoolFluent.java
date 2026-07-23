package io.fabric8.openshift.api.model.hive.ovirt.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.hive.ovirt.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CPUBuilder cpu;
  private Integer memoryMB;
  private DiskBuilder osDisk;
  private String vmType;

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
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
  
  public CPU buildCpu() {
    return this.cpu != null ? this.cpu.build() : null;
  }
  
  public Disk buildOsDisk() {
    return this.osDisk != null ? this.osDisk.build() : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withCpu(instance.getCpu());
        this.withMemoryMB(instance.getMemoryMB());
        this.withOsDisk(instance.getOsDisk());
        this.withVmType(instance.getVmType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CpuNested<A> editCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(null));
  }
  
  public CpuNested<A> editOrNewCpu() {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(new CPUBuilder().build()));
  }
  
  public CpuNested<A> editOrNewCpuLike(CPU item) {
    return this.withNewCpuLike(Optional.ofNullable(this.buildCpu()).orElse(item));
  }
  
  public OsDiskNested<A> editOrNewOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(new DiskBuilder().build()));
  }
  
  public OsDiskNested<A> editOrNewOsDiskLike(Disk item) {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(item));
  }
  
  public OsDiskNested<A> editOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(null));
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
    MachinePoolFluent that = (MachinePoolFluent) o;
    if (!(Objects.equals(cpu, that.cpu))) {
      return false;
    }
    if (!(Objects.equals(memoryMB, that.memoryMB))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(vmType, that.vmType))) {
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
  
  public Integer getMemoryMB() {
    return this.memoryMB;
  }
  
  public String getVmType() {
    return this.vmType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCpu() {
    return this.cpu != null;
  }
  
  public boolean hasMemoryMB() {
    return this.memoryMB != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasVmType() {
    return this.vmType != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpu, memoryMB, osDisk, vmType, additionalProperties);
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
    if (!(memoryMB == null)) {
        sb.append("memoryMB:");
        sb.append(memoryMB);
        sb.append(",");
    }
    if (!(osDisk == null)) {
        sb.append("osDisk:");
        sb.append(osDisk);
        sb.append(",");
    }
    if (!(vmType == null)) {
        sb.append("vmType:");
        sb.append(vmType);
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
  
  public A withCpu(CPU cpu) {
    this._visitables.remove("cpu");
    if (cpu != null) {
        this.cpu = new CPUBuilder(cpu);
        this._visitables.get("cpu").add(this.cpu);
    } else {
        this.cpu = null;
        this._visitables.get("cpu").remove(this.cpu);
    }
    return (A) this;
  }
  
  public A withMemoryMB(Integer memoryMB) {
    this.memoryMB = memoryMB;
    return (A) this;
  }
  
  public CpuNested<A> withNewCpu() {
    return new CpuNested(null);
  }
  
  public A withNewCpu(Integer cores,Integer sockets) {
    return (A) this.withCpu(new CPU(cores, sockets));
  }
  
  public CpuNested<A> withNewCpuLike(CPU item) {
    return new CpuNested(item);
  }
  
  public OsDiskNested<A> withNewOsDisk() {
    return new OsDiskNested(null);
  }
  
  public A withNewOsDisk(Long sizeGB) {
    return (A) this.withOsDisk(new Disk(sizeGB));
  }
  
  public OsDiskNested<A> withNewOsDiskLike(Disk item) {
    return new OsDiskNested(item);
  }
  
  public A withOsDisk(Disk osDisk) {
    this._visitables.remove("osDisk");
    if (osDisk != null) {
        this.osDisk = new DiskBuilder(osDisk);
        this._visitables.get("osDisk").add(this.osDisk);
    } else {
        this.osDisk = null;
        this._visitables.get("osDisk").remove(this.osDisk);
    }
    return (A) this;
  }
  
  public A withVmType(String vmType) {
    this.vmType = vmType;
    return (A) this;
  }
  public class CpuNested<N> extends CPUFluent<CpuNested<N>> implements Nested<N>{
  
    CPUBuilder builder;
  
    CpuNested(CPU item) {
      this.builder = new CPUBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withCpu(builder.build());
    }
    
    public N endCpu() {
      return and();
    }
    
  }
  public class OsDiskNested<N> extends DiskFluent<OsDiskNested<N>> implements Nested<N>{
  
    DiskBuilder builder;
  
    OsDiskNested(Disk item) {
      this.builder = new DiskBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withOsDisk(builder.build());
    }
    
    public N endOsDisk() {
      return and();
    }
    
  }
}