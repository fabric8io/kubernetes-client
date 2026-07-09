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
public class ReferenceGrantSpecFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.ReferenceGrantSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ReferenceGrantFromBuilder> from = new ArrayList<ReferenceGrantFromBuilder>();
  private ArrayList<ReferenceGrantToBuilder> to = new ArrayList<ReferenceGrantToBuilder>();

  public ReferenceGrantSpecFluent() {
  }
  
  public ReferenceGrantSpecFluent(ReferenceGrantSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToFrom(Collection<ReferenceGrantFrom> items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (ReferenceGrantFrom item : items) {
        ReferenceGrantFromBuilder builder = new ReferenceGrantFromBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTo(Collection<ReferenceGrantTo> items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (ReferenceGrantTo item : items) {
        ReferenceGrantToBuilder builder = new ReferenceGrantToBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public FromNested<A> addNewFrom() {
    return new FromNested(-1, null);
  }
  
  public A addNewFrom(String group,String kind,String namespace) {
    return (A) this.addToFrom(new ReferenceGrantFrom(group, kind, namespace));
  }
  
  public FromNested<A> addNewFromLike(ReferenceGrantFrom item) {
    return new FromNested(-1, item);
  }
  
  public ToNested<A> addNewTo() {
    return new ToNested(-1, null);
  }
  
  public A addNewTo(String group,String kind,String name) {
    return (A) this.addToTo(new ReferenceGrantTo(group, kind, name));
  }
  
  public ToNested<A> addNewToLike(ReferenceGrantTo item) {
    return new ToNested(-1, item);
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
  
  public A addToFrom(ReferenceGrantFrom... items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (ReferenceGrantFrom item : items) {
        ReferenceGrantFromBuilder builder = new ReferenceGrantFromBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
  }
  
  public A addToFrom(int index,ReferenceGrantFrom item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    ReferenceGrantFromBuilder builder = new ReferenceGrantFromBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTo(ReferenceGrantTo... items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (ReferenceGrantTo item : items) {
        ReferenceGrantToBuilder builder = new ReferenceGrantToBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public A addToTo(int index,ReferenceGrantTo item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    ReferenceGrantToBuilder builder = new ReferenceGrantToBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.add(index, builder);
    }
    return (A) this;
  }
  
  public ReferenceGrantFrom buildFirstFrom() {
    return this.from.get(0).build();
  }
  
  public ReferenceGrantTo buildFirstTo() {
    return this.to.get(0).build();
  }
  
  public List<ReferenceGrantFrom> buildFrom() {
    return this.from != null ? build(from) : null;
  }
  
  public ReferenceGrantFrom buildFrom(int index) {
    return this.from.get(index).build();
  }
  
  public ReferenceGrantFrom buildLastFrom() {
    return this.from.get(from.size() - 1).build();
  }
  
  public ReferenceGrantTo buildLastTo() {
    return this.to.get(to.size() - 1).build();
  }
  
  public ReferenceGrantFrom buildMatchingFrom(Predicate<ReferenceGrantFromBuilder> predicate) {
      for (ReferenceGrantFromBuilder item : from) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ReferenceGrantTo buildMatchingTo(Predicate<ReferenceGrantToBuilder> predicate) {
      for (ReferenceGrantToBuilder item : to) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<ReferenceGrantTo> buildTo() {
    return this.to != null ? build(to) : null;
  }
  
  public ReferenceGrantTo buildTo(int index) {
    return this.to.get(index).build();
  }
  
  protected void copyInstance(ReferenceGrantSpec instance) {
    instance = instance != null ? instance : new ReferenceGrantSpec();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withTo(instance.getTo());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FromNested<A> editFirstFrom() {
    if (from.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "from"));
    }
    return this.setNewFromLike(0, this.buildFrom(0));
  }
  
  public ToNested<A> editFirstTo() {
    if (to.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "to"));
    }
    return this.setNewToLike(0, this.buildTo(0));
  }
  
  public FromNested<A> editFrom(int index) {
    if (from.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public FromNested<A> editLastFrom() {
    int index = from.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public ToNested<A> editLastTo() {
    int index = to.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
  }
  
  public FromNested<A> editMatchingFrom(Predicate<ReferenceGrantFromBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < from.size();i++) {
      if (predicate.test(from.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "from"));
    }
    return this.setNewFromLike(index, this.buildFrom(index));
  }
  
  public ToNested<A> editMatchingTo(Predicate<ReferenceGrantToBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < to.size();i++) {
      if (predicate.test(to.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
  }
  
  public ToNested<A> editTo(int index) {
    if (to.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
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
    ReferenceGrantSpecFluent that = (ReferenceGrantSpecFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
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
  
  public boolean hasFrom() {
    return this.from != null && !(this.from.isEmpty());
  }
  
  public boolean hasMatchingFrom(Predicate<ReferenceGrantFromBuilder> predicate) {
      for (ReferenceGrantFromBuilder item : from) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTo(Predicate<ReferenceGrantToBuilder> predicate) {
      for (ReferenceGrantToBuilder item : to) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTo() {
    return this.to != null && !(this.to.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(from, to, additionalProperties);
  }
  
  public A removeAllFromFrom(Collection<ReferenceGrantFrom> items) {
    if (this.from == null) {
      return (A) this;
    }
    for (ReferenceGrantFrom item : items) {
        ReferenceGrantFromBuilder builder = new ReferenceGrantFromBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTo(Collection<ReferenceGrantTo> items) {
    if (this.to == null) {
      return (A) this;
    }
    for (ReferenceGrantTo item : items) {
        ReferenceGrantToBuilder builder = new ReferenceGrantToBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
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
  
  public A removeFromFrom(ReferenceGrantFrom... items) {
    if (this.from == null) {
      return (A) this;
    }
    for (ReferenceGrantFrom item : items) {
        ReferenceGrantFromBuilder builder = new ReferenceGrantFromBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTo(ReferenceGrantTo... items) {
    if (this.to == null) {
      return (A) this;
    }
    for (ReferenceGrantTo item : items) {
        ReferenceGrantToBuilder builder = new ReferenceGrantToBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFrom(Predicate<ReferenceGrantFromBuilder> predicate) {
    if (from == null) {
      return (A) this;
    }
    Iterator<ReferenceGrantFromBuilder> each = from.iterator();
    List visitables = _visitables.get("from");
    while (each.hasNext()) {
        ReferenceGrantFromBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTo(Predicate<ReferenceGrantToBuilder> predicate) {
    if (to == null) {
      return (A) this;
    }
    Iterator<ReferenceGrantToBuilder> each = to.iterator();
    List visitables = _visitables.get("to");
    while (each.hasNext()) {
        ReferenceGrantToBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FromNested<A> setNewFromLike(int index,ReferenceGrantFrom item) {
    return new FromNested(index, item);
  }
  
  public ToNested<A> setNewToLike(int index,ReferenceGrantTo item) {
    return new ToNested(index, item);
  }
  
  public A setToFrom(int index,ReferenceGrantFrom item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    ReferenceGrantFromBuilder builder = new ReferenceGrantFromBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTo(int index,ReferenceGrantTo item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    ReferenceGrantToBuilder builder = new ReferenceGrantToBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(from == null) && !(from.isEmpty())) {
        sb.append("from:");
        sb.append(from);
        sb.append(",");
    }
    if (!(to == null) && !(to.isEmpty())) {
        sb.append("to:");
        sb.append(to);
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
  
  public A withFrom(List<ReferenceGrantFrom> from) {
    if (this.from != null) {
      this._visitables.get("from").clear();
    }
    if (from != null) {
        this.from = new ArrayList();
        for (ReferenceGrantFrom item : from) {
          this.addToFrom(item);
        }
    } else {
      this.from = null;
    }
    return (A) this;
  }
  
  public A withFrom(ReferenceGrantFrom... from) {
    if (this.from != null) {
        this.from.clear();
        _visitables.remove("from");
    }
    if (from != null) {
      for (ReferenceGrantFrom item : from) {
        this.addToFrom(item);
      }
    }
    return (A) this;
  }
  
  public A withTo(List<ReferenceGrantTo> to) {
    if (this.to != null) {
      this._visitables.get("to").clear();
    }
    if (to != null) {
        this.to = new ArrayList();
        for (ReferenceGrantTo item : to) {
          this.addToTo(item);
        }
    } else {
      this.to = null;
    }
    return (A) this;
  }
  
  public A withTo(ReferenceGrantTo... to) {
    if (this.to != null) {
        this.to.clear();
        _visitables.remove("to");
    }
    if (to != null) {
      for (ReferenceGrantTo item : to) {
        this.addToTo(item);
      }
    }
    return (A) this;
  }
  public class FromNested<N> extends ReferenceGrantFromFluent<FromNested<N>> implements Nested<N>{
  
    ReferenceGrantFromBuilder builder;
    int index;
  
    FromNested(int index,ReferenceGrantFrom item) {
      this.index = index;
      this.builder = new ReferenceGrantFromBuilder(this, item);
    }
  
    public N and() {
      return (N) ReferenceGrantSpecFluent.this.setToFrom(index, builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class ToNested<N> extends ReferenceGrantToFluent<ToNested<N>> implements Nested<N>{
  
    ReferenceGrantToBuilder builder;
    int index;
  
    ToNested(int index,ReferenceGrantTo item) {
      this.index = index;
      this.builder = new ReferenceGrantToBuilder(this, item);
    }
  
    public N and() {
      return (N) ReferenceGrantSpecFluent.this.setToTo(index, builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
}