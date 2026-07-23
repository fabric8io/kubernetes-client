package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterCSIDriverListBuilder extends ClusterCSIDriverListFluent<ClusterCSIDriverListBuilder> implements VisitableBuilder<ClusterCSIDriverList,ClusterCSIDriverListBuilder>{

  ClusterCSIDriverListFluent<?> fluent;

  public ClusterCSIDriverListBuilder() {
    this(new ClusterCSIDriverList());
  }
  
  public ClusterCSIDriverListBuilder(ClusterCSIDriverListFluent<?> fluent) {
    this(fluent, new ClusterCSIDriverList());
  }
  
  public ClusterCSIDriverListBuilder(ClusterCSIDriverList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterCSIDriverListBuilder(ClusterCSIDriverListFluent<?> fluent,ClusterCSIDriverList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterCSIDriverList build() {
    ClusterCSIDriverList buildable = new ClusterCSIDriverList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}