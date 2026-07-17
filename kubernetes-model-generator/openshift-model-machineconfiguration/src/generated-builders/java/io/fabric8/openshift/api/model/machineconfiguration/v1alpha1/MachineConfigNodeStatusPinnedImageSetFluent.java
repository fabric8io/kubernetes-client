package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Integer;
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
public class MachineConfigNodeStatusPinnedImageSetFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1alpha1.MachineConfigNodeStatusPinnedImageSetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer currentGeneration;
  private Integer desiredGeneration;
  private Integer lastFailedGeneration;
  private String lastFailedGenerationError;
  private String name;

  public MachineConfigNodeStatusPinnedImageSetFluent() {
  }
  
  public MachineConfigNodeStatusPinnedImageSetFluent(MachineConfigNodeStatusPinnedImageSet instance) {
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
  
  protected void copyInstance(MachineConfigNodeStatusPinnedImageSet instance) {
    instance = instance != null ? instance : new MachineConfigNodeStatusPinnedImageSet();
    if (instance != null) {
        this.withCurrentGeneration(instance.getCurrentGeneration());
        this.withDesiredGeneration(instance.getDesiredGeneration());
        this.withLastFailedGeneration(instance.getLastFailedGeneration());
        this.withLastFailedGenerationError(instance.getLastFailedGenerationError());
        this.withName(instance.getName());
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
    MachineConfigNodeStatusPinnedImageSetFluent that = (MachineConfigNodeStatusPinnedImageSetFluent) o;
    if (!(Objects.equals(currentGeneration, that.currentGeneration))) {
      return false;
    }
    if (!(Objects.equals(desiredGeneration, that.desiredGeneration))) {
      return false;
    }
    if (!(Objects.equals(lastFailedGeneration, that.lastFailedGeneration))) {
      return false;
    }
    if (!(Objects.equals(lastFailedGenerationError, that.lastFailedGenerationError))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
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
  
  public Integer getCurrentGeneration() {
    return this.currentGeneration;
  }
  
  public Integer getDesiredGeneration() {
    return this.desiredGeneration;
  }
  
  public Integer getLastFailedGeneration() {
    return this.lastFailedGeneration;
  }
  
  public String getLastFailedGenerationError() {
    return this.lastFailedGenerationError;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentGeneration() {
    return this.currentGeneration != null;
  }
  
  public boolean hasDesiredGeneration() {
    return this.desiredGeneration != null;
  }
  
  public boolean hasLastFailedGeneration() {
    return this.lastFailedGeneration != null;
  }
  
  public boolean hasLastFailedGenerationError() {
    return this.lastFailedGenerationError != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentGeneration, desiredGeneration, lastFailedGeneration, lastFailedGenerationError, name, additionalProperties);
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
    if (!(currentGeneration == null)) {
        sb.append("currentGeneration:");
        sb.append(currentGeneration);
        sb.append(",");
    }
    if (!(desiredGeneration == null)) {
        sb.append("desiredGeneration:");
        sb.append(desiredGeneration);
        sb.append(",");
    }
    if (!(lastFailedGeneration == null)) {
        sb.append("lastFailedGeneration:");
        sb.append(lastFailedGeneration);
        sb.append(",");
    }
    if (!(lastFailedGenerationError == null)) {
        sb.append("lastFailedGenerationError:");
        sb.append(lastFailedGenerationError);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
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
  
  public A withCurrentGeneration(Integer currentGeneration) {
    this.currentGeneration = currentGeneration;
    return (A) this;
  }
  
  public A withDesiredGeneration(Integer desiredGeneration) {
    this.desiredGeneration = desiredGeneration;
    return (A) this;
  }
  
  public A withLastFailedGeneration(Integer lastFailedGeneration) {
    this.lastFailedGeneration = lastFailedGeneration;
    return (A) this;
  }
  
  public A withLastFailedGenerationError(String lastFailedGenerationError) {
    this.lastFailedGenerationError = lastFailedGenerationError;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
}