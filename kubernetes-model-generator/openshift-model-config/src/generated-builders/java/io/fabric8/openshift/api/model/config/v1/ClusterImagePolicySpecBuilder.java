package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImagePolicySpecBuilder extends ClusterImagePolicySpecFluent<ClusterImagePolicySpecBuilder> implements VisitableBuilder<ClusterImagePolicySpec,ClusterImagePolicySpecBuilder>{

  ClusterImagePolicySpecFluent<?> fluent;

  public ClusterImagePolicySpecBuilder() {
    this(new ClusterImagePolicySpec());
  }
  
  public ClusterImagePolicySpecBuilder(ClusterImagePolicySpecFluent<?> fluent) {
    this(fluent, new ClusterImagePolicySpec());
  }
  
  public ClusterImagePolicySpecBuilder(ClusterImagePolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImagePolicySpecBuilder(ClusterImagePolicySpecFluent<?> fluent,ClusterImagePolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImagePolicySpec build() {
    ClusterImagePolicySpec buildable = new ClusterImagePolicySpec(fluent.buildPolicy(), fluent.getScopes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}