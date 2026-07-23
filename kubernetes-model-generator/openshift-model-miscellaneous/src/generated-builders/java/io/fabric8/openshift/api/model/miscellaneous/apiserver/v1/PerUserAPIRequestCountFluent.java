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
public class PerUserAPIRequestCountFluent<A extends io.fabric8.openshift.api.model.miscellaneous.apiserver.v1.PerUserAPIRequestCountFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PerVerbAPIRequestCountBuilder> byVerb = new ArrayList<PerVerbAPIRequestCountBuilder>();
  private Long requestCount;
  private String userAgent;
  private String username;

  public PerUserAPIRequestCountFluent() {
  }
  
  public PerUserAPIRequestCountFluent(PerUserAPIRequestCount instance) {
    this.copyInstance(instance);
  }

  public A addAllToByVerb(Collection<PerVerbAPIRequestCount> items) {
    if (this.byVerb == null) {
      this.byVerb = new ArrayList();
    }
    for (PerVerbAPIRequestCount item : items) {
        PerVerbAPIRequestCountBuilder builder = new PerVerbAPIRequestCountBuilder(item);
        _visitables.get("byVerb").add(builder);
        this.byVerb.add(builder);
    }
    return (A) this;
  }
  
  public ByVerbNested<A> addNewByVerb() {
    return new ByVerbNested(-1, null);
  }
  
  public A addNewByVerb(Long requestCount,String verb) {
    return (A) this.addToByVerb(new PerVerbAPIRequestCount(requestCount, verb));
  }
  
  public ByVerbNested<A> addNewByVerbLike(PerVerbAPIRequestCount item) {
    return new ByVerbNested(-1, item);
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
  
  public A addToByVerb(PerVerbAPIRequestCount... items) {
    if (this.byVerb == null) {
      this.byVerb = new ArrayList();
    }
    for (PerVerbAPIRequestCount item : items) {
        PerVerbAPIRequestCountBuilder builder = new PerVerbAPIRequestCountBuilder(item);
        _visitables.get("byVerb").add(builder);
        this.byVerb.add(builder);
    }
    return (A) this;
  }
  
  public A addToByVerb(int index,PerVerbAPIRequestCount item) {
    if (this.byVerb == null) {
      this.byVerb = new ArrayList();
    }
    PerVerbAPIRequestCountBuilder builder = new PerVerbAPIRequestCountBuilder(item);
    if (index < 0 || index >= byVerb.size()) {
        _visitables.get("byVerb").add(builder);
        byVerb.add(builder);
    } else {
        _visitables.get("byVerb").add(builder);
        byVerb.add(index, builder);
    }
    return (A) this;
  }
  
  public List<PerVerbAPIRequestCount> buildByVerb() {
    return this.byVerb != null ? build(byVerb) : null;
  }
  
  public PerVerbAPIRequestCount buildByVerb(int index) {
    return this.byVerb.get(index).build();
  }
  
  public PerVerbAPIRequestCount buildFirstByVerb() {
    return this.byVerb.get(0).build();
  }
  
  public PerVerbAPIRequestCount buildLastByVerb() {
    return this.byVerb.get(byVerb.size() - 1).build();
  }
  
  public PerVerbAPIRequestCount buildMatchingByVerb(Predicate<PerVerbAPIRequestCountBuilder> predicate) {
      for (PerVerbAPIRequestCountBuilder item : byVerb) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PerUserAPIRequestCount instance) {
    instance = instance != null ? instance : new PerUserAPIRequestCount();
    if (instance != null) {
        this.withByVerb(instance.getByVerb());
        this.withRequestCount(instance.getRequestCount());
        this.withUserAgent(instance.getUserAgent());
        this.withUsername(instance.getUsername());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ByVerbNested<A> editByVerb(int index) {
    if (byVerb.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "byVerb"));
    }
    return this.setNewByVerbLike(index, this.buildByVerb(index));
  }
  
  public ByVerbNested<A> editFirstByVerb() {
    if (byVerb.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "byVerb"));
    }
    return this.setNewByVerbLike(0, this.buildByVerb(0));
  }
  
  public ByVerbNested<A> editLastByVerb() {
    int index = byVerb.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "byVerb"));
    }
    return this.setNewByVerbLike(index, this.buildByVerb(index));
  }
  
  public ByVerbNested<A> editMatchingByVerb(Predicate<PerVerbAPIRequestCountBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < byVerb.size();i++) {
      if (predicate.test(byVerb.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "byVerb"));
    }
    return this.setNewByVerbLike(index, this.buildByVerb(index));
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
    PerUserAPIRequestCountFluent that = (PerUserAPIRequestCountFluent) o;
    if (!(Objects.equals(byVerb, that.byVerb))) {
      return false;
    }
    if (!(Objects.equals(requestCount, that.requestCount))) {
      return false;
    }
    if (!(Objects.equals(userAgent, that.userAgent))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public String getUserAgent() {
    return this.userAgent;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasByVerb() {
    return this.byVerb != null && !(this.byVerb.isEmpty());
  }
  
  public boolean hasMatchingByVerb(Predicate<PerVerbAPIRequestCountBuilder> predicate) {
      for (PerVerbAPIRequestCountBuilder item : byVerb) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRequestCount() {
    return this.requestCount != null;
  }
  
  public boolean hasUserAgent() {
    return this.userAgent != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(byVerb, requestCount, userAgent, username, additionalProperties);
  }
  
  public A removeAllFromByVerb(Collection<PerVerbAPIRequestCount> items) {
    if (this.byVerb == null) {
      return (A) this;
    }
    for (PerVerbAPIRequestCount item : items) {
        PerVerbAPIRequestCountBuilder builder = new PerVerbAPIRequestCountBuilder(item);
        _visitables.get("byVerb").remove(builder);
        this.byVerb.remove(builder);
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
  
  public A removeFromByVerb(PerVerbAPIRequestCount... items) {
    if (this.byVerb == null) {
      return (A) this;
    }
    for (PerVerbAPIRequestCount item : items) {
        PerVerbAPIRequestCountBuilder builder = new PerVerbAPIRequestCountBuilder(item);
        _visitables.get("byVerb").remove(builder);
        this.byVerb.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromByVerb(Predicate<PerVerbAPIRequestCountBuilder> predicate) {
    if (byVerb == null) {
      return (A) this;
    }
    Iterator<PerVerbAPIRequestCountBuilder> each = byVerb.iterator();
    List visitables = _visitables.get("byVerb");
    while (each.hasNext()) {
        PerVerbAPIRequestCountBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ByVerbNested<A> setNewByVerbLike(int index,PerVerbAPIRequestCount item) {
    return new ByVerbNested(index, item);
  }
  
  public A setToByVerb(int index,PerVerbAPIRequestCount item) {
    if (this.byVerb == null) {
      this.byVerb = new ArrayList();
    }
    PerVerbAPIRequestCountBuilder builder = new PerVerbAPIRequestCountBuilder(item);
    if (index < 0 || index >= byVerb.size()) {
        _visitables.get("byVerb").add(builder);
        byVerb.add(builder);
    } else {
        _visitables.get("byVerb").add(builder);
        byVerb.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(byVerb == null) && !(byVerb.isEmpty())) {
        sb.append("byVerb:");
        sb.append(byVerb);
        sb.append(",");
    }
    if (!(requestCount == null)) {
        sb.append("requestCount:");
        sb.append(requestCount);
        sb.append(",");
    }
    if (!(userAgent == null)) {
        sb.append("userAgent:");
        sb.append(userAgent);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
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
  
  public A withByVerb(List<PerVerbAPIRequestCount> byVerb) {
    if (this.byVerb != null) {
      this._visitables.get("byVerb").clear();
    }
    if (byVerb != null) {
        this.byVerb = new ArrayList();
        for (PerVerbAPIRequestCount item : byVerb) {
          this.addToByVerb(item);
        }
    } else {
      this.byVerb = null;
    }
    return (A) this;
  }
  
  public A withByVerb(PerVerbAPIRequestCount... byVerb) {
    if (this.byVerb != null) {
        this.byVerb.clear();
        _visitables.remove("byVerb");
    }
    if (byVerb != null) {
      for (PerVerbAPIRequestCount item : byVerb) {
        this.addToByVerb(item);
      }
    }
    return (A) this;
  }
  
  public A withRequestCount(Long requestCount) {
    this.requestCount = requestCount;
    return (A) this;
  }
  
  public A withUserAgent(String userAgent) {
    this.userAgent = userAgent;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  public class ByVerbNested<N> extends PerVerbAPIRequestCountFluent<ByVerbNested<N>> implements Nested<N>{
  
    PerVerbAPIRequestCountBuilder builder;
    int index;
  
    ByVerbNested(int index,PerVerbAPIRequestCount item) {
      this.index = index;
      this.builder = new PerVerbAPIRequestCountBuilder(this, item);
    }
  
    public N and() {
      return (N) PerUserAPIRequestCountFluent.this.setToByVerb(index, builder.build());
    }
    
    public N endByVerb() {
      return and();
    }
    
  }
}