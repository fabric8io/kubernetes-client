package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachineOSBuildStatusFluent<A extends io.fabric8.openshift.api.model.machineconfiguration.v1.MachineOSBuildStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String buildEnd;
  private String buildStart;
  private MachineOSBuilderReferenceBuilder builder;
  private List<Condition> conditions = new ArrayList<Condition>();
  private String digestedImagePushSpec;
  private ArrayList<ObjectReferenceBuilder> relatedObjects = new ArrayList<ObjectReferenceBuilder>();

  public MachineOSBuildStatusFluent() {
  }
  
  public MachineOSBuildStatusFluent(MachineOSBuildStatus instance) {
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
  
  public MachineOSBuilderReference buildBuilder() {
    return this.builder != null ? this.builder.build() : null;
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
  
  protected void copyInstance(MachineOSBuildStatus instance) {
    instance = instance != null ? instance : new MachineOSBuildStatus();
    if (instance != null) {
        this.withBuildEnd(instance.getBuildEnd());
        this.withBuildStart(instance.getBuildStart());
        this.withBuilder(instance.getBuilder());
        this.withConditions(instance.getConditions());
        this.withDigestedImagePushSpec(instance.getDigestedImagePushSpec());
        this.withRelatedObjects(instance.getRelatedObjects());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BuilderNested<A> editBuilder() {
    return this.withNewBuilderLike(Optional.ofNullable(this.buildBuilder()).orElse(null));
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
  
  public BuilderNested<A> editOrNewBuilder() {
    return this.withNewBuilderLike(Optional.ofNullable(this.buildBuilder()).orElse(new MachineOSBuilderReferenceBuilder().build()));
  }
  
  public BuilderNested<A> editOrNewBuilderLike(MachineOSBuilderReference item) {
    return this.withNewBuilderLike(Optional.ofNullable(this.buildBuilder()).orElse(item));
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
    MachineOSBuildStatusFluent that = (MachineOSBuildStatusFluent) o;
    if (!(Objects.equals(buildEnd, that.buildEnd))) {
      return false;
    }
    if (!(Objects.equals(buildStart, that.buildStart))) {
      return false;
    }
    if (!(Objects.equals(builder, that.builder))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(digestedImagePushSpec, that.digestedImagePushSpec))) {
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
  
  public String getBuildEnd() {
    return this.buildEnd;
  }
  
  public String getBuildStart() {
    return this.buildStart;
  }
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public String getDigestedImagePushSpec() {
    return this.digestedImagePushSpec;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBuildEnd() {
    return this.buildEnd != null;
  }
  
  public boolean hasBuildStart() {
    return this.buildStart != null;
  }
  
  public boolean hasBuilder() {
    return this.builder != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasDigestedImagePushSpec() {
    return this.digestedImagePushSpec != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
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
  
  public boolean hasRelatedObjects() {
    return this.relatedObjects != null && !(this.relatedObjects.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(buildEnd, buildStart, builder, conditions, digestedImagePushSpec, relatedObjects, additionalProperties);
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
    if (!(buildEnd == null)) {
        sb.append("buildEnd:");
        sb.append(buildEnd);
        sb.append(",");
    }
    if (!(buildStart == null)) {
        sb.append("buildStart:");
        sb.append(buildStart);
        sb.append(",");
    }
    if (!(builder == null)) {
        sb.append("builder:");
        sb.append(builder);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(digestedImagePushSpec == null)) {
        sb.append("digestedImagePushSpec:");
        sb.append(digestedImagePushSpec);
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
  
  public A withBuildEnd(String buildEnd) {
    this.buildEnd = buildEnd;
    return (A) this;
  }
  
  public A withBuildStart(String buildStart) {
    this.buildStart = buildStart;
    return (A) this;
  }
  
  public A withBuilder(MachineOSBuilderReference builder) {
    this._visitables.remove("builder");
    if (builder != null) {
        this.builder = new MachineOSBuilderReferenceBuilder(builder);
        this._visitables.get("builder").add(this.builder);
    } else {
        this.builder = null;
        this._visitables.get("builder").remove(this.builder);
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
  
  public A withDigestedImagePushSpec(String digestedImagePushSpec) {
    this.digestedImagePushSpec = digestedImagePushSpec;
    return (A) this;
  }
  
  public BuilderNested<A> withNewBuilder() {
    return new BuilderNested(null);
  }
  
  public BuilderNested<A> withNewBuilderLike(MachineOSBuilderReference item) {
    return new BuilderNested(item);
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
  public class BuilderNested<N> extends MachineOSBuilderReferenceFluent<BuilderNested<N>> implements Nested<N>{
  
    MachineOSBuilderReferenceBuilder builder;
  
    BuilderNested(MachineOSBuilderReference item) {
      this.builder = new MachineOSBuilderReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineOSBuildStatusFluent.this.withBuilder(builder.build());
    }
    
    public N endBuilder() {
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
      return (N) MachineOSBuildStatusFluent.this.setToRelatedObjects(index, builder.build());
    }
    
    public N endRelatedObject() {
      return and();
    }
    
  }
}