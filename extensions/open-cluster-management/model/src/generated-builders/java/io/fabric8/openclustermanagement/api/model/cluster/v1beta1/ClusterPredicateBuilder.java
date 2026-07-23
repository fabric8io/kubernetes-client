package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterPredicateBuilder extends ClusterPredicateFluent<ClusterPredicateBuilder> implements VisitableBuilder<ClusterPredicate,ClusterPredicateBuilder>{

  ClusterPredicateFluent<?> fluent;

  public ClusterPredicateBuilder() {
    this(new ClusterPredicate());
  }
  
  public ClusterPredicateBuilder(ClusterPredicateFluent<?> fluent) {
    this(fluent, new ClusterPredicate());
  }
  
  public ClusterPredicateBuilder(ClusterPredicate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterPredicateBuilder(ClusterPredicateFluent<?> fluent,ClusterPredicate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterPredicate build() {
    ClusterPredicate buildable = new ClusterPredicate(fluent.buildRequiredClusterSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}