package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
public class HelmGlobalsFluent<A extends io.fabric8.kubernetes.api.model.kustomize.v1beta1.HelmGlobalsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String chartHome;
  private String configHome;

  public HelmGlobalsFluent() {
  }
  
  public HelmGlobalsFluent(HelmGlobals instance) {
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
  
  protected void copyInstance(HelmGlobals instance) {
    instance = instance != null ? instance : new HelmGlobals();
    if (instance != null) {
        this.withChartHome(instance.getChartHome());
        this.withConfigHome(instance.getConfigHome());
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
    HelmGlobalsFluent that = (HelmGlobalsFluent) o;
    if (!(Objects.equals(chartHome, that.chartHome))) {
      return false;
    }
    if (!(Objects.equals(configHome, that.configHome))) {
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
  
  public String getChartHome() {
    return this.chartHome;
  }
  
  public String getConfigHome() {
    return this.configHome;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChartHome() {
    return this.chartHome != null;
  }
  
  public boolean hasConfigHome() {
    return this.configHome != null;
  }
  
  public int hashCode() {
    return Objects.hash(chartHome, configHome, additionalProperties);
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
    if (!(chartHome == null)) {
        sb.append("chartHome:");
        sb.append(chartHome);
        sb.append(",");
    }
    if (!(configHome == null)) {
        sb.append("configHome:");
        sb.append(configHome);
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
  
  public A withChartHome(String chartHome) {
    this.chartHome = chartHome;
    return (A) this;
  }
  
  public A withConfigHome(String configHome) {
    this.configHome = configHome;
    return (A) this;
  }
  
}