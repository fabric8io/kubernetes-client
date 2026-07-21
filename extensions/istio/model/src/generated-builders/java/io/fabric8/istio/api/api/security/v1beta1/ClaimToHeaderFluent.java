package io.fabric8.istio.api.api.security.v1beta1;

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
public class ClaimToHeaderFluent<A extends io.fabric8.istio.api.api.security.v1beta1.ClaimToHeaderFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String claim;
  private String header;

  public ClaimToHeaderFluent() {
  }
  
  public ClaimToHeaderFluent(ClaimToHeader instance) {
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
  
  protected void copyInstance(ClaimToHeader instance) {
    instance = instance != null ? instance : new ClaimToHeader();
    if (instance != null) {
        this.withClaim(instance.getClaim());
        this.withHeader(instance.getHeader());
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
    ClaimToHeaderFluent that = (ClaimToHeaderFluent) o;
    if (!(Objects.equals(claim, that.claim))) {
      return false;
    }
    if (!(Objects.equals(header, that.header))) {
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
  
  public String getClaim() {
    return this.claim;
  }
  
  public String getHeader() {
    return this.header;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClaim() {
    return this.claim != null;
  }
  
  public boolean hasHeader() {
    return this.header != null;
  }
  
  public int hashCode() {
    return Objects.hash(claim, header, additionalProperties);
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
    if (!(claim == null)) {
        sb.append("claim:");
        sb.append(claim);
        sb.append(",");
    }
    if (!(header == null)) {
        sb.append("header:");
        sb.append(header);
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
  
  public A withClaim(String claim) {
    this.claim = claim;
    return (A) this;
  }
  
  public A withHeader(String header) {
    this.header = header;
    return (A) this;
  }
  
}