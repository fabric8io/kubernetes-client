package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.kubernetes.api.model.TypedLocalObjectReference;
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
public class WorkflowNodeStatusFluent<A extends io.fabric8.chaosmesh.v1alpha1.WorkflowNodeStatusFluent<A>> extends BaseFluent<A>{

  private ArrayList<LocalObjectReferenceBuilder> activeChildren = new ArrayList<LocalObjectReferenceBuilder>();
  private Map<String,Object> additionalProperties;
  private TypedLocalObjectReference chaosResource;
  private ConditionalBranchesStatusBuilder conditionalBranchesStatus;
  private ArrayList<WorkflowNodeConditionBuilder> conditions = new ArrayList<WorkflowNodeConditionBuilder>();
  private ArrayList<LocalObjectReferenceBuilder> finishedChildren = new ArrayList<LocalObjectReferenceBuilder>();

  public WorkflowNodeStatusFluent() {
  }
  
  public WorkflowNodeStatusFluent(WorkflowNodeStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToActiveChildren(Collection<LocalObjectReference> items) {
    if (this.activeChildren == null) {
      this.activeChildren = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("activeChildren").add(builder);
        this.activeChildren.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<WorkflowNodeCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (WorkflowNodeCondition item : items) {
        WorkflowNodeConditionBuilder builder = new WorkflowNodeConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFinishedChildren(Collection<LocalObjectReference> items) {
    if (this.finishedChildren == null) {
      this.finishedChildren = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("finishedChildren").add(builder);
        this.finishedChildren.add(builder);
    }
    return (A) this;
  }
  
  public ActiveChildrenNested<A> addNewActiveChild() {
    return new ActiveChildrenNested(-1, null);
  }
  
  public A addNewActiveChild(String name) {
    return (A) this.addToActiveChildren(new LocalObjectReference(name));
  }
  
  public ActiveChildrenNested<A> addNewActiveChildLike(LocalObjectReference item) {
    return new ActiveChildrenNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String reason,String status,String type) {
    return (A) this.addToConditions(new WorkflowNodeCondition(reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(WorkflowNodeCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public FinishedChildrenNested<A> addNewFinishedChild() {
    return new FinishedChildrenNested(-1, null);
  }
  
  public A addNewFinishedChild(String name) {
    return (A) this.addToFinishedChildren(new LocalObjectReference(name));
  }
  
  public FinishedChildrenNested<A> addNewFinishedChildLike(LocalObjectReference item) {
    return new FinishedChildrenNested(-1, item);
  }
  
  public A addToActiveChildren(LocalObjectReference... items) {
    if (this.activeChildren == null) {
      this.activeChildren = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("activeChildren").add(builder);
        this.activeChildren.add(builder);
    }
    return (A) this;
  }
  
  public A addToActiveChildren(int index,LocalObjectReference item) {
    if (this.activeChildren == null) {
      this.activeChildren = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= activeChildren.size()) {
        _visitables.get("activeChildren").add(builder);
        activeChildren.add(builder);
    } else {
        _visitables.get("activeChildren").add(builder);
        activeChildren.add(index, builder);
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
  
  public A addToConditions(WorkflowNodeCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (WorkflowNodeCondition item : items) {
        WorkflowNodeConditionBuilder builder = new WorkflowNodeConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,WorkflowNodeCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    WorkflowNodeConditionBuilder builder = new WorkflowNodeConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFinishedChildren(LocalObjectReference... items) {
    if (this.finishedChildren == null) {
      this.finishedChildren = new ArrayList();
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("finishedChildren").add(builder);
        this.finishedChildren.add(builder);
    }
    return (A) this;
  }
  
  public A addToFinishedChildren(int index,LocalObjectReference item) {
    if (this.finishedChildren == null) {
      this.finishedChildren = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= finishedChildren.size()) {
        _visitables.get("finishedChildren").add(builder);
        finishedChildren.add(builder);
    } else {
        _visitables.get("finishedChildren").add(builder);
        finishedChildren.add(index, builder);
    }
    return (A) this;
  }
  
  public LocalObjectReference buildActiveChild(int index) {
    return this.activeChildren.get(index).build();
  }
  
  public List<LocalObjectReference> buildActiveChildren() {
    return this.activeChildren != null ? build(activeChildren) : null;
  }
  
  public WorkflowNodeCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public ConditionalBranchesStatus buildConditionalBranchesStatus() {
    return this.conditionalBranchesStatus != null ? this.conditionalBranchesStatus.build() : null;
  }
  
  public List<WorkflowNodeCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public LocalObjectReference buildFinishedChild(int index) {
    return this.finishedChildren.get(index).build();
  }
  
  public List<LocalObjectReference> buildFinishedChildren() {
    return this.finishedChildren != null ? build(finishedChildren) : null;
  }
  
  public LocalObjectReference buildFirstActiveChild() {
    return this.activeChildren.get(0).build();
  }
  
  public WorkflowNodeCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public LocalObjectReference buildFirstFinishedChild() {
    return this.finishedChildren.get(0).build();
  }
  
  public LocalObjectReference buildLastActiveChild() {
    return this.activeChildren.get(activeChildren.size() - 1).build();
  }
  
  public WorkflowNodeCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public LocalObjectReference buildLastFinishedChild() {
    return this.finishedChildren.get(finishedChildren.size() - 1).build();
  }
  
  public LocalObjectReference buildMatchingActiveChild(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : activeChildren) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public WorkflowNodeCondition buildMatchingCondition(Predicate<WorkflowNodeConditionBuilder> predicate) {
      for (WorkflowNodeConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LocalObjectReference buildMatchingFinishedChild(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : finishedChildren) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(WorkflowNodeStatus instance) {
    instance = instance != null ? instance : new WorkflowNodeStatus();
    if (instance != null) {
        this.withActiveChildren(instance.getActiveChildren());
        this.withChaosResource(instance.getChaosResource());
        this.withConditionalBranchesStatus(instance.getConditionalBranchesStatus());
        this.withConditions(instance.getConditions());
        this.withFinishedChildren(instance.getFinishedChildren());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActiveChildrenNested<A> editActiveChild(int index) {
    if (activeChildren.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "activeChildren"));
    }
    return this.setNewActiveChildLike(index, this.buildActiveChild(index));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionalBranchesStatusNested<A> editConditionalBranchesStatus() {
    return this.withNewConditionalBranchesStatusLike(Optional.ofNullable(this.buildConditionalBranchesStatus()).orElse(null));
  }
  
  public FinishedChildrenNested<A> editFinishedChild(int index) {
    if (finishedChildren.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "finishedChildren"));
    }
    return this.setNewFinishedChildLike(index, this.buildFinishedChild(index));
  }
  
  public ActiveChildrenNested<A> editFirstActiveChild() {
    if (activeChildren.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "activeChildren"));
    }
    return this.setNewActiveChildLike(0, this.buildActiveChild(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public FinishedChildrenNested<A> editFirstFinishedChild() {
    if (finishedChildren.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "finishedChildren"));
    }
    return this.setNewFinishedChildLike(0, this.buildFinishedChild(0));
  }
  
  public ActiveChildrenNested<A> editLastActiveChild() {
    int index = activeChildren.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "activeChildren"));
    }
    return this.setNewActiveChildLike(index, this.buildActiveChild(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public FinishedChildrenNested<A> editLastFinishedChild() {
    int index = finishedChildren.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "finishedChildren"));
    }
    return this.setNewFinishedChildLike(index, this.buildFinishedChild(index));
  }
  
  public ActiveChildrenNested<A> editMatchingActiveChild(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < activeChildren.size();i++) {
      if (predicate.test(activeChildren.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "activeChildren"));
    }
    return this.setNewActiveChildLike(index, this.buildActiveChild(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<WorkflowNodeConditionBuilder> predicate) {
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
  
  public FinishedChildrenNested<A> editMatchingFinishedChild(Predicate<LocalObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < finishedChildren.size();i++) {
      if (predicate.test(finishedChildren.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "finishedChildren"));
    }
    return this.setNewFinishedChildLike(index, this.buildFinishedChild(index));
  }
  
  public ConditionalBranchesStatusNested<A> editOrNewConditionalBranchesStatus() {
    return this.withNewConditionalBranchesStatusLike(Optional.ofNullable(this.buildConditionalBranchesStatus()).orElse(new ConditionalBranchesStatusBuilder().build()));
  }
  
  public ConditionalBranchesStatusNested<A> editOrNewConditionalBranchesStatusLike(ConditionalBranchesStatus item) {
    return this.withNewConditionalBranchesStatusLike(Optional.ofNullable(this.buildConditionalBranchesStatus()).orElse(item));
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
    WorkflowNodeStatusFluent that = (WorkflowNodeStatusFluent) o;
    if (!(Objects.equals(activeChildren, that.activeChildren))) {
      return false;
    }
    if (!(Objects.equals(chaosResource, that.chaosResource))) {
      return false;
    }
    if (!(Objects.equals(conditionalBranchesStatus, that.conditionalBranchesStatus))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(finishedChildren, that.finishedChildren))) {
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
  
  public TypedLocalObjectReference getChaosResource() {
    return this.chaosResource;
  }
  
  public boolean hasActiveChildren() {
    return this.activeChildren != null && !(this.activeChildren.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasChaosResource() {
    return this.chaosResource != null;
  }
  
  public boolean hasConditionalBranchesStatus() {
    return this.conditionalBranchesStatus != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasFinishedChildren() {
    return this.finishedChildren != null && !(this.finishedChildren.isEmpty());
  }
  
  public boolean hasMatchingActiveChild(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : activeChildren) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<WorkflowNodeConditionBuilder> predicate) {
      for (WorkflowNodeConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFinishedChild(Predicate<LocalObjectReferenceBuilder> predicate) {
      for (LocalObjectReferenceBuilder item : finishedChildren) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(activeChildren, chaosResource, conditionalBranchesStatus, conditions, finishedChildren, additionalProperties);
  }
  
  public A removeAllFromActiveChildren(Collection<LocalObjectReference> items) {
    if (this.activeChildren == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("activeChildren").remove(builder);
        this.activeChildren.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<WorkflowNodeCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (WorkflowNodeCondition item : items) {
        WorkflowNodeConditionBuilder builder = new WorkflowNodeConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFinishedChildren(Collection<LocalObjectReference> items) {
    if (this.finishedChildren == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("finishedChildren").remove(builder);
        this.finishedChildren.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromActiveChildren(LocalObjectReference... items) {
    if (this.activeChildren == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("activeChildren").remove(builder);
        this.activeChildren.remove(builder);
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
  
  public A removeFromConditions(WorkflowNodeCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (WorkflowNodeCondition item : items) {
        WorkflowNodeConditionBuilder builder = new WorkflowNodeConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFinishedChildren(LocalObjectReference... items) {
    if (this.finishedChildren == null) {
      return (A) this;
    }
    for (LocalObjectReference item : items) {
        LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
        _visitables.get("finishedChildren").remove(builder);
        this.finishedChildren.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromActiveChildren(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (activeChildren == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = activeChildren.iterator();
    List visitables = _visitables.get("activeChildren");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<WorkflowNodeConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<WorkflowNodeConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        WorkflowNodeConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFinishedChildren(Predicate<LocalObjectReferenceBuilder> predicate) {
    if (finishedChildren == null) {
      return (A) this;
    }
    Iterator<LocalObjectReferenceBuilder> each = finishedChildren.iterator();
    List visitables = _visitables.get("finishedChildren");
    while (each.hasNext()) {
        LocalObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ActiveChildrenNested<A> setNewActiveChildLike(int index,LocalObjectReference item) {
    return new ActiveChildrenNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,WorkflowNodeCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public FinishedChildrenNested<A> setNewFinishedChildLike(int index,LocalObjectReference item) {
    return new FinishedChildrenNested(index, item);
  }
  
  public A setToActiveChildren(int index,LocalObjectReference item) {
    if (this.activeChildren == null) {
      this.activeChildren = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= activeChildren.size()) {
        _visitables.get("activeChildren").add(builder);
        activeChildren.add(builder);
    } else {
        _visitables.get("activeChildren").add(builder);
        activeChildren.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,WorkflowNodeCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    WorkflowNodeConditionBuilder builder = new WorkflowNodeConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFinishedChildren(int index,LocalObjectReference item) {
    if (this.finishedChildren == null) {
      this.finishedChildren = new ArrayList();
    }
    LocalObjectReferenceBuilder builder = new LocalObjectReferenceBuilder(item);
    if (index < 0 || index >= finishedChildren.size()) {
        _visitables.get("finishedChildren").add(builder);
        finishedChildren.add(builder);
    } else {
        _visitables.get("finishedChildren").add(builder);
        finishedChildren.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(activeChildren == null) && !(activeChildren.isEmpty())) {
        sb.append("activeChildren:");
        sb.append(activeChildren);
        sb.append(",");
    }
    if (!(chaosResource == null)) {
        sb.append("chaosResource:");
        sb.append(chaosResource);
        sb.append(",");
    }
    if (!(conditionalBranchesStatus == null)) {
        sb.append("conditionalBranchesStatus:");
        sb.append(conditionalBranchesStatus);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(finishedChildren == null) && !(finishedChildren.isEmpty())) {
        sb.append("finishedChildren:");
        sb.append(finishedChildren);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActiveChildren(List<LocalObjectReference> activeChildren) {
    if (this.activeChildren != null) {
      this._visitables.get("activeChildren").clear();
    }
    if (activeChildren != null) {
        this.activeChildren = new ArrayList();
        for (LocalObjectReference item : activeChildren) {
          this.addToActiveChildren(item);
        }
    } else {
      this.activeChildren = null;
    }
    return (A) this;
  }
  
  public A withActiveChildren(LocalObjectReference... activeChildren) {
    if (this.activeChildren != null) {
        this.activeChildren.clear();
        _visitables.remove("activeChildren");
    }
    if (activeChildren != null) {
      for (LocalObjectReference item : activeChildren) {
        this.addToActiveChildren(item);
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
  
  public A withChaosResource(TypedLocalObjectReference chaosResource) {
    this.chaosResource = chaosResource;
    return (A) this;
  }
  
  public A withConditionalBranchesStatus(ConditionalBranchesStatus conditionalBranchesStatus) {
    this._visitables.remove("conditionalBranchesStatus");
    if (conditionalBranchesStatus != null) {
        this.conditionalBranchesStatus = new ConditionalBranchesStatusBuilder(conditionalBranchesStatus);
        this._visitables.get("conditionalBranchesStatus").add(this.conditionalBranchesStatus);
    } else {
        this.conditionalBranchesStatus = null;
        this._visitables.get("conditionalBranchesStatus").remove(this.conditionalBranchesStatus);
    }
    return (A) this;
  }
  
  public A withConditions(List<WorkflowNodeCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (WorkflowNodeCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(WorkflowNodeCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (WorkflowNodeCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withFinishedChildren(List<LocalObjectReference> finishedChildren) {
    if (this.finishedChildren != null) {
      this._visitables.get("finishedChildren").clear();
    }
    if (finishedChildren != null) {
        this.finishedChildren = new ArrayList();
        for (LocalObjectReference item : finishedChildren) {
          this.addToFinishedChildren(item);
        }
    } else {
      this.finishedChildren = null;
    }
    return (A) this;
  }
  
  public A withFinishedChildren(LocalObjectReference... finishedChildren) {
    if (this.finishedChildren != null) {
        this.finishedChildren.clear();
        _visitables.remove("finishedChildren");
    }
    if (finishedChildren != null) {
      for (LocalObjectReference item : finishedChildren) {
        this.addToFinishedChildren(item);
      }
    }
    return (A) this;
  }
  
  public A withNewChaosResource(String apiGroup,String kind,String name) {
    return (A) this.withChaosResource(new TypedLocalObjectReference(apiGroup, kind, name));
  }
  
  public ConditionalBranchesStatusNested<A> withNewConditionalBranchesStatus() {
    return new ConditionalBranchesStatusNested(null);
  }
  
  public ConditionalBranchesStatusNested<A> withNewConditionalBranchesStatusLike(ConditionalBranchesStatus item) {
    return new ConditionalBranchesStatusNested(item);
  }
  public class ActiveChildrenNested<N> extends LocalObjectReferenceFluent<ActiveChildrenNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    ActiveChildrenNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkflowNodeStatusFluent.this.setToActiveChildren(index, builder.build());
    }
    
    public N endActiveChild() {
      return and();
    }
    
  }
  public class ConditionalBranchesStatusNested<N> extends ConditionalBranchesStatusFluent<ConditionalBranchesStatusNested<N>> implements Nested<N>{
  
    ConditionalBranchesStatusBuilder builder;
  
    ConditionalBranchesStatusNested(ConditionalBranchesStatus item) {
      this.builder = new ConditionalBranchesStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkflowNodeStatusFluent.this.withConditionalBranchesStatus(builder.build());
    }
    
    public N endConditionalBranchesStatus() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends WorkflowNodeConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    WorkflowNodeConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,WorkflowNodeCondition item) {
      this.index = index;
      this.builder = new WorkflowNodeConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkflowNodeStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class FinishedChildrenNested<N> extends LocalObjectReferenceFluent<FinishedChildrenNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
    int index;
  
    FinishedChildrenNested(int index,LocalObjectReference item) {
      this.index = index;
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) WorkflowNodeStatusFluent.this.setToFinishedChildren(index, builder.build());
    }
    
    public N endFinishedChild() {
      return and();
    }
    
  }
}