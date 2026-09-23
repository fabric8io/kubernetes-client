package io.fabric8.openshift.api.model.operator.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterAPISpecBuilder extends ClusterAPISpecFluent<ClusterAPISpecBuilder> implements VisitableBuilder<ClusterAPISpec,ClusterAPISpecBuilder>{

  ClusterAPISpecFluent<?> fluent;

  public ClusterAPISpecBuilder() {
    this(new ClusterAPISpec());
  }
  
  public ClusterAPISpecBuilder(ClusterAPISpecFluent<?> fluent) {
    this(fluent, new ClusterAPISpec());
  }
  
  public ClusterAPISpecBuilder(ClusterAPISpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterAPISpecBuilder(ClusterAPISpecFluent<?> fluent,ClusterAPISpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterAPISpec build() {
    ClusterAPISpec buildable = new ClusterAPISpec(fluent.getUnmanagedCustomResourceDefinitions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}