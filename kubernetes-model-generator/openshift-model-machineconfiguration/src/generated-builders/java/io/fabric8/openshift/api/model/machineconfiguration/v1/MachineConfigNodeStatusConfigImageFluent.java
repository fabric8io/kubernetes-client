package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class MachineConfigNodeStatusConfigImageFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineConfigNodeStatusConfigImageFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String currentImage;
  private String desiredImage;

  public MachineConfigNodeStatusConfigImageFluent() {
  }
  
  public MachineConfigNodeStatusConfigImageFluent(MachineConfigNodeStatusConfigImage instance) {
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
  
  protected void copyInstance(MachineConfigNodeStatusConfigImage instance) {
    instance = instance != null ? instance : new MachineConfigNodeStatusConfigImage();
    if (instance != null) {
        this.withCurrentImage(instance.getCurrentImage());
        this.withDesiredImage(instance.getDesiredImage());
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
    MachineConfigNodeStatusConfigImageFluent that = (MachineConfigNodeStatusConfigImageFluent) o;
    if (!(Objects.equals(currentImage, that.currentImage))) {
      return false;
    }
    if (!(Objects.equals(desiredImage, that.desiredImage))) {
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
  
  public String getCurrentImage() {
    return this.currentImage;
  }
  
  public String getDesiredImage() {
    return this.desiredImage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCurrentImage() {
    return this.currentImage != null;
  }
  
  public boolean hasDesiredImage() {
    return this.desiredImage != null;
  }
  
  public int hashCode() {
    return Objects.hash(currentImage, desiredImage, additionalProperties);
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
    if (!(currentImage == null)) {
        sb.append("currentImage:");
        sb.append(currentImage);
        sb.append(",");
    }
    if (!(desiredImage == null)) {
        sb.append("desiredImage:");
        sb.append(desiredImage);
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
  
  public A withCurrentImage(String currentImage) {
    this.currentImage = currentImage;
    return (A) this;
  }
  
  public A withDesiredImage(String desiredImage) {
    this.desiredImage = desiredImage;
    return (A) this;
  }
  
}