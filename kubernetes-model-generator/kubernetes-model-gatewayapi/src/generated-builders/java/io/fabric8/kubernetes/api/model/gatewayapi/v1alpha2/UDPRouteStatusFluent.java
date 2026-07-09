package io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.RouteParentStatus;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.RouteParentStatusBuilder;
import io.fabric8.kubernetes.api.model.gatewayapi.v1.RouteParentStatusFluent;
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
public class UDPRouteStatusFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.UDPRouteStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RouteParentStatusBuilder> parents = new ArrayList<RouteParentStatusBuilder>();

  public UDPRouteStatusFluent() {
  }
  
  public UDPRouteStatusFluent(UDPRouteStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToParents(Collection<RouteParentStatus> items) {
    if (this.parents == null) {
      this.parents = new ArrayList();
    }
    for (RouteParentStatus item : items) {
        RouteParentStatusBuilder builder = new RouteParentStatusBuilder(item);
        _visitables.get("parents").add(builder);
        this.parents.add(builder);
    }
    return (A) this;
  }
  
  public ParentsNested<A> addNewParent() {
    return new ParentsNested(-1, null);
  }
  
  public ParentsNested<A> addNewParentLike(RouteParentStatus item) {
    return new ParentsNested(-1, item);
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
  
  public A addToParents(RouteParentStatus... items) {
    if (this.parents == null) {
      this.parents = new ArrayList();
    }
    for (RouteParentStatus item : items) {
        RouteParentStatusBuilder builder = new RouteParentStatusBuilder(item);
        _visitables.get("parents").add(builder);
        this.parents.add(builder);
    }
    return (A) this;
  }
  
  public A addToParents(int index,RouteParentStatus item) {
    if (this.parents == null) {
      this.parents = new ArrayList();
    }
    RouteParentStatusBuilder builder = new RouteParentStatusBuilder(item);
    if (index < 0 || index >= parents.size()) {
        _visitables.get("parents").add(builder);
        parents.add(builder);
    } else {
        _visitables.get("parents").add(builder);
        parents.add(index, builder);
    }
    return (A) this;
  }
  
  public RouteParentStatus buildFirstParent() {
    return this.parents.get(0).build();
  }
  
  public RouteParentStatus buildLastParent() {
    return this.parents.get(parents.size() - 1).build();
  }
  
  public RouteParentStatus buildMatchingParent(Predicate<RouteParentStatusBuilder> predicate) {
      for (RouteParentStatusBuilder item : parents) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RouteParentStatus buildParent(int index) {
    return this.parents.get(index).build();
  }
  
  public List<RouteParentStatus> buildParents() {
    return this.parents != null ? build(parents) : null;
  }
  
  protected void copyInstance(UDPRouteStatus instance) {
    instance = instance != null ? instance : new UDPRouteStatus();
    if (instance != null) {
        this.withParents(instance.getParents());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ParentsNested<A> editFirstParent() {
    if (parents.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "parents"));
    }
    return this.setNewParentLike(0, this.buildParent(0));
  }
  
  public ParentsNested<A> editLastParent() {
    int index = parents.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "parents"));
    }
    return this.setNewParentLike(index, this.buildParent(index));
  }
  
  public ParentsNested<A> editMatchingParent(Predicate<RouteParentStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < parents.size();i++) {
      if (predicate.test(parents.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "parents"));
    }
    return this.setNewParentLike(index, this.buildParent(index));
  }
  
  public ParentsNested<A> editParent(int index) {
    if (parents.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "parents"));
    }
    return this.setNewParentLike(index, this.buildParent(index));
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
    UDPRouteStatusFluent that = (UDPRouteStatusFluent) o;
    if (!(Objects.equals(parents, that.parents))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingParent(Predicate<RouteParentStatusBuilder> predicate) {
      for (RouteParentStatusBuilder item : parents) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasParents() {
    return this.parents != null && !(this.parents.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(parents, additionalProperties);
  }
  
  public A removeAllFromParents(Collection<RouteParentStatus> items) {
    if (this.parents == null) {
      return (A) this;
    }
    for (RouteParentStatus item : items) {
        RouteParentStatusBuilder builder = new RouteParentStatusBuilder(item);
        _visitables.get("parents").remove(builder);
        this.parents.remove(builder);
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
  
  public A removeFromParents(RouteParentStatus... items) {
    if (this.parents == null) {
      return (A) this;
    }
    for (RouteParentStatus item : items) {
        RouteParentStatusBuilder builder = new RouteParentStatusBuilder(item);
        _visitables.get("parents").remove(builder);
        this.parents.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromParents(Predicate<RouteParentStatusBuilder> predicate) {
    if (parents == null) {
      return (A) this;
    }
    Iterator<RouteParentStatusBuilder> each = parents.iterator();
    List visitables = _visitables.get("parents");
    while (each.hasNext()) {
        RouteParentStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ParentsNested<A> setNewParentLike(int index,RouteParentStatus item) {
    return new ParentsNested(index, item);
  }
  
  public A setToParents(int index,RouteParentStatus item) {
    if (this.parents == null) {
      this.parents = new ArrayList();
    }
    RouteParentStatusBuilder builder = new RouteParentStatusBuilder(item);
    if (index < 0 || index >= parents.size()) {
        _visitables.get("parents").add(builder);
        parents.add(builder);
    } else {
        _visitables.get("parents").add(builder);
        parents.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(parents == null) && !(parents.isEmpty())) {
        sb.append("parents:");
        sb.append(parents);
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
  
  public A withParents(List<RouteParentStatus> parents) {
    if (this.parents != null) {
      this._visitables.get("parents").clear();
    }
    if (parents != null) {
        this.parents = new ArrayList();
        for (RouteParentStatus item : parents) {
          this.addToParents(item);
        }
    } else {
      this.parents = null;
    }
    return (A) this;
  }
  
  public A withParents(RouteParentStatus... parents) {
    if (this.parents != null) {
        this.parents.clear();
        _visitables.remove("parents");
    }
    if (parents != null) {
      for (RouteParentStatus item : parents) {
        this.addToParents(item);
      }
    }
    return (A) this;
  }
  public class ParentsNested<N> extends RouteParentStatusFluent<ParentsNested<N>> implements Nested<N>{
  
    RouteParentStatusBuilder builder;
    int index;
  
    ParentsNested(int index,RouteParentStatus item) {
      this.index = index;
      this.builder = new RouteParentStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) UDPRouteStatusFluent.this.setToParents(index, builder.build());
    }
    
    public N endParent() {
      return and();
    }
    
  }
}