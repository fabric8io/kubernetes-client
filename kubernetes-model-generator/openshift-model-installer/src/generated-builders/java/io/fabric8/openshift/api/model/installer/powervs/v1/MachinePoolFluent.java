package io.fabric8.openshift.api.model.installer.powervs.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.IntOrStringBuilder;
import io.fabric8.kubernetes.api.model.IntOrStringFluent;
import java.lang.Integer;
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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.installer.powervs.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer memoryGiB;
  private String procType;
  private IntOrStringBuilder processors;
  private String smtLevel;
  private String sysType;
  private List<String> volumeIDs = new ArrayList<String>();

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
  }

  public A addAllToVolumeIDs(Collection<String> items) {
    if (this.volumeIDs == null) {
      this.volumeIDs = new ArrayList();
    }
    for (String item : items) {
      this.volumeIDs.add(item);
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
  
  public A addToVolumeIDs(String... items) {
    if (this.volumeIDs == null) {
      this.volumeIDs = new ArrayList();
    }
    for (String item : items) {
      this.volumeIDs.add(item);
    }
    return (A) this;
  }
  
  public A addToVolumeIDs(int index,String item) {
    if (this.volumeIDs == null) {
      this.volumeIDs = new ArrayList();
    }
    this.volumeIDs.add(index, item);
    return (A) this;
  }
  
  public IntOrString buildProcessors() {
    return this.processors != null ? this.processors.build() : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withMemoryGiB(instance.getMemoryGiB());
        this.withProcType(instance.getProcType());
        this.withProcessors(instance.getProcessors());
        this.withSmtLevel(instance.getSmtLevel());
        this.withSysType(instance.getSysType());
        this.withVolumeIDs(instance.getVolumeIDs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ProcessorsNested<A> editOrNewProcessors() {
    return this.withNewProcessorsLike(Optional.ofNullable(this.buildProcessors()).orElse(new IntOrStringBuilder().build()));
  }
  
  public ProcessorsNested<A> editOrNewProcessorsLike(IntOrString item) {
    return this.withNewProcessorsLike(Optional.ofNullable(this.buildProcessors()).orElse(item));
  }
  
  public ProcessorsNested<A> editProcessors() {
    return this.withNewProcessorsLike(Optional.ofNullable(this.buildProcessors()).orElse(null));
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
    if (!(Objects.equals(memoryGiB, that.memoryGiB))) {
      return false;
    }
    if (!(Objects.equals(procType, that.procType))) {
      return false;
    }
    if (!(Objects.equals(processors, that.processors))) {
      return false;
    }
    if (!(Objects.equals(smtLevel, that.smtLevel))) {
      return false;
    }
    if (!(Objects.equals(sysType, that.sysType))) {
      return false;
    }
    if (!(Objects.equals(volumeIDs, that.volumeIDs))) {
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
  
  public String getFirstVolumeID() {
    return this.volumeIDs.get(0);
  }
  
  public String getLastVolumeID() {
    return this.volumeIDs.get(volumeIDs.size() - 1);
  }
  
  public String getMatchingVolumeID(Predicate<String> predicate) {
      for (String item : volumeIDs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMemoryGiB() {
    return this.memoryGiB;
  }
  
  public String getProcType() {
    return this.procType;
  }
  
  public String getSmtLevel() {
    return this.smtLevel;
  }
  
  public String getSysType() {
    return this.sysType;
  }
  
  public String getVolumeID(int index) {
    return this.volumeIDs.get(index);
  }
  
  public List<String> getVolumeIDs() {
    return this.volumeIDs;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingVolumeID(Predicate<String> predicate) {
      for (String item : volumeIDs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMemoryGiB() {
    return this.memoryGiB != null;
  }
  
  public boolean hasProcType() {
    return this.procType != null;
  }
  
  public boolean hasProcessors() {
    return this.processors != null;
  }
  
  public boolean hasSmtLevel() {
    return this.smtLevel != null;
  }
  
  public boolean hasSysType() {
    return this.sysType != null;
  }
  
  public boolean hasVolumeIDs() {
    return this.volumeIDs != null && !(this.volumeIDs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(memoryGiB, procType, processors, smtLevel, sysType, volumeIDs, additionalProperties);
  }
  
  public A removeAllFromVolumeIDs(Collection<String> items) {
    if (this.volumeIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.volumeIDs.remove(item);
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
  
  public A removeFromVolumeIDs(String... items) {
    if (this.volumeIDs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.volumeIDs.remove(item);
    }
    return (A) this;
  }
  
  public A setToVolumeIDs(int index,String item) {
    if (this.volumeIDs == null) {
      this.volumeIDs = new ArrayList();
    }
    this.volumeIDs.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(memoryGiB == null)) {
        sb.append("memoryGiB:");
        sb.append(memoryGiB);
        sb.append(",");
    }
    if (!(procType == null)) {
        sb.append("procType:");
        sb.append(procType);
        sb.append(",");
    }
    if (!(processors == null)) {
        sb.append("processors:");
        sb.append(processors);
        sb.append(",");
    }
    if (!(smtLevel == null)) {
        sb.append("smtLevel:");
        sb.append(smtLevel);
        sb.append(",");
    }
    if (!(sysType == null)) {
        sb.append("sysType:");
        sb.append(sysType);
        sb.append(",");
    }
    if (!(volumeIDs == null) && !(volumeIDs.isEmpty())) {
        sb.append("volumeIDs:");
        sb.append(volumeIDs);
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
  
  public A withMemoryGiB(Integer memoryGiB) {
    this.memoryGiB = memoryGiB;
    return (A) this;
  }
  
  public ProcessorsNested<A> withNewProcessors() {
    return new ProcessorsNested(null);
  }
  
  public A withNewProcessors(Object value) {
    return (A) this.withProcessors(new IntOrString(value));
  }
  
  public ProcessorsNested<A> withNewProcessorsLike(IntOrString item) {
    return new ProcessorsNested(item);
  }
  
  public A withProcType(String procType) {
    this.procType = procType;
    return (A) this;
  }
  
  public A withProcessors(IntOrString processors) {
    this._visitables.remove("processors");
    if (processors != null) {
        this.processors = new IntOrStringBuilder(processors);
        this._visitables.get("processors").add(this.processors);
    } else {
        this.processors = null;
        this._visitables.get("processors").remove(this.processors);
    }
    return (A) this;
  }
  
  public A withSmtLevel(String smtLevel) {
    this.smtLevel = smtLevel;
    return (A) this;
  }
  
  public A withSysType(String sysType) {
    this.sysType = sysType;
    return (A) this;
  }
  
  public A withVolumeIDs(List<String> volumeIDs) {
    if (volumeIDs != null) {
        this.volumeIDs = new ArrayList();
        for (String item : volumeIDs) {
          this.addToVolumeIDs(item);
        }
    } else {
      this.volumeIDs = null;
    }
    return (A) this;
  }
  
  public A withVolumeIDs(String... volumeIDs) {
    if (this.volumeIDs != null) {
        this.volumeIDs.clear();
        _visitables.remove("volumeIDs");
    }
    if (volumeIDs != null) {
      for (String item : volumeIDs) {
        this.addToVolumeIDs(item);
      }
    }
    return (A) this;
  }
  public class ProcessorsNested<N> extends IntOrStringFluent<ProcessorsNested<N>> implements Nested<N>{
  
    IntOrStringBuilder builder;
  
    ProcessorsNested(IntOrString item) {
      this.builder = new IntOrStringBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withProcessors(builder.build());
    }
    
    public N endProcessors() {
      return and();
    }
    
  }
}