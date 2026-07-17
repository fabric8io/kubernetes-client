package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterIngressBuilder extends ClusterIngressFluent<ClusterIngressBuilder> implements VisitableBuilder<ClusterIngress,ClusterIngressBuilder>{

  ClusterIngressFluent<?> fluent;

  public ClusterIngressBuilder() {
    this(new ClusterIngress());
  }
  
  public ClusterIngressBuilder(ClusterIngressFluent<?> fluent) {
    this(fluent, new ClusterIngress());
  }
  
  public ClusterIngressBuilder(ClusterIngress instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterIngressBuilder(ClusterIngressFluent<?> fluent,ClusterIngress instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterIngress build() {
    ClusterIngress buildable = new ClusterIngress(fluent.getDomain(), fluent.getHttpErrorCodePages(), fluent.getName(), fluent.buildNamespaceSelector(), fluent.buildRouteSelector(), fluent.getServingCertificate());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}