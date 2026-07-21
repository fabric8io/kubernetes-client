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
public class ACMEChallengeSolverHTTP01IngressTemplateFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ACMEChallengeSolverHTTP01IngressObjectMetaBuilder metadata;

  public ACMEChallengeSolverHTTP01IngressTemplateFluent() {
  }
  
  public ACMEChallengeSolverHTTP01IngressTemplateFluent(ACMEChallengeSolverHTTP01IngressTemplate instance) {
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
  
  public ACMEChallengeSolverHTTP01IngressObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolverHTTP01IngressTemplate instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverHTTP01IngressTemplate();
    if (instance != null) {
        this.withMetadata(instance.getMetadata());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ACMEChallengeSolverHTTP01IngressObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ACMEChallengeSolverHTTP01IngressObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
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
    ACMEChallengeSolverHTTP01IngressTemplateFluent that = (ACMEChallengeSolverHTTP01IngressTemplateFluent) o;
    if (!(Objects.equals(metadata, that.metadata))) {
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
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public int hashCode() {
    return Objects.hash(metadata, additionalProperties);
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
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
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
  
  public A withMetadata(ACMEChallengeSolverHTTP01IngressObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ACMEChallengeSolverHTTP01IngressObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ACMEChallengeSolverHTTP01IngressObjectMeta item) {
    return new MetadataNested(item);
  }
  public class MetadataNested<N> extends ACMEChallengeSolverHTTP01IngressObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressObjectMetaBuilder builder;
  
    MetadataNested(ACMEChallengeSolverHTTP01IngressObjectMeta item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressTemplateFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
}