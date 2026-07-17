package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class IconFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.IconFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String base64data;
  private String mediatype;

  public IconFluent() {
  }
  
  public IconFluent(Icon instance) {
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
  
  protected void copyInstance(Icon instance) {
    instance = instance != null ? instance : new Icon();
    if (instance != null) {
        this.withBase64data(instance.getBase64data());
        this.withMediatype(instance.getMediatype());
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
    IconFluent that = (IconFluent) o;
    if (!(Objects.equals(base64data, that.base64data))) {
      return false;
    }
    if (!(Objects.equals(mediatype, that.mediatype))) {
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
  
  public String getBase64data() {
    return this.base64data;
  }
  
  public String getMediatype() {
    return this.mediatype;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBase64data() {
    return this.base64data != null;
  }
  
  public boolean hasMediatype() {
    return this.mediatype != null;
  }
  
  public int hashCode() {
    return Objects.hash(base64data, mediatype, additionalProperties);
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
    if (!(base64data == null)) {
        sb.append("base64data:");
        sb.append(base64data);
        sb.append(",");
    }
    if (!(mediatype == null)) {
        sb.append("mediatype:");
        sb.append(mediatype);
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
  
  public A withBase64data(String base64data) {
    this.base64data = base64data;
    return (A) this;
  }
  
  public A withMediatype(String mediatype) {
    this.mediatype = mediatype;
    return (A) this;
  }
  
}