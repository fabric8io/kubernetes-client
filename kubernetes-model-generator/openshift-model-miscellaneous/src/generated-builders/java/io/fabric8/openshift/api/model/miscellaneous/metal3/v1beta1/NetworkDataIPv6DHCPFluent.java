package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class NetworkDataIPv6DHCPFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataIPv6DHCPFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String id;
  private String link;
  private ArrayList<NetworkDataRoutev6Builder> routes = new ArrayList<NetworkDataRoutev6Builder>();

  public NetworkDataIPv6DHCPFluent() {
  }
  
  public NetworkDataIPv6DHCPFluent(NetworkDataIPv6DHCP instance) {
    this.copyInstance(instance);
  }

  public A addAllToRoutes(Collection<NetworkDataRoutev6> items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (NetworkDataRoutev6 item : items) {
        NetworkDataRoutev6Builder builder = new NetworkDataRoutev6Builder(item);
        _visitables.get("routes").add(builder);
        this.routes.add(builder);
    }
    return (A) this;
  }
  
  public RoutesNested<A> addNewRoute() {
    return new RoutesNested(-1, null);
  }
  
  public RoutesNested<A> addNewRouteLike(NetworkDataRoutev6 item) {
    return new RoutesNested(-1, item);
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
  
  public A addToRoutes(NetworkDataRoutev6... items) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    for (NetworkDataRoutev6 item : items) {
        NetworkDataRoutev6Builder builder = new NetworkDataRoutev6Builder(item);
        _visitables.get("routes").add(builder);
        this.routes.add(builder);
    }
    return (A) this;
  }
  
  public A addToRoutes(int index,NetworkDataRoutev6 item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    NetworkDataRoutev6Builder builder = new NetworkDataRoutev6Builder(item);
    if (index < 0 || index >= routes.size()) {
        _visitables.get("routes").add(builder);
        routes.add(builder);
    } else {
        _visitables.get("routes").add(builder);
        routes.add(index, builder);
    }
    return (A) this;
  }
  
  public NetworkDataRoutev6 buildFirstRoute() {
    return this.routes.get(0).build();
  }
  
  public NetworkDataRoutev6 buildLastRoute() {
    return this.routes.get(routes.size() - 1).build();
  }
  
  public NetworkDataRoutev6 buildMatchingRoute(Predicate<NetworkDataRoutev6Builder> predicate) {
      for (NetworkDataRoutev6Builder item : routes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkDataRoutev6 buildRoute(int index) {
    return this.routes.get(index).build();
  }
  
  public List<NetworkDataRoutev6> buildRoutes() {
    return this.routes != null ? build(routes) : null;
  }
  
  protected void copyInstance(NetworkDataIPv6DHCP instance) {
    instance = instance != null ? instance : new NetworkDataIPv6DHCP();
    if (instance != null) {
        this.withId(instance.getId());
        this.withLink(instance.getLink());
        this.withRoutes(instance.getRoutes());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RoutesNested<A> editFirstRoute() {
    if (routes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "routes"));
    }
    return this.setNewRouteLike(0, this.buildRoute(0));
  }
  
  public RoutesNested<A> editLastRoute() {
    int index = routes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public RoutesNested<A> editMatchingRoute(Predicate<NetworkDataRoutev6Builder> predicate) {
    int index = -1;
    for (int i = 0;i < routes.size();i++) {
      if (predicate.test(routes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "routes"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public RoutesNested<A> editRoute(int index) {
    if (routes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "routes"));
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
    NetworkDataIPv6DHCPFluent that = (NetworkDataIPv6DHCPFluent) o;
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(link, that.link))) {
      return false;
    }
    if (!(Objects.equals(routes, that.routes))) {
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
  
  public String getId() {
    return this.id;
  }
  
  public String getLink() {
    return this.link;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasLink() {
    return this.link != null;
  }
  
  public boolean hasMatchingRoute(Predicate<NetworkDataRoutev6Builder> predicate) {
      for (NetworkDataRoutev6Builder item : routes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRoutes() {
    return this.routes != null && !(this.routes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(id, link, routes, additionalProperties);
  }
  
  public A removeAllFromRoutes(Collection<NetworkDataRoutev6> items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (NetworkDataRoutev6 item : items) {
        NetworkDataRoutev6Builder builder = new NetworkDataRoutev6Builder(item);
        _visitables.get("routes").remove(builder);
        this.routes.remove(builder);
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
  
  public A removeFromRoutes(NetworkDataRoutev6... items) {
    if (this.routes == null) {
      return (A) this;
    }
    for (NetworkDataRoutev6 item : items) {
        NetworkDataRoutev6Builder builder = new NetworkDataRoutev6Builder(item);
        _visitables.get("routes").remove(builder);
        this.routes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRoutes(Predicate<NetworkDataRoutev6Builder> predicate) {
    if (routes == null) {
      return (A) this;
    }
    Iterator<NetworkDataRoutev6Builder> each = routes.iterator();
    List visitables = _visitables.get("routes");
    while (each.hasNext()) {
        NetworkDataRoutev6Builder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RoutesNested<A> setNewRouteLike(int index,NetworkDataRoutev6 item) {
    return new RoutesNested(index, item);
  }
  
  public A setToRoutes(int index,NetworkDataRoutev6 item) {
    if (this.routes == null) {
      this.routes = new ArrayList();
    }
    NetworkDataRoutev6Builder builder = new NetworkDataRoutev6Builder(item);
    if (index < 0 || index >= routes.size()) {
        _visitables.get("routes").add(builder);
        routes.add(builder);
    } else {
        _visitables.get("routes").add(builder);
        routes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(link == null)) {
        sb.append("link:");
        sb.append(link);
        sb.append(",");
    }
    if (!(routes == null) && !(routes.isEmpty())) {
        sb.append("routes:");
        sb.append(routes);
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
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withLink(String link) {
    this.link = link;
    return (A) this;
  }
  
  public A withRoutes(List<NetworkDataRoutev6> routes) {
    if (this.routes != null) {
      this._visitables.get("routes").clear();
    }
    if (routes != null) {
        this.routes = new ArrayList();
        for (NetworkDataRoutev6 item : routes) {
          this.addToRoutes(item);
        }
    } else {
      this.routes = null;
    }
    return (A) this;
  }
  
  public A withRoutes(NetworkDataRoutev6... routes) {
    if (this.routes != null) {
        this.routes.clear();
        _visitables.remove("routes");
    }
    if (routes != null) {
      for (NetworkDataRoutev6 item : routes) {
        this.addToRoutes(item);
      }
    }
    return (A) this;
  }
  public class RoutesNested<N> extends NetworkDataRoutev6Fluent<RoutesNested<N>> implements Nested<N>{
  
    NetworkDataRoutev6Builder builder;
    int index;
  
    RoutesNested(int index,NetworkDataRoutev6 item) {
      this.index = index;
      this.builder = new NetworkDataRoutev6Builder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataIPv6DHCPFluent.this.setToRoutes(index, builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}