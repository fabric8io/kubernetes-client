package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeSchedulerListBuilder extends KubeSchedulerListFluent<KubeSchedulerListBuilder> implements VisitableBuilder<KubeSchedulerList,KubeSchedulerListBuilder>{

  KubeSchedulerListFluent<?> fluent;

  public KubeSchedulerListBuilder() {
    this(new KubeSchedulerList());
  }
  
  public KubeSchedulerListBuilder(KubeSchedulerListFluent<?> fluent) {
    this(fluent, new KubeSchedulerList());
  }
  
  public KubeSchedulerListBuilder(KubeSchedulerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeSchedulerListBuilder(KubeSchedulerListFluent<?> fluent,KubeSchedulerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeSchedulerList build() {
    KubeSchedulerList buildable = new KubeSchedulerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}