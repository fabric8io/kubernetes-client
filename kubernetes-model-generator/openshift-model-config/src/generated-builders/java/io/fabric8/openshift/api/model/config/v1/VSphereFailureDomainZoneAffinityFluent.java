package io.fabric8.openshift.api.model.config.v1;

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
public class VSphereFailureDomainZoneAffinityFluent<A extends io.fabric8.openshift.api.model.config.v1.VSphereFailureDomainZoneAffinityFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private VSphereFailureDomainHostGroupBuilder hostGroup;
  private String type;

  public VSphereFailureDomainZoneAffinityFluent() {
  }
  
  public VSphereFailureDomainZoneAffinityFluent(VSphereFailureDomainZoneAffinity instance) {
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
  
  public VSphereFailureDomainHostGroup buildHostGroup() {
    return this.hostGroup != null ? this.hostGroup.build() : null;
  }
  
  protected void copyInstance(VSphereFailureDomainZoneAffinity instance) {
    instance = instance != null ? instance : new VSphereFailureDomainZoneAffinity();
    if (instance != null) {
        this.withHostGroup(instance.getHostGroup());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public HostGroupNested<A> editHostGroup() {
    return this.withNewHostGroupLike(Optional.ofNullable(this.buildHostGroup()).orElse(null));
  }
  
  public HostGroupNested<A> editOrNewHostGroup() {
    return this.withNewHostGroupLike(Optional.ofNullable(this.buildHostGroup()).orElse(new VSphereFailureDomainHostGroupBuilder().build()));
  }
  
  public HostGroupNested<A> editOrNewHostGroupLike(VSphereFailureDomainHostGroup item) {
    return this.withNewHostGroupLike(Optional.ofNullable(this.buildHostGroup()).orElse(item));
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
    VSphereFailureDomainZoneAffinityFluent that = (VSphereFailureDomainZoneAffinityFluent) o;
    if (!(Objects.equals(hostGroup, that.hostGroup))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHostGroup() {
    return this.hostGroup != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(hostGroup, type, additionalProperties);
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
  
  public A withHostGroup(VSphereFailureDomainHostGroup hostGroup) {
    this._visitables.remove("hostGroup");
    if (hostGroup != null) {
        this.hostGroup = new VSphereFailureDomainHostGroupBuilder(hostGroup);
        this._visitables.get("hostGroup").add(this.hostGroup);
    } else {
        this.hostGroup = null;
        this._visitables.get("hostGroup").remove(this.hostGroup);
    }
    return (A) this;
  }
  
  public HostGroupNested<A> withNewHostGroup() {
    return new HostGroupNested(null);
  }
  
  public A withNewHostGroup(String hostGroup,String vmGroup,String vmHostRule) {
    return (A) this.withHostGroup(new VSphereFailureDomainHostGroup(hostGroup, vmGroup, vmHostRule));
  }
  
  public HostGroupNested<A> withNewHostGroupLike(VSphereFailureDomainHostGroup item) {
    return new HostGroupNested(item);
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class HostGroupNested<N> extends VSphereFailureDomainHostGroupFluent<HostGroupNested<N>> implements Nested<N>{
  
    VSphereFailureDomainHostGroupBuilder builder;
  
    HostGroupNested(VSphereFailureDomainHostGroup item) {
      this.builder = new VSphereFailureDomainHostGroupBuilder(this, item);
    }
  
    public N and() {
      return (N) VSphereFailureDomainZoneAffinityFluent.this.withHostGroup(builder.build());
    }
    
    public N endHostGroup() {
      return and();
    }
    
  }
}