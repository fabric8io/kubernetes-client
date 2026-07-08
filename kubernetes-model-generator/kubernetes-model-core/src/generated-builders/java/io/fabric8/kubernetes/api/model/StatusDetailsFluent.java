package io.fabric8.kubernetes.api.model;

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
public class StatusDetailsFluent<A extends io.fabric8.kubernetes.api.model.StatusDetailsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<StatusCauseBuilder> causes = new ArrayList<StatusCauseBuilder>();
  private String group;
  private String kind;
  private String name;
  private Integer retryAfterSeconds;
  private String uid;

  public StatusDetailsFluent() {
  }
  
  public StatusDetailsFluent(StatusDetails instance) {
    this.copyInstance(instance);
  }

  public A addAllToCauses(Collection<StatusCause> items) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    for (StatusCause item : items) {
        StatusCauseBuilder builder = new StatusCauseBuilder(item);
        _visitables.get("causes").add(builder);
        this.causes.add(builder);
    }
    return (A) this;
  }
  
  public CausesNested<A> addNewCause() {
    return new CausesNested(-1, null);
  }
  
  public A addNewCause(String field,String message,String reason) {
    return (A) this.addToCauses(new StatusCause(field, message, reason));
  }
  
  public CausesNested<A> addNewCauseLike(StatusCause item) {
    return new CausesNested(-1, item);
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
  
  public A addToCauses(StatusCause... items) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    for (StatusCause item : items) {
        StatusCauseBuilder builder = new StatusCauseBuilder(item);
        _visitables.get("causes").add(builder);
        this.causes.add(builder);
    }
    return (A) this;
  }
  
  public A addToCauses(int index,StatusCause item) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    StatusCauseBuilder builder = new StatusCauseBuilder(item);
    if (index < 0 || index >= causes.size()) {
        _visitables.get("causes").add(builder);
        causes.add(builder);
    } else {
        _visitables.get("causes").add(builder);
        causes.add(index, builder);
    }
    return (A) this;
  }
  
  public StatusCause buildCause(int index) {
    return this.causes.get(index).build();
  }
  
  public List<StatusCause> buildCauses() {
    return this.causes != null ? build(causes) : null;
  }
  
  public StatusCause buildFirstCause() {
    return this.causes.get(0).build();
  }
  
  public StatusCause buildLastCause() {
    return this.causes.get(causes.size() - 1).build();
  }
  
  public StatusCause buildMatchingCause(Predicate<StatusCauseBuilder> predicate) {
      for (StatusCauseBuilder item : causes) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(StatusDetails instance) {
    instance = instance != null ? instance : new StatusDetails();
    if (instance != null) {
        this.withCauses(instance.getCauses());
        this.withGroup(instance.getGroup());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withRetryAfterSeconds(instance.getRetryAfterSeconds());
        this.withUid(instance.getUid());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CausesNested<A> editCause(int index) {
    if (causes.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "causes"));
    }
    return this.setNewCauseLike(index, this.buildCause(index));
  }
  
  public CausesNested<A> editFirstCause() {
    if (causes.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "causes"));
    }
    return this.setNewCauseLike(0, this.buildCause(0));
  }
  
  public CausesNested<A> editLastCause() {
    int index = causes.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "causes"));
    }
    return this.setNewCauseLike(index, this.buildCause(index));
  }
  
  public CausesNested<A> editMatchingCause(Predicate<StatusCauseBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < causes.size();i++) {
      if (predicate.test(causes.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "causes"));
    }
    return this.setNewCauseLike(index, this.buildCause(index));
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
    StatusDetailsFluent that = (StatusDetailsFluent) o;
    if (!(Objects.equals(causes, that.causes))) {
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
    if (!(Objects.equals(retryAfterSeconds, that.retryAfterSeconds))) {
      return false;
    }
    if (!(Objects.equals(uid, that.uid))) {
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
  
  public Integer getRetryAfterSeconds() {
    return this.retryAfterSeconds;
  }
  
  public String getUid() {
    return this.uid;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCauses() {
    return this.causes != null && !(this.causes.isEmpty());
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingCause(Predicate<StatusCauseBuilder> predicate) {
      for (StatusCauseBuilder item : causes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRetryAfterSeconds() {
    return this.retryAfterSeconds != null;
  }
  
  public boolean hasUid() {
    return this.uid != null;
  }
  
  public int hashCode() {
    return Objects.hash(causes, group, kind, name, retryAfterSeconds, uid, additionalProperties);
  }
  
  public A removeAllFromCauses(Collection<StatusCause> items) {
    if (this.causes == null) {
      return (A) this;
    }
    for (StatusCause item : items) {
        StatusCauseBuilder builder = new StatusCauseBuilder(item);
        _visitables.get("causes").remove(builder);
        this.causes.remove(builder);
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
  
  public A removeFromCauses(StatusCause... items) {
    if (this.causes == null) {
      return (A) this;
    }
    for (StatusCause item : items) {
        StatusCauseBuilder builder = new StatusCauseBuilder(item);
        _visitables.get("causes").remove(builder);
        this.causes.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCauses(Predicate<StatusCauseBuilder> predicate) {
    if (causes == null) {
      return (A) this;
    }
    Iterator<StatusCauseBuilder> each = causes.iterator();
    List visitables = _visitables.get("causes");
    while (each.hasNext()) {
        StatusCauseBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CausesNested<A> setNewCauseLike(int index,StatusCause item) {
    return new CausesNested(index, item);
  }
  
  public A setToCauses(int index,StatusCause item) {
    if (this.causes == null) {
      this.causes = new ArrayList();
    }
    StatusCauseBuilder builder = new StatusCauseBuilder(item);
    if (index < 0 || index >= causes.size()) {
        _visitables.get("causes").add(builder);
        causes.add(builder);
    } else {
        _visitables.get("causes").add(builder);
        causes.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(causes == null) && !(causes.isEmpty())) {
        sb.append("causes:");
        sb.append(causes);
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
    if (!(retryAfterSeconds == null)) {
        sb.append("retryAfterSeconds:");
        sb.append(retryAfterSeconds);
        sb.append(",");
    }
    if (!(uid == null)) {
        sb.append("uid:");
        sb.append(uid);
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
  
  public A withCauses(List<StatusCause> causes) {
    if (this.causes != null) {
      this._visitables.get("causes").clear();
    }
    if (causes != null) {
        this.causes = new ArrayList();
        for (StatusCause item : causes) {
          this.addToCauses(item);
        }
    } else {
      this.causes = null;
    }
    return (A) this;
  }
  
  public A withCauses(StatusCause... causes) {
    if (this.causes != null) {
        this.causes.clear();
        _visitables.remove("causes");
    }
    if (causes != null) {
      for (StatusCause item : causes) {
        this.addToCauses(item);
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
  
  public A withRetryAfterSeconds(Integer retryAfterSeconds) {
    this.retryAfterSeconds = retryAfterSeconds;
    return (A) this;
  }
  
  public A withUid(String uid) {
    this.uid = uid;
    return (A) this;
  }
  public class CausesNested<N> extends StatusCauseFluent<CausesNested<N>> implements Nested<N>{
  
    StatusCauseBuilder builder;
    int index;
  
    CausesNested(int index,StatusCause item) {
      this.index = index;
      this.builder = new StatusCauseBuilder(this, item);
    }
  
    public N and() {
      return (N) StatusDetailsFluent.this.setToCauses(index, builder.build());
    }
    
    public N endCause() {
      return and();
    }
    
  }
}