package io.fabric8.openshift.api.model.autoscaling.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class ClusterAutoscalerSpecResourceLimitsFluent<A extends io.fabric8.openshift.api.model.autoscaling.v1.ClusterAutoscalerSpecResourceLimitsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ClusterAutoscalerSpecRLCoresBuilder cores;
  private ArrayList<ClusterAutoscalerSpecRLGpusBuilder> gpus = new ArrayList<ClusterAutoscalerSpecRLGpusBuilder>();
  private Integer maxNodesTotal;
  private ClusterAutoscalerSpecRLMemoryBuilder memory;

  public ClusterAutoscalerSpecResourceLimitsFluent() {
  }
  
  public ClusterAutoscalerSpecResourceLimitsFluent(ClusterAutoscalerSpecResourceLimits instance) {
    this.copyInstance(instance);
  }

  public A addAllToGpus(Collection<ClusterAutoscalerSpecRLGpus> items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (ClusterAutoscalerSpecRLGpus item : items) {
        ClusterAutoscalerSpecRLGpusBuilder builder = new ClusterAutoscalerSpecRLGpusBuilder(item);
        _visitables.get("gpus").add(builder);
        this.gpus.add(builder);
    }
    return (A) this;
  }
  
  public GpusNested<A> addNewGpus() {
    return new GpusNested(-1, null);
  }
  
  public A addNewGpus(Integer max,Integer min,String type) {
    return (A) this.addToGpus(new ClusterAutoscalerSpecRLGpus(max, min, type));
  }
  
  public GpusNested<A> addNewGpusLike(ClusterAutoscalerSpecRLGpus item) {
    return new GpusNested(-1, item);
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
  
  public A addToGpus(ClusterAutoscalerSpecRLGpus... items) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    for (ClusterAutoscalerSpecRLGpus item : items) {
        ClusterAutoscalerSpecRLGpusBuilder builder = new ClusterAutoscalerSpecRLGpusBuilder(item);
        _visitables.get("gpus").add(builder);
        this.gpus.add(builder);
    }
    return (A) this;
  }
  
  public A addToGpus(int index,ClusterAutoscalerSpecRLGpus item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    ClusterAutoscalerSpecRLGpusBuilder builder = new ClusterAutoscalerSpecRLGpusBuilder(item);
    if (index < 0 || index >= gpus.size()) {
        _visitables.get("gpus").add(builder);
        gpus.add(builder);
    } else {
        _visitables.get("gpus").add(builder);
        gpus.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterAutoscalerSpecRLCores buildCores() {
    return this.cores != null ? this.cores.build() : null;
  }
  
  public ClusterAutoscalerSpecRLGpus buildFirstGpus() {
    return this.gpus.get(0).build();
  }
  
  public List<ClusterAutoscalerSpecRLGpus> buildGpus() {
    return this.gpus != null ? build(gpus) : null;
  }
  
  public ClusterAutoscalerSpecRLGpus buildGpus(int index) {
    return this.gpus.get(index).build();
  }
  
  public ClusterAutoscalerSpecRLGpus buildLastGpus() {
    return this.gpus.get(gpus.size() - 1).build();
  }
  
  public ClusterAutoscalerSpecRLGpus buildMatchingGpus(Predicate<ClusterAutoscalerSpecRLGpusBuilder> predicate) {
      for (ClusterAutoscalerSpecRLGpusBuilder item : gpus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterAutoscalerSpecRLMemory buildMemory() {
    return this.memory != null ? this.memory.build() : null;
  }
  
  protected void copyInstance(ClusterAutoscalerSpecResourceLimits instance) {
    instance = instance != null ? instance : new ClusterAutoscalerSpecResourceLimits();
    if (instance != null) {
        this.withCores(instance.getCores());
        this.withGpus(instance.getGpus());
        this.withMaxNodesTotal(instance.getMaxNodesTotal());
        this.withMemory(instance.getMemory());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CoresNested<A> editCores() {
    return this.withNewCoresLike(Optional.ofNullable(this.buildCores()).orElse(null));
  }
  
  public GpusNested<A> editFirstGpus() {
    if (gpus.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "gpus"));
    }
    return this.setNewGpusLike(0, this.buildGpus(0));
  }
  
  public GpusNested<A> editGpus(int index) {
    if (gpus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public GpusNested<A> editLastGpus() {
    int index = gpus.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public GpusNested<A> editMatchingGpus(Predicate<ClusterAutoscalerSpecRLGpusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < gpus.size();i++) {
      if (predicate.test(gpus.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "gpus"));
    }
    return this.setNewGpusLike(index, this.buildGpus(index));
  }
  
  public MemoryNested<A> editMemory() {
    return this.withNewMemoryLike(Optional.ofNullable(this.buildMemory()).orElse(null));
  }
  
  public CoresNested<A> editOrNewCores() {
    return this.withNewCoresLike(Optional.ofNullable(this.buildCores()).orElse(new ClusterAutoscalerSpecRLCoresBuilder().build()));
  }
  
  public CoresNested<A> editOrNewCoresLike(ClusterAutoscalerSpecRLCores item) {
    return this.withNewCoresLike(Optional.ofNullable(this.buildCores()).orElse(item));
  }
  
  public MemoryNested<A> editOrNewMemory() {
    return this.withNewMemoryLike(Optional.ofNullable(this.buildMemory()).orElse(new ClusterAutoscalerSpecRLMemoryBuilder().build()));
  }
  
  public MemoryNested<A> editOrNewMemoryLike(ClusterAutoscalerSpecRLMemory item) {
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
    ClusterAutoscalerSpecResourceLimitsFluent that = (ClusterAutoscalerSpecResourceLimitsFluent) o;
    if (!(Objects.equals(cores, that.cores))) {
      return false;
    }
    if (!(Objects.equals(gpus, that.gpus))) {
      return false;
    }
    if (!(Objects.equals(maxNodesTotal, that.maxNodesTotal))) {
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
  
  public Integer getMaxNodesTotal() {
    return this.maxNodesTotal;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCores() {
    return this.cores != null;
  }
  
  public boolean hasGpus() {
    return this.gpus != null && !(this.gpus.isEmpty());
  }
  
  public boolean hasMatchingGpus(Predicate<ClusterAutoscalerSpecRLGpusBuilder> predicate) {
      for (ClusterAutoscalerSpecRLGpusBuilder item : gpus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxNodesTotal() {
    return this.maxNodesTotal != null;
  }
  
  public boolean hasMemory() {
    return this.memory != null;
  }
  
  public int hashCode() {
    return Objects.hash(cores, gpus, maxNodesTotal, memory, additionalProperties);
  }
  
  public A removeAllFromGpus(Collection<ClusterAutoscalerSpecRLGpus> items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (ClusterAutoscalerSpecRLGpus item : items) {
        ClusterAutoscalerSpecRLGpusBuilder builder = new ClusterAutoscalerSpecRLGpusBuilder(item);
        _visitables.get("gpus").remove(builder);
        this.gpus.remove(builder);
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
  
  public A removeFromGpus(ClusterAutoscalerSpecRLGpus... items) {
    if (this.gpus == null) {
      return (A) this;
    }
    for (ClusterAutoscalerSpecRLGpus item : items) {
        ClusterAutoscalerSpecRLGpusBuilder builder = new ClusterAutoscalerSpecRLGpusBuilder(item);
        _visitables.get("gpus").remove(builder);
        this.gpus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromGpus(Predicate<ClusterAutoscalerSpecRLGpusBuilder> predicate) {
    if (gpus == null) {
      return (A) this;
    }
    Iterator<ClusterAutoscalerSpecRLGpusBuilder> each = gpus.iterator();
    List visitables = _visitables.get("gpus");
    while (each.hasNext()) {
        ClusterAutoscalerSpecRLGpusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public GpusNested<A> setNewGpusLike(int index,ClusterAutoscalerSpecRLGpus item) {
    return new GpusNested(index, item);
  }
  
  public A setToGpus(int index,ClusterAutoscalerSpecRLGpus item) {
    if (this.gpus == null) {
      this.gpus = new ArrayList();
    }
    ClusterAutoscalerSpecRLGpusBuilder builder = new ClusterAutoscalerSpecRLGpusBuilder(item);
    if (index < 0 || index >= gpus.size()) {
        _visitables.get("gpus").add(builder);
        gpus.add(builder);
    } else {
        _visitables.get("gpus").add(builder);
        gpus.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cores == null)) {
        sb.append("cores:");
        sb.append(cores);
        sb.append(",");
    }
    if (!(gpus == null) && !(gpus.isEmpty())) {
        sb.append("gpus:");
        sb.append(gpus);
        sb.append(",");
    }
    if (!(maxNodesTotal == null)) {
        sb.append("maxNodesTotal:");
        sb.append(maxNodesTotal);
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
  
  public A withCores(ClusterAutoscalerSpecRLCores cores) {
    this._visitables.remove("cores");
    if (cores != null) {
        this.cores = new ClusterAutoscalerSpecRLCoresBuilder(cores);
        this._visitables.get("cores").add(this.cores);
    } else {
        this.cores = null;
        this._visitables.get("cores").remove(this.cores);
    }
    return (A) this;
  }
  
  public A withGpus(List<ClusterAutoscalerSpecRLGpus> gpus) {
    if (this.gpus != null) {
      this._visitables.get("gpus").clear();
    }
    if (gpus != null) {
        this.gpus = new ArrayList();
        for (ClusterAutoscalerSpecRLGpus item : gpus) {
          this.addToGpus(item);
        }
    } else {
      this.gpus = null;
    }
    return (A) this;
  }
  
  public A withGpus(ClusterAutoscalerSpecRLGpus... gpus) {
    if (this.gpus != null) {
        this.gpus.clear();
        _visitables.remove("gpus");
    }
    if (gpus != null) {
      for (ClusterAutoscalerSpecRLGpus item : gpus) {
        this.addToGpus(item);
      }
    }
    return (A) this;
  }
  
  public A withMaxNodesTotal(Integer maxNodesTotal) {
    this.maxNodesTotal = maxNodesTotal;
    return (A) this;
  }
  
  public A withMemory(ClusterAutoscalerSpecRLMemory memory) {
    this._visitables.remove("memory");
    if (memory != null) {
        this.memory = new ClusterAutoscalerSpecRLMemoryBuilder(memory);
        this._visitables.get("memory").add(this.memory);
    } else {
        this.memory = null;
        this._visitables.get("memory").remove(this.memory);
    }
    return (A) this;
  }
  
  public CoresNested<A> withNewCores() {
    return new CoresNested(null);
  }
  
  public A withNewCores(Integer max,Integer min) {
    return (A) this.withCores(new ClusterAutoscalerSpecRLCores(max, min));
  }
  
  public CoresNested<A> withNewCoresLike(ClusterAutoscalerSpecRLCores item) {
    return new CoresNested(item);
  }
  
  public MemoryNested<A> withNewMemory() {
    return new MemoryNested(null);
  }
  
  public A withNewMemory(Integer max,Integer min) {
    return (A) this.withMemory(new ClusterAutoscalerSpecRLMemory(max, min));
  }
  
  public MemoryNested<A> withNewMemoryLike(ClusterAutoscalerSpecRLMemory item) {
    return new MemoryNested(item);
  }
  public class CoresNested<N> extends ClusterAutoscalerSpecRLCoresFluent<CoresNested<N>> implements Nested<N>{
  
    ClusterAutoscalerSpecRLCoresBuilder builder;
  
    CoresNested(ClusterAutoscalerSpecRLCores item) {
      this.builder = new ClusterAutoscalerSpecRLCoresBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAutoscalerSpecResourceLimitsFluent.this.withCores(builder.build());
    }
    
    public N endCores() {
      return and();
    }
    
  }
  public class GpusNested<N> extends ClusterAutoscalerSpecRLGpusFluent<GpusNested<N>> implements Nested<N>{
  
    ClusterAutoscalerSpecRLGpusBuilder builder;
    int index;
  
    GpusNested(int index,ClusterAutoscalerSpecRLGpus item) {
      this.index = index;
      this.builder = new ClusterAutoscalerSpecRLGpusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAutoscalerSpecResourceLimitsFluent.this.setToGpus(index, builder.build());
    }
    
    public N endGpus() {
      return and();
    }
    
  }
  public class MemoryNested<N> extends ClusterAutoscalerSpecRLMemoryFluent<MemoryNested<N>> implements Nested<N>{
  
    ClusterAutoscalerSpecRLMemoryBuilder builder;
  
    MemoryNested(ClusterAutoscalerSpecRLMemory item) {
      this.builder = new ClusterAutoscalerSpecRLMemoryBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterAutoscalerSpecResourceLimitsFluent.this.withMemory(builder.build());
    }
    
    public N endMemory() {
      return and();
    }
    
  }
}