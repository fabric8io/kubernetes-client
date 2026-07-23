package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImagePolicyBuilder extends ClusterImagePolicyFluent<ClusterImagePolicyBuilder> implements VisitableBuilder<ClusterImagePolicy,ClusterImagePolicyBuilder>{

  ClusterImagePolicyFluent<?> fluent;

  public ClusterImagePolicyBuilder() {
    this(new ClusterImagePolicy());
  }
  
  public ClusterImagePolicyBuilder(ClusterImagePolicyFluent<?> fluent) {
    this(fluent, new ClusterImagePolicy());
  }
  
  public ClusterImagePolicyBuilder(ClusterImagePolicy instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImagePolicyBuilder(ClusterImagePolicyFluent<?> fluent,ClusterImagePolicy instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImagePolicy build() {
    ClusterImagePolicy buildable = new ClusterImagePolicy(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}