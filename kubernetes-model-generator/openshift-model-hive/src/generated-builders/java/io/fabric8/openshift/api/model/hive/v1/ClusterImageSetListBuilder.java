package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterImageSetListBuilder extends ClusterImageSetListFluent<ClusterImageSetListBuilder> implements VisitableBuilder<ClusterImageSetList,ClusterImageSetListBuilder>{

  ClusterImageSetListFluent<?> fluent;

  public ClusterImageSetListBuilder() {
    this(new ClusterImageSetList());
  }
  
  public ClusterImageSetListBuilder(ClusterImageSetListFluent<?> fluent) {
    this(fluent, new ClusterImageSetList());
  }
  
  public ClusterImageSetListBuilder(ClusterImageSetList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterImageSetListBuilder(ClusterImageSetListFluent<?> fluent,ClusterImageSetList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterImageSetList build() {
    ClusterImageSetList buildable = new ClusterImageSetList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}