package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ProxySpecFluent<A extends io.fabric8.openshift.api.model.config.v1.ProxySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String httpProxy;
  private String httpsProxy;
  private String noProxy;
  private List<String> readinessEndpoints = new ArrayList<String>();
  private ConfigMapNameReferenceBuilder trustedCA;

  public ProxySpecFluent() {
  }
  
  public ProxySpecFluent(ProxySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToReadinessEndpoints(Collection<String> items) {
    if (this.readinessEndpoints == null) {
      this.readinessEndpoints = new ArrayList();
    }
    for (String item : items) {
      this.readinessEndpoints.add(item);
    }
    return (A) this;
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
  
  public A addToReadinessEndpoints(String... items) {
    if (this.readinessEndpoints == null) {
      this.readinessEndpoints = new ArrayList();
    }
    for (String item : items) {
      this.readinessEndpoints.add(item);
    }
    return (A) this;
  }
  
  public A addToReadinessEndpoints(int index,String item) {
    if (this.readinessEndpoints == null) {
      this.readinessEndpoints = new ArrayList();
    }
    this.readinessEndpoints.add(index, item);
    return (A) this;
  }
  
  public ConfigMapNameReference buildTrustedCA() {
    return this.trustedCA != null ? this.trustedCA.build() : null;
  }
  
  protected void copyInstance(ProxySpec instance) {
    instance = instance != null ? instance : new ProxySpec();
    if (instance != null) {
        this.withHttpProxy(instance.getHttpProxy());
        this.withHttpsProxy(instance.getHttpsProxy());
        this.withNoProxy(instance.getNoProxy());
        this.withReadinessEndpoints(instance.getReadinessEndpoints());
        this.withTrustedCA(instance.getTrustedCA());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TrustedCANested<A> editOrNewTrustedCA() {
    return this.withNewTrustedCALike(Optional.ofNullable(this.buildTrustedCA()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public TrustedCANested<A> editOrNewTrustedCALike(ConfigMapNameReference item) {
    return this.withNewTrustedCALike(Optional.ofNullable(this.buildTrustedCA()).orElse(item));
  }
  
  public TrustedCANested<A> editTrustedCA() {
    return this.withNewTrustedCALike(Optional.ofNullable(this.buildTrustedCA()).orElse(null));
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
    ProxySpecFluent that = (ProxySpecFluent) o;
    if (!(Objects.equals(httpProxy, that.httpProxy))) {
      return false;
    }
    if (!(Objects.equals(httpsProxy, that.httpsProxy))) {
      return false;
    }
    if (!(Objects.equals(noProxy, that.noProxy))) {
      return false;
    }
    if (!(Objects.equals(readinessEndpoints, that.readinessEndpoints))) {
      return false;
    }
    if (!(Objects.equals(trustedCA, that.trustedCA))) {
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
  
  public String getFirstReadinessEndpoint() {
    return this.readinessEndpoints.get(0);
  }
  
  public String getHttpProxy() {
    return this.httpProxy;
  }
  
  public String getHttpsProxy() {
    return this.httpsProxy;
  }
  
  public String getLastReadinessEndpoint() {
    return this.readinessEndpoints.get(readinessEndpoints.size() - 1);
  }
  
  public String getMatchingReadinessEndpoint(Predicate<String> predicate) {
      for (String item : readinessEndpoints) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNoProxy() {
    return this.noProxy;
  }
  
  public String getReadinessEndpoint(int index) {
    return this.readinessEndpoints.get(index);
  }
  
  public List<String> getReadinessEndpoints() {
    return this.readinessEndpoints;
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
  
  public boolean hasMatchingReadinessEndpoint(Predicate<String> predicate) {
      for (String item : readinessEndpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNoProxy() {
    return this.noProxy != null;
  }
  
  public boolean hasReadinessEndpoints() {
    return this.readinessEndpoints != null && !(this.readinessEndpoints.isEmpty());
  }
  
  public boolean hasTrustedCA() {
    return this.trustedCA != null;
  }
  
  public int hashCode() {
    return Objects.hash(httpProxy, httpsProxy, noProxy, readinessEndpoints, trustedCA, additionalProperties);
  }
  
  public A removeAllFromReadinessEndpoints(Collection<String> items) {
    if (this.readinessEndpoints == null) {
      return (A) this;
    }
    for (String item : items) {
      this.readinessEndpoints.remove(item);
    }
    return (A) this;
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
  
  public A removeFromReadinessEndpoints(String... items) {
    if (this.readinessEndpoints == null) {
      return (A) this;
    }
    for (String item : items) {
      this.readinessEndpoints.remove(item);
    }
    return (A) this;
  }
  
  public A setToReadinessEndpoints(int index,String item) {
    if (this.readinessEndpoints == null) {
      this.readinessEndpoints = new ArrayList();
    }
    this.readinessEndpoints.set(index, item);
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
    if (!(readinessEndpoints == null) && !(readinessEndpoints.isEmpty())) {
        sb.append("readinessEndpoints:");
        sb.append(readinessEndpoints);
        sb.append(",");
    }
    if (!(trustedCA == null)) {
        sb.append("trustedCA:");
        sb.append(trustedCA);
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
  
  public TrustedCANested<A> withNewTrustedCA() {
    return new TrustedCANested(null);
  }
  
  public A withNewTrustedCA(String name) {
    return (A) this.withTrustedCA(new ConfigMapNameReference(name));
  }
  
  public TrustedCANested<A> withNewTrustedCALike(ConfigMapNameReference item) {
    return new TrustedCANested(item);
  }
  
  public A withNoProxy(String noProxy) {
    this.noProxy = noProxy;
    return (A) this;
  }
  
  public A withReadinessEndpoints(List<String> readinessEndpoints) {
    if (readinessEndpoints != null) {
        this.readinessEndpoints = new ArrayList();
        for (String item : readinessEndpoints) {
          this.addToReadinessEndpoints(item);
        }
    } else {
      this.readinessEndpoints = null;
    }
    return (A) this;
  }
  
  public A withReadinessEndpoints(String... readinessEndpoints) {
    if (this.readinessEndpoints != null) {
        this.readinessEndpoints.clear();
        _visitables.remove("readinessEndpoints");
    }
    if (readinessEndpoints != null) {
      for (String item : readinessEndpoints) {
        this.addToReadinessEndpoints(item);
      }
    }
    return (A) this;
  }
  
  public A withTrustedCA(ConfigMapNameReference trustedCA) {
    this._visitables.remove("trustedCA");
    if (trustedCA != null) {
        this.trustedCA = new ConfigMapNameReferenceBuilder(trustedCA);
        this._visitables.get("trustedCA").add(this.trustedCA);
    } else {
        this.trustedCA = null;
        this._visitables.get("trustedCA").remove(this.trustedCA);
    }
    return (A) this;
  }
  public class TrustedCANested<N> extends ConfigMapNameReferenceFluent<TrustedCANested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    TrustedCANested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ProxySpecFluent.this.withTrustedCA(builder.build());
    }
    
    public N endTrustedCA() {
      return and();
    }
    
  }
}