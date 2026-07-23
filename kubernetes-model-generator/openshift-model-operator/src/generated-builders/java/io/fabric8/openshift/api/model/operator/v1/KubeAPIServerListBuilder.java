package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeAPIServerListBuilder extends KubeAPIServerListFluent<KubeAPIServerListBuilder> implements VisitableBuilder<KubeAPIServerList,KubeAPIServerListBuilder>{

  KubeAPIServerListFluent<?> fluent;

  public KubeAPIServerListBuilder() {
    this(new KubeAPIServerList());
  }
  
  public KubeAPIServerListBuilder(KubeAPIServerListFluent<?> fluent) {
    this(fluent, new KubeAPIServerList());
  }
  
  public KubeAPIServerListBuilder(KubeAPIServerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeAPIServerListBuilder(KubeAPIServerListFluent<?> fluent,KubeAPIServerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeAPIServerList build() {
    KubeAPIServerList buildable = new KubeAPIServerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}