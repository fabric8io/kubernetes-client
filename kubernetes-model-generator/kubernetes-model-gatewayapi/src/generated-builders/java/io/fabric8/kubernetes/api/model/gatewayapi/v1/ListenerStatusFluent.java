package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class ListenerStatusFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ListenerStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer attachedRoutes;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String name;
  private ArrayList<RouteGroupKindBuilder> supportedKinds = new ArrayList<RouteGroupKindBuilder>();

  public ListenerStatusFluent() {
  }
  
  public ListenerStatusFluent(ListenerStatus instance) {
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
  
  public A addAllToSupportedKinds(Collection<RouteGroupKind> items) {
    if (this.supportedKinds == null) {
      this.supportedKinds = new ArrayList();
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("supportedKinds").add(builder);
        this.supportedKinds.add(builder);
    }
    return (A) this;
  }
  
  public SupportedKindsNested<A> addNewSupportedKind() {
    return new SupportedKindsNested(-1, null);
  }
  
  public A addNewSupportedKind(String group,String kind) {
    return (A) this.addToSupportedKinds(new RouteGroupKind(group, kind));
  }
  
  public SupportedKindsNested<A> addNewSupportedKindLike(RouteGroupKind item) {
    return new SupportedKindsNested(-1, item);
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
  
  public A addToSupportedKinds(RouteGroupKind... items) {
    if (this.supportedKinds == null) {
      this.supportedKinds = new ArrayList();
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("supportedKinds").add(builder);
        this.supportedKinds.add(builder);
    }
    return (A) this;
  }
  
  public A addToSupportedKinds(int index,RouteGroupKind item) {
    if (this.supportedKinds == null) {
      this.supportedKinds = new ArrayList();
    }
    RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
    if (index < 0 || index >= supportedKinds.size()) {
        _visitables.get("supportedKinds").add(builder);
        supportedKinds.add(builder);
    } else {
        _visitables.get("supportedKinds").add(builder);
        supportedKinds.add(index, builder);
    }
    return (A) this;
  }
  
  public RouteGroupKind buildFirstSupportedKind() {
    return this.supportedKinds.get(0).build();
  }
  
  public RouteGroupKind buildLastSupportedKind() {
    return this.supportedKinds.get(supportedKinds.size() - 1).build();
  }
  
  public RouteGroupKind buildMatchingSupportedKind(Predicate<RouteGroupKindBuilder> predicate) {
      for (RouteGroupKindBuilder item : supportedKinds) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RouteGroupKind buildSupportedKind(int index) {
    return this.supportedKinds.get(index).build();
  }
  
  public List<RouteGroupKind> buildSupportedKinds() {
    return this.supportedKinds != null ? build(supportedKinds) : null;
  }
  
  protected void copyInstance(ListenerStatus instance) {
    instance = instance != null ? instance : new ListenerStatus();
    if (instance != null) {
        this.withAttachedRoutes(instance.getAttachedRoutes());
        this.withConditions(instance.getConditions());
        this.withName(instance.getName());
        this.withSupportedKinds(instance.getSupportedKinds());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SupportedKindsNested<A> editFirstSupportedKind() {
    if (supportedKinds.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "supportedKinds"));
    }
    return this.setNewSupportedKindLike(0, this.buildSupportedKind(0));
  }
  
  public SupportedKindsNested<A> editLastSupportedKind() {
    int index = supportedKinds.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "supportedKinds"));
    }
    return this.setNewSupportedKindLike(index, this.buildSupportedKind(index));
  }
  
  public SupportedKindsNested<A> editMatchingSupportedKind(Predicate<RouteGroupKindBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < supportedKinds.size();i++) {
      if (predicate.test(supportedKinds.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "supportedKinds"));
    }
    return this.setNewSupportedKindLike(index, this.buildSupportedKind(index));
  }
  
  public SupportedKindsNested<A> editSupportedKind(int index) {
    if (supportedKinds.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "supportedKinds"));
    }
    return this.setNewSupportedKindLike(index, this.buildSupportedKind(index));
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
    ListenerStatusFluent that = (ListenerStatusFluent) o;
    if (!(Objects.equals(attachedRoutes, that.attachedRoutes))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(supportedKinds, that.supportedKinds))) {
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
  
  public Integer getAttachedRoutes() {
    return this.attachedRoutes;
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAttachedRoutes() {
    return this.attachedRoutes != null;
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
  
  public boolean hasMatchingSupportedKind(Predicate<RouteGroupKindBuilder> predicate) {
      for (RouteGroupKindBuilder item : supportedKinds) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSupportedKinds() {
    return this.supportedKinds != null && !(this.supportedKinds.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(attachedRoutes, conditions, name, supportedKinds, additionalProperties);
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
  
  public A removeAllFromSupportedKinds(Collection<RouteGroupKind> items) {
    if (this.supportedKinds == null) {
      return (A) this;
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("supportedKinds").remove(builder);
        this.supportedKinds.remove(builder);
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
  
  public A removeFromSupportedKinds(RouteGroupKind... items) {
    if (this.supportedKinds == null) {
      return (A) this;
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("supportedKinds").remove(builder);
        this.supportedKinds.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSupportedKinds(Predicate<RouteGroupKindBuilder> predicate) {
    if (supportedKinds == null) {
      return (A) this;
    }
    Iterator<RouteGroupKindBuilder> each = supportedKinds.iterator();
    List visitables = _visitables.get("supportedKinds");
    while (each.hasNext()) {
        RouteGroupKindBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SupportedKindsNested<A> setNewSupportedKindLike(int index,RouteGroupKind item) {
    return new SupportedKindsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToSupportedKinds(int index,RouteGroupKind item) {
    if (this.supportedKinds == null) {
      this.supportedKinds = new ArrayList();
    }
    RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
    if (index < 0 || index >= supportedKinds.size()) {
        _visitables.get("supportedKinds").add(builder);
        supportedKinds.add(builder);
    } else {
        _visitables.get("supportedKinds").add(builder);
        supportedKinds.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(attachedRoutes == null)) {
        sb.append("attachedRoutes:");
        sb.append(attachedRoutes);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(supportedKinds == null) && !(supportedKinds.isEmpty())) {
        sb.append("supportedKinds:");
        sb.append(supportedKinds);
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
  
  public A withAttachedRoutes(Integer attachedRoutes) {
    this.attachedRoutes = attachedRoutes;
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
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withSupportedKinds(List<RouteGroupKind> supportedKinds) {
    if (this.supportedKinds != null) {
      this._visitables.get("supportedKinds").clear();
    }
    if (supportedKinds != null) {
        this.supportedKinds = new ArrayList();
        for (RouteGroupKind item : supportedKinds) {
          this.addToSupportedKinds(item);
        }
    } else {
      this.supportedKinds = null;
    }
    return (A) this;
  }
  
  public A withSupportedKinds(RouteGroupKind... supportedKinds) {
    if (this.supportedKinds != null) {
        this.supportedKinds.clear();
        _visitables.remove("supportedKinds");
    }
    if (supportedKinds != null) {
      for (RouteGroupKind item : supportedKinds) {
        this.addToSupportedKinds(item);
      }
    }
    return (A) this;
  }
  public class SupportedKindsNested<N> extends RouteGroupKindFluent<SupportedKindsNested<N>> implements Nested<N>{
  
    RouteGroupKindBuilder builder;
    int index;
  
    SupportedKindsNested(int index,RouteGroupKind item) {
      this.index = index;
      this.builder = new RouteGroupKindBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerStatusFluent.this.setToSupportedKinds(index, builder.build());
    }
    
    public N endSupportedKind() {
      return and();
    }
    
  }
}