package io.fabric8.kubernetes.api.model.ovn.v1;

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
public class EgressQoSSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.EgressQoSSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EgressQoSRuleBuilder> egress = new ArrayList<EgressQoSRuleBuilder>();

  public EgressQoSSpecFluent() {
  }
  
  public EgressQoSSpecFluent(EgressQoSSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEgress(Collection<EgressQoSRule> items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (EgressQoSRule item : items) {
        EgressQoSRuleBuilder builder = new EgressQoSRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public EgressNested<A> addNewEgress() {
    return new EgressNested(-1, null);
  }
  
  public EgressNested<A> addNewEgressLike(EgressQoSRule item) {
    return new EgressNested(-1, item);
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
  
  public A addToEgress(EgressQoSRule... items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (EgressQoSRule item : items) {
        EgressQoSRuleBuilder builder = new EgressQoSRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public A addToEgress(int index,EgressQoSRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    EgressQoSRuleBuilder builder = new EgressQoSRuleBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EgressQoSRule> buildEgress() {
    return this.egress != null ? build(egress) : null;
  }
  
  public EgressQoSRule buildEgress(int index) {
    return this.egress.get(index).build();
  }
  
  public EgressQoSRule buildFirstEgress() {
    return this.egress.get(0).build();
  }
  
  public EgressQoSRule buildLastEgress() {
    return this.egress.get(egress.size() - 1).build();
  }
  
  public EgressQoSRule buildMatchingEgress(Predicate<EgressQoSRuleBuilder> predicate) {
      for (EgressQoSRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(EgressQoSSpec instance) {
    instance = instance != null ? instance : new EgressQoSSpec();
    if (instance != null) {
        this.withEgress(instance.getEgress());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EgressNested<A> editEgress(int index) {
    if (egress.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "egress"));
    }
    return this.setNewEgressLike(index, this.buildEgress(index));
  }
  
  public EgressNested<A> editFirstEgress() {
    if (egress.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "egress"));
    }
    return this.setNewEgressLike(0, this.buildEgress(0));
  }
  
  public EgressNested<A> editLastEgress() {
    int index = egress.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "egress"));
    }
    return this.setNewEgressLike(index, this.buildEgress(index));
  }
  
  public EgressNested<A> editMatchingEgress(Predicate<EgressQoSRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < egress.size();i++) {
      if (predicate.test(egress.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "egress"));
    }
    return this.setNewEgressLike(index, this.buildEgress(index));
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
    EgressQoSSpecFluent that = (EgressQoSSpecFluent) o;
    if (!(Objects.equals(egress, that.egress))) {
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
  
  public boolean hasEgress() {
    return this.egress != null && !(this.egress.isEmpty());
  }
  
  public boolean hasMatchingEgress(Predicate<EgressQoSRuleBuilder> predicate) {
      for (EgressQoSRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(egress, additionalProperties);
  }
  
  public A removeAllFromEgress(Collection<EgressQoSRule> items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (EgressQoSRule item : items) {
        EgressQoSRuleBuilder builder = new EgressQoSRuleBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
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
  
  public A removeFromEgress(EgressQoSRule... items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (EgressQoSRule item : items) {
        EgressQoSRuleBuilder builder = new EgressQoSRuleBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEgress(Predicate<EgressQoSRuleBuilder> predicate) {
    if (egress == null) {
      return (A) this;
    }
    Iterator<EgressQoSRuleBuilder> each = egress.iterator();
    List visitables = _visitables.get("egress");
    while (each.hasNext()) {
        EgressQoSRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EgressNested<A> setNewEgressLike(int index,EgressQoSRule item) {
    return new EgressNested(index, item);
  }
  
  public A setToEgress(int index,EgressQoSRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    EgressQoSRuleBuilder builder = new EgressQoSRuleBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(egress == null) && !(egress.isEmpty())) {
        sb.append("egress:");
        sb.append(egress);
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
  
  public A withEgress(List<EgressQoSRule> egress) {
    if (this.egress != null) {
      this._visitables.get("egress").clear();
    }
    if (egress != null) {
        this.egress = new ArrayList();
        for (EgressQoSRule item : egress) {
          this.addToEgress(item);
        }
    } else {
      this.egress = null;
    }
    return (A) this;
  }
  
  public A withEgress(EgressQoSRule... egress) {
    if (this.egress != null) {
        this.egress.clear();
        _visitables.remove("egress");
    }
    if (egress != null) {
      for (EgressQoSRule item : egress) {
        this.addToEgress(item);
      }
    }
    return (A) this;
  }
  public class EgressNested<N> extends EgressQoSRuleFluent<EgressNested<N>> implements Nested<N>{
  
    EgressQoSRuleBuilder builder;
    int index;
  
    EgressNested(int index,EgressQoSRule item) {
      this.index = index;
      this.builder = new EgressQoSRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressQoSSpecFluent.this.setToEgress(index, builder.build());
    }
    
    public N endEgress() {
      return and();
    }
    
  }
}