package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PerResourceAPIRequestLogFluent<A extends io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.PerResourceAPIRequestLogFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PerNodeAPIRequestLogBuilder> byNode = new ArrayList<PerNodeAPIRequestLogBuilder>();
  private Long requestCount;

  public PerResourceAPIRequestLogFluent() {
  }
  
  public PerResourceAPIRequestLogFluent(PerResourceAPIRequestLog instance) {
    this.copyInstance(instance);
  }

  public A addAllToByNode(Collection<PerNodeAPIRequestLog> items) {
    if (this.byNode == null) {
      this.byNode = new ArrayList();
    }
    for (PerNodeAPIRequestLog item : items) {
        PerNodeAPIRequestLogBuilder builder = new PerNodeAPIRequestLogBuilder(item);
        _visitables.get("byNode").add(builder);
        this.byNode.add(builder);
    }
    return (A) this;
  }
  
  public ByNodeNested<A> addNewByNode() {
    return new ByNodeNested(-1, null);
  }
  
  public ByNodeNested<A> addNewByNodeLike(PerNodeAPIRequestLog item) {
    return new ByNodeNested(-1, item);
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
  
  public A addToByNode(PerNodeAPIRequestLog... items) {
    if (this.byNode == null) {
      this.byNode = new ArrayList();
    }
    for (PerNodeAPIRequestLog item : items) {
        PerNodeAPIRequestLogBuilder builder = new PerNodeAPIRequestLogBuilder(item);
        _visitables.get("byNode").add(builder);
        this.byNode.add(builder);
    }
    return (A) this;
  }
  
  public A addToByNode(int index,PerNodeAPIRequestLog item) {
    if (this.byNode == null) {
      this.byNode = new ArrayList();
    }
    PerNodeAPIRequestLogBuilder builder = new PerNodeAPIRequestLogBuilder(item);
    if (index < 0 || index >= byNode.size()) {
        _visitables.get("byNode").add(builder);
        byNode.add(builder);
    } else {
        _visitables.get("byNode").add(builder);
        byNode.add(index, builder);
    }
    return (A) this;
  }
  
  public List<PerNodeAPIRequestLog> buildByNode() {
    return this.byNode != null ? build(byNode) : null;
  }
  
  public PerNodeAPIRequestLog buildByNode(int index) {
    return this.byNode.get(index).build();
  }
  
  public PerNodeAPIRequestLog buildFirstByNode() {
    return this.byNode.get(0).build();
  }
  
  public PerNodeAPIRequestLog buildLastByNode() {
    return this.byNode.get(byNode.size() - 1).build();
  }
  
  public PerNodeAPIRequestLog buildMatchingByNode(Predicate<PerNodeAPIRequestLogBuilder> predicate) {
      for (PerNodeAPIRequestLogBuilder item : byNode) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PerResourceAPIRequestLog instance) {
    instance = instance != null ? instance : new PerResourceAPIRequestLog();
    if (instance != null) {
        this.withByNode(instance.getByNode());
        this.withRequestCount(instance.getRequestCount());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ByNodeNested<A> editByNode(int index) {
    if (byNode.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "byNode"));
    }
    return this.setNewByNodeLike(index, this.buildByNode(index));
  }
  
  public ByNodeNested<A> editFirstByNode() {
    if (byNode.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "byNode"));
    }
    return this.setNewByNodeLike(0, this.buildByNode(0));
  }
  
  public ByNodeNested<A> editLastByNode() {
    int index = byNode.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "byNode"));
    }
    return this.setNewByNodeLike(index, this.buildByNode(index));
  }
  
  public ByNodeNested<A> editMatchingByNode(Predicate<PerNodeAPIRequestLogBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < byNode.size();i++) {
      if (predicate.test(byNode.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "byNode"));
    }
    return this.setNewByNodeLike(index, this.buildByNode(index));
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
    PerResourceAPIRequestLogFluent that = (PerResourceAPIRequestLogFluent) o;
    if (!(Objects.equals(byNode, that.byNode))) {
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
  
  public Long getRequestCount() {
    return this.requestCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasByNode() {
    return this.byNode != null && !(this.byNode.isEmpty());
  }
  
  public boolean hasMatchingByNode(Predicate<PerNodeAPIRequestLogBuilder> predicate) {
      for (PerNodeAPIRequestLogBuilder item : byNode) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequestCount() {
    return this.requestCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(byNode, requestCount, additionalProperties);
  }
  
  public A removeAllFromByNode(Collection<PerNodeAPIRequestLog> items) {
    if (this.byNode == null) {
      return (A) this;
    }
    for (PerNodeAPIRequestLog item : items) {
        PerNodeAPIRequestLogBuilder builder = new PerNodeAPIRequestLogBuilder(item);
        _visitables.get("byNode").remove(builder);
        this.byNode.remove(builder);
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
  
  public A removeFromByNode(PerNodeAPIRequestLog... items) {
    if (this.byNode == null) {
      return (A) this;
    }
    for (PerNodeAPIRequestLog item : items) {
        PerNodeAPIRequestLogBuilder builder = new PerNodeAPIRequestLogBuilder(item);
        _visitables.get("byNode").remove(builder);
        this.byNode.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromByNode(Predicate<PerNodeAPIRequestLogBuilder> predicate) {
    if (byNode == null) {
      return (A) this;
    }
    Iterator<PerNodeAPIRequestLogBuilder> each = byNode.iterator();
    List visitables = _visitables.get("byNode");
    while (each.hasNext()) {
        PerNodeAPIRequestLogBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ByNodeNested<A> setNewByNodeLike(int index,PerNodeAPIRequestLog item) {
    return new ByNodeNested(index, item);
  }
  
  public A setToByNode(int index,PerNodeAPIRequestLog item) {
    if (this.byNode == null) {
      this.byNode = new ArrayList();
    }
    PerNodeAPIRequestLogBuilder builder = new PerNodeAPIRequestLogBuilder(item);
    if (index < 0 || index >= byNode.size()) {
        _visitables.get("byNode").add(builder);
        byNode.add(builder);
    } else {
        _visitables.get("byNode").add(builder);
        byNode.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(byNode == null) && !(byNode.isEmpty())) {
        sb.append("byNode:");
        sb.append(byNode);
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
  
  public A withByNode(List<PerNodeAPIRequestLog> byNode) {
    if (this.byNode != null) {
      this._visitables.get("byNode").clear();
    }
    if (byNode != null) {
        this.byNode = new ArrayList();
        for (PerNodeAPIRequestLog item : byNode) {
          this.addToByNode(item);
        }
    } else {
      this.byNode = null;
    }
    return (A) this;
  }
  
  public A withByNode(PerNodeAPIRequestLog... byNode) {
    if (this.byNode != null) {
        this.byNode.clear();
        _visitables.remove("byNode");
    }
    if (byNode != null) {
      for (PerNodeAPIRequestLog item : byNode) {
        this.addToByNode(item);
      }
    }
    return (A) this;
  }
  
  public A withRequestCount(Long requestCount) {
    this.requestCount = requestCount;
    return (A) this;
  }
  public class ByNodeNested<N> extends PerNodeAPIRequestLogFluent<ByNodeNested<N>> implements Nested<N>{
  
    PerNodeAPIRequestLogBuilder builder;
    int index;
  
    ByNodeNested(int index,PerNodeAPIRequestLog item) {
      this.index = index;
      this.builder = new PerNodeAPIRequestLogBuilder(this, item);
    }
  
    public N and() {
      return (N) PerResourceAPIRequestLogFluent.this.setToByNode(index, builder.build());
    }
    
    public N endByNode() {
      return and();
    }
    
  }
}