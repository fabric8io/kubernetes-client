package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
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
public class VSphereFailureDomainHostGroupFluent<A extends io.fabric8.openshift.api.model.config.v1.VSphereFailureDomainHostGroupFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String hostGroup;
  private String vmGroup;
  private String vmHostRule;

  public VSphereFailureDomainHostGroupFluent() {
  }
  
  public VSphereFailureDomainHostGroupFluent(VSphereFailureDomainHostGroup instance) {
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
  
  protected void copyInstance(VSphereFailureDomainHostGroup instance) {
    instance = instance != null ? instance : new VSphereFailureDomainHostGroup();
    if (instance != null) {
        this.withHostGroup(instance.getHostGroup());
        this.withVmGroup(instance.getVmGroup());
        this.withVmHostRule(instance.getVmHostRule());
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
    VSphereFailureDomainHostGroupFluent that = (VSphereFailureDomainHostGroupFluent) o;
    if (!(Objects.equals(hostGroup, that.hostGroup))) {
      return false;
    }
    if (!(Objects.equals(vmGroup, that.vmGroup))) {
      return false;
    }
    if (!(Objects.equals(vmHostRule, that.vmHostRule))) {
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
  
  public String getHostGroup() {
    return this.hostGroup;
  }
  
  public String getVmGroup() {
    return this.vmGroup;
  }
  
  public String getVmHostRule() {
    return this.vmHostRule;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostGroup() {
    return this.hostGroup != null;
  }
  
  public boolean hasVmGroup() {
    return this.vmGroup != null;
  }
  
  public boolean hasVmHostRule() {
    return this.vmHostRule != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostGroup, vmGroup, vmHostRule, additionalProperties);
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
    if (!(hostGroup == null)) {
        sb.append("hostGroup:");
        sb.append(hostGroup);
        sb.append(",");
    }
    if (!(vmGroup == null)) {
        sb.append("vmGroup:");
        sb.append(vmGroup);
        sb.append(",");
    }
    if (!(vmHostRule == null)) {
        sb.append("vmHostRule:");
        sb.append(vmHostRule);
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
  
  public A withHostGroup(String hostGroup) {
    this.hostGroup = hostGroup;
    return (A) this;
  }
  
  public A withVmGroup(String vmGroup) {
    this.vmGroup = vmGroup;
    return (A) this;
  }
  
  public A withVmHostRule(String vmHostRule) {
    this.vmHostRule = vmHostRule;
    return (A) this;
  }
  
}