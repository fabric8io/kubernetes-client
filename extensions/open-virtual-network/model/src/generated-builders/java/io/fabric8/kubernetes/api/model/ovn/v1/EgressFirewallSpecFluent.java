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
public class EgressFirewallSpecFluent<A extends io.fabric8.kubernetes.api.model.ovn.v1.EgressFirewallSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EgressFirewallRuleBuilder> egress = new ArrayList<EgressFirewallRuleBuilder>();

  public EgressFirewallSpecFluent() {
  }
  
  public EgressFirewallSpecFluent(EgressFirewallSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEgress(Collection<EgressFirewallRule> items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (EgressFirewallRule item : items) {
        EgressFirewallRuleBuilder builder = new EgressFirewallRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public EgressNested<A> addNewEgress() {
    return new EgressNested(-1, null);
  }
  
  public EgressNested<A> addNewEgressLike(EgressFirewallRule item) {
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
  
  public A addToEgress(EgressFirewallRule... items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (EgressFirewallRule item : items) {
        EgressFirewallRuleBuilder builder = new EgressFirewallRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public A addToEgress(int index,EgressFirewallRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    EgressFirewallRuleBuilder builder = new EgressFirewallRuleBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EgressFirewallRule> buildEgress() {
    return this.egress != null ? build(egress) : null;
  }
  
  public EgressFirewallRule buildEgress(int index) {
    return this.egress.get(index).build();
  }
  
  public EgressFirewallRule buildFirstEgress() {
    return this.egress.get(0).build();
  }
  
  public EgressFirewallRule buildLastEgress() {
    return this.egress.get(egress.size() - 1).build();
  }
  
  public EgressFirewallRule buildMatchingEgress(Predicate<EgressFirewallRuleBuilder> predicate) {
      for (EgressFirewallRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(EgressFirewallSpec instance) {
    instance = instance != null ? instance : new EgressFirewallSpec();
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
  
  public EgressNested<A> editMatchingEgress(Predicate<EgressFirewallRuleBuilder> predicate) {
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
    EgressFirewallSpecFluent that = (EgressFirewallSpecFluent) o;
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
  
  public boolean hasMatchingEgress(Predicate<EgressFirewallRuleBuilder> predicate) {
      for (EgressFirewallRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(egress, additionalProperties);
  }
  
  public A removeAllFromEgress(Collection<EgressFirewallRule> items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (EgressFirewallRule item : items) {
        EgressFirewallRuleBuilder builder = new EgressFirewallRuleBuilder(item);
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
  
  public A removeFromEgress(EgressFirewallRule... items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (EgressFirewallRule item : items) {
        EgressFirewallRuleBuilder builder = new EgressFirewallRuleBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEgress(Predicate<EgressFirewallRuleBuilder> predicate) {
    if (egress == null) {
      return (A) this;
    }
    Iterator<EgressFirewallRuleBuilder> each = egress.iterator();
    List visitables = _visitables.get("egress");
    while (each.hasNext()) {
        EgressFirewallRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EgressNested<A> setNewEgressLike(int index,EgressFirewallRule item) {
    return new EgressNested(index, item);
  }
  
  public A setToEgress(int index,EgressFirewallRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    EgressFirewallRuleBuilder builder = new EgressFirewallRuleBuilder(item);
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
  
  public A withEgress(List<EgressFirewallRule> egress) {
    if (this.egress != null) {
      this._visitables.get("egress").clear();
    }
    if (egress != null) {
        this.egress = new ArrayList();
        for (EgressFirewallRule item : egress) {
          this.addToEgress(item);
        }
    } else {
      this.egress = null;
    }
    return (A) this;
  }
  
  public A withEgress(EgressFirewallRule... egress) {
    if (this.egress != null) {
        this.egress.clear();
        _visitables.remove("egress");
    }
    if (egress != null) {
      for (EgressFirewallRule item : egress) {
        this.addToEgress(item);
      }
    }
    return (A) this;
  }
  public class EgressNested<N> extends EgressFirewallRuleFluent<EgressNested<N>> implements Nested<N>{
  
    EgressFirewallRuleBuilder builder;
    int index;
  
    EgressNested(int index,EgressFirewallRule item) {
      this.index = index;
      this.builder = new EgressFirewallRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressFirewallSpecFluent.this.setToEgress(index, builder.build());
    }
    
    public N endEgress() {
      return and();
    }
    
  }
}