package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImagePolicyListBuilder extends ClusterImagePolicyListFluent<ClusterImagePolicyListBuilder> implements VisitableBuilder<ClusterImagePolicyList,ClusterImagePolicyListBuilder>{

  ClusterImagePolicyListFluent<?> fluent;

  public ClusterImagePolicyListBuilder() {
    this(new ClusterImagePolicyList());
  }
  
  public ClusterImagePolicyListBuilder(ClusterImagePolicyListFluent<?> fluent) {
    this(fluent, new ClusterImagePolicyList());
  }
  
  public ClusterImagePolicyListBuilder(ClusterImagePolicyList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImagePolicyListBuilder(ClusterImagePolicyListFluent<?> fluent,ClusterImagePolicyList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImagePolicyList build() {
    ClusterImagePolicyList buildable = new ClusterImagePolicyList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}