package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeSchedulerBuilder extends KubeSchedulerFluent<KubeSchedulerBuilder> implements VisitableBuilder<KubeScheduler,KubeSchedulerBuilder>{

  KubeSchedulerFluent<?> fluent;

  public KubeSchedulerBuilder() {
    this(new KubeScheduler());
  }
  
  public KubeSchedulerBuilder(KubeSchedulerFluent<?> fluent) {
    this(fluent, new KubeScheduler());
  }
  
  public KubeSchedulerBuilder(KubeScheduler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeSchedulerBuilder(KubeSchedulerFluent<?> fluent,KubeScheduler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeScheduler build() {
    KubeScheduler buildable = new KubeScheduler(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}