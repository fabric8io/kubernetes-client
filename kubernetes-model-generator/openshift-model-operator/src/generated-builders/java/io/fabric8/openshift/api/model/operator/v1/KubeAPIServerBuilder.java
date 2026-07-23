package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeAPIServerBuilder extends KubeAPIServerFluent<KubeAPIServerBuilder> implements VisitableBuilder<KubeAPIServer,KubeAPIServerBuilder>{

  KubeAPIServerFluent<?> fluent;

  public KubeAPIServerBuilder() {
    this(new KubeAPIServer());
  }
  
  public KubeAPIServerBuilder(KubeAPIServerFluent<?> fluent) {
    this(fluent, new KubeAPIServer());
  }
  
  public KubeAPIServerBuilder(KubeAPIServer instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeAPIServerBuilder(KubeAPIServerFluent<?> fluent,KubeAPIServer instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeAPIServer build() {
    KubeAPIServer buildable = new KubeAPIServer(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}