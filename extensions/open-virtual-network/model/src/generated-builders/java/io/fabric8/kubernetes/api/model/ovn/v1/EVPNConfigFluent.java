package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class EVPNConfigFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.EVPNConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VRFConfigBuilder ipVRF;
  private VRFConfigBuilder macVRF;
  private String vtep;

  public EVPNConfigFluent() {
  }
  
  public EVPNConfigFluent(EVPNConfig instance) {
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
  
  public VRFConfig buildIpVRF() {
    return this.ipVRF != null ? this.ipVRF.build() : null;
  }
  
  public VRFConfig buildMacVRF() {
    return this.macVRF != null ? this.macVRF.build() : null;
  }
  
  protected void copyInstance(EVPNConfig instance) {
    instance = instance != null ? instance : new EVPNConfig();
    if (instance != null) {
        this.withIpVRF(instance.getIpVRF());
        this.withMacVRF(instance.getMacVRF());
        this.withVtep(instance.getVtep());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IpVRFNested<A> editIpVRF() {
    return this.withNewIpVRFLike(Optional.ofNullable(this.buildIpVRF()).orElse(null));
  }
  
  public MacVRFNested<A> editMacVRF() {
    return this.withNewMacVRFLike(Optional.ofNullable(this.buildMacVRF()).orElse(null));
  }
  
  public IpVRFNested<A> editOrNewIpVRF() {
    return this.withNewIpVRFLike(Optional.ofNullable(this.buildIpVRF()).orElse(new VRFConfigBuilder().build()));
  }
  
  public IpVRFNested<A> editOrNewIpVRFLike(VRFConfig item) {
    return this.withNewIpVRFLike(Optional.ofNullable(this.buildIpVRF()).orElse(item));
  }
  
  public MacVRFNested<A> editOrNewMacVRF() {
    return this.withNewMacVRFLike(Optional.ofNullable(this.buildMacVRF()).orElse(new VRFConfigBuilder().build()));
  }
  
  public MacVRFNested<A> editOrNewMacVRFLike(VRFConfig item) {
    return this.withNewMacVRFLike(Optional.ofNullable(this.buildMacVRF()).orElse(item));
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
    EVPNConfigFluent that = (EVPNConfigFluent) o;
    if (!(Objects.equals(ipVRF, that.ipVRF))) {
      return false;
    }
    if (!(Objects.equals(macVRF, that.macVRF))) {
      return false;
    }
    if (!(Objects.equals(vtep, that.vtep))) {
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
  
  public String getVtep() {
    return this.vtep;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpVRF() {
    return this.ipVRF != null;
  }
  
  public boolean hasMacVRF() {
    return this.macVRF != null;
  }
  
  public boolean hasVtep() {
    return this.vtep != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipVRF, macVRF, vtep, additionalProperties);
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
    if (!(ipVRF == null)) {
        sb.append("ipVRF:");
        sb.append(ipVRF);
        sb.append(",");
    }
    if (!(macVRF == null)) {
        sb.append("macVRF:");
        sb.append(macVRF);
        sb.append(",");
    }
    if (!(vtep == null)) {
        sb.append("vtep:");
        sb.append(vtep);
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
  
  public A withIpVRF(VRFConfig ipVRF) {
    this._visitables.remove("ipVRF");
    if (ipVRF != null) {
        this.ipVRF = new VRFConfigBuilder(ipVRF);
        this._visitables.get("ipVRF").add(this.ipVRF);
    } else {
        this.ipVRF = null;
        this._visitables.get("ipVRF").remove(this.ipVRF);
    }
    return (A) this;
  }
  
  public A withMacVRF(VRFConfig macVRF) {
    this._visitables.remove("macVRF");
    if (macVRF != null) {
        this.macVRF = new VRFConfigBuilder(macVRF);
        this._visitables.get("macVRF").add(this.macVRF);
    } else {
        this.macVRF = null;
        this._visitables.get("macVRF").remove(this.macVRF);
    }
    return (A) this;
  }
  
  public IpVRFNested<A> withNewIpVRF() {
    return new IpVRFNested(null);
  }
  
  public A withNewIpVRF(String routeTarget,Integer vni) {
    return (A) this.withIpVRF(new VRFConfig(routeTarget, vni));
  }
  
  public IpVRFNested<A> withNewIpVRFLike(VRFConfig item) {
    return new IpVRFNested(item);
  }
  
  public MacVRFNested<A> withNewMacVRF() {
    return new MacVRFNested(null);
  }
  
  public A withNewMacVRF(String routeTarget,Integer vni) {
    return (A) this.withMacVRF(new VRFConfig(routeTarget, vni));
  }
  
  public MacVRFNested<A> withNewMacVRFLike(VRFConfig item) {
    return new MacVRFNested(item);
  }
  
  public A withVtep(String vtep) {
    this.vtep = vtep;
    return (A) this;
  }
  public class IpVRFNested<N> extends VRFConfigFluent<IpVRFNested<N>> implements Nested<N>{
  
    VRFConfigBuilder builder;
  
    IpVRFNested(VRFConfig item) {
      this.builder = new VRFConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EVPNConfigFluent.this.withIpVRF(builder.build());
    }
    
    public N endIpVRF() {
      return and();
    }
    
  }
  public class MacVRFNested<N> extends VRFConfigFluent<MacVRFNested<N>> implements Nested<N>{
  
    VRFConfigBuilder builder;
  
    MacVRFNested(VRFConfig item) {
      this.builder = new VRFConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EVPNConfigFluent.this.withMacVRF(builder.build());
    }
    
    public N endMacVRF() {
      return and();
    }
    
  }
}