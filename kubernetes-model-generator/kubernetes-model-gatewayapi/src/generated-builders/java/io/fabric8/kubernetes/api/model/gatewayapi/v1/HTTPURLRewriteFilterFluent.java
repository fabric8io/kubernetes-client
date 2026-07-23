package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPURLRewriteFilterFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPURLRewriteFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hostname;
  private HTTPPathModifierBuilder path;

  public HTTPURLRewriteFilterFluent() {
  }
  
  public HTTPURLRewriteFilterFluent(HTTPURLRewriteFilter instance) {
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
  
  public HTTPPathModifier buildPath() {
    return this.path != null ? this.path.build() : null;
  }
  
  protected void copyInstance(HTTPURLRewriteFilter instance) {
    instance = instance != null ? instance : new HTTPURLRewriteFilter();
    if (instance != null) {
        this.withHostname(instance.getHostname());
        this.withPath(instance.getPath());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PathNested<A> editOrNewPath() {
    return this.withNewPathLike(Optional.ofNullable(this.buildPath()).orElse(new HTTPPathModifierBuilder().build()));
  }
  
  public PathNested<A> editOrNewPathLike(HTTPPathModifier item) {
    return this.withNewPathLike(Optional.ofNullable(this.buildPath()).orElse(item));
  }
  
  public PathNested<A> editPath() {
    return this.withNewPathLike(Optional.ofNullable(this.buildPath()).orElse(null));
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
    HTTPURLRewriteFilterFluent that = (HTTPURLRewriteFilterFluent) o;
    if (!(Objects.equals(hostname, that.hostname))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
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
  
  public String getHostname() {
    return this.hostname;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostname() {
    return this.hostname != null;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostname, path, additionalProperties);
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
    if (!(hostname == null)) {
        sb.append("hostname:");
        sb.append(hostname);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
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
  
  public A withHostname(String hostname) {
    this.hostname = hostname;
    return (A) this;
  }
  
  public PathNested<A> withNewPath() {
    return new PathNested(null);
  }
  
  public A withNewPath(String replaceFullPath,String replacePrefixMatch,String type) {
    return (A) this.withPath(new HTTPPathModifier(replaceFullPath, replacePrefixMatch, type));
  }
  
  public PathNested<A> withNewPathLike(HTTPPathModifier item) {
    return new PathNested(item);
  }
  
  public A withPath(HTTPPathModifier path) {
    this._visitables.remove("path");
    if (path != null) {
        this.path = new HTTPPathModifierBuilder(path);
        this._visitables.get("path").add(this.path);
    } else {
        this.path = null;
        this._visitables.get("path").remove(this.path);
    }
    return (A) this;
  }
  public class PathNested<N> extends HTTPPathModifierFluent<PathNested<N>> implements Nested<N>{
  
    HTTPPathModifierBuilder builder;
  
    PathNested(HTTPPathModifier item) {
      this.builder = new HTTPPathModifierBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPURLRewriteFilterFluent.this.withPath(builder.build());
    }
    
    public N endPath() {
      return and();
    }
    
  }
}