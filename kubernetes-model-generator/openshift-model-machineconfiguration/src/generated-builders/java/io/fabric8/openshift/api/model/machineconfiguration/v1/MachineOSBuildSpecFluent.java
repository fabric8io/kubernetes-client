package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class MachineOSBuildSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineOSBuildSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MachineConfigReferenceBuilder machineConfig;
  private MachineOSConfigReferenceBuilder machineOSConfig;
  private String renderedImagePushSpec;

  public MachineOSBuildSpecFluent() {
  }
  
  public MachineOSBuildSpecFluent(MachineOSBuildSpec instance) {
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
  
  public MachineConfigReference buildMachineConfig() {
    return this.machineConfig != null ? this.machineConfig.build() : null;
  }
  
  public MachineOSConfigReference buildMachineOSConfig() {
    return this.machineOSConfig != null ? this.machineOSConfig.build() : null;
  }
  
  protected void copyInstance(MachineOSBuildSpec instance) {
    instance = instance != null ? instance : new MachineOSBuildSpec();
    if (instance != null) {
        this.withMachineConfig(instance.getMachineConfig());
        this.withMachineOSConfig(instance.getMachineOSConfig());
        this.withRenderedImagePushSpec(instance.getRenderedImagePushSpec());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MachineConfigNested<A> editMachineConfig() {
    return this.withNewMachineConfigLike(Optional.ofNullable(this.buildMachineConfig()).orElse(null));
  }
  
  public MachineOSConfigNested<A> editMachineOSConfig() {
    return this.withNewMachineOSConfigLike(Optional.ofNullable(this.buildMachineOSConfig()).orElse(null));
  }
  
  public MachineConfigNested<A> editOrNewMachineConfig() {
    return this.withNewMachineConfigLike(Optional.ofNullable(this.buildMachineConfig()).orElse(new MachineConfigReferenceBuilder().build()));
  }
  
  public MachineConfigNested<A> editOrNewMachineConfigLike(MachineConfigReference item) {
    return this.withNewMachineConfigLike(Optional.ofNullable(this.buildMachineConfig()).orElse(item));
  }
  
  public MachineOSConfigNested<A> editOrNewMachineOSConfig() {
    return this.withNewMachineOSConfigLike(Optional.ofNullable(this.buildMachineOSConfig()).orElse(new MachineOSConfigReferenceBuilder().build()));
  }
  
  public MachineOSConfigNested<A> editOrNewMachineOSConfigLike(MachineOSConfigReference item) {
    return this.withNewMachineOSConfigLike(Optional.ofNullable(this.buildMachineOSConfig()).orElse(item));
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
    MachineOSBuildSpecFluent that = (MachineOSBuildSpecFluent) o;
    if (!(Objects.equals(machineConfig, that.machineConfig))) {
      return false;
    }
    if (!(Objects.equals(machineOSConfig, that.machineOSConfig))) {
      return false;
    }
    if (!(Objects.equals(renderedImagePushSpec, that.renderedImagePushSpec))) {
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
  
  public String getRenderedImagePushSpec() {
    return this.renderedImagePushSpec;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMachineConfig() {
    return this.machineConfig != null;
  }
  
  public boolean hasMachineOSConfig() {
    return this.machineOSConfig != null;
  }
  
  public boolean hasRenderedImagePushSpec() {
    return this.renderedImagePushSpec != null;
  }
  
  public int hashCode() {
    return Objects.hash(machineConfig, machineOSConfig, renderedImagePushSpec, additionalProperties);
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
    if (!(machineConfig == null)) {
        sb.append("machineConfig:");
        sb.append(machineConfig);
        sb.append(",");
    }
    if (!(machineOSConfig == null)) {
        sb.append("machineOSConfig:");
        sb.append(machineOSConfig);
        sb.append(",");
    }
    if (!(renderedImagePushSpec == null)) {
        sb.append("renderedImagePushSpec:");
        sb.append(renderedImagePushSpec);
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
  
  public A withMachineConfig(MachineConfigReference machineConfig) {
    this._visitables.remove("machineConfig");
    if (machineConfig != null) {
        this.machineConfig = new MachineConfigReferenceBuilder(machineConfig);
        this._visitables.get("machineConfig").add(this.machineConfig);
    } else {
        this.machineConfig = null;
        this._visitables.get("machineConfig").remove(this.machineConfig);
    }
    return (A) this;
  }
  
  public A withMachineOSConfig(MachineOSConfigReference machineOSConfig) {
    this._visitables.remove("machineOSConfig");
    if (machineOSConfig != null) {
        this.machineOSConfig = new MachineOSConfigReferenceBuilder(machineOSConfig);
        this._visitables.get("machineOSConfig").add(this.machineOSConfig);
    } else {
        this.machineOSConfig = null;
        this._visitables.get("machineOSConfig").remove(this.machineOSConfig);
    }
    return (A) this;
  }
  
  public MachineConfigNested<A> withNewMachineConfig() {
    return new MachineConfigNested(null);
  }
  
  public A withNewMachineConfig(String name) {
    return (A) this.withMachineConfig(new MachineConfigReference(name));
  }
  
  public MachineConfigNested<A> withNewMachineConfigLike(MachineConfigReference item) {
    return new MachineConfigNested(item);
  }
  
  public MachineOSConfigNested<A> withNewMachineOSConfig() {
    return new MachineOSConfigNested(null);
  }
  
  public A withNewMachineOSConfig(String name) {
    return (A) this.withMachineOSConfig(new MachineOSConfigReference(name));
  }
  
  public MachineOSConfigNested<A> withNewMachineOSConfigLike(MachineOSConfigReference item) {
    return new MachineOSConfigNested(item);
  }
  
  public A withRenderedImagePushSpec(String renderedImagePushSpec) {
    this.renderedImagePushSpec = renderedImagePushSpec;
    return (A) this;
  }
  public class MachineConfigNested<N> extends MachineConfigReferenceFluent<MachineConfigNested<N>> implements Nested<N>{
  
    MachineConfigReferenceBuilder builder;
  
    MachineConfigNested(MachineConfigReference item) {
      this.builder = new MachineConfigReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSBuildSpecFluent.this.withMachineConfig(builder.build());
    }
    
    public N endMachineConfig() {
      return and();
    }
    
  }
  public class MachineOSConfigNested<N> extends MachineOSConfigReferenceFluent<MachineOSConfigNested<N>> implements Nested<N>{
  
    MachineOSConfigReferenceBuilder builder;
  
    MachineOSConfigNested(MachineOSConfigReference item) {
      this.builder = new MachineOSConfigReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSBuildSpecFluent.this.withMachineOSConfig(builder.build());
    }
    
    public N endMachineOSConfig() {
      return and();
    }
    
  }
}