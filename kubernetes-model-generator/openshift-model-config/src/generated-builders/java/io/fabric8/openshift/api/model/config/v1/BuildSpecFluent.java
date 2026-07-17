package io.fabric8.openshift.api.model.config.v1;

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
public class BuildSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.BuildSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapNameReferenceBuilder additionalTrustedCA;
  private BuildDefaultsBuilder buildDefaults;
  private BuildOverridesBuilder buildOverrides;

  public BuildSpecFluent() {
  }
  
  public BuildSpecFluent(BuildSpec instance) {
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
  
  public ConfigMapNameReference buildAdditionalTrustedCA() {
    return this.additionalTrustedCA != null ? this.additionalTrustedCA.build() : null;
  }
  
  public BuildDefaults buildBuildDefaults() {
    return this.buildDefaults != null ? this.buildDefaults.build() : null;
  }
  
  public BuildOverrides buildBuildOverrides() {
    return this.buildOverrides != null ? this.buildOverrides.build() : null;
  }
  
  protected void copyInstance(BuildSpec instance) {
    instance = instance != null ? instance : new BuildSpec();
    if (instance != null) {
        this.withAdditionalTrustedCA(instance.getAdditionalTrustedCA());
        this.withBuildDefaults(instance.getBuildDefaults());
        this.withBuildOverrides(instance.getBuildOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalTrustedCANested<A> editAdditionalTrustedCA() {
    return this.withNewAdditionalTrustedCALike(Optional.ofNullable(this.buildAdditionalTrustedCA()).orElse(null));
  }
  
  public BuildDefaultsNested<A> editBuildDefaults() {
    return this.withNewBuildDefaultsLike(Optional.ofNullable(this.buildBuildDefaults()).orElse(null));
  }
  
  public BuildOverridesNested<A> editBuildOverrides() {
    return this.withNewBuildOverridesLike(Optional.ofNullable(this.buildBuildOverrides()).orElse(null));
  }
  
  public AdditionalTrustedCANested<A> editOrNewAdditionalTrustedCA() {
    return this.withNewAdditionalTrustedCALike(Optional.ofNullable(this.buildAdditionalTrustedCA()).orElse(new ConfigMapNameReferenceBuilder().build()));
  }
  
  public AdditionalTrustedCANested<A> editOrNewAdditionalTrustedCALike(ConfigMapNameReference item) {
    return this.withNewAdditionalTrustedCALike(Optional.ofNullable(this.buildAdditionalTrustedCA()).orElse(item));
  }
  
  public BuildDefaultsNested<A> editOrNewBuildDefaults() {
    return this.withNewBuildDefaultsLike(Optional.ofNullable(this.buildBuildDefaults()).orElse(new BuildDefaultsBuilder().build()));
  }
  
  public BuildDefaultsNested<A> editOrNewBuildDefaultsLike(BuildDefaults item) {
    return this.withNewBuildDefaultsLike(Optional.ofNullable(this.buildBuildDefaults()).orElse(item));
  }
  
  public BuildOverridesNested<A> editOrNewBuildOverrides() {
    return this.withNewBuildOverridesLike(Optional.ofNullable(this.buildBuildOverrides()).orElse(new BuildOverridesBuilder().build()));
  }
  
  public BuildOverridesNested<A> editOrNewBuildOverridesLike(BuildOverrides item) {
    return this.withNewBuildOverridesLike(Optional.ofNullable(this.buildBuildOverrides()).orElse(item));
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
    BuildSpecFluent that = (BuildSpecFluent) o;
    if (!(Objects.equals(additionalTrustedCA, that.additionalTrustedCA))) {
      return false;
    }
    if (!(Objects.equals(buildDefaults, that.buildDefaults))) {
      return false;
    }
    if (!(Objects.equals(buildOverrides, that.buildOverrides))) {
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
  
  public boolean hasAdditionalTrustedCA() {
    return this.additionalTrustedCA != null;
  }
  
  public boolean hasBuildDefaults() {
    return this.buildDefaults != null;
  }
  
  public boolean hasBuildOverrides() {
    return this.buildOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalTrustedCA, buildDefaults, buildOverrides, additionalProperties);
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
    if (!(additionalTrustedCA == null)) {
        sb.append("additionalTrustedCA:");
        sb.append(additionalTrustedCA);
        sb.append(",");
    }
    if (!(buildDefaults == null)) {
        sb.append("buildDefaults:");
        sb.append(buildDefaults);
        sb.append(",");
    }
    if (!(buildOverrides == null)) {
        sb.append("buildOverrides:");
        sb.append(buildOverrides);
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
  
  public A withAdditionalTrustedCA(ConfigMapNameReference additionalTrustedCA) {
    this._visitables.remove("additionalTrustedCA");
    if (additionalTrustedCA != null) {
        this.additionalTrustedCA = new ConfigMapNameReferenceBuilder(additionalTrustedCA);
        this._visitables.get("additionalTrustedCA").add(this.additionalTrustedCA);
    } else {
        this.additionalTrustedCA = null;
        this._visitables.get("additionalTrustedCA").remove(this.additionalTrustedCA);
    }
    return (A) this;
  }
  
  public A withBuildDefaults(BuildDefaults buildDefaults) {
    this._visitables.remove("buildDefaults");
    if (buildDefaults != null) {
        this.buildDefaults = new BuildDefaultsBuilder(buildDefaults);
        this._visitables.get("buildDefaults").add(this.buildDefaults);
    } else {
        this.buildDefaults = null;
        this._visitables.get("buildDefaults").remove(this.buildDefaults);
    }
    return (A) this;
  }
  
  public A withBuildOverrides(BuildOverrides buildOverrides) {
    this._visitables.remove("buildOverrides");
    if (buildOverrides != null) {
        this.buildOverrides = new BuildOverridesBuilder(buildOverrides);
        this._visitables.get("buildOverrides").add(this.buildOverrides);
    } else {
        this.buildOverrides = null;
        this._visitables.get("buildOverrides").remove(this.buildOverrides);
    }
    return (A) this;
  }
  
  public AdditionalTrustedCANested<A> withNewAdditionalTrustedCA() {
    return new AdditionalTrustedCANested(null);
  }
  
  public A withNewAdditionalTrustedCA(String name) {
    return (A) this.withAdditionalTrustedCA(new ConfigMapNameReference(name));
  }
  
  public AdditionalTrustedCANested<A> withNewAdditionalTrustedCALike(ConfigMapNameReference item) {
    return new AdditionalTrustedCANested(item);
  }
  
  public BuildDefaultsNested<A> withNewBuildDefaults() {
    return new BuildDefaultsNested(null);
  }
  
  public BuildDefaultsNested<A> withNewBuildDefaultsLike(BuildDefaults item) {
    return new BuildDefaultsNested(item);
  }
  
  public BuildOverridesNested<A> withNewBuildOverrides() {
    return new BuildOverridesNested(null);
  }
  
  public BuildOverridesNested<A> withNewBuildOverridesLike(BuildOverrides item) {
    return new BuildOverridesNested(item);
  }
  public class AdditionalTrustedCANested<N> extends ConfigMapNameReferenceFluent<AdditionalTrustedCANested<N>> implements Nested<N>{
  
    ConfigMapNameReferenceBuilder builder;
  
    AdditionalTrustedCANested(ConfigMapNameReference item) {
      this.builder = new ConfigMapNameReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSpecFluent.this.withAdditionalTrustedCA(builder.build());
    }
    
    public N endAdditionalTrustedCA() {
      return and();
    }
    
  }
  public class BuildDefaultsNested<N> extends BuildDefaultsFluent<BuildDefaultsNested<N>> implements Nested<N>{
  
    BuildDefaultsBuilder builder;
  
    BuildDefaultsNested(BuildDefaults item) {
      this.builder = new BuildDefaultsBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSpecFluent.this.withBuildDefaults(builder.build());
    }
    
    public N endBuildDefaults() {
      return and();
    }
    
  }
  public class BuildOverridesNested<N> extends BuildOverridesFluent<BuildOverridesNested<N>> implements Nested<N>{
  
    BuildOverridesBuilder builder;
  
    BuildOverridesNested(BuildOverrides item) {
      this.builder = new BuildOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) BuildSpecFluent.this.withBuildOverrides(builder.build());
    }
    
    public N endBuildOverrides() {
      return and();
    }
    
  }
}