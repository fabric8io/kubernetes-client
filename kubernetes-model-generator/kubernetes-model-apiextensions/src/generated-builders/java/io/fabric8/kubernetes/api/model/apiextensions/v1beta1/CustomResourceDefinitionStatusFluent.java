package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

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
public class CustomResourceDefinitionStatusFluent<A extends io.fabric8.kubernetes.api.model.apiextensions.v1beta1.CustomResourceDefinitionStatusFluent<A>> extends BaseFluent<A>{

  private CustomResourceDefinitionNamesBuilder acceptedNames;
  private Map<String,Object> additionalProperties;
  private ArrayList<CustomResourceDefinitionConditionBuilder> conditions = new ArrayList<CustomResourceDefinitionConditionBuilder>();
  private List<String> storedVersions = new ArrayList<String>();

  public CustomResourceDefinitionStatusFluent() {
  }
  
  public CustomResourceDefinitionStatusFluent(CustomResourceDefinitionStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<CustomResourceDefinitionCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CustomResourceDefinitionCondition item : items) {
        CustomResourceDefinitionConditionBuilder builder = new CustomResourceDefinitionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStoredVersions(Collection<String> items) {
    if (this.storedVersions == null) {
      this.storedVersions = new ArrayList();
    }
    for (String item : items) {
      this.storedVersions.add(item);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public A addNewCondition(String lastTransitionTime,String message,String reason,String status,String type) {
    return (A) this.addToConditions(new CustomResourceDefinitionCondition(lastTransitionTime, message, reason, status, type));
  }
  
  public ConditionsNested<A> addNewConditionLike(CustomResourceDefinitionCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(CustomResourceDefinitionCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (CustomResourceDefinitionCondition item : items) {
        CustomResourceDefinitionConditionBuilder builder = new CustomResourceDefinitionConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,CustomResourceDefinitionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CustomResourceDefinitionConditionBuilder builder = new CustomResourceDefinitionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStoredVersions(String... items) {
    if (this.storedVersions == null) {
      this.storedVersions = new ArrayList();
    }
    for (String item : items) {
      this.storedVersions.add(item);
    }
    return (A) this;
  }
  
  public A addToStoredVersions(int index,String item) {
    if (this.storedVersions == null) {
      this.storedVersions = new ArrayList();
    }
    this.storedVersions.add(index, item);
    return (A) this;
  }
  
  public CustomResourceDefinitionNames buildAcceptedNames() {
    return this.acceptedNames != null ? this.acceptedNames.build() : null;
  }
  
  public CustomResourceDefinitionCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<CustomResourceDefinitionCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public CustomResourceDefinitionCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public CustomResourceDefinitionCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public CustomResourceDefinitionCondition buildMatchingCondition(Predicate<CustomResourceDefinitionConditionBuilder> predicate) {
      for (CustomResourceDefinitionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(CustomResourceDefinitionStatus instance) {
    instance = instance != null ? instance : new CustomResourceDefinitionStatus();
    if (instance != null) {
        this.withAcceptedNames(instance.getAcceptedNames());
        this.withConditions(instance.getConditions());
        this.withStoredVersions(instance.getStoredVersions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AcceptedNamesNested<A> editAcceptedNames() {
    return this.withNewAcceptedNamesLike(Optional.ofNullable(this.buildAcceptedNames()).orElse(null));
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
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<CustomResourceDefinitionConditionBuilder> predicate) {
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
  
  public AcceptedNamesNested<A> editOrNewAcceptedNames() {
    return this.withNewAcceptedNamesLike(Optional.ofNullable(this.buildAcceptedNames()).orElse(new CustomResourceDefinitionNamesBuilder().build()));
  }
  
  public AcceptedNamesNested<A> editOrNewAcceptedNamesLike(CustomResourceDefinitionNames item) {
    return this.withNewAcceptedNamesLike(Optional.ofNullable(this.buildAcceptedNames()).orElse(item));
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
    CustomResourceDefinitionStatusFluent that = (CustomResourceDefinitionStatusFluent) o;
    if (!(Objects.equals(acceptedNames, that.acceptedNames))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(storedVersions, that.storedVersions))) {
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
  
  public String getFirstStoredVersion() {
    return this.storedVersions.get(0);
  }
  
  public String getLastStoredVersion() {
    return this.storedVersions.get(storedVersions.size() - 1);
  }
  
  public String getMatchingStoredVersion(Predicate<String> predicate) {
      for (String item : storedVersions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getStoredVersion(int index) {
    return this.storedVersions.get(index);
  }
  
  public List<String> getStoredVersions() {
    return this.storedVersions;
  }
  
  public boolean hasAcceptedNames() {
    return this.acceptedNames != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<CustomResourceDefinitionConditionBuilder> predicate) {
      for (CustomResourceDefinitionConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStoredVersion(Predicate<String> predicate) {
      for (String item : storedVersions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasStoredVersions() {
    return this.storedVersions != null && !(this.storedVersions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(acceptedNames, conditions, storedVersions, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<CustomResourceDefinitionCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CustomResourceDefinitionCondition item : items) {
        CustomResourceDefinitionConditionBuilder builder = new CustomResourceDefinitionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStoredVersions(Collection<String> items) {
    if (this.storedVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.storedVersions.remove(item);
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
  
  public A removeFromConditions(CustomResourceDefinitionCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (CustomResourceDefinitionCondition item : items) {
        CustomResourceDefinitionConditionBuilder builder = new CustomResourceDefinitionConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStoredVersions(String... items) {
    if (this.storedVersions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.storedVersions.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<CustomResourceDefinitionConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<CustomResourceDefinitionConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        CustomResourceDefinitionConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,CustomResourceDefinitionCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,CustomResourceDefinitionCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    CustomResourceDefinitionConditionBuilder builder = new CustomResourceDefinitionConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStoredVersions(int index,String item) {
    if (this.storedVersions == null) {
      this.storedVersions = new ArrayList();
    }
    this.storedVersions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(acceptedNames == null)) {
        sb.append("acceptedNames:");
        sb.append(acceptedNames);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(storedVersions == null) && !(storedVersions.isEmpty())) {
        sb.append("storedVersions:");
        sb.append(storedVersions);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcceptedNames(CustomResourceDefinitionNames acceptedNames) {
    this._visitables.remove("acceptedNames");
    if (acceptedNames != null) {
        this.acceptedNames = new CustomResourceDefinitionNamesBuilder(acceptedNames);
        this._visitables.get("acceptedNames").add(this.acceptedNames);
    } else {
        this.acceptedNames = null;
        this._visitables.get("acceptedNames").remove(this.acceptedNames);
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
  
  public A withConditions(List<CustomResourceDefinitionCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (CustomResourceDefinitionCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(CustomResourceDefinitionCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (CustomResourceDefinitionCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public AcceptedNamesNested<A> withNewAcceptedNames() {
    return new AcceptedNamesNested(null);
  }
  
  public AcceptedNamesNested<A> withNewAcceptedNamesLike(CustomResourceDefinitionNames item) {
    return new AcceptedNamesNested(item);
  }
  
  public A withStoredVersions(List<String> storedVersions) {
    if (storedVersions != null) {
        this.storedVersions = new ArrayList();
        for (String item : storedVersions) {
          this.addToStoredVersions(item);
        }
    } else {
      this.storedVersions = null;
    }
    return (A) this;
  }
  
  public A withStoredVersions(String... storedVersions) {
    if (this.storedVersions != null) {
        this.storedVersions.clear();
        _visitables.remove("storedVersions");
    }
    if (storedVersions != null) {
      for (String item : storedVersions) {
        this.addToStoredVersions(item);
      }
    }
    return (A) this;
  }
  public class AcceptedNamesNested<N> extends CustomResourceDefinitionNamesFluent<AcceptedNamesNested<N>> implements Nested<N>{
  
    CustomResourceDefinitionNamesBuilder builder;
  
    AcceptedNamesNested(CustomResourceDefinitionNames item) {
      this.builder = new CustomResourceDefinitionNamesBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionStatusFluent.this.withAcceptedNames(builder.build());
    }
    
    public N endAcceptedNames() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends CustomResourceDefinitionConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    CustomResourceDefinitionConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,CustomResourceDefinitionCondition item) {
      this.index = index;
      this.builder = new CustomResourceDefinitionConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) CustomResourceDefinitionStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}