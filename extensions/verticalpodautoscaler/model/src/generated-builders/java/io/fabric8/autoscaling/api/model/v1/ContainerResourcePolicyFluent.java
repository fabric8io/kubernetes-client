package io.fabric8.autoscaling.api.model.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Quantity;
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
public class ContainerResourcePolicyFluent<A extends io.fabric8.autoscaling.api.model.v1.ContainerResourcePolicyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerName;
  private List<String> controlledResources = new ArrayList<String>();
  private String controlledValues;
  private Map<String,Quantity> maxAllowed;
  private Long memoryAggregationIntervalCount;
  private Integer memoryAggregationIntervalSeconds;
  private Map<String,Quantity> minAllowed;
  private String mode;
  private Quantity oomBumpUpRatio;
  private Quantity oomMinBumpUp;
  private StartupBoostBuilder startupBoost;

  public ContainerResourcePolicyFluent() {
  }
  
  public ContainerResourcePolicyFluent(ContainerResourcePolicy instance) {
    this.copyInstance(instance);
  }

  public A addAllToControlledResources(Collection<String> items) {
    if (this.controlledResources == null) {
      this.controlledResources = new ArrayList();
    }
    for (String item : items) {
      this.controlledResources.add(item);
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
  
  public A addToControlledResources(String... items) {
    if (this.controlledResources == null) {
      this.controlledResources = new ArrayList();
    }
    for (String item : items) {
      this.controlledResources.add(item);
    }
    return (A) this;
  }
  
  public A addToControlledResources(int index,String item) {
    if (this.controlledResources == null) {
      this.controlledResources = new ArrayList();
    }
    this.controlledResources.add(index, item);
    return (A) this;
  }
  
  public A addToMaxAllowed(Map<String,Quantity> map) {
    if (this.maxAllowed == null && map != null) {
      this.maxAllowed = new LinkedHashMap();
    }
    if (map != null) {
      this.maxAllowed.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMaxAllowed(String key,Quantity value) {
    if (this.maxAllowed == null && key != null && value != null) {
      this.maxAllowed = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.maxAllowed.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMinAllowed(Map<String,Quantity> map) {
    if (this.minAllowed == null && map != null) {
      this.minAllowed = new LinkedHashMap();
    }
    if (map != null) {
      this.minAllowed.putAll(map);
    }
    return (A) this;
  }
  
  public A addToMinAllowed(String key,Quantity value) {
    if (this.minAllowed == null && key != null && value != null) {
      this.minAllowed = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.minAllowed.put(key, value);
    }
    return (A) this;
  }
  
  public StartupBoost buildStartupBoost() {
    return this.startupBoost != null ? this.startupBoost.build() : null;
  }
  
  protected void copyInstance(ContainerResourcePolicy instance) {
    instance = instance != null ? instance : new ContainerResourcePolicy();
    if (instance != null) {
        this.withContainerName(instance.getContainerName());
        this.withControlledResources(instance.getControlledResources());
        this.withControlledValues(instance.getControlledValues());
        this.withMaxAllowed(instance.getMaxAllowed());
        this.withMemoryAggregationIntervalCount(instance.getMemoryAggregationIntervalCount());
        this.withMemoryAggregationIntervalSeconds(instance.getMemoryAggregationIntervalSeconds());
        this.withMinAllowed(instance.getMinAllowed());
        this.withMode(instance.getMode());
        this.withOomBumpUpRatio(instance.getOomBumpUpRatio());
        this.withOomMinBumpUp(instance.getOomMinBumpUp());
        this.withStartupBoost(instance.getStartupBoost());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StartupBoostNested<A> editOrNewStartupBoost() {
    return this.withNewStartupBoostLike(Optional.ofNullable(this.buildStartupBoost()).orElse(new StartupBoostBuilder().build()));
  }
  
  public StartupBoostNested<A> editOrNewStartupBoostLike(StartupBoost item) {
    return this.withNewStartupBoostLike(Optional.ofNullable(this.buildStartupBoost()).orElse(item));
  }
  
  public StartupBoostNested<A> editStartupBoost() {
    return this.withNewStartupBoostLike(Optional.ofNullable(this.buildStartupBoost()).orElse(null));
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
    ContainerResourcePolicyFluent that = (ContainerResourcePolicyFluent) o;
    if (!(Objects.equals(containerName, that.containerName))) {
      return false;
    }
    if (!(Objects.equals(controlledResources, that.controlledResources))) {
      return false;
    }
    if (!(Objects.equals(controlledValues, that.controlledValues))) {
      return false;
    }
    if (!(Objects.equals(maxAllowed, that.maxAllowed))) {
      return false;
    }
    if (!(Objects.equals(memoryAggregationIntervalCount, that.memoryAggregationIntervalCount))) {
      return false;
    }
    if (!(Objects.equals(memoryAggregationIntervalSeconds, that.memoryAggregationIntervalSeconds))) {
      return false;
    }
    if (!(Objects.equals(minAllowed, that.minAllowed))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(oomBumpUpRatio, that.oomBumpUpRatio))) {
      return false;
    }
    if (!(Objects.equals(oomMinBumpUp, that.oomMinBumpUp))) {
      return false;
    }
    if (!(Objects.equals(startupBoost, that.startupBoost))) {
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
  
  public String getContainerName() {
    return this.containerName;
  }
  
  public String getControlledResource(int index) {
    return this.controlledResources.get(index);
  }
  
  public List<String> getControlledResources() {
    return this.controlledResources;
  }
  
  public String getControlledValues() {
    return this.controlledValues;
  }
  
  public String getFirstControlledResource() {
    return this.controlledResources.get(0);
  }
  
  public String getLastControlledResource() {
    return this.controlledResources.get(controlledResources.size() - 1);
  }
  
  public String getMatchingControlledResource(Predicate<String> predicate) {
      for (String item : controlledResources) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Map<String,Quantity> getMaxAllowed() {
    return this.maxAllowed;
  }
  
  public Long getMemoryAggregationIntervalCount() {
    return this.memoryAggregationIntervalCount;
  }
  
  public Integer getMemoryAggregationIntervalSeconds() {
    return this.memoryAggregationIntervalSeconds;
  }
  
  public Map<String,Quantity> getMinAllowed() {
    return this.minAllowed;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public Quantity getOomBumpUpRatio() {
    return this.oomBumpUpRatio;
  }
  
  public Quantity getOomMinBumpUp() {
    return this.oomMinBumpUp;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerName() {
    return this.containerName != null;
  }
  
  public boolean hasControlledResources() {
    return this.controlledResources != null && !(this.controlledResources.isEmpty());
  }
  
  public boolean hasControlledValues() {
    return this.controlledValues != null;
  }
  
  public boolean hasMatchingControlledResource(Predicate<String> predicate) {
      for (String item : controlledResources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMaxAllowed() {
    return this.maxAllowed != null;
  }
  
  public boolean hasMemoryAggregationIntervalCount() {
    return this.memoryAggregationIntervalCount != null;
  }
  
  public boolean hasMemoryAggregationIntervalSeconds() {
    return this.memoryAggregationIntervalSeconds != null;
  }
  
  public boolean hasMinAllowed() {
    return this.minAllowed != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasOomBumpUpRatio() {
    return this.oomBumpUpRatio != null;
  }
  
  public boolean hasOomMinBumpUp() {
    return this.oomMinBumpUp != null;
  }
  
  public boolean hasStartupBoost() {
    return this.startupBoost != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerName, controlledResources, controlledValues, maxAllowed, memoryAggregationIntervalCount, memoryAggregationIntervalSeconds, minAllowed, mode, oomBumpUpRatio, oomMinBumpUp, startupBoost, additionalProperties);
  }
  
  public A removeAllFromControlledResources(Collection<String> items) {
    if (this.controlledResources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.controlledResources.remove(item);
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
  
  public A removeFromControlledResources(String... items) {
    if (this.controlledResources == null) {
      return (A) this;
    }
    for (String item : items) {
      this.controlledResources.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMaxAllowed(String key) {
    if (this.maxAllowed == null) {
      return (A) this;
    }
    if (key != null && this.maxAllowed != null) {
      this.maxAllowed.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMaxAllowed(Map<String,Quantity> map) {
    if (this.maxAllowed == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.maxAllowed != null) {
          this.maxAllowed.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMinAllowed(String key) {
    if (this.minAllowed == null) {
      return (A) this;
    }
    if (key != null && this.minAllowed != null) {
      this.minAllowed.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromMinAllowed(Map<String,Quantity> map) {
    if (this.minAllowed == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.minAllowed != null) {
          this.minAllowed.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToControlledResources(int index,String item) {
    if (this.controlledResources == null) {
      this.controlledResources = new ArrayList();
    }
    this.controlledResources.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(containerName == null)) {
        sb.append("containerName:");
        sb.append(containerName);
        sb.append(",");
    }
    if (!(controlledResources == null) && !(controlledResources.isEmpty())) {
        sb.append("controlledResources:");
        sb.append(controlledResources);
        sb.append(",");
    }
    if (!(controlledValues == null)) {
        sb.append("controlledValues:");
        sb.append(controlledValues);
        sb.append(",");
    }
    if (!(maxAllowed == null) && !(maxAllowed.isEmpty())) {
        sb.append("maxAllowed:");
        sb.append(maxAllowed);
        sb.append(",");
    }
    if (!(memoryAggregationIntervalCount == null)) {
        sb.append("memoryAggregationIntervalCount:");
        sb.append(memoryAggregationIntervalCount);
        sb.append(",");
    }
    if (!(memoryAggregationIntervalSeconds == null)) {
        sb.append("memoryAggregationIntervalSeconds:");
        sb.append(memoryAggregationIntervalSeconds);
        sb.append(",");
    }
    if (!(minAllowed == null) && !(minAllowed.isEmpty())) {
        sb.append("minAllowed:");
        sb.append(minAllowed);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(oomBumpUpRatio == null)) {
        sb.append("oomBumpUpRatio:");
        sb.append(oomBumpUpRatio);
        sb.append(",");
    }
    if (!(oomMinBumpUp == null)) {
        sb.append("oomMinBumpUp:");
        sb.append(oomMinBumpUp);
        sb.append(",");
    }
    if (!(startupBoost == null)) {
        sb.append("startupBoost:");
        sb.append(startupBoost);
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
  
  public A withContainerName(String containerName) {
    this.containerName = containerName;
    return (A) this;
  }
  
  public A withControlledResources(List<String> controlledResources) {
    if (controlledResources != null) {
        this.controlledResources = new ArrayList();
        for (String item : controlledResources) {
          this.addToControlledResources(item);
        }
    } else {
      this.controlledResources = null;
    }
    return (A) this;
  }
  
  public A withControlledResources(String... controlledResources) {
    if (this.controlledResources != null) {
        this.controlledResources.clear();
        _visitables.remove("controlledResources");
    }
    if (controlledResources != null) {
      for (String item : controlledResources) {
        this.addToControlledResources(item);
      }
    }
    return (A) this;
  }
  
  public A withControlledValues(String controlledValues) {
    this.controlledValues = controlledValues;
    return (A) this;
  }
  
  public <K,V>A withMaxAllowed(Map<String,Quantity> maxAllowed) {
    if (maxAllowed == null) {
      this.maxAllowed = null;
    } else {
      this.maxAllowed = new LinkedHashMap(maxAllowed);
    }
    return (A) this;
  }
  
  public A withMemoryAggregationIntervalCount(Long memoryAggregationIntervalCount) {
    this.memoryAggregationIntervalCount = memoryAggregationIntervalCount;
    return (A) this;
  }
  
  public A withMemoryAggregationIntervalSeconds(Integer memoryAggregationIntervalSeconds) {
    this.memoryAggregationIntervalSeconds = memoryAggregationIntervalSeconds;
    return (A) this;
  }
  
  public <K,V>A withMinAllowed(Map<String,Quantity> minAllowed) {
    if (minAllowed == null) {
      this.minAllowed = null;
    } else {
      this.minAllowed = new LinkedHashMap(minAllowed);
    }
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withNewOomBumpUpRatio(String amount) {
    return (A) this.withOomBumpUpRatio(new Quantity(amount));
  }
  
  public A withNewOomBumpUpRatio(String amount,String format) {
    return (A) this.withOomBumpUpRatio(new Quantity(amount, format));
  }
  
  public A withNewOomMinBumpUp(String amount) {
    return (A) this.withOomMinBumpUp(new Quantity(amount));
  }
  
  public A withNewOomMinBumpUp(String amount,String format) {
    return (A) this.withOomMinBumpUp(new Quantity(amount, format));
  }
  
  public StartupBoostNested<A> withNewStartupBoost() {
    return new StartupBoostNested(null);
  }
  
  public StartupBoostNested<A> withNewStartupBoostLike(StartupBoost item) {
    return new StartupBoostNested(item);
  }
  
  public A withOomBumpUpRatio(Quantity oomBumpUpRatio) {
    this.oomBumpUpRatio = oomBumpUpRatio;
    return (A) this;
  }
  
  public A withOomMinBumpUp(Quantity oomMinBumpUp) {
    this.oomMinBumpUp = oomMinBumpUp;
    return (A) this;
  }
  
  public A withStartupBoost(StartupBoost startupBoost) {
    this._visitables.remove("startupBoost");
    if (startupBoost != null) {
        this.startupBoost = new StartupBoostBuilder(startupBoost);
        this._visitables.get("startupBoost").add(this.startupBoost);
    } else {
        this.startupBoost = null;
        this._visitables.get("startupBoost").remove(this.startupBoost);
    }
    return (A) this;
  }
  public class StartupBoostNested<N> extends StartupBoostFluent<StartupBoostNested<N>> implements Nested<N>{
  
    StartupBoostBuilder builder;
  
    StartupBoostNested(StartupBoost item) {
      this.builder = new StartupBoostBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerResourcePolicyFluent.this.withStartupBoost(builder.build());
    }
    
    public N endStartupBoost() {
      return and();
    }
    
  }
}