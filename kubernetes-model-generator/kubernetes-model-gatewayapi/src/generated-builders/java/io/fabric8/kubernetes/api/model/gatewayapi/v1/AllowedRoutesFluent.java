package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class AllowedRoutesFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.AllowedRoutesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RouteGroupKindBuilder> kinds = new ArrayList<RouteGroupKindBuilder>();
  private RouteNamespacesBuilder namespaces;

  public AllowedRoutesFluent() {
  }
  
  public AllowedRoutesFluent(AllowedRoutes instance) {
    this.copyInstance(instance);
  }

  public A addAllToKinds(Collection<RouteGroupKind> items) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("kinds").add(builder);
        this.kinds.add(builder);
    }
    return (A) this;
  }
  
  public KindsNested<A> addNewKind() {
    return new KindsNested(-1, null);
  }
  
  public A addNewKind(String group,String kind) {
    return (A) this.addToKinds(new RouteGroupKind(group, kind));
  }
  
  public KindsNested<A> addNewKindLike(RouteGroupKind item) {
    return new KindsNested(-1, item);
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
  
  public A addToKinds(RouteGroupKind... items) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("kinds").add(builder);
        this.kinds.add(builder);
    }
    return (A) this;
  }
  
  public A addToKinds(int index,RouteGroupKind item) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
    if (index < 0 || index >= kinds.size()) {
        _visitables.get("kinds").add(builder);
        kinds.add(builder);
    } else {
        _visitables.get("kinds").add(builder);
        kinds.add(index, builder);
    }
    return (A) this;
  }
  
  public RouteGroupKind buildFirstKind() {
    return this.kinds.get(0).build();
  }
  
  public RouteGroupKind buildKind(int index) {
    return this.kinds.get(index).build();
  }
  
  public List<RouteGroupKind> buildKinds() {
    return this.kinds != null ? build(kinds) : null;
  }
  
  public RouteGroupKind buildLastKind() {
    return this.kinds.get(kinds.size() - 1).build();
  }
  
  public RouteGroupKind buildMatchingKind(Predicate<RouteGroupKindBuilder> predicate) {
      for (RouteGroupKindBuilder item : kinds) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RouteNamespaces buildNamespaces() {
    return this.namespaces != null ? this.namespaces.build() : null;
  }
  
  protected void copyInstance(AllowedRoutes instance) {
    instance = instance != null ? instance : new AllowedRoutes();
    if (instance != null) {
        this.withKinds(instance.getKinds());
        this.withNamespaces(instance.getNamespaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public KindsNested<A> editFirstKind() {
    if (kinds.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "kinds"));
    }
    return this.setNewKindLike(0, this.buildKind(0));
  }
  
  public KindsNested<A> editKind(int index) {
    if (kinds.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "kinds"));
    }
    return this.setNewKindLike(index, this.buildKind(index));
  }
  
  public KindsNested<A> editLastKind() {
    int index = kinds.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "kinds"));
    }
    return this.setNewKindLike(index, this.buildKind(index));
  }
  
  public KindsNested<A> editMatchingKind(Predicate<RouteGroupKindBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < kinds.size();i++) {
      if (predicate.test(kinds.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "kinds"));
    }
    return this.setNewKindLike(index, this.buildKind(index));
  }
  
  public NamespacesNested<A> editNamespaces() {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(null));
  }
  
  public NamespacesNested<A> editOrNewNamespaces() {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(new RouteNamespacesBuilder().build()));
  }
  
  public NamespacesNested<A> editOrNewNamespacesLike(RouteNamespaces item) {
    return this.withNewNamespacesLike(Optional.ofNullable(this.buildNamespaces()).orElse(item));
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
    AllowedRoutesFluent that = (AllowedRoutesFluent) o;
    if (!(Objects.equals(kinds, that.kinds))) {
      return false;
    }
    if (!(Objects.equals(namespaces, that.namespaces))) {
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
  
  public boolean hasKinds() {
    return this.kinds != null && !(this.kinds.isEmpty());
  }
  
  public boolean hasMatchingKind(Predicate<RouteGroupKindBuilder> predicate) {
      for (RouteGroupKindBuilder item : kinds) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNamespaces() {
    return this.namespaces != null;
  }
  
  public int hashCode() {
    return Objects.hash(kinds, namespaces, additionalProperties);
  }
  
  public A removeAllFromKinds(Collection<RouteGroupKind> items) {
    if (this.kinds == null) {
      return (A) this;
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("kinds").remove(builder);
        this.kinds.remove(builder);
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
  
  public A removeFromKinds(RouteGroupKind... items) {
    if (this.kinds == null) {
      return (A) this;
    }
    for (RouteGroupKind item : items) {
        RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
        _visitables.get("kinds").remove(builder);
        this.kinds.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromKinds(Predicate<RouteGroupKindBuilder> predicate) {
    if (kinds == null) {
      return (A) this;
    }
    Iterator<RouteGroupKindBuilder> each = kinds.iterator();
    List visitables = _visitables.get("kinds");
    while (each.hasNext()) {
        RouteGroupKindBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public KindsNested<A> setNewKindLike(int index,RouteGroupKind item) {
    return new KindsNested(index, item);
  }
  
  public A setToKinds(int index,RouteGroupKind item) {
    if (this.kinds == null) {
      this.kinds = new ArrayList();
    }
    RouteGroupKindBuilder builder = new RouteGroupKindBuilder(item);
    if (index < 0 || index >= kinds.size()) {
        _visitables.get("kinds").add(builder);
        kinds.add(builder);
    } else {
        _visitables.get("kinds").add(builder);
        kinds.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(kinds == null) && !(kinds.isEmpty())) {
        sb.append("kinds:");
        sb.append(kinds);
        sb.append(",");
    }
    if (!(namespaces == null)) {
        sb.append("namespaces:");
        sb.append(namespaces);
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
  
  public A withKinds(List<RouteGroupKind> kinds) {
    if (this.kinds != null) {
      this._visitables.get("kinds").clear();
    }
    if (kinds != null) {
        this.kinds = new ArrayList();
        for (RouteGroupKind item : kinds) {
          this.addToKinds(item);
        }
    } else {
      this.kinds = null;
    }
    return (A) this;
  }
  
  public A withKinds(RouteGroupKind... kinds) {
    if (this.kinds != null) {
        this.kinds.clear();
        _visitables.remove("kinds");
    }
    if (kinds != null) {
      for (RouteGroupKind item : kinds) {
        this.addToKinds(item);
      }
    }
    return (A) this;
  }
  
  public A withNamespaces(RouteNamespaces namespaces) {
    this._visitables.remove("namespaces");
    if (namespaces != null) {
        this.namespaces = new RouteNamespacesBuilder(namespaces);
        this._visitables.get("namespaces").add(this.namespaces);
    } else {
        this.namespaces = null;
        this._visitables.get("namespaces").remove(this.namespaces);
    }
    return (A) this;
  }
  
  public NamespacesNested<A> withNewNamespaces() {
    return new NamespacesNested(null);
  }
  
  public NamespacesNested<A> withNewNamespacesLike(RouteNamespaces item) {
    return new NamespacesNested(item);
  }
  public class KindsNested<N> extends RouteGroupKindFluent<KindsNested<N>> implements Nested<N>{
  
    RouteGroupKindBuilder builder;
    int index;
  
    KindsNested(int index,RouteGroupKind item) {
      this.index = index;
      this.builder = new RouteGroupKindBuilder(this, item);
    }
  
    public N and() {
      return (N) AllowedRoutesFluent.this.setToKinds(index, builder.build());
    }
    
    public N endKind() {
      return and();
    }
    
  }
  public class NamespacesNested<N> extends RouteNamespacesFluent<NamespacesNested<N>> implements Nested<N>{
  
    RouteNamespacesBuilder builder;
  
    NamespacesNested(RouteNamespaces item) {
      this.builder = new RouteNamespacesBuilder(this, item);
    }
  
    public N and() {
      return (N) AllowedRoutesFluent.this.withNamespaces(builder.build());
    }
    
    public N endNamespaces() {
      return and();
    }
    
  }
}