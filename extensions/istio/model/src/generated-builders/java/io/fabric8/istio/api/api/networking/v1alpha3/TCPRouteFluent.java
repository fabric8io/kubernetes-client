package io.fabric8.istio.api.api.networking.v1alpha3;

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
public class TCPRouteFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.TCPRouteFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<L4MatchAttributesBuilder> match = new ArrayList<L4MatchAttributesBuilder>();
  private ArrayList<RouteDestinationBuilder> route = new ArrayList<RouteDestinationBuilder>();

  public TCPRouteFluent() {
  }
  
  public TCPRouteFluent(TCPRoute instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatch(Collection<L4MatchAttributes> items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (L4MatchAttributes item : items) {
        L4MatchAttributesBuilder builder = new L4MatchAttributesBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRoute(Collection<RouteDestination> items) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    for (RouteDestination item : items) {
        RouteDestinationBuilder builder = new RouteDestinationBuilder(item);
        _visitables.get("route").add(builder);
        this.route.add(builder);
    }
    return (A) this;
  }
  
  public MatchNested<A> addNewMatch() {
    return new MatchNested(-1, null);
  }
  
  public MatchNested<A> addNewMatchLike(L4MatchAttributes item) {
    return new MatchNested(-1, item);
  }
  
  public RouteNested<A> addNewRoute() {
    return new RouteNested(-1, null);
  }
  
  public RouteNested<A> addNewRouteLike(RouteDestination item) {
    return new RouteNested(-1, item);
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
  
  public A addToMatch(L4MatchAttributes... items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (L4MatchAttributes item : items) {
        L4MatchAttributesBuilder builder = new L4MatchAttributesBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatch(int index,L4MatchAttributes item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    L4MatchAttributesBuilder builder = new L4MatchAttributesBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRoute(RouteDestination... items) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    for (RouteDestination item : items) {
        RouteDestinationBuilder builder = new RouteDestinationBuilder(item);
        _visitables.get("route").add(builder);
        this.route.add(builder);
    }
    return (A) this;
  }
  
  public A addToRoute(int index,RouteDestination item) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    RouteDestinationBuilder builder = new RouteDestinationBuilder(item);
    if (index < 0 || index >= route.size()) {
        _visitables.get("route").add(builder);
        route.add(builder);
    } else {
        _visitables.get("route").add(builder);
        route.add(index, builder);
    }
    return (A) this;
  }
  
  public L4MatchAttributes buildFirstMatch() {
    return this.match.get(0).build();
  }
  
  public RouteDestination buildFirstRoute() {
    return this.route.get(0).build();
  }
  
  public L4MatchAttributes buildLastMatch() {
    return this.match.get(match.size() - 1).build();
  }
  
  public RouteDestination buildLastRoute() {
    return this.route.get(route.size() - 1).build();
  }
  
  public List<L4MatchAttributes> buildMatch() {
    return this.match != null ? build(match) : null;
  }
  
  public L4MatchAttributes buildMatch(int index) {
    return this.match.get(index).build();
  }
  
  public L4MatchAttributes buildMatchingMatch(Predicate<L4MatchAttributesBuilder> predicate) {
      for (L4MatchAttributesBuilder item : match) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RouteDestination buildMatchingRoute(Predicate<RouteDestinationBuilder> predicate) {
      for (RouteDestinationBuilder item : route) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<RouteDestination> buildRoute() {
    return this.route != null ? build(route) : null;
  }
  
  public RouteDestination buildRoute(int index) {
    return this.route.get(index).build();
  }
  
  protected void copyInstance(TCPRoute instance) {
    instance = instance != null ? instance : new TCPRoute();
    if (instance != null) {
        this.withMatch(instance.getMatch());
        this.withRoute(instance.getRoute());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchNested<A> editFirstMatch() {
    if (match.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(0, this.buildMatch(0));
  }
  
  public RouteNested<A> editFirstRoute() {
    if (route.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "route"));
    }
    return this.setNewRouteLike(0, this.buildRoute(0));
  }
  
  public MatchNested<A> editLastMatch() {
    int index = match.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public RouteNested<A> editLastRoute() {
    int index = route.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "route"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public MatchNested<A> editMatch(int index) {
    if (match.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatchingMatch(Predicate<L4MatchAttributesBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < match.size();i++) {
      if (predicate.test(match.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public RouteNested<A> editMatchingRoute(Predicate<RouteDestinationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < route.size();i++) {
      if (predicate.test(route.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "route"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public RouteNested<A> editRoute(int index) {
    if (route.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "route"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
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
    TCPRouteFluent that = (TCPRouteFluent) o;
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(route, that.route))) {
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
  
  public boolean hasMatch() {
    return this.match != null && !(this.match.isEmpty());
  }
  
  public boolean hasMatchingMatch(Predicate<L4MatchAttributesBuilder> predicate) {
      for (L4MatchAttributesBuilder item : match) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRoute(Predicate<RouteDestinationBuilder> predicate) {
      for (RouteDestinationBuilder item : route) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRoute() {
    return this.route != null && !(this.route.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(match, route, additionalProperties);
  }
  
  public A removeAllFromMatch(Collection<L4MatchAttributes> items) {
    if (this.match == null) {
      return (A) this;
    }
    for (L4MatchAttributes item : items) {
        L4MatchAttributesBuilder builder = new L4MatchAttributesBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRoute(Collection<RouteDestination> items) {
    if (this.route == null) {
      return (A) this;
    }
    for (RouteDestination item : items) {
        RouteDestinationBuilder builder = new RouteDestinationBuilder(item);
        _visitables.get("route").remove(builder);
        this.route.remove(builder);
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
  
  public A removeFromMatch(L4MatchAttributes... items) {
    if (this.match == null) {
      return (A) this;
    }
    for (L4MatchAttributes item : items) {
        L4MatchAttributesBuilder builder = new L4MatchAttributesBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRoute(RouteDestination... items) {
    if (this.route == null) {
      return (A) this;
    }
    for (RouteDestination item : items) {
        RouteDestinationBuilder builder = new RouteDestinationBuilder(item);
        _visitables.get("route").remove(builder);
        this.route.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatch(Predicate<L4MatchAttributesBuilder> predicate) {
    if (match == null) {
      return (A) this;
    }
    Iterator<L4MatchAttributesBuilder> each = match.iterator();
    List visitables = _visitables.get("match");
    while (each.hasNext()) {
        L4MatchAttributesBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRoute(Predicate<RouteDestinationBuilder> predicate) {
    if (route == null) {
      return (A) this;
    }
    Iterator<RouteDestinationBuilder> each = route.iterator();
    List visitables = _visitables.get("route");
    while (each.hasNext()) {
        RouteDestinationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchNested<A> setNewMatchLike(int index,L4MatchAttributes item) {
    return new MatchNested(index, item);
  }
  
  public RouteNested<A> setNewRouteLike(int index,RouteDestination item) {
    return new RouteNested(index, item);
  }
  
  public A setToMatch(int index,L4MatchAttributes item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    L4MatchAttributesBuilder builder = new L4MatchAttributesBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRoute(int index,RouteDestination item) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    RouteDestinationBuilder builder = new RouteDestinationBuilder(item);
    if (index < 0 || index >= route.size()) {
        _visitables.get("route").add(builder);
        route.add(builder);
    } else {
        _visitables.get("route").add(builder);
        route.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(match == null) && !(match.isEmpty())) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(route == null) && !(route.isEmpty())) {
        sb.append("route:");
        sb.append(route);
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
  
  public A withMatch(List<L4MatchAttributes> match) {
    if (this.match != null) {
      this._visitables.get("match").clear();
    }
    if (match != null) {
        this.match = new ArrayList();
        for (L4MatchAttributes item : match) {
          this.addToMatch(item);
        }
    } else {
      this.match = null;
    }
    return (A) this;
  }
  
  public A withMatch(L4MatchAttributes... match) {
    if (this.match != null) {
        this.match.clear();
        _visitables.remove("match");
    }
    if (match != null) {
      for (L4MatchAttributes item : match) {
        this.addToMatch(item);
      }
    }
    return (A) this;
  }
  
  public A withRoute(List<RouteDestination> route) {
    if (this.route != null) {
      this._visitables.get("route").clear();
    }
    if (route != null) {
        this.route = new ArrayList();
        for (RouteDestination item : route) {
          this.addToRoute(item);
        }
    } else {
      this.route = null;
    }
    return (A) this;
  }
  
  public A withRoute(RouteDestination... route) {
    if (this.route != null) {
        this.route.clear();
        _visitables.remove("route");
    }
    if (route != null) {
      for (RouteDestination item : route) {
        this.addToRoute(item);
      }
    }
    return (A) this;
  }
  public class MatchNested<N> extends L4MatchAttributesFluent<MatchNested<N>> implements Nested<N>{
  
    L4MatchAttributesBuilder builder;
    int index;
  
    MatchNested(int index,L4MatchAttributes item) {
      this.index = index;
      this.builder = new L4MatchAttributesBuilder(this, item);
    }
  
    public N and() {
      return (N) TCPRouteFluent.this.setToMatch(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class RouteNested<N> extends RouteDestinationFluent<RouteNested<N>> implements Nested<N>{
  
    RouteDestinationBuilder builder;
    int index;
  
    RouteNested(int index,RouteDestination item) {
      this.index = index;
      this.builder = new RouteDestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) TCPRouteFluent.this.setToRoute(index, builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}