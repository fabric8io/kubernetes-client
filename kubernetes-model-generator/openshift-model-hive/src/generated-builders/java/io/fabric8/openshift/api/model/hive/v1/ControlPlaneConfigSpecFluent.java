package io.fabric8.openshift.api.model.hive.v1;

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
public class ControlPlaneConfigSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ControlPlaneConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiServerIPOverride;
  private String apiURLOverride;
  private ControlPlaneServingCertificateSpecBuilder servingCertificates;

  public ControlPlaneConfigSpecFluent() {
  }
  
  public ControlPlaneConfigSpecFluent(ControlPlaneConfigSpec instance) {
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
  
  public ControlPlaneServingCertificateSpec buildServingCertificates() {
    return this.servingCertificates != null ? this.servingCertificates.build() : null;
  }
  
  protected void copyInstance(ControlPlaneConfigSpec instance) {
    instance = instance != null ? instance : new ControlPlaneConfigSpec();
    if (instance != null) {
        this.withApiServerIPOverride(instance.getApiServerIPOverride());
        this.withApiURLOverride(instance.getApiURLOverride());
        this.withServingCertificates(instance.getServingCertificates());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServingCertificatesNested<A> editOrNewServingCertificates() {
    return this.withNewServingCertificatesLike(Optional.ofNullable(this.buildServingCertificates()).orElse(new ControlPlaneServingCertificateSpecBuilder().build()));
  }
  
  public ServingCertificatesNested<A> editOrNewServingCertificatesLike(ControlPlaneServingCertificateSpec item) {
    return this.withNewServingCertificatesLike(Optional.ofNullable(this.buildServingCertificates()).orElse(item));
  }
  
  public ServingCertificatesNested<A> editServingCertificates() {
    return this.withNewServingCertificatesLike(Optional.ofNullable(this.buildServingCertificates()).orElse(null));
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
    ControlPlaneConfigSpecFluent that = (ControlPlaneConfigSpecFluent) o;
    if (!(Objects.equals(apiServerIPOverride, that.apiServerIPOverride))) {
      return false;
    }
    if (!(Objects.equals(apiURLOverride, that.apiURLOverride))) {
      return false;
    }
    if (!(Objects.equals(servingCertificates, that.servingCertificates))) {
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
  
  public String getApiServerIPOverride() {
    return this.apiServerIPOverride;
  }
  
  public String getApiURLOverride() {
    return this.apiURLOverride;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiServerIPOverride() {
    return this.apiServerIPOverride != null;
  }
  
  public boolean hasApiURLOverride() {
    return this.apiURLOverride != null;
  }
  
  public boolean hasServingCertificates() {
    return this.servingCertificates != null;
  }
  
  public int hashCode() {
    return Objects.hash(apiServerIPOverride, apiURLOverride, servingCertificates, additionalProperties);
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
    if (!(apiServerIPOverride == null)) {
        sb.append("apiServerIPOverride:");
        sb.append(apiServerIPOverride);
        sb.append(",");
    }
    if (!(apiURLOverride == null)) {
        sb.append("apiURLOverride:");
        sb.append(apiURLOverride);
        sb.append(",");
    }
    if (!(servingCertificates == null)) {
        sb.append("servingCertificates:");
        sb.append(servingCertificates);
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
  
  public A withApiServerIPOverride(String apiServerIPOverride) {
    this.apiServerIPOverride = apiServerIPOverride;
    return (A) this;
  }
  
  public A withApiURLOverride(String apiURLOverride) {
    this.apiURLOverride = apiURLOverride;
    return (A) this;
  }
  
  public ServingCertificatesNested<A> withNewServingCertificates() {
    return new ServingCertificatesNested(null);
  }
  
  public ServingCertificatesNested<A> withNewServingCertificatesLike(ControlPlaneServingCertificateSpec item) {
    return new ServingCertificatesNested(item);
  }
  
  public A withServingCertificates(ControlPlaneServingCertificateSpec servingCertificates) {
    this._visitables.remove("servingCertificates");
    if (servingCertificates != null) {
        this.servingCertificates = new ControlPlaneServingCertificateSpecBuilder(servingCertificates);
        this._visitables.get("servingCertificates").add(this.servingCertificates);
    } else {
        this.servingCertificates = null;
        this._visitables.get("servingCertificates").remove(this.servingCertificates);
    }
    return (A) this;
  }
  public class ServingCertificatesNested<N> extends ControlPlaneServingCertificateSpecFluent<ServingCertificatesNested<N>> implements Nested<N>{
  
    ControlPlaneServingCertificateSpecBuilder builder;
  
    ServingCertificatesNested(ControlPlaneServingCertificateSpec item) {
      this.builder = new ControlPlaneServingCertificateSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ControlPlaneConfigSpecFluent.this.withServingCertificates(builder.build());
    }
    
    public N endServingCertificates() {
      return and();
    }
    
  }
}