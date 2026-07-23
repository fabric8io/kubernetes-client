package io.fabric8.autoscaling.api.model.v1beta2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class VerticalPodAutoscalerCheckpointStatusFluent<A extends io.fabric8.autoscaling.api.model.v1beta2.VerticalPodAutoscalerCheckpointStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HistogramCheckpointBuilder cpuHistogram;
  private String firstSampleStart;
  private String lastSampleStart;
  private String lastUpdateTime;
  private HistogramCheckpointBuilder memoryHistogram;
  private Integer totalSamplesCount;
  private String version;

  public VerticalPodAutoscalerCheckpointStatusFluent() {
  }
  
  public VerticalPodAutoscalerCheckpointStatusFluent(VerticalPodAutoscalerCheckpointStatus instance) {
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
  
  public HistogramCheckpoint buildCpuHistogram() {
    return this.cpuHistogram != null ? this.cpuHistogram.build() : null;
  }
  
  public HistogramCheckpoint buildMemoryHistogram() {
    return this.memoryHistogram != null ? this.memoryHistogram.build() : null;
  }
  
  protected void copyInstance(VerticalPodAutoscalerCheckpointStatus instance) {
    instance = instance != null ? instance : new VerticalPodAutoscalerCheckpointStatus();
    if (instance != null) {
        this.withCpuHistogram(instance.getCpuHistogram());
        this.withFirstSampleStart(instance.getFirstSampleStart());
        this.withLastSampleStart(instance.getLastSampleStart());
        this.withLastUpdateTime(instance.getLastUpdateTime());
        this.withMemoryHistogram(instance.getMemoryHistogram());
        this.withTotalSamplesCount(instance.getTotalSamplesCount());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CpuHistogramNested<A> editCpuHistogram() {
    return this.withNewCpuHistogramLike(Optional.ofNullable(this.buildCpuHistogram()).orElse(null));
  }
  
  public MemoryHistogramNested<A> editMemoryHistogram() {
    return this.withNewMemoryHistogramLike(Optional.ofNullable(this.buildMemoryHistogram()).orElse(null));
  }
  
  public CpuHistogramNested<A> editOrNewCpuHistogram() {
    return this.withNewCpuHistogramLike(Optional.ofNullable(this.buildCpuHistogram()).orElse(new HistogramCheckpointBuilder().build()));
  }
  
  public CpuHistogramNested<A> editOrNewCpuHistogramLike(HistogramCheckpoint item) {
    return this.withNewCpuHistogramLike(Optional.ofNullable(this.buildCpuHistogram()).orElse(item));
  }
  
  public MemoryHistogramNested<A> editOrNewMemoryHistogram() {
    return this.withNewMemoryHistogramLike(Optional.ofNullable(this.buildMemoryHistogram()).orElse(new HistogramCheckpointBuilder().build()));
  }
  
  public MemoryHistogramNested<A> editOrNewMemoryHistogramLike(HistogramCheckpoint item) {
    return this.withNewMemoryHistogramLike(Optional.ofNullable(this.buildMemoryHistogram()).orElse(item));
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
    VerticalPodAutoscalerCheckpointStatusFluent that = (VerticalPodAutoscalerCheckpointStatusFluent) o;
    if (!(Objects.equals(cpuHistogram, that.cpuHistogram))) {
      return false;
    }
    if (!(Objects.equals(firstSampleStart, that.firstSampleStart))) {
      return false;
    }
    if (!(Objects.equals(lastSampleStart, that.lastSampleStart))) {
      return false;
    }
    if (!(Objects.equals(lastUpdateTime, that.lastUpdateTime))) {
      return false;
    }
    if (!(Objects.equals(memoryHistogram, that.memoryHistogram))) {
      return false;
    }
    if (!(Objects.equals(totalSamplesCount, that.totalSamplesCount))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getFirstSampleStart() {
    return this.firstSampleStart;
  }
  
  public String getLastSampleStart() {
    return this.lastSampleStart;
  }
  
  public String getLastUpdateTime() {
    return this.lastUpdateTime;
  }
  
  public Integer getTotalSamplesCount() {
    return this.totalSamplesCount;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCpuHistogram() {
    return this.cpuHistogram != null;
  }
  
  public boolean hasFirstSampleStart() {
    return this.firstSampleStart != null;
  }
  
  public boolean hasLastSampleStart() {
    return this.lastSampleStart != null;
  }
  
  public boolean hasLastUpdateTime() {
    return this.lastUpdateTime != null;
  }
  
  public boolean hasMemoryHistogram() {
    return this.memoryHistogram != null;
  }
  
  public boolean hasTotalSamplesCount() {
    return this.totalSamplesCount != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(cpuHistogram, firstSampleStart, lastSampleStart, lastUpdateTime, memoryHistogram, totalSamplesCount, version, additionalProperties);
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
    if (!(cpuHistogram == null)) {
        sb.append("cpuHistogram:");
        sb.append(cpuHistogram);
        sb.append(",");
    }
    if (!(firstSampleStart == null)) {
        sb.append("firstSampleStart:");
        sb.append(firstSampleStart);
        sb.append(",");
    }
    if (!(lastSampleStart == null)) {
        sb.append("lastSampleStart:");
        sb.append(lastSampleStart);
        sb.append(",");
    }
    if (!(lastUpdateTime == null)) {
        sb.append("lastUpdateTime:");
        sb.append(lastUpdateTime);
        sb.append(",");
    }
    if (!(memoryHistogram == null)) {
        sb.append("memoryHistogram:");
        sb.append(memoryHistogram);
        sb.append(",");
    }
    if (!(totalSamplesCount == null)) {
        sb.append("totalSamplesCount:");
        sb.append(totalSamplesCount);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withCpuHistogram(HistogramCheckpoint cpuHistogram) {
    this._visitables.remove("cpuHistogram");
    if (cpuHistogram != null) {
        this.cpuHistogram = new HistogramCheckpointBuilder(cpuHistogram);
        this._visitables.get("cpuHistogram").add(this.cpuHistogram);
    } else {
        this.cpuHistogram = null;
        this._visitables.get("cpuHistogram").remove(this.cpuHistogram);
    }
    return (A) this;
  }
  
  public A withFirstSampleStart(String firstSampleStart) {
    this.firstSampleStart = firstSampleStart;
    return (A) this;
  }
  
  public A withLastSampleStart(String lastSampleStart) {
    this.lastSampleStart = lastSampleStart;
    return (A) this;
  }
  
  public A withLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return (A) this;
  }
  
  public A withMemoryHistogram(HistogramCheckpoint memoryHistogram) {
    this._visitables.remove("memoryHistogram");
    if (memoryHistogram != null) {
        this.memoryHistogram = new HistogramCheckpointBuilder(memoryHistogram);
        this._visitables.get("memoryHistogram").add(this.memoryHistogram);
    } else {
        this.memoryHistogram = null;
        this._visitables.get("memoryHistogram").remove(this.memoryHistogram);
    }
    return (A) this;
  }
  
  public CpuHistogramNested<A> withNewCpuHistogram() {
    return new CpuHistogramNested(null);
  }
  
  public CpuHistogramNested<A> withNewCpuHistogramLike(HistogramCheckpoint item) {
    return new CpuHistogramNested(item);
  }
  
  public MemoryHistogramNested<A> withNewMemoryHistogram() {
    return new MemoryHistogramNested(null);
  }
  
  public MemoryHistogramNested<A> withNewMemoryHistogramLike(HistogramCheckpoint item) {
    return new MemoryHistogramNested(item);
  }
  
  public A withTotalSamplesCount(Integer totalSamplesCount) {
    this.totalSamplesCount = totalSamplesCount;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class CpuHistogramNested<N> extends HistogramCheckpointFluent<CpuHistogramNested<N>> implements Nested<N>{
  
    HistogramCheckpointBuilder builder;
  
    CpuHistogramNested(HistogramCheckpoint item) {
      this.builder = new HistogramCheckpointBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerCheckpointStatusFluent.this.withCpuHistogram(builder.build());
    }
    
    public N endCpuHistogram() {
      return and();
    }
    
  }
  public class MemoryHistogramNested<N> extends HistogramCheckpointFluent<MemoryHistogramNested<N>> implements Nested<N>{
  
    HistogramCheckpointBuilder builder;
  
    MemoryHistogramNested(HistogramCheckpoint item) {
      this.builder = new HistogramCheckpointBuilder(this, item);
    }
  
    public N and() {
      return (N) VerticalPodAutoscalerCheckpointStatusFluent.this.withMemoryHistogram(builder.build());
    }
    
    public N endMemoryHistogram() {
      return and();
    }
    
  }
}