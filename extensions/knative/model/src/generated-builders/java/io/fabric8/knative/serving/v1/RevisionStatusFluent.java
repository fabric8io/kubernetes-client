package io.fabric8.knative.serving.v1;

import io.fabric8.knative.pkg.apis.Condition;
import io.fabric8.knative.pkg.apis.ConditionBuilder;
import io.fabric8.knative.pkg.apis.ConditionFluent;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RevisionStatusFluent<A extends io.fabric8.knative.serving.v1.RevisionStatusFluent<A>> extends BaseFluent<A>{

  private Integer actualReplicas;
  private Map<String,Object> additionalProperties;
  private Map<String,String> annotations;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private ArrayList<ContainerStatusBuilder> containerStatuses = new ArrayList<ContainerStatusBuilder>();
  private Integer desiredReplicas;
  private ArrayList<ContainerStatusBuilder> initContainerStatuses = new ArrayList<ContainerStatusBuilder>();
  private String logUrl;
  private Long observedGeneration;

  public RevisionStatusFluent() {
  }
  
  public RevisionStatusFluent(RevisionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToContainerStatuses(Collection<ContainerStatus> items) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").add(builder);
        this.containerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToInitContainerStatuses(Collection<ContainerStatus> items) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").add(builder);
        this.initContainerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(Condition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ContainerStatusesNested<A> addNewContainerStatus() {
    return new ContainerStatusesNested(-1, null);
  }
  
  public A addNewContainerStatus(String imageDigest,String name) {
    return (A) this.addToContainerStatuses(new ContainerStatus(imageDigest, name));
  }
  
  public ContainerStatusesNested<A> addNewContainerStatusLike(ContainerStatus item) {
    return new ContainerStatusesNested(-1, item);
  }
  
  public InitContainerStatusesNested<A> addNewInitContainerStatus() {
    return new InitContainerStatusesNested(-1, null);
  }
  
  public A addNewInitContainerStatus(String imageDigest,String name) {
    return (A) this.addToInitContainerStatuses(new ContainerStatus(imageDigest, name));
  }
  
  public InitContainerStatusesNested<A> addNewInitContainerStatusLike(ContainerStatus item) {
    return new InitContainerStatusesNested(-1, item);
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
  
  public A addToAnnotations(Map<String,String> map) {
    if (this.annotations == null && map != null) {
      this.annotations = new LinkedHashMap();
    }
    if (map != null) {
      this.annotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAnnotations(String key,String value) {
    if (this.annotations == null && key != null && value != null) {
      this.annotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.annotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToContainerStatuses(ContainerStatus... items) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").add(builder);
        this.containerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToContainerStatuses(int index,ContainerStatus item) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= containerStatuses.size()) {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.add(builder);
    } else {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToInitContainerStatuses(ContainerStatus... items) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").add(builder);
        this.initContainerStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToInitContainerStatuses(int index,ContainerStatus item) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= initContainerStatuses.size()) {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.add(builder);
    } else {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ContainerStatus buildContainerStatus(int index) {
    return this.containerStatuses.get(index).build();
  }
  
  public List<ContainerStatus> buildContainerStatuses() {
    return this.containerStatuses != null ? build(containerStatuses) : null;
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ContainerStatus buildFirstContainerStatus() {
    return this.containerStatuses.get(0).build();
  }
  
  public ContainerStatus buildFirstInitContainerStatus() {
    return this.initContainerStatuses.get(0).build();
  }
  
  public ContainerStatus buildInitContainerStatus(int index) {
    return this.initContainerStatuses.get(index).build();
  }
  
  public List<ContainerStatus> buildInitContainerStatuses() {
    return this.initContainerStatuses != null ? build(initContainerStatuses) : null;
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ContainerStatus buildLastContainerStatus() {
    return this.containerStatuses.get(containerStatuses.size() - 1).build();
  }
  
  public ContainerStatus buildLastInitContainerStatus() {
    return this.initContainerStatuses.get(initContainerStatuses.size() - 1).build();
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerStatus buildMatchingContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : containerStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ContainerStatus buildMatchingInitContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : initContainerStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RevisionStatus instance) {
    instance = instance != null ? instance : new RevisionStatus();
    if (instance != null) {
        this.withActualReplicas(instance.getActualReplicas());
        this.withAnnotations(instance.getAnnotations());
        this.withConditions(instance.getConditions());
        this.withContainerStatuses(instance.getContainerStatuses());
        this.withDesiredReplicas(instance.getDesiredReplicas());
        this.withInitContainerStatuses(instance.getInitContainerStatuses());
        this.withLogUrl(instance.getLogUrl());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ContainerStatusesNested<A> editContainerStatus(int index) {
    if (containerStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(index, this.buildContainerStatus(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ContainerStatusesNested<A> editFirstContainerStatus() {
    if (containerStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(0, this.buildContainerStatus(0));
  }
  
  public InitContainerStatusesNested<A> editFirstInitContainerStatus() {
    if (initContainerStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(0, this.buildInitContainerStatus(0));
  }
  
  public InitContainerStatusesNested<A> editInitContainerStatus(int index) {
    if (initContainerStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(index, this.buildInitContainerStatus(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ContainerStatusesNested<A> editLastContainerStatus() {
    int index = containerStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(index, this.buildContainerStatus(index));
  }
  
  public InitContainerStatusesNested<A> editLastInitContainerStatus() {
    int index = initContainerStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(index, this.buildInitContainerStatus(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ConditionBuilder> predicate) {
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
  
  public ContainerStatusesNested<A> editMatchingContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < containerStatuses.size();i++) {
      if (predicate.test(containerStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "containerStatuses"));
    }
    return this.setNewContainerStatusLike(index, this.buildContainerStatus(index));
  }
  
  public InitContainerStatusesNested<A> editMatchingInitContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < initContainerStatuses.size();i++) {
      if (predicate.test(initContainerStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "initContainerStatuses"));
    }
    return this.setNewInitContainerStatusLike(index, this.buildInitContainerStatus(index));
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
    RevisionStatusFluent that = (RevisionStatusFluent) o;
    if (!(Objects.equals(actualReplicas, that.actualReplicas))) {
      return false;
    }
    if (!(Objects.equals(annotations, that.annotations))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(containerStatuses, that.containerStatuses))) {
      return false;
    }
    if (!(Objects.equals(desiredReplicas, that.desiredReplicas))) {
      return false;
    }
    if (!(Objects.equals(initContainerStatuses, that.initContainerStatuses))) {
      return false;
    }
    if (!(Objects.equals(logUrl, that.logUrl))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Integer getActualReplicas() {
    return this.actualReplicas;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Map<String,String> getAnnotations() {
    return this.annotations;
  }
  
  public Integer getDesiredReplicas() {
    return this.desiredReplicas;
  }
  
  public String getLogUrl() {
    return this.logUrl;
  }
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public boolean hasActualReplicas() {
    return this.actualReplicas != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAnnotations() {
    return this.annotations != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasContainerStatuses() {
    return this.containerStatuses != null && !(this.containerStatuses.isEmpty());
  }
  
  public boolean hasDesiredReplicas() {
    return this.desiredReplicas != null;
  }
  
  public boolean hasInitContainerStatuses() {
    return this.initContainerStatuses != null && !(this.initContainerStatuses.isEmpty());
  }
  
  public boolean hasLogUrl() {
    return this.logUrl != null;
  }
  
  public boolean hasMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : containerStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingInitContainerStatus(Predicate<ContainerStatusBuilder> predicate) {
      for (ContainerStatusBuilder item : initContainerStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public int hashCode() {
    return Objects.hash(actualReplicas, annotations, conditions, containerStatuses, desiredReplicas, initContainerStatuses, logUrl, observedGeneration, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromContainerStatuses(Collection<ContainerStatus> items) {
    if (this.containerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").remove(builder);
        this.containerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromInitContainerStatuses(Collection<ContainerStatus> items) {
    if (this.initContainerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").remove(builder);
        this.initContainerStatuses.remove(builder);
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
  
  public A removeFromAnnotations(String key) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (key != null && this.annotations != null) {
      this.annotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAnnotations(Map<String,String> map) {
    if (this.annotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.annotations != null) {
          this.annotations.remove(key);
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
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromContainerStatuses(ContainerStatus... items) {
    if (this.containerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("containerStatuses").remove(builder);
        this.containerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromInitContainerStatuses(ContainerStatus... items) {
    if (this.initContainerStatuses == null) {
      return (A) this;
    }
    for (ContainerStatus item : items) {
        ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
        _visitables.get("initContainerStatuses").remove(builder);
        this.initContainerStatuses.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromContainerStatuses(Predicate<ContainerStatusBuilder> predicate) {
    if (containerStatuses == null) {
      return (A) this;
    }
    Iterator<ContainerStatusBuilder> each = containerStatuses.iterator();
    List visitables = _visitables.get("containerStatuses");
    while (each.hasNext()) {
        ContainerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromInitContainerStatuses(Predicate<ContainerStatusBuilder> predicate) {
    if (initContainerStatuses == null) {
      return (A) this;
    }
    Iterator<ContainerStatusBuilder> each = initContainerStatuses.iterator();
    List visitables = _visitables.get("initContainerStatuses");
    while (each.hasNext()) {
        ContainerStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,Condition item) {
    return new ConditionsNested(index, item);
  }
  
  public ContainerStatusesNested<A> setNewContainerStatusLike(int index,ContainerStatus item) {
    return new ContainerStatusesNested(index, item);
  }
  
  public InitContainerStatusesNested<A> setNewInitContainerStatusLike(int index,ContainerStatus item) {
    return new InitContainerStatusesNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToContainerStatuses(int index,ContainerStatus item) {
    if (this.containerStatuses == null) {
      this.containerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= containerStatuses.size()) {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.add(builder);
    } else {
        _visitables.get("containerStatuses").add(builder);
        containerStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToInitContainerStatuses(int index,ContainerStatus item) {
    if (this.initContainerStatuses == null) {
      this.initContainerStatuses = new ArrayList();
    }
    ContainerStatusBuilder builder = new ContainerStatusBuilder(item);
    if (index < 0 || index >= initContainerStatuses.size()) {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.add(builder);
    } else {
        _visitables.get("initContainerStatuses").add(builder);
        initContainerStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actualReplicas == null)) {
        sb.append("actualReplicas:");
        sb.append(actualReplicas);
        sb.append(",");
    }
    if (!(annotations == null) && !(annotations.isEmpty())) {
        sb.append("annotations:");
        sb.append(annotations);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(containerStatuses == null) && !(containerStatuses.isEmpty())) {
        sb.append("containerStatuses:");
        sb.append(containerStatuses);
        sb.append(",");
    }
    if (!(desiredReplicas == null)) {
        sb.append("desiredReplicas:");
        sb.append(desiredReplicas);
        sb.append(",");
    }
    if (!(initContainerStatuses == null) && !(initContainerStatuses.isEmpty())) {
        sb.append("initContainerStatuses:");
        sb.append(initContainerStatuses);
        sb.append(",");
    }
    if (!(logUrl == null)) {
        sb.append("logUrl:");
        sb.append(logUrl);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActualReplicas(Integer actualReplicas) {
    this.actualReplicas = actualReplicas;
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
  
  public <K,V>A withAnnotations(Map<String,String> annotations) {
    if (annotations == null) {
      this.annotations = null;
    } else {
      this.annotations = new LinkedHashMap(annotations);
    }
    return (A) this;
  }
  
  public A withConditions(List<Condition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
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
  
  public A withContainerStatuses(List<ContainerStatus> containerStatuses) {
    if (this.containerStatuses != null) {
      this._visitables.get("containerStatuses").clear();
    }
    if (containerStatuses != null) {
        this.containerStatuses = new ArrayList();
        for (ContainerStatus item : containerStatuses) {
          this.addToContainerStatuses(item);
        }
    } else {
      this.containerStatuses = null;
    }
    return (A) this;
  }
  
  public A withContainerStatuses(ContainerStatus... containerStatuses) {
    if (this.containerStatuses != null) {
        this.containerStatuses.clear();
        _visitables.remove("containerStatuses");
    }
    if (containerStatuses != null) {
      for (ContainerStatus item : containerStatuses) {
        this.addToContainerStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withDesiredReplicas(Integer desiredReplicas) {
    this.desiredReplicas = desiredReplicas;
    return (A) this;
  }
  
  public A withInitContainerStatuses(List<ContainerStatus> initContainerStatuses) {
    if (this.initContainerStatuses != null) {
      this._visitables.get("initContainerStatuses").clear();
    }
    if (initContainerStatuses != null) {
        this.initContainerStatuses = new ArrayList();
        for (ContainerStatus item : initContainerStatuses) {
          this.addToInitContainerStatuses(item);
        }
    } else {
      this.initContainerStatuses = null;
    }
    return (A) this;
  }
  
  public A withInitContainerStatuses(ContainerStatus... initContainerStatuses) {
    if (this.initContainerStatuses != null) {
        this.initContainerStatuses.clear();
        _visitables.remove("initContainerStatuses");
    }
    if (initContainerStatuses != null) {
      for (ContainerStatus item : initContainerStatuses) {
        this.addToInitContainerStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withLogUrl(String logUrl) {
    this.logUrl = logUrl;
    return (A) this;
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  public class ConditionsNested<N> extends ConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,Condition item) {
      this.index = index;
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) RevisionStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ContainerStatusesNested<N> extends ContainerStatusFluent<ContainerStatusesNested<N>> implements Nested<N>{
  
    ContainerStatusBuilder builder;
    int index;
  
    ContainerStatusesNested(int index,ContainerStatus item) {
      this.index = index;
      this.builder = new ContainerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) RevisionStatusFluent.this.setToContainerStatuses(index, builder.build());
    }
    
    public N endContainerStatus() {
      return and();
    }
    
  }
  public class InitContainerStatusesNested<N> extends ContainerStatusFluent<InitContainerStatusesNested<N>> implements Nested<N>{
  
    ContainerStatusBuilder builder;
    int index;
  
    InitContainerStatusesNested(int index,ContainerStatus item) {
      this.index = index;
      this.builder = new ContainerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) RevisionStatusFluent.this.setToInitContainerStatuses(index, builder.build());
    }
    
    public N endInitContainerStatus() {
      return and();
    }
    
  }
}