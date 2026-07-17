package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class ClusterVersionStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.ClusterVersionStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ReleaseBuilder> availableUpdates = new ArrayList<ReleaseBuilder>();
  private ClusterVersionCapabilitiesStatusBuilder capabilities;
  private ArrayList<ConditionalUpdateBuilder> conditionalUpdates = new ArrayList<ConditionalUpdateBuilder>();
  private ArrayList<ClusterOperatorStatusConditionBuilder> conditions = new ArrayList<ClusterOperatorStatusConditionBuilder>();
  private ReleaseBuilder desired;
  private ArrayList<UpdateHistoryBuilder> history = new ArrayList<UpdateHistoryBuilder>();
  private Long observedGeneration;
  private String versionHash;

  public ClusterVersionStatusFluent() {
  }
  
  public ClusterVersionStatusFluent(ClusterVersionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToAvailableUpdates(Collection<Release> items) {
    if (this.availableUpdates == null) {
      this.availableUpdates = new ArrayList();
    }
    for (Release item : items) {
        ReleaseBuilder builder = new ReleaseBuilder(item);
        _visitables.get("availableUpdates").add(builder);
        this.availableUpdates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditionalUpdates(Collection<ConditionalUpdate> items) {
    if (this.conditionalUpdates == null) {
      this.conditionalUpdates = new ArrayList();
    }
    for (ConditionalUpdate item : items) {
        ConditionalUpdateBuilder builder = new ConditionalUpdateBuilder(item);
        _visitables.get("conditionalUpdates").add(builder);
        this.conditionalUpdates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToConditions(Collection<ClusterOperatorStatusCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToHistory(Collection<UpdateHistory> items) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    for (UpdateHistory item : items) {
        UpdateHistoryBuilder builder = new UpdateHistoryBuilder(item);
        _visitables.get("history").add(builder);
        this.history.add(builder);
    }
    return (A) this;
  }
  
  public AvailableUpdatesNested<A> addNewAvailableUpdate() {
    return new AvailableUpdatesNested(-1, null);
  }
  
  public AvailableUpdatesNested<A> addNewAvailableUpdateLike(Release item) {
    return new AvailableUpdatesNested(-1, item);
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new ClusterOperatorStatusCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(ClusterOperatorStatusCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ConditionalUpdatesNested<A> addNewConditionalUpdate() {
    return new ConditionalUpdatesNested(-1, null);
  }
  
  public ConditionalUpdatesNested<A> addNewConditionalUpdateLike(ConditionalUpdate item) {
    return new ConditionalUpdatesNested(-1, item);
  }
  
  public HistoryNested<A> addNewHistory() {
    return new HistoryNested(-1, null);
  }
  
  public HistoryNested<A> addNewHistoryLike(UpdateHistory item) {
    return new HistoryNested(-1, item);
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
  
  public A addToAvailableUpdates(Release... items) {
    if (this.availableUpdates == null) {
      this.availableUpdates = new ArrayList();
    }
    for (Release item : items) {
        ReleaseBuilder builder = new ReleaseBuilder(item);
        _visitables.get("availableUpdates").add(builder);
        this.availableUpdates.add(builder);
    }
    return (A) this;
  }
  
  public A addToAvailableUpdates(int index,Release item) {
    if (this.availableUpdates == null) {
      this.availableUpdates = new ArrayList();
    }
    ReleaseBuilder builder = new ReleaseBuilder(item);
    if (index < 0 || index >= availableUpdates.size()) {
        _visitables.get("availableUpdates").add(builder);
        availableUpdates.add(builder);
    } else {
        _visitables.get("availableUpdates").add(builder);
        availableUpdates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditionalUpdates(ConditionalUpdate... items) {
    if (this.conditionalUpdates == null) {
      this.conditionalUpdates = new ArrayList();
    }
    for (ConditionalUpdate item : items) {
        ConditionalUpdateBuilder builder = new ConditionalUpdateBuilder(item);
        _visitables.get("conditionalUpdates").add(builder);
        this.conditionalUpdates.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditionalUpdates(int index,ConditionalUpdate item) {
    if (this.conditionalUpdates == null) {
      this.conditionalUpdates = new ArrayList();
    }
    ConditionalUpdateBuilder builder = new ConditionalUpdateBuilder(item);
    if (index < 0 || index >= conditionalUpdates.size()) {
        _visitables.get("conditionalUpdates").add(builder);
        conditionalUpdates.add(builder);
    } else {
        _visitables.get("conditionalUpdates").add(builder);
        conditionalUpdates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToConditions(ClusterOperatorStatusCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterOperatorStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToHistory(UpdateHistory... items) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    for (UpdateHistory item : items) {
        UpdateHistoryBuilder builder = new UpdateHistoryBuilder(item);
        _visitables.get("history").add(builder);
        this.history.add(builder);
    }
    return (A) this;
  }
  
  public A addToHistory(int index,UpdateHistory item) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    UpdateHistoryBuilder builder = new UpdateHistoryBuilder(item);
    if (index < 0 || index >= history.size()) {
        _visitables.get("history").add(builder);
        history.add(builder);
    } else {
        _visitables.get("history").add(builder);
        history.add(index, builder);
    }
    return (A) this;
  }
  
  public Release buildAvailableUpdate(int index) {
    return this.availableUpdates.get(index).build();
  }
  
  public List<Release> buildAvailableUpdates() {
    return this.availableUpdates != null ? build(availableUpdates) : null;
  }
  
  public ClusterVersionCapabilitiesStatus buildCapabilities() {
    return this.capabilities != null ? this.capabilities.build() : null;
  }
  
  public ClusterOperatorStatusCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public ConditionalUpdate buildConditionalUpdate(int index) {
    return this.conditionalUpdates.get(index).build();
  }
  
  public List<ConditionalUpdate> buildConditionalUpdates() {
    return this.conditionalUpdates != null ? build(conditionalUpdates) : null;
  }
  
  public List<ClusterOperatorStatusCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public Release buildDesired() {
    return this.desired != null ? this.desired.build() : null;
  }
  
  public Release buildFirstAvailableUpdate() {
    return this.availableUpdates.get(0).build();
  }
  
  public ClusterOperatorStatusCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ConditionalUpdate buildFirstConditionalUpdate() {
    return this.conditionalUpdates.get(0).build();
  }
  
  public UpdateHistory buildFirstHistory() {
    return this.history.get(0).build();
  }
  
  public List<UpdateHistory> buildHistory() {
    return this.history != null ? build(history) : null;
  }
  
  public UpdateHistory buildHistory(int index) {
    return this.history.get(index).build();
  }
  
  public Release buildLastAvailableUpdate() {
    return this.availableUpdates.get(availableUpdates.size() - 1).build();
  }
  
  public ClusterOperatorStatusCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ConditionalUpdate buildLastConditionalUpdate() {
    return this.conditionalUpdates.get(conditionalUpdates.size() - 1).build();
  }
  
  public UpdateHistory buildLastHistory() {
    return this.history.get(history.size() - 1).build();
  }
  
  public Release buildMatchingAvailableUpdate(Predicate<ReleaseBuilder> predicate) {
      for (ReleaseBuilder item : availableUpdates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterOperatorStatusCondition buildMatchingCondition(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
      for (ClusterOperatorStatusConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ConditionalUpdate buildMatchingConditionalUpdate(Predicate<ConditionalUpdateBuilder> predicate) {
      for (ConditionalUpdateBuilder item : conditionalUpdates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public UpdateHistory buildMatchingHistory(Predicate<UpdateHistoryBuilder> predicate) {
      for (UpdateHistoryBuilder item : history) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(ClusterVersionStatus instance) {
    instance = instance != null ? instance : new ClusterVersionStatus();
    if (instance != null) {
        this.withAvailableUpdates(instance.getAvailableUpdates());
        this.withCapabilities(instance.getCapabilities());
        this.withConditionalUpdates(instance.getConditionalUpdates());
        this.withConditions(instance.getConditions());
        this.withDesired(instance.getDesired());
        this.withHistory(instance.getHistory());
        this.withObservedGeneration(instance.getObservedGeneration());
        this.withVersionHash(instance.getVersionHash());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AvailableUpdatesNested<A> editAvailableUpdate(int index) {
    if (availableUpdates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "availableUpdates"));
    }
    return this.setNewAvailableUpdateLike(index, this.buildAvailableUpdate(index));
  }
  
  public CapabilitiesNested<A> editCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(null));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionalUpdatesNested<A> editConditionalUpdate(int index) {
    if (conditionalUpdates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditionalUpdates"));
    }
    return this.setNewConditionalUpdateLike(index, this.buildConditionalUpdate(index));
  }
  
  public DesiredNested<A> editDesired() {
    return this.withNewDesiredLike(Optional.ofNullable(this.buildDesired()).orElse(null));
  }
  
  public AvailableUpdatesNested<A> editFirstAvailableUpdate() {
    if (availableUpdates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "availableUpdates"));
    }
    return this.setNewAvailableUpdateLike(0, this.buildAvailableUpdate(0));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ConditionalUpdatesNested<A> editFirstConditionalUpdate() {
    if (conditionalUpdates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditionalUpdates"));
    }
    return this.setNewConditionalUpdateLike(0, this.buildConditionalUpdate(0));
  }
  
  public HistoryNested<A> editFirstHistory() {
    if (history.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "history"));
    }
    return this.setNewHistoryLike(0, this.buildHistory(0));
  }
  
  public HistoryNested<A> editHistory(int index) {
    if (history.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "history"));
    }
    return this.setNewHistoryLike(index, this.buildHistory(index));
  }
  
  public AvailableUpdatesNested<A> editLastAvailableUpdate() {
    int index = availableUpdates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "availableUpdates"));
    }
    return this.setNewAvailableUpdateLike(index, this.buildAvailableUpdate(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionalUpdatesNested<A> editLastConditionalUpdate() {
    int index = conditionalUpdates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditionalUpdates"));
    }
    return this.setNewConditionalUpdateLike(index, this.buildConditionalUpdate(index));
  }
  
  public HistoryNested<A> editLastHistory() {
    int index = history.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "history"));
    }
    return this.setNewHistoryLike(index, this.buildHistory(index));
  }
  
  public AvailableUpdatesNested<A> editMatchingAvailableUpdate(Predicate<ReleaseBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < availableUpdates.size();i++) {
      if (predicate.test(availableUpdates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "availableUpdates"));
    }
    return this.setNewAvailableUpdateLike(index, this.buildAvailableUpdate(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
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
  
  public ConditionalUpdatesNested<A> editMatchingConditionalUpdate(Predicate<ConditionalUpdateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditionalUpdates.size();i++) {
      if (predicate.test(conditionalUpdates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditionalUpdates"));
    }
    return this.setNewConditionalUpdateLike(index, this.buildConditionalUpdate(index));
  }
  
  public HistoryNested<A> editMatchingHistory(Predicate<UpdateHistoryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < history.size();i++) {
      if (predicate.test(history.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "history"));
    }
    return this.setNewHistoryLike(index, this.buildHistory(index));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilities() {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(new ClusterVersionCapabilitiesStatusBuilder().build()));
  }
  
  public CapabilitiesNested<A> editOrNewCapabilitiesLike(ClusterVersionCapabilitiesStatus item) {
    return this.withNewCapabilitiesLike(Optional.ofNullable(this.buildCapabilities()).orElse(item));
  }
  
  public DesiredNested<A> editOrNewDesired() {
    return this.withNewDesiredLike(Optional.ofNullable(this.buildDesired()).orElse(new ReleaseBuilder().build()));
  }
  
  public DesiredNested<A> editOrNewDesiredLike(Release item) {
    return this.withNewDesiredLike(Optional.ofNullable(this.buildDesired()).orElse(item));
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
    ClusterVersionStatusFluent that = (ClusterVersionStatusFluent) o;
    if (!(Objects.equals(availableUpdates, that.availableUpdates))) {
      return false;
    }
    if (!(Objects.equals(capabilities, that.capabilities))) {
      return false;
    }
    if (!(Objects.equals(conditionalUpdates, that.conditionalUpdates))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(desired, that.desired))) {
      return false;
    }
    if (!(Objects.equals(history, that.history))) {
      return false;
    }
    if (!(Objects.equals(observedGeneration, that.observedGeneration))) {
      return false;
    }
    if (!(Objects.equals(versionHash, that.versionHash))) {
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
  
  public Long getObservedGeneration() {
    return this.observedGeneration;
  }
  
  public String getVersionHash() {
    return this.versionHash;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableUpdates() {
    return this.availableUpdates != null && !(this.availableUpdates.isEmpty());
  }
  
  public boolean hasCapabilities() {
    return this.capabilities != null;
  }
  
  public boolean hasConditionalUpdates() {
    return this.conditionalUpdates != null && !(this.conditionalUpdates.isEmpty());
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDesired() {
    return this.desired != null;
  }
  
  public boolean hasHistory() {
    return this.history != null && !(this.history.isEmpty());
  }
  
  public boolean hasMatchingAvailableUpdate(Predicate<ReleaseBuilder> predicate) {
      for (ReleaseBuilder item : availableUpdates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
      for (ClusterOperatorStatusConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConditionalUpdate(Predicate<ConditionalUpdateBuilder> predicate) {
      for (ConditionalUpdateBuilder item : conditionalUpdates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingHistory(Predicate<UpdateHistoryBuilder> predicate) {
      for (UpdateHistoryBuilder item : history) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObservedGeneration() {
    return this.observedGeneration != null;
  }
  
  public boolean hasVersionHash() {
    return this.versionHash != null;
  }
  
  public int hashCode() {
    return Objects.hash(availableUpdates, capabilities, conditionalUpdates, conditions, desired, history, observedGeneration, versionHash, additionalProperties);
  }
  
  public A removeAllFromAvailableUpdates(Collection<Release> items) {
    if (this.availableUpdates == null) {
      return (A) this;
    }
    for (Release item : items) {
        ReleaseBuilder builder = new ReleaseBuilder(item);
        _visitables.get("availableUpdates").remove(builder);
        this.availableUpdates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditionalUpdates(Collection<ConditionalUpdate> items) {
    if (this.conditionalUpdates == null) {
      return (A) this;
    }
    for (ConditionalUpdate item : items) {
        ConditionalUpdateBuilder builder = new ConditionalUpdateBuilder(item);
        _visitables.get("conditionalUpdates").remove(builder);
        this.conditionalUpdates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromConditions(Collection<ClusterOperatorStatusCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromHistory(Collection<UpdateHistory> items) {
    if (this.history == null) {
      return (A) this;
    }
    for (UpdateHistory item : items) {
        UpdateHistoryBuilder builder = new UpdateHistoryBuilder(item);
        _visitables.get("history").remove(builder);
        this.history.remove(builder);
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
  
  public A removeFromAvailableUpdates(Release... items) {
    if (this.availableUpdates == null) {
      return (A) this;
    }
    for (Release item : items) {
        ReleaseBuilder builder = new ReleaseBuilder(item);
        _visitables.get("availableUpdates").remove(builder);
        this.availableUpdates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditionalUpdates(ConditionalUpdate... items) {
    if (this.conditionalUpdates == null) {
      return (A) this;
    }
    for (ConditionalUpdate item : items) {
        ConditionalUpdateBuilder builder = new ConditionalUpdateBuilder(item);
        _visitables.get("conditionalUpdates").remove(builder);
        this.conditionalUpdates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromConditions(ClusterOperatorStatusCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromHistory(UpdateHistory... items) {
    if (this.history == null) {
      return (A) this;
    }
    for (UpdateHistory item : items) {
        UpdateHistoryBuilder builder = new UpdateHistoryBuilder(item);
        _visitables.get("history").remove(builder);
        this.history.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAvailableUpdates(Predicate<ReleaseBuilder> predicate) {
    if (availableUpdates == null) {
      return (A) this;
    }
    Iterator<ReleaseBuilder> each = availableUpdates.iterator();
    List visitables = _visitables.get("availableUpdates");
    while (each.hasNext()) {
        ReleaseBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditionalUpdates(Predicate<ConditionalUpdateBuilder> predicate) {
    if (conditionalUpdates == null) {
      return (A) this;
    }
    Iterator<ConditionalUpdateBuilder> each = conditionalUpdates.iterator();
    List visitables = _visitables.get("conditionalUpdates");
    while (each.hasNext()) {
        ConditionalUpdateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ClusterOperatorStatusConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ClusterOperatorStatusConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromHistory(Predicate<UpdateHistoryBuilder> predicate) {
    if (history == null) {
      return (A) this;
    }
    Iterator<UpdateHistoryBuilder> each = history.iterator();
    List visitables = _visitables.get("history");
    while (each.hasNext()) {
        UpdateHistoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AvailableUpdatesNested<A> setNewAvailableUpdateLike(int index,Release item) {
    return new AvailableUpdatesNested(index, item);
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ClusterOperatorStatusCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public ConditionalUpdatesNested<A> setNewConditionalUpdateLike(int index,ConditionalUpdate item) {
    return new ConditionalUpdatesNested(index, item);
  }
  
  public HistoryNested<A> setNewHistoryLike(int index,UpdateHistory item) {
    return new HistoryNested(index, item);
  }
  
  public A setToAvailableUpdates(int index,Release item) {
    if (this.availableUpdates == null) {
      this.availableUpdates = new ArrayList();
    }
    ReleaseBuilder builder = new ReleaseBuilder(item);
    if (index < 0 || index >= availableUpdates.size()) {
        _visitables.get("availableUpdates").add(builder);
        availableUpdates.add(builder);
    } else {
        _visitables.get("availableUpdates").add(builder);
        availableUpdates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditionalUpdates(int index,ConditionalUpdate item) {
    if (this.conditionalUpdates == null) {
      this.conditionalUpdates = new ArrayList();
    }
    ConditionalUpdateBuilder builder = new ConditionalUpdateBuilder(item);
    if (index < 0 || index >= conditionalUpdates.size()) {
        _visitables.get("conditionalUpdates").add(builder);
        conditionalUpdates.add(builder);
    } else {
        _visitables.get("conditionalUpdates").add(builder);
        conditionalUpdates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,ClusterOperatorStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToHistory(int index,UpdateHistory item) {
    if (this.history == null) {
      this.history = new ArrayList();
    }
    UpdateHistoryBuilder builder = new UpdateHistoryBuilder(item);
    if (index < 0 || index >= history.size()) {
        _visitables.get("history").add(builder);
        history.add(builder);
    } else {
        _visitables.get("history").add(builder);
        history.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availableUpdates == null) && !(availableUpdates.isEmpty())) {
        sb.append("availableUpdates:");
        sb.append(availableUpdates);
        sb.append(",");
    }
    if (!(capabilities == null)) {
        sb.append("capabilities:");
        sb.append(capabilities);
        sb.append(",");
    }
    if (!(conditionalUpdates == null) && !(conditionalUpdates.isEmpty())) {
        sb.append("conditionalUpdates:");
        sb.append(conditionalUpdates);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(desired == null)) {
        sb.append("desired:");
        sb.append(desired);
        sb.append(",");
    }
    if (!(history == null) && !(history.isEmpty())) {
        sb.append("history:");
        sb.append(history);
        sb.append(",");
    }
    if (!(observedGeneration == null)) {
        sb.append("observedGeneration:");
        sb.append(observedGeneration);
        sb.append(",");
    }
    if (!(versionHash == null)) {
        sb.append("versionHash:");
        sb.append(versionHash);
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
  
  public A withAvailableUpdates(List<Release> availableUpdates) {
    if (this.availableUpdates != null) {
      this._visitables.get("availableUpdates").clear();
    }
    if (availableUpdates != null) {
        this.availableUpdates = new ArrayList();
        for (Release item : availableUpdates) {
          this.addToAvailableUpdates(item);
        }
    } else {
      this.availableUpdates = null;
    }
    return (A) this;
  }
  
  public A withAvailableUpdates(Release... availableUpdates) {
    if (this.availableUpdates != null) {
        this.availableUpdates.clear();
        _visitables.remove("availableUpdates");
    }
    if (availableUpdates != null) {
      for (Release item : availableUpdates) {
        this.addToAvailableUpdates(item);
      }
    }
    return (A) this;
  }
  
  public A withCapabilities(ClusterVersionCapabilitiesStatus capabilities) {
    this._visitables.remove("capabilities");
    if (capabilities != null) {
        this.capabilities = new ClusterVersionCapabilitiesStatusBuilder(capabilities);
        this._visitables.get("capabilities").add(this.capabilities);
    } else {
        this.capabilities = null;
        this._visitables.get("capabilities").remove(this.capabilities);
    }
    return (A) this;
  }
  
  public A withConditionalUpdates(List<ConditionalUpdate> conditionalUpdates) {
    if (this.conditionalUpdates != null) {
      this._visitables.get("conditionalUpdates").clear();
    }
    if (conditionalUpdates != null) {
        this.conditionalUpdates = new ArrayList();
        for (ConditionalUpdate item : conditionalUpdates) {
          this.addToConditionalUpdates(item);
        }
    } else {
      this.conditionalUpdates = null;
    }
    return (A) this;
  }
  
  public A withConditionalUpdates(ConditionalUpdate... conditionalUpdates) {
    if (this.conditionalUpdates != null) {
        this.conditionalUpdates.clear();
        _visitables.remove("conditionalUpdates");
    }
    if (conditionalUpdates != null) {
      for (ConditionalUpdate item : conditionalUpdates) {
        this.addToConditionalUpdates(item);
      }
    }
    return (A) this;
  }
  
  public A withConditions(List<ClusterOperatorStatusCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterOperatorStatusCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterOperatorStatusCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterOperatorStatusCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withDesired(Release desired) {
    this._visitables.remove("desired");
    if (desired != null) {
        this.desired = new ReleaseBuilder(desired);
        this._visitables.get("desired").add(this.desired);
    } else {
        this.desired = null;
        this._visitables.get("desired").remove(this.desired);
    }
    return (A) this;
  }
  
  public A withHistory(List<UpdateHistory> history) {
    if (this.history != null) {
      this._visitables.get("history").clear();
    }
    if (history != null) {
        this.history = new ArrayList();
        for (UpdateHistory item : history) {
          this.addToHistory(item);
        }
    } else {
      this.history = null;
    }
    return (A) this;
  }
  
  public A withHistory(UpdateHistory... history) {
    if (this.history != null) {
        this.history.clear();
        _visitables.remove("history");
    }
    if (history != null) {
      for (UpdateHistory item : history) {
        this.addToHistory(item);
      }
    }
    return (A) this;
  }
  
  public CapabilitiesNested<A> withNewCapabilities() {
    return new CapabilitiesNested(null);
  }
  
  public CapabilitiesNested<A> withNewCapabilitiesLike(ClusterVersionCapabilitiesStatus item) {
    return new CapabilitiesNested(item);
  }
  
  public DesiredNested<A> withNewDesired() {
    return new DesiredNested(null);
  }
  
  public DesiredNested<A> withNewDesiredLike(Release item) {
    return new DesiredNested(item);
  }
  
  public A withObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return (A) this;
  }
  
  public A withVersionHash(String versionHash) {
    this.versionHash = versionHash;
    return (A) this;
  }
  public class AvailableUpdatesNested<N> extends ReleaseFluent<AvailableUpdatesNested<N>> implements Nested<N>{
  
    ReleaseBuilder builder;
    int index;
  
    AvailableUpdatesNested(int index,Release item) {
      this.index = index;
      this.builder = new ReleaseBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionStatusFluent.this.setToAvailableUpdates(index, builder.build());
    }
    
    public N endAvailableUpdate() {
      return and();
    }
    
  }
  public class CapabilitiesNested<N> extends ClusterVersionCapabilitiesStatusFluent<CapabilitiesNested<N>> implements Nested<N>{
  
    ClusterVersionCapabilitiesStatusBuilder builder;
  
    CapabilitiesNested(ClusterVersionCapabilitiesStatus item) {
      this.builder = new ClusterVersionCapabilitiesStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionStatusFluent.this.withCapabilities(builder.build());
    }
    
    public N endCapabilities() {
      return and();
    }
    
  }
  public class ConditionalUpdatesNested<N> extends ConditionalUpdateFluent<ConditionalUpdatesNested<N>> implements Nested<N>{
  
    ConditionalUpdateBuilder builder;
    int index;
  
    ConditionalUpdatesNested(int index,ConditionalUpdate item) {
      this.index = index;
      this.builder = new ConditionalUpdateBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionStatusFluent.this.setToConditionalUpdates(index, builder.build());
    }
    
    public N endConditionalUpdate() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends ClusterOperatorStatusConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ClusterOperatorStatusConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ClusterOperatorStatusCondition item) {
      this.index = index;
      this.builder = new ClusterOperatorStatusConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class DesiredNested<N> extends ReleaseFluent<DesiredNested<N>> implements Nested<N>{
  
    ReleaseBuilder builder;
  
    DesiredNested(Release item) {
      this.builder = new ReleaseBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionStatusFluent.this.withDesired(builder.build());
    }
    
    public N endDesired() {
      return and();
    }
    
  }
  public class HistoryNested<N> extends UpdateHistoryFluent<HistoryNested<N>> implements Nested<N>{
  
    UpdateHistoryBuilder builder;
    int index;
  
    HistoryNested(int index,UpdateHistory item) {
      this.index = index;
      this.builder = new UpdateHistoryBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterVersionStatusFluent.this.setToHistory(index, builder.build());
    }
    
    public N endHistory() {
      return and();
    }
    
  }
}