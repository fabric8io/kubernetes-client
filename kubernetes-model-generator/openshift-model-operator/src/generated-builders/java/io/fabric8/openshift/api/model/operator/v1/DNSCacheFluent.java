package io.fabric8.openshift.api.model.operator.v1;

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
public class DNSCacheFluent<A extends io.fabric8.openshift.api.model.operator.v1.DNSCacheFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String negativeTTL;
  private String positiveTTL;

  public DNSCacheFluent() {
  }
  
  public DNSCacheFluent(DNSCache instance) {
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
  
  protected void copyInstance(DNSCache instance) {
    instance = instance != null ? instance : new DNSCache();
    if (instance != null) {
        this.withNegativeTTL(instance.getNegativeTTL());
        this.withPositiveTTL(instance.getPositiveTTL());
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
    DNSCacheFluent that = (DNSCacheFluent) o;
    if (!(Objects.equals(negativeTTL, that.negativeTTL))) {
      return false;
    }
    if (!(Objects.equals(positiveTTL, that.positiveTTL))) {
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
  
  public String getNegativeTTL() {
    return this.negativeTTL;
  }
  
  public String getPositiveTTL() {
    return this.positiveTTL;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasNegativeTTL() {
    return this.negativeTTL != null;
  }
  
  public boolean hasPositiveTTL() {
    return this.positiveTTL != null;
  }
  
  public int hashCode() {
    return Objects.hash(negativeTTL, positiveTTL, additionalProperties);
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
    if (!(negativeTTL == null)) {
        sb.append("negativeTTL:");
        sb.append(negativeTTL);
        sb.append(",");
    }
    if (!(positiveTTL == null)) {
        sb.append("positiveTTL:");
        sb.append(positiveTTL);
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
  
  public A withNegativeTTL(String negativeTTL) {
    this.negativeTTL = negativeTTL;
    return (A) this;
  }
  
  public A withPositiveTTL(String positiveTTL) {
    this.positiveTTL = positiveTTL;
    return (A) this;
  }
  
}