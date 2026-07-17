package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EtcdBackupStatusFluent<A extends io.fabric8.openshift.api.model.operator.v1alpha1.EtcdBackupStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private BackupJobReferenceBuilder backupJob;
  private List<Condition> conditions = new ArrayList<Condition>();

  public EtcdBackupStatusFluent() {
  }
  
  public EtcdBackupStatusFluent(EtcdBackupStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public BackupJobReference buildBackupJob() {
    return this.backupJob != null ? this.backupJob.build() : null;
  }
  
  protected void copyInstance(EtcdBackupStatus instance) {
    instance = instance != null ? instance : new EtcdBackupStatus();
    if (instance != null) {
        this.withBackupJob(instance.getBackupJob());
        this.withConditions(instance.getConditions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackupJobNested<A> editBackupJob() {
    return this.withNewBackupJobLike(Optional.ofNullable(this.buildBackupJob()).orElse(null));
  }
  
  public BackupJobNested<A> editOrNewBackupJob() {
    return this.withNewBackupJobLike(Optional.ofNullable(this.buildBackupJob()).orElse(new BackupJobReferenceBuilder().build()));
  }
  
  public BackupJobNested<A> editOrNewBackupJobLike(BackupJobReference item) {
    return this.withNewBackupJobLike(Optional.ofNullable(this.buildBackupJob()).orElse(item));
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
    EtcdBackupStatusFluent that = (EtcdBackupStatusFluent) o;
    if (!(Objects.equals(backupJob, that.backupJob))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackupJob() {
    return this.backupJob != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(backupJob, conditions, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(backupJob == null)) {
        sb.append("backupJob:");
        sb.append(backupJob);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
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
  
  public A withBackupJob(BackupJobReference backupJob) {
    this._visitables.remove("backupJob");
    if (backupJob != null) {
        this.backupJob = new BackupJobReferenceBuilder(backupJob);
        this._visitables.get("backupJob").add(this.backupJob);
    } else {
        this.backupJob = null;
        this._visitables.get("backupJob").remove(this.backupJob);
    }
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public BackupJobNested<A> withNewBackupJob() {
    return new BackupJobNested(null);
  }
  
  public A withNewBackupJob(String name,String namespace) {
    return (A) this.withBackupJob(new BackupJobReference(name, namespace));
  }
  
  public BackupJobNested<A> withNewBackupJobLike(BackupJobReference item) {
    return new BackupJobNested(item);
  }
  public class BackupJobNested<N> extends BackupJobReferenceFluent<BackupJobNested<N>> implements Nested<N>{
  
    BackupJobReferenceBuilder builder;
  
    BackupJobNested(BackupJobReference item) {
      this.builder = new BackupJobReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) EtcdBackupStatusFluent.this.withBackupJob(builder.build());
    }
    
    public N endBackupJob() {
      return and();
    }
    
  }
}