package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
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
public class PrometheusStatusFluent<A extends io.fabric8.openshift.api.model.monitoring.v1.PrometheusStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer availableReplicas;
  private ArrayList<ConditionBuilder> conditions = new ArrayList<ConditionBuilder>();
  private Boolean paused;
  private Integer replicas;
  private String selector;
  private ArrayList<ShardStatusBuilder> shardStatuses = new ArrayList<ShardStatusBuilder>();
  private Integer shards;
  private Integer unavailableReplicas;
  private Integer updatedReplicas;

  public PrometheusStatusFluent() {
  }
  
  public PrometheusStatusFluent(PrometheusStatus instance) {
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
  
  public A addAllToShardStatuses(Collection<ShardStatus> items) {
    if (this.shardStatuses == null) {
      this.shardStatuses = new ArrayList();
    }
    for (ShardStatus item : items) {
        ShardStatusBuilder builder = new ShardStatusBuilder(item);
        _visitables.get("shardStatuses").add(builder);
        this.shardStatuses.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(Condition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ShardStatusesNested<A> addNewShardStatus() {
    return new ShardStatusesNested(-1, null);
  }
  
  public A addNewShardStatus(Integer availableReplicas,Integer replicas,String shardID,Integer unavailableReplicas,Integer updatedReplicas) {
    return (A) this.addToShardStatuses(new ShardStatus(availableReplicas, replicas, shardID, unavailableReplicas, updatedReplicas));
  }
  
  public ShardStatusesNested<A> addNewShardStatusLike(ShardStatus item) {
    return new ShardStatusesNested(-1, item);
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
  
  public A addToShardStatuses(ShardStatus... items) {
    if (this.shardStatuses == null) {
      this.shardStatuses = new ArrayList();
    }
    for (ShardStatus item : items) {
        ShardStatusBuilder builder = new ShardStatusBuilder(item);
        _visitables.get("shardStatuses").add(builder);
        this.shardStatuses.add(builder);
    }
    return (A) this;
  }
  
  public A addToShardStatuses(int index,ShardStatus item) {
    if (this.shardStatuses == null) {
      this.shardStatuses = new ArrayList();
    }
    ShardStatusBuilder builder = new ShardStatusBuilder(item);
    if (index < 0 || index >= shardStatuses.size()) {
        _visitables.get("shardStatuses").add(builder);
        shardStatuses.add(builder);
    } else {
        _visitables.get("shardStatuses").add(builder);
        shardStatuses.add(index, builder);
    }
    return (A) this;
  }
  
  public Condition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<Condition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public Condition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ShardStatus buildFirstShardStatus() {
    return this.shardStatuses.get(0).build();
  }
  
  public Condition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ShardStatus buildLastShardStatus() {
    return this.shardStatuses.get(shardStatuses.size() - 1).build();
  }
  
  public Condition buildMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ShardStatus buildMatchingShardStatus(Predicate<ShardStatusBuilder> predicate) {
      for (ShardStatusBuilder item : shardStatuses) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ShardStatus buildShardStatus(int index) {
    return this.shardStatuses.get(index).build();
  }
  
  public List<ShardStatus> buildShardStatuses() {
    return this.shardStatuses != null ? build(shardStatuses) : null;
  }
  
  protected void copyInstance(PrometheusStatus instance) {
    instance = instance != null ? instance : new PrometheusStatus();
    if (instance != null) {
        this.withAvailableReplicas(instance.getAvailableReplicas());
        this.withConditions(instance.getConditions());
        this.withPaused(instance.getPaused());
        this.withReplicas(instance.getReplicas());
        this.withSelector(instance.getSelector());
        this.withShardStatuses(instance.getShardStatuses());
        this.withShards(instance.getShards());
        this.withUnavailableReplicas(instance.getUnavailableReplicas());
        this.withUpdatedReplicas(instance.getUpdatedReplicas());
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
  
  public ShardStatusesNested<A> editFirstShardStatus() {
    if (shardStatuses.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "shardStatuses"));
    }
    return this.setNewShardStatusLike(0, this.buildShardStatus(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ShardStatusesNested<A> editLastShardStatus() {
    int index = shardStatuses.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "shardStatuses"));
    }
    return this.setNewShardStatusLike(index, this.buildShardStatus(index));
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
  
  public ShardStatusesNested<A> editMatchingShardStatus(Predicate<ShardStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < shardStatuses.size();i++) {
      if (predicate.test(shardStatuses.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "shardStatuses"));
    }
    return this.setNewShardStatusLike(index, this.buildShardStatus(index));
  }
  
  public ShardStatusesNested<A> editShardStatus(int index) {
    if (shardStatuses.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "shardStatuses"));
    }
    return this.setNewShardStatusLike(index, this.buildShardStatus(index));
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
    PrometheusStatusFluent that = (PrometheusStatusFluent) o;
    if (!(Objects.equals(availableReplicas, that.availableReplicas))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(paused, that.paused))) {
      return false;
    }
    if (!(Objects.equals(replicas, that.replicas))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(shardStatuses, that.shardStatuses))) {
      return false;
    }
    if (!(Objects.equals(shards, that.shards))) {
      return false;
    }
    if (!(Objects.equals(unavailableReplicas, that.unavailableReplicas))) {
      return false;
    }
    if (!(Objects.equals(updatedReplicas, that.updatedReplicas))) {
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
  
  public Integer getAvailableReplicas() {
    return this.availableReplicas;
  }
  
  public Boolean getPaused() {
    return this.paused;
  }
  
  public Integer getReplicas() {
    return this.replicas;
  }
  
  public String getSelector() {
    return this.selector;
  }
  
  public Integer getShards() {
    return this.shards;
  }
  
  public Integer getUnavailableReplicas() {
    return this.unavailableReplicas;
  }
  
  public Integer getUpdatedReplicas() {
    return this.updatedReplicas;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAvailableReplicas() {
    return this.availableReplicas != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingShardStatus(Predicate<ShardStatusBuilder> predicate) {
      for (ShardStatusBuilder item : shardStatuses) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPaused() {
    return this.paused != null;
  }
  
  public boolean hasReplicas() {
    return this.replicas != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasShardStatuses() {
    return this.shardStatuses != null && !(this.shardStatuses.isEmpty());
  }
  
  public boolean hasShards() {
    return this.shards != null;
  }
  
  public boolean hasUnavailableReplicas() {
    return this.unavailableReplicas != null;
  }
  
  public boolean hasUpdatedReplicas() {
    return this.updatedReplicas != null;
  }
  
  public int hashCode() {
    return Objects.hash(availableReplicas, conditions, paused, replicas, selector, shardStatuses, shards, unavailableReplicas, updatedReplicas, additionalProperties);
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
  
  public A removeAllFromShardStatuses(Collection<ShardStatus> items) {
    if (this.shardStatuses == null) {
      return (A) this;
    }
    for (ShardStatus item : items) {
        ShardStatusBuilder builder = new ShardStatusBuilder(item);
        _visitables.get("shardStatuses").remove(builder);
        this.shardStatuses.remove(builder);
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
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromShardStatuses(ShardStatus... items) {
    if (this.shardStatuses == null) {
      return (A) this;
    }
    for (ShardStatus item : items) {
        ShardStatusBuilder builder = new ShardStatusBuilder(item);
        _visitables.get("shardStatuses").remove(builder);
        this.shardStatuses.remove(builder);
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
  
  public A removeMatchingFromShardStatuses(Predicate<ShardStatusBuilder> predicate) {
    if (shardStatuses == null) {
      return (A) this;
    }
    Iterator<ShardStatusBuilder> each = shardStatuses.iterator();
    List visitables = _visitables.get("shardStatuses");
    while (each.hasNext()) {
        ShardStatusBuilder builder = each.next();
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
  
  public ShardStatusesNested<A> setNewShardStatusLike(int index,ShardStatus item) {
    return new ShardStatusesNested(index, item);
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
  
  public A setToShardStatuses(int index,ShardStatus item) {
    if (this.shardStatuses == null) {
      this.shardStatuses = new ArrayList();
    }
    ShardStatusBuilder builder = new ShardStatusBuilder(item);
    if (index < 0 || index >= shardStatuses.size()) {
        _visitables.get("shardStatuses").add(builder);
        shardStatuses.add(builder);
    } else {
        _visitables.get("shardStatuses").add(builder);
        shardStatuses.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(availableReplicas == null)) {
        sb.append("availableReplicas:");
        sb.append(availableReplicas);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(paused == null)) {
        sb.append("paused:");
        sb.append(paused);
        sb.append(",");
    }
    if (!(replicas == null)) {
        sb.append("replicas:");
        sb.append(replicas);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(shardStatuses == null) && !(shardStatuses.isEmpty())) {
        sb.append("shardStatuses:");
        sb.append(shardStatuses);
        sb.append(",");
    }
    if (!(shards == null)) {
        sb.append("shards:");
        sb.append(shards);
        sb.append(",");
    }
    if (!(unavailableReplicas == null)) {
        sb.append("unavailableReplicas:");
        sb.append(unavailableReplicas);
        sb.append(",");
    }
    if (!(updatedReplicas == null)) {
        sb.append("updatedReplicas:");
        sb.append(updatedReplicas);
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
  
  public A withAvailableReplicas(Integer availableReplicas) {
    this.availableReplicas = availableReplicas;
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
  
  public A withPaused() {
    return withPaused(true);
  }
  
  public A withPaused(Boolean paused) {
    this.paused = paused;
    return (A) this;
  }
  
  public A withReplicas(Integer replicas) {
    this.replicas = replicas;
    return (A) this;
  }
  
  public A withSelector(String selector) {
    this.selector = selector;
    return (A) this;
  }
  
  public A withShardStatuses(List<ShardStatus> shardStatuses) {
    if (this.shardStatuses != null) {
      this._visitables.get("shardStatuses").clear();
    }
    if (shardStatuses != null) {
        this.shardStatuses = new ArrayList();
        for (ShardStatus item : shardStatuses) {
          this.addToShardStatuses(item);
        }
    } else {
      this.shardStatuses = null;
    }
    return (A) this;
  }
  
  public A withShardStatuses(ShardStatus... shardStatuses) {
    if (this.shardStatuses != null) {
        this.shardStatuses.clear();
        _visitables.remove("shardStatuses");
    }
    if (shardStatuses != null) {
      for (ShardStatus item : shardStatuses) {
        this.addToShardStatuses(item);
      }
    }
    return (A) this;
  }
  
  public A withShards(Integer shards) {
    this.shards = shards;
    return (A) this;
  }
  
  public A withUnavailableReplicas(Integer unavailableReplicas) {
    this.unavailableReplicas = unavailableReplicas;
    return (A) this;
  }
  
  public A withUpdatedReplicas(Integer updatedReplicas) {
    this.updatedReplicas = updatedReplicas;
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
      return (N) PrometheusStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ShardStatusesNested<N> extends ShardStatusFluent<ShardStatusesNested<N>> implements Nested<N>{
  
    ShardStatusBuilder builder;
    int index;
  
    ShardStatusesNested(int index,ShardStatus item) {
      this.index = index;
      this.builder = new ShardStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) PrometheusStatusFluent.this.setToShardStatuses(index, builder.build());
    }
    
    public N endShardStatus() {
      return and();
    }
    
  }
}