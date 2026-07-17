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
public class PerNodeAPIRequestLogFluent<A extends io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.PerNodeAPIRequestLogFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PerUserAPIRequestCountBuilder> byUser = new ArrayList<PerUserAPIRequestCountBuilder>();
  private String nodeName;
  private Long requestCount;

  public PerNodeAPIRequestLogFluent() {
  }
  
  public PerNodeAPIRequestLogFluent(PerNodeAPIRequestLog instance) {
    this.copyInstance(instance);
  }

  public A addAllToByUser(Collection<PerUserAPIRequestCount> items) {
    if (this.byUser == null) {
      this.byUser = new ArrayList();
    }
    for (PerUserAPIRequestCount item : items) {
        PerUserAPIRequestCountBuilder builder = new PerUserAPIRequestCountBuilder(item);
        _visitables.get("byUser").add(builder);
        this.byUser.add(builder);
    }
    return (A) this;
  }
  
  public ByUserNested<A> addNewByUser() {
    return new ByUserNested(-1, null);
  }
  
  public ByUserNested<A> addNewByUserLike(PerUserAPIRequestCount item) {
    return new ByUserNested(-1, item);
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
  
  public A addToByUser(PerUserAPIRequestCount... items) {
    if (this.byUser == null) {
      this.byUser = new ArrayList();
    }
    for (PerUserAPIRequestCount item : items) {
        PerUserAPIRequestCountBuilder builder = new PerUserAPIRequestCountBuilder(item);
        _visitables.get("byUser").add(builder);
        this.byUser.add(builder);
    }
    return (A) this;
  }
  
  public A addToByUser(int index,PerUserAPIRequestCount item) {
    if (this.byUser == null) {
      this.byUser = new ArrayList();
    }
    PerUserAPIRequestCountBuilder builder = new PerUserAPIRequestCountBuilder(item);
    if (index < 0 || index >= byUser.size()) {
        _visitables.get("byUser").add(builder);
        byUser.add(builder);
    } else {
        _visitables.get("byUser").add(builder);
        byUser.add(index, builder);
    }
    return (A) this;
  }
  
  public List<PerUserAPIRequestCount> buildByUser() {
    return this.byUser != null ? build(byUser) : null;
  }
  
  public PerUserAPIRequestCount buildByUser(int index) {
    return this.byUser.get(index).build();
  }
  
  public PerUserAPIRequestCount buildFirstByUser() {
    return this.byUser.get(0).build();
  }
  
  public PerUserAPIRequestCount buildLastByUser() {
    return this.byUser.get(byUser.size() - 1).build();
  }
  
  public PerUserAPIRequestCount buildMatchingByUser(Predicate<PerUserAPIRequestCountBuilder> predicate) {
      for (PerUserAPIRequestCountBuilder item : byUser) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PerNodeAPIRequestLog instance) {
    instance = instance != null ? instance : new PerNodeAPIRequestLog();
    if (instance != null) {
        this.withByUser(instance.getByUser());
        this.withNodeName(instance.getNodeName());
        this.withRequestCount(instance.getRequestCount());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ByUserNested<A> editByUser(int index) {
    if (byUser.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "byUser"));
    }
    return this.setNewByUserLike(index, this.buildByUser(index));
  }
  
  public ByUserNested<A> editFirstByUser() {
    if (byUser.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "byUser"));
    }
    return this.setNewByUserLike(0, this.buildByUser(0));
  }
  
  public ByUserNested<A> editLastByUser() {
    int index = byUser.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "byUser"));
    }
    return this.setNewByUserLike(index, this.buildByUser(index));
  }
  
  public ByUserNested<A> editMatchingByUser(Predicate<PerUserAPIRequestCountBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < byUser.size();i++) {
      if (predicate.test(byUser.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "byUser"));
    }
    return this.setNewByUserLike(index, this.buildByUser(index));
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
    PerNodeAPIRequestLogFluent that = (PerNodeAPIRequestLogFluent) o;
    if (!(Objects.equals(byUser, that.byUser))) {
      return false;
    }
    if (!(Objects.equals(nodeName, that.nodeName))) {
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
  
  public String getNodeName() {
    return this.nodeName;
  }
  
  public Long getRequestCount() {
    return this.requestCount;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasByUser() {
    return this.byUser != null && !(this.byUser.isEmpty());
  }
  
  public boolean hasMatchingByUser(Predicate<PerUserAPIRequestCountBuilder> predicate) {
      for (PerUserAPIRequestCountBuilder item : byUser) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodeName() {
    return this.nodeName != null;
  }
  
  public boolean hasRequestCount() {
    return this.requestCount != null;
  }
  
  public int hashCode() {
    return Objects.hash(byUser, nodeName, requestCount, additionalProperties);
  }
  
  public A removeAllFromByUser(Collection<PerUserAPIRequestCount> items) {
    if (this.byUser == null) {
      return (A) this;
    }
    for (PerUserAPIRequestCount item : items) {
        PerUserAPIRequestCountBuilder builder = new PerUserAPIRequestCountBuilder(item);
        _visitables.get("byUser").remove(builder);
        this.byUser.remove(builder);
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
  
  public A removeFromByUser(PerUserAPIRequestCount... items) {
    if (this.byUser == null) {
      return (A) this;
    }
    for (PerUserAPIRequestCount item : items) {
        PerUserAPIRequestCountBuilder builder = new PerUserAPIRequestCountBuilder(item);
        _visitables.get("byUser").remove(builder);
        this.byUser.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromByUser(Predicate<PerUserAPIRequestCountBuilder> predicate) {
    if (byUser == null) {
      return (A) this;
    }
    Iterator<PerUserAPIRequestCountBuilder> each = byUser.iterator();
    List visitables = _visitables.get("byUser");
    while (each.hasNext()) {
        PerUserAPIRequestCountBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ByUserNested<A> setNewByUserLike(int index,PerUserAPIRequestCount item) {
    return new ByUserNested(index, item);
  }
  
  public A setToByUser(int index,PerUserAPIRequestCount item) {
    if (this.byUser == null) {
      this.byUser = new ArrayList();
    }
    PerUserAPIRequestCountBuilder builder = new PerUserAPIRequestCountBuilder(item);
    if (index < 0 || index >= byUser.size()) {
        _visitables.get("byUser").add(builder);
        byUser.add(builder);
    } else {
        _visitables.get("byUser").add(builder);
        byUser.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(byUser == null) && !(byUser.isEmpty())) {
        sb.append("byUser:");
        sb.append(byUser);
        sb.append(",");
    }
    if (!(nodeName == null)) {
        sb.append("nodeName:");
        sb.append(nodeName);
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
  
  public A withByUser(List<PerUserAPIRequestCount> byUser) {
    if (this.byUser != null) {
      this._visitables.get("byUser").clear();
    }
    if (byUser != null) {
        this.byUser = new ArrayList();
        for (PerUserAPIRequestCount item : byUser) {
          this.addToByUser(item);
        }
    } else {
      this.byUser = null;
    }
    return (A) this;
  }
  
  public A withByUser(PerUserAPIRequestCount... byUser) {
    if (this.byUser != null) {
        this.byUser.clear();
        _visitables.remove("byUser");
    }
    if (byUser != null) {
      for (PerUserAPIRequestCount item : byUser) {
        this.addToByUser(item);
      }
    }
    return (A) this;
  }
  
  public A withNodeName(String nodeName) {
    this.nodeName = nodeName;
    return (A) this;
  }
  
  public A withRequestCount(Long requestCount) {
    this.requestCount = requestCount;
    return (A) this;
  }
  public class ByUserNested<N> extends PerUserAPIRequestCountFluent<ByUserNested<N>> implements Nested<N>{
  
    PerUserAPIRequestCountBuilder builder;
    int index;
  
    ByUserNested(int index,PerUserAPIRequestCount item) {
      this.index = index;
      this.builder = new PerUserAPIRequestCountBuilder(this, item);
    }
  
    public N and() {
      return (N) PerNodeAPIRequestLogFluent.this.setToByUser(index, builder.build());
    }
    
    public N endByUser() {
      return and();
    }
    
  }
}