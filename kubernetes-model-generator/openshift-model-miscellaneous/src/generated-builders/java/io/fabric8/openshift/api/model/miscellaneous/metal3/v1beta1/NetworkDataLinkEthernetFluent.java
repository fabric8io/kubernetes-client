package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class NetworkDataLinkEthernetFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataLinkEthernetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String id;
  private NetworkLinkEthernetMacBuilder macAddress;
  private Integer mtu;
  private String name;
  private String type;

  public NetworkDataLinkEthernetFluent() {
  }
  
  public NetworkDataLinkEthernetFluent(NetworkDataLinkEthernet instance) {
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
  
  public NetworkLinkEthernetMac buildMacAddress() {
    return this.macAddress != null ? this.macAddress.build() : null;
  }
  
  protected void copyInstance(NetworkDataLinkEthernet instance) {
    instance = instance != null ? instance : new NetworkDataLinkEthernet();
    if (instance != null) {
        this.withId(instance.getId());
        this.withMacAddress(instance.getMacAddress());
        this.withMtu(instance.getMtu());
        this.withName(instance.getName());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MacAddressNested<A> editMacAddress() {
    return this.withNewMacAddressLike(Optional.ofNullable(this.buildMacAddress()).orElse(null));
  }
  
  public MacAddressNested<A> editOrNewMacAddress() {
    return this.withNewMacAddressLike(Optional.ofNullable(this.buildMacAddress()).orElse(new NetworkLinkEthernetMacBuilder().build()));
  }
  
  public MacAddressNested<A> editOrNewMacAddressLike(NetworkLinkEthernetMac item) {
    return this.withNewMacAddressLike(Optional.ofNullable(this.buildMacAddress()).orElse(item));
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
    NetworkDataLinkEthernetFluent that = (NetworkDataLinkEthernetFluent) o;
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(macAddress, that.macAddress))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getId() {
    return this.id;
  }
  
  public Integer getMtu() {
    return this.mtu;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasMacAddress() {
    return this.macAddress != null;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(id, macAddress, mtu, name, type, additionalProperties);
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
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(macAddress == null)) {
        sb.append("macAddress:");
        sb.append(macAddress);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withMacAddress(NetworkLinkEthernetMac macAddress) {
    this._visitables.remove("macAddress");
    if (macAddress != null) {
        this.macAddress = new NetworkLinkEthernetMacBuilder(macAddress);
        this._visitables.get("macAddress").add(this.macAddress);
    } else {
        this.macAddress = null;
        this._visitables.get("macAddress").remove(this.macAddress);
    }
    return (A) this;
  }
  
  public A withMtu(Integer mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public MacAddressNested<A> withNewMacAddress() {
    return new MacAddressNested(null);
  }
  
  public MacAddressNested<A> withNewMacAddressLike(NetworkLinkEthernetMac item) {
    return new MacAddressNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class MacAddressNested<N> extends NetworkLinkEthernetMacFluent<MacAddressNested<N>> implements Nested<N>{
  
    NetworkLinkEthernetMacBuilder builder;
  
    MacAddressNested(NetworkLinkEthernetMac item) {
      this.builder = new NetworkLinkEthernetMacBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataLinkEthernetFluent.this.withMacAddress(builder.build());
    }
    
    public N endMacAddress() {
      return and();
    }
    
  }
}