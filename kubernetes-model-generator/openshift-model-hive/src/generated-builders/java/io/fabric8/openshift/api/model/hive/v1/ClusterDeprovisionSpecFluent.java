package io.fabric8.openshift.api.model.hive.v1;

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
public class ClusterDeprovisionSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterDeprovisionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String baseDomain;
  private String clusterID;
  private String clusterName;
  private String infraID;
  private ClusterDeprovisionPlatformBuilder platform;

  public ClusterDeprovisionSpecFluent() {
  }
  
  public ClusterDeprovisionSpecFluent(ClusterDeprovisionSpec instance) {
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
  
  public ClusterDeprovisionPlatform buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  protected void copyInstance(ClusterDeprovisionSpec instance) {
    instance = instance != null ? instance : new ClusterDeprovisionSpec();
    if (instance != null) {
        this.withBaseDomain(instance.getBaseDomain());
        this.withClusterID(instance.getClusterID());
        this.withClusterName(instance.getClusterName());
        this.withInfraID(instance.getInfraID());
        this.withPlatform(instance.getPlatform());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new ClusterDeprovisionPlatformBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(ClusterDeprovisionPlatform item) {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(item));
  }
  
  public PlatformNested<A> editPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(null));
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
    ClusterDeprovisionSpecFluent that = (ClusterDeprovisionSpecFluent) o;
    if (!(Objects.equals(baseDomain, that.baseDomain))) {
      return false;
    }
    if (!(Objects.equals(clusterID, that.clusterID))) {
      return false;
    }
    if (!(Objects.equals(clusterName, that.clusterName))) {
      return false;
    }
    if (!(Objects.equals(infraID, that.infraID))) {
      return false;
    }
    if (!(Objects.equals(platform, that.platform))) {
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
  
  public String getBaseDomain() {
    return this.baseDomain;
  }
  
  public String getClusterID() {
    return this.clusterID;
  }
  
  public String getClusterName() {
    return this.clusterName;
  }
  
  public String getInfraID() {
    return this.infraID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBaseDomain() {
    return this.baseDomain != null;
  }
  
  public boolean hasClusterID() {
    return this.clusterID != null;
  }
  
  public boolean hasClusterName() {
    return this.clusterName != null;
  }
  
  public boolean hasInfraID() {
    return this.infraID != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public int hashCode() {
    return Objects.hash(baseDomain, clusterID, clusterName, infraID, platform, additionalProperties);
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
    if (!(baseDomain == null)) {
        sb.append("baseDomain:");
        sb.append(baseDomain);
        sb.append(",");
    }
    if (!(clusterID == null)) {
        sb.append("clusterID:");
        sb.append(clusterID);
        sb.append(",");
    }
    if (!(clusterName == null)) {
        sb.append("clusterName:");
        sb.append(clusterName);
        sb.append(",");
    }
    if (!(infraID == null)) {
        sb.append("infraID:");
        sb.append(infraID);
        sb.append(",");
    }
    if (!(platform == null)) {
        sb.append("platform:");
        sb.append(platform);
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
  
  public A withBaseDomain(String baseDomain) {
    this.baseDomain = baseDomain;
    return (A) this;
  }
  
  public A withClusterID(String clusterID) {
    this.clusterID = clusterID;
    return (A) this;
  }
  
  public A withClusterName(String clusterName) {
    this.clusterName = clusterName;
    return (A) this;
  }
  
  public A withInfraID(String infraID) {
    this.infraID = infraID;
    return (A) this;
  }
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(ClusterDeprovisionPlatform item) {
    return new PlatformNested(item);
  }
  
  public A withPlatform(ClusterDeprovisionPlatform platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new ClusterDeprovisionPlatformBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  public class PlatformNested<N> extends ClusterDeprovisionPlatformFluent<PlatformNested<N>> implements Nested<N>{
  
    ClusterDeprovisionPlatformBuilder builder;
  
    PlatformNested(ClusterDeprovisionPlatform item) {
      this.builder = new ClusterDeprovisionPlatformBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterDeprovisionSpecFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
}