package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeControllerManagerListBuilder extends KubeControllerManagerListFluent<KubeControllerManagerListBuilder> implements VisitableBuilder<KubeControllerManagerList,KubeControllerManagerListBuilder>{

  KubeControllerManagerListFluent<?> fluent;

  public KubeControllerManagerListBuilder() {
    this(new KubeControllerManagerList());
  }
  
  public KubeControllerManagerListBuilder(KubeControllerManagerListFluent<?> fluent) {
    this(fluent, new KubeControllerManagerList());
  }
  
  public KubeControllerManagerListBuilder(KubeControllerManagerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeControllerManagerListBuilder(KubeControllerManagerListFluent<?> fluent,KubeControllerManagerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeControllerManagerList build() {
    KubeControllerManagerList buildable = new KubeControllerManagerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}