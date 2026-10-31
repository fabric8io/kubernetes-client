package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPIListBuilder extends ClusterAPIListFluent<ClusterAPIListBuilder> implements VisitableBuilder<ClusterAPIList,ClusterAPIListBuilder>{

  ClusterAPIListFluent<?> fluent;

  public ClusterAPIListBuilder() {
    this(new ClusterAPIList());
  }
  
  public ClusterAPIListBuilder(ClusterAPIListFluent<?> fluent) {
    this(fluent, new ClusterAPIList());
  }
  
  public ClusterAPIListBuilder(ClusterAPIList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPIListBuilder(ClusterAPIListFluent<?> fluent,ClusterAPIList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPIList build() {
    ClusterAPIList buildable = new ClusterAPIList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}