package io.fabric8.openshift.api.model;

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
public class NamedTagEventListFluent<A extends io.fabric8.openshift.api.model.NamedTagEventListFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TagEventConditionBuilder> conditions = new ArrayList<TagEventConditionBuilder>();
  private ArrayList<TagEventBuilder> items = new ArrayList<TagEventBuilder>();
  private String tag;

  public NamedTagEventListFluent() {
  }
  
  public NamedTagEventListFluent(NamedTagEventList instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<TagEventCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToItems(Collection<TagEvent> items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (TagEvent item : items) {
        TagEventBuilder builder = new TagEventBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(TagEventCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ItemsNested<A> addNewItem() {
    return new ItemsNested(-1, null);
  }
  
  public A addNewItem(String created,String dockerImageReference,Long generation,String image) {
    return (A) this.addToItems(new TagEvent(created, dockerImageReference, generation, image));
  }
  
  public ItemsNested<A> addNewItemLike(TagEvent item) {
    return new ItemsNested(-1, item);
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
  
  public A addToConditions(TagEventCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,TagEventCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToItems(TagEvent... items) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    for (TagEvent item : items) {
        TagEventBuilder builder = new TagEventBuilder(item);
        _visitables.get("items").add(builder);
        this.items.add(builder);
    }
    return (A) this;
  }
  
  public A addToItems(int index,TagEvent item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    TagEventBuilder builder = new TagEventBuilder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.add(index, builder);
    }
    return (A) this;
  }
  
  public TagEventCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<TagEventCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public TagEventCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public TagEvent buildFirstItem() {
    return this.items.get(0).build();
  }
  
  public TagEvent buildItem(int index) {
    return this.items.get(index).build();
  }
  
  public List<TagEvent> buildItems() {
    return this.items != null ? build(items) : null;
  }
  
  public TagEventCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public TagEvent buildLastItem() {
    return this.items.get(items.size() - 1).build();
  }
  
  public TagEventCondition buildMatchingCondition(Predicate<TagEventConditionBuilder> predicate) {
      for (TagEventConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TagEvent buildMatchingItem(Predicate<TagEventBuilder> predicate) {
      for (TagEventBuilder item : items) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(NamedTagEventList instance) {
    instance = instance != null ? instance : new NamedTagEventList();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withItems(instance.getItems());
        this.withTag(instance.getTag());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public ItemsNested<A> editFirstItem() {
    if (items.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "items"));
    }
    return this.setNewItemLike(0, this.buildItem(0));
  }
  
  public ItemsNested<A> editItem(int index) {
    if (items.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "items"));
    }
    return this.setNewItemLike(index, this.buildItem(index));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ItemsNested<A> editLastItem() {
    int index = items.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "items"));
    }
    return this.setNewItemLike(index, this.buildItem(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<TagEventConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ItemsNested<A> editMatchingItem(Predicate<TagEventBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < items.size();i++) {
      if (predicate.test(items.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "items"));
    }
    return this.setNewItemLike(index, this.buildItem(index));
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
    NamedTagEventListFluent that = (NamedTagEventListFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(items, that.items))) {
      return false;
    }
    if (!(Objects.equals(tag, that.tag))) {
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
  
  public String getTag() {
    return this.tag;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasItems() {
    return this.items != null && !(this.items.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<TagEventConditionBuilder> predicate) {
      for (TagEventConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingItem(Predicate<TagEventBuilder> predicate) {
      for (TagEventBuilder item : items) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasTag() {
    return this.tag != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, items, tag, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<TagEventCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromItems(Collection<TagEvent> items) {
    if (this.items == null) {
      return (A) this;
    }
    for (TagEvent item : items) {
        TagEventBuilder builder = new TagEventBuilder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
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
  
  public A removeFromConditions(TagEventCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (TagEventCondition item : items) {
        TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromItems(TagEvent... items) {
    if (this.items == null) {
      return (A) this;
    }
    for (TagEvent item : items) {
        TagEventBuilder builder = new TagEventBuilder(item);
        _visitables.get("items").remove(builder);
        this.items.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<TagEventConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<TagEventConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        TagEventConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromItems(Predicate<TagEventBuilder> predicate) {
    if (items == null) {
      return (A) this;
    }
    Iterator<TagEventBuilder> each = items.iterator();
    List visitables = _visitables.get("items");
    while (each.hasNext()) {
        TagEventBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,TagEventCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public ItemsNested<A> setNewItemLike(int index,TagEvent item) {
    return new ItemsNested(index, item);
  }
  
  public A setToConditions(int index,TagEventCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    TagEventConditionBuilder builder = new TagEventConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToItems(int index,TagEvent item) {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    TagEventBuilder builder = new TagEventBuilder(item);
    if (index < 0 || index >= items.size()) {
        _visitables.get("items").add(builder);
        items.add(builder);
    } else {
        _visitables.get("items").add(builder);
        items.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(items == null) && !(items.isEmpty())) {
        sb.append("items:");
        sb.append(items);
        sb.append(",");
    }
    if (!(tag == null)) {
        sb.append("tag:");
        sb.append(tag);
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
  
  public A withConditions(List<TagEventCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (TagEventCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(TagEventCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (TagEventCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withItems(List<TagEvent> items) {
    if (this.items != null) {
      this._visitables.get("items").clear();
    }
    if (items != null) {
        this.items = new ArrayList();
        for (TagEvent item : items) {
          this.addToItems(item);
        }
    } else {
      this.items = null;
    }
    return (A) this;
  }
  
  public A withItems(TagEvent... items) {
    if (this.items != null) {
        this.items.clear();
        _visitables.remove("items");
    }
    if (items != null) {
      for (TagEvent item : items) {
        this.addToItems(item);
      }
    }
    return (A) this;
  }
  
  public A withTag(String tag) {
    this.tag = tag;
    return (A) this;
  }
  public class ConditionsNested<N> extends TagEventConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    TagEventConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,TagEventCondition item) {
      this.index = index;
      this.builder = new TagEventConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedTagEventListFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ItemsNested<N> extends TagEventFluent<ItemsNested<N>> implements Nested<N>{
  
    TagEventBuilder builder;
    int index;
  
    ItemsNested(int index,TagEvent item) {
      this.index = index;
      this.builder = new TagEventBuilder(this, item);
    }
  
    public N and() {
      return (N) NamedTagEventListFluent.this.setToItems(index, builder.build());
    }
    
    public N endItem() {
      return and();
    }
    
  }
}