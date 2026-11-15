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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ListenerFiltersFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ListenerFiltersFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ListenerFilterBuilder> requests = new ArrayList<ListenerFilterBuilder>();

  public ListenerFiltersFluent() {
  }
  
  public ListenerFiltersFluent(ListenerFilters instance) {
    this.copyInstance(instance);
  }

  public A addAllToRequests(Collection<ListenerFilter> items) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    for (ListenerFilter item : items) {
        ListenerFilterBuilder builder = new ListenerFilterBuilder(item);
        _visitables.get("requests").add(builder);
        this.requests.add(builder);
    }
    return (A) this;
  }
  
  public RequestsNested<A> addNewRequest() {
    return new RequestsNested(-1, null);
  }
  
  public RequestsNested<A> addNewRequestLike(ListenerFilter item) {
    return new RequestsNested(-1, item);
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
  
  public A addToRequests(ListenerFilter... items) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    for (ListenerFilter item : items) {
        ListenerFilterBuilder builder = new ListenerFilterBuilder(item);
        _visitables.get("requests").add(builder);
        this.requests.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequests(int index,ListenerFilter item) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    ListenerFilterBuilder builder = new ListenerFilterBuilder(item);
    if (index < 0 || index >= requests.size()) {
        _visitables.get("requests").add(builder);
        requests.add(builder);
    } else {
        _visitables.get("requests").add(builder);
        requests.add(index, builder);
    }
    return (A) this;
  }
  
  public ListenerFilter buildFirstRequest() {
    return this.requests.get(0).build();
  }
  
  public ListenerFilter buildLastRequest() {
    return this.requests.get(requests.size() - 1).build();
  }
  
  public ListenerFilter buildMatchingRequest(Predicate<ListenerFilterBuilder> predicate) {
      for (ListenerFilterBuilder item : requests) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ListenerFilter buildRequest(int index) {
    return this.requests.get(index).build();
  }
  
  public List<ListenerFilter> buildRequests() {
    return this.requests != null ? build(requests) : null;
  }
  
  protected void copyInstance(ListenerFilters instance) {
    instance = instance != null ? instance : new ListenerFilters();
    if (instance != null) {
        this.withRequests(instance.getRequests());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RequestsNested<A> editFirstRequest() {
    if (requests.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "requests"));
    }
    return this.setNewRequestLike(0, this.buildRequest(0));
  }
  
  public RequestsNested<A> editLastRequest() {
    int index = requests.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "requests"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
  }
  
  public RequestsNested<A> editMatchingRequest(Predicate<ListenerFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < requests.size();i++) {
      if (predicate.test(requests.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "requests"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
  }
  
  public RequestsNested<A> editRequest(int index) {
    if (requests.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "requests"));
    }
    return this.setNewRequestLike(index, this.buildRequest(index));
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
    ListenerFiltersFluent that = (ListenerFiltersFluent) o;
    if (!(Objects.equals(requests, that.requests))) {
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
  
  public boolean hasMatchingRequest(Predicate<ListenerFilterBuilder> predicate) {
      for (ListenerFilterBuilder item : requests) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequests() {
    return this.requests != null && !(this.requests.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(requests, additionalProperties);
  }
  
  public A removeAllFromRequests(Collection<ListenerFilter> items) {
    if (this.requests == null) {
      return (A) this;
    }
    for (ListenerFilter item : items) {
        ListenerFilterBuilder builder = new ListenerFilterBuilder(item);
        _visitables.get("requests").remove(builder);
        this.requests.remove(builder);
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
  
  public A removeFromRequests(ListenerFilter... items) {
    if (this.requests == null) {
      return (A) this;
    }
    for (ListenerFilter item : items) {
        ListenerFilterBuilder builder = new ListenerFilterBuilder(item);
        _visitables.get("requests").remove(builder);
        this.requests.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequests(Predicate<ListenerFilterBuilder> predicate) {
    if (requests == null) {
      return (A) this;
    }
    Iterator<ListenerFilterBuilder> each = requests.iterator();
    List visitables = _visitables.get("requests");
    while (each.hasNext()) {
        ListenerFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RequestsNested<A> setNewRequestLike(int index,ListenerFilter item) {
    return new RequestsNested(index, item);
  }
  
  public A setToRequests(int index,ListenerFilter item) {
    if (this.requests == null) {
      this.requests = new ArrayList();
    }
    ListenerFilterBuilder builder = new ListenerFilterBuilder(item);
    if (index < 0 || index >= requests.size()) {
        _visitables.get("requests").add(builder);
        requests.add(builder);
    } else {
        _visitables.get("requests").add(builder);
        requests.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(requests == null) && !(requests.isEmpty())) {
        sb.append("requests:");
        sb.append(requests);
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
  
  public A withRequests(List<ListenerFilter> requests) {
    if (this.requests != null) {
      this._visitables.get("requests").clear();
    }
    if (requests != null) {
        this.requests = new ArrayList();
        for (ListenerFilter item : requests) {
          this.addToRequests(item);
        }
    } else {
      this.requests = null;
    }
    return (A) this;
  }
  
  public A withRequests(ListenerFilter... requests) {
    if (this.requests != null) {
        this.requests.clear();
        _visitables.remove("requests");
    }
    if (requests != null) {
      for (ListenerFilter item : requests) {
        this.addToRequests(item);
      }
    }
    return (A) this;
  }
  public class RequestsNested<N> extends ListenerFilterFluent<RequestsNested<N>> implements Nested<N>{
  
    ListenerFilterBuilder builder;
    int index;
  
    RequestsNested(int index,ListenerFilter item) {
      this.index = index;
      this.builder = new ListenerFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) ListenerFiltersFluent.this.setToRequests(index, builder.build());
    }
    
    public N endRequest() {
      return and();
    }
    
  }
}