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
public class MachineOSContainerfileFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineOSContainerfileFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String containerfileArch;
  private String content;

  public MachineOSContainerfileFluent() {
  }
  
  public MachineOSContainerfileFluent(MachineOSContainerfile instance) {
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
  
  protected void copyInstance(MachineOSContainerfile instance) {
    instance = instance != null ? instance : new MachineOSContainerfile();
    if (instance != null) {
        this.withContainerfileArch(instance.getContainerfileArch());
        this.withContent(instance.getContent());
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
    MachineOSContainerfileFluent that = (MachineOSContainerfileFluent) o;
    if (!(Objects.equals(containerfileArch, that.containerfileArch))) {
      return false;
    }
    if (!(Objects.equals(content, that.content))) {
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
  
  public String getContainerfileArch() {
    return this.containerfileArch;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainerfileArch() {
    return this.containerfileArch != null;
  }
  
  public boolean hasContent() {
    return this.content != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerfileArch, content, additionalProperties);
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
    if (!(containerfileArch == null)) {
        sb.append("containerfileArch:");
        sb.append(containerfileArch);
        sb.append(",");
    }
    if (!(content == null)) {
        sb.append("content:");
        sb.append(content);
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
  
  public A withContainerfileArch(String containerfileArch) {
    this.containerfileArch = containerfileArch;
    return (A) this;
  }
  
  public A withContent(String content) {
    this.content = content;
    return (A) this;
  }
  
}