package io.fabric8.openshift.api.model.operator.network.v1;

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
public class EgressRouterInterfaceFluent<A extends io.fabric8.openshift.api.model.operator.network.v1.EgressRouterInterfaceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MacvlanConfigBuilder macvlan;

  public EgressRouterInterfaceFluent() {
  }
  
  public EgressRouterInterfaceFluent(EgressRouterInterface instance) {
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
  
  public MacvlanConfig buildMacvlan() {
    return this.macvlan != null ? this.macvlan.build() : null;
  }
  
  protected void copyInstance(EgressRouterInterface instance) {
    instance = instance != null ? instance : new EgressRouterInterface();
    if (instance != null) {
        this.withMacvlan(instance.getMacvlan());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MacvlanNested<A> editMacvlan() {
    return this.withNewMacvlanLike(Optional.ofNullable(this.buildMacvlan()).orElse(null));
  }
  
  public MacvlanNested<A> editOrNewMacvlan() {
    return this.withNewMacvlanLike(Optional.ofNullable(this.buildMacvlan()).orElse(new MacvlanConfigBuilder().build()));
  }
  
  public MacvlanNested<A> editOrNewMacvlanLike(MacvlanConfig item) {
    return this.withNewMacvlanLike(Optional.ofNullable(this.buildMacvlan()).orElse(item));
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
    EgressRouterInterfaceFluent that = (EgressRouterInterfaceFluent) o;
    if (!(Objects.equals(macvlan, that.macvlan))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMacvlan() {
    return this.macvlan != null;
  }
  
  public int hashCode() {
    return Objects.hash(macvlan, additionalProperties);
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
    if (!(macvlan == null)) {
        sb.append("macvlan:");
        sb.append(macvlan);
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
  
  public A withMacvlan(MacvlanConfig macvlan) {
    this._visitables.remove("macvlan");
    if (macvlan != null) {
        this.macvlan = new MacvlanConfigBuilder(macvlan);
        this._visitables.get("macvlan").add(this.macvlan);
    } else {
        this.macvlan = null;
        this._visitables.get("macvlan").remove(this.macvlan);
    }
    return (A) this;
  }
  
  public MacvlanNested<A> withNewMacvlan() {
    return new MacvlanNested(null);
  }
  
  public A withNewMacvlan(String master,String mode) {
    return (A) this.withMacvlan(new MacvlanConfig(master, mode));
  }
  
  public MacvlanNested<A> withNewMacvlanLike(MacvlanConfig item) {
    return new MacvlanNested(item);
  }
  public class MacvlanNested<N> extends MacvlanConfigFluent<MacvlanNested<N>> implements Nested<N>{
  
    MacvlanConfigBuilder builder;
  
    MacvlanNested(MacvlanConfig item) {
      this.builder = new MacvlanConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressRouterInterfaceFluent.this.withMacvlan(builder.build());
    }
    
    public N endMacvlan() {
      return and();
    }
    
  }
}