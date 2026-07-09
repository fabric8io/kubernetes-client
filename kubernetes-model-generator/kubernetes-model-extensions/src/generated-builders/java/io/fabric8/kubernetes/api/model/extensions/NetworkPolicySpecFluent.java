package io.fabric8.kubernetes.api.model.extensions;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
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
public class NetworkPolicySpecFluent<A extends io.fabric8.kubernetes.api.model.extensions.NetworkPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<NetworkPolicyEgressRuleBuilder> egress = new ArrayList<NetworkPolicyEgressRuleBuilder>();
  private ArrayList<NetworkPolicyIngressRuleBuilder> ingress = new ArrayList<NetworkPolicyIngressRuleBuilder>();
  private LabelSelectorBuilder podSelector;
  private List<String> policyTypes = new ArrayList<String>();

  public NetworkPolicySpecFluent() {
  }
  
  public NetworkPolicySpecFluent(NetworkPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToEgress(Collection<NetworkPolicyEgressRule> items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (NetworkPolicyEgressRule item : items) {
        NetworkPolicyEgressRuleBuilder builder = new NetworkPolicyEgressRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToIngress(Collection<NetworkPolicyIngressRule> items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (NetworkPolicyIngressRule item : items) {
        NetworkPolicyIngressRuleBuilder builder = new NetworkPolicyIngressRuleBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPolicyTypes(Collection<String> items) {
    if (this.policyTypes == null) {
      this.policyTypes = new ArrayList();
    }
    for (String item : items) {
      this.policyTypes.add(item);
    }
    return (A) this;
  }
  
  public EgressNested<A> addNewEgress() {
    return new EgressNested(-1, null);
  }
  
  public EgressNested<A> addNewEgressLike(NetworkPolicyEgressRule item) {
    return new EgressNested(-1, item);
  }
  
  public IngressNested<A> addNewIngress() {
    return new IngressNested(-1, null);
  }
  
  public IngressNested<A> addNewIngressLike(NetworkPolicyIngressRule item) {
    return new IngressNested(-1, item);
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
  
  public A addToEgress(NetworkPolicyEgressRule... items) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    for (NetworkPolicyEgressRule item : items) {
        NetworkPolicyEgressRuleBuilder builder = new NetworkPolicyEgressRuleBuilder(item);
        _visitables.get("egress").add(builder);
        this.egress.add(builder);
    }
    return (A) this;
  }
  
  public A addToEgress(int index,NetworkPolicyEgressRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    NetworkPolicyEgressRuleBuilder builder = new NetworkPolicyEgressRuleBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToIngress(NetworkPolicyIngressRule... items) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    for (NetworkPolicyIngressRule item : items) {
        NetworkPolicyIngressRuleBuilder builder = new NetworkPolicyIngressRuleBuilder(item);
        _visitables.get("ingress").add(builder);
        this.ingress.add(builder);
    }
    return (A) this;
  }
  
  public A addToIngress(int index,NetworkPolicyIngressRule item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    NetworkPolicyIngressRuleBuilder builder = new NetworkPolicyIngressRuleBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPolicyTypes(String... items) {
    if (this.policyTypes == null) {
      this.policyTypes = new ArrayList();
    }
    for (String item : items) {
      this.policyTypes.add(item);
    }
    return (A) this;
  }
  
  public A addToPolicyTypes(int index,String item) {
    if (this.policyTypes == null) {
      this.policyTypes = new ArrayList();
    }
    this.policyTypes.add(index, item);
    return (A) this;
  }
  
  public List<NetworkPolicyEgressRule> buildEgress() {
    return this.egress != null ? build(egress) : null;
  }
  
  public NetworkPolicyEgressRule buildEgress(int index) {
    return this.egress.get(index).build();
  }
  
  public NetworkPolicyEgressRule buildFirstEgress() {
    return this.egress.get(0).build();
  }
  
  public NetworkPolicyIngressRule buildFirstIngress() {
    return this.ingress.get(0).build();
  }
  
  public List<NetworkPolicyIngressRule> buildIngress() {
    return this.ingress != null ? build(ingress) : null;
  }
  
  public NetworkPolicyIngressRule buildIngress(int index) {
    return this.ingress.get(index).build();
  }
  
  public NetworkPolicyEgressRule buildLastEgress() {
    return this.egress.get(egress.size() - 1).build();
  }
  
  public NetworkPolicyIngressRule buildLastIngress() {
    return this.ingress.get(ingress.size() - 1).build();
  }
  
  public NetworkPolicyEgressRule buildMatchingEgress(Predicate<NetworkPolicyEgressRuleBuilder> predicate) {
      for (NetworkPolicyEgressRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkPolicyIngressRule buildMatchingIngress(Predicate<NetworkPolicyIngressRuleBuilder> predicate) {
      for (NetworkPolicyIngressRuleBuilder item : ingress) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LabelSelector buildPodSelector() {
    return this.podSelector != null ? this.podSelector.build() : null;
  }
  
  protected void copyInstance(NetworkPolicySpec instance) {
    instance = instance != null ? instance : new NetworkPolicySpec();
    if (instance != null) {
        this.withEgress(instance.getEgress());
        this.withIngress(instance.getIngress());
        this.withPodSelector(instance.getPodSelector());
        this.withPolicyTypes(instance.getPolicyTypes());
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
  
  public IngressNested<A> editFirstIngress() {
    if (ingress.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(0, this.buildIngress(0));
  }
  
  public IngressNested<A> editIngress(int index) {
    if (ingress.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public EgressNested<A> editLastEgress() {
    int index = egress.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "egress"));
    }
    return this.setNewEgressLike(index, this.buildEgress(index));
  }
  
  public IngressNested<A> editLastIngress() {
    int index = ingress.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public EgressNested<A> editMatchingEgress(Predicate<NetworkPolicyEgressRuleBuilder> predicate) {
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
  
  public IngressNested<A> editMatchingIngress(Predicate<NetworkPolicyIngressRuleBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ingress.size();i++) {
      if (predicate.test(ingress.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ingress"));
    }
    return this.setNewIngressLike(index, this.buildIngress(index));
  }
  
  public PodSelectorNested<A> editOrNewPodSelector() {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public PodSelectorNested<A> editOrNewPodSelectorLike(LabelSelector item) {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(item));
  }
  
  public PodSelectorNested<A> editPodSelector() {
    return this.withNewPodSelectorLike(Optional.ofNullable(this.buildPodSelector()).orElse(null));
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
    NetworkPolicySpecFluent that = (NetworkPolicySpecFluent) o;
    if (!(Objects.equals(egress, that.egress))) {
      return false;
    }
    if (!(Objects.equals(ingress, that.ingress))) {
      return false;
    }
    if (!(Objects.equals(podSelector, that.podSelector))) {
      return false;
    }
    if (!(Objects.equals(policyTypes, that.policyTypes))) {
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
  
  public String getFirstPolicyType() {
    return this.policyTypes.get(0);
  }
  
  public String getLastPolicyType() {
    return this.policyTypes.get(policyTypes.size() - 1);
  }
  
  public String getMatchingPolicyType(Predicate<String> predicate) {
      for (String item : policyTypes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getPolicyType(int index) {
    return this.policyTypes.get(index);
  }
  
  public List<String> getPolicyTypes() {
    return this.policyTypes;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEgress() {
    return this.egress != null && !(this.egress.isEmpty());
  }
  
  public boolean hasIngress() {
    return this.ingress != null && !(this.ingress.isEmpty());
  }
  
  public boolean hasMatchingEgress(Predicate<NetworkPolicyEgressRuleBuilder> predicate) {
      for (NetworkPolicyEgressRuleBuilder item : egress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingIngress(Predicate<NetworkPolicyIngressRuleBuilder> predicate) {
      for (NetworkPolicyIngressRuleBuilder item : ingress) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPolicyType(Predicate<String> predicate) {
      for (String item : policyTypes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPodSelector() {
    return this.podSelector != null;
  }
  
  public boolean hasPolicyTypes() {
    return this.policyTypes != null && !(this.policyTypes.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(egress, ingress, podSelector, policyTypes, additionalProperties);
  }
  
  public A removeAllFromEgress(Collection<NetworkPolicyEgressRule> items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (NetworkPolicyEgressRule item : items) {
        NetworkPolicyEgressRuleBuilder builder = new NetworkPolicyEgressRuleBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromIngress(Collection<NetworkPolicyIngressRule> items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (NetworkPolicyIngressRule item : items) {
        NetworkPolicyIngressRuleBuilder builder = new NetworkPolicyIngressRuleBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPolicyTypes(Collection<String> items) {
    if (this.policyTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policyTypes.remove(item);
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
  
  public A removeFromEgress(NetworkPolicyEgressRule... items) {
    if (this.egress == null) {
      return (A) this;
    }
    for (NetworkPolicyEgressRule item : items) {
        NetworkPolicyEgressRuleBuilder builder = new NetworkPolicyEgressRuleBuilder(item);
        _visitables.get("egress").remove(builder);
        this.egress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromIngress(NetworkPolicyIngressRule... items) {
    if (this.ingress == null) {
      return (A) this;
    }
    for (NetworkPolicyIngressRule item : items) {
        NetworkPolicyIngressRuleBuilder builder = new NetworkPolicyIngressRuleBuilder(item);
        _visitables.get("ingress").remove(builder);
        this.ingress.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPolicyTypes(String... items) {
    if (this.policyTypes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.policyTypes.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEgress(Predicate<NetworkPolicyEgressRuleBuilder> predicate) {
    if (egress == null) {
      return (A) this;
    }
    Iterator<NetworkPolicyEgressRuleBuilder> each = egress.iterator();
    List visitables = _visitables.get("egress");
    while (each.hasNext()) {
        NetworkPolicyEgressRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromIngress(Predicate<NetworkPolicyIngressRuleBuilder> predicate) {
    if (ingress == null) {
      return (A) this;
    }
    Iterator<NetworkPolicyIngressRuleBuilder> each = ingress.iterator();
    List visitables = _visitables.get("ingress");
    while (each.hasNext()) {
        NetworkPolicyIngressRuleBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EgressNested<A> setNewEgressLike(int index,NetworkPolicyEgressRule item) {
    return new EgressNested(index, item);
  }
  
  public IngressNested<A> setNewIngressLike(int index,NetworkPolicyIngressRule item) {
    return new IngressNested(index, item);
  }
  
  public A setToEgress(int index,NetworkPolicyEgressRule item) {
    if (this.egress == null) {
      this.egress = new ArrayList();
    }
    NetworkPolicyEgressRuleBuilder builder = new NetworkPolicyEgressRuleBuilder(item);
    if (index < 0 || index >= egress.size()) {
        _visitables.get("egress").add(builder);
        egress.add(builder);
    } else {
        _visitables.get("egress").add(builder);
        egress.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToIngress(int index,NetworkPolicyIngressRule item) {
    if (this.ingress == null) {
      this.ingress = new ArrayList();
    }
    NetworkPolicyIngressRuleBuilder builder = new NetworkPolicyIngressRuleBuilder(item);
    if (index < 0 || index >= ingress.size()) {
        _visitables.get("ingress").add(builder);
        ingress.add(builder);
    } else {
        _visitables.get("ingress").add(builder);
        ingress.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPolicyTypes(int index,String item) {
    if (this.policyTypes == null) {
      this.policyTypes = new ArrayList();
    }
    this.policyTypes.set(index, item);
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
    if (!(ingress == null) && !(ingress.isEmpty())) {
        sb.append("ingress:");
        sb.append(ingress);
        sb.append(",");
    }
    if (!(podSelector == null)) {
        sb.append("podSelector:");
        sb.append(podSelector);
        sb.append(",");
    }
    if (!(policyTypes == null) && !(policyTypes.isEmpty())) {
        sb.append("policyTypes:");
        sb.append(policyTypes);
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
  
  public A withEgress(List<NetworkPolicyEgressRule> egress) {
    if (this.egress != null) {
      this._visitables.get("egress").clear();
    }
    if (egress != null) {
        this.egress = new ArrayList();
        for (NetworkPolicyEgressRule item : egress) {
          this.addToEgress(item);
        }
    } else {
      this.egress = null;
    }
    return (A) this;
  }
  
  public A withEgress(NetworkPolicyEgressRule... egress) {
    if (this.egress != null) {
        this.egress.clear();
        _visitables.remove("egress");
    }
    if (egress != null) {
      for (NetworkPolicyEgressRule item : egress) {
        this.addToEgress(item);
      }
    }
    return (A) this;
  }
  
  public A withIngress(List<NetworkPolicyIngressRule> ingress) {
    if (this.ingress != null) {
      this._visitables.get("ingress").clear();
    }
    if (ingress != null) {
        this.ingress = new ArrayList();
        for (NetworkPolicyIngressRule item : ingress) {
          this.addToIngress(item);
        }
    } else {
      this.ingress = null;
    }
    return (A) this;
  }
  
  public A withIngress(NetworkPolicyIngressRule... ingress) {
    if (this.ingress != null) {
        this.ingress.clear();
        _visitables.remove("ingress");
    }
    if (ingress != null) {
      for (NetworkPolicyIngressRule item : ingress) {
        this.addToIngress(item);
      }
    }
    return (A) this;
  }
  
  public PodSelectorNested<A> withNewPodSelector() {
    return new PodSelectorNested(null);
  }
  
  public PodSelectorNested<A> withNewPodSelectorLike(LabelSelector item) {
    return new PodSelectorNested(item);
  }
  
  public A withPodSelector(LabelSelector podSelector) {
    this._visitables.remove("podSelector");
    if (podSelector != null) {
        this.podSelector = new LabelSelectorBuilder(podSelector);
        this._visitables.get("podSelector").add(this.podSelector);
    } else {
        this.podSelector = null;
        this._visitables.get("podSelector").remove(this.podSelector);
    }
    return (A) this;
  }
  
  public A withPolicyTypes(List<String> policyTypes) {
    if (policyTypes != null) {
        this.policyTypes = new ArrayList();
        for (String item : policyTypes) {
          this.addToPolicyTypes(item);
        }
    } else {
      this.policyTypes = null;
    }
    return (A) this;
  }
  
  public A withPolicyTypes(String... policyTypes) {
    if (this.policyTypes != null) {
        this.policyTypes.clear();
        _visitables.remove("policyTypes");
    }
    if (policyTypes != null) {
      for (String item : policyTypes) {
        this.addToPolicyTypes(item);
      }
    }
    return (A) this;
  }
  public class EgressNested<N> extends NetworkPolicyEgressRuleFluent<EgressNested<N>> implements Nested<N>{
  
    NetworkPolicyEgressRuleBuilder builder;
    int index;
  
    EgressNested(int index,NetworkPolicyEgressRule item) {
      this.index = index;
      this.builder = new NetworkPolicyEgressRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicySpecFluent.this.setToEgress(index, builder.build());
    }
    
    public N endEgress() {
      return and();
    }
    
  }
  public class IngressNested<N> extends NetworkPolicyIngressRuleFluent<IngressNested<N>> implements Nested<N>{
  
    NetworkPolicyIngressRuleBuilder builder;
    int index;
  
    IngressNested(int index,NetworkPolicyIngressRule item) {
      this.index = index;
      this.builder = new NetworkPolicyIngressRuleBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicySpecFluent.this.setToIngress(index, builder.build());
    }
    
    public N endIngress() {
      return and();
    }
    
  }
  public class PodSelectorNested<N> extends LabelSelectorFluent<PodSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    PodSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkPolicySpecFluent.this.withPodSelector(builder.build());
    }
    
    public N endPodSelector() {
      return and();
    }
    
  }
}