package io.fabric8.openshift.api.model.miscellaneous.network.v1;

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
public class EgressNetworkPolicySpecFluent<A extends io.fabric8.openshift.api.model.miscellaneous.network.v1.EgressNetworkPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<EgressNetworkPolicyRuleBuilder> egress = new ArrayList<EgressNetworkPolicyRuleBuilder>();

  public EgressNetworkPolicySpecFluent() {
  }
  
  public EgressNetworkPolicySpecFluent(EgressNetworkPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEgress(Collection<EgressNetworkPolicyRule> items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (EgressNetworkPolicyRule item : items) {
        EgressNetworkPolicyRuleBuilder builder = new EgressNetworkPolicyRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public EgressNested<A> addNewEgress() {
    return new EgressNested(-1, null);
  }
  
  public EgressNested<A> addNewEgressLike(EgressNetworkPolicyRule item) {
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
  
  public A addToEgress(EgressNetworkPolicyRule... items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (EgressNetworkPolicyRule item : items) {
        EgressNetworkPolicyRuleBuilder builder = new EgressNetworkPolicyRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public A addToEgress(int index,EgressNetworkPolicyRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    EgressNetworkPolicyRuleBuilder builder = new EgressNetworkPolicyRuleBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.add(index, builder);
    }
    return (A) this;
  }
  
  public List<EgressNetworkPolicyRule> buildEgress() {
    return this.egress != null ? build(egress) : null;
  }
  
  public EgressNetworkPolicyRule buildEgress(int index) {
    return this.egress.get(index).build();
  }
  
  public EgressNetworkPolicyRule buildFirstEgress() {
    return this.egress.get(0).build();
  }
  
  public EgressNetworkPolicyRule buildLastEgress() {
    return this.egress.get(egress.size() - 1).build();
  }
  
  public EgressNetworkPolicyRule buildMatchingEgress(Predicate<EgressNetworkPolicyRuleBuilder> predicate) {
      for (EgressNetworkPolicyRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(EgressNetworkPolicySpec instance) {
    instance = instance != null ? instance : new EgressNetworkPolicySpec();
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
  
  public EgressNested<A> editMatchingEgress(Predicate<EgressNetworkPolicyRuleBuilder> predicate) {
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
    EgressNetworkPolicySpecFluent that = (EgressNetworkPolicySpecFluent) o;
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
  
  public boolean hasMatchingEgress(Predicate<EgressNetworkPolicyRuleBuilder> predicate) {
      for (EgressNetworkPolicyRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(egress, additionalProperties);
  }
  
  public A removeAllFromEgress(Collection<EgressNetworkPolicyRule> items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (EgressNetworkPolicyRule item : items) {
        EgressNetworkPolicyRuleBuilder builder = new EgressNetworkPolicyRuleBuilder(item);
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
  
  public A removeFromEgress(EgressNetworkPolicyRule... items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (EgressNetworkPolicyRule item : items) {
        EgressNetworkPolicyRuleBuilder builder = new EgressNetworkPolicyRuleBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEgress(Predicate<EgressNetworkPolicyRuleBuilder> predicate) {
    if (egress == null) {
      return (A) this;
    }
    Iterator<EgressNetworkPolicyRuleBuilder> each = egress.iterator();
    List visitables = _visitables.get("egress");
    while (each.hasNext()) {
        EgressNetworkPolicyRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EgressNested<A> setNewEgressLike(int index,EgressNetworkPolicyRule item) {
    return new EgressNested(index, item);
  }
  
  public A setToEgress(int index,EgressNetworkPolicyRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    EgressNetworkPolicyRuleBuilder builder = new EgressNetworkPolicyRuleBuilder(item);
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
  
  public A withEgress(List<EgressNetworkPolicyRule> egress) {
    if (this.egress != null) {
      this._visitables.get("egress").clear();
    }
    if (egress != null) {
        this.egress = new ArrayList();
        for (EgressNetworkPolicyRule item : egress) {
          this.addToEgress(item);
        }
    } else {
      this.egress = null;
    }
    return (A) this;
  }
  
  public A withEgress(EgressNetworkPolicyRule... egress) {
    if (this.egress != null) {
        this.egress.clear();
        _visitables.remove("egress");
    }
    if (egress != null) {
      for (EgressNetworkPolicyRule item : egress) {
        this.addToEgress(item);
      }
    }
    return (A) this;
  }
  public class EgressNested<N> extends EgressNetworkPolicyRuleFluent<EgressNested<N>> implements Nested<N>{
  
    EgressNetworkPolicyRuleBuilder builder;
    int index;
  
    EgressNested(int index,EgressNetworkPolicyRule item) {
      this.index = index;
      this.builder = new EgressNetworkPolicyRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) EgressNetworkPolicySpecFluent.this.setToEgress(index, builder.build());
    }
    
    public N endEgress() {
      return and();
    }
    
  }
}