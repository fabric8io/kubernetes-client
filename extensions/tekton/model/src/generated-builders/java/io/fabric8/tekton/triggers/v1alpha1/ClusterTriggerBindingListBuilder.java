package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterTriggerBindingListBuilder extends ClusterTriggerBindingListFluent<ClusterTriggerBindingListBuilder> implements VisitableBuilder<ClusterTriggerBindingList,ClusterTriggerBindingListBuilder>{

  ClusterTriggerBindingListFluent<?> fluent;

  public ClusterTriggerBindingListBuilder() {
    this(new ClusterTriggerBindingList());
  }
  
  public ClusterTriggerBindingListBuilder(ClusterTriggerBindingListFluent<?> fluent) {
    this(fluent, new ClusterTriggerBindingList());
  }
  
  public ClusterTriggerBindingListBuilder(ClusterTriggerBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterTriggerBindingListBuilder(ClusterTriggerBindingListFluent<?> fluent,ClusterTriggerBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterTriggerBindingList build() {
    ClusterTriggerBindingList buildable = new ClusterTriggerBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}