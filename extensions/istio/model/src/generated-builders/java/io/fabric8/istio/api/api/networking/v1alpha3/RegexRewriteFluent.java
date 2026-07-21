package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class RegexRewriteFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.RegexRewriteFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String match;
  private String rewrite;

  public RegexRewriteFluent() {
  }
  
  public RegexRewriteFluent(RegexRewrite instance) {
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
  
  protected void copyInstance(RegexRewrite instance) {
    instance = instance != null ? instance : new RegexRewrite();
    if (instance != null) {
        this.withMatch(instance.getMatch());
        this.withRewrite(instance.getRewrite());
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
    RegexRewriteFluent that = (RegexRewriteFluent) o;
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(rewrite, that.rewrite))) {
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
  
  public String getMatch() {
    return this.match;
  }
  
  public String getRewrite() {
    return this.rewrite;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatch() {
    return this.match != null;
  }
  
  public boolean hasRewrite() {
    return this.rewrite != null;
  }
  
  public int hashCode() {
    return Objects.hash(match, rewrite, additionalProperties);
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
    if (!(match == null)) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(rewrite == null)) {
        sb.append("rewrite:");
        sb.append(rewrite);
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
  
  public A withMatch(String match) {
    this.match = match;
    return (A) this;
  }
  
  public A withRewrite(String rewrite) {
    this.rewrite = rewrite;
    return (A) this;
  }
  
}