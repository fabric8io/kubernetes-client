package io.fabric8.openshift.api.model;

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
public class TemplateInstanceStatusFluent<A extends io.fabric8.openshift.api.model.TemplateInstanceStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<TemplateInstanceConditionBuilder> conditions = new ArrayList<TemplateInstanceConditionBuilder>();
  private ArrayList<TemplateInstanceObjectBuilder> objects = new ArrayList<TemplateInstanceObjectBuilder>();

  public TemplateInstanceStatusFluent() {
  }
  
  public TemplateInstanceStatusFluent(TemplateInstanceStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<TemplateInstanceCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (TemplateInstanceCondition item : items) {
        TemplateInstanceConditionBuilder builder = new TemplateInstanceConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToObjects(Collection<TemplateInstanceObject> items) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    for (TemplateInstanceObject item : items) {
        TemplateInstanceObjectBuilder builder = new TemplateInstanceObjectBuilder(item);
        _visitables.get("objects").add(builder);
        this.objects.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new TemplateInstanceCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(TemplateInstanceCondition item) {
    return new ConditionsNested(-1, item);
  }
  
  public ObjectsNested<A> addNewObject() {
    return new ObjectsNested(-1, null);
  }
  
  public ObjectsNested<A> addNewObjectLike(TemplateInstanceObject item) {
    return new ObjectsNested(-1, item);
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
  
  public A addToConditions(TemplateInstanceCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (TemplateInstanceCondition item : items) {
        TemplateInstanceConditionBuilder builder = new TemplateInstanceConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,TemplateInstanceCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    TemplateInstanceConditionBuilder builder = new TemplateInstanceConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToObjects(TemplateInstanceObject... items) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    for (TemplateInstanceObject item : items) {
        TemplateInstanceObjectBuilder builder = new TemplateInstanceObjectBuilder(item);
        _visitables.get("objects").add(builder);
        this.objects.add(builder);
    }
    return (A) this;
  }
  
  public A addToObjects(int index,TemplateInstanceObject item) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    TemplateInstanceObjectBuilder builder = new TemplateInstanceObjectBuilder(item);
    if (index < 0 || index >= objects.size()) {
        _visitables.get("objects").add(builder);
        objects.add(builder);
    } else {
        _visitables.get("objects").add(builder);
        objects.add(index, builder);
    }
    return (A) this;
  }
  
  public TemplateInstanceCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<TemplateInstanceCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public TemplateInstanceCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public TemplateInstanceObject buildFirstObject() {
    return this.objects.get(0).build();
  }
  
  public TemplateInstanceCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public TemplateInstanceObject buildLastObject() {
    return this.objects.get(objects.size() - 1).build();
  }
  
  public TemplateInstanceCondition buildMatchingCondition(Predicate<TemplateInstanceConditionBuilder> predicate) {
      for (TemplateInstanceConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TemplateInstanceObject buildMatchingObject(Predicate<TemplateInstanceObjectBuilder> predicate) {
      for (TemplateInstanceObjectBuilder item : objects) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public TemplateInstanceObject buildObject(int index) {
    return this.objects.get(index).build();
  }
  
  public List<TemplateInstanceObject> buildObjects() {
    return this.objects != null ? build(objects) : null;
  }
  
  protected void copyInstance(TemplateInstanceStatus instance) {
    instance = instance != null ? instance : new TemplateInstanceStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withObjects(instance.getObjects());
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
  
  public ObjectsNested<A> editFirstObject() {
    if (objects.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "objects"));
    }
    return this.setNewObjectLike(0, this.buildObject(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ObjectsNested<A> editLastObject() {
    int index = objects.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "objects"));
    }
    return this.setNewObjectLike(index, this.buildObject(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<TemplateInstanceConditionBuilder> predicate) {
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
  
  public ObjectsNested<A> editMatchingObject(Predicate<TemplateInstanceObjectBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < objects.size();i++) {
      if (predicate.test(objects.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "objects"));
    }
    return this.setNewObjectLike(index, this.buildObject(index));
  }
  
  public ObjectsNested<A> editObject(int index) {
    if (objects.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "objects"));
    }
    return this.setNewObjectLike(index, this.buildObject(index));
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
    TemplateInstanceStatusFluent that = (TemplateInstanceStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(objects, that.objects))) {
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
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<TemplateInstanceConditionBuilder> predicate) {
      for (TemplateInstanceConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingObject(Predicate<TemplateInstanceObjectBuilder> predicate) {
      for (TemplateInstanceObjectBuilder item : objects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasObjects() {
    return this.objects != null && !(this.objects.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, objects, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<TemplateInstanceCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (TemplateInstanceCondition item : items) {
        TemplateInstanceConditionBuilder builder = new TemplateInstanceConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromObjects(Collection<TemplateInstanceObject> items) {
    if (this.objects == null) {
      return (A) this;
    }
    for (TemplateInstanceObject item : items) {
        TemplateInstanceObjectBuilder builder = new TemplateInstanceObjectBuilder(item);
        _visitables.get("objects").remove(builder);
        this.objects.remove(builder);
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
  
  public A removeFromConditions(TemplateInstanceCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (TemplateInstanceCondition item : items) {
        TemplateInstanceConditionBuilder builder = new TemplateInstanceConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromObjects(TemplateInstanceObject... items) {
    if (this.objects == null) {
      return (A) this;
    }
    for (TemplateInstanceObject item : items) {
        TemplateInstanceObjectBuilder builder = new TemplateInstanceObjectBuilder(item);
        _visitables.get("objects").remove(builder);
        this.objects.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<TemplateInstanceConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<TemplateInstanceConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        TemplateInstanceConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromObjects(Predicate<TemplateInstanceObjectBuilder> predicate) {
    if (objects == null) {
      return (A) this;
    }
    Iterator<TemplateInstanceObjectBuilder> each = objects.iterator();
    List visitables = _visitables.get("objects");
    while (each.hasNext()) {
        TemplateInstanceObjectBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,TemplateInstanceCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public ObjectsNested<A> setNewObjectLike(int index,TemplateInstanceObject item) {
    return new ObjectsNested(index, item);
  }
  
  public A setToConditions(int index,TemplateInstanceCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    TemplateInstanceConditionBuilder builder = new TemplateInstanceConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToObjects(int index,TemplateInstanceObject item) {
    if (this.objects == null) {
      this.objects = new ArrayList();
    }
    TemplateInstanceObjectBuilder builder = new TemplateInstanceObjectBuilder(item);
    if (index < 0 || index >= objects.size()) {
        _visitables.get("objects").add(builder);
        objects.add(builder);
    } else {
        _visitables.get("objects").add(builder);
        objects.set(index, builder);
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
    if (!(objects == null) && !(objects.isEmpty())) {
        sb.append("objects:");
        sb.append(objects);
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
  
  public A withConditions(List<TemplateInstanceCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (TemplateInstanceCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(TemplateInstanceCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (TemplateInstanceCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withObjects(List<TemplateInstanceObject> objects) {
    if (this.objects != null) {
      this._visitables.get("objects").clear();
    }
    if (objects != null) {
        this.objects = new ArrayList();
        for (TemplateInstanceObject item : objects) {
          this.addToObjects(item);
        }
    } else {
      this.objects = null;
    }
    return (A) this;
  }
  
  public A withObjects(TemplateInstanceObject... objects) {
    if (this.objects != null) {
        this.objects.clear();
        _visitables.remove("objects");
    }
    if (objects != null) {
      for (TemplateInstanceObject item : objects) {
        this.addToObjects(item);
      }
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends TemplateInstanceConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    TemplateInstanceConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,TemplateInstanceCondition item) {
      this.index = index;
      this.builder = new TemplateInstanceConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) TemplateInstanceStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class ObjectsNested<N> extends TemplateInstanceObjectFluent<ObjectsNested<N>> implements Nested<N>{
  
    TemplateInstanceObjectBuilder builder;
    int index;
  
    ObjectsNested(int index,TemplateInstanceObject item) {
      this.index = index;
      this.builder = new TemplateInstanceObjectBuilder(this, item);
    }
  
    public N and() {
      return (N) TemplateInstanceStatusFluent.this.setToObjects(index, builder.build());
    }
    
    public N endObject() {
      return and();
    }
    
  }
}