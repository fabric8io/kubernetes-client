package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterSpecBuilder extends Metal3ClusterSpecFluent<Metal3ClusterSpecBuilder> implements VisitableBuilder<Metal3ClusterSpec,Metal3ClusterSpecBuilder>{

  Metal3ClusterSpecFluent<?> fluent;

  public Metal3ClusterSpecBuilder() {
    this(new Metal3ClusterSpec());
  }
  
  public Metal3ClusterSpecBuilder(Metal3ClusterSpecFluent<?> fluent) {
    this(fluent, new Metal3ClusterSpec());
  }
  
  public Metal3ClusterSpecBuilder(Metal3ClusterSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterSpecBuilder(Metal3ClusterSpecFluent<?> fluent,Metal3ClusterSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterSpec build() {
    Metal3ClusterSpec buildable = new Metal3ClusterSpec(fluent.getCloudProviderEnabled(), fluent.buildControlPlaneEndpoint(), fluent.getFailureDomains(), fluent.getNoCloudProvider());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}