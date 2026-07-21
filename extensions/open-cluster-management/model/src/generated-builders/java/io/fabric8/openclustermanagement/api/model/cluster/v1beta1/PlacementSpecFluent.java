package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
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
public class PlacementSpecFluent<A extends io.fabric8.openclustermanagement.api.model.cluster.v1beta1.PlacementSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> clusterSets = new ArrayList<String>();
  private DecisionStrategyBuilder decisionStrategy;
  private Integer numberOfClusters;
  private ArrayList<ClusterPredicateBuilder> predicates = new ArrayList<ClusterPredicateBuilder>();
  private PrioritizerPolicyBuilder prioritizerPolicy;
  private String scoreRateLimit;
  private String sortBy;
  private SpreadPolicyBuilder spreadPolicy;
  private ArrayList<TolerationBuilder> tolerations = new ArrayList<TolerationBuilder>();

  public PlacementSpecFluent() {
  }
  
  public PlacementSpecFluent(PlacementSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterSets(Collection<String> items) {
    if (this.clusterSets == null) {
      this.clusterSets = new ArrayList();
    }
    for (String item : items) {
      this.clusterSets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPredicates(Collection<ClusterPredicate> items) {
    if (this.predicates == null) {
      this.predicates = new ArrayList();
    }
    for (ClusterPredicate item : items) {
        ClusterPredicateBuilder builder = new ClusterPredicateBuilder(item);
        _visitables.get("predicates").add(builder);
        this.predicates.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").add(builder);
        this.tolerations.add(builder);
    }
    return (A) this;
  }
  
  public PredicatesNested<A> addNewPredicate() {
    return new PredicatesNested(-1, null);
  }
  
  public PredicatesNested<A> addNewPredicateLike(ClusterPredicate item) {
    return new PredicatesNested(-1, item);
  }
  
  public TolerationsNested<A> addNewToleration() {
    return new TolerationsNested(-1, null);
  }
  
  public A addNewToleration(String effect,String key,String operator,Long tolerationSeconds,String value) {
    return (A) this.addToTolerations(new Toleration(effect, key, operator, tolerationSeconds, value));
  }
  
  public TolerationsNested<A> addNewTolerationLike(Toleration item) {
    return new TolerationsNested(-1, item);
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
  
  public A addToClusterSets(String... items) {
    if (this.clusterSets == null) {
      this.clusterSets = new ArrayList();
    }
    for (String item : items) {
      this.clusterSets.add(item);
    }
    return (A) this;
  }
  
  public A addToClusterSets(int index,String item) {
    if (this.clusterSets == null) {
      this.clusterSets = new ArrayList();
    }
    this.clusterSets.add(index, item);
    return (A) this;
  }
  
  public A addToPredicates(ClusterPredicate... items) {
    if (this.predicates == null) {
      this.predicates = new ArrayList();
    }
    for (ClusterPredicate item : items) {
        ClusterPredicateBuilder builder = new ClusterPredicateBuilder(item);
        _visitables.get("predicates").add(builder);
        this.predicates.add(builder);
    }
    return (A) this;
  }
  
  public A addToPredicates(int index,ClusterPredicate item) {
    if (this.predicates == null) {
      this.predicates = new ArrayList();
    }
    ClusterPredicateBuilder builder = new ClusterPredicateBuilder(item);
    if (index < 0 || index >= predicates.size()) {
        _visitables.get("predicates").add(builder);
        predicates.add(builder);
    } else {
        _visitables.get("predicates").add(builder);
        predicates.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToTolerations(Toleration... items) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").add(builder);
        this.tolerations.add(builder);
    }
    return (A) this;
  }
  
  public A addToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    TolerationBuilder builder = new TolerationBuilder(item);
    if (index < 0 || index >= tolerations.size()) {
        _visitables.get("tolerations").add(builder);
        tolerations.add(builder);
    } else {
        _visitables.get("tolerations").add(builder);
        tolerations.add(index, builder);
    }
    return (A) this;
  }
  
  public DecisionStrategy buildDecisionStrategy() {
    return this.decisionStrategy != null ? this.decisionStrategy.build() : null;
  }
  
  public ClusterPredicate buildFirstPredicate() {
    return this.predicates.get(0).build();
  }
  
  public Toleration buildFirstToleration() {
    return this.tolerations.get(0).build();
  }
  
  public ClusterPredicate buildLastPredicate() {
    return this.predicates.get(predicates.size() - 1).build();
  }
  
  public Toleration buildLastToleration() {
    return this.tolerations.get(tolerations.size() - 1).build();
  }
  
  public ClusterPredicate buildMatchingPredicate(Predicate<ClusterPredicateBuilder> predicate) {
      for (ClusterPredicateBuilder item : predicates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Toleration buildMatchingToleration(Predicate<TolerationBuilder> predicate) {
      for (TolerationBuilder item : tolerations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterPredicate buildPredicate(int index) {
    return this.predicates.get(index).build();
  }
  
  public List<ClusterPredicate> buildPredicates() {
    return this.predicates != null ? build(predicates) : null;
  }
  
  public PrioritizerPolicy buildPrioritizerPolicy() {
    return this.prioritizerPolicy != null ? this.prioritizerPolicy.build() : null;
  }
  
  public SpreadPolicy buildSpreadPolicy() {
    return this.spreadPolicy != null ? this.spreadPolicy.build() : null;
  }
  
  public Toleration buildToleration(int index) {
    return this.tolerations.get(index).build();
  }
  
  public List<Toleration> buildTolerations() {
    return this.tolerations != null ? build(tolerations) : null;
  }
  
  protected void copyInstance(PlacementSpec instance) {
    instance = instance != null ? instance : new PlacementSpec();
    if (instance != null) {
        this.withClusterSets(instance.getClusterSets());
        this.withDecisionStrategy(instance.getDecisionStrategy());
        this.withNumberOfClusters(instance.getNumberOfClusters());
        this.withPredicates(instance.getPredicates());
        this.withPrioritizerPolicy(instance.getPrioritizerPolicy());
        this.withScoreRateLimit(instance.getScoreRateLimit());
        this.withSortBy(instance.getSortBy());
        this.withSpreadPolicy(instance.getSpreadPolicy());
        this.withTolerations(instance.getTolerations());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DecisionStrategyNested<A> editDecisionStrategy() {
    return this.withNewDecisionStrategyLike(Optional.ofNullable(this.buildDecisionStrategy()).orElse(null));
  }
  
  public PredicatesNested<A> editFirstPredicate() {
    if (predicates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "predicates"));
    }
    return this.setNewPredicateLike(0, this.buildPredicate(0));
  }
  
  public TolerationsNested<A> editFirstToleration() {
    if (tolerations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tolerations"));
    }
    return this.setNewTolerationLike(0, this.buildToleration(0));
  }
  
  public PredicatesNested<A> editLastPredicate() {
    int index = predicates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "predicates"));
    }
    return this.setNewPredicateLike(index, this.buildPredicate(index));
  }
  
  public TolerationsNested<A> editLastToleration() {
    int index = tolerations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
  }
  
  public PredicatesNested<A> editMatchingPredicate(Predicate<ClusterPredicateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < predicates.size();i++) {
      if (predicate.test(predicates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "predicates"));
    }
    return this.setNewPredicateLike(index, this.buildPredicate(index));
  }
  
  public TolerationsNested<A> editMatchingToleration(Predicate<TolerationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tolerations.size();i++) {
      if (predicate.test(tolerations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
  }
  
  public DecisionStrategyNested<A> editOrNewDecisionStrategy() {
    return this.withNewDecisionStrategyLike(Optional.ofNullable(this.buildDecisionStrategy()).orElse(new DecisionStrategyBuilder().build()));
  }
  
  public DecisionStrategyNested<A> editOrNewDecisionStrategyLike(DecisionStrategy item) {
    return this.withNewDecisionStrategyLike(Optional.ofNullable(this.buildDecisionStrategy()).orElse(item));
  }
  
  public PrioritizerPolicyNested<A> editOrNewPrioritizerPolicy() {
    return this.withNewPrioritizerPolicyLike(Optional.ofNullable(this.buildPrioritizerPolicy()).orElse(new PrioritizerPolicyBuilder().build()));
  }
  
  public PrioritizerPolicyNested<A> editOrNewPrioritizerPolicyLike(PrioritizerPolicy item) {
    return this.withNewPrioritizerPolicyLike(Optional.ofNullable(this.buildPrioritizerPolicy()).orElse(item));
  }
  
  public SpreadPolicyNested<A> editOrNewSpreadPolicy() {
    return this.withNewSpreadPolicyLike(Optional.ofNullable(this.buildSpreadPolicy()).orElse(new SpreadPolicyBuilder().build()));
  }
  
  public SpreadPolicyNested<A> editOrNewSpreadPolicyLike(SpreadPolicy item) {
    return this.withNewSpreadPolicyLike(Optional.ofNullable(this.buildSpreadPolicy()).orElse(item));
  }
  
  public PredicatesNested<A> editPredicate(int index) {
    if (predicates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "predicates"));
    }
    return this.setNewPredicateLike(index, this.buildPredicate(index));
  }
  
  public PrioritizerPolicyNested<A> editPrioritizerPolicy() {
    return this.withNewPrioritizerPolicyLike(Optional.ofNullable(this.buildPrioritizerPolicy()).orElse(null));
  }
  
  public SpreadPolicyNested<A> editSpreadPolicy() {
    return this.withNewSpreadPolicyLike(Optional.ofNullable(this.buildSpreadPolicy()).orElse(null));
  }
  
  public TolerationsNested<A> editToleration(int index) {
    if (tolerations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tolerations"));
    }
    return this.setNewTolerationLike(index, this.buildToleration(index));
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
    PlacementSpecFluent that = (PlacementSpecFluent) o;
    if (!(Objects.equals(clusterSets, that.clusterSets))) {
      return false;
    }
    if (!(Objects.equals(decisionStrategy, that.decisionStrategy))) {
      return false;
    }
    if (!(Objects.equals(numberOfClusters, that.numberOfClusters))) {
      return false;
    }
    if (!(Objects.equals(predicates, that.predicates))) {
      return false;
    }
    if (!(Objects.equals(prioritizerPolicy, that.prioritizerPolicy))) {
      return false;
    }
    if (!(Objects.equals(scoreRateLimit, that.scoreRateLimit))) {
      return false;
    }
    if (!(Objects.equals(sortBy, that.sortBy))) {
      return false;
    }
    if (!(Objects.equals(spreadPolicy, that.spreadPolicy))) {
      return false;
    }
    if (!(Objects.equals(tolerations, that.tolerations))) {
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
  
  public String getClusterSet(int index) {
    return this.clusterSets.get(index);
  }
  
  public List<String> getClusterSets() {
    return this.clusterSets;
  }
  
  public String getFirstClusterSet() {
    return this.clusterSets.get(0);
  }
  
  public String getLastClusterSet() {
    return this.clusterSets.get(clusterSets.size() - 1);
  }
  
  public String getMatchingClusterSet(Predicate<String> predicate) {
      for (String item : clusterSets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getNumberOfClusters() {
    return this.numberOfClusters;
  }
  
  public String getScoreRateLimit() {
    return this.scoreRateLimit;
  }
  
  public String getSortBy() {
    return this.sortBy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterSets() {
    return this.clusterSets != null && !(this.clusterSets.isEmpty());
  }
  
  public boolean hasDecisionStrategy() {
    return this.decisionStrategy != null;
  }
  
  public boolean hasMatchingClusterSet(Predicate<String> predicate) {
      for (String item : clusterSets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPredicate(Predicate<ClusterPredicateBuilder> predicate) {
      for (ClusterPredicateBuilder item : predicates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingToleration(Predicate<TolerationBuilder> predicate) {
      for (TolerationBuilder item : tolerations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNumberOfClusters() {
    return this.numberOfClusters != null;
  }
  
  public boolean hasPredicates() {
    return this.predicates != null && !(this.predicates.isEmpty());
  }
  
  public boolean hasPrioritizerPolicy() {
    return this.prioritizerPolicy != null;
  }
  
  public boolean hasScoreRateLimit() {
    return this.scoreRateLimit != null;
  }
  
  public boolean hasSortBy() {
    return this.sortBy != null;
  }
  
  public boolean hasSpreadPolicy() {
    return this.spreadPolicy != null;
  }
  
  public boolean hasTolerations() {
    return this.tolerations != null && !(this.tolerations.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(clusterSets, decisionStrategy, numberOfClusters, predicates, prioritizerPolicy, scoreRateLimit, sortBy, spreadPolicy, tolerations, additionalProperties);
  }
  
  public A removeAllFromClusterSets(Collection<String> items) {
    if (this.clusterSets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterSets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPredicates(Collection<ClusterPredicate> items) {
    if (this.predicates == null) {
      return (A) this;
    }
    for (ClusterPredicate item : items) {
        ClusterPredicateBuilder builder = new ClusterPredicateBuilder(item);
        _visitables.get("predicates").remove(builder);
        this.predicates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromTolerations(Collection<Toleration> items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").remove(builder);
        this.tolerations.remove(builder);
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
  
  public A removeFromClusterSets(String... items) {
    if (this.clusterSets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.clusterSets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPredicates(ClusterPredicate... items) {
    if (this.predicates == null) {
      return (A) this;
    }
    for (ClusterPredicate item : items) {
        ClusterPredicateBuilder builder = new ClusterPredicateBuilder(item);
        _visitables.get("predicates").remove(builder);
        this.predicates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromTolerations(Toleration... items) {
    if (this.tolerations == null) {
      return (A) this;
    }
    for (Toleration item : items) {
        TolerationBuilder builder = new TolerationBuilder(item);
        _visitables.get("tolerations").remove(builder);
        this.tolerations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromPredicates(Predicate<ClusterPredicateBuilder> predicate) {
    if (predicates == null) {
      return (A) this;
    }
    Iterator<ClusterPredicateBuilder> each = predicates.iterator();
    List visitables = _visitables.get("predicates");
    while (each.hasNext()) {
        ClusterPredicateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromTolerations(Predicate<TolerationBuilder> predicate) {
    if (tolerations == null) {
      return (A) this;
    }
    Iterator<TolerationBuilder> each = tolerations.iterator();
    List visitables = _visitables.get("tolerations");
    while (each.hasNext()) {
        TolerationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public PredicatesNested<A> setNewPredicateLike(int index,ClusterPredicate item) {
    return new PredicatesNested(index, item);
  }
  
  public TolerationsNested<A> setNewTolerationLike(int index,Toleration item) {
    return new TolerationsNested(index, item);
  }
  
  public A setToClusterSets(int index,String item) {
    if (this.clusterSets == null) {
      this.clusterSets = new ArrayList();
    }
    this.clusterSets.set(index, item);
    return (A) this;
  }
  
  public A setToPredicates(int index,ClusterPredicate item) {
    if (this.predicates == null) {
      this.predicates = new ArrayList();
    }
    ClusterPredicateBuilder builder = new ClusterPredicateBuilder(item);
    if (index < 0 || index >= predicates.size()) {
        _visitables.get("predicates").add(builder);
        predicates.add(builder);
    } else {
        _visitables.get("predicates").add(builder);
        predicates.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToTolerations(int index,Toleration item) {
    if (this.tolerations == null) {
      this.tolerations = new ArrayList();
    }
    TolerationBuilder builder = new TolerationBuilder(item);
    if (index < 0 || index >= tolerations.size()) {
        _visitables.get("tolerations").add(builder);
        tolerations.add(builder);
    } else {
        _visitables.get("tolerations").add(builder);
        tolerations.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterSets == null) && !(clusterSets.isEmpty())) {
        sb.append("clusterSets:");
        sb.append(clusterSets);
        sb.append(",");
    }
    if (!(decisionStrategy == null)) {
        sb.append("decisionStrategy:");
        sb.append(decisionStrategy);
        sb.append(",");
    }
    if (!(numberOfClusters == null)) {
        sb.append("numberOfClusters:");
        sb.append(numberOfClusters);
        sb.append(",");
    }
    if (!(predicates == null) && !(predicates.isEmpty())) {
        sb.append("predicates:");
        sb.append(predicates);
        sb.append(",");
    }
    if (!(prioritizerPolicy == null)) {
        sb.append("prioritizerPolicy:");
        sb.append(prioritizerPolicy);
        sb.append(",");
    }
    if (!(scoreRateLimit == null)) {
        sb.append("scoreRateLimit:");
        sb.append(scoreRateLimit);
        sb.append(",");
    }
    if (!(sortBy == null)) {
        sb.append("sortBy:");
        sb.append(sortBy);
        sb.append(",");
    }
    if (!(spreadPolicy == null)) {
        sb.append("spreadPolicy:");
        sb.append(spreadPolicy);
        sb.append(",");
    }
    if (!(tolerations == null) && !(tolerations.isEmpty())) {
        sb.append("tolerations:");
        sb.append(tolerations);
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
  
  public A withClusterSets(List<String> clusterSets) {
    if (clusterSets != null) {
        this.clusterSets = new ArrayList();
        for (String item : clusterSets) {
          this.addToClusterSets(item);
        }
    } else {
      this.clusterSets = null;
    }
    return (A) this;
  }
  
  public A withClusterSets(String... clusterSets) {
    if (this.clusterSets != null) {
        this.clusterSets.clear();
        _visitables.remove("clusterSets");
    }
    if (clusterSets != null) {
      for (String item : clusterSets) {
        this.addToClusterSets(item);
      }
    }
    return (A) this;
  }
  
  public A withDecisionStrategy(DecisionStrategy decisionStrategy) {
    this._visitables.remove("decisionStrategy");
    if (decisionStrategy != null) {
        this.decisionStrategy = new DecisionStrategyBuilder(decisionStrategy);
        this._visitables.get("decisionStrategy").add(this.decisionStrategy);
    } else {
        this.decisionStrategy = null;
        this._visitables.get("decisionStrategy").remove(this.decisionStrategy);
    }
    return (A) this;
  }
  
  public DecisionStrategyNested<A> withNewDecisionStrategy() {
    return new DecisionStrategyNested(null);
  }
  
  public DecisionStrategyNested<A> withNewDecisionStrategyLike(DecisionStrategy item) {
    return new DecisionStrategyNested(item);
  }
  
  public PrioritizerPolicyNested<A> withNewPrioritizerPolicy() {
    return new PrioritizerPolicyNested(null);
  }
  
  public PrioritizerPolicyNested<A> withNewPrioritizerPolicyLike(PrioritizerPolicy item) {
    return new PrioritizerPolicyNested(item);
  }
  
  public SpreadPolicyNested<A> withNewSpreadPolicy() {
    return new SpreadPolicyNested(null);
  }
  
  public SpreadPolicyNested<A> withNewSpreadPolicyLike(SpreadPolicy item) {
    return new SpreadPolicyNested(item);
  }
  
  public A withNumberOfClusters(Integer numberOfClusters) {
    this.numberOfClusters = numberOfClusters;
    return (A) this;
  }
  
  public A withPredicates(List<ClusterPredicate> predicates) {
    if (this.predicates != null) {
      this._visitables.get("predicates").clear();
    }
    if (predicates != null) {
        this.predicates = new ArrayList();
        for (ClusterPredicate item : predicates) {
          this.addToPredicates(item);
        }
    } else {
      this.predicates = null;
    }
    return (A) this;
  }
  
  public A withPredicates(ClusterPredicate... predicates) {
    if (this.predicates != null) {
        this.predicates.clear();
        _visitables.remove("predicates");
    }
    if (predicates != null) {
      for (ClusterPredicate item : predicates) {
        this.addToPredicates(item);
      }
    }
    return (A) this;
  }
  
  public A withPrioritizerPolicy(PrioritizerPolicy prioritizerPolicy) {
    this._visitables.remove("prioritizerPolicy");
    if (prioritizerPolicy != null) {
        this.prioritizerPolicy = new PrioritizerPolicyBuilder(prioritizerPolicy);
        this._visitables.get("prioritizerPolicy").add(this.prioritizerPolicy);
    } else {
        this.prioritizerPolicy = null;
        this._visitables.get("prioritizerPolicy").remove(this.prioritizerPolicy);
    }
    return (A) this;
  }
  
  public A withScoreRateLimit(String scoreRateLimit) {
    this.scoreRateLimit = scoreRateLimit;
    return (A) this;
  }
  
  public A withSortBy(String sortBy) {
    this.sortBy = sortBy;
    return (A) this;
  }
  
  public A withSpreadPolicy(SpreadPolicy spreadPolicy) {
    this._visitables.remove("spreadPolicy");
    if (spreadPolicy != null) {
        this.spreadPolicy = new SpreadPolicyBuilder(spreadPolicy);
        this._visitables.get("spreadPolicy").add(this.spreadPolicy);
    } else {
        this.spreadPolicy = null;
        this._visitables.get("spreadPolicy").remove(this.spreadPolicy);
    }
    return (A) this;
  }
  
  public A withTolerations(List<Toleration> tolerations) {
    if (this.tolerations != null) {
      this._visitables.get("tolerations").clear();
    }
    if (tolerations != null) {
        this.tolerations = new ArrayList();
        for (Toleration item : tolerations) {
          this.addToTolerations(item);
        }
    } else {
      this.tolerations = null;
    }
    return (A) this;
  }
  
  public A withTolerations(Toleration... tolerations) {
    if (this.tolerations != null) {
        this.tolerations.clear();
        _visitables.remove("tolerations");
    }
    if (tolerations != null) {
      for (Toleration item : tolerations) {
        this.addToTolerations(item);
      }
    }
    return (A) this;
  }
  public class DecisionStrategyNested<N> extends DecisionStrategyFluent<DecisionStrategyNested<N>> implements Nested<N>{
  
    DecisionStrategyBuilder builder;
  
    DecisionStrategyNested(DecisionStrategy item) {
      this.builder = new DecisionStrategyBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementSpecFluent.this.withDecisionStrategy(builder.build());
    }
    
    public N endDecisionStrategy() {
      return and();
    }
    
  }
  public class PredicatesNested<N> extends ClusterPredicateFluent<PredicatesNested<N>> implements Nested<N>{
  
    ClusterPredicateBuilder builder;
    int index;
  
    PredicatesNested(int index,ClusterPredicate item) {
      this.index = index;
      this.builder = new ClusterPredicateBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementSpecFluent.this.setToPredicates(index, builder.build());
    }
    
    public N endPredicate() {
      return and();
    }
    
  }
  public class PrioritizerPolicyNested<N> extends PrioritizerPolicyFluent<PrioritizerPolicyNested<N>> implements Nested<N>{
  
    PrioritizerPolicyBuilder builder;
  
    PrioritizerPolicyNested(PrioritizerPolicy item) {
      this.builder = new PrioritizerPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementSpecFluent.this.withPrioritizerPolicy(builder.build());
    }
    
    public N endPrioritizerPolicy() {
      return and();
    }
    
  }
  public class SpreadPolicyNested<N> extends SpreadPolicyFluent<SpreadPolicyNested<N>> implements Nested<N>{
  
    SpreadPolicyBuilder builder;
  
    SpreadPolicyNested(SpreadPolicy item) {
      this.builder = new SpreadPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementSpecFluent.this.withSpreadPolicy(builder.build());
    }
    
    public N endSpreadPolicy() {
      return and();
    }
    
  }
  public class TolerationsNested<N> extends TolerationFluent<TolerationsNested<N>> implements Nested<N>{
  
    TolerationBuilder builder;
    int index;
  
    TolerationsNested(int index,Toleration item) {
      this.index = index;
      this.builder = new TolerationBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementSpecFluent.this.setToTolerations(index, builder.build());
    }
    
    public N endToleration() {
      return and();
    }
    
  }
}