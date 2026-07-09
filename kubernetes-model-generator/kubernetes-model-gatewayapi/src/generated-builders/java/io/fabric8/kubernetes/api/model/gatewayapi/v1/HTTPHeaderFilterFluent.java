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
public class HTTPHeaderFilterFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPHeaderFilterFluent<A>> extends BaseFluent<A>{

  private ArrayList<HTTPHeaderBuilder> add = new ArrayList<HTTPHeaderBuilder>();
  private Map<String,Object> additionalProperties;
  private List<String> remove = new ArrayList<String>();
  private ArrayList<HTTPHeaderBuilder> set = new ArrayList<HTTPHeaderBuilder>();

  public HTTPHeaderFilterFluent() {
  }
  
  public HTTPHeaderFilterFluent(HTTPHeaderFilter instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdd(Collection<HTTPHeader> items) {
    if (this.add == null) {
      this.add = new ArrayList();
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("add").add(builder);
        this.add.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRemove(Collection<String> items) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    for (String item : items) {
      this.remove.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSet(Collection<HTTPHeader> items) {
    if (this.set == null) {
      this.set = new ArrayList();
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("set").add(builder);
        this.set.add(builder);
    }
    return (A) this;
  }
  
  public AddNested<A> addNewAdd() {
    return new AddNested(-1, null);
  }
  
  public A addNewAdd(String name,String value) {
    return (A) this.addToAdd(new HTTPHeader(name, value));
  }
  
  public AddNested<A> addNewAddLike(HTTPHeader item) {
    return new AddNested(-1, item);
  }
  
  public SetNested<A> addNewSet() {
    return new SetNested(-1, null);
  }
  
  public A addNewSet(String name,String value) {
    return (A) this.addToSet(new HTTPHeader(name, value));
  }
  
  public SetNested<A> addNewSetLike(HTTPHeader item) {
    return new SetNested(-1, item);
  }
  
  public A addToAdd(HTTPHeader... items) {
    if (this.add == null) {
      this.add = new ArrayList();
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("add").add(builder);
        this.add.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdd(int index,HTTPHeader item) {
    if (this.add == null) {
      this.add = new ArrayList();
    }
    HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
    if (index < 0 || index >= add.size()) {
        _visitables.get("add").add(builder);
        add.add(builder);
    } else {
        _visitables.get("add").add(builder);
        add.add(index, builder);
    }
    return (A) this;
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
  
  public A addToRemove(String... items) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    for (String item : items) {
      this.remove.add(item);
    }
    return (A) this;
  }
  
  public A addToRemove(int index,String item) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    this.remove.add(index, item);
    return (A) this;
  }
  
  public A addToSet(HTTPHeader... items) {
    if (this.set == null) {
      this.set = new ArrayList();
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("set").add(builder);
        this.set.add(builder);
    }
    return (A) this;
  }
  
  public A addToSet(int index,HTTPHeader item) {
    if (this.set == null) {
      this.set = new ArrayList();
    }
    HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
    if (index < 0 || index >= set.size()) {
        _visitables.get("set").add(builder);
        set.add(builder);
    } else {
        _visitables.get("set").add(builder);
        set.add(index, builder);
    }
    return (A) this;
  }
  
  public List<HTTPHeader> buildAdd() {
    return this.add != null ? build(add) : null;
  }
  
  public HTTPHeader buildAdd(int index) {
    return this.add.get(index).build();
  }
  
  public HTTPHeader buildFirstAdd() {
    return this.add.get(0).build();
  }
  
  public HTTPHeader buildFirstSet() {
    return this.set.get(0).build();
  }
  
  public HTTPHeader buildLastAdd() {
    return this.add.get(add.size() - 1).build();
  }
  
  public HTTPHeader buildLastSet() {
    return this.set.get(set.size() - 1).build();
  }
  
  public HTTPHeader buildMatchingAdd(Predicate<HTTPHeaderBuilder> predicate) {
      for (HTTPHeaderBuilder item : add) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPHeader buildMatchingSet(Predicate<HTTPHeaderBuilder> predicate) {
      for (HTTPHeaderBuilder item : set) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<HTTPHeader> buildSet() {
    return this.set != null ? build(set) : null;
  }
  
  public HTTPHeader buildSet(int index) {
    return this.set.get(index).build();
  }
  
  protected void copyInstance(HTTPHeaderFilter instance) {
    instance = instance != null ? instance : new HTTPHeaderFilter();
    if (instance != null) {
        this.withAdd(instance.getAdd());
        this.withRemove(instance.getRemove());
        this.withSet(instance.getSet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddNested<A> editAdd(int index) {
    if (add.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "add"));
    }
    return this.setNewAddLike(index, this.buildAdd(index));
  }
  
  public AddNested<A> editFirstAdd() {
    if (add.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "add"));
    }
    return this.setNewAddLike(0, this.buildAdd(0));
  }
  
  public SetNested<A> editFirstSet() {
    if (set.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "set"));
    }
    return this.setNewSetLike(0, this.buildSet(0));
  }
  
  public AddNested<A> editLastAdd() {
    int index = add.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "add"));
    }
    return this.setNewAddLike(index, this.buildAdd(index));
  }
  
  public SetNested<A> editLastSet() {
    int index = set.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "set"));
    }
    return this.setNewSetLike(index, this.buildSet(index));
  }
  
  public AddNested<A> editMatchingAdd(Predicate<HTTPHeaderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < add.size();i++) {
      if (predicate.test(add.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "add"));
    }
    return this.setNewAddLike(index, this.buildAdd(index));
  }
  
  public SetNested<A> editMatchingSet(Predicate<HTTPHeaderBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < set.size();i++) {
      if (predicate.test(set.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "set"));
    }
    return this.setNewSetLike(index, this.buildSet(index));
  }
  
  public SetNested<A> editSet(int index) {
    if (set.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "set"));
    }
    return this.setNewSetLike(index, this.buildSet(index));
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
    HTTPHeaderFilterFluent that = (HTTPHeaderFilterFluent) o;
    if (!(Objects.equals(add, that.add))) {
      return false;
    }
    if (!(Objects.equals(remove, that.remove))) {
      return false;
    }
    if (!(Objects.equals(set, that.set))) {
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
  
  public String getFirstRemove() {
    return this.remove.get(0);
  }
  
  public String getLastRemove() {
    return this.remove.get(remove.size() - 1);
  }
  
  public String getMatchingRemove(Predicate<String> predicate) {
      for (String item : remove) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getRemove() {
    return this.remove;
  }
  
  public String getRemove(int index) {
    return this.remove.get(index);
  }
  
  public boolean hasAdd() {
    return this.add != null && !(this.add.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingAdd(Predicate<HTTPHeaderBuilder> predicate) {
      for (HTTPHeaderBuilder item : add) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRemove(Predicate<String> predicate) {
      for (String item : remove) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSet(Predicate<HTTPHeaderBuilder> predicate) {
      for (HTTPHeaderBuilder item : set) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRemove() {
    return this.remove != null && !(this.remove.isEmpty());
  }
  
  public boolean hasSet() {
    return this.set != null && !(this.set.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(add, remove, set, additionalProperties);
  }
  
  public A removeAllFromAdd(Collection<HTTPHeader> items) {
    if (this.add == null) {
      return (A) this;
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("add").remove(builder);
        this.add.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRemove(Collection<String> items) {
    if (this.remove == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remove.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSet(Collection<HTTPHeader> items) {
    if (this.set == null) {
      return (A) this;
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("set").remove(builder);
        this.set.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdd(HTTPHeader... items) {
    if (this.add == null) {
      return (A) this;
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("add").remove(builder);
        this.add.remove(builder);
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
  
  public A removeFromRemove(String... items) {
    if (this.remove == null) {
      return (A) this;
    }
    for (String item : items) {
      this.remove.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSet(HTTPHeader... items) {
    if (this.set == null) {
      return (A) this;
    }
    for (HTTPHeader item : items) {
        HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
        _visitables.get("set").remove(builder);
        this.set.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdd(Predicate<HTTPHeaderBuilder> predicate) {
    if (add == null) {
      return (A) this;
    }
    Iterator<HTTPHeaderBuilder> each = add.iterator();
    List visitables = _visitables.get("add");
    while (each.hasNext()) {
        HTTPHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromSet(Predicate<HTTPHeaderBuilder> predicate) {
    if (set == null) {
      return (A) this;
    }
    Iterator<HTTPHeaderBuilder> each = set.iterator();
    List visitables = _visitables.get("set");
    while (each.hasNext()) {
        HTTPHeaderBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AddNested<A> setNewAddLike(int index,HTTPHeader item) {
    return new AddNested(index, item);
  }
  
  public SetNested<A> setNewSetLike(int index,HTTPHeader item) {
    return new SetNested(index, item);
  }
  
  public A setToAdd(int index,HTTPHeader item) {
    if (this.add == null) {
      this.add = new ArrayList();
    }
    HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
    if (index < 0 || index >= add.size()) {
        _visitables.get("add").add(builder);
        add.add(builder);
    } else {
        _visitables.get("add").add(builder);
        add.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRemove(int index,String item) {
    if (this.remove == null) {
      this.remove = new ArrayList();
    }
    this.remove.set(index, item);
    return (A) this;
  }
  
  public A setToSet(int index,HTTPHeader item) {
    if (this.set == null) {
      this.set = new ArrayList();
    }
    HTTPHeaderBuilder builder = new HTTPHeaderBuilder(item);
    if (index < 0 || index >= set.size()) {
        _visitables.get("set").add(builder);
        set.add(builder);
    } else {
        _visitables.get("set").add(builder);
        set.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(add == null) && !(add.isEmpty())) {
        sb.append("add:");
        sb.append(add);
        sb.append(",");
    }
    if (!(remove == null) && !(remove.isEmpty())) {
        sb.append("remove:");
        sb.append(remove);
        sb.append(",");
    }
    if (!(set == null) && !(set.isEmpty())) {
        sb.append("set:");
        sb.append(set);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdd(List<HTTPHeader> add) {
    if (this.add != null) {
      this._visitables.get("add").clear();
    }
    if (add != null) {
        this.add = new ArrayList();
        for (HTTPHeader item : add) {
          this.addToAdd(item);
        }
    } else {
      this.add = null;
    }
    return (A) this;
  }
  
  public A withAdd(HTTPHeader... add) {
    if (this.add != null) {
        this.add.clear();
        _visitables.remove("add");
    }
    if (add != null) {
      for (HTTPHeader item : add) {
        this.addToAdd(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withRemove(List<String> remove) {
    if (remove != null) {
        this.remove = new ArrayList();
        for (String item : remove) {
          this.addToRemove(item);
        }
    } else {
      this.remove = null;
    }
    return (A) this;
  }
  
  public A withRemove(String... remove) {
    if (this.remove != null) {
        this.remove.clear();
        _visitables.remove("remove");
    }
    if (remove != null) {
      for (String item : remove) {
        this.addToRemove(item);
      }
    }
    return (A) this;
  }
  
  public A withSet(List<HTTPHeader> set) {
    if (this.set != null) {
      this._visitables.get("set").clear();
    }
    if (set != null) {
        this.set = new ArrayList();
        for (HTTPHeader item : set) {
          this.addToSet(item);
        }
    } else {
      this.set = null;
    }
    return (A) this;
  }
  
  public A withSet(HTTPHeader... set) {
    if (this.set != null) {
        this.set.clear();
        _visitables.remove("set");
    }
    if (set != null) {
      for (HTTPHeader item : set) {
        this.addToSet(item);
      }
    }
    return (A) this;
  }
  public class AddNested<N> extends HTTPHeaderFluent<AddNested<N>> implements Nested<N>{
  
    HTTPHeaderBuilder builder;
    int index;
  
    AddNested(int index,HTTPHeader item) {
      this.index = index;
      this.builder = new HTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPHeaderFilterFluent.this.setToAdd(index, builder.build());
    }
    
    public N endAdd() {
      return and();
    }
    
  }
  public class SetNested<N> extends HTTPHeaderFluent<SetNested<N>> implements Nested<N>{
  
    HTTPHeaderBuilder builder;
    int index;
  
    SetNested(int index,HTTPHeader item) {
      this.index = index;
      this.builder = new HTTPHeaderBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPHeaderFilterFluent.this.setToSet(index, builder.build());
    }
    
    public N endSet() {
      return and();
    }
    
  }
}