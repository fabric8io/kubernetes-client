package io.fabric8.knative.eventing.v1;

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
public class SubscriptionsAPIFilterFluent<A extends io.fabric8.knative.eventing.v1.SubscriptionsAPIFilterFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<SubscriptionsAPIFilterBuilder> all = new ArrayList<SubscriptionsAPIFilterBuilder>();
  private ArrayList<SubscriptionsAPIFilterBuilder> any = new ArrayList<SubscriptionsAPIFilterBuilder>();
  private String cesql;
  private Map<String,String> exact;
  private SubscriptionsAPIFilterBuilder not;
  private Map<String,String> prefix;
  private Map<String,String> suffix;

  public SubscriptionsAPIFilterFluent() {
  }
  
  public SubscriptionsAPIFilterFluent(SubscriptionsAPIFilter instance) {
    this.copyInstance(instance);
  }

  public A addAllToAll(Collection<SubscriptionsAPIFilter> items) {
    if (this.all == null) {
      this.all = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("all").add(builder);
        this.all.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToAny(Collection<SubscriptionsAPIFilter> items) {
    if (this.any == null) {
      this.any = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("any").add(builder);
        this.any.add(builder);
    }
    return (A) this;
  }
  
  public AllNested<A> addNewAll() {
    return new AllNested(-1, null);
  }
  
  public AllNested<A> addNewAllLike(SubscriptionsAPIFilter item) {
    return new AllNested(-1, item);
  }
  
  public AnyNested<A> addNewAny() {
    return new AnyNested(-1, null);
  }
  
  public AnyNested<A> addNewAnyLike(SubscriptionsAPIFilter item) {
    return new AnyNested(-1, item);
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
  
  public A addToAll(SubscriptionsAPIFilter... items) {
    if (this.all == null) {
      this.all = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("all").add(builder);
        this.all.add(builder);
    }
    return (A) this;
  }
  
  public A addToAll(int index,SubscriptionsAPIFilter item) {
    if (this.all == null) {
      this.all = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= all.size()) {
        _visitables.get("all").add(builder);
        all.add(builder);
    } else {
        _visitables.get("all").add(builder);
        all.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToAny(SubscriptionsAPIFilter... items) {
    if (this.any == null) {
      this.any = new ArrayList();
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("any").add(builder);
        this.any.add(builder);
    }
    return (A) this;
  }
  
  public A addToAny(int index,SubscriptionsAPIFilter item) {
    if (this.any == null) {
      this.any = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= any.size()) {
        _visitables.get("any").add(builder);
        any.add(builder);
    } else {
        _visitables.get("any").add(builder);
        any.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToExact(Map<String,String> map) {
    if (this.exact == null && map != null) {
      this.exact = new LinkedHashMap();
    }
    if (map != null) {
      this.exact.putAll(map);
    }
    return (A) this;
  }
  
  public A addToExact(String key,String value) {
    if (this.exact == null && key != null && value != null) {
      this.exact = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.exact.put(key, value);
    }
    return (A) this;
  }
  
  public A addToPrefix(Map<String,String> map) {
    if (this.prefix == null && map != null) {
      this.prefix = new LinkedHashMap();
    }
    if (map != null) {
      this.prefix.putAll(map);
    }
    return (A) this;
  }
  
  public A addToPrefix(String key,String value) {
    if (this.prefix == null && key != null && value != null) {
      this.prefix = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.prefix.put(key, value);
    }
    return (A) this;
  }
  
  public A addToSuffix(Map<String,String> map) {
    if (this.suffix == null && map != null) {
      this.suffix = new LinkedHashMap();
    }
    if (map != null) {
      this.suffix.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSuffix(String key,String value) {
    if (this.suffix == null && key != null && value != null) {
      this.suffix = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.suffix.put(key, value);
    }
    return (A) this;
  }
  
  public List<SubscriptionsAPIFilter> buildAll() {
    return this.all != null ? build(all) : null;
  }
  
  public SubscriptionsAPIFilter buildAll(int index) {
    return this.all.get(index).build();
  }
  
  public List<SubscriptionsAPIFilter> buildAny() {
    return this.any != null ? build(any) : null;
  }
  
  public SubscriptionsAPIFilter buildAny(int index) {
    return this.any.get(index).build();
  }
  
  public SubscriptionsAPIFilter buildFirstAll() {
    return this.all.get(0).build();
  }
  
  public SubscriptionsAPIFilter buildFirstAny() {
    return this.any.get(0).build();
  }
  
  public SubscriptionsAPIFilter buildLastAll() {
    return this.all.get(all.size() - 1).build();
  }
  
  public SubscriptionsAPIFilter buildLastAny() {
    return this.any.get(any.size() - 1).build();
  }
  
  public SubscriptionsAPIFilter buildMatchingAll(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : all) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubscriptionsAPIFilter buildMatchingAny(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : any) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubscriptionsAPIFilter buildNot() {
    return this.not != null ? this.not.build() : null;
  }
  
  protected void copyInstance(SubscriptionsAPIFilter instance) {
    instance = instance != null ? instance : new SubscriptionsAPIFilter();
    if (instance != null) {
        this.withAll(instance.getAll());
        this.withAny(instance.getAny());
        this.withCesql(instance.getCesql());
        this.withExact(instance.getExact());
        this.withNot(instance.getNot());
        this.withPrefix(instance.getPrefix());
        this.withSuffix(instance.getSuffix());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllNested<A> editAll(int index) {
    if (all.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "all"));
    }
    return this.setNewAllLike(index, this.buildAll(index));
  }
  
  public AnyNested<A> editAny(int index) {
    if (any.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "any"));
    }
    return this.setNewAnyLike(index, this.buildAny(index));
  }
  
  public AllNested<A> editFirstAll() {
    if (all.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "all"));
    }
    return this.setNewAllLike(0, this.buildAll(0));
  }
  
  public AnyNested<A> editFirstAny() {
    if (any.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "any"));
    }
    return this.setNewAnyLike(0, this.buildAny(0));
  }
  
  public AllNested<A> editLastAll() {
    int index = all.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "all"));
    }
    return this.setNewAllLike(index, this.buildAll(index));
  }
  
  public AnyNested<A> editLastAny() {
    int index = any.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "any"));
    }
    return this.setNewAnyLike(index, this.buildAny(index));
  }
  
  public AllNested<A> editMatchingAll(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < all.size();i++) {
      if (predicate.test(all.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "all"));
    }
    return this.setNewAllLike(index, this.buildAll(index));
  }
  
  public AnyNested<A> editMatchingAny(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < any.size();i++) {
      if (predicate.test(any.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "any"));
    }
    return this.setNewAnyLike(index, this.buildAny(index));
  }
  
  public NotNested<A> editNot() {
    return this.withNewNotLike(Optional.ofNullable(this.buildNot()).orElse(null));
  }
  
  public NotNested<A> editOrNewNot() {
    return this.withNewNotLike(Optional.ofNullable(this.buildNot()).orElse(new SubscriptionsAPIFilterBuilder().build()));
  }
  
  public NotNested<A> editOrNewNotLike(SubscriptionsAPIFilter item) {
    return this.withNewNotLike(Optional.ofNullable(this.buildNot()).orElse(item));
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
    SubscriptionsAPIFilterFluent that = (SubscriptionsAPIFilterFluent) o;
    if (!(Objects.equals(all, that.all))) {
      return false;
    }
    if (!(Objects.equals(any, that.any))) {
      return false;
    }
    if (!(Objects.equals(cesql, that.cesql))) {
      return false;
    }
    if (!(Objects.equals(exact, that.exact))) {
      return false;
    }
    if (!(Objects.equals(not, that.not))) {
      return false;
    }
    if (!(Objects.equals(prefix, that.prefix))) {
      return false;
    }
    if (!(Objects.equals(suffix, that.suffix))) {
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
  
  public String getCesql() {
    return this.cesql;
  }
  
  public Map<String,String> getExact() {
    return this.exact;
  }
  
  public Map<String,String> getPrefix() {
    return this.prefix;
  }
  
  public Map<String,String> getSuffix() {
    return this.suffix;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAll() {
    return this.all != null && !(this.all.isEmpty());
  }
  
  public boolean hasAny() {
    return this.any != null && !(this.any.isEmpty());
  }
  
  public boolean hasCesql() {
    return this.cesql != null;
  }
  
  public boolean hasExact() {
    return this.exact != null;
  }
  
  public boolean hasMatchingAll(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : all) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingAny(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
      for (SubscriptionsAPIFilterBuilder item : any) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNot() {
    return this.not != null;
  }
  
  public boolean hasPrefix() {
    return this.prefix != null;
  }
  
  public boolean hasSuffix() {
    return this.suffix != null;
  }
  
  public int hashCode() {
    return Objects.hash(all, any, cesql, exact, not, prefix, suffix, additionalProperties);
  }
  
  public A removeAllFromAll(Collection<SubscriptionsAPIFilter> items) {
    if (this.all == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("all").remove(builder);
        this.all.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromAny(Collection<SubscriptionsAPIFilter> items) {
    if (this.any == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("any").remove(builder);
        this.any.remove(builder);
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
  
  public A removeFromAll(SubscriptionsAPIFilter... items) {
    if (this.all == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("all").remove(builder);
        this.all.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAny(SubscriptionsAPIFilter... items) {
    if (this.any == null) {
      return (A) this;
    }
    for (SubscriptionsAPIFilter item : items) {
        SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
        _visitables.get("any").remove(builder);
        this.any.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromExact(String key) {
    if (this.exact == null) {
      return (A) this;
    }
    if (key != null && this.exact != null) {
      this.exact.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromExact(Map<String,String> map) {
    if (this.exact == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.exact != null) {
          this.exact.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromPrefix(String key) {
    if (this.prefix == null) {
      return (A) this;
    }
    if (key != null && this.prefix != null) {
      this.prefix.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromPrefix(Map<String,String> map) {
    if (this.prefix == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.prefix != null) {
          this.prefix.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromSuffix(String key) {
    if (this.suffix == null) {
      return (A) this;
    }
    if (key != null && this.suffix != null) {
      this.suffix.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSuffix(Map<String,String> map) {
    if (this.suffix == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.suffix != null) {
          this.suffix.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeMatchingFromAll(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
    if (all == null) {
      return (A) this;
    }
    Iterator<SubscriptionsAPIFilterBuilder> each = all.iterator();
    List visitables = _visitables.get("all");
    while (each.hasNext()) {
        SubscriptionsAPIFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromAny(Predicate<SubscriptionsAPIFilterBuilder> predicate) {
    if (any == null) {
      return (A) this;
    }
    Iterator<SubscriptionsAPIFilterBuilder> each = any.iterator();
    List visitables = _visitables.get("any");
    while (each.hasNext()) {
        SubscriptionsAPIFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllNested<A> setNewAllLike(int index,SubscriptionsAPIFilter item) {
    return new AllNested(index, item);
  }
  
  public AnyNested<A> setNewAnyLike(int index,SubscriptionsAPIFilter item) {
    return new AnyNested(index, item);
  }
  
  public A setToAll(int index,SubscriptionsAPIFilter item) {
    if (this.all == null) {
      this.all = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= all.size()) {
        _visitables.get("all").add(builder);
        all.add(builder);
    } else {
        _visitables.get("all").add(builder);
        all.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToAny(int index,SubscriptionsAPIFilter item) {
    if (this.any == null) {
      this.any = new ArrayList();
    }
    SubscriptionsAPIFilterBuilder builder = new SubscriptionsAPIFilterBuilder(item);
    if (index < 0 || index >= any.size()) {
        _visitables.get("any").add(builder);
        any.add(builder);
    } else {
        _visitables.get("any").add(builder);
        any.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(all == null) && !(all.isEmpty())) {
        sb.append("all:");
        sb.append(all);
        sb.append(",");
    }
    if (!(any == null) && !(any.isEmpty())) {
        sb.append("any:");
        sb.append(any);
        sb.append(",");
    }
    if (!(cesql == null)) {
        sb.append("cesql:");
        sb.append(cesql);
        sb.append(",");
    }
    if (!(exact == null) && !(exact.isEmpty())) {
        sb.append("exact:");
        sb.append(exact);
        sb.append(",");
    }
    if (!(not == null)) {
        sb.append("not:");
        sb.append(not);
        sb.append(",");
    }
    if (!(prefix == null) && !(prefix.isEmpty())) {
        sb.append("prefix:");
        sb.append(prefix);
        sb.append(",");
    }
    if (!(suffix == null) && !(suffix.isEmpty())) {
        sb.append("suffix:");
        sb.append(suffix);
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
  
  public A withAll(List<SubscriptionsAPIFilter> all) {
    if (this.all != null) {
      this._visitables.get("all").clear();
    }
    if (all != null) {
        this.all = new ArrayList();
        for (SubscriptionsAPIFilter item : all) {
          this.addToAll(item);
        }
    } else {
      this.all = null;
    }
    return (A) this;
  }
  
  public A withAll(SubscriptionsAPIFilter... all) {
    if (this.all != null) {
        this.all.clear();
        _visitables.remove("all");
    }
    if (all != null) {
      for (SubscriptionsAPIFilter item : all) {
        this.addToAll(item);
      }
    }
    return (A) this;
  }
  
  public A withAny(List<SubscriptionsAPIFilter> any) {
    if (this.any != null) {
      this._visitables.get("any").clear();
    }
    if (any != null) {
        this.any = new ArrayList();
        for (SubscriptionsAPIFilter item : any) {
          this.addToAny(item);
        }
    } else {
      this.any = null;
    }
    return (A) this;
  }
  
  public A withAny(SubscriptionsAPIFilter... any) {
    if (this.any != null) {
        this.any.clear();
        _visitables.remove("any");
    }
    if (any != null) {
      for (SubscriptionsAPIFilter item : any) {
        this.addToAny(item);
      }
    }
    return (A) this;
  }
  
  public A withCesql(String cesql) {
    this.cesql = cesql;
    return (A) this;
  }
  
  public <K,V>A withExact(Map<String,String> exact) {
    if (exact == null) {
      this.exact = null;
    } else {
      this.exact = new LinkedHashMap(exact);
    }
    return (A) this;
  }
  
  public NotNested<A> withNewNot() {
    return new NotNested(null);
  }
  
  public NotNested<A> withNewNotLike(SubscriptionsAPIFilter item) {
    return new NotNested(item);
  }
  
  public A withNot(SubscriptionsAPIFilter not) {
    this._visitables.remove("not");
    if (not != null) {
        this.not = new SubscriptionsAPIFilterBuilder(not);
        this._visitables.get("not").add(this.not);
    } else {
        this.not = null;
        this._visitables.get("not").remove(this.not);
    }
    return (A) this;
  }
  
  public <K,V>A withPrefix(Map<String,String> prefix) {
    if (prefix == null) {
      this.prefix = null;
    } else {
      this.prefix = new LinkedHashMap(prefix);
    }
    return (A) this;
  }
  
  public <K,V>A withSuffix(Map<String,String> suffix) {
    if (suffix == null) {
      this.suffix = null;
    } else {
      this.suffix = new LinkedHashMap(suffix);
    }
    return (A) this;
  }
  public class AllNested<N> extends SubscriptionsAPIFilterFluent<AllNested<N>> implements Nested<N>{
  
    SubscriptionsAPIFilterBuilder builder;
    int index;
  
    AllNested(int index,SubscriptionsAPIFilter item) {
      this.index = index;
      this.builder = new SubscriptionsAPIFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionsAPIFilterFluent.this.setToAll(index, builder.build());
    }
    
    public N endAll() {
      return and();
    }
    
  }
  public class AnyNested<N> extends SubscriptionsAPIFilterFluent<AnyNested<N>> implements Nested<N>{
  
    SubscriptionsAPIFilterBuilder builder;
    int index;
  
    AnyNested(int index,SubscriptionsAPIFilter item) {
      this.index = index;
      this.builder = new SubscriptionsAPIFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionsAPIFilterFluent.this.setToAny(index, builder.build());
    }
    
    public N endAny() {
      return and();
    }
    
  }
  public class NotNested<N> extends SubscriptionsAPIFilterFluent<NotNested<N>> implements Nested<N>{
  
    SubscriptionsAPIFilterBuilder builder;
  
    NotNested(SubscriptionsAPIFilter item) {
      this.builder = new SubscriptionsAPIFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) SubscriptionsAPIFilterFluent.this.withNot(builder.build());
    }
    
    public N endNot() {
      return and();
    }
    
  }
}