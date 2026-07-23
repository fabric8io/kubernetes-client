package io.fabric8.certmanager.api.model.v1;

import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerStatus;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerStatusBuilder;
import io.fabric8.certmanager.api.model.acme.v1.ACMEIssuerStatusFluent;
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
public class IssuerStatusFluent<A extends io.fabric8.certmanager.api.model.v1.IssuerStatusFluent<A>> extends BaseFluent<A>{

  private ACMEIssuerStatusBuilder acme;
  private Map<String,Object> additionalProperties;
  private ArrayList<IssuerConditionBuilder> conditions = new ArrayList<IssuerConditionBuilder>();

  public IssuerStatusFluent() {
  }
  
  public IssuerStatusFluent(IssuerStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<IssuerCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (IssuerCondition item : items) {
        IssuerConditionBuilder builder = new IssuerConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(IssuerCondition item) {
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
  
  public A addToConditions(IssuerCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (IssuerCondition item : items) {
        IssuerConditionBuilder builder = new IssuerConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,IssuerCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    IssuerConditionBuilder builder = new IssuerConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public ACMEIssuerStatus buildAcme() {
    return this.acme != null ? this.acme.build() : null;
  }
  
  public IssuerCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<IssuerCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public IssuerCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public IssuerCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public IssuerCondition buildMatchingCondition(Predicate<IssuerConditionBuilder> predicate) {
      for (IssuerConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(IssuerStatus instance) {
    instance = instance != null ? instance : new IssuerStatus();
    if (instance != null) {
        this.withAcme(instance.getAcme());
        this.withConditions(instance.getConditions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AcmeNested<A> editAcme() {
    return this.withNewAcmeLike(Optional.ofNullable(this.buildAcme()).orElse(null));
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
  
  public ConditionsNested<A> editMatchingCondition(Predicate<IssuerConditionBuilder> predicate) {
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
  
  public AcmeNested<A> editOrNewAcme() {
    return this.withNewAcmeLike(Optional.ofNullable(this.buildAcme()).orElse(new ACMEIssuerStatusBuilder().build()));
  }
  
  public AcmeNested<A> editOrNewAcmeLike(ACMEIssuerStatus item) {
    return this.withNewAcmeLike(Optional.ofNullable(this.buildAcme()).orElse(item));
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
    IssuerStatusFluent that = (IssuerStatusFluent) o;
    if (!(Objects.equals(acme, that.acme))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
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
  
  public boolean hasAcme() {
    return this.acme != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasMatchingCondition(Predicate<IssuerConditionBuilder> predicate) {
      for (IssuerConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(acme, conditions, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<IssuerCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (IssuerCondition item : items) {
        IssuerConditionBuilder builder = new IssuerConditionBuilder(item);
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
  
  public A removeFromConditions(IssuerCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (IssuerCondition item : items) {
        IssuerConditionBuilder builder = new IssuerConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<IssuerConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<IssuerConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        IssuerConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,IssuerCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,IssuerCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    IssuerConditionBuilder builder = new IssuerConditionBuilder(item);
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
    if (!(acme == null)) {
        sb.append("acme:");
        sb.append(acme);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAcme(ACMEIssuerStatus acme) {
    this._visitables.remove("acme");
    if (acme != null) {
        this.acme = new ACMEIssuerStatusBuilder(acme);
        this._visitables.get("acme").add(this.acme);
    } else {
        this.acme = null;
        this._visitables.get("acme").remove(this.acme);
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
  
  public A withConditions(List<IssuerCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (IssuerCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(IssuerCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (IssuerCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public AcmeNested<A> withNewAcme() {
    return new AcmeNested(null);
  }
  
  public A withNewAcme(String lastPrivateKeyHash,String lastRegisteredEmail,String uri) {
    return (A) this.withAcme(new ACMEIssuerStatus(lastPrivateKeyHash, lastRegisteredEmail, uri));
  }
  
  public AcmeNested<A> withNewAcmeLike(ACMEIssuerStatus item) {
    return new AcmeNested(item);
  }
  public class AcmeNested<N> extends ACMEIssuerStatusFluent<AcmeNested<N>> implements Nested<N>{
  
    ACMEIssuerStatusBuilder builder;
  
    AcmeNested(ACMEIssuerStatus item) {
      this.builder = new ACMEIssuerStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) IssuerStatusFluent.this.withAcme(builder.build());
    }
    
    public N endAcme() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends IssuerConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    IssuerConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,IssuerCondition item) {
      this.index = index;
      this.builder = new IssuerConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) IssuerStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
}