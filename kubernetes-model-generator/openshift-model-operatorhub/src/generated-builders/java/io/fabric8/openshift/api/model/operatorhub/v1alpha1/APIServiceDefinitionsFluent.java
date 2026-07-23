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
public class APIServiceDefinitionsFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.APIServiceDefinitionsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<APIServiceDescriptionBuilder> owned = new ArrayList<APIServiceDescriptionBuilder>();
  private ArrayList<APIServiceDescriptionBuilder> required = new ArrayList<APIServiceDescriptionBuilder>();

  public APIServiceDefinitionsFluent() {
  }
  
  public APIServiceDefinitionsFluent(APIServiceDefinitions instance) {
    this.copyInstance(instance);
  }

  public A addAllToOwned(Collection<APIServiceDescription> items) {
    if (this.owned == null) {
      this.owned = new ArrayList();
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("owned").add(builder);
        this.owned.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRequired(Collection<APIServiceDescription> items) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("required").add(builder);
        this.required.add(builder);
    }
    return (A) this;
  }
  
  public OwnedNested<A> addNewOwned() {
    return new OwnedNested(-1, null);
  }
  
  public OwnedNested<A> addNewOwnedLike(APIServiceDescription item) {
    return new OwnedNested(-1, item);
  }
  
  public RequiredNested<A> addNewRequired() {
    return new RequiredNested(-1, null);
  }
  
  public RequiredNested<A> addNewRequiredLike(APIServiceDescription item) {
    return new RequiredNested(-1, item);
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
  
  public A addToOwned(APIServiceDescription... items) {
    if (this.owned == null) {
      this.owned = new ArrayList();
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("owned").add(builder);
        this.owned.add(builder);
    }
    return (A) this;
  }
  
  public A addToOwned(int index,APIServiceDescription item) {
    if (this.owned == null) {
      this.owned = new ArrayList();
    }
    APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
    if (index < 0 || index >= owned.size()) {
        _visitables.get("owned").add(builder);
        owned.add(builder);
    } else {
        _visitables.get("owned").add(builder);
        owned.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRequired(APIServiceDescription... items) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("required").add(builder);
        this.required.add(builder);
    }
    return (A) this;
  }
  
  public A addToRequired(int index,APIServiceDescription item) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
    if (index < 0 || index >= required.size()) {
        _visitables.get("required").add(builder);
        required.add(builder);
    } else {
        _visitables.get("required").add(builder);
        required.add(index, builder);
    }
    return (A) this;
  }
  
  public APIServiceDescription buildFirstOwned() {
    return this.owned.get(0).build();
  }
  
  public APIServiceDescription buildFirstRequired() {
    return this.required.get(0).build();
  }
  
  public APIServiceDescription buildLastOwned() {
    return this.owned.get(owned.size() - 1).build();
  }
  
  public APIServiceDescription buildLastRequired() {
    return this.required.get(required.size() - 1).build();
  }
  
  public APIServiceDescription buildMatchingOwned(Predicate<APIServiceDescriptionBuilder> predicate) {
      for (APIServiceDescriptionBuilder item : owned) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public APIServiceDescription buildMatchingRequired(Predicate<APIServiceDescriptionBuilder> predicate) {
      for (APIServiceDescriptionBuilder item : required) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<APIServiceDescription> buildOwned() {
    return this.owned != null ? build(owned) : null;
  }
  
  public APIServiceDescription buildOwned(int index) {
    return this.owned.get(index).build();
  }
  
  public List<APIServiceDescription> buildRequired() {
    return this.required != null ? build(required) : null;
  }
  
  public APIServiceDescription buildRequired(int index) {
    return this.required.get(index).build();
  }
  
  protected void copyInstance(APIServiceDefinitions instance) {
    instance = instance != null ? instance : new APIServiceDefinitions();
    if (instance != null) {
        this.withOwned(instance.getOwned());
        this.withRequired(instance.getRequired());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public OwnedNested<A> editFirstOwned() {
    if (owned.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "owned"));
    }
    return this.setNewOwnedLike(0, this.buildOwned(0));
  }
  
  public RequiredNested<A> editFirstRequired() {
    if (required.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "required"));
    }
    return this.setNewRequiredLike(0, this.buildRequired(0));
  }
  
  public OwnedNested<A> editLastOwned() {
    int index = owned.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "owned"));
    }
    return this.setNewOwnedLike(index, this.buildOwned(index));
  }
  
  public RequiredNested<A> editLastRequired() {
    int index = required.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "required"));
    }
    return this.setNewRequiredLike(index, this.buildRequired(index));
  }
  
  public OwnedNested<A> editMatchingOwned(Predicate<APIServiceDescriptionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < owned.size();i++) {
      if (predicate.test(owned.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "owned"));
    }
    return this.setNewOwnedLike(index, this.buildOwned(index));
  }
  
  public RequiredNested<A> editMatchingRequired(Predicate<APIServiceDescriptionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < required.size();i++) {
      if (predicate.test(required.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "required"));
    }
    return this.setNewRequiredLike(index, this.buildRequired(index));
  }
  
  public OwnedNested<A> editOwned(int index) {
    if (owned.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "owned"));
    }
    return this.setNewOwnedLike(index, this.buildOwned(index));
  }
  
  public RequiredNested<A> editRequired(int index) {
    if (required.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "required"));
    }
    return this.setNewRequiredLike(index, this.buildRequired(index));
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
    APIServiceDefinitionsFluent that = (APIServiceDefinitionsFluent) o;
    if (!(Objects.equals(owned, that.owned))) {
      return false;
    }
    if (!(Objects.equals(required, that.required))) {
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
  
  public boolean hasMatchingOwned(Predicate<APIServiceDescriptionBuilder> predicate) {
      for (APIServiceDescriptionBuilder item : owned) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRequired(Predicate<APIServiceDescriptionBuilder> predicate) {
      for (APIServiceDescriptionBuilder item : required) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOwned() {
    return this.owned != null && !(this.owned.isEmpty());
  }
  
  public boolean hasRequired() {
    return this.required != null && !(this.required.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(owned, required, additionalProperties);
  }
  
  public A removeAllFromOwned(Collection<APIServiceDescription> items) {
    if (this.owned == null) {
      return (A) this;
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("owned").remove(builder);
        this.owned.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRequired(Collection<APIServiceDescription> items) {
    if (this.required == null) {
      return (A) this;
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("required").remove(builder);
        this.required.remove(builder);
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
  
  public A removeFromOwned(APIServiceDescription... items) {
    if (this.owned == null) {
      return (A) this;
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("owned").remove(builder);
        this.owned.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRequired(APIServiceDescription... items) {
    if (this.required == null) {
      return (A) this;
    }
    for (APIServiceDescription item : items) {
        APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
        _visitables.get("required").remove(builder);
        this.required.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromOwned(Predicate<APIServiceDescriptionBuilder> predicate) {
    if (owned == null) {
      return (A) this;
    }
    Iterator<APIServiceDescriptionBuilder> each = owned.iterator();
    List visitables = _visitables.get("owned");
    while (each.hasNext()) {
        APIServiceDescriptionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRequired(Predicate<APIServiceDescriptionBuilder> predicate) {
    if (required == null) {
      return (A) this;
    }
    Iterator<APIServiceDescriptionBuilder> each = required.iterator();
    List visitables = _visitables.get("required");
    while (each.hasNext()) {
        APIServiceDescriptionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public OwnedNested<A> setNewOwnedLike(int index,APIServiceDescription item) {
    return new OwnedNested(index, item);
  }
  
  public RequiredNested<A> setNewRequiredLike(int index,APIServiceDescription item) {
    return new RequiredNested(index, item);
  }
  
  public A setToOwned(int index,APIServiceDescription item) {
    if (this.owned == null) {
      this.owned = new ArrayList();
    }
    APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
    if (index < 0 || index >= owned.size()) {
        _visitables.get("owned").add(builder);
        owned.add(builder);
    } else {
        _visitables.get("owned").add(builder);
        owned.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRequired(int index,APIServiceDescription item) {
    if (this.required == null) {
      this.required = new ArrayList();
    }
    APIServiceDescriptionBuilder builder = new APIServiceDescriptionBuilder(item);
    if (index < 0 || index >= required.size()) {
        _visitables.get("required").add(builder);
        required.add(builder);
    } else {
        _visitables.get("required").add(builder);
        required.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(owned == null) && !(owned.isEmpty())) {
        sb.append("owned:");
        sb.append(owned);
        sb.append(",");
    }
    if (!(required == null) && !(required.isEmpty())) {
        sb.append("required:");
        sb.append(required);
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
  
  public A withOwned(List<APIServiceDescription> owned) {
    if (this.owned != null) {
      this._visitables.get("owned").clear();
    }
    if (owned != null) {
        this.owned = new ArrayList();
        for (APIServiceDescription item : owned) {
          this.addToOwned(item);
        }
    } else {
      this.owned = null;
    }
    return (A) this;
  }
  
  public A withOwned(APIServiceDescription... owned) {
    if (this.owned != null) {
        this.owned.clear();
        _visitables.remove("owned");
    }
    if (owned != null) {
      for (APIServiceDescription item : owned) {
        this.addToOwned(item);
      }
    }
    return (A) this;
  }
  
  public A withRequired(List<APIServiceDescription> required) {
    if (this.required != null) {
      this._visitables.get("required").clear();
    }
    if (required != null) {
        this.required = new ArrayList();
        for (APIServiceDescription item : required) {
          this.addToRequired(item);
        }
    } else {
      this.required = null;
    }
    return (A) this;
  }
  
  public A withRequired(APIServiceDescription... required) {
    if (this.required != null) {
        this.required.clear();
        _visitables.remove("required");
    }
    if (required != null) {
      for (APIServiceDescription item : required) {
        this.addToRequired(item);
      }
    }
    return (A) this;
  }
  public class OwnedNested<N> extends APIServiceDescriptionFluent<OwnedNested<N>> implements Nested<N>{
  
    APIServiceDescriptionBuilder builder;
    int index;
  
    OwnedNested(int index,APIServiceDescription item) {
      this.index = index;
      this.builder = new APIServiceDescriptionBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServiceDefinitionsFluent.this.setToOwned(index, builder.build());
    }
    
    public N endOwned() {
      return and();
    }
    
  }
  public class RequiredNested<N> extends APIServiceDescriptionFluent<RequiredNested<N>> implements Nested<N>{
  
    APIServiceDescriptionBuilder builder;
    int index;
  
    RequiredNested(int index,APIServiceDescription item) {
      this.index = index;
      this.builder = new APIServiceDescriptionBuilder(this, item);
    }
  
    public N and() {
      return (N) APIServiceDefinitionsFluent.this.setToRequired(index, builder.build());
    }
    
    public N endRequired() {
      return and();
    }
    
  }
}