package io.fabric8.openshift.api.model.installer.v1;

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
public class OperatorPublishingStrategyFluent<A extends io.fabric8.openshift.api.model.installer.v1.OperatorPublishingStrategyFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiserver;
  private String ingress;

  public OperatorPublishingStrategyFluent() {
  }
  
  public OperatorPublishingStrategyFluent(OperatorPublishingStrategy instance) {
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
  
  protected void copyInstance(OperatorPublishingStrategy instance) {
    instance = instance != null ? instance : new OperatorPublishingStrategy();
    if (instance != null) {
        this.withApiserver(instance.getApiserver());
        this.withIngress(instance.getIngress());
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
    OperatorPublishingStrategyFluent that = (OperatorPublishingStrategyFluent) o;
    if (!(Objects.equals(apiserver, that.apiserver))) {
      return false;
    }
    if (!(Objects.equals(ingress, that.ingress))) {
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
  
  public String getApiserver() {
    return this.apiserver;
  }
  
  public String getIngress() {
    return this.ingress;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiserver() {
    return this.apiserver != null;
  }
  
  public boolean hasIngress() {
    return this.ingress != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiserver, ingress, additionalProperties);
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
    if (!(apiserver == null)) {
        sb.append("apiserver:");
        sb.append(apiserver);
        sb.append(",");
    }
    if (!(ingress == null)) {
        sb.append("ingress:");
        sb.append(ingress);
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
  
  public A withApiserver(String apiserver) {
    this.apiserver = apiserver;
    return (A) this;
  }
  
  public A withIngress(String ingress) {
    this.ingress = ingress;
    return (A) this;
  }
  
}