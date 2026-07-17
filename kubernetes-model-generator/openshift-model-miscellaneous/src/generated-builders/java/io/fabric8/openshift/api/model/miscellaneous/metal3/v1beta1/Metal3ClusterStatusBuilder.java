package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterStatusBuilder extends Metal3ClusterStatusFluent<Metal3ClusterStatusBuilder> implements VisitableBuilder<Metal3ClusterStatus,Metal3ClusterStatusBuilder>{

  Metal3ClusterStatusFluent<?> fluent;

  public Metal3ClusterStatusBuilder() {
    this(new Metal3ClusterStatus());
  }
  
  public Metal3ClusterStatusBuilder(Metal3ClusterStatusFluent<?> fluent) {
    this(fluent, new Metal3ClusterStatus());
  }
  
  public Metal3ClusterStatusBuilder(Metal3ClusterStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterStatusBuilder(Metal3ClusterStatusFluent<?> fluent,Metal3ClusterStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterStatus build() {
    Metal3ClusterStatus buildable = new Metal3ClusterStatus(fluent.getConditions(), fluent.getFailureDomains(), fluent.getFailureMessage(), fluent.getFailureReason(), fluent.getLastUpdated(), fluent.getReady(), fluent.buildV1beta2());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}