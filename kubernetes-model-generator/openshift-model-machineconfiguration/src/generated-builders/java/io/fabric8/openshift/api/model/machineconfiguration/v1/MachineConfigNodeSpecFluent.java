package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
public class MachineConfigNodeSpecFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineConfigNodeSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MachineConfigNodeSpecMachineConfigVersionBuilder configVersion;
  private MCOObjectReferenceBuilder node;
  private MCOObjectReferenceBuilder pool;

  public MachineConfigNodeSpecFluent() {
  }
  
  public MachineConfigNodeSpecFluent(MachineConfigNodeSpec instance) {
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
  
  public MachineConfigNodeSpecMachineConfigVersion buildConfigVersion() {
    return this.configVersion != null ? this.configVersion.build() : null;
  }
  
  public MCOObjectReference buildNode() {
    return this.node != null ? this.node.build() : null;
  }
  
  public MCOObjectReference buildPool() {
    return this.pool != null ? this.pool.build() : null;
  }
  
  protected void copyInstance(MachineConfigNodeSpec instance) {
    instance = instance != null ? instance : new MachineConfigNodeSpec();
    if (instance != null) {
        this.withConfigVersion(instance.getConfigVersion());
        this.withNode(instance.getNode());
        this.withPool(instance.getPool());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConfigVersionNested<A> editConfigVersion() {
    return this.withNewConfigVersionLike(Optional.ofNullable(this.buildConfigVersion()).orElse(null));
  }
  
  public NodeNested<A> editNode() {
    return this.withNewNodeLike(Optional.ofNullable(this.buildNode()).orElse(null));
  }
  
  public ConfigVersionNested<A> editOrNewConfigVersion() {
    return this.withNewConfigVersionLike(Optional.ofNullable(this.buildConfigVersion()).orElse(new MachineConfigNodeSpecMachineConfigVersionBuilder().build()));
  }
  
  public ConfigVersionNested<A> editOrNewConfigVersionLike(MachineConfigNodeSpecMachineConfigVersion item) {
    return this.withNewConfigVersionLike(Optional.ofNullable(this.buildConfigVersion()).orElse(item));
  }
  
  public NodeNested<A> editOrNewNode() {
    return this.withNewNodeLike(Optional.ofNullable(this.buildNode()).orElse(new MCOObjectReferenceBuilder().build()));
  }
  
  public NodeNested<A> editOrNewNodeLike(MCOObjectReference item) {
    return this.withNewNodeLike(Optional.ofNullable(this.buildNode()).orElse(item));
  }
  
  public PoolNested<A> editOrNewPool() {
    return this.withNewPoolLike(Optional.ofNullable(this.buildPool()).orElse(new MCOObjectReferenceBuilder().build()));
  }
  
  public PoolNested<A> editOrNewPoolLike(MCOObjectReference item) {
    return this.withNewPoolLike(Optional.ofNullable(this.buildPool()).orElse(item));
  }
  
  public PoolNested<A> editPool() {
    return this.withNewPoolLike(Optional.ofNullable(this.buildPool()).orElse(null));
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
    MachineConfigNodeSpecFluent that = (MachineConfigNodeSpecFluent) o;
    if (!(Objects.equals(configVersion, that.configVersion))) {
      return false;
    }
    if (!(Objects.equals(node, that.node))) {
      return false;
    }
    if (!(Objects.equals(pool, that.pool))) {
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
  
  public boolean hasConfigVersion() {
    return this.configVersion != null;
  }
  
  public boolean hasNode() {
    return this.node != null;
  }
  
  public boolean hasPool() {
    return this.pool != null;
  }
  
  public int hashCode() {
    return Objects.hash(configVersion, node, pool, additionalProperties);
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
    if (!(configVersion == null)) {
        sb.append("configVersion:");
        sb.append(configVersion);
        sb.append(",");
    }
    if (!(node == null)) {
        sb.append("node:");
        sb.append(node);
        sb.append(",");
    }
    if (!(pool == null)) {
        sb.append("pool:");
        sb.append(pool);
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
  
  public A withConfigVersion(MachineConfigNodeSpecMachineConfigVersion configVersion) {
    this._visitables.remove("configVersion");
    if (configVersion != null) {
        this.configVersion = new MachineConfigNodeSpecMachineConfigVersionBuilder(configVersion);
        this._visitables.get("configVersion").add(this.configVersion);
    } else {
        this.configVersion = null;
        this._visitables.get("configVersion").remove(this.configVersion);
    }
    return (A) this;
  }
  
  public ConfigVersionNested<A> withNewConfigVersion() {
    return new ConfigVersionNested(null);
  }
  
  public A withNewConfigVersion(String desired) {
    return (A) this.withConfigVersion(new MachineConfigNodeSpecMachineConfigVersion(desired));
  }
  
  public ConfigVersionNested<A> withNewConfigVersionLike(MachineConfigNodeSpecMachineConfigVersion item) {
    return new ConfigVersionNested(item);
  }
  
  public NodeNested<A> withNewNode() {
    return new NodeNested(null);
  }
  
  public A withNewNode(String name) {
    return (A) this.withNode(new MCOObjectReference(name));
  }
  
  public NodeNested<A> withNewNodeLike(MCOObjectReference item) {
    return new NodeNested(item);
  }
  
  public PoolNested<A> withNewPool() {
    return new PoolNested(null);
  }
  
  public A withNewPool(String name) {
    return (A) this.withPool(new MCOObjectReference(name));
  }
  
  public PoolNested<A> withNewPoolLike(MCOObjectReference item) {
    return new PoolNested(item);
  }
  
  public A withNode(MCOObjectReference node) {
    this._visitables.remove("node");
    if (node != null) {
        this.node = new MCOObjectReferenceBuilder(node);
        this._visitables.get("node").add(this.node);
    } else {
        this.node = null;
        this._visitables.get("node").remove(this.node);
    }
    return (A) this;
  }
  
  public A withPool(MCOObjectReference pool) {
    this._visitables.remove("pool");
    if (pool != null) {
        this.pool = new MCOObjectReferenceBuilder(pool);
        this._visitables.get("pool").add(this.pool);
    } else {
        this.pool = null;
        this._visitables.get("pool").remove(this.pool);
    }
    return (A) this;
  }
  public class ConfigVersionNested<N> extends MachineConfigNodeSpecMachineConfigVersionFluent<ConfigVersionNested<N>> implements Nested<N>{
  
    MachineConfigNodeSpecMachineConfigVersionBuilder builder;
  
    ConfigVersionNested(MachineConfigNodeSpecMachineConfigVersion item) {
      this.builder = new MachineConfigNodeSpecMachineConfigVersionBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigNodeSpecFluent.this.withConfigVersion(builder.build());
    }
    
    public N endConfigVersion() {
      return and();
    }
    
  }
  public class NodeNested<N> extends MCOObjectReferenceFluent<NodeNested<N>> implements Nested<N>{
  
    MCOObjectReferenceBuilder builder;
  
    NodeNested(MCOObjectReference item) {
      this.builder = new MCOObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigNodeSpecFluent.this.withNode(builder.build());
    }
    
    public N endNode() {
      return and();
    }
    
  }
  public class PoolNested<N> extends MCOObjectReferenceFluent<PoolNested<N>> implements Nested<N>{
  
    MCOObjectReferenceBuilder builder;
  
    PoolNested(MCOObjectReference item) {
      this.builder = new MCOObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigNodeSpecFluent.this.withPool(builder.build());
    }
    
    public N endPool() {
      return and();
    }
    
  }
}