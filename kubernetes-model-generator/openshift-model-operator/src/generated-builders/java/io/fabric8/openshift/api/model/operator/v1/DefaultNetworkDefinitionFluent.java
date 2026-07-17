package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class DefaultNetworkDefinitionFluent<A extends io.fabric8.openshift.api.model.operator.v1.DefaultNetworkDefinitionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private OpenShiftSDNConfigBuilder openshiftSDNConfig;
  private OVNKubernetesConfigBuilder ovnKubernetesConfig;
  private String type;

  public DefaultNetworkDefinitionFluent() {
  }
  
  public DefaultNetworkDefinitionFluent(DefaultNetworkDefinition instance) {
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
  
  public OpenShiftSDNConfig buildOpenshiftSDNConfig() {
    return this.openshiftSDNConfig != null ? this.openshiftSDNConfig.build() : null;
  }
  
  public OVNKubernetesConfig buildOvnKubernetesConfig() {
    return this.ovnKubernetesConfig != null ? this.ovnKubernetesConfig.build() : null;
  }
  
  protected void copyInstance(DefaultNetworkDefinition instance) {
    instance = instance != null ? instance : new DefaultNetworkDefinition();
    if (instance != null) {
        this.withOpenshiftSDNConfig(instance.getOpenshiftSDNConfig());
        this.withOvnKubernetesConfig(instance.getOvnKubernetesConfig());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OpenshiftSDNConfigNested<A> editOpenshiftSDNConfig() {
    return this.withNewOpenshiftSDNConfigLike(Optional.ofNullable(this.buildOpenshiftSDNConfig()).orElse(null));
  }
  
  public OpenshiftSDNConfigNested<A> editOrNewOpenshiftSDNConfig() {
    return this.withNewOpenshiftSDNConfigLike(Optional.ofNullable(this.buildOpenshiftSDNConfig()).orElse(new OpenShiftSDNConfigBuilder().build()));
  }
  
  public OpenshiftSDNConfigNested<A> editOrNewOpenshiftSDNConfigLike(OpenShiftSDNConfig item) {
    return this.withNewOpenshiftSDNConfigLike(Optional.ofNullable(this.buildOpenshiftSDNConfig()).orElse(item));
  }
  
  public OvnKubernetesConfigNested<A> editOrNewOvnKubernetesConfig() {
    return this.withNewOvnKubernetesConfigLike(Optional.ofNullable(this.buildOvnKubernetesConfig()).orElse(new OVNKubernetesConfigBuilder().build()));
  }
  
  public OvnKubernetesConfigNested<A> editOrNewOvnKubernetesConfigLike(OVNKubernetesConfig item) {
    return this.withNewOvnKubernetesConfigLike(Optional.ofNullable(this.buildOvnKubernetesConfig()).orElse(item));
  }
  
  public OvnKubernetesConfigNested<A> editOvnKubernetesConfig() {
    return this.withNewOvnKubernetesConfigLike(Optional.ofNullable(this.buildOvnKubernetesConfig()).orElse(null));
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
    DefaultNetworkDefinitionFluent that = (DefaultNetworkDefinitionFluent) o;
    if (!(Objects.equals(openshiftSDNConfig, that.openshiftSDNConfig))) {
      return false;
    }
    if (!(Objects.equals(ovnKubernetesConfig, that.ovnKubernetesConfig))) {
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
  
  public boolean hasOpenshiftSDNConfig() {
    return this.openshiftSDNConfig != null;
  }
  
  public boolean hasOvnKubernetesConfig() {
    return this.ovnKubernetesConfig != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(openshiftSDNConfig, ovnKubernetesConfig, type, additionalProperties);
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
    if (!(openshiftSDNConfig == null)) {
        sb.append("openshiftSDNConfig:");
        sb.append(openshiftSDNConfig);
        sb.append(",");
    }
    if (!(ovnKubernetesConfig == null)) {
        sb.append("ovnKubernetesConfig:");
        sb.append(ovnKubernetesConfig);
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
  
  public OpenshiftSDNConfigNested<A> withNewOpenshiftSDNConfig() {
    return new OpenshiftSDNConfigNested(null);
  }
  
  public A withNewOpenshiftSDNConfig(Boolean enableUnidling,String mode,Long mtu,Boolean useExternalOpenvswitch,Long vxlanPort) {
    return (A) this.withOpenshiftSDNConfig(new OpenShiftSDNConfig(enableUnidling, mode, mtu, useExternalOpenvswitch, vxlanPort));
  }
  
  public OpenshiftSDNConfigNested<A> withNewOpenshiftSDNConfigLike(OpenShiftSDNConfig item) {
    return new OpenshiftSDNConfigNested(item);
  }
  
  public OvnKubernetesConfigNested<A> withNewOvnKubernetesConfig() {
    return new OvnKubernetesConfigNested(null);
  }
  
  public OvnKubernetesConfigNested<A> withNewOvnKubernetesConfigLike(OVNKubernetesConfig item) {
    return new OvnKubernetesConfigNested(item);
  }
  
  public A withOpenshiftSDNConfig(OpenShiftSDNConfig openshiftSDNConfig) {
    this._visitables.remove("openshiftSDNConfig");
    if (openshiftSDNConfig != null) {
        this.openshiftSDNConfig = new OpenShiftSDNConfigBuilder(openshiftSDNConfig);
        this._visitables.get("openshiftSDNConfig").add(this.openshiftSDNConfig);
    } else {
        this.openshiftSDNConfig = null;
        this._visitables.get("openshiftSDNConfig").remove(this.openshiftSDNConfig);
    }
    return (A) this;
  }
  
  public A withOvnKubernetesConfig(OVNKubernetesConfig ovnKubernetesConfig) {
    this._visitables.remove("ovnKubernetesConfig");
    if (ovnKubernetesConfig != null) {
        this.ovnKubernetesConfig = new OVNKubernetesConfigBuilder(ovnKubernetesConfig);
        this._visitables.get("ovnKubernetesConfig").add(this.ovnKubernetesConfig);
    } else {
        this.ovnKubernetesConfig = null;
        this._visitables.get("ovnKubernetesConfig").remove(this.ovnKubernetesConfig);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class OpenshiftSDNConfigNested<N> extends OpenShiftSDNConfigFluent<OpenshiftSDNConfigNested<N>> implements Nested<N>{
  
    OpenShiftSDNConfigBuilder builder;
  
    OpenshiftSDNConfigNested(OpenShiftSDNConfig item) {
      this.builder = new OpenShiftSDNConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DefaultNetworkDefinitionFluent.this.withOpenshiftSDNConfig(builder.build());
    }
    
    public N endOpenshiftSDNConfig() {
      return and();
    }
    
  }
  public class OvnKubernetesConfigNested<N> extends OVNKubernetesConfigFluent<OvnKubernetesConfigNested<N>> implements Nested<N>{
  
    OVNKubernetesConfigBuilder builder;
  
    OvnKubernetesConfigNested(OVNKubernetesConfig item) {
      this.builder = new OVNKubernetesConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) DefaultNetworkDefinitionFluent.this.withOvnKubernetesConfig(builder.build());
    }
    
    public N endOvnKubernetesConfig() {
      return and();
    }
    
  }
}