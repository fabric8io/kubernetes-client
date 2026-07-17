package io.fabric8.openshift.api.model.config.v1;

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
public class ClusterOperatorStatusFluent<A extends io.fabric8.openshift.api.model.config.v1.ClusterOperatorStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterOperatorStatusConditionBuilder> conditions = new ArrayList<ClusterOperatorStatusConditionBuilder>();
  private Object extension;
  private ArrayList<ObjectReferenceBuilder> relatedObjects = new ArrayList<ObjectReferenceBuilder>();
  private ArrayList<OperandVersionBuilder> versions = new ArrayList<OperandVersionBuilder>();

  public ClusterOperatorStatusFluent() {
  }
  
  public ClusterOperatorStatusFluent(ClusterOperatorStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<ClusterOperatorStatusCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
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
  
  public A addAllToVersions(Collection<OperandVersion> items) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    for (OperandVersion item : items) {
        OperandVersionBuilder builder = new OperandVersionBuilder(item);
        _visitables.get("versions").add(builder);
        this.versions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new ClusterOperatorStatusCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(ClusterOperatorStatusCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public VersionsNested<A> addNewVersion() {
    return new VersionsNested(-1, null);
  }
  
  public A addNewVersion(String name,String version) {
    return (A) this.addToVersions(new OperandVersion(name, version));
  }
  
  public VersionsNested<A> addNewVersionLike(OperandVersion item) {
    return new VersionsNested(-1, item);
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
  
  public A addToConditions(ClusterOperatorStatusCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,ClusterOperatorStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
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
  
  public A addToVersions(OperandVersion... items) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    for (OperandVersion item : items) {
        OperandVersionBuilder builder = new OperandVersionBuilder(item);
        _visitables.get("versions").add(builder);
        this.versions.add(builder);
    }
    return (A) this;
  }
  
  public A addToVersions(int index,OperandVersion item) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    OperandVersionBuilder builder = new OperandVersionBuilder(item);
    if (index < 0 || index >= versions.size()) {
        _visitables.get("versions").add(builder);
        versions.add(builder);
    } else {
        _visitables.get("versions").add(builder);
        versions.add(index, builder);
    }
    return (A) this;
  }
  
  public ClusterOperatorStatusCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<ClusterOperatorStatusCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public ClusterOperatorStatusCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public ObjectReference buildFirstRelatedObject() {
    return this.relatedObjects.get(0).build();
  }
  
  public OperandVersion buildFirstVersion() {
    return this.versions.get(0).build();
  }
  
  public ClusterOperatorStatusCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public ObjectReference buildLastRelatedObject() {
    return this.relatedObjects.get(relatedObjects.size() - 1).build();
  }
  
  public OperandVersion buildLastVersion() {
    return this.versions.get(versions.size() - 1).build();
  }
  
  public ClusterOperatorStatusCondition buildMatchingCondition(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
      for (ClusterOperatorStatusConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildMatchingRelatedObject(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : relatedObjects) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OperandVersion buildMatchingVersion(Predicate<OperandVersionBuilder> predicate) {
      for (OperandVersionBuilder item : versions) {
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
  
  public OperandVersion buildVersion(int index) {
    return this.versions.get(index).build();
  }
  
  public List<OperandVersion> buildVersions() {
    return this.versions != null ? build(versions) : null;
  }
  
  protected void copyInstance(ClusterOperatorStatus instance) {
    instance = instance != null ? instance : new ClusterOperatorStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withExtension(instance.getExtension());
        this.withRelatedObjects(instance.getRelatedObjects());
        this.withVersions(instance.getVersions());
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
  
  public RelatedObjectsNested<A> editFirstRelatedObject() {
    if (relatedObjects.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(0, this.buildRelatedObject(0));
  }
  
  public VersionsNested<A> editFirstVersion() {
    if (versions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(0, this.buildVersion(0));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public RelatedObjectsNested<A> editLastRelatedObject() {
    int index = relatedObjects.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
  }
  
  public VersionsNested<A> editLastVersion() {
    int index = versions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
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
  
  public VersionsNested<A> editMatchingVersion(Predicate<OperandVersionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < versions.size();i++) {
      if (predicate.test(versions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
  }
  
  public RelatedObjectsNested<A> editRelatedObject(int index) {
    if (relatedObjects.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "relatedObjects"));
    }
    return this.setNewRelatedObjectLike(index, this.buildRelatedObject(index));
  }
  
  public VersionsNested<A> editVersion(int index) {
    if (versions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
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
    ClusterOperatorStatusFluent that = (ClusterOperatorStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(extension, that.extension))) {
      return false;
    }
    if (!(Objects.equals(relatedObjects, that.relatedObjects))) {
      return false;
    }
    if (!(Objects.equals(versions, that.versions))) {
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
  
  public Object getExtension() {
    return this.extension;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasExtension() {
    return this.extension != null;
  }
  
  public boolean hasMatchingCondition(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
      for (ClusterOperatorStatusConditionBuilder item : conditions) {
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
  
  public boolean hasMatchingVersion(Predicate<OperandVersionBuilder> predicate) {
      for (OperandVersionBuilder item : versions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRelatedObjects() {
    return this.relatedObjects != null && !(this.relatedObjects.isEmpty());
  }
  
  public boolean hasVersions() {
    return this.versions != null && !(this.versions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(conditions, extension, relatedObjects, versions, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<ClusterOperatorStatusCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeAllFromVersions(Collection<OperandVersion> items) {
    if (this.versions == null) {
      return (A) this;
    }
    for (OperandVersion item : items) {
        OperandVersionBuilder builder = new OperandVersionBuilder(item);
        _visitables.get("versions").remove(builder);
        this.versions.remove(builder);
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
  
  public A removeFromConditions(ClusterOperatorStatusCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (ClusterOperatorStatusCondition item : items) {
        ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromVersions(OperandVersion... items) {
    if (this.versions == null) {
      return (A) this;
    }
    for (OperandVersion item : items) {
        OperandVersionBuilder builder = new OperandVersionBuilder(item);
        _visitables.get("versions").remove(builder);
        this.versions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<ClusterOperatorStatusConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<ClusterOperatorStatusConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        ClusterOperatorStatusConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public A removeMatchingFromVersions(Predicate<OperandVersionBuilder> predicate) {
    if (versions == null) {
      return (A) this;
    }
    Iterator<OperandVersionBuilder> each = versions.iterator();
    List visitables = _visitables.get("versions");
    while (each.hasNext()) {
        OperandVersionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,ClusterOperatorStatusCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public RelatedObjectsNested<A> setNewRelatedObjectLike(int index,ObjectReference item) {
    return new RelatedObjectsNested(index, item);
  }
  
  public VersionsNested<A> setNewVersionLike(int index,OperandVersion item) {
    return new VersionsNested(index, item);
  }
  
  public A setToConditions(int index,ClusterOperatorStatusCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    ClusterOperatorStatusConditionBuilder builder = new ClusterOperatorStatusConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
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
  
  public A setToVersions(int index,OperandVersion item) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    OperandVersionBuilder builder = new OperandVersionBuilder(item);
    if (index < 0 || index >= versions.size()) {
        _visitables.get("versions").add(builder);
        versions.add(builder);
    } else {
        _visitables.get("versions").add(builder);
        versions.set(index, builder);
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
    if (!(extension == null)) {
        sb.append("extension:");
        sb.append(extension);
        sb.append(",");
    }
    if (!(relatedObjects == null) && !(relatedObjects.isEmpty())) {
        sb.append("relatedObjects:");
        sb.append(relatedObjects);
        sb.append(",");
    }
    if (!(versions == null) && !(versions.isEmpty())) {
        sb.append("versions:");
        sb.append(versions);
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
  
  public A withConditions(List<ClusterOperatorStatusCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (ClusterOperatorStatusCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(ClusterOperatorStatusCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (ClusterOperatorStatusCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withExtension(Object extension) {
    this.extension = extension;
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
  
  public A withVersions(List<OperandVersion> versions) {
    if (this.versions != null) {
      this._visitables.get("versions").clear();
    }
    if (versions != null) {
        this.versions = new ArrayList();
        for (OperandVersion item : versions) {
          this.addToVersions(item);
        }
    } else {
      this.versions = null;
    }
    return (A) this;
  }
  
  public A withVersions(OperandVersion... versions) {
    if (this.versions != null) {
        this.versions.clear();
        _visitables.remove("versions");
    }
    if (versions != null) {
      for (OperandVersion item : versions) {
        this.addToVersions(item);
      }
    }
    return (A) this;
  }
  public class ConditionsNested<N> extends ClusterOperatorStatusConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    ClusterOperatorStatusConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,ClusterOperatorStatusCondition item) {
      this.index = index;
      this.builder = new ClusterOperatorStatusConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterOperatorStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class RelatedObjectsNested<N> extends ObjectReferenceFluent<RelatedObjectsNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    RelatedObjectsNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterOperatorStatusFluent.this.setToRelatedObjects(index, builder.build());
    }
    
    public N endRelatedObject() {
      return and();
    }
    
  }
  public class VersionsNested<N> extends OperandVersionFluent<VersionsNested<N>> implements Nested<N>{
  
    OperandVersionBuilder builder;
    int index;
  
    VersionsNested(int index,OperandVersion item) {
      this.index = index;
      this.builder = new OperandVersionBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterOperatorStatusFluent.this.setToVersions(index, builder.build());
    }
    
    public N endVersion() {
      return and();
    }
    
  }
}