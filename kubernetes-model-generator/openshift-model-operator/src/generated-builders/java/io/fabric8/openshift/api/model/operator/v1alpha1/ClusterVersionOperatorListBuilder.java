package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterVersionOperatorListBuilder extends ClusterVersionOperatorListFluent<ClusterVersionOperatorListBuilder> implements VisitableBuilder<ClusterVersionOperatorList,ClusterVersionOperatorListBuilder>{

  ClusterVersionOperatorListFluent<?> fluent;

  public ClusterVersionOperatorListBuilder() {
    this(new ClusterVersionOperatorList());
  }
  
  public ClusterVersionOperatorListBuilder(ClusterVersionOperatorListFluent<?> fluent) {
    this(fluent, new ClusterVersionOperatorList());
  }
  
  public ClusterVersionOperatorListBuilder(ClusterVersionOperatorList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterVersionOperatorListBuilder(ClusterVersionOperatorListFluent<?> fluent,ClusterVersionOperatorList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterVersionOperatorList build() {
    ClusterVersionOperatorList buildable = new ClusterVersionOperatorList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}