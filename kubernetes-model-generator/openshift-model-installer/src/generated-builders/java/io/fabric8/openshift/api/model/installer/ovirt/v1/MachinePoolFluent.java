package io.fabric8.openshift.api.model.installer.ovirt.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.installer.ovirt.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> affinityGroupsNames = new ArrayList<String>();
  private String autoPinningPolicy;
  private Boolean clone;
  private CPUBuilder cpu;
  private String format;
  private Integer hugepages;
  private String instanceTypeID;
  private Integer memoryMB;
  private DiskBuilder osDisk;
  private Boolean sparse;
  private String vmType;

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
  }

  public A addAllToAffinityGroupsNames(Collection<String> items) {
    if (this.affinityGroupsNames == null) {
      this.affinityGroupsNames = new ArrayList();
    }
    for (String item : items) {
      this.affinityGroupsNames.add(item);
    }
    return (A) this;
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
  
  public A addToAffinityGroupsNames(String... items) {
    if (this.affinityGroupsNames == null) {
      this.affinityGroupsNames = new ArrayList();
    }
    for (String item : items) {
      this.affinityGroupsNames.add(item);
    }
    return (A) this;
  }
  
  public A addToAffinityGroupsNames(int index,String item) {
    if (this.affinityGroupsNames == null) {
      this.affinityGroupsNames = new ArrayList();
    }
    this.affinityGroupsNames.add(index, item);
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
        this.withAffinityGroupsNames(instance.getAffinityGroupsNames());
        this.withAutoPinningPolicy(instance.getAutoPinningPolicy());
        this.withClone(instance.getClone());
        this.withCpu(instance.getCpu());
        this.withFormat(instance.getFormat());
        this.withHugepages(instance.getHugepages());
        this.withInstanceTypeID(instance.getInstanceTypeID());
        this.withMemoryMB(instance.getMemoryMB());
        this.withOsDisk(instance.getOsDisk());
        this.withSparse(instance.getSparse());
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
    if (!(Objects.equals(affinityGroupsNames, that.affinityGroupsNames))) {
      return false;
    }
    if (!(Objects.equals(autoPinningPolicy, that.autoPinningPolicy))) {
      return false;
    }
    if (!(Objects.equals(clone, that.clone))) {
      return false;
    }
    if (!(Objects.equals(cpu, that.cpu))) {
      return false;
    }
    if (!(Objects.equals(format, that.format))) {
      return false;
    }
    if (!(Objects.equals(hugepages, that.hugepages))) {
      return false;
    }
    if (!(Objects.equals(instanceTypeID, that.instanceTypeID))) {
      return false;
    }
    if (!(Objects.equals(memoryMB, that.memoryMB))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(sparse, that.sparse))) {
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
  
  public String getAffinityGroupsName(int index) {
    return this.affinityGroupsNames.get(index);
  }
  
  public List<String> getAffinityGroupsNames() {
    return this.affinityGroupsNames;
  }
  
  public String getAutoPinningPolicy() {
    return this.autoPinningPolicy;
  }
  
  public Boolean getClone() {
    return this.clone;
  }
  
  public String getFirstAffinityGroupsName() {
    return this.affinityGroupsNames.get(0);
  }
  
  public String getFormat() {
    return this.format;
  }
  
  public Integer getHugepages() {
    return this.hugepages;
  }
  
  public String getInstanceTypeID() {
    return this.instanceTypeID;
  }
  
  public String getLastAffinityGroupsName() {
    return this.affinityGroupsNames.get(affinityGroupsNames.size() - 1);
  }
  
  public String getMatchingAffinityGroupsName(Predicate<String> predicate) {
      for (String item : affinityGroupsNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMemoryMB() {
    return this.memoryMB;
  }
  
  public Boolean getSparse() {
    return this.sparse;
  }
  
  public String getVmType() {
    return this.vmType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAffinityGroupsNames() {
    return this.affinityGroupsNames != null && !(this.affinityGroupsNames.isEmpty());
  }
  
  public boolean hasAutoPinningPolicy() {
    return this.autoPinningPolicy != null;
  }
  
  public boolean hasClone() {
    return this.clone != null;
  }
  
  public boolean hasCpu() {
    return this.cpu != null;
  }
  
  public boolean hasFormat() {
    return this.format != null;
  }
  
  public boolean hasHugepages() {
    return this.hugepages != null;
  }
  
  public boolean hasInstanceTypeID() {
    return this.instanceTypeID != null;
  }
  
  public boolean hasMatchingAffinityGroupsName(Predicate<String> predicate) {
      for (String item : affinityGroupsNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemoryMB() {
    return this.memoryMB != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasSparse() {
    return this.sparse != null;
  }
  
  public boolean hasVmType() {
    return this.vmType != null;
  }
  
  public int hashCode() {
    return Objects.hash(affinityGroupsNames, autoPinningPolicy, clone, cpu, format, hugepages, instanceTypeID, memoryMB, osDisk, sparse, vmType, additionalProperties);
  }
  
  public A removeAllFromAffinityGroupsNames(Collection<String> items) {
    if (this.affinityGroupsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.affinityGroupsNames.remove(item);
    }
    return (A) this;
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
  
  public A removeFromAffinityGroupsNames(String... items) {
    if (this.affinityGroupsNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.affinityGroupsNames.remove(item);
    }
    return (A) this;
  }
  
  public A setToAffinityGroupsNames(int index,String item) {
    if (this.affinityGroupsNames == null) {
      this.affinityGroupsNames = new ArrayList();
    }
    this.affinityGroupsNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(affinityGroupsNames == null) && !(affinityGroupsNames.isEmpty())) {
        sb.append("affinityGroupsNames:");
        sb.append(affinityGroupsNames);
        sb.append(",");
    }
    if (!(autoPinningPolicy == null)) {
        sb.append("autoPinningPolicy:");
        sb.append(autoPinningPolicy);
        sb.append(",");
    }
    if (!(clone == null)) {
        sb.append("clone:");
        sb.append(clone);
        sb.append(",");
    }
    if (!(cpu == null)) {
        sb.append("cpu:");
        sb.append(cpu);
        sb.append(",");
    }
    if (!(format == null)) {
        sb.append("format:");
        sb.append(format);
        sb.append(",");
    }
    if (!(hugepages == null)) {
        sb.append("hugepages:");
        sb.append(hugepages);
        sb.append(",");
    }
    if (!(instanceTypeID == null)) {
        sb.append("instanceTypeID:");
        sb.append(instanceTypeID);
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
    if (!(sparse == null)) {
        sb.append("sparse:");
        sb.append(sparse);
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
  
  public A withAffinityGroupsNames(List<String> affinityGroupsNames) {
    if (affinityGroupsNames != null) {
        this.affinityGroupsNames = new ArrayList();
        for (String item : affinityGroupsNames) {
          this.addToAffinityGroupsNames(item);
        }
    } else {
      this.affinityGroupsNames = null;
    }
    return (A) this;
  }
  
  public A withAffinityGroupsNames(String... affinityGroupsNames) {
    if (this.affinityGroupsNames != null) {
        this.affinityGroupsNames.clear();
        _visitables.remove("affinityGroupsNames");
    }
    if (affinityGroupsNames != null) {
      for (String item : affinityGroupsNames) {
        this.addToAffinityGroupsNames(item);
      }
    }
    return (A) this;
  }
  
  public A withAutoPinningPolicy(String autoPinningPolicy) {
    this.autoPinningPolicy = autoPinningPolicy;
    return (A) this;
  }
  
  public A withClone() {
    return withClone(true);
  }
  
  public A withClone(Boolean clone) {
    this.clone = clone;
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
  
  public A withFormat(String format) {
    this.format = format;
    return (A) this;
  }
  
  public A withHugepages(Integer hugepages) {
    this.hugepages = hugepages;
    return (A) this;
  }
  
  public A withInstanceTypeID(String instanceTypeID) {
    this.instanceTypeID = instanceTypeID;
    return (A) this;
  }
  
  public A withMemoryMB(Integer memoryMB) {
    this.memoryMB = memoryMB;
    return (A) this;
  }
  
  public CpuNested<A> withNewCpu() {
    return new CpuNested(null);
  }
  
  public A withNewCpu(Integer cores,Integer sockets,Integer threads) {
    return (A) this.withCpu(new CPU(cores, sockets, threads));
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
  
  public A withSparse() {
    return withSparse(true);
  }
  
  public A withSparse(Boolean sparse) {
    this.sparse = sparse;
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