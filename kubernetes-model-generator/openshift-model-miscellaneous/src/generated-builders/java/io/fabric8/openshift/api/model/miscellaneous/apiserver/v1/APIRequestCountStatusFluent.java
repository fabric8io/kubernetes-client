package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class APIRequestCountStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.APIRequestCountStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private PerResourceAPIRequestLogBuilder currentHour;
  private ArrayList<PerResourceAPIRequestLogBuilder> last24h = new ArrayList<PerResourceAPIRequestLogBuilder>();
  private String removedInRelease;
  private Long requestCount;

  public APIRequestCountStatusFluent() {
  }
  
  public APIRequestCountStatusFluent(APIRequestCountStatus instance) {
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
  
  public A addAllToLast24h(Collection<PerResourceAPIRequestLog> items) {
    if (this.last24h == null) {
      this.last24h = new ArrayList();
    }
    for (PerResourceAPIRequestLog item : items) {
        PerResourceAPIRequestLogBuilder builder = new PerResourceAPIRequestLogBuilder(item);
        _visitables.get("last24h").add(builder);
        this.last24h.add(builder);
    }
    return (A) this;
  }
  
  public Last24hNested<A> addNewLast24h() {
    return new Last24hNested(-1, null);
  }
  
  public Last24hNested<A> addNewLast24hLike(PerResourceAPIRequestLog item) {
    return new Last24hNested(-1, item);
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
  
  public A addToLast24h(PerResourceAPIRequestLog... items) {
    if (this.last24h == null) {
      this.last24h = new ArrayList();
    }
    for (PerResourceAPIRequestLog item : items) {
        PerResourceAPIRequestLogBuilder builder = new PerResourceAPIRequestLogBuilder(item);
        _visitables.get("last24h").add(builder);
        this.last24h.add(builder);
    }
    return (A) this;
  }
  
  public A addToLast24h(int index,PerResourceAPIRequestLog item) {
    if (this.last24h == null) {
      this.last24h = new ArrayList();
    }
    PerResourceAPIRequestLogBuilder builder = new PerResourceAPIRequestLogBuilder(item);
    if (index < 0 || index >= last24h.size()) {
        _visitables.get("last24h").add(builder);
        last24h.add(builder);
    } else {
        _visitables.get("last24h").add(builder);
        last24h.add(index, builder);
    }
    return (A) this;
  }
  
  public PerResourceAPIRequestLog buildCurrentHour() {
    return this.currentHour != null ? this.currentHour.build() : null;
  }
  
  public PerResourceAPIRequestLog buildFirstLast24h() {
    return this.last24h.get(0).build();
  }
  
  public List<PerResourceAPIRequestLog> buildLast24h() {
    return this.last24h != null ? build(last24h) : null;
  }
  
  public PerResourceAPIRequestLog buildLast24h(int index) {
    return this.last24h.get(index).build();
  }
  
  public PerResourceAPIRequestLog buildLastLast24h() {
    return this.last24h.get(last24h.size() - 1).build();
  }
  
  public PerResourceAPIRequestLog buildMatchingLast24h(Predicate<PerResourceAPIRequestLogBuilder> predicate) {
      for (PerResourceAPIRequestLogBuilder item : last24h) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(APIRequestCountStatus instance) {
    instance = instance != null ? instance : new APIRequestCountStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withCurrentHour(instance.getCurrentHour());
        this.withLast24h(instance.getLast24h());
        this.withRemovedInRelease(instance.getRemovedInRelease());
        this.withRequestCount(instance.getRequestCount());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CurrentHourNested<A> editCurrentHour() {
    return this.withNewCurrentHourLike(Optional.ofNullable(this.buildCurrentHour()).orElse(null));
  }
  
  public Last24hNested<A> editFirstLast24h() {
    if (last24h.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "last24h"));
    }
    return this.setNewLast24hLike(0, this.buildLast24h(0));
  }
  
  public Last24hNested<A> editLast24h(int index) {
    if (last24h.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "last24h"));
    }
    return this.setNewLast24hLike(index, this.buildLast24h(index));
  }
  
  public Last24hNested<A> editLastLast24h() {
    int index = last24h.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "last24h"));
    }
    return this.setNewLast24hLike(index, this.buildLast24h(index));
  }
  
  public Last24hNested<A> editMatchingLast24h(Predicate<PerResourceAPIRequestLogBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < last24h.size();i++) {
      if (predicate.test(last24h.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "last24h"));
    }
    return this.setNewLast24hLike(index, this.buildLast24h(index));
  }
  
  public CurrentHourNested<A> editOrNewCurrentHour() {
    return this.withNewCurrentHourLike(Optional.ofNullable(this.buildCurrentHour()).orElse(new PerResourceAPIRequestLogBuilder().build()));
  }
  
  public CurrentHourNested<A> editOrNewCurrentHourLike(PerResourceAPIRequestLog item) {
    return this.withNewCurrentHourLike(Optional.ofNullable(this.buildCurrentHour()).orElse(item));
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
    APIRequestCountStatusFluent that = (APIRequestCountStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(currentHour, that.currentHour))) {
      return false;
    }
    if (!(Objects.equals(last24h, that.last24h))) {
      return false;
    }
    if (!(Objects.equals(removedInRelease, that.removedInRelease))) {
      return false;
    }
    if (!(Objects.equals(requestCount, that.requestCount))) {
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
  
  public String getRemovedInRelease() {
    return this.removedInRelease;
  }
  
  public Long getRequestCount() {
    return this.requestCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasCurrentHour() {
    return this.currentHour != null;
  }
  
  public boolean hasLast24h() {
    return this.last24h != null && !(this.last24h.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLast24h(Predicate<PerResourceAPIRequestLogBuilder> predicate) {
      for (PerResourceAPIRequestLogBuilder item : last24h) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRemovedInRelease() {
    return this.removedInRelease != null;
  }
  
  public boolean hasRequestCount() {
    return this.requestCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, currentHour, last24h, removedInRelease, requestCount, additionalProperties);
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
  
  public A removeAllFromLast24h(Collection<PerResourceAPIRequestLog> items) {
    if (this.last24h == null) {
      return (A) this;
    }
    for (PerResourceAPIRequestLog item : items) {
        PerResourceAPIRequestLogBuilder builder = new PerResourceAPIRequestLogBuilder(item);
        _visitables.get("last24h").remove(builder);
        this.last24h.remove(builder);
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
  
  public A removeFromLast24h(PerResourceAPIRequestLog... items) {
    if (this.last24h == null) {
      return (A) this;
    }
    for (PerResourceAPIRequestLog item : items) {
        PerResourceAPIRequestLogBuilder builder = new PerResourceAPIRequestLogBuilder(item);
        _visitables.get("last24h").remove(builder);
        this.last24h.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromLast24h(Predicate<PerResourceAPIRequestLogBuilder> predicate) {
    if (last24h == null) {
      return (A) this;
    }
    Iterator<PerResourceAPIRequestLogBuilder> each = last24h.iterator();
    List visitables = _visitables.get("last24h");
    while (each.hasNext()) {
        PerResourceAPIRequestLogBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public Last24hNested<A> setNewLast24hLike(int index,PerResourceAPIRequestLog item) {
    return new Last24hNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToLast24h(int index,PerResourceAPIRequestLog item) {
    if (this.last24h == null) {
      this.last24h = new ArrayList();
    }
    PerResourceAPIRequestLogBuilder builder = new PerResourceAPIRequestLogBuilder(item);
    if (index < 0 || index >= last24h.size()) {
        _visitables.get("last24h").add(builder);
        last24h.add(builder);
    } else {
        _visitables.get("last24h").add(builder);
        last24h.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(currentHour == null)) {
        sb.append("currentHour:");
        sb.append(currentHour);
        sb.append(",");
    }
    if (!(last24h == null) && !(last24h.isEmpty())) {
        sb.append("last24h:");
        sb.append(last24h);
        sb.append(",");
    }
    if (!(removedInRelease == null)) {
        sb.append("removedInRelease:");
        sb.append(removedInRelease);
        sb.append(",");
    }
    if (!(requestCount == null)) {
        sb.append("requestCount:");
        sb.append(requestCount);
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
  
  public A withCurrentHour(PerResourceAPIRequestLog currentHour) {
    this._visitables.remove("currentHour");
    if (currentHour != null) {
        this.currentHour = new PerResourceAPIRequestLogBuilder(currentHour);
        this._visitables.get("currentHour").add(this.currentHour);
    } else {
        this.currentHour = null;
        this._visitables.get("currentHour").remove(this.currentHour);
    }
    return (A) this;
  }
  
  public A withLast24h(List<PerResourceAPIRequestLog> last24h) {
    if (this.last24h != null) {
      this._visitables.get("last24h").clear();
    }
    if (last24h != null) {
        this.last24h = new ArrayList();
        for (PerResourceAPIRequestLog item : last24h) {
          this.addToLast24h(item);
        }
    } else {
      this.last24h = null;
    }
    return (A) this;
  }
  
  public A withLast24h(PerResourceAPIRequestLog... last24h) {
    if (this.last24h != null) {
        this.last24h.clear();
        _visitables.remove("last24h");
    }
    if (last24h != null) {
      for (PerResourceAPIRequestLog item : last24h) {
        this.addToLast24h(item);
      }
    }
    return (A) this;
  }
  
  public CurrentHourNested<A> withNewCurrentHour() {
    return new CurrentHourNested(null);
  }
  
  public CurrentHourNested<A> withNewCurrentHourLike(PerResourceAPIRequestLog item) {
    return new CurrentHourNested(item);
  }
  
  public A withRemovedInRelease(String removedInRelease) {
    this.removedInRelease = removedInRelease;
    return (A) this;
  }
  
  public A withRequestCount(Long requestCount) {
    this.requestCount = requestCount;
    return (A) this;
  }
  public class CurrentHourNested<N> extends PerResourceAPIRequestLogFluent<CurrentHourNested<N>> implements Nested<N>{
  
    PerResourceAPIRequestLogBuilder builder;
  
    CurrentHourNested(PerResourceAPIRequestLog item) {
      this.builder = new PerResourceAPIRequestLogBuilder(this, item);
    }
  
    public N and() {
      return (N) APIRequestCountStatusFluent.this.withCurrentHour(builder.build());
    }
    
    public N endCurrentHour() {
      return and();
    }
    
  }
  public class Last24hNested<N> extends PerResourceAPIRequestLogFluent<Last24hNested<N>> implements Nested<N>{
  
    PerResourceAPIRequestLogBuilder builder;
    int index;
  
    Last24hNested(int index,PerResourceAPIRequestLog item) {
      this.index = index;
      this.builder = new PerResourceAPIRequestLogBuilder(this, item);
    }
  
    public N and() {
      return (N) APIRequestCountStatusFluent.this.setToLast24h(index, builder.build());
    }
    
    public N endLast24h() {
      return and();
    }
    
  }
}