package io.fabric8.openshift.api.model.machine.v1;

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
public class AWSResourceReferenceFluent<A extends io.fabric8.openshift.api.model.machine.v1.AWSResourceReferenceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String arn;
  private ArrayList<AWSResourceFilterBuilder> filters = new ArrayList<AWSResourceFilterBuilder>();
  private String id;
  private String type;

  public AWSResourceReferenceFluent() {
  }
  
  public AWSResourceReferenceFluent(AWSResourceReference instance) {
    this.copyInstance(instance);
  }

  public A addAllToFilters(Collection<AWSResourceFilter> items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (AWSResourceFilter item : items) {
        AWSResourceFilterBuilder builder = new AWSResourceFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(AWSResourceFilter item) {
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
  
  public A addToFilters(AWSResourceFilter... items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (AWSResourceFilter item : items) {
        AWSResourceFilterBuilder builder = new AWSResourceFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addToFilters(int index,AWSResourceFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    AWSResourceFilterBuilder builder = new AWSResourceFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.add(index, builder);
    }
    return (A) this;
  }
  
  public AWSResourceFilter buildFilter(int index) {
    return this.filters.get(index).build();
  }
  
  public List<AWSResourceFilter> buildFilters() {
    return this.filters != null ? build(filters) : null;
  }
  
  public AWSResourceFilter buildFirstFilter() {
    return this.filters.get(0).build();
  }
  
  public AWSResourceFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public AWSResourceFilter buildMatchingFilter(Predicate<AWSResourceFilterBuilder> predicate) {
      for (AWSResourceFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AWSResourceReference instance) {
    instance = instance != null ? instance : new AWSResourceReference();
    if (instance != null) {
        this.withArn(instance.getArn());
        this.withFilters(instance.getFilters());
        this.withId(instance.getId());
        this.withType(instance.getType());
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
  
  public FiltersNested<A> editMatchingFilter(Predicate<AWSResourceFilterBuilder> predicate) {
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
    AWSResourceReferenceFluent that = (AWSResourceReferenceFluent) o;
    if (!(Objects.equals(arn, that.arn))) {
      return false;
    }
    if (!(Objects.equals(filters, that.filters))) {
      return false;
    }
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getArn() {
    return this.arn;
  }
  
  public String getId() {
    return this.id;
  }
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasArn() {
    return this.arn != null;
  }
  
  public boolean hasFilters() {
    return this.filters != null && !(this.filters.isEmpty());
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasMatchingFilter(Predicate<AWSResourceFilterBuilder> predicate) {
      for (AWSResourceFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(arn, filters, id, type, additionalProperties);
  }
  
  public A removeAllFromFilters(Collection<AWSResourceFilter> items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (AWSResourceFilter item : items) {
        AWSResourceFilterBuilder builder = new AWSResourceFilterBuilder(item);
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
  
  public A removeFromFilters(AWSResourceFilter... items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (AWSResourceFilter item : items) {
        AWSResourceFilterBuilder builder = new AWSResourceFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFilters(Predicate<AWSResourceFilterBuilder> predicate) {
    if (filters == null) {
      return (A) this;
    }
    Iterator<AWSResourceFilterBuilder> each = filters.iterator();
    List visitables = _visitables.get("filters");
    while (each.hasNext()) {
        AWSResourceFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FiltersNested<A> setNewFilterLike(int index,AWSResourceFilter item) {
    return new FiltersNested(index, item);
  }
  
  public A setToFilters(int index,AWSResourceFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    AWSResourceFilterBuilder builder = new AWSResourceFilterBuilder(item);
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
    if (!(arn == null)) {
        sb.append("arn:");
        sb.append(arn);
        sb.append(",");
    }
    if (!(filters == null) && !(filters.isEmpty())) {
        sb.append("filters:");
        sb.append(filters);
        sb.append(",");
    }
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withArn(String arn) {
    this.arn = arn;
    return (A) this;
  }
  
  public A withFilters(List<AWSResourceFilter> filters) {
    if (this.filters != null) {
      this._visitables.get("filters").clear();
    }
    if (filters != null) {
        this.filters = new ArrayList();
        for (AWSResourceFilter item : filters) {
          this.addToFilters(item);
        }
    } else {
      this.filters = null;
    }
    return (A) this;
  }
  
  public A withFilters(AWSResourceFilter... filters) {
    if (this.filters != null) {
        this.filters.clear();
        _visitables.remove("filters");
    }
    if (filters != null) {
      for (AWSResourceFilter item : filters) {
        this.addToFilters(item);
      }
    }
    return (A) this;
  }
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class FiltersNested<N> extends AWSResourceFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    AWSResourceFilterBuilder builder;
    int index;
  
    FiltersNested(int index,AWSResourceFilter item) {
      this.index = index;
      this.builder = new AWSResourceFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSResourceReferenceFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
}