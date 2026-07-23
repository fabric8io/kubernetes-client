package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class BackupConfigFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.BackupConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer minBackupPeriodSeconds;
  private VeleroBackupConfigBuilder velero;

  public BackupConfigFluent() {
  }
  
  public BackupConfigFluent(BackupConfig instance) {
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
  
  public VeleroBackupConfig buildVelero() {
    return this.velero != null ? this.velero.build() : null;
  }
  
  protected void copyInstance(BackupConfig instance) {
    instance = instance != null ? instance : new BackupConfig();
    if (instance != null) {
        this.withMinBackupPeriodSeconds(instance.getMinBackupPeriodSeconds());
        this.withVelero(instance.getVelero());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VeleroNested<A> editOrNewVelero() {
    return this.withNewVeleroLike(Optional.ofNullable(this.buildVelero()).orElse(new VeleroBackupConfigBuilder().build()));
  }
  
  public VeleroNested<A> editOrNewVeleroLike(VeleroBackupConfig item) {
    return this.withNewVeleroLike(Optional.ofNullable(this.buildVelero()).orElse(item));
  }
  
  public VeleroNested<A> editVelero() {
    return this.withNewVeleroLike(Optional.ofNullable(this.buildVelero()).orElse(null));
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
    BackupConfigFluent that = (BackupConfigFluent) o;
    if (!(Objects.equals(minBackupPeriodSeconds, that.minBackupPeriodSeconds))) {
      return false;
    }
    if (!(Objects.equals(velero, that.velero))) {
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
  
  public Integer getMinBackupPeriodSeconds() {
    return this.minBackupPeriodSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMinBackupPeriodSeconds() {
    return this.minBackupPeriodSeconds != null;
  }
  
  public boolean hasVelero() {
    return this.velero != null;
  }
  
  public int hashCode() {
    return Objects.hash(minBackupPeriodSeconds, velero, additionalProperties);
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
    if (!(minBackupPeriodSeconds == null)) {
        sb.append("minBackupPeriodSeconds:");
        sb.append(minBackupPeriodSeconds);
        sb.append(",");
    }
    if (!(velero == null)) {
        sb.append("velero:");
        sb.append(velero);
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
  
  public A withMinBackupPeriodSeconds(Integer minBackupPeriodSeconds) {
    this.minBackupPeriodSeconds = minBackupPeriodSeconds;
    return (A) this;
  }
  
  public VeleroNested<A> withNewVelero() {
    return new VeleroNested(null);
  }
  
  public A withNewVelero(Boolean enabled) {
    return (A) this.withVelero(new VeleroBackupConfig(enabled));
  }
  
  public VeleroNested<A> withNewVeleroLike(VeleroBackupConfig item) {
    return new VeleroNested(item);
  }
  
  public A withVelero(VeleroBackupConfig velero) {
    this._visitables.remove("velero");
    if (velero != null) {
        this.velero = new VeleroBackupConfigBuilder(velero);
        this._visitables.get("velero").add(this.velero);
    } else {
        this.velero = null;
        this._visitables.get("velero").remove(this.velero);
    }
    return (A) this;
  }
  public class VeleroNested<N> extends VeleroBackupConfigFluent<VeleroNested<N>> implements Nested<N>{
  
    VeleroBackupConfigBuilder builder;
  
    VeleroNested(VeleroBackupConfig item) {
      this.builder = new VeleroBackupConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) BackupConfigFluent.this.withVelero(builder.build());
    }
    
    public N endVelero() {
      return and();
    }
    
  }
}