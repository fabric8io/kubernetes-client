package io.fabric8.openshift.api.model.tuned.v1;

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
public class TunedMatchFluent<A extends io.fabric8.openshift.api.model.tuned.v1.TunedMatchFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String label;
  private ArrayList<TunedMatchBuilder> match = new ArrayList<TunedMatchBuilder>();
  private String type;
  private String value;

  public TunedMatchFluent() {
  }
  
  public TunedMatchFluent(TunedMatch instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatch(Collection<TunedMatch> items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public MatchNested<A> addNewMatch() {
    return new MatchNested(-1, null);
  }
  
  public MatchNested<A> addNewMatchLike(TunedMatch item) {
    return new MatchNested(-1, item);
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
  
  public A addToMatch(TunedMatch... items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatch(int index,TunedMatch item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    TunedMatchBuilder builder = new TunedMatchBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.add(index, builder);
    }
    return (A) this;
  }
  
  public TunedMatch buildFirstMatch() {
    return this.match.get(0).build();
  }
  
  public TunedMatch buildLastMatch() {
    return this.match.get(match.size() - 1).build();
  }
  
  public List<TunedMatch> buildMatch() {
    return this.match != null ? build(match) : null;
  }
  
  public TunedMatch buildMatch(int index) {
    return this.match.get(index).build();
  }
  
  public TunedMatch buildMatchingMatch(Predicate<TunedMatchBuilder> predicate) {
      for (TunedMatchBuilder item : match) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(TunedMatch instance) {
    instance = instance != null ? instance : new TunedMatch();
    if (instance != null) {
        this.withLabel(instance.getLabel());
        this.withMatch(instance.getMatch());
        this.withType(instance.getType());
        this.withValue(instance.getValue());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchNested<A> editFirstMatch() {
    if (match.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(0, this.buildMatch(0));
  }
  
  public MatchNested<A> editLastMatch() {
    int index = match.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatch(int index) {
    if (match.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatchingMatch(Predicate<TunedMatchBuilder> predicate) {
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
    TunedMatchFluent that = (TunedMatchFluent) o;
    if (!(Objects.equals(label, that.label))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(value, that.value))) {
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
  
  public String getLabel() {
    return this.label;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getValue() {
    return this.value;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasLabel() {
    return this.label != null;
  }
  
  public boolean hasMatch() {
    return this.match != null && !(this.match.isEmpty());
  }
  
  public boolean hasMatchingMatch(Predicate<TunedMatchBuilder> predicate) {
      for (TunedMatchBuilder item : match) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasValue() {
    return this.value != null;
  }
  
  public int hashCode() {
    return Objects.hash(label, match, type, value, additionalProperties);
  }
  
  public A removeAllFromMatch(Collection<TunedMatch> items) {
    if (this.match == null) {
      return (A) this;
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
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
  
  public A removeFromMatch(TunedMatch... items) {
    if (this.match == null) {
      return (A) this;
    }
    for (TunedMatch item : items) {
        TunedMatchBuilder builder = new TunedMatchBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatch(Predicate<TunedMatchBuilder> predicate) {
    if (match == null) {
      return (A) this;
    }
    Iterator<TunedMatchBuilder> each = match.iterator();
    List visitables = _visitables.get("match");
    while (each.hasNext()) {
        TunedMatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchNested<A> setNewMatchLike(int index,TunedMatch item) {
    return new MatchNested(index, item);
  }
  
  public A setToMatch(int index,TunedMatch item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    TunedMatchBuilder builder = new TunedMatchBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(label == null)) {
        sb.append("label:");
        sb.append(label);
        sb.append(",");
    }
    if (!(match == null) && !(match.isEmpty())) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(value == null)) {
        sb.append("value:");
        sb.append(value);
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
  
  public A withLabel(String label) {
    this.label = label;
    return (A) this;
  }
  
  public A withMatch(List<TunedMatch> match) {
    if (this.match != null) {
      this._visitables.get("match").clear();
    }
    if (match != null) {
        this.match = new ArrayList();
        for (TunedMatch item : match) {
          this.addToMatch(item);
        }
    } else {
      this.match = null;
    }
    return (A) this;
  }
  
  public A withMatch(TunedMatch... match) {
    if (this.match != null) {
        this.match.clear();
        _visitables.remove("match");
    }
    if (match != null) {
      for (TunedMatch item : match) {
        this.addToMatch(item);
      }
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  
  public A withValue(String value) {
    this.value = value;
    return (A) this;
  }
  public class MatchNested<N> extends TunedMatchFluent<MatchNested<N>> implements Nested<N>{
  
    TunedMatchBuilder builder;
    int index;
  
    MatchNested(int index,TunedMatch item) {
      this.index = index;
      this.builder = new TunedMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) TunedMatchFluent.this.setToMatch(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
}