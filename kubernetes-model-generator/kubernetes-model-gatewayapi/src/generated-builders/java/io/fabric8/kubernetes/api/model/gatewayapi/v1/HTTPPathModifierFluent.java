package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
public class HTTPPathModifierFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPPathModifierFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String replaceFullPath;
  private String replacePrefixMatch;
  private String type;

  public HTTPPathModifierFluent() {
  }
  
  public HTTPPathModifierFluent(HTTPPathModifier instance) {
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
  
  protected void copyInstance(HTTPPathModifier instance) {
    instance = instance != null ? instance : new HTTPPathModifier();
    if (instance != null) {
        this.withReplaceFullPath(instance.getReplaceFullPath());
        this.withReplacePrefixMatch(instance.getReplacePrefixMatch());
        this.withType(instance.getType());
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
    HTTPPathModifierFluent that = (HTTPPathModifierFluent) o;
    if (!(Objects.equals(replaceFullPath, that.replaceFullPath))) {
      return false;
    }
    if (!(Objects.equals(replacePrefixMatch, that.replacePrefixMatch))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getReplaceFullPath() {
    return this.replaceFullPath;
  }
  
  public String getReplacePrefixMatch() {
    return this.replacePrefixMatch;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasReplaceFullPath() {
    return this.replaceFullPath != null;
  }
  
  public boolean hasReplacePrefixMatch() {
    return this.replacePrefixMatch != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(replaceFullPath, replacePrefixMatch, type, additionalProperties);
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
    if (!(replaceFullPath == null)) {
        sb.append("replaceFullPath:");
        sb.append(replaceFullPath);
        sb.append(",");
    }
    if (!(replacePrefixMatch == null)) {
        sb.append("replacePrefixMatch:");
        sb.append(replacePrefixMatch);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withReplaceFullPath(String replaceFullPath) {
    this.replaceFullPath = replaceFullPath;
    return (A) this;
  }
  
  public A withReplacePrefixMatch(String replacePrefixMatch) {
    this.replacePrefixMatch = replacePrefixMatch;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
}