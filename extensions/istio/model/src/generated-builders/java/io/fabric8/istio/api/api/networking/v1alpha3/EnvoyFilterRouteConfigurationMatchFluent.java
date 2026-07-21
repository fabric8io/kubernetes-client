package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class EnvoyFilterRouteConfigurationMatchFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.EnvoyFilterRouteConfigurationMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String gateway;
  private String name;
  private String portName;
  private Long portNumber;
  private EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder vhost;

  public EnvoyFilterRouteConfigurationMatchFluent() {
  }
  
  public EnvoyFilterRouteConfigurationMatchFluent(EnvoyFilterRouteConfigurationMatch instance) {
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
  
  public EnvoyFilterRouteConfigurationMatchVirtualHostMatch buildVhost() {
    return this.vhost != null ? this.vhost.build() : null;
  }
  
  protected void copyInstance(EnvoyFilterRouteConfigurationMatch instance) {
    instance = instance != null ? instance : new EnvoyFilterRouteConfigurationMatch();
    if (instance != null) {
        this.withGateway(instance.getGateway());
        this.withName(instance.getName());
        this.withPortName(instance.getPortName());
        this.withPortNumber(instance.getPortNumber());
        this.withVhost(instance.getVhost());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VhostNested<A> editOrNewVhost() {
    return this.withNewVhostLike(Optional.ofNullable(this.buildVhost()).orElse(new EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder().build()));
  }
  
  public VhostNested<A> editOrNewVhostLike(EnvoyFilterRouteConfigurationMatchVirtualHostMatch item) {
    return this.withNewVhostLike(Optional.ofNullable(this.buildVhost()).orElse(item));
  }
  
  public VhostNested<A> editVhost() {
    return this.withNewVhostLike(Optional.ofNullable(this.buildVhost()).orElse(null));
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
    EnvoyFilterRouteConfigurationMatchFluent that = (EnvoyFilterRouteConfigurationMatchFluent) o;
    if (!(Objects.equals(gateway, that.gateway))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(portName, that.portName))) {
      return false;
    }
    if (!(Objects.equals(portNumber, that.portNumber))) {
      return false;
    }
    if (!(Objects.equals(vhost, that.vhost))) {
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
  
  public String getGateway() {
    return this.gateway;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getPortName() {
    return this.portName;
  }
  
  public Long getPortNumber() {
    return this.portNumber;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasGateway() {
    return this.gateway != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPortName() {
    return this.portName != null;
  }
  
  public boolean hasPortNumber() {
    return this.portNumber != null;
  }
  
  public boolean hasVhost() {
    return this.vhost != null;
  }
  
  public int hashCode() {
    return Objects.hash(gateway, name, portName, portNumber, vhost, additionalProperties);
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
    if (!(gateway == null)) {
        sb.append("gateway:");
        sb.append(gateway);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(portName == null)) {
        sb.append("portName:");
        sb.append(portName);
        sb.append(",");
    }
    if (!(portNumber == null)) {
        sb.append("portNumber:");
        sb.append(portNumber);
        sb.append(",");
    }
    if (!(vhost == null)) {
        sb.append("vhost:");
        sb.append(vhost);
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
  
  public A withGateway(String gateway) {
    this.gateway = gateway;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public VhostNested<A> withNewVhost() {
    return new VhostNested(null);
  }
  
  public VhostNested<A> withNewVhostLike(EnvoyFilterRouteConfigurationMatchVirtualHostMatch item) {
    return new VhostNested(item);
  }
  
  public A withPortName(String portName) {
    this.portName = portName;
    return (A) this;
  }
  
  public A withPortNumber(Long portNumber) {
    this.portNumber = portNumber;
    return (A) this;
  }
  
  public A withVhost(EnvoyFilterRouteConfigurationMatchVirtualHostMatch vhost) {
    this._visitables.remove("vhost");
    if (vhost != null) {
        this.vhost = new EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder(vhost);
        this._visitables.get("vhost").add(this.vhost);
    } else {
        this.vhost = null;
        this._visitables.get("vhost").remove(this.vhost);
    }
    return (A) this;
  }
  public class VhostNested<N> extends EnvoyFilterRouteConfigurationMatchVirtualHostMatchFluent<VhostNested<N>> implements Nested<N>{
  
    EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder builder;
  
    VhostNested(EnvoyFilterRouteConfigurationMatchVirtualHostMatch item) {
      this.builder = new EnvoyFilterRouteConfigurationMatchVirtualHostMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) EnvoyFilterRouteConfigurationMatchFluent.this.withVhost(builder.build());
    }
    
    public N endVhost() {
      return and();
    }
    
  }
}