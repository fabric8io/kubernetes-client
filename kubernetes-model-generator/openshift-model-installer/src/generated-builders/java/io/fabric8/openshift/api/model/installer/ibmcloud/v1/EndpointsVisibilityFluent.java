package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

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
public class EndpointsVisibilityFluent<A extends io.fabric8.openshift.api.model.installer.ibmcloud.v1.EndpointsVisibilityFluent<A>> extends BaseFluent<A>{

  private Map<String,String> _private;
  private Map<String,String> _public;
  private Map<String,Object> additionalProperties;

  public EndpointsVisibilityFluent() {
  }
  
  public EndpointsVisibilityFluent(EndpointsVisibility instance) {
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
  
  public A addToPrivate(Map<String,String> map) {
    if (this._private == null && map != null) {
      this._private = new LinkedHashMap();
    }
    if (map != null) {
      this._private.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPrivate(String key,String value) {
    if (this._private == null && key != null && value != null) {
      this._private = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this._private.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPublic(Map<String,String> map) {
    if (this._public == null && map != null) {
      this._public = new LinkedHashMap();
    }
    if (map != null) {
      this._public.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPublic(String key,String value) {
    if (this._public == null && key != null && value != null) {
      this._public = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this._public.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(EndpointsVisibility instance) {
    instance = instance != null ? instance : new EndpointsVisibility();
    if (instance != null) {
        this.withPrivate(instance.getPrivate());
        this.withPublic(instance.getPublic());
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
    EndpointsVisibilityFluent that = (EndpointsVisibilityFluent) o;
    if (!(Objects.equals(_private, that._private))) {
      return false;
    }
    if (!(Objects.equals(_public, that._public))) {
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
  
  public Map<String,String> getPrivate() {
    return this._private;
  }
  
  public Map<String,String> getPublic() {
    return this._public;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPrivate() {
    return this._private != null;
  }
  
  public boolean hasPublic() {
    return this._public != null;
  }
  
  public int hashCode() {
    return Objects.hash(_private, _public, additionalProperties);
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
  
  public A removeFromPrivate(String key) {
    if (this._private == null) {
      return (A) this;
    }
    if (key != null && this._private != null) {
      this._private.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPrivate(Map<String,String> map) {
    if (this._private == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this._private != null) {
          this._private.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPublic(String key) {
    if (this._public == null) {
      return (A) this;
    }
    if (key != null && this._public != null) {
      this._public.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPublic(Map<String,String> map) {
    if (this._public == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this._public != null) {
          this._public.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(_private == null) && !(_private.isEmpty())) {
        sb.append("_private:");
        sb.append(_private);
        sb.append(",");
    }
    if (!(_public == null) && !(_public.isEmpty())) {
        sb.append("_public:");
        sb.append(_public);
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
  
  public <K,V>A withPrivate(Map<String,String> _private) {
    if (_private == null) {
      this._private = null;
    } else {
      this._private = new LinkedHashMap(_private);
    }
    return (A) this;
  }
  
  public <K,V>A withPublic(Map<String,String> _public) {
    if (_public == null) {
      this._public = null;
    } else {
      this._public = new LinkedHashMap(_public);
    }
    return (A) this;
  }
  
}