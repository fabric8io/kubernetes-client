package io.fabric8.openshift.api.model.config.v1alpha2;

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
public class InsightsDataGatherSpecFluent<A extends io.fabric8.openshift.api.model.config.v1alpha2.InsightsDataGatherSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private GatherConfigBuilder gatherConfig;

  public InsightsDataGatherSpecFluent() {
  }
  
  public InsightsDataGatherSpecFluent(InsightsDataGatherSpec instance) {
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
  
  public GatherConfig buildGatherConfig() {
    return this.gatherConfig != null ? this.gatherConfig.build() : null;
  }
  
  protected void copyInstance(InsightsDataGatherSpec instance) {
    instance = instance != null ? instance : new InsightsDataGatherSpec();
    if (instance != null) {
        this.withGatherConfig(instance.getGatherConfig());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GatherConfigNested<A> editGatherConfig() {
    return this.withNewGatherConfigLike(Optional.ofNullable(this.buildGatherConfig()).orElse(null));
  }
  
  public GatherConfigNested<A> editOrNewGatherConfig() {
    return this.withNewGatherConfigLike(Optional.ofNullable(this.buildGatherConfig()).orElse(new GatherConfigBuilder().build()));
  }
  
  public GatherConfigNested<A> editOrNewGatherConfigLike(GatherConfig item) {
    return this.withNewGatherConfigLike(Optional.ofNullable(this.buildGatherConfig()).orElse(item));
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
    InsightsDataGatherSpecFluent that = (InsightsDataGatherSpecFluent) o;
    if (!(Objects.equals(gatherConfig, that.gatherConfig))) {
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
  
  public boolean hasGatherConfig() {
    return this.gatherConfig != null;
  }
  
  public int hashCode() {
    return Objects.hash(gatherConfig, additionalProperties);
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
    if (!(gatherConfig == null)) {
        sb.append("gatherConfig:");
        sb.append(gatherConfig);
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
  
  public A withGatherConfig(GatherConfig gatherConfig) {
    this._visitables.remove("gatherConfig");
    if (gatherConfig != null) {
        this.gatherConfig = new GatherConfigBuilder(gatherConfig);
        this._visitables.get("gatherConfig").add(this.gatherConfig);
    } else {
        this.gatherConfig = null;
        this._visitables.get("gatherConfig").remove(this.gatherConfig);
    }
    return (A) this;
  }
  
  public GatherConfigNested<A> withNewGatherConfig() {
    return new GatherConfigNested(null);
  }
  
  public GatherConfigNested<A> withNewGatherConfigLike(GatherConfig item) {
    return new GatherConfigNested(item);
  }
  public class GatherConfigNested<N> extends GatherConfigFluent<GatherConfigNested<N>> implements Nested<N>{
  
    GatherConfigBuilder builder;
  
    GatherConfigNested(GatherConfig item) {
      this.builder = new GatherConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) InsightsDataGatherSpecFluent.this.withGatherConfig(builder.build());
    }
    
    public N endGatherConfig() {
      return and();
    }
    
  }
}