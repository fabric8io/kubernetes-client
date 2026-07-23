package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class GRPCBackendRefFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GRPCBackendRefFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<GRPCRouteFilterBuilder> filters = new ArrayList<GRPCRouteFilterBuilder>();
  private String group;
  private String kind;
  private String name;
  private String namespace;
  private Integer port;
  private Integer weight;

  public GRPCBackendRefFluent() {
  }
  
  public GRPCBackendRefFluent(GRPCBackendRef instance) {
    this.copyInstance(instance);
  }

  public A addAllToFilters(Collection<GRPCRouteFilter> items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(GRPCRouteFilter item) {
    return new FiltersNested(-1, item);
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
  
  public A addToFilters(GRPCRouteFilter... items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addToFilters(int index,GRPCRouteFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.add(index, builder);
    }
    return (A) this;
  }
  
  public GRPCRouteFilter buildFilter(int index) {
    return this.filters.get(index).build();
  }
  
  public List<GRPCRouteFilter> buildFilters() {
    return this.filters != null ? build(filters) : null;
  }
  
  public GRPCRouteFilter buildFirstFilter() {
    return this.filters.get(0).build();
  }
  
  public GRPCRouteFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public GRPCRouteFilter buildMatchingFilter(Predicate<GRPCRouteFilterBuilder> predicate) {
      for (GRPCRouteFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(GRPCBackendRef instance) {
    instance = instance != null ? instance : new GRPCBackendRef();
    if (instance != null) {
        this.withFilters(instance.getFilters());
        this.withGroup(instance.getGroup());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withPort(instance.getPort());
        this.withWeight(instance.getWeight());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FiltersNested<A> editFilter(int index) {
    if (filters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public FiltersNested<A> editFirstFilter() {
    if (filters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(0, this.buildFilter(0));
  }
  
  public FiltersNested<A> editLastFilter() {
    int index = filters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public FiltersNested<A> editMatchingFilter(Predicate<GRPCRouteFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < filters.size();i++) {
      if (predicate.test(filters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
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
    GRPCBackendRefFluent that = (GRPCBackendRefFluent) o;
    if (!(Objects.equals(filters, that.filters))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(weight, that.weight))) {
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
  
  public String getGroup() {
    return this.group;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public Integer getPort() {
    return this.port;
  }
  
  public Integer getWeight() {
    return this.weight;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilters() {
    return this.filters != null && !(this.filters.isEmpty());
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingFilter(Predicate<GRPCRouteFilterBuilder> predicate) {
      for (GRPCRouteFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasWeight() {
    return this.weight != null;
  }
  
  public int hashCode() {
    return Objects.hash(filters, group, kind, name, namespace, port, weight, additionalProperties);
  }
  
  public A removeAllFromFilters(Collection<GRPCRouteFilter> items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
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
  
  public A removeFromFilters(GRPCRouteFilter... items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFilters(Predicate<GRPCRouteFilterBuilder> predicate) {
    if (filters == null) {
      return (A) this;
    }
    Iterator<GRPCRouteFilterBuilder> each = filters.iterator();
    List visitables = _visitables.get("filters");
    while (each.hasNext()) {
        GRPCRouteFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FiltersNested<A> setNewFilterLike(int index,GRPCRouteFilter item) {
    return new FiltersNested(index, item);
  }
  
  public A setToFilters(int index,GRPCRouteFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(filters == null) && !(filters.isEmpty())) {
        sb.append("filters:");
        sb.append(filters);
        sb.append(",");
    }
    if (!(group == null)) {
        sb.append("group:");
        sb.append(group);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(weight == null)) {
        sb.append("weight:");
        sb.append(weight);
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
  
  public A withFilters(List<GRPCRouteFilter> filters) {
    if (this.filters != null) {
      this._visitables.get("filters").clear();
    }
    if (filters != null) {
        this.filters = new ArrayList();
        for (GRPCRouteFilter item : filters) {
          this.addToFilters(item);
        }
    } else {
      this.filters = null;
    }
    return (A) this;
  }
  
  public A withFilters(GRPCRouteFilter... filters) {
    if (this.filters != null) {
        this.filters.clear();
        _visitables.remove("filters");
    }
    if (filters != null) {
      for (GRPCRouteFilter item : filters) {
        this.addToFilters(item);
      }
    }
    return (A) this;
  }
  
  public A withGroup(String group) {
    this.group = group;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withPort(Integer port) {
    this.port = port;
    return (A) this;
  }
  
  public A withWeight(Integer weight) {
    this.weight = weight;
    return (A) this;
  }
  public class FiltersNested<N> extends GRPCRouteFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    GRPCRouteFilterBuilder builder;
    int index;
  
    FiltersNested(int index,GRPCRouteFilter item) {
      this.index = index;
      this.builder = new GRPCRouteFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) GRPCBackendRefFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
}