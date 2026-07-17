package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
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
public class ComponentRouteStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.ComponentRouteStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private List<String> consumingUsers = new ArrayList<String>();
  private List<String> currentHostnames = new ArrayList<String>();
  private String defaultHostname;
  private String name;
  private String namespace;
  private ArrayList<ObjectReferenceBuilder> relatedObjects = new ArrayList<ObjectReferenceBuilder>();

  public ComponentRouteStatusFluent() {
  }
  
  public ComponentRouteStatusFluent(ComponentRouteStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addAllToConsumingUsers(Collection<String> items) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    for (String item : items) {
      this.consumingUsers.add(item);
    }
    return (A) this;
  }
  
  public A addAllToCurrentHostnames(Collection<String> items) {
    if (this.currentHostnames == null) {
      this.currentHostnames = new ArrayList();
    }
    for (String item : items) {
      this.currentHostnames.add(item);
    }
    return (A) this;
  }
  
  public A addAllToRelatedObjects(Collection<ObjectReference> items) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").add(builder);
        this.relatedObjects.add(builder);
    }
    return (A) this;
  }
  
  public RelatedObjectsNested<A> addNewRelatedObject() {
    return new RelatedObjectsNested(-1, null);
  }
  
  public A addNewRelatedObject(String group,String name,String namespace,String resource) {
    return (A) this.addToRelatedObjects(new ObjectReference(group, name, namespace, resource));
  }
  
  public RelatedObjectsNested<A> addNewRelatedObjectLike(ObjectReference item) {
    return new RelatedObjectsNested(-1, item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public A addToConsumingUsers(String... items) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    for (String item : items) {
      this.consumingUsers.add(item);
    }
    return (A) this;
  }
  
  public A addToConsumingUsers(int index,String item) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    this.consumingUsers.add(index, item);
    return (A) this;
  }
  
  public A addToCurrentHostnames(String... items) {
    if (this.currentHostnames == null) {
      this.currentHostnames = new ArrayList();
    }
    for (String item : items) {
      this.currentHostnames.add(item);
    }
    return (A) this;
  }
  
  public A addToCurrentHostnames(int index,String item) {
    if (this.currentHostnames == null) {
      this.currentHostnames = new ArrayList();
    }
    this.currentHostnames.add(index, item);
    return (A) this;
  }
  
  public A addToRelatedObjects(ObjectReference... items) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").add(builder);
        this.relatedObjects.add(builder);
    }
    return (A) this;
  }
  
  public A addToRelatedObjects(int index,ObjectReference item) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= relatedObjects.size()) {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.add(builder);
    } else {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.add(index, builder);
    }
    return (A) this;
  }
  
  public ObjectReference buildFirstRelatedObject() {
    return this.relatedObjects.get(0).build();
  }
  
  public ObjectReference buildLastRelatedObject() {
    return this.relatedObjects.get(relatedObjects.size() - 1).build();
  }
  
  public ObjectReference buildMatchingRelatedObject(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : relatedObjects) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildRelatedObject(int index) {
    return this.relatedObjects.get(index).build();
  }
  
  public List<ObjectReference> buildRelatedObjects() {
    return this.relatedObjects != null ? build(relatedObjects) : null;
  }
  
  protected void copyInstance(ComponentRouteStatus instance) {
    instance = instance != null ? instance : new ComponentRouteStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withConsumingUsers(instance.getConsumingUsers());
        this.withCurrentHostnames(instance.getCurrentHostnames());
        this.withDefaultHostname(instance.getDefaultHostname());
        this.withName(instance.getName());
        this.withNamespace(instance.getNamespace());
        this.withRelatedObjects(instance.getRelatedObjects());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RelatedObjectsNested<A> editFirstRelatedObject() {
    if (relatedObjects.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(0, this.buildRelatedObject(0));
  }
  
  public RelatedObjectsNested<A> editLastRelatedObject() {
    int index = relatedObjects.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
  }
  
  public RelatedObjectsNested<A> editMatchingRelatedObject(Predicate<ObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < relatedObjects.size();i++) {
      if (predicate.test(relatedObjects.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
  }
  
  public RelatedObjectsNested<A> editRelatedObject(int index) {
    if (relatedObjects.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
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
    ComponentRouteStatusFluent that = (ComponentRouteStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(consumingUsers, that.consumingUsers))) {
      return false;
    }
    if (!(Objects.equals(currentHostnames, that.currentHostnames))) {
      return false;
    }
    if (!(Objects.equals(defaultHostname, that.defaultHostname))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespace, that.namespace))) {
      return false;
    }
    if (!(Objects.equals(relatedObjects, that.relatedObjects))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getConsumingUser(int index) {
    return this.consumingUsers.get(index);
  }
  
  public List<String> getConsumingUsers() {
    return this.consumingUsers;
  }
  
  public String getCurrentHostname(int index) {
    return this.currentHostnames.get(index);
  }
  
  public List<String> getCurrentHostnames() {
    return this.currentHostnames;
  }
  
  public String getDefaultHostname() {
    return this.defaultHostname;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public String getFirstConsumingUser() {
    return this.consumingUsers.get(0);
  }
  
  public String getFirstCurrentHostname() {
    return this.currentHostnames.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastConsumingUser() {
    return this.consumingUsers.get(consumingUsers.size() - 1);
  }
  
  public String getLastCurrentHostname() {
    return this.currentHostnames.get(currentHostnames.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingConsumingUser(Predicate<String> predicate) {
      for (String item : consumingUsers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingCurrentHostname(Predicate<String> predicate) {
      for (String item : currentHostnames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getNamespace() {
    return this.namespace;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasConsumingUsers() {
    return this.consumingUsers != null && !(this.consumingUsers.isEmpty());
  }
  
  public boolean hasCurrentHostnames() {
    return this.currentHostnames != null && !(this.currentHostnames.isEmpty());
  }
  
  public boolean hasDefaultHostname() {
    return this.defaultHostname != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingConsumingUser(Predicate<String> predicate) {
      for (String item : consumingUsers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCurrentHostname(Predicate<String> predicate) {
      for (String item : currentHostnames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRelatedObject(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : relatedObjects) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespace() {
    return this.namespace != null;
  }
  
  public boolean hasRelatedObjects() {
    return this.relatedObjects != null && !(this.relatedObjects.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, consumingUsers, currentHostnames, defaultHostname, name, namespace, relatedObjects, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromConsumingUsers(Collection<String> items) {
    if (this.consumingUsers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.consumingUsers.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromCurrentHostnames(Collection<String> items) {
    if (this.currentHostnames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.currentHostnames.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromRelatedObjects(Collection<ObjectReference> items) {
    if (this.relatedObjects == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").remove(builder);
        this.relatedObjects.remove(builder);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromConsumingUsers(String... items) {
    if (this.consumingUsers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.consumingUsers.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromCurrentHostnames(String... items) {
    if (this.currentHostnames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.currentHostnames.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromRelatedObjects(ObjectReference... items) {
    if (this.relatedObjects == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("relatedObjects").remove(builder);
        this.relatedObjects.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromRelatedObjects(Predicate<ObjectReferenceBuilder> predicate) {
    if (relatedObjects == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = relatedObjects.iterator();
    List visitables = _visitables.get("relatedObjects");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public RelatedObjectsNested<A> setNewRelatedObjectLike(int index,ObjectReference item) {
    return new RelatedObjectsNested(index, item);
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public A setToConsumingUsers(int index,String item) {
    if (this.consumingUsers == null) {
      this.consumingUsers = new ArrayList();
    }
    this.consumingUsers.set(index, item);
    return (A) this;
  }
  
  public A setToCurrentHostnames(int index,String item) {
    if (this.currentHostnames == null) {
      this.currentHostnames = new ArrayList();
    }
    this.currentHostnames.set(index, item);
    return (A) this;
  }
  
  public A setToRelatedObjects(int index,ObjectReference item) {
    if (this.relatedObjects == null) {
      this.relatedObjects = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= relatedObjects.size()) {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.add(builder);
    } else {
        _visitables.get("relatedObjects").add(builder);
        relatedObjects.set(index, builder);
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
    if (!(consumingUsers == null) && !(consumingUsers.isEmpty())) {
        sb.append("consumingUsers:");
        sb.append(consumingUsers);
        sb.append(",");
    }
    if (!(currentHostnames == null) && !(currentHostnames.isEmpty())) {
        sb.append("currentHostnames:");
        sb.append(currentHostnames);
        sb.append(",");
    }
    if (!(defaultHostname == null)) {
        sb.append("defaultHostname:");
        sb.append(defaultHostname);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespace == null)) {
        sb.append("namespace:");
        sb.append(namespace);
        sb.append(",");
    }
    if (!(relatedObjects == null) && !(relatedObjects.isEmpty())) {
        sb.append("relatedObjects:");
        sb.append(relatedObjects);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withConsumingUsers(List<String> consumingUsers) {
    if (consumingUsers != null) {
        this.consumingUsers = new ArrayList();
        for (String item : consumingUsers) {
          this.addToConsumingUsers(item);
        }
    } else {
      this.consumingUsers = null;
    }
    return (A) this;
  }
  
  public A withConsumingUsers(String... consumingUsers) {
    if (this.consumingUsers != null) {
        this.consumingUsers.clear();
        _visitables.remove("consumingUsers");
    }
    if (consumingUsers != null) {
      for (String item : consumingUsers) {
        this.addToConsumingUsers(item);
      }
    }
    return (A) this;
  }
  
  public A withCurrentHostnames(List<String> currentHostnames) {
    if (currentHostnames != null) {
        this.currentHostnames = new ArrayList();
        for (String item : currentHostnames) {
          this.addToCurrentHostnames(item);
        }
    } else {
      this.currentHostnames = null;
    }
    return (A) this;
  }
  
  public A withCurrentHostnames(String... currentHostnames) {
    if (this.currentHostnames != null) {
        this.currentHostnames.clear();
        _visitables.remove("currentHostnames");
    }
    if (currentHostnames != null) {
      for (String item : currentHostnames) {
        this.addToCurrentHostnames(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultHostname(String defaultHostname) {
    this.defaultHostname = defaultHostname;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespace(String namespace) {
    this.namespace = namespace;
    return (A) this;
  }
  
  public A withRelatedObjects(List<ObjectReference> relatedObjects) {
    if (this.relatedObjects != null) {
      this._visitables.get("relatedObjects").clear();
    }
    if (relatedObjects != null) {
        this.relatedObjects = new ArrayList();
        for (ObjectReference item : relatedObjects) {
          this.addToRelatedObjects(item);
        }
    } else {
      this.relatedObjects = null;
    }
    return (A) this;
  }
  
  public A withRelatedObjects(ObjectReference... relatedObjects) {
    if (this.relatedObjects != null) {
        this.relatedObjects.clear();
        _visitables.remove("relatedObjects");
    }
    if (relatedObjects != null) {
      for (ObjectReference item : relatedObjects) {
        this.addToRelatedObjects(item);
      }
    }
    return (A) this;
  }
  public class RelatedObjectsNested<N> extends ObjectReferenceFluent<RelatedObjectsNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    RelatedObjectsNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ComponentRouteStatusFluent.this.setToRelatedObjects(index, builder.build());
    }
    
    public N endRelatedObject() {
      return and();
    }
    
  }
}