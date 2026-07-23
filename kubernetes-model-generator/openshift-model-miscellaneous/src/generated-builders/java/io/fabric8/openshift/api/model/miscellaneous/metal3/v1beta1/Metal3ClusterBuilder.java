package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterBuilder extends Metal3ClusterFluent<Metal3ClusterBuilder> implements VisitableBuilder<Metal3Cluster,Metal3ClusterBuilder>{

  Metal3ClusterFluent<?> fluent;

  public Metal3ClusterBuilder() {
    this(new Metal3Cluster());
  }
  
  public Metal3ClusterBuilder(Metal3ClusterFluent<?> fluent) {
    this(fluent, new Metal3Cluster());
  }
  
  public Metal3ClusterBuilder(Metal3Cluster instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterBuilder(Metal3ClusterFluent<?> fluent,Metal3Cluster instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3Cluster build() {
    Metal3Cluster buildable = new Metal3Cluster(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}