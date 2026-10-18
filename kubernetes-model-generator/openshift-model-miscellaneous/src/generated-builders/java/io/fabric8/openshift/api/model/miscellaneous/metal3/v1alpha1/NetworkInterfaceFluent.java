package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
public class NetworkInterfaceFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.NetworkInterfaceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private HostNetworkAttachmentRefBuilder hostNetworkAttachment;
  private String macAddress;
  private String name;
  private SwitchPortBuilder switchPort;

  public NetworkInterfaceFluent() {
  }
  
  public NetworkInterfaceFluent(NetworkInterface instance) {
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
  
  public HostNetworkAttachmentRef buildHostNetworkAttachment() {
    return this.hostNetworkAttachment != null ? this.hostNetworkAttachment.build() : null;
  }
  
  public SwitchPort buildSwitchPort() {
    return this.switchPort != null ? this.switchPort.build() : null;
  }
  
  protected void copyInstance(NetworkInterface instance) {
    instance = instance != null ? instance : new NetworkInterface();
    if (instance != null) {
        this.withHostNetworkAttachment(instance.getHostNetworkAttachment());
        this.withMacAddress(instance.getMacAddress());
        this.withName(instance.getName());
        this.withSwitchPort(instance.getSwitchPort());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HostNetworkAttachmentNested<A> editHostNetworkAttachment() {
    return this.withNewHostNetworkAttachmentLike(Optional.ofNullable(this.buildHostNetworkAttachment()).orElse(null));
  }
  
  public HostNetworkAttachmentNested<A> editOrNewHostNetworkAttachment() {
    return this.withNewHostNetworkAttachmentLike(Optional.ofNullable(this.buildHostNetworkAttachment()).orElse(new HostNetworkAttachmentRefBuilder().build()));
  }
  
  public HostNetworkAttachmentNested<A> editOrNewHostNetworkAttachmentLike(HostNetworkAttachmentRef item) {
    return this.withNewHostNetworkAttachmentLike(Optional.ofNullable(this.buildHostNetworkAttachment()).orElse(item));
  }
  
  public SwitchPortNested<A> editOrNewSwitchPort() {
    return this.withNewSwitchPortLike(Optional.ofNullable(this.buildSwitchPort()).orElse(new SwitchPortBuilder().build()));
  }
  
  public SwitchPortNested<A> editOrNewSwitchPortLike(SwitchPort item) {
    return this.withNewSwitchPortLike(Optional.ofNullable(this.buildSwitchPort()).orElse(item));
  }
  
  public SwitchPortNested<A> editSwitchPort() {
    return this.withNewSwitchPortLike(Optional.ofNullable(this.buildSwitchPort()).orElse(null));
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
    NetworkInterfaceFluent that = (NetworkInterfaceFluent) o;
    if (!(Objects.equals(hostNetworkAttachment, that.hostNetworkAttachment))) {
      return false;
    }
    if (!(Objects.equals(macAddress, that.macAddress))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(switchPort, that.switchPort))) {
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
  
  public String getMacAddress() {
    return this.macAddress;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostNetworkAttachment() {
    return this.hostNetworkAttachment != null;
  }
  
  public boolean hasMacAddress() {
    return this.macAddress != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSwitchPort() {
    return this.switchPort != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostNetworkAttachment, macAddress, name, switchPort, additionalProperties);
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
    if (!(hostNetworkAttachment == null)) {
        sb.append("hostNetworkAttachment:");
        sb.append(hostNetworkAttachment);
        sb.append(",");
    }
    if (!(macAddress == null)) {
        sb.append("macAddress:");
        sb.append(macAddress);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(switchPort == null)) {
        sb.append("switchPort:");
        sb.append(switchPort);
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
  
  public A withHostNetworkAttachment(HostNetworkAttachmentRef hostNetworkAttachment) {
    this._visitables.remove("hostNetworkAttachment");
    if (hostNetworkAttachment != null) {
        this.hostNetworkAttachment = new HostNetworkAttachmentRefBuilder(hostNetworkAttachment);
        this._visitables.get("hostNetworkAttachment").add(this.hostNetworkAttachment);
    } else {
        this.hostNetworkAttachment = null;
        this._visitables.get("hostNetworkAttachment").remove(this.hostNetworkAttachment);
    }
    return (A) this;
  }
  
  public A withMacAddress(String macAddress) {
    this.macAddress = macAddress;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public HostNetworkAttachmentNested<A> withNewHostNetworkAttachment() {
    return new HostNetworkAttachmentNested(null);
  }
  
  public A withNewHostNetworkAttachment(String name,String namespace) {
    return (A) this.withHostNetworkAttachment(new HostNetworkAttachmentRef(name, namespace));
  }
  
  public HostNetworkAttachmentNested<A> withNewHostNetworkAttachmentLike(HostNetworkAttachmentRef item) {
    return new HostNetworkAttachmentNested(item);
  }
  
  public SwitchPortNested<A> withNewSwitchPort() {
    return new SwitchPortNested(null);
  }
  
  public A withNewSwitchPort(String portID,String switchID) {
    return (A) this.withSwitchPort(new SwitchPort(portID, switchID));
  }
  
  public SwitchPortNested<A> withNewSwitchPortLike(SwitchPort item) {
    return new SwitchPortNested(item);
  }
  
  public A withSwitchPort(SwitchPort switchPort) {
    this._visitables.remove("switchPort");
    if (switchPort != null) {
        this.switchPort = new SwitchPortBuilder(switchPort);
        this._visitables.get("switchPort").add(this.switchPort);
    } else {
        this.switchPort = null;
        this._visitables.get("switchPort").remove(this.switchPort);
    }
    return (A) this;
  }
  public class HostNetworkAttachmentNested<N> extends HostNetworkAttachmentRefFluent<HostNetworkAttachmentNested<N>> implements Nested<N>{
  
    HostNetworkAttachmentRefBuilder builder;
  
    HostNetworkAttachmentNested(HostNetworkAttachmentRef item) {
      this.builder = new HostNetworkAttachmentRefBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkInterfaceFluent.this.withHostNetworkAttachment(builder.build());
    }
    
    public N endHostNetworkAttachment() {
      return and();
    }
    
  }
  public class SwitchPortNested<N> extends SwitchPortFluent<SwitchPortNested<N>> implements Nested<N>{
  
    SwitchPortBuilder builder;
  
    SwitchPortNested(SwitchPort item) {
      this.builder = new SwitchPortBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkInterfaceFluent.this.withSwitchPort(builder.build());
    }
    
    public N endSwitchPort() {
      return and();
    }
    
  }
}