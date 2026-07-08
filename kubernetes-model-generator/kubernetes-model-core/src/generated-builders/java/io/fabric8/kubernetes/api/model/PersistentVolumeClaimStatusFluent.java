package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class PersistentVolumeClaimStatusFluent<A extends io.fabric8.kubernetes.api.model.PersistentVolumeClaimStatusFluent<A>> extends BaseFluent<A>{

  private List<String> accessModes = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private Map<String,String> allocatedResourceStatuses;
  private Map<String,Quantity> allocatedResources;
  private Map<String,Quantity> capacity;
  private ArrayList<PersistentVolumeClaimConditionBuilder> conditions = new ArrayList<PersistentVolumeClaimConditionBuilder>();
  private String currentVolumeAttributesClassName;
  private ModifyVolumeStatusBuilder modifyVolumeStatus;
  private String phase;

  public PersistentVolumeClaimStatusFluent() {
  }
  
  public PersistentVolumeClaimStatusFluent(PersistentVolumeClaimStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAccessModes(Collection<String> items) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    for (String item : items) {
      this.accessModes.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<PersistentVolumeClaimCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PersistentVolumeClaimCondition item : items) {
        PersistentVolumeClaimConditionBuilder builder = new PersistentVolumeClaimConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(PersistentVolumeClaimCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public A addToAccessModes(String... items) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    for (String item : items) {
      this.accessModes.add(item);
    }
    return (A) this;
  }
  
  public A addToAccessModes(int index,String item) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    this.accessModes.add(index, item);
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
  
  public A addToAllocatedResourceStatuses(Map<String,String> map) {
    if (this.allocatedResourceStatuses == null && map != null) {
      this.allocatedResourceStatuses = new LinkedHashMap();
    }
    if (map != null) {
      this.allocatedResourceStatuses.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAllocatedResourceStatuses(String key,String value) {
    if (this.allocatedResourceStatuses == null && key != null && value != null) {
      this.allocatedResourceStatuses = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.allocatedResourceStatuses.put(key, value);
    }
    return (A) this;
  }
  
  public A addToAllocatedResources(Map<String,Quantity> map) {
    if (this.allocatedResources == null && map != null) {
      this.allocatedResources = new LinkedHashMap();
    }
    if (map != null) {
      this.allocatedResources.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAllocatedResources(String key,Quantity value) {
    if (this.allocatedResources == null && key != null && value != null) {
      this.allocatedResources = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.allocatedResources.put(key, value);
    }
    return (A) this;
  }
  
  public A addToCapacity(Map<String,Quantity> map) {
    if (this.capacity == null && map != null) {
      this.capacity = new LinkedHashMap();
    }
    if (map != null) {
      this.capacity.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCapacity(String key,Quantity value) {
    if (this.capacity == null && key != null && value != null) {
      this.capacity = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.capacity.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConditions(PersistentVolumeClaimCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (PersistentVolumeClaimCondition item : items) {
        PersistentVolumeClaimConditionBuilder builder = new PersistentVolumeClaimConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,PersistentVolumeClaimCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PersistentVolumeClaimConditionBuilder builder = new PersistentVolumeClaimConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public PersistentVolumeClaimCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<PersistentVolumeClaimCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public PersistentVolumeClaimCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public PersistentVolumeClaimCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public PersistentVolumeClaimCondition buildMatchingCondition(Predicate<PersistentVolumeClaimConditionBuilder> predicate) {
      for (PersistentVolumeClaimConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ModifyVolumeStatus buildModifyVolumeStatus() {
    return this.modifyVolumeStatus != null ? this.modifyVolumeStatus.build() : null;
  }
  
  protected void copyInstance(PersistentVolumeClaimStatus instance) {
    instance = instance != null ? instance : new PersistentVolumeClaimStatus();
    if (instance != null) {
        this.withAccessModes(instance.getAccessModes());
        this.withAllocatedResourceStatuses(instance.getAllocatedResourceStatuses());
        this.withAllocatedResources(instance.getAllocatedResources());
        this.withCapacity(instance.getCapacity());
        this.withConditions(instance.getConditions());
        this.withCurrentVolumeAttributesClassName(instance.getCurrentVolumeAttributesClassName());
        this.withModifyVolumeStatus(instance.getModifyVolumeStatus());
        this.withPhase(instance.getPhase());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<PersistentVolumeClaimConditionBuilder> predicate) {
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
  
  public ModifyVolumeStatusNested<A> editModifyVolumeStatus() {
    return this.withNewModifyVolumeStatusLike(Optional.ofNullable(this.buildModifyVolumeStatus()).orElse(null));
  }
  
  public ModifyVolumeStatusNested<A> editOrNewModifyVolumeStatus() {
    return this.withNewModifyVolumeStatusLike(Optional.ofNullable(this.buildModifyVolumeStatus()).orElse(new ModifyVolumeStatusBuilder().build()));
  }
  
  public ModifyVolumeStatusNested<A> editOrNewModifyVolumeStatusLike(ModifyVolumeStatus item) {
    return this.withNewModifyVolumeStatusLike(Optional.ofNullable(this.buildModifyVolumeStatus()).orElse(item));
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
    PersistentVolumeClaimStatusFluent that = (PersistentVolumeClaimStatusFluent) o;
    if (!(Objects.equals(accessModes, that.accessModes))) {
      return false;
    }
    if (!(Objects.equals(allocatedResourceStatuses, that.allocatedResourceStatuses))) {
      return false;
    }
    if (!(Objects.equals(allocatedResources, that.allocatedResources))) {
      return false;
    }
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentVolumeAttributesClassName, that.currentVolumeAttributesClassName))) {
      return false;
    }
    if (!(Objects.equals(modifyVolumeStatus, that.modifyVolumeStatus))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccessMode(int index) {
    return this.accessModes.get(index);
  }
  
  public List<String> getAccessModes() {
    return this.accessModes;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Map<String,String> getAllocatedResourceStatuses() {
    return this.allocatedResourceStatuses;
  }
  
  public Map<String,Quantity> getAllocatedResources() {
    return this.allocatedResources;
  }
  
  public Map<String,Quantity> getCapacity() {
    return this.capacity;
  }
  
  public String getCurrentVolumeAttributesClassName() {
    return this.currentVolumeAttributesClassName;
  }
  
  public String getFirstAccessMode() {
    return this.accessModes.get(0);
  }
  
  public String getLastAccessMode() {
    return this.accessModes.get(accessModes.size() - 1);
  }
  
  public String getMatchingAccessMode(Predicate<String> predicate) {
      for (String item : accessModes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public boolean hasAccessModes() {
    return this.accessModes != null && !(this.accessModes.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAllocatedResourceStatuses() {
    return this.allocatedResourceStatuses != null;
  }
  
  public boolean hasAllocatedResources() {
    return this.allocatedResources != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCurrentVolumeAttributesClassName() {
    return this.currentVolumeAttributesClassName != null;
  }
  
  public boolean hasMatchingAccessMode(Predicate<String> predicate) {
      for (String item : accessModes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<PersistentVolumeClaimConditionBuilder> predicate) {
      for (PersistentVolumeClaimConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasModifyVolumeStatus() {
    return this.modifyVolumeStatus != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessModes, allocatedResourceStatuses, allocatedResources, capacity, conditions, currentVolumeAttributesClassName, modifyVolumeStatus, phase, additionalProperties);
  }
  
  public A removeAllFromAccessModes(Collection<String> items) {
    if (this.accessModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.accessModes.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<PersistentVolumeClaimCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PersistentVolumeClaimCondition item : items) {
        PersistentVolumeClaimConditionBuilder builder = new PersistentVolumeClaimConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAccessModes(String... items) {
    if (this.accessModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.accessModes.remove(item);
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
  
  public A removeFromAllocatedResourceStatuses(String key) {
    if (this.allocatedResourceStatuses == null) {
      return (A) this;
    }
    if (key != null && this.allocatedResourceStatuses != null) {
      this.allocatedResourceStatuses.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAllocatedResourceStatuses(Map<String,String> map) {
    if (this.allocatedResourceStatuses == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.allocatedResourceStatuses != null) {
          this.allocatedResourceStatuses.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromAllocatedResources(String key) {
    if (this.allocatedResources == null) {
      return (A) this;
    }
    if (key != null && this.allocatedResources != null) {
      this.allocatedResources.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAllocatedResources(Map<String,Quantity> map) {
    if (this.allocatedResources == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.allocatedResources != null) {
          this.allocatedResources.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromCapacity(String key) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (key != null && this.capacity != null) {
      this.capacity.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCapacity(Map<String,Quantity> map) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.capacity != null) {
          this.capacity.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromConditions(PersistentVolumeClaimCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (PersistentVolumeClaimCondition item : items) {
        PersistentVolumeClaimConditionBuilder builder = new PersistentVolumeClaimConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<PersistentVolumeClaimConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<PersistentVolumeClaimConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        PersistentVolumeClaimConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,PersistentVolumeClaimCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToAccessModes(int index,String item) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    this.accessModes.set(index, item);
    return (A) this;
  }
  
  public A setToConditions(int index,PersistentVolumeClaimCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    PersistentVolumeClaimConditionBuilder builder = new PersistentVolumeClaimConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessModes == null) && !(accessModes.isEmpty())) {
        sb.append("accessModes:");
        sb.append(accessModes);
        sb.append(",");
    }
    if (!(allocatedResourceStatuses == null) && !(allocatedResourceStatuses.isEmpty())) {
        sb.append("allocatedResourceStatuses:");
        sb.append(allocatedResourceStatuses);
        sb.append(",");
    }
    if (!(allocatedResources == null) && !(allocatedResources.isEmpty())) {
        sb.append("allocatedResources:");
        sb.append(allocatedResources);
        sb.append(",");
    }
    if (!(capacity == null) && !(capacity.isEmpty())) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(currentVolumeAttributesClassName == null)) {
        sb.append("currentVolumeAttributesClassName:");
        sb.append(currentVolumeAttributesClassName);
        sb.append(",");
    }
    if (!(modifyVolumeStatus == null)) {
        sb.append("modifyVolumeStatus:");
        sb.append(modifyVolumeStatus);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessModes(List<String> accessModes) {
    if (accessModes != null) {
        this.accessModes = new ArrayList();
        for (String item : accessModes) {
          this.addToAccessModes(item);
        }
    } else {
      this.accessModes = null;
    }
    return (A) this;
  }
  
  public A withAccessModes(String... accessModes) {
    if (this.accessModes != null) {
        this.accessModes.clear();
        _visitables.remove("accessModes");
    }
    if (accessModes != null) {
      for (String item : accessModes) {
        this.addToAccessModes(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public <K,V>A withAllocatedResourceStatuses(Map<String,String> allocatedResourceStatuses) {
    if (allocatedResourceStatuses == null) {
      this.allocatedResourceStatuses = null;
    } else {
      this.allocatedResourceStatuses = new LinkedHashMap(allocatedResourceStatuses);
    }
    return (A) this;
  }
  
  public <K,V>A withAllocatedResources(Map<String,Quantity> allocatedResources) {
    if (allocatedResources == null) {
      this.allocatedResources = null;
    } else {
      this.allocatedResources = new LinkedHashMap(allocatedResources);
    }
    return (A) this;
  }
  
  public <K,V>A withCapacity(Map<String,Quantity> capacity) {
    if (capacity == null) {
      this.capacity = null;
    } else {
      this.capacity = new LinkedHashMap(capacity);
    }
    return (A) this;
  }
  
  public A withConditions(List<PersistentVolumeClaimCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (PersistentVolumeClaimCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(PersistentVolumeClaimCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (PersistentVolumeClaimCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentVolumeAttributesClassName(String currentVolumeAttributesClassName) {
    this.currentVolumeAttributesClassName = currentVolumeAttributesClassName;
    return (A) this;
  }
  
  public A withModifyVolumeStatus(ModifyVolumeStatus modifyVolumeStatus) {
    this._visitables.remove("modifyVolumeStatus");
    if (modifyVolumeStatus != null) {
        this.modifyVolumeStatus = new ModifyVolumeStatusBuilder(modifyVolumeStatus);
        this._visitables.get("modifyVolumeStatus").add(this.modifyVolumeStatus);
    } else {
        this.modifyVolumeStatus = null;
        this._visitables.get("modifyVolumeStatus").remove(this.modifyVolumeStatus);
    }
    return (A) this;
  }
  
  public ModifyVolumeStatusNested<A> withNewModifyVolumeStatus() {
    return new ModifyVolumeStatusNested(null);
  }
  
  public A withNewModifyVolumeStatus(String status,String targetVolumeAttributesClassName) {
    return (A) this.withModifyVolumeStatus(new ModifyVolumeStatus(status, targetVolumeAttributesClassName));
  }
  
  public ModifyVolumeStatusNested<A> withNewModifyVolumeStatusLike(ModifyVolumeStatus item) {
    return new ModifyVolumeStatusNested(item);
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  public class ConditionsNested<N> extends PersistentVolumeClaimConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    PersistentVolumeClaimConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,PersistentVolumeClaimCondition item) {
      this.index = index;
      this.builder = new PersistentVolumeClaimConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeClaimStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ModifyVolumeStatusNested<N> extends ModifyVolumeStatusFluent<ModifyVolumeStatusNested<N>> implements Nested<N>{
  
    ModifyVolumeStatusBuilder builder;
  
    ModifyVolumeStatusNested(ModifyVolumeStatus item) {
      this.builder = new ModifyVolumeStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeClaimStatusFluent.this.withModifyVolumeStatus(builder.build());
    }
    
    public N endModifyVolumeStatus() {
      return and();
    }
    
  }
}