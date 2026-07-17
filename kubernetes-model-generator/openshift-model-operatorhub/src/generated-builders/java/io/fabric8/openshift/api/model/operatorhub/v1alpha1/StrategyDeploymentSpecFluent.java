package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.apps.DeploymentSpec;
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
public class StrategyDeploymentSpecFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.StrategyDeploymentSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> label;
  private String name;
  private DeploymentSpec spec;

  public StrategyDeploymentSpecFluent() {
  }
  
  public StrategyDeploymentSpecFluent(StrategyDeploymentSpec instance) {
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
  
  public A addToLabel(Map<String,String> map) {
    if (this.label == null && map != null) {
      this.label = new LinkedHashMap();
    }
    if (map != null) {
      this.label.putAll(map);
    }
    return (A) this;
  }
  
  public A addToLabel(String key,String value) {
    if (this.label == null && key != null && value != null) {
      this.label = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.label.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(StrategyDeploymentSpec instance) {
    instance = instance != null ? instance : new StrategyDeploymentSpec();
    if (instance != null) {
        this.withLabel(instance.getLabel());
        this.withName(instance.getName());
        this.withSpec(instance.getSpec());
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
    StrategyDeploymentSpecFluent that = (StrategyDeploymentSpecFluent) o;
    if (!(Objects.equals(label, that.label))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(spec, that.spec))) {
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
  
  public Map<String,String> getLabel() {
    return this.label;
  }
  
  public String getName() {
    return this.name;
  }
  
  public DeploymentSpec getSpec() {
    return this.spec;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabel() {
    return this.label != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public int hashCode() {
    return Objects.hash(label, name, spec, additionalProperties);
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
  
  public A removeFromLabel(String key) {
    if (this.label == null) {
      return (A) this;
    }
    if (key != null && this.label != null) {
      this.label.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromLabel(Map<String,String> map) {
    if (this.label == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.label != null) {
          this.label.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(label == null) && !(label.isEmpty())) {
        sb.append("label:");
        sb.append(label);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(spec == null)) {
        sb.append("spec:");
        sb.append(spec);
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
  
  public <K,V>A withLabel(Map<String,String> label) {
    if (label == null) {
      this.label = null;
    } else {
      this.label = new LinkedHashMap(label);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withSpec(DeploymentSpec spec) {
    this.spec = spec;
    return (A) this;
  }
  
}