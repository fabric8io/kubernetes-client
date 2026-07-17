package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PodNetworkConnectivityCheckListBuilder extends PodNetworkConnectivityCheckListFluent<PodNetworkConnectivityCheckListBuilder> implements VisitableBuilder<PodNetworkConnectivityCheckList,PodNetworkConnectivityCheckListBuilder>{

  PodNetworkConnectivityCheckListFluent<?> fluent;

  public PodNetworkConnectivityCheckListBuilder() {
    this(new PodNetworkConnectivityCheckList());
  }
  
  public PodNetworkConnectivityCheckListBuilder(PodNetworkConnectivityCheckListFluent<?> fluent) {
    this(fluent, new PodNetworkConnectivityCheckList());
  }
  
  public PodNetworkConnectivityCheckListBuilder(PodNetworkConnectivityCheckList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PodNetworkConnectivityCheckListBuilder(PodNetworkConnectivityCheckListFluent<?> fluent,PodNetworkConnectivityCheckList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PodNetworkConnectivityCheckList build() {
    PodNetworkConnectivityCheckList buildable = new PodNetworkConnectivityCheckList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}