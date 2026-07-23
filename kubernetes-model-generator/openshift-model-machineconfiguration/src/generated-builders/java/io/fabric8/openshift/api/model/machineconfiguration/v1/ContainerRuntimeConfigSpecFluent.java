package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class ContainerRuntimeConfigSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.ContainerRuntimeConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ContainerRuntimeConfigurationBuilder containerRuntimeConfig;
  private LabelSelectorBuilder machineConfigPoolSelector;

  public ContainerRuntimeConfigSpecFluent() {
  }
  
  public ContainerRuntimeConfigSpecFluent(ContainerRuntimeConfigSpec instance) {
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
  
  public ContainerRuntimeConfiguration buildContainerRuntimeConfig() {
    return this.containerRuntimeConfig != null ? this.containerRuntimeConfig.build() : null;
  }
  
  public LabelSelector buildMachineConfigPoolSelector() {
    return this.machineConfigPoolSelector != null ? this.machineConfigPoolSelector.build() : null;
  }
  
  protected void copyInstance(ContainerRuntimeConfigSpec instance) {
    instance = instance != null ? instance : new ContainerRuntimeConfigSpec();
    if (instance != null) {
        this.withContainerRuntimeConfig(instance.getContainerRuntimeConfig());
        this.withMachineConfigPoolSelector(instance.getMachineConfigPoolSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerRuntimeConfigNested<A> editContainerRuntimeConfig() {
    return this.withNewContainerRuntimeConfigLike(Optional.ofNullable(this.buildContainerRuntimeConfig()).orElse(null));
  }
  
  public MachineConfigPoolSelectorNested<A> editMachineConfigPoolSelector() {
    return this.withNewMachineConfigPoolSelectorLike(Optional.ofNullable(this.buildMachineConfigPoolSelector()).orElse(null));
  }
  
  public ContainerRuntimeConfigNested<A> editOrNewContainerRuntimeConfig() {
    return this.withNewContainerRuntimeConfigLike(Optional.ofNullable(this.buildContainerRuntimeConfig()).orElse(new ContainerRuntimeConfigurationBuilder().build()));
  }
  
  public ContainerRuntimeConfigNested<A> editOrNewContainerRuntimeConfigLike(ContainerRuntimeConfiguration item) {
    return this.withNewContainerRuntimeConfigLike(Optional.ofNullable(this.buildContainerRuntimeConfig()).orElse(item));
  }
  
  public MachineConfigPoolSelectorNested<A> editOrNewMachineConfigPoolSelector() {
    return this.withNewMachineConfigPoolSelectorLike(Optional.ofNullable(this.buildMachineConfigPoolSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public MachineConfigPoolSelectorNested<A> editOrNewMachineConfigPoolSelectorLike(LabelSelector item) {
    return this.withNewMachineConfigPoolSelectorLike(Optional.ofNullable(this.buildMachineConfigPoolSelector()).orElse(item));
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
    ContainerRuntimeConfigSpecFluent that = (ContainerRuntimeConfigSpecFluent) o;
    if (!(Objects.equals(containerRuntimeConfig, that.containerRuntimeConfig))) {
      return false;
    }
    if (!(Objects.equals(machineConfigPoolSelector, that.machineConfigPoolSelector))) {
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
  
  public boolean hasContainerRuntimeConfig() {
    return this.containerRuntimeConfig != null;
  }
  
  public boolean hasMachineConfigPoolSelector() {
    return this.machineConfigPoolSelector != null;
  }
  
  public int hashCode() {
    return Objects.hash(containerRuntimeConfig, machineConfigPoolSelector, additionalProperties);
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
    if (!(containerRuntimeConfig == null)) {
        sb.append("containerRuntimeConfig:");
        sb.append(containerRuntimeConfig);
        sb.append(",");
    }
    if (!(machineConfigPoolSelector == null)) {
        sb.append("machineConfigPoolSelector:");
        sb.append(machineConfigPoolSelector);
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
  
  public A withContainerRuntimeConfig(ContainerRuntimeConfiguration containerRuntimeConfig) {
    this._visitables.remove("containerRuntimeConfig");
    if (containerRuntimeConfig != null) {
        this.containerRuntimeConfig = new ContainerRuntimeConfigurationBuilder(containerRuntimeConfig);
        this._visitables.get("containerRuntimeConfig").add(this.containerRuntimeConfig);
    } else {
        this.containerRuntimeConfig = null;
        this._visitables.get("containerRuntimeConfig").remove(this.containerRuntimeConfig);
    }
    return (A) this;
  }
  
  public A withMachineConfigPoolSelector(LabelSelector machineConfigPoolSelector) {
    this._visitables.remove("machineConfigPoolSelector");
    if (machineConfigPoolSelector != null) {
        this.machineConfigPoolSelector = new LabelSelectorBuilder(machineConfigPoolSelector);
        this._visitables.get("machineConfigPoolSelector").add(this.machineConfigPoolSelector);
    } else {
        this.machineConfigPoolSelector = null;
        this._visitables.get("machineConfigPoolSelector").remove(this.machineConfigPoolSelector);
    }
    return (A) this;
  }
  
  public ContainerRuntimeConfigNested<A> withNewContainerRuntimeConfig() {
    return new ContainerRuntimeConfigNested(null);
  }
  
  public ContainerRuntimeConfigNested<A> withNewContainerRuntimeConfigLike(ContainerRuntimeConfiguration item) {
    return new ContainerRuntimeConfigNested(item);
  }
  
  public MachineConfigPoolSelectorNested<A> withNewMachineConfigPoolSelector() {
    return new MachineConfigPoolSelectorNested(null);
  }
  
  public MachineConfigPoolSelectorNested<A> withNewMachineConfigPoolSelectorLike(LabelSelector item) {
    return new MachineConfigPoolSelectorNested(item);
  }
  public class ContainerRuntimeConfigNested<N> extends ContainerRuntimeConfigurationFluent<ContainerRuntimeConfigNested<N>> implements Nested<N>{
  
    ContainerRuntimeConfigurationBuilder builder;
  
    ContainerRuntimeConfigNested(ContainerRuntimeConfiguration item) {
      this.builder = new ContainerRuntimeConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerRuntimeConfigSpecFluent.this.withContainerRuntimeConfig(builder.build());
    }
    
    public N endContainerRuntimeConfig() {
      return and();
    }
    
  }
  public class MachineConfigPoolSelectorNested<N> extends LabelSelectorFluent<MachineConfigPoolSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    MachineConfigPoolSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ContainerRuntimeConfigSpecFluent.this.withMachineConfigPoolSelector(builder.build());
    }
    
    public N endMachineConfigPoolSelector() {
      return and();
    }
    
  }
}