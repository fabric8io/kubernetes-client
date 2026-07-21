package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Boolean;
import java.lang.Long;
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
public class LoadBalancerSettingsConsistentHashLBFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VisitableBuilder<? extends IsLoadBalancerSettingsConsistentHashLBHashAlgorithm,?> hashAlgorithm;
  private VisitableBuilder<? extends IsLoadBalancerSettingsConsistentHashLBHashKey,?> hashKey;
  private Long minimumRingSize;

  public LoadBalancerSettingsConsistentHashLBFluent() {
  }
  
  public LoadBalancerSettingsConsistentHashLBFluent(LoadBalancerSettingsConsistentHashLB instance) {
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
  
  public IsLoadBalancerSettingsConsistentHashLBHashAlgorithm buildHashAlgorithm() {
    return this.hashAlgorithm != null ? this.hashAlgorithm.build() : null;
  }
  
  public IsLoadBalancerSettingsConsistentHashLBHashKey buildHashKey() {
    return this.hashKey != null ? this.hashKey.build() : null;
  }
  
  protected static <T>VisitableBuilder<T,?> builder(Object item) {
    switch (item.getClass().getName()) {
      case "LoadBalancerSettingsConsistentHashLBRingHash":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsConsistentHashLBRingHashBuilder((LoadBalancerSettingsConsistentHashLBRingHash) item);
    
      case "LoadBalancerSettingsConsistentHashLBMaglev":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsConsistentHashLBMaglevBuilder((LoadBalancerSettingsConsistentHashLBMaglev) item);
    
      case "LoadBalancerSettingsConsistentHashLBUseSourceIp":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder((LoadBalancerSettingsConsistentHashLBUseSourceIp) item);
    
      case "LoadBalancerSettingsConsistentHashLBHttpHeaderName":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder((LoadBalancerSettingsConsistentHashLBHttpHeaderName) item);
    
      case "LoadBalancerSettingsConsistentHashLBHttpQueryParameterName":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder((LoadBalancerSettingsConsistentHashLBHttpQueryParameterName) item);
    
      case "LoadBalancerSettingsConsistentHashLBHttpCookie":
    
          return (VisitableBuilder<T,?>) new LoadBalancerSettingsConsistentHashLBHttpCookieBuilder((LoadBalancerSettingsConsistentHashLBHttpCookie) item);
    
      default:
    
          return (VisitableBuilder<T,?>) builderOf(item);
    
    }
  }
  
  protected void copyInstance(LoadBalancerSettingsConsistentHashLB instance) {
    instance = instance != null ? instance : new LoadBalancerSettingsConsistentHashLB();
    if (instance != null) {
        this.withHashAlgorithm(instance.getHashAlgorithm());
        this.withHashKey(instance.getHashKey());
        this.withMinimumRingSize(instance.getMinimumRingSize());
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
    LoadBalancerSettingsConsistentHashLBFluent that = (LoadBalancerSettingsConsistentHashLBFluent) o;
    if (!(Objects.equals(hashAlgorithm, that.hashAlgorithm))) {
      return false;
    }
    if (!(Objects.equals(hashKey, that.hashKey))) {
      return false;
    }
    if (!(Objects.equals(minimumRingSize, that.minimumRingSize))) {
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
  
  public Long getMinimumRingSize() {
    return this.minimumRingSize;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHashAlgorithm() {
    return this.hashAlgorithm != null;
  }
  
  public boolean hasHashKey() {
    return this.hashKey != null;
  }
  
  public boolean hasMinimumRingSize() {
    return this.minimumRingSize != null;
  }
  
  public int hashCode() {
    return Objects.hash(hashAlgorithm, hashKey, minimumRingSize, additionalProperties);
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
    if (!(hashAlgorithm == null)) {
        sb.append("hashAlgorithm:");
        sb.append(hashAlgorithm);
        sb.append(",");
    }
    if (!(hashKey == null)) {
        sb.append("hashKey:");
        sb.append(hashKey);
        sb.append(",");
    }
    if (!(minimumRingSize == null)) {
        sb.append("minimumRingSize:");
        sb.append(minimumRingSize);
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
  
  public A withHashAlgorithm(IsLoadBalancerSettingsConsistentHashLBHashAlgorithm hashAlgorithm) {
    if (hashAlgorithm == null) {
        this.hashAlgorithm = null;
        this._visitables.remove("hashAlgorithm");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsLoadBalancerSettingsConsistentHashLBHashAlgorithm,?> builder = builder(hashAlgorithm);
        this._visitables.get("hashAlgorithm").clear();
        this._visitables.get("hashAlgorithm").add(builder);
        this.hashAlgorithm = builder;
        return (A) this;
    }
  }
  
  public A withHashKey(IsLoadBalancerSettingsConsistentHashLBHashKey hashKey) {
    if (hashKey == null) {
        this.hashKey = null;
        this._visitables.remove("hashKey");
        return (A) this;
    } else {
        VisitableBuilder<? extends IsLoadBalancerSettingsConsistentHashLBHashKey,?> builder = builder(hashKey);
        this._visitables.get("hashKey").clear();
        this._visitables.get("hashKey").add(builder);
        this.hashKey = builder;
        return (A) this;
    }
  }
  
  public A withMinimumRingSize(Long minimumRingSize) {
    this.minimumRingSize = minimumRingSize;
    return (A) this;
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpCookieKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBHttpCookieKey() {
    return new LoadBalancerSettingsConsistentHashLBHttpCookieKeyNested(null);
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpCookieKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBHttpCookieKeyLike(LoadBalancerSettingsConsistentHashLBHttpCookie item) {
    return new LoadBalancerSettingsConsistentHashLBHttpCookieKeyNested(item);
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBHttpHeaderNameKey() {
    return new LoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyNested(null);
  }
  
  public A withNewLoadBalancerSettingsConsistentHashLBHttpHeaderNameKey(String httpHeaderName) {
    return (A) this.withHashKey(new LoadBalancerSettingsConsistentHashLBHttpHeaderName(httpHeaderName));
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyLike(LoadBalancerSettingsConsistentHashLBHttpHeaderName item) {
    return new LoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyNested(item);
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKey() {
    return new LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyNested(null);
  }
  
  public A withNewLoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKey(String httpQueryParameterName) {
    return (A) this.withHashKey(new LoadBalancerSettingsConsistentHashLBHttpQueryParameterName(httpQueryParameterName));
  }
  
  public LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyLike(LoadBalancerSettingsConsistentHashLBHttpQueryParameterName item) {
    return new LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyNested(item);
  }
  
  public LoadBalancerSettingsConsistentHashLBMaglevAlgorithmNested<A> withNewLoadBalancerSettingsConsistentHashLBMaglevAlgorithm() {
    return new LoadBalancerSettingsConsistentHashLBMaglevAlgorithmNested(null);
  }
  
  public LoadBalancerSettingsConsistentHashLBMaglevAlgorithmNested<A> withNewLoadBalancerSettingsConsistentHashLBMaglevAlgorithmLike(LoadBalancerSettingsConsistentHashLBMaglev item) {
    return new LoadBalancerSettingsConsistentHashLBMaglevAlgorithmNested(item);
  }
  
  public LoadBalancerSettingsConsistentHashLBRingHashAlgorithmNested<A> withNewLoadBalancerSettingsConsistentHashLBRingHashAlgorithm() {
    return new LoadBalancerSettingsConsistentHashLBRingHashAlgorithmNested(null);
  }
  
  public LoadBalancerSettingsConsistentHashLBRingHashAlgorithmNested<A> withNewLoadBalancerSettingsConsistentHashLBRingHashAlgorithmLike(LoadBalancerSettingsConsistentHashLBRingHash item) {
    return new LoadBalancerSettingsConsistentHashLBRingHashAlgorithmNested(item);
  }
  
  public LoadBalancerSettingsConsistentHashLBUseSourceIpKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBUseSourceIpKey() {
    return new LoadBalancerSettingsConsistentHashLBUseSourceIpKeyNested(null);
  }
  
  public A withNewLoadBalancerSettingsConsistentHashLBUseSourceIpKey(Boolean useSourceIp) {
    return (A) this.withHashKey(new LoadBalancerSettingsConsistentHashLBUseSourceIp(useSourceIp));
  }
  
  public LoadBalancerSettingsConsistentHashLBUseSourceIpKeyNested<A> withNewLoadBalancerSettingsConsistentHashLBUseSourceIpKeyLike(LoadBalancerSettingsConsistentHashLBUseSourceIp item) {
    return new LoadBalancerSettingsConsistentHashLBUseSourceIpKeyNested(item);
  }
  public class LoadBalancerSettingsConsistentHashLBHttpCookieKeyNested<N> extends LoadBalancerSettingsConsistentHashLBHttpCookieFluent<LoadBalancerSettingsConsistentHashLBHttpCookieKeyNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBHttpCookieBuilder builder;
  
    LoadBalancerSettingsConsistentHashLBHttpCookieKeyNested(LoadBalancerSettingsConsistentHashLBHttpCookie item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBHttpCookieBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBFluent.this.withHashKey(builder.build());
    }
    
    public N endLoadBalancerSettingsConsistentHashLBHttpCookieKey() {
      return and();
    }
    
  }
  public class LoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyNested<N> extends LoadBalancerSettingsConsistentHashLBHttpHeaderNameFluent<LoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder builder;
  
    LoadBalancerSettingsConsistentHashLBHttpHeaderNameKeyNested(LoadBalancerSettingsConsistentHashLBHttpHeaderName item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBHttpHeaderNameBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBFluent.this.withHashKey(builder.build());
    }
    
    public N endLoadBalancerSettingsConsistentHashLBHttpHeaderNameKey() {
      return and();
    }
    
  }
  public class LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyNested<N> extends LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameFluent<LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder builder;
  
    LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKeyNested(LoadBalancerSettingsConsistentHashLBHttpQueryParameterName item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBHttpQueryParameterNameBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBFluent.this.withHashKey(builder.build());
    }
    
    public N endLoadBalancerSettingsConsistentHashLBHttpQueryParameterNameKey() {
      return and();
    }
    
  }
  public class LoadBalancerSettingsConsistentHashLBMaglevAlgorithmNested<N> extends LoadBalancerSettingsConsistentHashLBMaglevFluent<LoadBalancerSettingsConsistentHashLBMaglevAlgorithmNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBMaglevBuilder builder;
  
    LoadBalancerSettingsConsistentHashLBMaglevAlgorithmNested(LoadBalancerSettingsConsistentHashLBMaglev item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBMaglevBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBFluent.this.withHashAlgorithm(builder.build());
    }
    
    public N endLoadBalancerSettingsConsistentHashLBMaglevAlgorithm() {
      return and();
    }
    
  }
  public class LoadBalancerSettingsConsistentHashLBRingHashAlgorithmNested<N> extends LoadBalancerSettingsConsistentHashLBRingHashFluent<LoadBalancerSettingsConsistentHashLBRingHashAlgorithmNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBRingHashBuilder builder;
  
    LoadBalancerSettingsConsistentHashLBRingHashAlgorithmNested(LoadBalancerSettingsConsistentHashLBRingHash item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBRingHashBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBFluent.this.withHashAlgorithm(builder.build());
    }
    
    public N endLoadBalancerSettingsConsistentHashLBRingHashAlgorithm() {
      return and();
    }
    
  }
  public class LoadBalancerSettingsConsistentHashLBUseSourceIpKeyNested<N> extends LoadBalancerSettingsConsistentHashLBUseSourceIpFluent<LoadBalancerSettingsConsistentHashLBUseSourceIpKeyNested<N>> implements Nested<N>{
  
    LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder builder;
  
    LoadBalancerSettingsConsistentHashLBUseSourceIpKeyNested(LoadBalancerSettingsConsistentHashLBUseSourceIp item) {
      this.builder = new LoadBalancerSettingsConsistentHashLBUseSourceIpBuilder(this, item);
    }
  
    public N and() {
      return (N) LoadBalancerSettingsConsistentHashLBFluent.this.withHashKey(builder.build());
    }
    
    public N endLoadBalancerSettingsConsistentHashLBUseSourceIpKey() {
      return and();
    }
    
  }
}