package io.fabric8.openshift.api.model.installer.v1;

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
public class DiskFluent<A extends io.fabric8.openshift.api.model.installer.v1.DiskFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DiskEtcdBuilder etcd;
  private DiskSwapBuilder swap;
  private String type;
  private DiskUserDefinedBuilder userDefined;

  public DiskFluent() {
  }
  
  public DiskFluent(Disk instance) {
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
  
  public DiskEtcd buildEtcd() {
    return this.etcd != null ? this.etcd.build() : null;
  }
  
  public DiskSwap buildSwap() {
    return this.swap != null ? this.swap.build() : null;
  }
  
  public DiskUserDefined buildUserDefined() {
    return this.userDefined != null ? this.userDefined.build() : null;
  }
  
  protected void copyInstance(Disk instance) {
    instance = instance != null ? instance : new Disk();
    if (instance != null) {
        this.withEtcd(instance.getEtcd());
        this.withSwap(instance.getSwap());
        this.withType(instance.getType());
        this.withUserDefined(instance.getUserDefined());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EtcdNested<A> editEtcd() {
    return this.withNewEtcdLike(Optional.ofNullable(this.buildEtcd()).orElse(null));
  }
  
  public EtcdNested<A> editOrNewEtcd() {
    return this.withNewEtcdLike(Optional.ofNullable(this.buildEtcd()).orElse(new DiskEtcdBuilder().build()));
  }
  
  public EtcdNested<A> editOrNewEtcdLike(DiskEtcd item) {
    return this.withNewEtcdLike(Optional.ofNullable(this.buildEtcd()).orElse(item));
  }
  
  public SwapNested<A> editOrNewSwap() {
    return this.withNewSwapLike(Optional.ofNullable(this.buildSwap()).orElse(new DiskSwapBuilder().build()));
  }
  
  public SwapNested<A> editOrNewSwapLike(DiskSwap item) {
    return this.withNewSwapLike(Optional.ofNullable(this.buildSwap()).orElse(item));
  }
  
  public UserDefinedNested<A> editOrNewUserDefined() {
    return this.withNewUserDefinedLike(Optional.ofNullable(this.buildUserDefined()).orElse(new DiskUserDefinedBuilder().build()));
  }
  
  public UserDefinedNested<A> editOrNewUserDefinedLike(DiskUserDefined item) {
    return this.withNewUserDefinedLike(Optional.ofNullable(this.buildUserDefined()).orElse(item));
  }
  
  public SwapNested<A> editSwap() {
    return this.withNewSwapLike(Optional.ofNullable(this.buildSwap()).orElse(null));
  }
  
  public UserDefinedNested<A> editUserDefined() {
    return this.withNewUserDefinedLike(Optional.ofNullable(this.buildUserDefined()).orElse(null));
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
    DiskFluent that = (DiskFluent) o;
    if (!(Objects.equals(etcd, that.etcd))) {
      return false;
    }
    if (!(Objects.equals(swap, that.swap))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(userDefined, that.userDefined))) {
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
  
  public boolean hasEtcd() {
    return this.etcd != null;
  }
  
  public boolean hasSwap() {
    return this.swap != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUserDefined() {
    return this.userDefined != null;
  }
  
  public int hashCode() {
    return Objects.hash(etcd, swap, type, userDefined, additionalProperties);
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
    if (!(etcd == null)) {
        sb.append("etcd:");
        sb.append(etcd);
        sb.append(",");
    }
    if (!(swap == null)) {
        sb.append("swap:");
        sb.append(swap);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(userDefined == null)) {
        sb.append("userDefined:");
        sb.append(userDefined);
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
  
  public A withEtcd(DiskEtcd etcd) {
    this._visitables.remove("etcd");
    if (etcd != null) {
        this.etcd = new DiskEtcdBuilder(etcd);
        this._visitables.get("etcd").add(this.etcd);
    } else {
        this.etcd = null;
        this._visitables.get("etcd").remove(this.etcd);
    }
    return (A) this;
  }
  
  public EtcdNested<A> withNewEtcd() {
    return new EtcdNested(null);
  }
  
  public A withNewEtcd(String platformDiskID) {
    return (A) this.withEtcd(new DiskEtcd(platformDiskID));
  }
  
  public EtcdNested<A> withNewEtcdLike(DiskEtcd item) {
    return new EtcdNested(item);
  }
  
  public SwapNested<A> withNewSwap() {
    return new SwapNested(null);
  }
  
  public A withNewSwap(String platformDiskID) {
    return (A) this.withSwap(new DiskSwap(platformDiskID));
  }
  
  public SwapNested<A> withNewSwapLike(DiskSwap item) {
    return new SwapNested(item);
  }
  
  public UserDefinedNested<A> withNewUserDefined() {
    return new UserDefinedNested(null);
  }
  
  public A withNewUserDefined(String mountPath,String platformDiskID) {
    return (A) this.withUserDefined(new DiskUserDefined(mountPath, platformDiskID));
  }
  
  public UserDefinedNested<A> withNewUserDefinedLike(DiskUserDefined item) {
    return new UserDefinedNested(item);
  }
  
  public A withSwap(DiskSwap swap) {
    this._visitables.remove("swap");
    if (swap != null) {
        this.swap = new DiskSwapBuilder(swap);
        this._visitables.get("swap").add(this.swap);
    } else {
        this.swap = null;
        this._visitables.get("swap").remove(this.swap);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withUserDefined(DiskUserDefined userDefined) {
    this._visitables.remove("userDefined");
    if (userDefined != null) {
        this.userDefined = new DiskUserDefinedBuilder(userDefined);
        this._visitables.get("userDefined").add(this.userDefined);
    } else {
        this.userDefined = null;
        this._visitables.get("userDefined").remove(this.userDefined);
    }
    return (A) this;
  }
  public class EtcdNested<N> extends DiskEtcdFluent<EtcdNested<N>> implements Nested<N>{
  
    DiskEtcdBuilder builder;
  
    EtcdNested(DiskEtcd item) {
      this.builder = new DiskEtcdBuilder(this, item);
    }
  
    public N and() {
      return (N) DiskFluent.this.withEtcd(builder.build());
    }
    
    public N endEtcd() {
      return and();
    }
    
  }
  public class SwapNested<N> extends DiskSwapFluent<SwapNested<N>> implements Nested<N>{
  
    DiskSwapBuilder builder;
  
    SwapNested(DiskSwap item) {
      this.builder = new DiskSwapBuilder(this, item);
    }
  
    public N and() {
      return (N) DiskFluent.this.withSwap(builder.build());
    }
    
    public N endSwap() {
      return and();
    }
    
  }
  public class UserDefinedNested<N> extends DiskUserDefinedFluent<UserDefinedNested<N>> implements Nested<N>{
  
    DiskUserDefinedBuilder builder;
  
    UserDefinedNested(DiskUserDefined item) {
      this.builder = new DiskUserDefinedBuilder(this, item);
    }
  
    public N and() {
      return (N) DiskFluent.this.withUserDefined(builder.build());
    }
    
    public N endUserDefined() {
      return and();
    }
    
  }
}