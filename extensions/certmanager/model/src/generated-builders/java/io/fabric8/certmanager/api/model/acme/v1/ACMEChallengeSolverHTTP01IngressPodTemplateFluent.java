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
public class ACMEChallengeSolverHTTP01IngressPodTemplateFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressPodTemplateFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder metadata;
  private ACMEChallengeSolverHTTP01IngressPodSpecBuilder spec;

  public ACMEChallengeSolverHTTP01IngressPodTemplateFluent() {
  }
  
  public ACMEChallengeSolverHTTP01IngressPodTemplateFluent(ACMEChallengeSolverHTTP01IngressPodTemplate instance) {
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
  
  public ACMEChallengeSolverHTTP01IngressPodObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSpec buildSpec() {
    return this.spec != null ? this.spec.build() : null;
  }
  
  protected void copyInstance(ACMEChallengeSolverHTTP01IngressPodTemplate instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverHTTP01IngressPodTemplate();
    if (instance != null) {
        this.withMetadata(instance.getMetadata());
        this.withSpec(instance.getSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ACMEChallengeSolverHTTP01IngressPodObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public SpecNested<A> editOrNewSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(new ACMEChallengeSolverHTTP01IngressPodSpecBuilder().build()));
  }
  
  public SpecNested<A> editOrNewSpecLike(ACMEChallengeSolverHTTP01IngressPodSpec item) {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(item));
  }
  
  public SpecNested<A> editSpec() {
    return this.withNewSpecLike(Optional.ofNullable(this.buildSpec()).orElse(null));
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
    ACMEChallengeSolverHTTP01IngressPodTemplateFluent that = (ACMEChallengeSolverHTTP01IngressPodTemplateFluent) o;
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(spec, that.spec))) {
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
  
  public boolean hasSpec() {
    return this.spec != null;
  }
  
  public int hashCode() {
    return Objects.hash(metadata, spec, additionalProperties);
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
    if (!(spec == null)) {
        sb.append("spec:");
        sb.append(spec);
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
  
  public A withMetadata(ACMEChallengeSolverHTTP01IngressPodObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder(metadata);
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
  
  public MetadataNested<A> withNewMetadataLike(ACMEChallengeSolverHTTP01IngressPodObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public SpecNested<A> withNewSpec() {
    return new SpecNested(null);
  }
  
  public SpecNested<A> withNewSpecLike(ACMEChallengeSolverHTTP01IngressPodSpec item) {
    return new SpecNested(item);
  }
  
  public A withSpec(ACMEChallengeSolverHTTP01IngressPodSpec spec) {
    this._visitables.remove("spec");
    if (spec != null) {
        this.spec = new ACMEChallengeSolverHTTP01IngressPodSpecBuilder(spec);
        this._visitables.get("spec").add(this.spec);
    } else {
        this.spec = null;
        this._visitables.get("spec").remove(this.spec);
    }
    return (A) this;
  }
  public class MetadataNested<N> extends ACMEChallengeSolverHTTP01IngressPodObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder builder;
  
    MetadataNested(ACMEChallengeSolverHTTP01IngressPodObjectMeta item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressPodObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressPodTemplateFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class SpecNested<N> extends ACMEChallengeSolverHTTP01IngressPodSpecFluent<SpecNested<N>> implements Nested<N>{
  
    ACMEChallengeSolverHTTP01IngressPodSpecBuilder builder;
  
    SpecNested(ACMEChallengeSolverHTTP01IngressPodSpec item) {
      this.builder = new ACMEChallengeSolverHTTP01IngressPodSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) ACMEChallengeSolverHTTP01IngressPodTemplateFluent.this.withSpec(builder.build());
    }
    
    public N endSpec() {
      return and();
    }
    
  }
}