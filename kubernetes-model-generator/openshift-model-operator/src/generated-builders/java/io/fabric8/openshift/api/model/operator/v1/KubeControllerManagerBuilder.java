package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeControllerManagerBuilder extends KubeControllerManagerFluent<KubeControllerManagerBuilder> implements VisitableBuilder<KubeControllerManager,KubeControllerManagerBuilder>{

  KubeControllerManagerFluent<?> fluent;

  public KubeControllerManagerBuilder() {
    this(new KubeControllerManager());
  }
  
  public KubeControllerManagerBuilder(KubeControllerManagerFluent<?> fluent) {
    this(fluent, new KubeControllerManager());
  }
  
  public KubeControllerManagerBuilder(KubeControllerManager instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeControllerManagerBuilder(KubeControllerManagerFluent<?> fluent,KubeControllerManager instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeControllerManager build() {
    KubeControllerManager buildable = new KubeControllerManager(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}