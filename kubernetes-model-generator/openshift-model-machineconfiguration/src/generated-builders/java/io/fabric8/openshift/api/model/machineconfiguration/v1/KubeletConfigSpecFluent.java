package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.openshift.api.model.config.v1.TLSSecurityProfile;
import java.lang.Boolean;
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
public class KubeletConfigSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.KubeletConfigSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean autoSizingReserved;
  private Object kubeletConfig;
  private Integer logLevel;
  private LabelSelectorBuilder machineConfigPoolSelector;
  private TLSSecurityProfile tlsSecurityProfile;

  public KubeletConfigSpecFluent() {
  }
  
  public KubeletConfigSpecFluent(KubeletConfigSpec instance) {
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
  
  public LabelSelector buildMachineConfigPoolSelector() {
    return this.machineConfigPoolSelector != null ? this.machineConfigPoolSelector.build() : null;
  }
  
  protected void copyInstance(KubeletConfigSpec instance) {
    instance = instance != null ? instance : new KubeletConfigSpec();
    if (instance != null) {
        this.withAutoSizingReserved(instance.getAutoSizingReserved());
        this.withKubeletConfig(instance.getKubeletConfig());
        this.withLogLevel(instance.getLogLevel());
        this.withMachineConfigPoolSelector(instance.getMachineConfigPoolSelector());
        this.withTlsSecurityProfile(instance.getTlsSecurityProfile());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MachineConfigPoolSelectorNested<A> editMachineConfigPoolSelector() {
    return this.withNewMachineConfigPoolSelectorLike(Optional.ofNullable(this.buildMachineConfigPoolSelector()).orElse(null));
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
    KubeletConfigSpecFluent that = (KubeletConfigSpecFluent) o;
    if (!(Objects.equals(autoSizingReserved, that.autoSizingReserved))) {
      return false;
    }
    if (!(Objects.equals(kubeletConfig, that.kubeletConfig))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(machineConfigPoolSelector, that.machineConfigPoolSelector))) {
      return false;
    }
    if (!(Objects.equals(tlsSecurityProfile, that.tlsSecurityProfile))) {
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
  
  public Boolean getAutoSizingReserved() {
    return this.autoSizingReserved;
  }
  
  public Object getKubeletConfig() {
    return this.kubeletConfig;
  }
  
  public Integer getLogLevel() {
    return this.logLevel;
  }
  
  public TLSSecurityProfile getTlsSecurityProfile() {
    return this.tlsSecurityProfile;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAutoSizingReserved() {
    return this.autoSizingReserved != null;
  }
  
  public boolean hasKubeletConfig() {
    return this.kubeletConfig != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasMachineConfigPoolSelector() {
    return this.machineConfigPoolSelector != null;
  }
  
  public boolean hasTlsSecurityProfile() {
    return this.tlsSecurityProfile != null;
  }
  
  public int hashCode() {
    return Objects.hash(autoSizingReserved, kubeletConfig, logLevel, machineConfigPoolSelector, tlsSecurityProfile, additionalProperties);
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
    if (!(autoSizingReserved == null)) {
        sb.append("autoSizingReserved:");
        sb.append(autoSizingReserved);
        sb.append(",");
    }
    if (!(kubeletConfig == null)) {
        sb.append("kubeletConfig:");
        sb.append(kubeletConfig);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(machineConfigPoolSelector == null)) {
        sb.append("machineConfigPoolSelector:");
        sb.append(machineConfigPoolSelector);
        sb.append(",");
    }
    if (!(tlsSecurityProfile == null)) {
        sb.append("tlsSecurityProfile:");
        sb.append(tlsSecurityProfile);
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
  
  public A withAutoSizingReserved() {
    return withAutoSizingReserved(true);
  }
  
  public A withAutoSizingReserved(Boolean autoSizingReserved) {
    this.autoSizingReserved = autoSizingReserved;
    return (A) this;
  }
  
  public A withKubeletConfig(Object kubeletConfig) {
    this.kubeletConfig = kubeletConfig;
    return (A) this;
  }
  
  public A withLogLevel(Integer logLevel) {
    this.logLevel = logLevel;
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
  
  public MachineConfigPoolSelectorNested<A> withNewMachineConfigPoolSelector() {
    return new MachineConfigPoolSelectorNested(null);
  }
  
  public MachineConfigPoolSelectorNested<A> withNewMachineConfigPoolSelectorLike(LabelSelector item) {
    return new MachineConfigPoolSelectorNested(item);
  }
  
  public A withTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
    this.tlsSecurityProfile = tlsSecurityProfile;
    return (A) this;
  }
  public class MachineConfigPoolSelectorNested<N> extends LabelSelectorFluent<MachineConfigPoolSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    MachineConfigPoolSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) KubeletConfigSpecFluent.this.withMachineConfigPoolSelector(builder.build());
    }
    
    public N endMachineConfigPoolSelector() {
      return and();
    }
    
  }
}