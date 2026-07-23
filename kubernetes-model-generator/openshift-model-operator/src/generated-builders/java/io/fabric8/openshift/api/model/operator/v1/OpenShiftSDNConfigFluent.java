package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OpenShiftSDNConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.OpenShiftSDNConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean enableUnidling;
  private String mode;
  private Long mtu;
  private Boolean useExternalOpenvswitch;
  private Long vxlanPort;

  public OpenShiftSDNConfigFluent() {
  }
  
  public OpenShiftSDNConfigFluent(OpenShiftSDNConfig instance) {
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
  
  protected void copyInstance(OpenShiftSDNConfig instance) {
    instance = instance != null ? instance : new OpenShiftSDNConfig();
    if (instance != null) {
        this.withEnableUnidling(instance.getEnableUnidling());
        this.withMode(instance.getMode());
        this.withMtu(instance.getMtu());
        this.withUseExternalOpenvswitch(instance.getUseExternalOpenvswitch());
        this.withVxlanPort(instance.getVxlanPort());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    OpenShiftSDNConfigFluent that = (OpenShiftSDNConfigFluent) o;
    if (!(Objects.equals(enableUnidling, that.enableUnidling))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(useExternalOpenvswitch, that.useExternalOpenvswitch))) {
      return false;
    }
    if (!(Objects.equals(vxlanPort, that.vxlanPort))) {
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
  
  public Boolean getEnableUnidling() {
    return this.enableUnidling;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public Long getMtu() {
    return this.mtu;
  }
  
  public Boolean getUseExternalOpenvswitch() {
    return this.useExternalOpenvswitch;
  }
  
  public Long getVxlanPort() {
    return this.vxlanPort;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnableUnidling() {
    return this.enableUnidling != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasUseExternalOpenvswitch() {
    return this.useExternalOpenvswitch != null;
  }
  
  public boolean hasVxlanPort() {
    return this.vxlanPort != null;
  }
  
  public int hashCode() {
    return Objects.hash(enableUnidling, mode, mtu, useExternalOpenvswitch, vxlanPort, additionalProperties);
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
    if (!(enableUnidling == null)) {
        sb.append("enableUnidling:");
        sb.append(enableUnidling);
        sb.append(",");
    }
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(useExternalOpenvswitch == null)) {
        sb.append("useExternalOpenvswitch:");
        sb.append(useExternalOpenvswitch);
        sb.append(",");
    }
    if (!(vxlanPort == null)) {
        sb.append("vxlanPort:");
        sb.append(vxlanPort);
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
  
  public A withEnableUnidling() {
    return withEnableUnidling(true);
  }
  
  public A withEnableUnidling(Boolean enableUnidling) {
    this.enableUnidling = enableUnidling;
    return (A) this;
  }
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public A withMtu(Long mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public A withUseExternalOpenvswitch() {
    return withUseExternalOpenvswitch(true);
  }
  
  public A withUseExternalOpenvswitch(Boolean useExternalOpenvswitch) {
    this.useExternalOpenvswitch = useExternalOpenvswitch;
    return (A) this;
  }
  
  public A withVxlanPort(Long vxlanPort) {
    this.vxlanPort = vxlanPort;
    return (A) this;
  }
  
}