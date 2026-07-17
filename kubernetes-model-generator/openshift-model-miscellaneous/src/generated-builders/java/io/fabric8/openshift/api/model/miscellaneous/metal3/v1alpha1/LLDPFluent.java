package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class LLDPFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.LLDPFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String portID;
  private String switchID;
  private String switchSystemName;

  public LLDPFluent() {
  }
  
  public LLDPFluent(LLDP instance) {
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
  
  protected void copyInstance(LLDP instance) {
    instance = instance != null ? instance : new LLDP();
    if (instance != null) {
        this.withPortID(instance.getPortID());
        this.withSwitchID(instance.getSwitchID());
        this.withSwitchSystemName(instance.getSwitchSystemName());
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
    LLDPFluent that = (LLDPFluent) o;
    if (!(Objects.equals(portID, that.portID))) {
      return false;
    }
    if (!(Objects.equals(switchID, that.switchID))) {
      return false;
    }
    if (!(Objects.equals(switchSystemName, that.switchSystemName))) {
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
  
  public String getPortID() {
    return this.portID;
  }
  
  public String getSwitchID() {
    return this.switchID;
  }
  
  public String getSwitchSystemName() {
    return this.switchSystemName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasPortID() {
    return this.portID != null;
  }
  
  public boolean hasSwitchID() {
    return this.switchID != null;
  }
  
  public boolean hasSwitchSystemName() {
    return this.switchSystemName != null;
  }
  
  public int hashCode() {
    return Objects.hash(portID, switchID, switchSystemName, additionalProperties);
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
    if (!(portID == null)) {
        sb.append("portID:");
        sb.append(portID);
        sb.append(",");
    }
    if (!(switchID == null)) {
        sb.append("switchID:");
        sb.append(switchID);
        sb.append(",");
    }
    if (!(switchSystemName == null)) {
        sb.append("switchSystemName:");
        sb.append(switchSystemName);
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
  
  public A withPortID(String portID) {
    this.portID = portID;
    return (A) this;
  }
  
  public A withSwitchID(String switchID) {
    this.switchID = switchID;
    return (A) this;
  }
  
  public A withSwitchSystemName(String switchSystemName) {
    this.switchSystemName = switchSystemName;
    return (A) this;
  }
  
}