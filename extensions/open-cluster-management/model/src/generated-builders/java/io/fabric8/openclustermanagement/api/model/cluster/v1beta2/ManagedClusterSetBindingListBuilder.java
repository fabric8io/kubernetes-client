package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetBindingListBuilder extends ManagedClusterSetBindingListFluent<ManagedClusterSetBindingListBuilder> implements VisitableBuilder<ManagedClusterSetBindingList,ManagedClusterSetBindingListBuilder>{

  ManagedClusterSetBindingListFluent<?> fluent;

  public ManagedClusterSetBindingListBuilder() {
    this(new ManagedClusterSetBindingList());
  }
  
  public ManagedClusterSetBindingListBuilder(ManagedClusterSetBindingListFluent<?> fluent) {
    this(fluent, new ManagedClusterSetBindingList());
  }
  
  public ManagedClusterSetBindingListBuilder(ManagedClusterSetBindingList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetBindingListBuilder(ManagedClusterSetBindingListFluent<?> fluent,ManagedClusterSetBindingList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSetBindingList build() {
    ManagedClusterSetBindingList buildable = new ManagedClusterSetBindingList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}