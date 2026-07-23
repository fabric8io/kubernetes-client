package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class ClusterMetadataFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterMetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder adminKubeconfigSecretRef;
  private LocalObjectReferenceBuilder adminPasswordSecretRef;
  private String clusterID;
  private String infraID;
  private ClusterPlatformMetadataBuilder platform;

  public ClusterMetadataFluent() {
  }
  
  public ClusterMetadataFluent(ClusterMetadata instance) {
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
  
  public LocalObjectReference buildAdminKubeconfigSecretRef() {
    return this.adminKubeconfigSecretRef != null ? this.adminKubeconfigSecretRef.build() : null;
  }
  
  public LocalObjectReference buildAdminPasswordSecretRef() {
    return this.adminPasswordSecretRef != null ? this.adminPasswordSecretRef.build() : null;
  }
  
  public ClusterPlatformMetadata buildPlatform() {
    return this.platform != null ? this.platform.build() : null;
  }
  
  protected void copyInstance(ClusterMetadata instance) {
    instance = instance != null ? instance : new ClusterMetadata();
    if (instance != null) {
        this.withAdminKubeconfigSecretRef(instance.getAdminKubeconfigSecretRef());
        this.withAdminPasswordSecretRef(instance.getAdminPasswordSecretRef());
        this.withClusterID(instance.getClusterID());
        this.withInfraID(instance.getInfraID());
        this.withPlatform(instance.getPlatform());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdminKubeconfigSecretRefNested<A> editAdminKubeconfigSecretRef() {
    return this.withNewAdminKubeconfigSecretRefLike(Optional.ofNullable(this.buildAdminKubeconfigSecretRef()).orElse(null));
  }
  
  public AdminPasswordSecretRefNested<A> editAdminPasswordSecretRef() {
    return this.withNewAdminPasswordSecretRefLike(Optional.ofNullable(this.buildAdminPasswordSecretRef()).orElse(null));
  }
  
  public AdminKubeconfigSecretRefNested<A> editOrNewAdminKubeconfigSecretRef() {
    return this.withNewAdminKubeconfigSecretRefLike(Optional.ofNullable(this.buildAdminKubeconfigSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public AdminKubeconfigSecretRefNested<A> editOrNewAdminKubeconfigSecretRefLike(LocalObjectReference item) {
    return this.withNewAdminKubeconfigSecretRefLike(Optional.ofNullable(this.buildAdminKubeconfigSecretRef()).orElse(item));
  }
  
  public AdminPasswordSecretRefNested<A> editOrNewAdminPasswordSecretRef() {
    return this.withNewAdminPasswordSecretRefLike(Optional.ofNullable(this.buildAdminPasswordSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public AdminPasswordSecretRefNested<A> editOrNewAdminPasswordSecretRefLike(LocalObjectReference item) {
    return this.withNewAdminPasswordSecretRefLike(Optional.ofNullable(this.buildAdminPasswordSecretRef()).orElse(item));
  }
  
  public PlatformNested<A> editOrNewPlatform() {
    return this.withNewPlatformLike(Optional.ofNullable(this.buildPlatform()).orElse(new ClusterPlatformMetadataBuilder().build()));
  }
  
  public PlatformNested<A> editOrNewPlatformLike(ClusterPlatformMetadata item) {
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
    ClusterMetadataFluent that = (ClusterMetadataFluent) o;
    if (!(Objects.equals(adminKubeconfigSecretRef, that.adminKubeconfigSecretRef))) {
      return false;
    }
    if (!(Objects.equals(adminPasswordSecretRef, that.adminPasswordSecretRef))) {
      return false;
    }
    if (!(Objects.equals(clusterID, that.clusterID))) {
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
  
  public String getClusterID() {
    return this.clusterID;
  }
  
  public String getInfraID() {
    return this.infraID;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdminKubeconfigSecretRef() {
    return this.adminKubeconfigSecretRef != null;
  }
  
  public boolean hasAdminPasswordSecretRef() {
    return this.adminPasswordSecretRef != null;
  }
  
  public boolean hasClusterID() {
    return this.clusterID != null;
  }
  
  public boolean hasInfraID() {
    return this.infraID != null;
  }
  
  public boolean hasPlatform() {
    return this.platform != null;
  }
  
  public int hashCode() {
    return Objects.hash(adminKubeconfigSecretRef, adminPasswordSecretRef, clusterID, infraID, platform, additionalProperties);
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
    if (!(adminKubeconfigSecretRef == null)) {
        sb.append("adminKubeconfigSecretRef:");
        sb.append(adminKubeconfigSecretRef);
        sb.append(",");
    }
    if (!(adminPasswordSecretRef == null)) {
        sb.append("adminPasswordSecretRef:");
        sb.append(adminPasswordSecretRef);
        sb.append(",");
    }
    if (!(clusterID == null)) {
        sb.append("clusterID:");
        sb.append(clusterID);
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
  
  public A withAdminKubeconfigSecretRef(LocalObjectReference adminKubeconfigSecretRef) {
    this._visitables.remove("adminKubeconfigSecretRef");
    if (adminKubeconfigSecretRef != null) {
        this.adminKubeconfigSecretRef = new LocalObjectReferenceBuilder(adminKubeconfigSecretRef);
        this._visitables.get("adminKubeconfigSecretRef").add(this.adminKubeconfigSecretRef);
    } else {
        this.adminKubeconfigSecretRef = null;
        this._visitables.get("adminKubeconfigSecretRef").remove(this.adminKubeconfigSecretRef);
    }
    return (A) this;
  }
  
  public A withAdminPasswordSecretRef(LocalObjectReference adminPasswordSecretRef) {
    this._visitables.remove("adminPasswordSecretRef");
    if (adminPasswordSecretRef != null) {
        this.adminPasswordSecretRef = new LocalObjectReferenceBuilder(adminPasswordSecretRef);
        this._visitables.get("adminPasswordSecretRef").add(this.adminPasswordSecretRef);
    } else {
        this.adminPasswordSecretRef = null;
        this._visitables.get("adminPasswordSecretRef").remove(this.adminPasswordSecretRef);
    }
    return (A) this;
  }
  
  public A withClusterID(String clusterID) {
    this.clusterID = clusterID;
    return (A) this;
  }
  
  public A withInfraID(String infraID) {
    this.infraID = infraID;
    return (A) this;
  }
  
  public AdminKubeconfigSecretRefNested<A> withNewAdminKubeconfigSecretRef() {
    return new AdminKubeconfigSecretRefNested(null);
  }
  
  public A withNewAdminKubeconfigSecretRef(String name) {
    return (A) this.withAdminKubeconfigSecretRef(new LocalObjectReference(name));
  }
  
  public AdminKubeconfigSecretRefNested<A> withNewAdminKubeconfigSecretRefLike(LocalObjectReference item) {
    return new AdminKubeconfigSecretRefNested(item);
  }
  
  public AdminPasswordSecretRefNested<A> withNewAdminPasswordSecretRef() {
    return new AdminPasswordSecretRefNested(null);
  }
  
  public A withNewAdminPasswordSecretRef(String name) {
    return (A) this.withAdminPasswordSecretRef(new LocalObjectReference(name));
  }
  
  public AdminPasswordSecretRefNested<A> withNewAdminPasswordSecretRefLike(LocalObjectReference item) {
    return new AdminPasswordSecretRefNested(item);
  }
  
  public PlatformNested<A> withNewPlatform() {
    return new PlatformNested(null);
  }
  
  public PlatformNested<A> withNewPlatformLike(ClusterPlatformMetadata item) {
    return new PlatformNested(item);
  }
  
  public A withPlatform(ClusterPlatformMetadata platform) {
    this._visitables.remove("platform");
    if (platform != null) {
        this.platform = new ClusterPlatformMetadataBuilder(platform);
        this._visitables.get("platform").add(this.platform);
    } else {
        this.platform = null;
        this._visitables.get("platform").remove(this.platform);
    }
    return (A) this;
  }
  public class AdminKubeconfigSecretRefNested<N> extends LocalObjectReferenceFluent<AdminKubeconfigSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    AdminKubeconfigSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterMetadataFluent.this.withAdminKubeconfigSecretRef(builder.build());
    }
    
    public N endAdminKubeconfigSecretRef() {
      return and();
    }
    
  }
  public class AdminPasswordSecretRefNested<N> extends LocalObjectReferenceFluent<AdminPasswordSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    AdminPasswordSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterMetadataFluent.this.withAdminPasswordSecretRef(builder.build());
    }
    
    public N endAdminPasswordSecretRef() {
      return and();
    }
    
  }
  public class PlatformNested<N> extends ClusterPlatformMetadataFluent<PlatformNested<N>> implements Nested<N>{
  
    ClusterPlatformMetadataBuilder builder;
  
    PlatformNested(ClusterPlatformMetadata item) {
      this.builder = new ClusterPlatformMetadataBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterMetadataFluent.this.withPlatform(builder.build());
    }
    
    public N endPlatform() {
      return and();
    }
    
  }
}