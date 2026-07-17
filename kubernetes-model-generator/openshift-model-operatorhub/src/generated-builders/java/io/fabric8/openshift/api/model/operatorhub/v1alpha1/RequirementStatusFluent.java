package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class RequirementStatusFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.RequirementStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<DependentStatusBuilder> dependents = new ArrayList<DependentStatusBuilder>();
  private String group;
  private String kind;
  private String message;
  private String name;
  private String status;
  private String uuid;
  private String version;

  public RequirementStatusFluent() {
  }
  
  public RequirementStatusFluent(RequirementStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToDependents(Collection<DependentStatus> items) {
    if (this.dependents == null) {
      this.dependents = new ArrayList();
    }
    for (DependentStatus item : items) {
        DependentStatusBuilder builder = new DependentStatusBuilder(item);
        _visitables.get("dependents").add(builder);
        this.dependents.add(builder);
    }
    return (A) this;
  }
  
  public DependentsNested<A> addNewDependent() {
    return new DependentsNested(-1, null);
  }
  
  public DependentsNested<A> addNewDependentLike(DependentStatus item) {
    return new DependentsNested(-1, item);
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
  
  public A addToDependents(DependentStatus... items) {
    if (this.dependents == null) {
      this.dependents = new ArrayList();
    }
    for (DependentStatus item : items) {
        DependentStatusBuilder builder = new DependentStatusBuilder(item);
        _visitables.get("dependents").add(builder);
        this.dependents.add(builder);
    }
    return (A) this;
  }
  
  public A addToDependents(int index,DependentStatus item) {
    if (this.dependents == null) {
      this.dependents = new ArrayList();
    }
    DependentStatusBuilder builder = new DependentStatusBuilder(item);
    if (index < 0 || index >= dependents.size()) {
        _visitables.get("dependents").add(builder);
        dependents.add(builder);
    } else {
        _visitables.get("dependents").add(builder);
        dependents.add(index, builder);
    }
    return (A) this;
  }
  
  public DependentStatus buildDependent(int index) {
    return this.dependents.get(index).build();
  }
  
  public List<DependentStatus> buildDependents() {
    return this.dependents != null ? build(dependents) : null;
  }
  
  public DependentStatus buildFirstDependent() {
    return this.dependents.get(0).build();
  }
  
  public DependentStatus buildLastDependent() {
    return this.dependents.get(dependents.size() - 1).build();
  }
  
  public DependentStatus buildMatchingDependent(Predicate<DependentStatusBuilder> predicate) {
      for (DependentStatusBuilder item : dependents) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RequirementStatus instance) {
    instance = instance != null ? instance : new RequirementStatus();
    if (instance != null) {
        this.withDependents(instance.getDependents());
        this.withGroup(instance.getGroup());
        this.withKind(instance.getKind());
        this.withMessage(instance.getMessage());
        this.withName(instance.getName());
        this.withStatus(instance.getStatus());
        this.withUuid(instance.getUuid());
        this.withVersion(instance.getVersion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DependentsNested<A> editDependent(int index) {
    if (dependents.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "dependents"));
    }
    return this.setNewDependentLike(index, this.buildDependent(index));
  }
  
  public DependentsNested<A> editFirstDependent() {
    if (dependents.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "dependents"));
    }
    return this.setNewDependentLike(0, this.buildDependent(0));
  }
  
  public DependentsNested<A> editLastDependent() {
    int index = dependents.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "dependents"));
    }
    return this.setNewDependentLike(index, this.buildDependent(index));
  }
  
  public DependentsNested<A> editMatchingDependent(Predicate<DependentStatusBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < dependents.size();i++) {
      if (predicate.test(dependents.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "dependents"));
    }
    return this.setNewDependentLike(index, this.buildDependent(index));
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
    RequirementStatusFluent that = (RequirementStatusFluent) o;
    if (!(Objects.equals(dependents, that.dependents))) {
      return false;
    }
    if (!(Objects.equals(group, that.group))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(status, that.status))) {
      return false;
    }
    if (!(Objects.equals(uuid, that.uuid))) {
      return false;
    }
    if (!(Objects.equals(version, that.version))) {
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
  
  public String getMessage() {
    return this.message;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  public String getUuid() {
    return this.uuid;
  }
  
  public String getVersion() {
    return this.version;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDependents() {
    return this.dependents != null && !(this.dependents.isEmpty());
  }
  
  public boolean hasGroup() {
    return this.group != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingDependent(Predicate<DependentStatusBuilder> predicate) {
      for (DependentStatusBuilder item : dependents) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasStatus() {
    return this.status != null;
  }
  
  public boolean hasUuid() {
    return this.uuid != null;
  }
  
  public boolean hasVersion() {
    return this.version != null;
  }
  
  public int hashCode() {
    return Objects.hash(dependents, group, kind, message, name, status, uuid, version, additionalProperties);
  }
  
  public A removeAllFromDependents(Collection<DependentStatus> items) {
    if (this.dependents == null) {
      return (A) this;
    }
    for (DependentStatus item : items) {
        DependentStatusBuilder builder = new DependentStatusBuilder(item);
        _visitables.get("dependents").remove(builder);
        this.dependents.remove(builder);
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
  
  public A removeFromDependents(DependentStatus... items) {
    if (this.dependents == null) {
      return (A) this;
    }
    for (DependentStatus item : items) {
        DependentStatusBuilder builder = new DependentStatusBuilder(item);
        _visitables.get("dependents").remove(builder);
        this.dependents.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDependents(Predicate<DependentStatusBuilder> predicate) {
    if (dependents == null) {
      return (A) this;
    }
    Iterator<DependentStatusBuilder> each = dependents.iterator();
    List visitables = _visitables.get("dependents");
    while (each.hasNext()) {
        DependentStatusBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DependentsNested<A> setNewDependentLike(int index,DependentStatus item) {
    return new DependentsNested(index, item);
  }
  
  public A setToDependents(int index,DependentStatus item) {
    if (this.dependents == null) {
      this.dependents = new ArrayList();
    }
    DependentStatusBuilder builder = new DependentStatusBuilder(item);
    if (index < 0 || index >= dependents.size()) {
        _visitables.get("dependents").add(builder);
        dependents.add(builder);
    } else {
        _visitables.get("dependents").add(builder);
        dependents.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(dependents == null) && !(dependents.isEmpty())) {
        sb.append("dependents:");
        sb.append(dependents);
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
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(status == null)) {
        sb.append("status:");
        sb.append(status);
        sb.append(",");
    }
    if (!(uuid == null)) {
        sb.append("uuid:");
        sb.append(uuid);
        sb.append(",");
    }
    if (!(version == null)) {
        sb.append("version:");
        sb.append(version);
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
  
  public A withDependents(List<DependentStatus> dependents) {
    if (this.dependents != null) {
      this._visitables.get("dependents").clear();
    }
    if (dependents != null) {
        this.dependents = new ArrayList();
        for (DependentStatus item : dependents) {
          this.addToDependents(item);
        }
    } else {
      this.dependents = null;
    }
    return (A) this;
  }
  
  public A withDependents(DependentStatus... dependents) {
    if (this.dependents != null) {
        this.dependents.clear();
        _visitables.remove("dependents");
    }
    if (dependents != null) {
      for (DependentStatus item : dependents) {
        this.addToDependents(item);
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
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withStatus(String status) {
    this.status = status;
    return (A) this;
  }
  
  public A withUuid(String uuid) {
    this.uuid = uuid;
    return (A) this;
  }
  
  public A withVersion(String version) {
    this.version = version;
    return (A) this;
  }
  public class DependentsNested<N> extends DependentStatusFluent<DependentsNested<N>> implements Nested<N>{
  
    DependentStatusBuilder builder;
    int index;
  
    DependentsNested(int index,DependentStatus item) {
      this.index = index;
      this.builder = new DependentStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) RequirementStatusFluent.this.setToDependents(index, builder.build());
    }
    
    public N endDependent() {
      return and();
    }
    
  }
}