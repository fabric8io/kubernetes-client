package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PoolStatusFluent<A extends io.fabric8.kubernetes.api.model.resource.v1alpha3.PoolStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer allocatedDevices;
  private Integer availableDevices;
  private String driver;
  private Long generation;
  private String nodeName;
  private String poolName;
  private Integer resourceSliceCount;
  private Integer totalDevices;
  private Integer unavailableDevices;
  private String validationError;

  public PoolStatusFluent() {
  }
  
  public PoolStatusFluent(PoolStatus instance) {
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
  
  protected void copyInstance(PoolStatus instance) {
    instance = instance != null ? instance : new PoolStatus();
    if (instance != null) {
        this.withAllocatedDevices(instance.getAllocatedDevices());
        this.withAvailableDevices(instance.getAvailableDevices());
        this.withDriver(instance.getDriver());
        this.withGeneration(instance.getGeneration());
        this.withNodeName(instance.getNodeName());
        this.withPoolName(instance.getPoolName());
        this.withResourceSliceCount(instance.getResourceSliceCount());
        this.withTotalDevices(instance.getTotalDevices());
        this.withUnavailableDevices(instance.getUnavailableDevices());
        this.withValidationError(instance.getValidationError());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    PoolStatusFluent that = (PoolStatusFluent) o;
    if (!(Objects.equals(allocatedDevices, that.allocatedDevices))) {
      return false;
    }
    if (!(Objects.equals(availableDevices, that.availableDevices))) {
      return false;
    }
    if (!(Objects.equals(driver, that.driver))) {
      return false;
    }
    if (!(Objects.equals(generation, that.generation))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
      return false;
    }
    if (!(Objects.equals(poolName, that.poolName))) {
      return false;
    }
    if (!(Objects.equals(resourceSliceCount, that.resourceSliceCount))) {
      return false;
    }
    if (!(Objects.equals(totalDevices, that.totalDevices))) {
      return false;
    }
    if (!(Objects.equals(unavailableDevices, that.unavailableDevices))) {
      return false;
    }
    if (!(Objects.equals(validationError, that.validationError))) {
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
  
  public Integer getAllocatedDevices() {
    return this.allocatedDevices;
  }
  
  public Integer getAvailableDevices() {
    return this.availableDevices;
  }
  
  public String getDriver() {
    return this.driver;
  }
  
  public Long getGeneration() {
    return this.generation;
  }
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public String getPoolName() {
    return this.poolName;
  }
  
  public Integer getResourceSliceCount() {
    return this.resourceSliceCount;
  }
  
  public Integer getTotalDevices() {
    return this.totalDevices;
  }
  
  public Integer getUnavailableDevices() {
    return this.unavailableDevices;
  }
  
  public String getValidationError() {
    return this.validationError;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatedDevices() {
    return this.allocatedDevices != null;
  }
  
  public boolean hasAvailableDevices() {
    return this.availableDevices != null;
  }
  
  public boolean hasDriver() {
    return this.driver != null;
  }
  
  public boolean hasGeneration() {
    return this.generation != null;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasPoolName() {
    return this.poolName != null;
  }
  
  public boolean hasResourceSliceCount() {
    return this.resourceSliceCount != null;
  }
  
  public boolean hasTotalDevices() {
    return this.totalDevices != null;
  }
  
  public boolean hasUnavailableDevices() {
    return this.unavailableDevices != null;
  }
  
  public boolean hasValidationError() {
    return this.validationError != null;
  }
  
  public int hashCode() {
    return Objects.hash(allocatedDevices, availableDevices, driver, generation, nodeName, poolName, resourceSliceCount, totalDevices, unavailableDevices, validationError, additionalProperties);
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
    if (!(allocatedDevices == null)) {
        sb.append("allocatedDevices:");
        sb.append(allocatedDevices);
        sb.append(",");
    }
    if (!(availableDevices == null)) {
        sb.append("availableDevices:");
        sb.append(availableDevices);
        sb.append(",");
    }
    if (!(driver == null)) {
        sb.append("driver:");
        sb.append(driver);
        sb.append(",");
    }
    if (!(generation == null)) {
        sb.append("generation:");
        sb.append(generation);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
        sb.append(",");
    }
    if (!(poolName == null)) {
        sb.append("poolName:");
        sb.append(poolName);
        sb.append(",");
    }
    if (!(resourceSliceCount == null)) {
        sb.append("resourceSliceCount:");
        sb.append(resourceSliceCount);
        sb.append(",");
    }
    if (!(totalDevices == null)) {
        sb.append("totalDevices:");
        sb.append(totalDevices);
        sb.append(",");
    }
    if (!(unavailableDevices == null)) {
        sb.append("unavailableDevices:");
        sb.append(unavailableDevices);
        sb.append(",");
    }
    if (!(validationError == null)) {
        sb.append("validationError:");
        sb.append(validationError);
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
  
  public A withAllocatedDevices(Integer allocatedDevices) {
    this.allocatedDevices = allocatedDevices;
    return (A) this;
  }
  
  public A withAvailableDevices(Integer availableDevices) {
    this.availableDevices = availableDevices;
    return (A) this;
  }
  
  public A withDriver(String driver) {
    this.driver = driver;
    return (A) this;
  }
  
  public A withGeneration(Long generation) {
    this.generation = generation;
    return (A) this;
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withPoolName(String poolName) {
    this.poolName = poolName;
    return (A) this;
  }
  
  public A withResourceSliceCount(Integer resourceSliceCount) {
    this.resourceSliceCount = resourceSliceCount;
    return (A) this;
  }
  
  public A withTotalDevices(Integer totalDevices) {
    this.totalDevices = totalDevices;
    return (A) this;
  }
  
  public A withUnavailableDevices(Integer unavailableDevices) {
    this.unavailableDevices = unavailableDevices;
    return (A) this;
  }
  
  public A withValidationError(String validationError) {
    this.validationError = validationError;
    return (A) this;
  }
  
}