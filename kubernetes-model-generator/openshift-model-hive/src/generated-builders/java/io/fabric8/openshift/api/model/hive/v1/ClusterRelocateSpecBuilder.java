package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterRelocateSpecBuilder extends ClusterRelocateSpecFluent<ClusterRelocateSpecBuilder> implements VisitableBuilder<ClusterRelocateSpec,ClusterRelocateSpecBuilder>{

  ClusterRelocateSpecFluent<?> fluent;

  public ClusterRelocateSpecBuilder() {
    this(new ClusterRelocateSpec());
  }
  
  public ClusterRelocateSpecBuilder(ClusterRelocateSpecFluent<?> fluent) {
    this(fluent, new ClusterRelocateSpec());
  }
  
  public ClusterRelocateSpecBuilder(ClusterRelocateSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterRelocateSpecBuilder(ClusterRelocateSpecFluent<?> fluent,ClusterRelocateSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterRelocateSpec build() {
    ClusterRelocateSpec buildable = new ClusterRelocateSpec(fluent.buildClusterDeploymentSelector(), fluent.buildKubeconfigSecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}