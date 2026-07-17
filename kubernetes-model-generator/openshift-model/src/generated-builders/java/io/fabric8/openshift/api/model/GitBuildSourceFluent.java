package io.fabric8.openshift.api.model;

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
public class GitBuildSourceFluent<A extends io.fabric8.openshift.api.model.GitBuildSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String httpProxy;
  private String httpsProxy;
  private String noProxy;
  private String ref;
  private String uri;

  public GitBuildSourceFluent() {
  }
  
  public GitBuildSourceFluent(GitBuildSource instance) {
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
  
  protected void copyInstance(GitBuildSource instance) {
    instance = instance != null ? instance : new GitBuildSource();
    if (instance != null) {
        this.withHttpProxy(instance.getHttpProxy());
        this.withHttpsProxy(instance.getHttpsProxy());
        this.withNoProxy(instance.getNoProxy());
        this.withRef(instance.getRef());
        this.withUri(instance.getUri());
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
    GitBuildSourceFluent that = (GitBuildSourceFluent) o;
    if (!(Objects.equals(httpProxy, that.httpProxy))) {
      return false;
    }
    if (!(Objects.equals(httpsProxy, that.httpsProxy))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(ref, that.ref))) {
      return false;
    }
    if (!(Objects.equals(uri, that.uri))) {
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
  
  public String getHttpProxy() {
    return this.httpProxy;
  }
  
  public String getHttpsProxy() {
    return this.httpsProxy;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public String getRef() {
    return this.ref;
  }
  
  public String getUri() {
    return this.uri;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHttpProxy() {
    return this.httpProxy != null;
  }
  
  public boolean hasHttpsProxy() {
    return this.httpsProxy != null;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasRef() {
    return this.ref != null;
  }
  
  public boolean hasUri() {
    return this.uri != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpProxy, httpsProxy, noProxy, ref, uri, additionalProperties);
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
    if (!(httpProxy == null)) {
        sb.append("httpProxy:");
        sb.append(httpProxy);
        sb.append(",");
    }
    if (!(httpsProxy == null)) {
        sb.append("httpsProxy:");
        sb.append(httpsProxy);
        sb.append(",");
    }
    if (!(noProxy == null)) {
        sb.append("noProxy:");
        sb.append(noProxy);
        sb.append(",");
    }
    if (!(ref == null)) {
        sb.append("ref:");
        sb.append(ref);
        sb.append(",");
    }
    if (!(uri == null)) {
        sb.append("uri:");
        sb.append(uri);
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
  
  public A withHttpProxy(String httpProxy) {
    this.httpProxy = httpProxy;
    return (A) this;
  }
  
  public A withHttpsProxy(String httpsProxy) {
    this.httpsProxy = httpsProxy;
    return (A) this;
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public A withRef(String ref) {
    this.ref = ref;
    return (A) this;
  }
  
  public A withUri(String uri) {
    this.uri = uri;
    return (A) this;
  }
  
}