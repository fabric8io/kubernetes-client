package io.fabric8.certmanager.api.model.acme.v1;

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
public class Route53AuthFluent<A extends io.fabric8.certmanager.api.model.acme.v1.Route53AuthFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Route53KubernetesAuthBuilder kubernetes;

  public Route53AuthFluent() {
  }
  
  public Route53AuthFluent(Route53Auth instance) {
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
  
  public Route53KubernetesAuth buildKubernetes() {
    return this.kubernetes != null ? this.kubernetes.build() : null;
  }
  
  protected void copyInstance(Route53Auth instance) {
    instance = instance != null ? instance : new Route53Auth();
    if (instance != null) {
        this.withKubernetes(instance.getKubernetes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KubernetesNested<A> editKubernetes() {
    return this.withNewKubernetesLike(Optional.ofNullable(this.buildKubernetes()).orElse(null));
  }
  
  public KubernetesNested<A> editOrNewKubernetes() {
    return this.withNewKubernetesLike(Optional.ofNullable(this.buildKubernetes()).orElse(new Route53KubernetesAuthBuilder().build()));
  }
  
  public KubernetesNested<A> editOrNewKubernetesLike(Route53KubernetesAuth item) {
    return this.withNewKubernetesLike(Optional.ofNullable(this.buildKubernetes()).orElse(item));
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
    Route53AuthFluent that = (Route53AuthFluent) o;
    if (!(Objects.equals(kubernetes, that.kubernetes))) {
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
  
  public boolean hasKubernetes() {
    return this.kubernetes != null;
  }
  
  public int hashCode() {
    return Objects.hash(kubernetes, additionalProperties);
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
    if (!(kubernetes == null)) {
        sb.append("kubernetes:");
        sb.append(kubernetes);
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
  
  public A withKubernetes(Route53KubernetesAuth kubernetes) {
    this._visitables.remove("kubernetes");
    if (kubernetes != null) {
        this.kubernetes = new Route53KubernetesAuthBuilder(kubernetes);
        this._visitables.get("kubernetes").add(this.kubernetes);
    } else {
        this.kubernetes = null;
        this._visitables.get("kubernetes").remove(this.kubernetes);
    }
    return (A) this;
  }
  
  public KubernetesNested<A> withNewKubernetes() {
    return new KubernetesNested(null);
  }
  
  public KubernetesNested<A> withNewKubernetesLike(Route53KubernetesAuth item) {
    return new KubernetesNested(item);
  }
  public class KubernetesNested<N> extends Route53KubernetesAuthFluent<KubernetesNested<N>> implements Nested<N>{
  
    Route53KubernetesAuthBuilder builder;
  
    KubernetesNested(Route53KubernetesAuth item) {
      this.builder = new Route53KubernetesAuthBuilder(this, item);
    }
  
    public N and() {
      return (N) Route53AuthFluent.this.withKubernetes(builder.build());
    }
    
    public N endKubernetes() {
      return and();
    }
    
  }
}