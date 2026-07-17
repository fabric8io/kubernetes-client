package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.PodSpec;
import java.lang.Integer;
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
public class ClusterProvisionSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterProvisionSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private LocalObjectReferenceBuilder adminKubeconfigSecretRef;
  private LocalObjectReferenceBuilder adminPasswordSecretRef;
  private Integer attempt;
  private LocalObjectReferenceBuilder clusterDeploymentRef;
  private String clusterID;
  private String infraID;
  private String installLog;
  private Object metadata;
  private String metadataJSON;
  private PodSpec podSpec;
  private String prevClusterID;
  private String prevInfraID;
  private String prevProvisionName;
  private String stage;

  public ClusterProvisionSpecFluent() {
  }
  
  public ClusterProvisionSpecFluent(ClusterProvisionSpec instance) {
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
  
  public LocalObjectReference buildClusterDeploymentRef() {
    return this.clusterDeploymentRef != null ? this.clusterDeploymentRef.build() : null;
  }
  
  protected void copyInstance(ClusterProvisionSpec instance) {
    instance = instance != null ? instance : new ClusterProvisionSpec();
    if (instance != null) {
        this.withAdminKubeconfigSecretRef(instance.getAdminKubeconfigSecretRef());
        this.withAdminPasswordSecretRef(instance.getAdminPasswordSecretRef());
        this.withAttempt(instance.getAttempt());
        this.withClusterDeploymentRef(instance.getClusterDeploymentRef());
        this.withClusterID(instance.getClusterID());
        this.withInfraID(instance.getInfraID());
        this.withInstallLog(instance.getInstallLog());
        this.withMetadata(instance.getMetadata());
        this.withMetadataJSON(instance.getMetadataJSON());
        this.withPodSpec(instance.getPodSpec());
        this.withPrevClusterID(instance.getPrevClusterID());
        this.withPrevInfraID(instance.getPrevInfraID());
        this.withPrevProvisionName(instance.getPrevProvisionName());
        this.withStage(instance.getStage());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdminKubeconfigSecretRefNested<A> editAdminKubeconfigSecretRef() {
    return this.withNewAdminKubeconfigSecretRefLike(Optional.ofNullable(this.buildAdminKubeconfigSecretRef()).orElse(null));
  }
  
  public AdminPasswordSecretRefNested<A> editAdminPasswordSecretRef() {
    return this.withNewAdminPasswordSecretRefLike(Optional.ofNullable(this.buildAdminPasswordSecretRef()).orElse(null));
  }
  
  public ClusterDeploymentRefNested<A> editClusterDeploymentRef() {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(null));
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
  
  public ClusterDeploymentRefNested<A> editOrNewClusterDeploymentRef() {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public ClusterDeploymentRefNested<A> editOrNewClusterDeploymentRefLike(LocalObjectReference item) {
    return this.withNewClusterDeploymentRefLike(Optional.ofNullable(this.buildClusterDeploymentRef()).orElse(item));
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
    ClusterProvisionSpecFluent that = (ClusterProvisionSpecFluent) o;
    if (!(Objects.equals(adminKubeconfigSecretRef, that.adminKubeconfigSecretRef))) {
      return false;
    }
    if (!(Objects.equals(adminPasswordSecretRef, that.adminPasswordSecretRef))) {
      return false;
    }
    if (!(Objects.equals(attempt, that.attempt))) {
      return false;
    }
    if (!(Objects.equals(clusterDeploymentRef, that.clusterDeploymentRef))) {
      return false;
    }
    if (!(Objects.equals(clusterID, that.clusterID))) {
      return false;
    }
    if (!(Objects.equals(infraID, that.infraID))) {
      return false;
    }
    if (!(Objects.equals(installLog, that.installLog))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(metadataJSON, that.metadataJSON))) {
      return false;
    }
    if (!(Objects.equals(podSpec, that.podSpec))) {
      return false;
    }
    if (!(Objects.equals(prevClusterID, that.prevClusterID))) {
      return false;
    }
    if (!(Objects.equals(prevInfraID, that.prevInfraID))) {
      return false;
    }
    if (!(Objects.equals(prevProvisionName, that.prevProvisionName))) {
      return false;
    }
    if (!(Objects.equals(stage, that.stage))) {
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
  
  public Integer getAttempt() {
    return this.attempt;
  }
  
  public String getClusterID() {
    return this.clusterID;
  }
  
  public String getInfraID() {
    return this.infraID;
  }
  
  public String getInstallLog() {
    return this.installLog;
  }
  
  public Object getMetadata() {
    return this.metadata;
  }
  
  public String getMetadataJSON() {
    return this.metadataJSON;
  }
  
  public PodSpec getPodSpec() {
    return this.podSpec;
  }
  
  public String getPrevClusterID() {
    return this.prevClusterID;
  }
  
  public String getPrevInfraID() {
    return this.prevInfraID;
  }
  
  public String getPrevProvisionName() {
    return this.prevProvisionName;
  }
  
  public String getStage() {
    return this.stage;
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
  
  public boolean hasAttempt() {
    return this.attempt != null;
  }
  
  public boolean hasClusterDeploymentRef() {
    return this.clusterDeploymentRef != null;
  }
  
  public boolean hasClusterID() {
    return this.clusterID != null;
  }
  
  public boolean hasInfraID() {
    return this.infraID != null;
  }
  
  public boolean hasInstallLog() {
    return this.installLog != null;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasMetadataJSON() {
    return this.metadataJSON != null;
  }
  
  public boolean hasPodSpec() {
    return this.podSpec != null;
  }
  
  public boolean hasPrevClusterID() {
    return this.prevClusterID != null;
  }
  
  public boolean hasPrevInfraID() {
    return this.prevInfraID != null;
  }
  
  public boolean hasPrevProvisionName() {
    return this.prevProvisionName != null;
  }
  
  public boolean hasStage() {
    return this.stage != null;
  }
  
  public int hashCode() {
    return Objects.hash(adminKubeconfigSecretRef, adminPasswordSecretRef, attempt, clusterDeploymentRef, clusterID, infraID, installLog, metadata, metadataJSON, podSpec, prevClusterID, prevInfraID, prevProvisionName, stage, additionalProperties);
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
    if (!(attempt == null)) {
        sb.append("attempt:");
        sb.append(attempt);
        sb.append(",");
    }
    if (!(clusterDeploymentRef == null)) {
        sb.append("clusterDeploymentRef:");
        sb.append(clusterDeploymentRef);
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
    if (!(installLog == null)) {
        sb.append("installLog:");
        sb.append(installLog);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(metadataJSON == null)) {
        sb.append("metadataJSON:");
        sb.append(metadataJSON);
        sb.append(",");
    }
    if (!(podSpec == null)) {
        sb.append("podSpec:");
        sb.append(podSpec);
        sb.append(",");
    }
    if (!(prevClusterID == null)) {
        sb.append("prevClusterID:");
        sb.append(prevClusterID);
        sb.append(",");
    }
    if (!(prevInfraID == null)) {
        sb.append("prevInfraID:");
        sb.append(prevInfraID);
        sb.append(",");
    }
    if (!(prevProvisionName == null)) {
        sb.append("prevProvisionName:");
        sb.append(prevProvisionName);
        sb.append(",");
    }
    if (!(stage == null)) {
        sb.append("stage:");
        sb.append(stage);
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
  
  public A withAttempt(Integer attempt) {
    this.attempt = attempt;
    return (A) this;
  }
  
  public A withClusterDeploymentRef(LocalObjectReference clusterDeploymentRef) {
    this._visitables.remove("clusterDeploymentRef");
    if (clusterDeploymentRef != null) {
        this.clusterDeploymentRef = new LocalObjectReferenceBuilder(clusterDeploymentRef);
        this._visitables.get("clusterDeploymentRef").add(this.clusterDeploymentRef);
    } else {
        this.clusterDeploymentRef = null;
        this._visitables.get("clusterDeploymentRef").remove(this.clusterDeploymentRef);
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
  
  public A withInstallLog(String installLog) {
    this.installLog = installLog;
    return (A) this;
  }
  
  public A withMetadata(Object metadata) {
    this.metadata = metadata;
    return (A) this;
  }
  
  public A withMetadataJSON(String metadataJSON) {
    this.metadataJSON = metadataJSON;
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
  
  public ClusterDeploymentRefNested<A> withNewClusterDeploymentRef() {
    return new ClusterDeploymentRefNested(null);
  }
  
  public A withNewClusterDeploymentRef(String name) {
    return (A) this.withClusterDeploymentRef(new LocalObjectReference(name));
  }
  
  public ClusterDeploymentRefNested<A> withNewClusterDeploymentRefLike(LocalObjectReference item) {
    return new ClusterDeploymentRefNested(item);
  }
  
  public A withPodSpec(PodSpec podSpec) {
    this.podSpec = podSpec;
    return (A) this;
  }
  
  public A withPrevClusterID(String prevClusterID) {
    this.prevClusterID = prevClusterID;
    return (A) this;
  }
  
  public A withPrevInfraID(String prevInfraID) {
    this.prevInfraID = prevInfraID;
    return (A) this;
  }
  
  public A withPrevProvisionName(String prevProvisionName) {
    this.prevProvisionName = prevProvisionName;
    return (A) this;
  }
  
  public A withStage(String stage) {
    this.stage = stage;
    return (A) this;
  }
  public class AdminKubeconfigSecretRefNested<N> extends LocalObjectReferenceFluent<AdminKubeconfigSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    AdminKubeconfigSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterProvisionSpecFluent.this.withAdminKubeconfigSecretRef(builder.build());
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
      return (N) ClusterProvisionSpecFluent.this.withAdminPasswordSecretRef(builder.build());
    }
    
    public N endAdminPasswordSecretRef() {
      return and();
    }
    
  }
  public class ClusterDeploymentRefNested<N> extends LocalObjectReferenceFluent<ClusterDeploymentRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    ClusterDeploymentRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterProvisionSpecFluent.this.withClusterDeploymentRef(builder.build());
    }
    
    public N endClusterDeploymentRef() {
      return and();
    }
    
  }
}