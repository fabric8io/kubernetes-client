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
public class InfrastructureSpecFluent<A extends io.fabric8.openshift.api.model.config.v1.InfrastructureSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapFileReferenceBuilder cloudConfig;
  private PlatformSpecBuilder platformSpec;

  public InfrastructureSpecFluent() {
  }
  
  public InfrastructureSpecFluent(InfrastructureSpec instance) {
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
  
  public ConfigMapFileReference buildCloudConfig() {
    return this.cloudConfig != null ? this.cloudConfig.build() : null;
  }
  
  public PlatformSpec buildPlatformSpec() {
    return this.platformSpec != null ? this.platformSpec.build() : null;
  }
  
  protected void copyInstance(InfrastructureSpec instance) {
    instance = instance != null ? instance : new InfrastructureSpec();
    if (instance != null) {
        this.withCloudConfig(instance.getCloudConfig());
        this.withPlatformSpec(instance.getPlatformSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CloudConfigNested<A> editCloudConfig() {
    return this.withNewCloudConfigLike(Optional.ofNullable(this.buildCloudConfig()).orElse(null));
  }
  
  public CloudConfigNested<A> editOrNewCloudConfig() {
    return this.withNewCloudConfigLike(Optional.ofNullable(this.buildCloudConfig()).orElse(new ConfigMapFileReferenceBuilder().build()));
  }
  
  public CloudConfigNested<A> editOrNewCloudConfigLike(ConfigMapFileReference item) {
    return this.withNewCloudConfigLike(Optional.ofNullable(this.buildCloudConfig()).orElse(item));
  }
  
  public PlatformSpecNested<A> editOrNewPlatformSpec() {
    return this.withNewPlatformSpecLike(Optional.ofNullable(this.buildPlatformSpec()).orElse(new PlatformSpecBuilder().build()));
  }
  
  public PlatformSpecNested<A> editOrNewPlatformSpecLike(PlatformSpec item) {
    return this.withNewPlatformSpecLike(Optional.ofNullable(this.buildPlatformSpec()).orElse(item));
  }
  
  public PlatformSpecNested<A> editPlatformSpec() {
    return this.withNewPlatformSpecLike(Optional.ofNullable(this.buildPlatformSpec()).orElse(null));
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
    InfrastructureSpecFluent that = (InfrastructureSpecFluent) o;
    if (!(Objects.equals(cloudConfig, that.cloudConfig))) {
      return false;
    }
    if (!(Objects.equals(platformSpec, that.platformSpec))) {
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
  
  public boolean hasCloudConfig() {
    return this.cloudConfig != null;
  }
  
  public boolean hasPlatformSpec() {
    return this.platformSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(cloudConfig, platformSpec, additionalProperties);
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
    if (!(cloudConfig == null)) {
        sb.append("cloudConfig:");
        sb.append(cloudConfig);
        sb.append(",");
    }
    if (!(platformSpec == null)) {
        sb.append("platformSpec:");
        sb.append(platformSpec);
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
  
  public A withCloudConfig(ConfigMapFileReference cloudConfig) {
    this._visitables.remove("cloudConfig");
    if (cloudConfig != null) {
        this.cloudConfig = new ConfigMapFileReferenceBuilder(cloudConfig);
        this._visitables.get("cloudConfig").add(this.cloudConfig);
    } else {
        this.cloudConfig = null;
        this._visitables.get("cloudConfig").remove(this.cloudConfig);
    }
    return (A) this;
  }
  
  public CloudConfigNested<A> withNewCloudConfig() {
    return new CloudConfigNested(null);
  }
  
  public A withNewCloudConfig(String key,String name) {
    return (A) this.withCloudConfig(new ConfigMapFileReference(key, name));
  }
  
  public CloudConfigNested<A> withNewCloudConfigLike(ConfigMapFileReference item) {
    return new CloudConfigNested(item);
  }
  
  public PlatformSpecNested<A> withNewPlatformSpec() {
    return new PlatformSpecNested(null);
  }
  
  public PlatformSpecNested<A> withNewPlatformSpecLike(PlatformSpec item) {
    return new PlatformSpecNested(item);
  }
  
  public A withPlatformSpec(PlatformSpec platformSpec) {
    this._visitables.remove("platformSpec");
    if (platformSpec != null) {
        this.platformSpec = new PlatformSpecBuilder(platformSpec);
        this._visitables.get("platformSpec").add(this.platformSpec);
    } else {
        this.platformSpec = null;
        this._visitables.get("platformSpec").remove(this.platformSpec);
    }
    return (A) this;
  }
  public class CloudConfigNested<N> extends ConfigMapFileReferenceFluent<CloudConfigNested<N>> implements Nested<N>{
  
    ConfigMapFileReferenceBuilder builder;
  
    CloudConfigNested(ConfigMapFileReference item) {
      this.builder = new ConfigMapFileReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) InfrastructureSpecFluent.this.withCloudConfig(builder.build());
    }
    
    public N endCloudConfig() {
      return and();
    }
    
  }
  public class PlatformSpecNested<N> extends PlatformSpecFluent<PlatformSpecNested<N>> implements Nested<N>{
  
    PlatformSpecBuilder builder;
  
    PlatformSpecNested(PlatformSpec item) {
      this.builder = new PlatformSpecBuilder(this, item);
    }
  
    public N and() {
      return (N) InfrastructureSpecFluent.this.withPlatformSpec(builder.build());
    }
    
    public N endPlatformSpec() {
      return and();
    }
    
  }
}