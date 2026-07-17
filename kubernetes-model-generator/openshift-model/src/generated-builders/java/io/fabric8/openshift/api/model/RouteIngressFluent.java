package io.fabric8.openshift.api.model;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RouteIngressFluent<A extends io.fabric8.openshift.api.model.RouteIngressFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RouteIngressConditionBuilder> conditions = new ArrayList<RouteIngressConditionBuilder>();
  private String host;
  private String routerCanonicalHostname;
  private String routerName;
  private String wildcardPolicy;

  public RouteIngressFluent() {
  }
  
  public RouteIngressFluent(RouteIngress instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<RouteIngressCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (RouteIngressCondition item : items) {
        RouteIngressConditionBuilder builder = new RouteIngressConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new RouteIngressCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(RouteIngressCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(RouteIngressCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (RouteIngressCondition item : items) {
        RouteIngressConditionBuilder builder = new RouteIngressConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,RouteIngressCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    RouteIngressConditionBuilder builder = new RouteIngressConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public RouteIngressCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<RouteIngressCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public RouteIngressCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public RouteIngressCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public RouteIngressCondition buildMatchingCondition(Predicate<RouteIngressConditionBuilder> predicate) {
      for (RouteIngressConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RouteIngress instance) {
    instance = instance != null ? instance : new RouteIngress();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withHost(instance.getHost());
        this.withRouterCanonicalHostname(instance.getRouterCanonicalHostname());
        this.withRouterName(instance.getRouterName());
        this.withWildcardPolicy(instance.getWildcardPolicy());
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<RouteIngressConditionBuilder> predicate) {
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
    RouteIngressFluent that = (RouteIngressFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(host, that.host))) {
      return false;
    }
    if (!(Objects.equals(routerCanonicalHostname, that.routerCanonicalHostname))) {
      return false;
    }
    if (!(Objects.equals(routerName, that.routerName))) {
      return false;
    }
    if (!(Objects.equals(wildcardPolicy, that.wildcardPolicy))) {
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
  
  public String getHost() {
    return this.host;
  }
  
  public String getRouterCanonicalHostname() {
    return this.routerCanonicalHostname;
  }
  
  public String getRouterName() {
    return this.routerName;
  }
  
  public String getWildcardPolicy() {
    return this.wildcardPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasHost() {
    return this.host != null;
  }
  
  public boolean hasMatchingCondition(Predicate<RouteIngressConditionBuilder> predicate) {
      for (RouteIngressConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRouterCanonicalHostname() {
    return this.routerCanonicalHostname != null;
  }
  
  public boolean hasRouterName() {
    return this.routerName != null;
  }
  
  public boolean hasWildcardPolicy() {
    return this.wildcardPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, host, routerCanonicalHostname, routerName, wildcardPolicy, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<RouteIngressCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (RouteIngressCondition item : items) {
        RouteIngressConditionBuilder builder = new RouteIngressConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(RouteIngressCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (RouteIngressCondition item : items) {
        RouteIngressConditionBuilder builder = new RouteIngressConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<RouteIngressConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<RouteIngressConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        RouteIngressConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,RouteIngressCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,RouteIngressCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    RouteIngressConditionBuilder builder = new RouteIngressConditionBuilder(item);
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
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(host == null)) {
        sb.append("host:");
        sb.append(host);
        sb.append(",");
    }
    if (!(routerCanonicalHostname == null)) {
        sb.append("routerCanonicalHostname:");
        sb.append(routerCanonicalHostname);
        sb.append(",");
    }
    if (!(routerName == null)) {
        sb.append("routerName:");
        sb.append(routerName);
        sb.append(",");
    }
    if (!(wildcardPolicy == null)) {
        sb.append("wildcardPolicy:");
        sb.append(wildcardPolicy);
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
  
  public A withConditions(List<RouteIngressCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (RouteIngressCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(RouteIngressCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (RouteIngressCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withHost(String host) {
    this.host = host;
    return (A) this;
  }
  
  public A withRouterCanonicalHostname(String routerCanonicalHostname) {
    this.routerCanonicalHostname = routerCanonicalHostname;
    return (A) this;
  }
  
  public A withRouterName(String routerName) {
    this.routerName = routerName;
    return (A) this;
  }
  
  public A withWildcardPolicy(String wildcardPolicy) {
    this.wildcardPolicy = wildcardPolicy;
    return (A) this;
  }
  public class ConditionsNested<N> extends RouteIngressConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    RouteIngressConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,RouteIngressCondition item) {
      this.index = index;
      this.builder = new RouteIngressConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) RouteIngressFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}