package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
public class MachineConfigPoolStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineConfigPoolStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<CertExpiryBuilder> certExpirys = new ArrayList<CertExpiryBuilder>();
  private ArrayList<MachineConfigPoolConditionBuilder> conditions = new ArrayList<MachineConfigPoolConditionBuilder>();
  private MachineConfigPoolStatusConfigurationBuilder configuration;
  private Integer degradedMachineCount;
  private Integer machineCount;
  private Long observedGeneration;
  private ArrayList<PoolSynchronizerStatusBuilder> poolSynchronizersStatus = new ArrayList<PoolSynchronizerStatusBuilder>();
  private Integer readyMachineCount;
  private Integer unavailableMachineCount;
  private Integer updatedMachineCount;

  public MachineConfigPoolStatusFluent() {
  }
  
  public MachineConfigPoolStatusFluent(MachineConfigPoolStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToCertExpirys(Collection<CertExpiry> items) {
    if (this.certExpirys == null) {
      this.certExpirys = new ArrayList();
    }
    for (CertExpiry item : items) {
        CertExpiryBuilder builder = new CertExpiryBuilder(item);
        _visitables.get("certExpirys").add(builder);
        this.certExpirys.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<MachineConfigPoolCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (MachineConfigPoolCondition item : items) {
        MachineConfigPoolConditionBuilder builder = new MachineConfigPoolConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPoolSynchronizersStatus(Collection<PoolSynchronizerStatus> items) {
    if (this.poolSynchronizersStatus == null) {
      this.poolSynchronizersStatus = new ArrayList();
    }
    for (PoolSynchronizerStatus item : items) {
        PoolSynchronizerStatusBuilder builder = new PoolSynchronizerStatusBuilder(item);
        _visitables.get("poolSynchronizersStatus").add(builder);
        this.poolSynchronizersStatus.add(builder);
    }
    return (A) this;
  }
  
  public CertExpirysNested<A> addNewCertExpiry() {
    return new CertExpirysNested(-1, null);
  }
  
  public A addNewCertExpiry(String bundle,String expiry,String subject) {
    return (A) this.addToCertExpirys(new CertExpiry(bundle, expiry, subject));
  }
  
  public CertExpirysNested<A> addNewCertExpiryLike(CertExpiry item) {
    return new CertExpirysNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new MachineConfigPoolCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(MachineConfigPoolCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public PoolSynchronizersStatusNested<A> addNewPoolSynchronizersStatus() {
    return new PoolSynchronizersStatusNested(-1, null);
  }
  
  public PoolSynchronizersStatusNested<A> addNewPoolSynchronizersStatusLike(PoolSynchronizerStatus item) {
    return new PoolSynchronizersStatusNested(-1, item);
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
  
  public A addToCertExpirys(CertExpiry... items) {
    if (this.certExpirys == null) {
      this.certExpirys = new ArrayList();
    }
    for (CertExpiry item : items) {
        CertExpiryBuilder builder = new CertExpiryBuilder(item);
        _visitables.get("certExpirys").add(builder);
        this.certExpirys.add(builder);
    }
    return (A) this;
  }
  
  public A addToCertExpirys(int index,CertExpiry item) {
    if (this.certExpirys == null) {
      this.certExpirys = new ArrayList();
    }
    CertExpiryBuilder builder = new CertExpiryBuilder(item);
    if (index < 0 || index >= certExpirys.size()) {
        _visitables.get("certExpirys").add(builder);
        certExpirys.add(builder);
    } else {
        _visitables.get("certExpirys").add(builder);
        certExpirys.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(MachineConfigPoolCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (MachineConfigPoolCondition item : items) {
        MachineConfigPoolConditionBuilder builder = new MachineConfigPoolConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,MachineConfigPoolCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    MachineConfigPoolConditionBuilder builder = new MachineConfigPoolConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPoolSynchronizersStatus(PoolSynchronizerStatus... items) {
    if (this.poolSynchronizersStatus == null) {
      this.poolSynchronizersStatus = new ArrayList();
    }
    for (PoolSynchronizerStatus item : items) {
        PoolSynchronizerStatusBuilder builder = new PoolSynchronizerStatusBuilder(item);
        _visitables.get("poolSynchronizersStatus").add(builder);
        this.poolSynchronizersStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addToPoolSynchronizersStatus(int index,PoolSynchronizerStatus item) {
    if (this.poolSynchronizersStatus == null) {
      this.poolSynchronizersStatus = new ArrayList();
    }
    PoolSynchronizerStatusBuilder builder = new PoolSynchronizerStatusBuilder(item);
    if (index < 0 || index >= poolSynchronizersStatus.size()) {
        _visitables.get("poolSynchronizersStatus").add(builder);
        poolSynchronizersStatus.add(builder);
    } else {
        _visitables.get("poolSynchronizersStatus").add(builder);
        poolSynchronizersStatus.add(index, builder);
    }
    return (A) this;
  }
  
  public CertExpiry buildCertExpiry(int index) {
    return this.certExpirys.get(index).build();
  }
  
  public List<CertExpiry> buildCertExpirys() {
    return this.certExpirys != null ? build(certExpirys) : null;
  }
  
  public MachineConfigPoolCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<MachineConfigPoolCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public MachineConfigPoolStatusConfiguration buildConfiguration() {
    return this.configuration != null ? this.configuration.build() : null;
  }
  
  public CertExpiry buildFirstCertExpiry() {
    return this.certExpirys.get(0).build();
  }
  
  public MachineConfigPoolCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public PoolSynchronizerStatus buildFirstPoolSynchronizersStatus() {
    return this.poolSynchronizersStatus.get(0).build();
  }
  
  public CertExpiry buildLastCertExpiry() {
    return this.certExpirys.get(certExpirys.size() - 1).build();
  }
  
  public MachineConfigPoolCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public PoolSynchronizerStatus buildLastPoolSynchronizersStatus() {
    return this.poolSynchronizersStatus.get(poolSynchronizersStatus.size() - 1).build();
  }
  
  public CertExpiry buildMatchingCertExpiry(Predicate<CertExpiryBuilder> predicate) {
      for (CertExpiryBuilder item : certExpirys) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MachineConfigPoolCondition buildMatchingCondition(Predicate<MachineConfigPoolConditionBuilder> predicate) {
      for (MachineConfigPoolConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PoolSynchronizerStatus buildMatchingPoolSynchronizersStatus(Predicate<PoolSynchronizerStatusBuilder> predicate) {
      for (PoolSynchronizerStatusBuilder item : poolSynchronizersStatus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<PoolSynchronizerStatus> buildPoolSynchronizersStatus() {
    return this.poolSynchronizersStatus != null ? build(poolSynchronizersStatus) : null;
  }
  
  public PoolSynchronizerStatus buildPoolSynchronizersStatus(int index) {
    return this.poolSynchronizersStatus.get(index).build();
  }
  
  protected void copyInstance(MachineConfigPoolStatus instance) {
    instance = instance != null ? instance : new MachineConfigPoolStatus();
    if (instance != null) {
        this.withCertExpirys(instance.getCertExpirys());
        this.withConditions(instance.getConditions());
        this.withConfiguration(instance.getConfiguration());
        this.withDegradedMachineCount(instance.getDegradedMachineCount());
        this.withMachineCount(instance.getMachineCount());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withPoolSynchronizersStatus(instance.getPoolSynchronizersStatus());
        this.withReadyMachineCount(instance.getReadyMachineCount());
        this.withUnavailableMachineCount(instance.getUnavailableMachineCount());
        this.withUpdatedMachineCount(instance.getUpdatedMachineCount());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CertExpirysNested<A> editCertExpiry(int index) {
    if (certExpirys.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "certExpirys"));
    }
    return this.setNewCertExpiryLike(index, this.buildCertExpiry(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConfigurationNested<A> editConfiguration() {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(null));
  }
  
  public CertExpirysNested<A> editFirstCertExpiry() {
    if (certExpirys.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "certExpirys"));
    }
    return this.setNewCertExpiryLike(0, this.buildCertExpiry(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public PoolSynchronizersStatusNested<A> editFirstPoolSynchronizersStatus() {
    if (poolSynchronizersStatus.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "poolSynchronizersStatus"));
    }
    return this.setNewPoolSynchronizersStatusLike(0, this.buildPoolSynchronizersStatus(0));
  }
  
  public CertExpirysNested<A> editLastCertExpiry() {
    int index = certExpirys.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "certExpirys"));
    }
    return this.setNewCertExpiryLike(index, this.buildCertExpiry(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public PoolSynchronizersStatusNested<A> editLastPoolSynchronizersStatus() {
    int index = poolSynchronizersStatus.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "poolSynchronizersStatus"));
    }
    return this.setNewPoolSynchronizersStatusLike(index, this.buildPoolSynchronizersStatus(index));
  }
  
  public CertExpirysNested<A> editMatchingCertExpiry(Predicate<CertExpiryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < certExpirys.size();i++) {
      if (predicate.test(certExpirys.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "certExpirys"));
    }
    return this.setNewCertExpiryLike(index, this.buildCertExpiry(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<MachineConfigPoolConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public PoolSynchronizersStatusNested<A> editMatchingPoolSynchronizersStatus(Predicate<PoolSynchronizerStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < poolSynchronizersStatus.size();i++) {
      if (predicate.test(poolSynchronizersStatus.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "poolSynchronizersStatus"));
    }
    return this.setNewPoolSynchronizersStatusLike(index, this.buildPoolSynchronizersStatus(index));
  }
  
  public ConfigurationNested<A> editOrNewConfiguration() {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(new MachineConfigPoolStatusConfigurationBuilder().build()));
  }
  
  public ConfigurationNested<A> editOrNewConfigurationLike(MachineConfigPoolStatusConfiguration item) {
    return this.withNewConfigurationLike(Optional.ofNullable(this.buildConfiguration()).orElse(item));
  }
  
  public PoolSynchronizersStatusNested<A> editPoolSynchronizersStatus(int index) {
    if (poolSynchronizersStatus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "poolSynchronizersStatus"));
    }
    return this.setNewPoolSynchronizersStatusLike(index, this.buildPoolSynchronizersStatus(index));
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
    MachineConfigPoolStatusFluent that = (MachineConfigPoolStatusFluent) o;
    if (!(Objects.equals(certExpirys, that.certExpirys))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(configuration, that.configuration))) {
      return false;
    }
    if (!(Objects.equals(degradedMachineCount, that.degradedMachineCount))) {
      return false;
    }
    if (!(Objects.equals(machineCount, that.machineCount))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(poolSynchronizersStatus, that.poolSynchronizersStatus))) {
      return false;
    }
    if (!(Objects.equals(readyMachineCount, that.readyMachineCount))) {
      return false;
    }
    if (!(Objects.equals(unavailableMachineCount, that.unavailableMachineCount))) {
      return false;
    }
    if (!(Objects.equals(updatedMachineCount, that.updatedMachineCount))) {
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
  
  public Integer getDegradedMachineCount() {
    return this.degradedMachineCount;
  }
  
  public Integer getMachineCount() {
    return this.machineCount;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public Integer getReadyMachineCount() {
    return this.readyMachineCount;
  }
  
  public Integer getUnavailableMachineCount() {
    return this.unavailableMachineCount;
  }
  
  public Integer getUpdatedMachineCount() {
    return this.updatedMachineCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertExpirys() {
    return this.certExpirys != null && !(this.certExpirys.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasConfiguration() {
    return this.configuration != null;
  }
  
  public boolean hasDegradedMachineCount() {
    return this.degradedMachineCount != null;
  }
  
  public boolean hasMachineCount() {
    return this.machineCount != null;
  }
  
  public boolean hasMatchingCertExpiry(Predicate<CertExpiryBuilder> predicate) {
      for (CertExpiryBuilder item : certExpirys) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<MachineConfigPoolConditionBuilder> predicate) {
      for (MachineConfigPoolConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPoolSynchronizersStatus(Predicate<PoolSynchronizerStatusBuilder> predicate) {
      for (PoolSynchronizerStatusBuilder item : poolSynchronizersStatus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasPoolSynchronizersStatus() {
    return this.poolSynchronizersStatus != null && !(this.poolSynchronizersStatus.isEmpty());
  }
  
  public boolean hasReadyMachineCount() {
    return this.readyMachineCount != null;
  }
  
  public boolean hasUnavailableMachineCount() {
    return this.unavailableMachineCount != null;
  }
  
  public boolean hasUpdatedMachineCount() {
    return this.updatedMachineCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(certExpirys, conditions, configuration, degradedMachineCount, machineCount, observedGeneration, poolSynchronizersStatus, readyMachineCount, unavailableMachineCount, updatedMachineCount, additionalProperties);
  }
  
  public A removeAllFromCertExpirys(Collection<CertExpiry> items) {
    if (this.certExpirys == null) {
      return (A) this;
    }
    for (CertExpiry item : items) {
        CertExpiryBuilder builder = new CertExpiryBuilder(item);
        _visitables.get("certExpirys").remove(builder);
        this.certExpirys.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<MachineConfigPoolCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (MachineConfigPoolCondition item : items) {
        MachineConfigPoolConditionBuilder builder = new MachineConfigPoolConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPoolSynchronizersStatus(Collection<PoolSynchronizerStatus> items) {
    if (this.poolSynchronizersStatus == null) {
      return (A) this;
    }
    for (PoolSynchronizerStatus item : items) {
        PoolSynchronizerStatusBuilder builder = new PoolSynchronizerStatusBuilder(item);
        _visitables.get("poolSynchronizersStatus").remove(builder);
        this.poolSynchronizersStatus.remove(builder);
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
  
  public A removeFromCertExpirys(CertExpiry... items) {
    if (this.certExpirys == null) {
      return (A) this;
    }
    for (CertExpiry item : items) {
        CertExpiryBuilder builder = new CertExpiryBuilder(item);
        _visitables.get("certExpirys").remove(builder);
        this.certExpirys.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(MachineConfigPoolCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (MachineConfigPoolCondition item : items) {
        MachineConfigPoolConditionBuilder builder = new MachineConfigPoolConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPoolSynchronizersStatus(PoolSynchronizerStatus... items) {
    if (this.poolSynchronizersStatus == null) {
      return (A) this;
    }
    for (PoolSynchronizerStatus item : items) {
        PoolSynchronizerStatusBuilder builder = new PoolSynchronizerStatusBuilder(item);
        _visitables.get("poolSynchronizersStatus").remove(builder);
        this.poolSynchronizersStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCertExpirys(Predicate<CertExpiryBuilder> predicate) {
    if (certExpirys == null) {
      return (A) this;
    }
    Iterator<CertExpiryBuilder> each = certExpirys.iterator();
    List visitables = _visitables.get("certExpirys");
    while (each.hasNext()) {
        CertExpiryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<MachineConfigPoolConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<MachineConfigPoolConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        MachineConfigPoolConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPoolSynchronizersStatus(Predicate<PoolSynchronizerStatusBuilder> predicate) {
    if (poolSynchronizersStatus == null) {
      return (A) this;
    }
    Iterator<PoolSynchronizerStatusBuilder> each = poolSynchronizersStatus.iterator();
    List visitables = _visitables.get("poolSynchronizersStatus");
    while (each.hasNext()) {
        PoolSynchronizerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CertExpirysNested<A> setNewCertExpiryLike(int index,CertExpiry item) {
    return new CertExpirysNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,MachineConfigPoolCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public PoolSynchronizersStatusNested<A> setNewPoolSynchronizersStatusLike(int index,PoolSynchronizerStatus item) {
    return new PoolSynchronizersStatusNested(index, item);
  }
  
  public A setToCertExpirys(int index,CertExpiry item) {
    if (this.certExpirys == null) {
      this.certExpirys = new ArrayList();
    }
    CertExpiryBuilder builder = new CertExpiryBuilder(item);
    if (index < 0 || index >= certExpirys.size()) {
        _visitables.get("certExpirys").add(builder);
        certExpirys.add(builder);
    } else {
        _visitables.get("certExpirys").add(builder);
        certExpirys.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,MachineConfigPoolCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    MachineConfigPoolConditionBuilder builder = new MachineConfigPoolConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPoolSynchronizersStatus(int index,PoolSynchronizerStatus item) {
    if (this.poolSynchronizersStatus == null) {
      this.poolSynchronizersStatus = new ArrayList();
    }
    PoolSynchronizerStatusBuilder builder = new PoolSynchronizerStatusBuilder(item);
    if (index < 0 || index >= poolSynchronizersStatus.size()) {
        _visitables.get("poolSynchronizersStatus").add(builder);
        poolSynchronizersStatus.add(builder);
    } else {
        _visitables.get("poolSynchronizersStatus").add(builder);
        poolSynchronizersStatus.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certExpirys == null) && !(certExpirys.isEmpty())) {
        sb.append("certExpirys:");
        sb.append(certExpirys);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(configuration == null)) {
        sb.append("configuration:");
        sb.append(configuration);
        sb.append(",");
    }
    if (!(degradedMachineCount == null)) {
        sb.append("degradedMachineCount:");
        sb.append(degradedMachineCount);
        sb.append(",");
    }
    if (!(machineCount == null)) {
        sb.append("machineCount:");
        sb.append(machineCount);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(poolSynchronizersStatus == null) && !(poolSynchronizersStatus.isEmpty())) {
        sb.append("poolSynchronizersStatus:");
        sb.append(poolSynchronizersStatus);
        sb.append(",");
    }
    if (!(readyMachineCount == null)) {
        sb.append("readyMachineCount:");
        sb.append(readyMachineCount);
        sb.append(",");
    }
    if (!(unavailableMachineCount == null)) {
        sb.append("unavailableMachineCount:");
        sb.append(unavailableMachineCount);
        sb.append(",");
    }
    if (!(updatedMachineCount == null)) {
        sb.append("updatedMachineCount:");
        sb.append(updatedMachineCount);
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
  
  public A withCertExpirys(List<CertExpiry> certExpirys) {
    if (this.certExpirys != null) {
      this._visitables.get("certExpirys").clear();
    }
    if (certExpirys != null) {
        this.certExpirys = new ArrayList();
        for (CertExpiry item : certExpirys) {
          this.addToCertExpirys(item);
        }
    } else {
      this.certExpirys = null;
    }
    return (A) this;
  }
  
  public A withCertExpirys(CertExpiry... certExpirys) {
    if (this.certExpirys != null) {
        this.certExpirys.clear();
        _visitables.remove("certExpirys");
    }
    if (certExpirys != null) {
      for (CertExpiry item : certExpirys) {
        this.addToCertExpirys(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<MachineConfigPoolCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (MachineConfigPoolCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(MachineConfigPoolCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (MachineConfigPoolCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withConfiguration(MachineConfigPoolStatusConfiguration configuration) {
    this._visitables.remove("configuration");
    if (configuration != null) {
        this.configuration = new MachineConfigPoolStatusConfigurationBuilder(configuration);
        this._visitables.get("configuration").add(this.configuration);
    } else {
        this.configuration = null;
        this._visitables.get("configuration").remove(this.configuration);
    }
    return (A) this;
  }
  
  public A withDegradedMachineCount(Integer degradedMachineCount) {
    this.degradedMachineCount = degradedMachineCount;
    return (A) this;
  }
  
  public A withMachineCount(Integer machineCount) {
    this.machineCount = machineCount;
    return (A) this;
  }
  
  public ConfigurationNested<A> withNewConfiguration() {
    return new ConfigurationNested(null);
  }
  
  public ConfigurationNested<A> withNewConfigurationLike(MachineConfigPoolStatusConfiguration item) {
    return new ConfigurationNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withPoolSynchronizersStatus(List<PoolSynchronizerStatus> poolSynchronizersStatus) {
    if (this.poolSynchronizersStatus != null) {
      this._visitables.get("poolSynchronizersStatus").clear();
    }
    if (poolSynchronizersStatus != null) {
        this.poolSynchronizersStatus = new ArrayList();
        for (PoolSynchronizerStatus item : poolSynchronizersStatus) {
          this.addToPoolSynchronizersStatus(item);
        }
    } else {
      this.poolSynchronizersStatus = null;
    }
    return (A) this;
  }
  
  public A withPoolSynchronizersStatus(PoolSynchronizerStatus... poolSynchronizersStatus) {
    if (this.poolSynchronizersStatus != null) {
        this.poolSynchronizersStatus.clear();
        _visitables.remove("poolSynchronizersStatus");
    }
    if (poolSynchronizersStatus != null) {
      for (PoolSynchronizerStatus item : poolSynchronizersStatus) {
        this.addToPoolSynchronizersStatus(item);
      }
    }
    return (A) this;
  }
  
  public A withReadyMachineCount(Integer readyMachineCount) {
    this.readyMachineCount = readyMachineCount;
    return (A) this;
  }
  
  public A withUnavailableMachineCount(Integer unavailableMachineCount) {
    this.unavailableMachineCount = unavailableMachineCount;
    return (A) this;
  }
  
  public A withUpdatedMachineCount(Integer updatedMachineCount) {
    this.updatedMachineCount = updatedMachineCount;
    return (A) this;
  }
  public class CertExpirysNested<N> extends CertExpiryFluent<CertExpirysNested<N>> implements Nested<N>{
  
    CertExpiryBuilder builder;
    int index;
  
    CertExpirysNested(int index,CertExpiry item) {
      this.index = index;
      this.builder = new CertExpiryBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolStatusFluent.this.setToCertExpirys(index, builder.build());
    }
    
    public N endCertExpiry() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends MachineConfigPoolConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    MachineConfigPoolConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,MachineConfigPoolCondition item) {
      this.index = index;
      this.builder = new MachineConfigPoolConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ConfigurationNested<N> extends MachineConfigPoolStatusConfigurationFluent<ConfigurationNested<N>> implements Nested<N>{
  
    MachineConfigPoolStatusConfigurationBuilder builder;
  
    ConfigurationNested(MachineConfigPoolStatusConfiguration item) {
      this.builder = new MachineConfigPoolStatusConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolStatusFluent.this.withConfiguration(builder.build());
    }
    
    public N endConfiguration() {
      return and();
    }
    
  }
  public class PoolSynchronizersStatusNested<N> extends PoolSynchronizerStatusFluent<PoolSynchronizersStatusNested<N>> implements Nested<N>{
  
    PoolSynchronizerStatusBuilder builder;
    int index;
  
    PoolSynchronizersStatusNested(int index,PoolSynchronizerStatus item) {
      this.index = index;
      this.builder = new PoolSynchronizerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigPoolStatusFluent.this.setToPoolSynchronizersStatus(index, builder.build());
    }
    
    public N endPoolSynchronizersStatus() {
      return and();
    }
    
  }
}