package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class ClusterServiceVersionStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String certsLastUpdated;
  private String certsRotateAt;
  private CleanupStatusBuilder cleanup;
  private ArrayList<ClusterServiceVersionConditionBuilder> conditions = new ArrayList<ClusterServiceVersionConditionBuilder>();
  private String lastTransitionTime;
  private String lastUpdateTime;
  private String message;
  private String phase;
  private String reason;
  private ArrayList<RequirementStatusBuilder> requirementStatus = new ArrayList<RequirementStatusBuilder>();

  public ClusterServiceVersionStatusFluent() {
  }
  
  public ClusterServiceVersionStatusFluent(ClusterServiceVersionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<ClusterServiceVersionCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterServiceVersionCondition item : items) {
        ClusterServiceVersionConditionBuilder builder = new ClusterServiceVersionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRequirementStatus(Collection<RequirementStatus> items) {
    if (this.requirementStatus == null) {
      this.requirementStatus = new ArrayList();
    }
    for (RequirementStatus item : items) {
        RequirementStatusBuilder builder = new RequirementStatusBuilder(item);
        _visitables.get("requirementStatus").add(builder);
        this.requirementStatus.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String lastUpdateTime,String message,String phase,String reason) {
    return (A) this.addToConditions(new ClusterServiceVersionCondition(lastTransitionTime, lastUpdateTime, message, phase, reason));
  }
  
  public ConditionsNested<A> addNewConditionLike(ClusterServiceVersionCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public RequirementStatusNested<A> addNewRequirementStatus() {
    return new RequirementStatusNested(-1, null);
  }
  
  public RequirementStatusNested<A> addNewRequirementStatusLike(RequirementStatus item) {
    return new RequirementStatusNested(-1, item);
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
  
  public A addToConditions(ClusterServiceVersionCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterServiceVersionCondition item : items) {
        ClusterServiceVersionConditionBuilder builder = new ClusterServiceVersionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterServiceVersionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterServiceVersionConditionBuilder builder = new ClusterServiceVersionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRequirementStatus(RequirementStatus... items) {
    if (this.requirementStatus == null) {
      this.requirementStatus = new ArrayList();
    }
    for (RequirementStatus item : items) {
        RequirementStatusBuilder builder = new RequirementStatusBuilder(item);
        _visitables.get("requirementStatus").add(builder);
        this.requirementStatus.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequirementStatus(int index,RequirementStatus item) {
    if (this.requirementStatus == null) {
      this.requirementStatus = new ArrayList();
    }
    RequirementStatusBuilder builder = new RequirementStatusBuilder(item);
    if (index < 0 || index >= requirementStatus.size()) {
        _visitables.get("requirementStatus").add(builder);
        requirementStatus.add(builder);
    } else {
        _visitables.get("requirementStatus").add(builder);
        requirementStatus.add(index, builder);
    }
    return (A) this;
  }
  
  public CleanupStatus buildCleanup() {
    return this.cleanup != null ? this.cleanup.build() : null;
  }
  
  public ClusterServiceVersionCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ClusterServiceVersionCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ClusterServiceVersionCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public RequirementStatus buildFirstRequirementStatus() {
    return this.requirementStatus.get(0).build();
  }
  
  public ClusterServiceVersionCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public RequirementStatus buildLastRequirementStatus() {
    return this.requirementStatus.get(requirementStatus.size() - 1).build();
  }
  
  public ClusterServiceVersionCondition buildMatchingCondition(Predicate<ClusterServiceVersionConditionBuilder> predicate) {
      for (ClusterServiceVersionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RequirementStatus buildMatchingRequirementStatus(Predicate<RequirementStatusBuilder> predicate) {
      for (RequirementStatusBuilder item : requirementStatus) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<RequirementStatus> buildRequirementStatus() {
    return this.requirementStatus != null ? build(requirementStatus) : null;
  }
  
  public RequirementStatus buildRequirementStatus(int index) {
    return this.requirementStatus.get(index).build();
  }
  
  protected void copyInstance(ClusterServiceVersionStatus instance) {
    instance = instance != null ? instance : new ClusterServiceVersionStatus();
    if (instance != null) {
        this.withCertsLastUpdated(instance.getCertsLastUpdated());
        this.withCertsRotateAt(instance.getCertsRotateAt());
        this.withCleanup(instance.getCleanup());
        this.withConditions(instance.getConditions());
        this.withLastTransitionTime(instance.getLastTransitionTime());
        this.withLastUpdateTime(instance.getLastUpdateTime());
        this.withMessage(instance.getMessage());
        this.withPhase(instance.getPhase());
        this.withReason(instance.getReason());
        this.withRequirementStatus(instance.getRequirementStatus());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CleanupNested<A> editCleanup() {
    return this.withNewCleanupLike(Optional.ofNullable(this.buildCleanup()).orElse(null));
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
  
  public RequirementStatusNested<A> editFirstRequirementStatus() {
    if (requirementStatus.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "requirementStatus"));
    }
    return this.setNewRequirementStatusLike(0, this.buildRequirementStatus(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public RequirementStatusNested<A> editLastRequirementStatus() {
    int index = requirementStatus.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "requirementStatus"));
    }
    return this.setNewRequirementStatusLike(index, this.buildRequirementStatus(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ClusterServiceVersionConditionBuilder> predicate) {
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
  
  public RequirementStatusNested<A> editMatchingRequirementStatus(Predicate<RequirementStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < requirementStatus.size();i++) {
      if (predicate.test(requirementStatus.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "requirementStatus"));
    }
    return this.setNewRequirementStatusLike(index, this.buildRequirementStatus(index));
  }
  
  public CleanupNested<A> editOrNewCleanup() {
    return this.withNewCleanupLike(Optional.ofNullable(this.buildCleanup()).orElse(new CleanupStatusBuilder().build()));
  }
  
  public CleanupNested<A> editOrNewCleanupLike(CleanupStatus item) {
    return this.withNewCleanupLike(Optional.ofNullable(this.buildCleanup()).orElse(item));
  }
  
  public RequirementStatusNested<A> editRequirementStatus(int index) {
    if (requirementStatus.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "requirementStatus"));
    }
    return this.setNewRequirementStatusLike(index, this.buildRequirementStatus(index));
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
    ClusterServiceVersionStatusFluent that = (ClusterServiceVersionStatusFluent) o;
    if (!(Objects.equals(certsLastUpdated, that.certsLastUpdated))) {
      return false;
    }
    if (!(Objects.equals(certsRotateAt, that.certsRotateAt))) {
      return false;
    }
    if (!(Objects.equals(cleanup, that.cleanup))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(lastTransitionTime, that.lastTransitionTime))) {
      return false;
    }
    if (!(Objects.equals(lastUpdateTime, that.lastUpdateTime))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(phase, that.phase))) {
      return false;
    }
    if (!(Objects.equals(reason, that.reason))) {
      return false;
    }
    if (!(Objects.equals(requirementStatus, that.requirementStatus))) {
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
  
  public String getCertsLastUpdated() {
    return this.certsLastUpdated;
  }
  
  public String getCertsRotateAt() {
    return this.certsRotateAt;
  }
  
  public String getLastTransitionTime() {
    return this.lastTransitionTime;
  }
  
  public String getLastUpdateTime() {
    return this.lastUpdateTime;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getPhase() {
    return this.phase;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCertsLastUpdated() {
    return this.certsLastUpdated != null;
  }
  
  public boolean hasCertsRotateAt() {
    return this.certsRotateAt != null;
  }
  
  public boolean hasCleanup() {
    return this.cleanup != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasLastTransitionTime() {
    return this.lastTransitionTime != null;
  }
  
  public boolean hasLastUpdateTime() {
    return this.lastUpdateTime != null;
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterServiceVersionConditionBuilder> predicate) {
      for (ClusterServiceVersionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequirementStatus(Predicate<RequirementStatusBuilder> predicate) {
      for (RequirementStatusBuilder item : requirementStatus) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasPhase() {
    return this.phase != null;
  }
  
  public boolean hasReason() {
    return this.reason != null;
  }
  
  public boolean hasRequirementStatus() {
    return this.requirementStatus != null && !(this.requirementStatus.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(certsLastUpdated, certsRotateAt, cleanup, conditions, lastTransitionTime, lastUpdateTime, message, phase, reason, requirementStatus, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<ClusterServiceVersionCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterServiceVersionCondition item : items) {
        ClusterServiceVersionConditionBuilder builder = new ClusterServiceVersionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRequirementStatus(Collection<RequirementStatus> items) {
    if (this.requirementStatus == null) {
      return (A) this;
    }
    for (RequirementStatus item : items) {
        RequirementStatusBuilder builder = new RequirementStatusBuilder(item);
        _visitables.get("requirementStatus").remove(builder);
        this.requirementStatus.remove(builder);
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
  
  public A removeFromConditions(ClusterServiceVersionCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterServiceVersionCondition item : items) {
        ClusterServiceVersionConditionBuilder builder = new ClusterServiceVersionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRequirementStatus(RequirementStatus... items) {
    if (this.requirementStatus == null) {
      return (A) this;
    }
    for (RequirementStatus item : items) {
        RequirementStatusBuilder builder = new RequirementStatusBuilder(item);
        _visitables.get("requirementStatus").remove(builder);
        this.requirementStatus.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ClusterServiceVersionConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ClusterServiceVersionConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ClusterServiceVersionConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequirementStatus(Predicate<RequirementStatusBuilder> predicate) {
    if (requirementStatus == null) {
      return (A) this;
    }
    Iterator<RequirementStatusBuilder> each = requirementStatus.iterator();
    List visitables = _visitables.get("requirementStatus");
    while (each.hasNext()) {
        RequirementStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ClusterServiceVersionCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public RequirementStatusNested<A> setNewRequirementStatusLike(int index,RequirementStatus item) {
    return new RequirementStatusNested(index, item);
  }
  
  public A setToConditions(int index,ClusterServiceVersionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterServiceVersionConditionBuilder builder = new ClusterServiceVersionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRequirementStatus(int index,RequirementStatus item) {
    if (this.requirementStatus == null) {
      this.requirementStatus = new ArrayList();
    }
    RequirementStatusBuilder builder = new RequirementStatusBuilder(item);
    if (index < 0 || index >= requirementStatus.size()) {
        _visitables.get("requirementStatus").add(builder);
        requirementStatus.add(builder);
    } else {
        _visitables.get("requirementStatus").add(builder);
        requirementStatus.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(certsLastUpdated == null)) {
        sb.append("certsLastUpdated:");
        sb.append(certsLastUpdated);
        sb.append(",");
    }
    if (!(certsRotateAt == null)) {
        sb.append("certsRotateAt:");
        sb.append(certsRotateAt);
        sb.append(",");
    }
    if (!(cleanup == null)) {
        sb.append("cleanup:");
        sb.append(cleanup);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(lastTransitionTime == null)) {
        sb.append("lastTransitionTime:");
        sb.append(lastTransitionTime);
        sb.append(",");
    }
    if (!(lastUpdateTime == null)) {
        sb.append("lastUpdateTime:");
        sb.append(lastUpdateTime);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(phase == null)) {
        sb.append("phase:");
        sb.append(phase);
        sb.append(",");
    }
    if (!(reason == null)) {
        sb.append("reason:");
        sb.append(reason);
        sb.append(",");
    }
    if (!(requirementStatus == null) && !(requirementStatus.isEmpty())) {
        sb.append("requirementStatus:");
        sb.append(requirementStatus);
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
  
  public A withCertsLastUpdated(String certsLastUpdated) {
    this.certsLastUpdated = certsLastUpdated;
    return (A) this;
  }
  
  public A withCertsRotateAt(String certsRotateAt) {
    this.certsRotateAt = certsRotateAt;
    return (A) this;
  }
  
  public A withCleanup(CleanupStatus cleanup) {
    this._visitables.remove("cleanup");
    if (cleanup != null) {
        this.cleanup = new CleanupStatusBuilder(cleanup);
        this._visitables.get("cleanup").add(this.cleanup);
    } else {
        this.cleanup = null;
        this._visitables.get("cleanup").remove(this.cleanup);
    }
    return (A) this;
  }
  
  public A withConditions(List<ClusterServiceVersionCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterServiceVersionCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterServiceVersionCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterServiceVersionCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withLastTransitionTime(String lastTransitionTime) {
    this.lastTransitionTime = lastTransitionTime;
    return (A) this;
  }
  
  public A withLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public CleanupNested<A> withNewCleanup() {
    return new CleanupNested(null);
  }
  
  public CleanupNested<A> withNewCleanupLike(CleanupStatus item) {
    return new CleanupNested(item);
  }
  
  public A withPhase(String phase) {
    this.phase = phase;
    return (A) this;
  }
  
  public A withReason(String reason) {
    this.reason = reason;
    return (A) this;
  }
  
  public A withRequirementStatus(List<RequirementStatus> requirementStatus) {
    if (this.requirementStatus != null) {
      this._visitables.get("requirementStatus").clear();
    }
    if (requirementStatus != null) {
        this.requirementStatus = new ArrayList();
        for (RequirementStatus item : requirementStatus) {
          this.addToRequirementStatus(item);
        }
    } else {
      this.requirementStatus = null;
    }
    return (A) this;
  }
  
  public A withRequirementStatus(RequirementStatus... requirementStatus) {
    if (this.requirementStatus != null) {
        this.requirementStatus.clear();
        _visitables.remove("requirementStatus");
    }
    if (requirementStatus != null) {
      for (RequirementStatus item : requirementStatus) {
        this.addToRequirementStatus(item);
      }
    }
    return (A) this;
  }
  public class CleanupNested<N> extends CleanupStatusFluent<CleanupNested<N>> implements Nested<N>{
  
    CleanupStatusBuilder builder;
  
    CleanupNested(CleanupStatus item) {
      this.builder = new CleanupStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionStatusFluent.this.withCleanup(builder.build());
    }
    
    public N endCleanup() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends ClusterServiceVersionConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ClusterServiceVersionConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ClusterServiceVersionCondition item) {
      this.index = index;
      this.builder = new ClusterServiceVersionConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class RequirementStatusNested<N> extends RequirementStatusFluent<RequirementStatusNested<N>> implements Nested<N>{
  
    RequirementStatusBuilder builder;
    int index;
  
    RequirementStatusNested(int index,RequirementStatus item) {
      this.index = index;
      this.builder = new RequirementStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterServiceVersionStatusFluent.this.setToRequirementStatus(index, builder.build());
    }
    
    public N endRequirementStatus() {
      return and();
    }
    
  }
}