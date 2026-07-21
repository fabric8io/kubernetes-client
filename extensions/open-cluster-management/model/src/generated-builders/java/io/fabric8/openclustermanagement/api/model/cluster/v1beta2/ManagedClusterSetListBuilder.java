package io.fabric8.openclustermanagement.api.model.cluster.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ManagedClusterSetListBuilder extends ManagedClusterSetListFluent<ManagedClusterSetListBuilder> implements VisitableBuilder<ManagedClusterSetList,ManagedClusterSetListBuilder>{

  ManagedClusterSetListFluent<?> fluent;

  public ManagedClusterSetListBuilder() {
    this(new ManagedClusterSetList());
  }
  
  public ManagedClusterSetListBuilder(ManagedClusterSetListFluent<?> fluent) {
    this(fluent, new ManagedClusterSetList());
  }
  
  public ManagedClusterSetListBuilder(ManagedClusterSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ManagedClusterSetListBuilder(ManagedClusterSetListFluent<?> fluent,ManagedClusterSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ManagedClusterSetList build() {
    ManagedClusterSetList buildable = new ManagedClusterSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}