package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImagePolicyStatusBuilder extends ClusterImagePolicyStatusFluent<ClusterImagePolicyStatusBuilder> implements VisitableBuilder<ClusterImagePolicyStatus,ClusterImagePolicyStatusBuilder>{

  ClusterImagePolicyStatusFluent<?> fluent;

  public ClusterImagePolicyStatusBuilder() {
    this(new ClusterImagePolicyStatus());
  }
  
  public ClusterImagePolicyStatusBuilder(ClusterImagePolicyStatusFluent<?> fluent) {
    this(fluent, new ClusterImagePolicyStatus());
  }
  
  public ClusterImagePolicyStatusBuilder(ClusterImagePolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImagePolicyStatusBuilder(ClusterImagePolicyStatusFluent<?> fluent,ClusterImagePolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImagePolicyStatus build() {
    ClusterImagePolicyStatus buildable = new ClusterImagePolicyStatus(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}