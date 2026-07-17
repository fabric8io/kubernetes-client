package io.fabric8.openshift.api.model.miscellaneous.network.v1;

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
public class EgressNetworkPolicyPeerFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1.EgressNetworkPolicyPeerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String cidrSelector;
  private String dnsName;

  public EgressNetworkPolicyPeerFluent() {
  }
  
  public EgressNetworkPolicyPeerFluent(EgressNetworkPolicyPeer instance) {
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
  
  protected void copyInstance(EgressNetworkPolicyPeer instance) {
    instance = instance != null ? instance : new EgressNetworkPolicyPeer();
    if (instance != null) {
        this.withCidrSelector(instance.getCidrSelector());
        this.withDnsName(instance.getDnsName());
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
    EgressNetworkPolicyPeerFluent that = (EgressNetworkPolicyPeerFluent) o;
    if (!(Objects.equals(cidrSelector, that.cidrSelector))) {
      return false;
    }
    if (!(Objects.equals(dnsName, that.dnsName))) {
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
  
  public String getCidrSelector() {
    return this.cidrSelector;
  }
  
  public String getDnsName() {
    return this.dnsName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCidrSelector() {
    return this.cidrSelector != null;
  }
  
  public boolean hasDnsName() {
    return this.dnsName != null;
  }
  
  public int hashCode() {
    return Objects.hash(cidrSelector, dnsName, additionalProperties);
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
    if (!(cidrSelector == null)) {
        sb.append("cidrSelector:");
        sb.append(cidrSelector);
        sb.append(",");
    }
    if (!(dnsName == null)) {
        sb.append("dnsName:");
        sb.append(dnsName);
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
  
  public A withCidrSelector(String cidrSelector) {
    this.cidrSelector = cidrSelector;
    return (A) this;
  }
  
  public A withDnsName(String dnsName) {
    this.dnsName = dnsName;
    return (A) this;
  }
  
}