package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRelocateListBuilder extends ClusterRelocateListFluent<ClusterRelocateListBuilder> implements VisitableBuilder<ClusterRelocateList,ClusterRelocateListBuilder>{

  ClusterRelocateListFluent<?> fluent;

  public ClusterRelocateListBuilder() {
    this(new ClusterRelocateList());
  }
  
  public ClusterRelocateListBuilder(ClusterRelocateListFluent<?> fluent) {
    this(fluent, new ClusterRelocateList());
  }
  
  public ClusterRelocateListBuilder(ClusterRelocateList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRelocateListBuilder(ClusterRelocateListFluent<?> fluent,ClusterRelocateList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRelocateList build() {
    ClusterRelocateList buildable = new ClusterRelocateList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}