package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class Metal3RemediationTemplateStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3RemediationTemplateStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Metal3RemediationStatusBuilder status;

  public Metal3RemediationTemplateStatusFluent() {
  }
  
  public Metal3RemediationTemplateStatusFluent(Metal3RemediationTemplateStatus instance) {
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
  
  public Metal3RemediationStatus buildStatus() {
    return this.status != null ? this.status.build() : null;
  }
  
  protected void copyInstance(Metal3RemediationTemplateStatus instance) {
    instance = instance != null ? instance : new Metal3RemediationTemplateStatus();
    if (instance != null) {
        this.withStatus(instance.getStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public StatusNested<A> editOrNewStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(new Metal3RemediationStatusBuilder().build()));
  }
  
  public StatusNested<A> editOrNewStatusLike(Metal3RemediationStatus item) {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(item));
  }
  
  public StatusNested<A> editStatus() {
    return this.withNewStatusLike(Optional.ofNullable(this.buildStatus()).orElse(null));
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
    Metal3RemediationTemplateStatusFluent that = (Metal3RemediationTemplateStatusFluent) o;
    if (!(Objects.equals(status, that.status))) {
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
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public int hashCode() {
    return Objects.hash(status, additionalProperties);
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
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
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
  
  public StatusNested<A> withNewStatus() {
    return new StatusNested(null);
  }
  
  public A withNewStatus(String lastRemediated,String phase,Integer retryCount) {
    return (A) this.withStatus(new Metal3RemediationStatus(lastRemediated, phase, retryCount));
  }
  
  public StatusNested<A> withNewStatusLike(Metal3RemediationStatus item) {
    return new StatusNested(item);
  }
  
  public A withStatus(Metal3RemediationStatus status) {
    this._visitables.remove("status");
    if (status != null) {
        this.status = new Metal3RemediationStatusBuilder(status);
        this._visitables.get("status").add(this.status);
    } else {
        this.status = null;
        this._visitables.get("status").remove(this.status);
    }
    return (A) this;
  }
  public class StatusNested<N> extends Metal3RemediationStatusFluent<StatusNested<N>> implements Nested<N>{
  
    Metal3RemediationStatusBuilder builder;
  
    StatusNested(Metal3RemediationStatus item) {
      this.builder = new Metal3RemediationStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3RemediationTemplateStatusFluent.this.withStatus(builder.build());
    }
    
    public N endStatus() {
      return and();
    }
    
  }
}