package io.fabric8.openshift.api.model.monitoring.v1;

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
public class ProbeTargetsFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.ProbeTargetsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ProbeTargetIngressBuilder ingress;
  private ProbeTargetStaticConfigBuilder staticConfig;

  public ProbeTargetsFluent() {
  }
  
  public ProbeTargetsFluent(ProbeTargets instance) {
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
  
  public ProbeTargetIngress buildIngress() {
    return this.ingress != null ? this.ingress.build() : null;
  }
  
  public ProbeTargetStaticConfig buildStaticConfig() {
    return this.staticConfig != null ? this.staticConfig.build() : null;
  }
  
  protected void copyInstance(ProbeTargets instance) {
    instance = instance != null ? instance : new ProbeTargets();
    if (instance != null) {
        this.withIngress(instance.getIngress());
        this.withStaticConfig(instance.getStaticConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IngressNested<A> editIngress() {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(null));
  }
  
  public IngressNested<A> editOrNewIngress() {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(new ProbeTargetIngressBuilder().build()));
  }
  
  public IngressNested<A> editOrNewIngressLike(ProbeTargetIngress item) {
    return this.withNewIngressLike(Optional.ofNullable(this.buildIngress()).orElse(item));
  }
  
  public StaticConfigNested<A> editOrNewStaticConfig() {
    return this.withNewStaticConfigLike(Optional.ofNullable(this.buildStaticConfig()).orElse(new ProbeTargetStaticConfigBuilder().build()));
  }
  
  public StaticConfigNested<A> editOrNewStaticConfigLike(ProbeTargetStaticConfig item) {
    return this.withNewStaticConfigLike(Optional.ofNullable(this.buildStaticConfig()).orElse(item));
  }
  
  public StaticConfigNested<A> editStaticConfig() {
    return this.withNewStaticConfigLike(Optional.ofNullable(this.buildStaticConfig()).orElse(null));
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
    ProbeTargetsFluent that = (ProbeTargetsFluent) o;
    if (!(Objects.equals(ingress, that.ingress))) {
      return false;
    }
    if (!(Objects.equals(staticConfig, that.staticConfig))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIngress() {
    return this.ingress != null;
  }
  
  public boolean hasStaticConfig() {
    return this.staticConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(ingress, staticConfig, additionalProperties);
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
    if (!(ingress == null)) {
        sb.append("ingress:");
        sb.append(ingress);
        sb.append(",");
    }
    if (!(staticConfig == null)) {
        sb.append("staticConfig:");
        sb.append(staticConfig);
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
  
  public A withIngress(ProbeTargetIngress ingress) {
    this._visitables.remove("ingress");
    if (ingress != null) {
        this.ingress = new ProbeTargetIngressBuilder(ingress);
        this._visitables.get("ingress").add(this.ingress);
    } else {
        this.ingress = null;
        this._visitables.get("ingress").remove(this.ingress);
    }
    return (A) this;
  }
  
  public IngressNested<A> withNewIngress() {
    return new IngressNested(null);
  }
  
  public IngressNested<A> withNewIngressLike(ProbeTargetIngress item) {
    return new IngressNested(item);
  }
  
  public StaticConfigNested<A> withNewStaticConfig() {
    return new StaticConfigNested(null);
  }
  
  public StaticConfigNested<A> withNewStaticConfigLike(ProbeTargetStaticConfig item) {
    return new StaticConfigNested(item);
  }
  
  public A withStaticConfig(ProbeTargetStaticConfig staticConfig) {
    this._visitables.remove("staticConfig");
    if (staticConfig != null) {
        this.staticConfig = new ProbeTargetStaticConfigBuilder(staticConfig);
        this._visitables.get("staticConfig").add(this.staticConfig);
    } else {
        this.staticConfig = null;
        this._visitables.get("staticConfig").remove(this.staticConfig);
    }
    return (A) this;
  }
  public class IngressNested<N> extends ProbeTargetIngressFluent<IngressNested<N>> implements Nested<N>{
  
    ProbeTargetIngressBuilder builder;
  
    IngressNested(ProbeTargetIngress item) {
      this.builder = new ProbeTargetIngressBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeTargetsFluent.this.withIngress(builder.build());
    }
    
    public N endIngress() {
      return and();
    }
    
  }
  public class StaticConfigNested<N> extends ProbeTargetStaticConfigFluent<StaticConfigNested<N>> implements Nested<N>{
  
    ProbeTargetStaticConfigBuilder builder;
  
    StaticConfigNested(ProbeTargetStaticConfig item) {
      this.builder = new ProbeTargetStaticConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeTargetsFluent.this.withStaticConfig(builder.build());
    }
    
    public N endStaticConfig() {
      return and();
    }
    
  }
}