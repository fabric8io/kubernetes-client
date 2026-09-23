package io.fabric8.openclustermanagement.api.model.policy.v1;

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
public class PlacementFluent<A extends io.fabric8.openclustermanagement.api.model.policy.v1.PlacementFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<PlacementDecisionBuilder> decisions = new ArrayList<PlacementDecisionBuilder>();
  private ArrayList<PolicyExclusionBuilder> exclusions = new ArrayList<PolicyExclusionBuilder>();
  private String placement;
  private String placementBinding;
  private String placementRule;
  private String policySet;

  public PlacementFluent() {
  }
  
  public PlacementFluent(Placement instance) {
    this.copyInstance(instance);
  }

  public A addAllToDecisions(Collection<PlacementDecision> items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
        _visitables.get("decisions").add(builder);
        this.decisions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToExclusions(Collection<PolicyExclusion> items) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    for (PolicyExclusion item : items) {
        PolicyExclusionBuilder builder = new PolicyExclusionBuilder(item);
        _visitables.get("exclusions").add(builder);
        this.exclusions.add(builder);
    }
    return (A) this;
  }
  
  public DecisionsNested<A> addNewDecision() {
    return new DecisionsNested(-1, null);
  }
  
  public A addNewDecision(String clusterName,String clusterNamespace) {
    return (A) this.addToDecisions(new PlacementDecision(clusterName, clusterNamespace));
  }
  
  public DecisionsNested<A> addNewDecisionLike(PlacementDecision item) {
    return new DecisionsNested(-1, item);
  }
  
  public ExclusionsNested<A> addNewExclusion() {
    return new ExclusionsNested(-1, null);
  }
  
  public A addNewExclusion(String clusterName) {
    return (A) this.addToExclusions(new PolicyExclusion(clusterName));
  }
  
  public ExclusionsNested<A> addNewExclusionLike(PolicyExclusion item) {
    return new ExclusionsNested(-1, item);
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
  
  public A addToDecisions(PlacementDecision... items) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
        _visitables.get("decisions").add(builder);
        this.decisions.add(builder);
    }
    return (A) this;
  }
  
  public A addToDecisions(int index,PlacementDecision item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
    if (index < 0 || index >= decisions.size()) {
        _visitables.get("decisions").add(builder);
        decisions.add(builder);
    } else {
        _visitables.get("decisions").add(builder);
        decisions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToExclusions(PolicyExclusion... items) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    for (PolicyExclusion item : items) {
        PolicyExclusionBuilder builder = new PolicyExclusionBuilder(item);
        _visitables.get("exclusions").add(builder);
        this.exclusions.add(builder);
    }
    return (A) this;
  }
  
  public A addToExclusions(int index,PolicyExclusion item) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    PolicyExclusionBuilder builder = new PolicyExclusionBuilder(item);
    if (index < 0 || index >= exclusions.size()) {
        _visitables.get("exclusions").add(builder);
        exclusions.add(builder);
    } else {
        _visitables.get("exclusions").add(builder);
        exclusions.add(index, builder);
    }
    return (A) this;
  }
  
  public PlacementDecision buildDecision(int index) {
    return this.decisions.get(index).build();
  }
  
  public List<PlacementDecision> buildDecisions() {
    return this.decisions != null ? build(decisions) : null;
  }
  
  public PolicyExclusion buildExclusion(int index) {
    return this.exclusions.get(index).build();
  }
  
  public List<PolicyExclusion> buildExclusions() {
    return this.exclusions != null ? build(exclusions) : null;
  }
  
  public PlacementDecision buildFirstDecision() {
    return this.decisions.get(0).build();
  }
  
  public PolicyExclusion buildFirstExclusion() {
    return this.exclusions.get(0).build();
  }
  
  public PlacementDecision buildLastDecision() {
    return this.decisions.get(decisions.size() - 1).build();
  }
  
  public PolicyExclusion buildLastExclusion() {
    return this.exclusions.get(exclusions.size() - 1).build();
  }
  
  public PlacementDecision buildMatchingDecision(Predicate<PlacementDecisionBuilder> predicate) {
      for (PlacementDecisionBuilder item : decisions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public PolicyExclusion buildMatchingExclusion(Predicate<PolicyExclusionBuilder> predicate) {
      for (PolicyExclusionBuilder item : exclusions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(Placement instance) {
    instance = instance != null ? instance : new Placement();
    if (instance != null) {
        this.withDecisions(instance.getDecisions());
        this.withExclusions(instance.getExclusions());
        this.withPlacement(instance.getPlacement());
        this.withPlacementBinding(instance.getPlacementBinding());
        this.withPlacementRule(instance.getPlacementRule());
        this.withPolicySet(instance.getPolicySet());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DecisionsNested<A> editDecision(int index) {
    if (decisions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "decisions"));
    }
    return this.setNewDecisionLike(index, this.buildDecision(index));
  }
  
  public ExclusionsNested<A> editExclusion(int index) {
    if (exclusions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "exclusions"));
    }
    return this.setNewExclusionLike(index, this.buildExclusion(index));
  }
  
  public DecisionsNested<A> editFirstDecision() {
    if (decisions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "decisions"));
    }
    return this.setNewDecisionLike(0, this.buildDecision(0));
  }
  
  public ExclusionsNested<A> editFirstExclusion() {
    if (exclusions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "exclusions"));
    }
    return this.setNewExclusionLike(0, this.buildExclusion(0));
  }
  
  public DecisionsNested<A> editLastDecision() {
    int index = decisions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "decisions"));
    }
    return this.setNewDecisionLike(index, this.buildDecision(index));
  }
  
  public ExclusionsNested<A> editLastExclusion() {
    int index = exclusions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "exclusions"));
    }
    return this.setNewExclusionLike(index, this.buildExclusion(index));
  }
  
  public DecisionsNested<A> editMatchingDecision(Predicate<PlacementDecisionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < decisions.size();i++) {
      if (predicate.test(decisions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "decisions"));
    }
    return this.setNewDecisionLike(index, this.buildDecision(index));
  }
  
  public ExclusionsNested<A> editMatchingExclusion(Predicate<PolicyExclusionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < exclusions.size();i++) {
      if (predicate.test(exclusions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "exclusions"));
    }
    return this.setNewExclusionLike(index, this.buildExclusion(index));
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
    PlacementFluent that = (PlacementFluent) o;
    if (!(Objects.equals(decisions, that.decisions))) {
      return false;
    }
    if (!(Objects.equals(exclusions, that.exclusions))) {
      return false;
    }
    if (!(Objects.equals(placement, that.placement))) {
      return false;
    }
    if (!(Objects.equals(placementBinding, that.placementBinding))) {
      return false;
    }
    if (!(Objects.equals(placementRule, that.placementRule))) {
      return false;
    }
    if (!(Objects.equals(policySet, that.policySet))) {
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
  
  public String getPlacement() {
    return this.placement;
  }
  
  public String getPlacementBinding() {
    return this.placementBinding;
  }
  
  public String getPlacementRule() {
    return this.placementRule;
  }
  
  public String getPolicySet() {
    return this.policySet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDecisions() {
    return this.decisions != null && !(this.decisions.isEmpty());
  }
  
  public boolean hasExclusions() {
    return this.exclusions != null && !(this.exclusions.isEmpty());
  }
  
  public boolean hasMatchingDecision(Predicate<PlacementDecisionBuilder> predicate) {
      for (PlacementDecisionBuilder item : decisions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingExclusion(Predicate<PolicyExclusionBuilder> predicate) {
      for (PolicyExclusionBuilder item : exclusions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPlacement() {
    return this.placement != null;
  }
  
  public boolean hasPlacementBinding() {
    return this.placementBinding != null;
  }
  
  public boolean hasPlacementRule() {
    return this.placementRule != null;
  }
  
  public boolean hasPolicySet() {
    return this.policySet != null;
  }
  
  public int hashCode() {
    return Objects.hash(decisions, exclusions, placement, placementBinding, placementRule, policySet, additionalProperties);
  }
  
  public A removeAllFromDecisions(Collection<PlacementDecision> items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
        _visitables.get("decisions").remove(builder);
        this.decisions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromExclusions(Collection<PolicyExclusion> items) {
    if (this.exclusions == null) {
      return (A) this;
    }
    for (PolicyExclusion item : items) {
        PolicyExclusionBuilder builder = new PolicyExclusionBuilder(item);
        _visitables.get("exclusions").remove(builder);
        this.exclusions.remove(builder);
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
  
  public A removeFromDecisions(PlacementDecision... items) {
    if (this.decisions == null) {
      return (A) this;
    }
    for (PlacementDecision item : items) {
        PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
        _visitables.get("decisions").remove(builder);
        this.decisions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromExclusions(PolicyExclusion... items) {
    if (this.exclusions == null) {
      return (A) this;
    }
    for (PolicyExclusion item : items) {
        PolicyExclusionBuilder builder = new PolicyExclusionBuilder(item);
        _visitables.get("exclusions").remove(builder);
        this.exclusions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromDecisions(Predicate<PlacementDecisionBuilder> predicate) {
    if (decisions == null) {
      return (A) this;
    }
    Iterator<PlacementDecisionBuilder> each = decisions.iterator();
    List visitables = _visitables.get("decisions");
    while (each.hasNext()) {
        PlacementDecisionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromExclusions(Predicate<PolicyExclusionBuilder> predicate) {
    if (exclusions == null) {
      return (A) this;
    }
    Iterator<PolicyExclusionBuilder> each = exclusions.iterator();
    List visitables = _visitables.get("exclusions");
    while (each.hasNext()) {
        PolicyExclusionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public DecisionsNested<A> setNewDecisionLike(int index,PlacementDecision item) {
    return new DecisionsNested(index, item);
  }
  
  public ExclusionsNested<A> setNewExclusionLike(int index,PolicyExclusion item) {
    return new ExclusionsNested(index, item);
  }
  
  public A setToDecisions(int index,PlacementDecision item) {
    if (this.decisions == null) {
      this.decisions = new ArrayList();
    }
    PlacementDecisionBuilder builder = new PlacementDecisionBuilder(item);
    if (index < 0 || index >= decisions.size()) {
        _visitables.get("decisions").add(builder);
        decisions.add(builder);
    } else {
        _visitables.get("decisions").add(builder);
        decisions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToExclusions(int index,PolicyExclusion item) {
    if (this.exclusions == null) {
      this.exclusions = new ArrayList();
    }
    PolicyExclusionBuilder builder = new PolicyExclusionBuilder(item);
    if (index < 0 || index >= exclusions.size()) {
        _visitables.get("exclusions").add(builder);
        exclusions.add(builder);
    } else {
        _visitables.get("exclusions").add(builder);
        exclusions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(decisions == null) && !(decisions.isEmpty())) {
        sb.append("decisions:");
        sb.append(decisions);
        sb.append(",");
    }
    if (!(exclusions == null) && !(exclusions.isEmpty())) {
        sb.append("exclusions:");
        sb.append(exclusions);
        sb.append(",");
    }
    if (!(placement == null)) {
        sb.append("placement:");
        sb.append(placement);
        sb.append(",");
    }
    if (!(placementBinding == null)) {
        sb.append("placementBinding:");
        sb.append(placementBinding);
        sb.append(",");
    }
    if (!(placementRule == null)) {
        sb.append("placementRule:");
        sb.append(placementRule);
        sb.append(",");
    }
    if (!(policySet == null)) {
        sb.append("policySet:");
        sb.append(policySet);
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
  
  public A withDecisions(List<PlacementDecision> decisions) {
    if (this.decisions != null) {
      this._visitables.get("decisions").clear();
    }
    if (decisions != null) {
        this.decisions = new ArrayList();
        for (PlacementDecision item : decisions) {
          this.addToDecisions(item);
        }
    } else {
      this.decisions = null;
    }
    return (A) this;
  }
  
  public A withDecisions(PlacementDecision... decisions) {
    if (this.decisions != null) {
        this.decisions.clear();
        _visitables.remove("decisions");
    }
    if (decisions != null) {
      for (PlacementDecision item : decisions) {
        this.addToDecisions(item);
      }
    }
    return (A) this;
  }
  
  public A withExclusions(List<PolicyExclusion> exclusions) {
    if (this.exclusions != null) {
      this._visitables.get("exclusions").clear();
    }
    if (exclusions != null) {
        this.exclusions = new ArrayList();
        for (PolicyExclusion item : exclusions) {
          this.addToExclusions(item);
        }
    } else {
      this.exclusions = null;
    }
    return (A) this;
  }
  
  public A withExclusions(PolicyExclusion... exclusions) {
    if (this.exclusions != null) {
        this.exclusions.clear();
        _visitables.remove("exclusions");
    }
    if (exclusions != null) {
      for (PolicyExclusion item : exclusions) {
        this.addToExclusions(item);
      }
    }
    return (A) this;
  }
  
  public A withPlacement(String placement) {
    this.placement = placement;
    return (A) this;
  }
  
  public A withPlacementBinding(String placementBinding) {
    this.placementBinding = placementBinding;
    return (A) this;
  }
  
  public A withPlacementRule(String placementRule) {
    this.placementRule = placementRule;
    return (A) this;
  }
  
  public A withPolicySet(String policySet) {
    this.policySet = policySet;
    return (A) this;
  }
  public class DecisionsNested<N> extends PlacementDecisionFluent<DecisionsNested<N>> implements Nested<N>{
  
    PlacementDecisionBuilder builder;
    int index;
  
    DecisionsNested(int index,PlacementDecision item) {
      this.index = index;
      this.builder = new PlacementDecisionBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementFluent.this.setToDecisions(index, builder.build());
    }
    
    public N endDecision() {
      return and();
    }
    
  }
  public class ExclusionsNested<N> extends PolicyExclusionFluent<ExclusionsNested<N>> implements Nested<N>{
  
    PolicyExclusionBuilder builder;
    int index;
  
    ExclusionsNested(int index,PolicyExclusion item) {
      this.index = index;
      this.builder = new PolicyExclusionBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementFluent.this.setToExclusions(index, builder.build());
    }
    
    public N endExclusion() {
      return and();
    }
    
  }
}