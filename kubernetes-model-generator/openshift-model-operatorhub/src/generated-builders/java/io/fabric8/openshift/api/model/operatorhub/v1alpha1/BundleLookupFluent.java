package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class BundleLookupFluent<A extends io.fabric8.openshift.api.model.operatorhub.v1alpha1.BundleLookupFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ObjectReferenceBuilder catalogSourceRef;
  private ArrayList<BundleLookupConditionBuilder> conditions = new ArrayList<BundleLookupConditionBuilder>();
  private String identifier;
  private String path;
  private String properties;
  private String replaces;

  public BundleLookupFluent() {
  }
  
  public BundleLookupFluent(BundleLookup instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<BundleLookupCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (BundleLookupCondition item : items) {
        BundleLookupConditionBuilder builder = new BundleLookupConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(BundleLookupCondition item) {
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
  
  public A addToConditions(BundleLookupCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (BundleLookupCondition item : items) {
        BundleLookupConditionBuilder builder = new BundleLookupConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,BundleLookupCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    BundleLookupConditionBuilder builder = new BundleLookupConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public ObjectReference buildCatalogSourceRef() {
    return this.catalogSourceRef != null ? this.catalogSourceRef.build() : null;
  }
  
  public BundleLookupCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<BundleLookupCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public BundleLookupCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public BundleLookupCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public BundleLookupCondition buildMatchingCondition(Predicate<BundleLookupConditionBuilder> predicate) {
      for (BundleLookupConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(BundleLookup instance) {
    instance = instance != null ? instance : new BundleLookup();
    if (instance != null) {
        this.withCatalogSourceRef(instance.getCatalogSourceRef());
        this.withConditions(instance.getConditions());
        this.withIdentifier(instance.getIdentifier());
        this.withPath(instance.getPath());
        this.withProperties(instance.getProperties());
        this.withReplaces(instance.getReplaces());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CatalogSourceRefNested<A> editCatalogSourceRef() {
    return this.withNewCatalogSourceRefLike(Optional.ofNullable(this.buildCatalogSourceRef()).orElse(null));
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<BundleLookupConditionBuilder> predicate) {
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
  
  public CatalogSourceRefNested<A> editOrNewCatalogSourceRef() {
    return this.withNewCatalogSourceRefLike(Optional.ofNullable(this.buildCatalogSourceRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public CatalogSourceRefNested<A> editOrNewCatalogSourceRefLike(ObjectReference item) {
    return this.withNewCatalogSourceRefLike(Optional.ofNullable(this.buildCatalogSourceRef()).orElse(item));
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
    BundleLookupFluent that = (BundleLookupFluent) o;
    if (!(Objects.equals(catalogSourceRef, that.catalogSourceRef))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(identifier, that.identifier))) {
      return false;
    }
    if (!(Objects.equals(path, that.path))) {
      return false;
    }
    if (!(Objects.equals(properties, that.properties))) {
      return false;
    }
    if (!(Objects.equals(replaces, that.replaces))) {
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
  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public String getPath() {
    return this.path;
  }
  
  public String getProperties() {
    return this.properties;
  }
  
  public String getReplaces() {
    return this.replaces;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCatalogSourceRef() {
    return this.catalogSourceRef != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasIdentifier() {
    return this.identifier != null;
  }
  
  public boolean hasMatchingCondition(Predicate<BundleLookupConditionBuilder> predicate) {
      for (BundleLookupConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPath() {
    return this.path != null;
  }
  
  public boolean hasProperties() {
    return this.properties != null;
  }
  
  public boolean hasReplaces() {
    return this.replaces != null;
  }
  
  public int hashCode() {
    return Objects.hash(catalogSourceRef, conditions, identifier, path, properties, replaces, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<BundleLookupCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (BundleLookupCondition item : items) {
        BundleLookupConditionBuilder builder = new BundleLookupConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
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
  
  public A removeFromConditions(BundleLookupCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (BundleLookupCondition item : items) {
        BundleLookupConditionBuilder builder = new BundleLookupConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<BundleLookupConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<BundleLookupConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        BundleLookupConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,BundleLookupCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,BundleLookupCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    BundleLookupConditionBuilder builder = new BundleLookupConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(catalogSourceRef == null)) {
        sb.append("catalogSourceRef:");
        sb.append(catalogSourceRef);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(identifier == null)) {
        sb.append("identifier:");
        sb.append(identifier);
        sb.append(",");
    }
    if (!(path == null)) {
        sb.append("path:");
        sb.append(path);
        sb.append(",");
    }
    if (!(properties == null)) {
        sb.append("properties:");
        sb.append(properties);
        sb.append(",");
    }
    if (!(replaces == null)) {
        sb.append("replaces:");
        sb.append(replaces);
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
  
  public A withCatalogSourceRef(ObjectReference catalogSourceRef) {
    this._visitables.remove("catalogSourceRef");
    if (catalogSourceRef != null) {
        this.catalogSourceRef = new ObjectReferenceBuilder(catalogSourceRef);
        this._visitables.get("catalogSourceRef").add(this.catalogSourceRef);
    } else {
        this.catalogSourceRef = null;
        this._visitables.get("catalogSourceRef").remove(this.catalogSourceRef);
    }
    return (A) this;
  }
  
  public A withConditions(List<BundleLookupCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (BundleLookupCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(BundleLookupCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (BundleLookupCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withIdentifier(String identifier) {
    this.identifier = identifier;
    return (A) this;
  }
  
  public CatalogSourceRefNested<A> withNewCatalogSourceRef() {
    return new CatalogSourceRefNested(null);
  }
  
  public CatalogSourceRefNested<A> withNewCatalogSourceRefLike(ObjectReference item) {
    return new CatalogSourceRefNested(item);
  }
  
  public A withPath(String path) {
    this.path = path;
    return (A) this;
  }
  
  public A withProperties(String properties) {
    this.properties = properties;
    return (A) this;
  }
  
  public A withReplaces(String replaces) {
    this.replaces = replaces;
    return (A) this;
  }
  public class CatalogSourceRefNested<N> extends ObjectReferenceFluent<CatalogSourceRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    CatalogSourceRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) BundleLookupFluent.this.withCatalogSourceRef(builder.build());
    }
    
    public N endCatalogSourceRef() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends BundleLookupConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    BundleLookupConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,BundleLookupCondition item) {
      this.index = index;
      this.builder = new BundleLookupConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) BundleLookupFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}