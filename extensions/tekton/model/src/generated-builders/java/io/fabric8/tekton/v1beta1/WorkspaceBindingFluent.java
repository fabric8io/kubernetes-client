package io.fabric8.tekton.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.CSIVolumeSource;
import io.fabric8.kubernetes.api.model.ConfigMapVolumeSource;
import io.fabric8.kubernetes.api.model.EmptyDirVolumeSource;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimBuilder;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimFluent;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimVolumeSource;
import io.fabric8.kubernetes.api.model.ProjectedVolumeSource;
import io.fabric8.kubernetes.api.model.SecretVolumeSource;
import java.lang.Boolean;
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
public class WorkspaceBindingFluent<A extends io.fabric8.tekton.v1beta1.WorkspaceBindingFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConfigMapVolumeSource configMap;
  private CSIVolumeSource csi;
  private EmptyDirVolumeSource emptyDir;
  private String name;
  private PersistentVolumeClaimVolumeSource persistentVolumeClaim;
  private ProjectedVolumeSource projected;
  private SecretVolumeSource secret;
  private String subPath;
  private PersistentVolumeClaimBuilder volumeClaimTemplate;

  public WorkspaceBindingFluent() {
  }
  
  public WorkspaceBindingFluent(WorkspaceBinding instance) {
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
  
  public PersistentVolumeClaim buildVolumeClaimTemplate() {
    return this.volumeClaimTemplate != null ? this.volumeClaimTemplate.build() : null;
  }
  
  protected void copyInstance(WorkspaceBinding instance) {
    instance = instance != null ? instance : new WorkspaceBinding();
    if (instance != null) {
        this.withConfigMap(instance.getConfigMap());
        this.withCsi(instance.getCsi());
        this.withEmptyDir(instance.getEmptyDir());
        this.withName(instance.getName());
        this.withPersistentVolumeClaim(instance.getPersistentVolumeClaim());
        this.withProjected(instance.getProjected());
        this.withSecret(instance.getSecret());
        this.withSubPath(instance.getSubPath());
        this.withVolumeClaimTemplate(instance.getVolumeClaimTemplate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VolumeClaimTemplateNested<A> editOrNewVolumeClaimTemplate() {
    return this.withNewVolumeClaimTemplateLike(Optional.ofNullable(this.buildVolumeClaimTemplate()).orElse(new PersistentVolumeClaimBuilder().build()));
  }
  
  public VolumeClaimTemplateNested<A> editOrNewVolumeClaimTemplateLike(PersistentVolumeClaim item) {
    return this.withNewVolumeClaimTemplateLike(Optional.ofNullable(this.buildVolumeClaimTemplate()).orElse(item));
  }
  
  public VolumeClaimTemplateNested<A> editVolumeClaimTemplate() {
    return this.withNewVolumeClaimTemplateLike(Optional.ofNullable(this.buildVolumeClaimTemplate()).orElse(null));
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
    WorkspaceBindingFluent that = (WorkspaceBindingFluent) o;
    if (!(Objects.equals(configMap, that.configMap))) {
      return false;
    }
    if (!(Objects.equals(csi, that.csi))) {
      return false;
    }
    if (!(Objects.equals(emptyDir, that.emptyDir))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(persistentVolumeClaim, that.persistentVolumeClaim))) {
      return false;
    }
    if (!(Objects.equals(projected, that.projected))) {
      return false;
    }
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(subPath, that.subPath))) {
      return false;
    }
    if (!(Objects.equals(volumeClaimTemplate, that.volumeClaimTemplate))) {
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
  
  public ConfigMapVolumeSource getConfigMap() {
    return this.configMap;
  }
  
  public CSIVolumeSource getCsi() {
    return this.csi;
  }
  
  public EmptyDirVolumeSource getEmptyDir() {
    return this.emptyDir;
  }
  
  public String getName() {
    return this.name;
  }
  
  public PersistentVolumeClaimVolumeSource getPersistentVolumeClaim() {
    return this.persistentVolumeClaim;
  }
  
  public ProjectedVolumeSource getProjected() {
    return this.projected;
  }
  
  public SecretVolumeSource getSecret() {
    return this.secret;
  }
  
  public String getSubPath() {
    return this.subPath;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConfigMap() {
    return this.configMap != null;
  }
  
  public boolean hasCsi() {
    return this.csi != null;
  }
  
  public boolean hasEmptyDir() {
    return this.emptyDir != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPersistentVolumeClaim() {
    return this.persistentVolumeClaim != null;
  }
  
  public boolean hasProjected() {
    return this.projected != null;
  }
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasSubPath() {
    return this.subPath != null;
  }
  
  public boolean hasVolumeClaimTemplate() {
    return this.volumeClaimTemplate != null;
  }
  
  public int hashCode() {
    return Objects.hash(configMap, csi, emptyDir, name, persistentVolumeClaim, projected, secret, subPath, volumeClaimTemplate, additionalProperties);
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
    if (!(configMap == null)) {
        sb.append("configMap:");
        sb.append(configMap);
        sb.append(",");
    }
    if (!(csi == null)) {
        sb.append("csi:");
        sb.append(csi);
        sb.append(",");
    }
    if (!(emptyDir == null)) {
        sb.append("emptyDir:");
        sb.append(emptyDir);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(persistentVolumeClaim == null)) {
        sb.append("persistentVolumeClaim:");
        sb.append(persistentVolumeClaim);
        sb.append(",");
    }
    if (!(projected == null)) {
        sb.append("projected:");
        sb.append(projected);
        sb.append(",");
    }
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(subPath == null)) {
        sb.append("subPath:");
        sb.append(subPath);
        sb.append(",");
    }
    if (!(volumeClaimTemplate == null)) {
        sb.append("volumeClaimTemplate:");
        sb.append(volumeClaimTemplate);
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
  
  public A withConfigMap(ConfigMapVolumeSource configMap) {
    this.configMap = configMap;
    return (A) this;
  }
  
  public A withCsi(CSIVolumeSource csi) {
    this.csi = csi;
    return (A) this;
  }
  
  public A withEmptyDir(EmptyDirVolumeSource emptyDir) {
    this.emptyDir = emptyDir;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNewPersistentVolumeClaim(String claimName,Boolean readOnly) {
    return (A) this.withPersistentVolumeClaim(new PersistentVolumeClaimVolumeSource(claimName, readOnly));
  }
  
  public VolumeClaimTemplateNested<A> withNewVolumeClaimTemplate() {
    return new VolumeClaimTemplateNested(null);
  }
  
  public VolumeClaimTemplateNested<A> withNewVolumeClaimTemplateLike(PersistentVolumeClaim item) {
    return new VolumeClaimTemplateNested(item);
  }
  
  public A withPersistentVolumeClaim(PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
    this.persistentVolumeClaim = persistentVolumeClaim;
    return (A) this;
  }
  
  public A withProjected(ProjectedVolumeSource projected) {
    this.projected = projected;
    return (A) this;
  }
  
  public A withSecret(SecretVolumeSource secret) {
    this.secret = secret;
    return (A) this;
  }
  
  public A withSubPath(String subPath) {
    this.subPath = subPath;
    return (A) this;
  }
  
  public A withVolumeClaimTemplate(PersistentVolumeClaim volumeClaimTemplate) {
    this._visitables.remove("volumeClaimTemplate");
    if (volumeClaimTemplate != null) {
        this.volumeClaimTemplate = new PersistentVolumeClaimBuilder(volumeClaimTemplate);
        this._visitables.get("volumeClaimTemplate").add(this.volumeClaimTemplate);
    } else {
        this.volumeClaimTemplate = null;
        this._visitables.get("volumeClaimTemplate").remove(this.volumeClaimTemplate);
    }
    return (A) this;
  }
  public class VolumeClaimTemplateNested<N> extends PersistentVolumeClaimFluent<VolumeClaimTemplateNested<N>> implements Nested<N>{
  
    PersistentVolumeClaimBuilder builder;
  
    VolumeClaimTemplateNested(PersistentVolumeClaim item) {
      this.builder = new PersistentVolumeClaimBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkspaceBindingFluent.this.withVolumeClaimTemplate(builder.build());
    }
    
    public N endVolumeClaimTemplate() {
      return and();
    }
    
  }
}