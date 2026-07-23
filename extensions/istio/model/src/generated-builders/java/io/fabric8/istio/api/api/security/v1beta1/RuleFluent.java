package io.fabric8.istio.api.api.security.v1beta1;

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
public class RuleFluent<A extends io.fabric8.istio.api.api.security.v1beta1.RuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<RuleFromBuilder> from = new ArrayList<RuleFromBuilder>();
  private ArrayList<RuleToBuilder> to = new ArrayList<RuleToBuilder>();
  private ArrayList<ConditionBuilder> when = new ArrayList<ConditionBuilder>();

  public RuleFluent() {
  }
  
  public RuleFluent(Rule instance) {
    this.copyInstance(instance);
  }

  public A addAllToFrom(Collection<RuleFrom> items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (RuleFrom item : items) {
        RuleFromBuilder builder = new RuleFromBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTo(Collection<RuleTo> items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (RuleTo item : items) {
        RuleToBuilder builder = new RuleToBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToWhen(Collection<Condition> items) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("when").add(builder);
        this.when.add(builder);
    }
    return (A) this;
  }
  
  public FromNested<A> addNewFrom() {
    return new FromNested(-1, null);
  }
  
  public FromNested<A> addNewFromLike(RuleFrom item) {
    return new FromNested(-1, item);
  }
  
  public ToNested<A> addNewTo() {
    return new ToNested(-1, null);
  }
  
  public ToNested<A> addNewToLike(RuleTo item) {
    return new ToNested(-1, item);
  }
  
  public WhenNested<A> addNewWhen() {
    return new WhenNested(-1, null);
  }
  
  public WhenNested<A> addNewWhenLike(Condition item) {
    return new WhenNested(-1, item);
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
  
  public A addToFrom(RuleFrom... items) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    for (RuleFrom item : items) {
        RuleFromBuilder builder = new RuleFromBuilder(item);
        _visitables.get("from").add(builder);
        this.from.add(builder);
    }
    return (A) this;
  }
  
  public A addToFrom(int index,RuleFrom item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    RuleFromBuilder builder = new RuleFromBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTo(RuleTo... items) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    for (RuleTo item : items) {
        RuleToBuilder builder = new RuleToBuilder(item);
        _visitables.get("to").add(builder);
        this.to.add(builder);
    }
    return (A) this;
  }
  
  public A addToTo(int index,RuleTo item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    RuleToBuilder builder = new RuleToBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToWhen(Condition... items) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("when").add(builder);
        this.when.add(builder);
    }
    return (A) this;
  }
  
  public A addToWhen(int index,Condition item) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= when.size()) {
        _visitables.get("when").add(builder);
        when.add(builder);
    } else {
        _visitables.get("when").add(builder);
        when.add(index, builder);
    }
    return (A) this;
  }
  
  public RuleFrom buildFirstFrom() {
    return this.from.get(0).build();
  }
  
  public RuleTo buildFirstTo() {
    return this.to.get(0).build();
  }
  
  public Condition buildFirstWhen() {
    return this.when.get(0).build();
  }
  
  public List<RuleFrom> buildFrom() {
    return this.from != null ? build(from) : null;
  }
  
  public RuleFrom buildFrom(int index) {
    return this.from.get(index).build();
  }
  
  public RuleFrom buildLastFrom() {
    return this.from.get(from.size() - 1).build();
  }
  
  public RuleTo buildLastTo() {
    return this.to.get(to.size() - 1).build();
  }
  
  public Condition buildLastWhen() {
    return this.when.get(when.size() - 1).build();
  }
  
  public RuleFrom buildMatchingFrom(Predicate<RuleFromBuilder> predicate) {
      for (RuleFromBuilder item : from) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RuleTo buildMatchingTo(Predicate<RuleToBuilder> predicate) {
      for (RuleToBuilder item : to) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Condition buildMatchingWhen(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : when) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<RuleTo> buildTo() {
    return this.to != null ? build(to) : null;
  }
  
  public RuleTo buildTo(int index) {
    return this.to.get(index).build();
  }
  
  public List<Condition> buildWhen() {
    return this.when != null ? build(when) : null;
  }
  
  public Condition buildWhen(int index) {
    return this.when.get(index).build();
  }
  
  protected void copyInstance(Rule instance) {
    instance = instance != null ? instance : new Rule();
    if (instance != null) {
        this.withFrom(instance.getFrom());
        this.withTo(instance.getTo());
        this.withWhen(instance.getWhen());
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
  
  public WhenNested<A> editFirstWhen() {
    if (when.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "when"));
    }
    return this.setNewWhenLike(0, this.buildWhen(0));
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
  
  public WhenNested<A> editLastWhen() {
    int index = when.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "when"));
    }
    return this.setNewWhenLike(index, this.buildWhen(index));
  }
  
  public FromNested<A> editMatchingFrom(Predicate<RuleFromBuilder> predicate) {
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
  
  public ToNested<A> editMatchingTo(Predicate<RuleToBuilder> predicate) {
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
  
  public WhenNested<A> editMatchingWhen(Predicate<ConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < when.size();i++) {
      if (predicate.test(when.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "when"));
    }
    return this.setNewWhenLike(index, this.buildWhen(index));
  }
  
  public ToNested<A> editTo(int index) {
    if (to.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "to"));
    }
    return this.setNewToLike(index, this.buildTo(index));
  }
  
  public WhenNested<A> editWhen(int index) {
    if (when.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "when"));
    }
    return this.setNewWhenLike(index, this.buildWhen(index));
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
    RuleFluent that = (RuleFluent) o;
    if (!(Objects.equals(from, that.from))) {
      return false;
    }
    if (!(Objects.equals(to, that.to))) {
      return false;
    }
    if (!(Objects.equals(when, that.when))) {
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
  
  public boolean hasMatchingFrom(Predicate<RuleFromBuilder> predicate) {
      for (RuleFromBuilder item : from) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTo(Predicate<RuleToBuilder> predicate) {
      for (RuleToBuilder item : to) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingWhen(Predicate<ConditionBuilder> predicate) {
      for (ConditionBuilder item : when) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTo() {
    return this.to != null && !(this.to.isEmpty());
  }
  
  public boolean hasWhen() {
    return this.when != null && !(this.when.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(from, to, when, additionalProperties);
  }
  
  public A removeAllFromFrom(Collection<RuleFrom> items) {
    if (this.from == null) {
      return (A) this;
    }
    for (RuleFrom item : items) {
        RuleFromBuilder builder = new RuleFromBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTo(Collection<RuleTo> items) {
    if (this.to == null) {
      return (A) this;
    }
    for (RuleTo item : items) {
        RuleToBuilder builder = new RuleToBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromWhen(Collection<Condition> items) {
    if (this.when == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("when").remove(builder);
        this.when.remove(builder);
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
  
  public A removeFromFrom(RuleFrom... items) {
    if (this.from == null) {
      return (A) this;
    }
    for (RuleFrom item : items) {
        RuleFromBuilder builder = new RuleFromBuilder(item);
        _visitables.get("from").remove(builder);
        this.from.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTo(RuleTo... items) {
    if (this.to == null) {
      return (A) this;
    }
    for (RuleTo item : items) {
        RuleToBuilder builder = new RuleToBuilder(item);
        _visitables.get("to").remove(builder);
        this.to.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromWhen(Condition... items) {
    if (this.when == null) {
      return (A) this;
    }
    for (Condition item : items) {
        ConditionBuilder builder = new ConditionBuilder(item);
        _visitables.get("when").remove(builder);
        this.when.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFrom(Predicate<RuleFromBuilder> predicate) {
    if (from == null) {
      return (A) this;
    }
    Iterator<RuleFromBuilder> each = from.iterator();
    List visitables = _visitables.get("from");
    while (each.hasNext()) {
        RuleFromBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTo(Predicate<RuleToBuilder> predicate) {
    if (to == null) {
      return (A) this;
    }
    Iterator<RuleToBuilder> each = to.iterator();
    List visitables = _visitables.get("to");
    while (each.hasNext()) {
        RuleToBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromWhen(Predicate<ConditionBuilder> predicate) {
    if (when == null) {
      return (A) this;
    }
    Iterator<ConditionBuilder> each = when.iterator();
    List visitables = _visitables.get("when");
    while (each.hasNext()) {
        ConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FromNested<A> setNewFromLike(int index,RuleFrom item) {
    return new FromNested(index, item);
  }
  
  public ToNested<A> setNewToLike(int index,RuleTo item) {
    return new ToNested(index, item);
  }
  
  public WhenNested<A> setNewWhenLike(int index,Condition item) {
    return new WhenNested(index, item);
  }
  
  public A setToFrom(int index,RuleFrom item) {
    if (this.from == null) {
      this.from = new ArrayList();
    }
    RuleFromBuilder builder = new RuleFromBuilder(item);
    if (index < 0 || index >= from.size()) {
        _visitables.get("from").add(builder);
        from.add(builder);
    } else {
        _visitables.get("from").add(builder);
        from.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTo(int index,RuleTo item) {
    if (this.to == null) {
      this.to = new ArrayList();
    }
    RuleToBuilder builder = new RuleToBuilder(item);
    if (index < 0 || index >= to.size()) {
        _visitables.get("to").add(builder);
        to.add(builder);
    } else {
        _visitables.get("to").add(builder);
        to.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToWhen(int index,Condition item) {
    if (this.when == null) {
      this.when = new ArrayList();
    }
    ConditionBuilder builder = new ConditionBuilder(item);
    if (index < 0 || index >= when.size()) {
        _visitables.get("when").add(builder);
        when.add(builder);
    } else {
        _visitables.get("when").add(builder);
        when.set(index, builder);
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
    if (!(when == null) && !(when.isEmpty())) {
        sb.append("when:");
        sb.append(when);
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
  
  public A withFrom(List<RuleFrom> from) {
    if (this.from != null) {
      this._visitables.get("from").clear();
    }
    if (from != null) {
        this.from = new ArrayList();
        for (RuleFrom item : from) {
          this.addToFrom(item);
        }
    } else {
      this.from = null;
    }
    return (A) this;
  }
  
  public A withFrom(RuleFrom... from) {
    if (this.from != null) {
        this.from.clear();
        _visitables.remove("from");
    }
    if (from != null) {
      for (RuleFrom item : from) {
        this.addToFrom(item);
      }
    }
    return (A) this;
  }
  
  public A withTo(List<RuleTo> to) {
    if (this.to != null) {
      this._visitables.get("to").clear();
    }
    if (to != null) {
        this.to = new ArrayList();
        for (RuleTo item : to) {
          this.addToTo(item);
        }
    } else {
      this.to = null;
    }
    return (A) this;
  }
  
  public A withTo(RuleTo... to) {
    if (this.to != null) {
        this.to.clear();
        _visitables.remove("to");
    }
    if (to != null) {
      for (RuleTo item : to) {
        this.addToTo(item);
      }
    }
    return (A) this;
  }
  
  public A withWhen(List<Condition> when) {
    if (this.when != null) {
      this._visitables.get("when").clear();
    }
    if (when != null) {
        this.when = new ArrayList();
        for (Condition item : when) {
          this.addToWhen(item);
        }
    } else {
      this.when = null;
    }
    return (A) this;
  }
  
  public A withWhen(Condition... when) {
    if (this.when != null) {
        this.when.clear();
        _visitables.remove("when");
    }
    if (when != null) {
      for (Condition item : when) {
        this.addToWhen(item);
      }
    }
    return (A) this;
  }
  public class FromNested<N> extends RuleFromFluent<FromNested<N>> implements Nested<N>{
  
    RuleFromBuilder builder;
    int index;
  
    FromNested(int index,RuleFrom item) {
      this.index = index;
      this.builder = new RuleFromBuilder(this, item);
    }
  
    public N and() {
      return (N) RuleFluent.this.setToFrom(index, builder.build());
    }
    
    public N endFrom() {
      return and();
    }
    
  }
  public class ToNested<N> extends RuleToFluent<ToNested<N>> implements Nested<N>{
  
    RuleToBuilder builder;
    int index;
  
    ToNested(int index,RuleTo item) {
      this.index = index;
      this.builder = new RuleToBuilder(this, item);
    }
  
    public N and() {
      return (N) RuleFluent.this.setToTo(index, builder.build());
    }
    
    public N endTo() {
      return and();
    }
    
  }
  public class WhenNested<N> extends ConditionFluent<WhenNested<N>> implements Nested<N>{
  
    ConditionBuilder builder;
    int index;
  
    WhenNested(int index,Condition item) {
      this.index = index;
      this.builder = new ConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) RuleFluent.this.setToWhen(index, builder.build());
    }
    
    public N endWhen() {
      return and();
    }
    
  }
}