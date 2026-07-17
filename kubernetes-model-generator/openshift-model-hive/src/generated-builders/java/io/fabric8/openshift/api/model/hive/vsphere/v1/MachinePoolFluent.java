package io.fabric8.openshift.api.model.hive.vsphere.v1;

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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.hive.vsphere.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer coresPerSocket;
  private Integer cpus;
  private Long memoryMB;
  private OSDiskBuilder osDisk;
  private String resourcePool;

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
  
  public OSDisk buildOsDisk() {
    return this.osDisk != null ? this.osDisk.build() : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withCoresPerSocket(instance.getCoresPerSocket());
        this.withCpus(instance.getCpus());
        this.withMemoryMB(instance.getMemoryMB());
        this.withOsDisk(instance.getOsDisk());
        this.withResourcePool(instance.getResourcePool());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OsDiskNested<A> editOrNewOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(new OSDiskBuilder().build()));
  }
  
  public OsDiskNested<A> editOrNewOsDiskLike(OSDisk item) {
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
    if (!(Objects.equals(coresPerSocket, that.coresPerSocket))) {
      return false;
    }
    if (!(Objects.equals(cpus, that.cpus))) {
      return false;
    }
    if (!(Objects.equals(memoryMB, that.memoryMB))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(resourcePool, that.resourcePool))) {
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
  
  public Integer getCoresPerSocket() {
    return this.coresPerSocket;
  }
  
  public Integer getCpus() {
    return this.cpus;
  }
  
  public Long getMemoryMB() {
    return this.memoryMB;
  }
  
  public String getResourcePool() {
    return this.resourcePool;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCoresPerSocket() {
    return this.coresPerSocket != null;
  }
  
  public boolean hasCpus() {
    return this.cpus != null;
  }
  
  public boolean hasMemoryMB() {
    return this.memoryMB != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasResourcePool() {
    return this.resourcePool != null;
  }
  
  public int hashCode() {
    return Objects.hash(coresPerSocket, cpus, memoryMB, osDisk, resourcePool, additionalProperties);
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
    if (!(coresPerSocket == null)) {
        sb.append("coresPerSocket:");
        sb.append(coresPerSocket);
        sb.append(",");
    }
    if (!(cpus == null)) {
        sb.append("cpus:");
        sb.append(cpus);
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
    if (!(resourcePool == null)) {
        sb.append("resourcePool:");
        sb.append(resourcePool);
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
  
  public A withCoresPerSocket(Integer coresPerSocket) {
    this.coresPerSocket = coresPerSocket;
    return (A) this;
  }
  
  public A withCpus(Integer cpus) {
    this.cpus = cpus;
    return (A) this;
  }
  
  public A withMemoryMB(Long memoryMB) {
    this.memoryMB = memoryMB;
    return (A) this;
  }
  
  public OsDiskNested<A> withNewOsDisk() {
    return new OsDiskNested(null);
  }
  
  public A withNewOsDisk(Integer diskSizeGB) {
    return (A) this.withOsDisk(new OSDisk(diskSizeGB));
  }
  
  public OsDiskNested<A> withNewOsDiskLike(OSDisk item) {
    return new OsDiskNested(item);
  }
  
  public A withOsDisk(OSDisk osDisk) {
    this._visitables.remove("osDisk");
    if (osDisk != null) {
        this.osDisk = new OSDiskBuilder(osDisk);
        this._visitables.get("osDisk").add(this.osDisk);
    } else {
        this.osDisk = null;
        this._visitables.get("osDisk").remove(this.osDisk);
    }
    return (A) this;
  }
  
  public A withResourcePool(String resourcePool) {
    this.resourcePool = resourcePool;
    return (A) this;
  }
  public class OsDiskNested<N> extends OSDiskFluent<OsDiskNested<N>> implements Nested<N>{
  
    OSDiskBuilder builder;
  
    OsDiskNested(OSDisk item) {
      this.builder = new OSDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withOsDisk(builder.build());
    }
    
    public N endOsDisk() {
      return and();
    }
    
  }
}