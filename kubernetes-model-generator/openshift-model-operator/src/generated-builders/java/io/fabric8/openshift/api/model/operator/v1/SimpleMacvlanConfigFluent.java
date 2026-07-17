package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class SimpleMacvlanConfigFluent<A extends io.fabric8.openshift.api.model.operator.v1.SimpleMacvlanConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private IPAMConfigBuilder ipamConfig;
  private String master;
  private String mode;
  private Long mtu;

  public SimpleMacvlanConfigFluent() {
  }
  
  public SimpleMacvlanConfigFluent(SimpleMacvlanConfig instance) {
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
  
  public IPAMConfig buildIpamConfig() {
    return this.ipamConfig != null ? this.ipamConfig.build() : null;
  }
  
  protected void copyInstance(SimpleMacvlanConfig instance) {
    instance = instance != null ? instance : new SimpleMacvlanConfig();
    if (instance != null) {
        this.withIpamConfig(instance.getIpamConfig());
        this.withMaster(instance.getMaster());
        this.withMode(instance.getMode());
        this.withMtu(instance.getMtu());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IpamConfigNested<A> editIpamConfig() {
    return this.withNewIpamConfigLike(Optional.ofNullable(this.buildIpamConfig()).orElse(null));
  }
  
  public IpamConfigNested<A> editOrNewIpamConfig() {
    return this.withNewIpamConfigLike(Optional.ofNullable(this.buildIpamConfig()).orElse(new IPAMConfigBuilder().build()));
  }
  
  public IpamConfigNested<A> editOrNewIpamConfigLike(IPAMConfig item) {
    return this.withNewIpamConfigLike(Optional.ofNullable(this.buildIpamConfig()).orElse(item));
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
    SimpleMacvlanConfigFluent that = (SimpleMacvlanConfigFluent) o;
    if (!(Objects.equals(ipamConfig, that.ipamConfig))) {
      return false;
    }
    if (!(Objects.equals(master, that.master))) {
      return false;
    }
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
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
  
  public String getMaster() {
    return this.master;
  }
  
  public String getMode() {
    return this.mode;
  }
  
  public Long getMtu() {
    return this.mtu;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasIpamConfig() {
    return this.ipamConfig != null;
  }
  
  public boolean hasMaster() {
    return this.master != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public int hashCode() {
    return Objects.hash(ipamConfig, master, mode, mtu, additionalProperties);
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
    if (!(ipamConfig == null)) {
        sb.append("ipamConfig:");
        sb.append(ipamConfig);
        sb.append(",");
    }
    if (!(master == null)) {
        sb.append("master:");
        sb.append(master);
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
  
  public A withIpamConfig(IPAMConfig ipamConfig) {
    this._visitables.remove("ipamConfig");
    if (ipamConfig != null) {
        this.ipamConfig = new IPAMConfigBuilder(ipamConfig);
        this._visitables.get("ipamConfig").add(this.ipamConfig);
    } else {
        this.ipamConfig = null;
        this._visitables.get("ipamConfig").remove(this.ipamConfig);
    }
    return (A) this;
  }
  
  public A withMaster(String master) {
    this.master = master;
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
  
  public IpamConfigNested<A> withNewIpamConfig() {
    return new IpamConfigNested(null);
  }
  
  public IpamConfigNested<A> withNewIpamConfigLike(IPAMConfig item) {
    return new IpamConfigNested(item);
  }
  public class IpamConfigNested<N> extends IPAMConfigFluent<IpamConfigNested<N>> implements Nested<N>{
  
    IPAMConfigBuilder builder;
  
    IpamConfigNested(IPAMConfig item) {
      this.builder = new IPAMConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SimpleMacvlanConfigFluent.this.withIpamConfig(builder.build());
    }
    
    public N endIpamConfig() {
      return and();
    }
    
  }
}