package io.fabric8.openshift.api.model.config.v1;

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
public class MTUMigrationFluent<A extends io.fabric8.openshift.api.model.config.v1.MTUMigrationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MTUMigrationValuesBuilder machine;
  private MTUMigrationValuesBuilder network;

  public MTUMigrationFluent() {
  }
  
  public MTUMigrationFluent(MTUMigration instance) {
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
  
  public MTUMigrationValues buildMachine() {
    return this.machine != null ? this.machine.build() : null;
  }
  
  public MTUMigrationValues buildNetwork() {
    return this.network != null ? this.network.build() : null;
  }
  
  protected void copyInstance(MTUMigration instance) {
    instance = instance != null ? instance : new MTUMigration();
    if (instance != null) {
        this.withMachine(instance.getMachine());
        this.withNetwork(instance.getNetwork());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MachineNested<A> editMachine() {
    return this.withNewMachineLike(Optional.ofNullable(this.buildMachine()).orElse(null));
  }
  
  public NetworkNested<A> editNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(null));
  }
  
  public MachineNested<A> editOrNewMachine() {
    return this.withNewMachineLike(Optional.ofNullable(this.buildMachine()).orElse(new MTUMigrationValuesBuilder().build()));
  }
  
  public MachineNested<A> editOrNewMachineLike(MTUMigrationValues item) {
    return this.withNewMachineLike(Optional.ofNullable(this.buildMachine()).orElse(item));
  }
  
  public NetworkNested<A> editOrNewNetwork() {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(new MTUMigrationValuesBuilder().build()));
  }
  
  public NetworkNested<A> editOrNewNetworkLike(MTUMigrationValues item) {
    return this.withNewNetworkLike(Optional.ofNullable(this.buildNetwork()).orElse(item));
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
    MTUMigrationFluent that = (MTUMigrationFluent) o;
    if (!(Objects.equals(machine, that.machine))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
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
  
  public boolean hasMachine() {
    return this.machine != null;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public int hashCode() {
    return Objects.hash(machine, network, additionalProperties);
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
    if (!(machine == null)) {
        sb.append("machine:");
        sb.append(machine);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
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
  
  public A withMachine(MTUMigrationValues machine) {
    this._visitables.remove("machine");
    if (machine != null) {
        this.machine = new MTUMigrationValuesBuilder(machine);
        this._visitables.get("machine").add(this.machine);
    } else {
        this.machine = null;
        this._visitables.get("machine").remove(this.machine);
    }
    return (A) this;
  }
  
  public A withNetwork(MTUMigrationValues network) {
    this._visitables.remove("network");
    if (network != null) {
        this.network = new MTUMigrationValuesBuilder(network);
        this._visitables.get("network").add(this.network);
    } else {
        this.network = null;
        this._visitables.get("network").remove(this.network);
    }
    return (A) this;
  }
  
  public MachineNested<A> withNewMachine() {
    return new MachineNested(null);
  }
  
  public A withNewMachine(Long from,Long to) {
    return (A) this.withMachine(new MTUMigrationValues(from, to));
  }
  
  public MachineNested<A> withNewMachineLike(MTUMigrationValues item) {
    return new MachineNested(item);
  }
  
  public NetworkNested<A> withNewNetwork() {
    return new NetworkNested(null);
  }
  
  public A withNewNetwork(Long from,Long to) {
    return (A) this.withNetwork(new MTUMigrationValues(from, to));
  }
  
  public NetworkNested<A> withNewNetworkLike(MTUMigrationValues item) {
    return new NetworkNested(item);
  }
  public class MachineNested<N> extends MTUMigrationValuesFluent<MachineNested<N>> implements Nested<N>{
  
    MTUMigrationValuesBuilder builder;
  
    MachineNested(MTUMigrationValues item) {
      this.builder = new MTUMigrationValuesBuilder(this, item);
    }
  
    public N and() {
      return (N) MTUMigrationFluent.this.withMachine(builder.build());
    }
    
    public N endMachine() {
      return and();
    }
    
  }
  public class NetworkNested<N> extends MTUMigrationValuesFluent<NetworkNested<N>> implements Nested<N>{
  
    MTUMigrationValuesBuilder builder;
  
    NetworkNested(MTUMigrationValues item) {
      this.builder = new MTUMigrationValuesBuilder(this, item);
    }
  
    public N and() {
      return (N) MTUMigrationFluent.this.withNetwork(builder.build());
    }
    
    public N endNetwork() {
      return and();
    }
    
  }
}