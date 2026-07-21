package io.fabric8.openclustermanagement.api.model.apps.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
import java.lang.Integer;
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
public class PlacementRuleSpecFluent<A extends io.fabric8.openclustermanagement.api.model.apps.v1.PlacementRuleSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<ClusterConditionFilterBuilder> clusterConditions = new ArrayList<ClusterConditionFilterBuilder>();
  private Integer clusterReplicas;
  private LabelSelectorBuilder clusterSelector;
  private ArrayList<GenericClusterReferenceBuilder> clusters = new ArrayList<GenericClusterReferenceBuilder>();
  private ArrayList<ObjectReferenceBuilder> policies = new ArrayList<ObjectReferenceBuilder>();
  private ResourceHintBuilder resourceHint;
  private String schedulerName;

  public PlacementRuleSpecFluent() {
  }
  
  public PlacementRuleSpecFluent(PlacementRuleSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToClusterConditions(Collection<ClusterConditionFilter> items) {
    if (this.clusterConditions == null) {
      this.clusterConditions = new ArrayList();
    }
    for (ClusterConditionFilter item : items) {
        ClusterConditionFilterBuilder builder = new ClusterConditionFilterBuilder(item);
        _visitables.get("clusterConditions").add(builder);
        this.clusterConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToClusters(Collection<GenericClusterReference> items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").add(builder);
        this.clusters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPolicies(Collection<ObjectReference> items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public ClustersNested<A> addNewCluster() {
    return new ClustersNested(-1, null);
  }
  
  public A addNewCluster(String name) {
    return (A) this.addToClusters(new GenericClusterReference(name));
  }
  
  public ClusterConditionsNested<A> addNewClusterCondition() {
    return new ClusterConditionsNested(-1, null);
  }
  
  public A addNewClusterCondition(String status,String type) {
    return (A) this.addToClusterConditions(new ClusterConditionFilter(status, type));
  }
  
  public ClusterConditionsNested<A> addNewClusterConditionLike(ClusterConditionFilter item) {
    return new ClusterConditionsNested(-1, item);
  }
  
  public ClustersNested<A> addNewClusterLike(GenericClusterReference item) {
    return new ClustersNested(-1, item);
  }
  
  public PoliciesNested<A> addNewPolicy() {
    return new PoliciesNested(-1, null);
  }
  
  public PoliciesNested<A> addNewPolicyLike(ObjectReference item) {
    return new PoliciesNested(-1, item);
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
  
  public A addToClusterConditions(ClusterConditionFilter... items) {
    if (this.clusterConditions == null) {
      this.clusterConditions = new ArrayList();
    }
    for (ClusterConditionFilter item : items) {
        ClusterConditionFilterBuilder builder = new ClusterConditionFilterBuilder(item);
        _visitables.get("clusterConditions").add(builder);
        this.clusterConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterConditions(int index,ClusterConditionFilter item) {
    if (this.clusterConditions == null) {
      this.clusterConditions = new ArrayList();
    }
    ClusterConditionFilterBuilder builder = new ClusterConditionFilterBuilder(item);
    if (index < 0 || index >= clusterConditions.size()) {
        _visitables.get("clusterConditions").add(builder);
        clusterConditions.add(builder);
    } else {
        _visitables.get("clusterConditions").add(builder);
        clusterConditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToClusters(GenericClusterReference... items) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").add(builder);
        this.clusters.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusters(int index,GenericClusterReference item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
    if (index < 0 || index >= clusters.size()) {
        _visitables.get("clusters").add(builder);
        clusters.add(builder);
    } else {
        _visitables.get("clusters").add(builder);
        clusters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(ObjectReference... items) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("policies").add(builder);
        this.policies.add(builder);
    }
    return (A) this;
  }
  
  public A addToPolicies(int index,ObjectReference item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.add(index, builder);
    }
    return (A) this;
  }
  
  public GenericClusterReference buildCluster(int index) {
    return this.clusters.get(index).build();
  }
  
  public ClusterConditionFilter buildClusterCondition(int index) {
    return this.clusterConditions.get(index).build();
  }
  
  public List<ClusterConditionFilter> buildClusterConditions() {
    return this.clusterConditions != null ? build(clusterConditions) : null;
  }
  
  public LabelSelector buildClusterSelector() {
    return this.clusterSelector != null ? this.clusterSelector.build() : null;
  }
  
  public List<GenericClusterReference> buildClusters() {
    return this.clusters != null ? build(clusters) : null;
  }
  
  public GenericClusterReference buildFirstCluster() {
    return this.clusters.get(0).build();
  }
  
  public ClusterConditionFilter buildFirstClusterCondition() {
    return this.clusterConditions.get(0).build();
  }
  
  public ObjectReference buildFirstPolicy() {
    return this.policies.get(0).build();
  }
  
  public GenericClusterReference buildLastCluster() {
    return this.clusters.get(clusters.size() - 1).build();
  }
  
  public ClusterConditionFilter buildLastClusterCondition() {
    return this.clusterConditions.get(clusterConditions.size() - 1).build();
  }
  
  public ObjectReference buildLastPolicy() {
    return this.policies.get(policies.size() - 1).build();
  }
  
  public GenericClusterReference buildMatchingCluster(Predicate<GenericClusterReferenceBuilder> predicate) {
      for (GenericClusterReferenceBuilder item : clusters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterConditionFilter buildMatchingClusterCondition(Predicate<ClusterConditionFilterBuilder> predicate) {
      for (ClusterConditionFilterBuilder item : clusterConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectReference buildMatchingPolicy(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : policies) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public List<ObjectReference> buildPolicies() {
    return this.policies != null ? build(policies) : null;
  }
  
  public ObjectReference buildPolicy(int index) {
    return this.policies.get(index).build();
  }
  
  public ResourceHint buildResourceHint() {
    return this.resourceHint != null ? this.resourceHint.build() : null;
  }
  
  protected void copyInstance(PlacementRuleSpec instance) {
    instance = instance != null ? instance : new PlacementRuleSpec();
    if (instance != null) {
        this.withClusterConditions(instance.getClusterConditions());
        this.withClusterReplicas(instance.getClusterReplicas());
        this.withClusterSelector(instance.getClusterSelector());
        this.withClusters(instance.getClusters());
        this.withPolicies(instance.getPolicies());
        this.withResourceHint(instance.getResourceHint());
        this.withSchedulerName(instance.getSchedulerName());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ClustersNested<A> editCluster(int index) {
    if (clusters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ClusterConditionsNested<A> editClusterCondition(int index) {
    if (clusterConditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterConditions"));
    }
    return this.setNewClusterConditionLike(index, this.buildClusterCondition(index));
  }
  
  public ClusterSelectorNested<A> editClusterSelector() {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(null));
  }
  
  public ClustersNested<A> editFirstCluster() {
    if (clusters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusters"));
    }
    return this.setNewClusterLike(0, this.buildCluster(0));
  }
  
  public ClusterConditionsNested<A> editFirstClusterCondition() {
    if (clusterConditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterConditions"));
    }
    return this.setNewClusterConditionLike(0, this.buildClusterCondition(0));
  }
  
  public PoliciesNested<A> editFirstPolicy() {
    if (policies.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(0, this.buildPolicy(0));
  }
  
  public ClustersNested<A> editLastCluster() {
    int index = clusters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ClusterConditionsNested<A> editLastClusterCondition() {
    int index = clusterConditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterConditions"));
    }
    return this.setNewClusterConditionLike(index, this.buildClusterCondition(index));
  }
  
  public PoliciesNested<A> editLastPolicy() {
    int index = policies.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public ClustersNested<A> editMatchingCluster(Predicate<GenericClusterReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusters.size();i++) {
      if (predicate.test(clusters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusters"));
    }
    return this.setNewClusterLike(index, this.buildCluster(index));
  }
  
  public ClusterConditionsNested<A> editMatchingClusterCondition(Predicate<ClusterConditionFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterConditions.size();i++) {
      if (predicate.test(clusterConditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterConditions"));
    }
    return this.setNewClusterConditionLike(index, this.buildClusterCondition(index));
  }
  
  public PoliciesNested<A> editMatchingPolicy(Predicate<ObjectReferenceBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < policies.size();i++) {
      if (predicate.test(policies.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public ClusterSelectorNested<A> editOrNewClusterSelector() {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public ClusterSelectorNested<A> editOrNewClusterSelectorLike(LabelSelector item) {
    return this.withNewClusterSelectorLike(Optional.ofNullable(this.buildClusterSelector()).orElse(item));
  }
  
  public ResourceHintNested<A> editOrNewResourceHint() {
    return this.withNewResourceHintLike(Optional.ofNullable(this.buildResourceHint()).orElse(new ResourceHintBuilder().build()));
  }
  
  public ResourceHintNested<A> editOrNewResourceHintLike(ResourceHint item) {
    return this.withNewResourceHintLike(Optional.ofNullable(this.buildResourceHint()).orElse(item));
  }
  
  public PoliciesNested<A> editPolicy(int index) {
    if (policies.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "policies"));
    }
    return this.setNewPolicyLike(index, this.buildPolicy(index));
  }
  
  public ResourceHintNested<A> editResourceHint() {
    return this.withNewResourceHintLike(Optional.ofNullable(this.buildResourceHint()).orElse(null));
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
    PlacementRuleSpecFluent that = (PlacementRuleSpecFluent) o;
    if (!(Objects.equals(clusterConditions, that.clusterConditions))) {
      return false;
    }
    if (!(Objects.equals(clusterReplicas, that.clusterReplicas))) {
      return false;
    }
    if (!(Objects.equals(clusterSelector, that.clusterSelector))) {
      return false;
    }
    if (!(Objects.equals(clusters, that.clusters))) {
      return false;
    }
    if (!(Objects.equals(policies, that.policies))) {
      return false;
    }
    if (!(Objects.equals(resourceHint, that.resourceHint))) {
      return false;
    }
    if (!(Objects.equals(schedulerName, that.schedulerName))) {
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
  
  public Integer getClusterReplicas() {
    return this.clusterReplicas;
  }
  
  public String getSchedulerName() {
    return this.schedulerName;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasClusterConditions() {
    return this.clusterConditions != null && !(this.clusterConditions.isEmpty());
  }
  
  public boolean hasClusterReplicas() {
    return this.clusterReplicas != null;
  }
  
  public boolean hasClusterSelector() {
    return this.clusterSelector != null;
  }
  
  public boolean hasClusters() {
    return this.clusters != null && !(this.clusters.isEmpty());
  }
  
  public boolean hasMatchingCluster(Predicate<GenericClusterReferenceBuilder> predicate) {
      for (GenericClusterReferenceBuilder item : clusters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingClusterCondition(Predicate<ClusterConditionFilterBuilder> predicate) {
      for (ClusterConditionFilterBuilder item : clusterConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPolicy(Predicate<ObjectReferenceBuilder> predicate) {
      for (ObjectReferenceBuilder item : policies) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPolicies() {
    return this.policies != null && !(this.policies.isEmpty());
  }
  
  public boolean hasResourceHint() {
    return this.resourceHint != null;
  }
  
  public boolean hasSchedulerName() {
    return this.schedulerName != null;
  }
  
  public int hashCode() {
    return Objects.hash(clusterConditions, clusterReplicas, clusterSelector, clusters, policies, resourceHint, schedulerName, additionalProperties);
  }
  
  public A removeAllFromClusterConditions(Collection<ClusterConditionFilter> items) {
    if (this.clusterConditions == null) {
      return (A) this;
    }
    for (ClusterConditionFilter item : items) {
        ClusterConditionFilterBuilder builder = new ClusterConditionFilterBuilder(item);
        _visitables.get("clusterConditions").remove(builder);
        this.clusterConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromClusters(Collection<GenericClusterReference> items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").remove(builder);
        this.clusters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPolicies(Collection<ObjectReference> items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
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
  
  public A removeFromClusterConditions(ClusterConditionFilter... items) {
    if (this.clusterConditions == null) {
      return (A) this;
    }
    for (ClusterConditionFilter item : items) {
        ClusterConditionFilterBuilder builder = new ClusterConditionFilterBuilder(item);
        _visitables.get("clusterConditions").remove(builder);
        this.clusterConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromClusters(GenericClusterReference... items) {
    if (this.clusters == null) {
      return (A) this;
    }
    for (GenericClusterReference item : items) {
        GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
        _visitables.get("clusters").remove(builder);
        this.clusters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPolicies(ObjectReference... items) {
    if (this.policies == null) {
      return (A) this;
    }
    for (ObjectReference item : items) {
        ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
        _visitables.get("policies").remove(builder);
        this.policies.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterConditions(Predicate<ClusterConditionFilterBuilder> predicate) {
    if (clusterConditions == null) {
      return (A) this;
    }
    Iterator<ClusterConditionFilterBuilder> each = clusterConditions.iterator();
    List visitables = _visitables.get("clusterConditions");
    while (each.hasNext()) {
        ClusterConditionFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusters(Predicate<GenericClusterReferenceBuilder> predicate) {
    if (clusters == null) {
      return (A) this;
    }
    Iterator<GenericClusterReferenceBuilder> each = clusters.iterator();
    List visitables = _visitables.get("clusters");
    while (each.hasNext()) {
        GenericClusterReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPolicies(Predicate<ObjectReferenceBuilder> predicate) {
    if (policies == null) {
      return (A) this;
    }
    Iterator<ObjectReferenceBuilder> each = policies.iterator();
    List visitables = _visitables.get("policies");
    while (each.hasNext()) {
        ObjectReferenceBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ClusterConditionsNested<A> setNewClusterConditionLike(int index,ClusterConditionFilter item) {
    return new ClusterConditionsNested(index, item);
  }
  
  public ClustersNested<A> setNewClusterLike(int index,GenericClusterReference item) {
    return new ClustersNested(index, item);
  }
  
  public PoliciesNested<A> setNewPolicyLike(int index,ObjectReference item) {
    return new PoliciesNested(index, item);
  }
  
  public A setToClusterConditions(int index,ClusterConditionFilter item) {
    if (this.clusterConditions == null) {
      this.clusterConditions = new ArrayList();
    }
    ClusterConditionFilterBuilder builder = new ClusterConditionFilterBuilder(item);
    if (index < 0 || index >= clusterConditions.size()) {
        _visitables.get("clusterConditions").add(builder);
        clusterConditions.add(builder);
    } else {
        _visitables.get("clusterConditions").add(builder);
        clusterConditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToClusters(int index,GenericClusterReference item) {
    if (this.clusters == null) {
      this.clusters = new ArrayList();
    }
    GenericClusterReferenceBuilder builder = new GenericClusterReferenceBuilder(item);
    if (index < 0 || index >= clusters.size()) {
        _visitables.get("clusters").add(builder);
        clusters.add(builder);
    } else {
        _visitables.get("clusters").add(builder);
        clusters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPolicies(int index,ObjectReference item) {
    if (this.policies == null) {
      this.policies = new ArrayList();
    }
    ObjectReferenceBuilder builder = new ObjectReferenceBuilder(item);
    if (index < 0 || index >= policies.size()) {
        _visitables.get("policies").add(builder);
        policies.add(builder);
    } else {
        _visitables.get("policies").add(builder);
        policies.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(clusterConditions == null) && !(clusterConditions.isEmpty())) {
        sb.append("clusterConditions:");
        sb.append(clusterConditions);
        sb.append(",");
    }
    if (!(clusterReplicas == null)) {
        sb.append("clusterReplicas:");
        sb.append(clusterReplicas);
        sb.append(",");
    }
    if (!(clusterSelector == null)) {
        sb.append("clusterSelector:");
        sb.append(clusterSelector);
        sb.append(",");
    }
    if (!(clusters == null) && !(clusters.isEmpty())) {
        sb.append("clusters:");
        sb.append(clusters);
        sb.append(",");
    }
    if (!(policies == null) && !(policies.isEmpty())) {
        sb.append("policies:");
        sb.append(policies);
        sb.append(",");
    }
    if (!(resourceHint == null)) {
        sb.append("resourceHint:");
        sb.append(resourceHint);
        sb.append(",");
    }
    if (!(schedulerName == null)) {
        sb.append("schedulerName:");
        sb.append(schedulerName);
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
  
  public A withClusterConditions(List<ClusterConditionFilter> clusterConditions) {
    if (this.clusterConditions != null) {
      this._visitables.get("clusterConditions").clear();
    }
    if (clusterConditions != null) {
        this.clusterConditions = new ArrayList();
        for (ClusterConditionFilter item : clusterConditions) {
          this.addToClusterConditions(item);
        }
    } else {
      this.clusterConditions = null;
    }
    return (A) this;
  }
  
  public A withClusterConditions(ClusterConditionFilter... clusterConditions) {
    if (this.clusterConditions != null) {
        this.clusterConditions.clear();
        _visitables.remove("clusterConditions");
    }
    if (clusterConditions != null) {
      for (ClusterConditionFilter item : clusterConditions) {
        this.addToClusterConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withClusterReplicas(Integer clusterReplicas) {
    this.clusterReplicas = clusterReplicas;
    return (A) this;
  }
  
  public A withClusterSelector(LabelSelector clusterSelector) {
    this._visitables.remove("clusterSelector");
    if (clusterSelector != null) {
        this.clusterSelector = new LabelSelectorBuilder(clusterSelector);
        this._visitables.get("clusterSelector").add(this.clusterSelector);
    } else {
        this.clusterSelector = null;
        this._visitables.get("clusterSelector").remove(this.clusterSelector);
    }
    return (A) this;
  }
  
  public A withClusters(List<GenericClusterReference> clusters) {
    if (this.clusters != null) {
      this._visitables.get("clusters").clear();
    }
    if (clusters != null) {
        this.clusters = new ArrayList();
        for (GenericClusterReference item : clusters) {
          this.addToClusters(item);
        }
    } else {
      this.clusters = null;
    }
    return (A) this;
  }
  
  public A withClusters(GenericClusterReference... clusters) {
    if (this.clusters != null) {
        this.clusters.clear();
        _visitables.remove("clusters");
    }
    if (clusters != null) {
      for (GenericClusterReference item : clusters) {
        this.addToClusters(item);
      }
    }
    return (A) this;
  }
  
  public ClusterSelectorNested<A> withNewClusterSelector() {
    return new ClusterSelectorNested(null);
  }
  
  public ClusterSelectorNested<A> withNewClusterSelectorLike(LabelSelector item) {
    return new ClusterSelectorNested(item);
  }
  
  public ResourceHintNested<A> withNewResourceHint() {
    return new ResourceHintNested(null);
  }
  
  public A withNewResourceHint(String order,String type) {
    return (A) this.withResourceHint(new ResourceHint(order, type));
  }
  
  public ResourceHintNested<A> withNewResourceHintLike(ResourceHint item) {
    return new ResourceHintNested(item);
  }
  
  public A withPolicies(List<ObjectReference> policies) {
    if (this.policies != null) {
      this._visitables.get("policies").clear();
    }
    if (policies != null) {
        this.policies = new ArrayList();
        for (ObjectReference item : policies) {
          this.addToPolicies(item);
        }
    } else {
      this.policies = null;
    }
    return (A) this;
  }
  
  public A withPolicies(ObjectReference... policies) {
    if (this.policies != null) {
        this.policies.clear();
        _visitables.remove("policies");
    }
    if (policies != null) {
      for (ObjectReference item : policies) {
        this.addToPolicies(item);
      }
    }
    return (A) this;
  }
  
  public A withResourceHint(ResourceHint resourceHint) {
    this._visitables.remove("resourceHint");
    if (resourceHint != null) {
        this.resourceHint = new ResourceHintBuilder(resourceHint);
        this._visitables.get("resourceHint").add(this.resourceHint);
    } else {
        this.resourceHint = null;
        this._visitables.get("resourceHint").remove(this.resourceHint);
    }
    return (A) this;
  }
  
  public A withSchedulerName(String schedulerName) {
    this.schedulerName = schedulerName;
    return (A) this;
  }
  public class ClusterConditionsNested<N> extends ClusterConditionFilterFluent<ClusterConditionsNested<N>> implements Nested<N>{
  
    ClusterConditionFilterBuilder builder;
    int index;
  
    ClusterConditionsNested(int index,ClusterConditionFilter item) {
      this.index = index;
      this.builder = new ClusterConditionFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementRuleSpecFluent.this.setToClusterConditions(index, builder.build());
    }
    
    public N endClusterCondition() {
      return and();
    }
    
  }
  public class ClusterSelectorNested<N> extends LabelSelectorFluent<ClusterSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    ClusterSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementRuleSpecFluent.this.withClusterSelector(builder.build());
    }
    
    public N endClusterSelector() {
      return and();
    }
    
  }
  public class ClustersNested<N> extends GenericClusterReferenceFluent<ClustersNested<N>> implements Nested<N>{
  
    GenericClusterReferenceBuilder builder;
    int index;
  
    ClustersNested(int index,GenericClusterReference item) {
      this.index = index;
      this.builder = new GenericClusterReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementRuleSpecFluent.this.setToClusters(index, builder.build());
    }
    
    public N endCluster() {
      return and();
    }
    
  }
  public class PoliciesNested<N> extends ObjectReferenceFluent<PoliciesNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
    int index;
  
    PoliciesNested(int index,ObjectReference item) {
      this.index = index;
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementRuleSpecFluent.this.setToPolicies(index, builder.build());
    }
    
    public N endPolicy() {
      return and();
    }
    
  }
  public class ResourceHintNested<N> extends ResourceHintFluent<ResourceHintNested<N>> implements Nested<N>{
  
    ResourceHintBuilder builder;
  
    ResourceHintNested(ResourceHint item) {
      this.builder = new ResourceHintBuilder(this, item);
    }
  
    public N and() {
      return (N) PlacementRuleSpecFluent.this.withResourceHint(builder.build());
    }
    
    public N endResourceHint() {
      return and();
    }
    
  }
}