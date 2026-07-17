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
public class CheckpointSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.CheckpointSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String lastBackupChecksum;
  private BackupReferenceBuilder lastBackupRef;
  private String lastBackupTime;

  public CheckpointSpecFluent() {
  }
  
  public CheckpointSpecFluent(CheckpointSpec instance) {
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
  
  public BackupReference buildLastBackupRef() {
    return this.lastBackupRef != null ? this.lastBackupRef.build() : null;
  }
  
  protected void copyInstance(CheckpointSpec instance) {
    instance = instance != null ? instance : new CheckpointSpec();
    if (instance != null) {
        this.withLastBackupChecksum(instance.getLastBackupChecksum());
        this.withLastBackupRef(instance.getLastBackupRef());
        this.withLastBackupTime(instance.getLastBackupTime());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LastBackupRefNested<A> editLastBackupRef() {
    return this.withNewLastBackupRefLike(Optional.ofNullable(this.buildLastBackupRef()).orElse(null));
  }
  
  public LastBackupRefNested<A> editOrNewLastBackupRef() {
    return this.withNewLastBackupRefLike(Optional.ofNullable(this.buildLastBackupRef()).orElse(new BackupReferenceBuilder().build()));
  }
  
  public LastBackupRefNested<A> editOrNewLastBackupRefLike(BackupReference item) {
    return this.withNewLastBackupRefLike(Optional.ofNullable(this.buildLastBackupRef()).orElse(item));
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
    CheckpointSpecFluent that = (CheckpointSpecFluent) o;
    if (!(Objects.equals(lastBackupChecksum, that.lastBackupChecksum))) {
      return false;
    }
    if (!(Objects.equals(lastBackupRef, that.lastBackupRef))) {
      return false;
    }
    if (!(Objects.equals(lastBackupTime, that.lastBackupTime))) {
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
  
  public String getLastBackupChecksum() {
    return this.lastBackupChecksum;
  }
  
  public String getLastBackupTime() {
    return this.lastBackupTime;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLastBackupChecksum() {
    return this.lastBackupChecksum != null;
  }
  
  public boolean hasLastBackupRef() {
    return this.lastBackupRef != null;
  }
  
  public boolean hasLastBackupTime() {
    return this.lastBackupTime != null;
  }
  
  public int hashCode() {
    return Objects.hash(lastBackupChecksum, lastBackupRef, lastBackupTime, additionalProperties);
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
    if (!(lastBackupChecksum == null)) {
        sb.append("lastBackupChecksum:");
        sb.append(lastBackupChecksum);
        sb.append(",");
    }
    if (!(lastBackupRef == null)) {
        sb.append("lastBackupRef:");
        sb.append(lastBackupRef);
        sb.append(",");
    }
    if (!(lastBackupTime == null)) {
        sb.append("lastBackupTime:");
        sb.append(lastBackupTime);
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
  
  public A withLastBackupChecksum(String lastBackupChecksum) {
    this.lastBackupChecksum = lastBackupChecksum;
    return (A) this;
  }
  
  public A withLastBackupRef(BackupReference lastBackupRef) {
    this._visitables.remove("lastBackupRef");
    if (lastBackupRef != null) {
        this.lastBackupRef = new BackupReferenceBuilder(lastBackupRef);
        this._visitables.get("lastBackupRef").add(this.lastBackupRef);
    } else {
        this.lastBackupRef = null;
        this._visitables.get("lastBackupRef").remove(this.lastBackupRef);
    }
    return (A) this;
  }
  
  public A withLastBackupTime(String lastBackupTime) {
    this.lastBackupTime = lastBackupTime;
    return (A) this;
  }
  
  public LastBackupRefNested<A> withNewLastBackupRef() {
    return new LastBackupRefNested(null);
  }
  
  public A withNewLastBackupRef(String name,String namespace) {
    return (A) this.withLastBackupRef(new BackupReference(name, namespace));
  }
  
  public LastBackupRefNested<A> withNewLastBackupRefLike(BackupReference item) {
    return new LastBackupRefNested(item);
  }
  public class LastBackupRefNested<N> extends BackupReferenceFluent<LastBackupRefNested<N>> implements Nested<N>{
  
    BackupReferenceBuilder builder;
  
    LastBackupRefNested(BackupReference item) {
      this.builder = new BackupReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) CheckpointSpecFluent.this.withLastBackupRef(builder.build());
    }
    
    public N endLastBackupRef() {
      return and();
    }
    
  }
}