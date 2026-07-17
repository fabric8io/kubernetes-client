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
public class NetworkMigrationFluent<A extends io.fabric8.openshift.api.model.config.v1.NetworkMigrationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private MTUMigrationBuilder mtu;
  private String networkType;

  public NetworkMigrationFluent() {
  }
  
  public NetworkMigrationFluent(NetworkMigration instance) {
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
  
  public MTUMigration buildMtu() {
    return this.mtu != null ? this.mtu.build() : null;
  }
  
  protected void copyInstance(NetworkMigration instance) {
    instance = instance != null ? instance : new NetworkMigration();
    if (instance != null) {
        this.withMtu(instance.getMtu());
        this.withNetworkType(instance.getNetworkType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MtuNested<A> editMtu() {
    return this.withNewMtuLike(Optional.ofNullable(this.buildMtu()).orElse(null));
  }
  
  public MtuNested<A> editOrNewMtu() {
    return this.withNewMtuLike(Optional.ofNullable(this.buildMtu()).orElse(new MTUMigrationBuilder().build()));
  }
  
  public MtuNested<A> editOrNewMtuLike(MTUMigration item) {
    return this.withNewMtuLike(Optional.ofNullable(this.buildMtu()).orElse(item));
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
    NetworkMigrationFluent that = (NetworkMigrationFluent) o;
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(networkType, that.networkType))) {
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
  
  public String getNetworkType() {
    return this.networkType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasNetworkType() {
    return this.networkType != null;
  }
  
  public int hashCode() {
    return Objects.hash(mtu, networkType, additionalProperties);
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
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(networkType == null)) {
        sb.append("networkType:");
        sb.append(networkType);
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
  
  public A withMtu(MTUMigration mtu) {
    this._visitables.remove("mtu");
    if (mtu != null) {
        this.mtu = new MTUMigrationBuilder(mtu);
        this._visitables.get("mtu").add(this.mtu);
    } else {
        this.mtu = null;
        this._visitables.get("mtu").remove(this.mtu);
    }
    return (A) this;
  }
  
  public A withNetworkType(String networkType) {
    this.networkType = networkType;
    return (A) this;
  }
  
  public MtuNested<A> withNewMtu() {
    return new MtuNested(null);
  }
  
  public MtuNested<A> withNewMtuLike(MTUMigration item) {
    return new MtuNested(item);
  }
  public class MtuNested<N> extends MTUMigrationFluent<MtuNested<N>> implements Nested<N>{
  
    MTUMigrationBuilder builder;
  
    MtuNested(MTUMigration item) {
      this.builder = new MTUMigrationBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkMigrationFluent.this.withMtu(builder.build());
    }
    
    public N endMtu() {
      return and();
    }
    
  }
}