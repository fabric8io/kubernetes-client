package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class FlockerVolumeSourceFluent<A extends io.fabric8.kubernetes.api.model.FlockerVolumeSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String datasetName;
  private String datasetUUID;

  public FlockerVolumeSourceFluent() {
  }
  
  public FlockerVolumeSourceFluent(FlockerVolumeSource instance) {
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
  
  protected void copyInstance(FlockerVolumeSource instance) {
    instance = instance != null ? instance : new FlockerVolumeSource();
    if (instance != null) {
        this.withDatasetName(instance.getDatasetName());
        this.withDatasetUUID(instance.getDatasetUUID());
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
    FlockerVolumeSourceFluent that = (FlockerVolumeSourceFluent) o;
    if (!(Objects.equals(datasetName, that.datasetName))) {
      return false;
    }
    if (!(Objects.equals(datasetUUID, that.datasetUUID))) {
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
  
  public String getDatasetName() {
    return this.datasetName;
  }
  
  public String getDatasetUUID() {
    return this.datasetUUID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDatasetName() {
    return this.datasetName != null;
  }
  
  public boolean hasDatasetUUID() {
    return this.datasetUUID != null;
  }
  
  public int hashCode() {
    return Objects.hash(datasetName, datasetUUID, additionalProperties);
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
    if (!(datasetName == null)) {
        sb.append("datasetName:");
        sb.append(datasetName);
        sb.append(",");
    }
    if (!(datasetUUID == null)) {
        sb.append("datasetUUID:");
        sb.append(datasetUUID);
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
  
  public A withDatasetName(String datasetName) {
    this.datasetName = datasetName;
    return (A) this;
  }
  
  public A withDatasetUUID(String datasetUUID) {
    this.datasetUUID = datasetUUID;
    return (A) this;
  }
  
}