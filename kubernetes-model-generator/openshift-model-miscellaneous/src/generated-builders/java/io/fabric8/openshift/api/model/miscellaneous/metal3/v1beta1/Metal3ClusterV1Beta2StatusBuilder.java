package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3ClusterV1Beta2StatusBuilder extends Metal3ClusterV1Beta2StatusFluent<Metal3ClusterV1Beta2StatusBuilder> implements VisitableBuilder<Metal3ClusterV1Beta2Status,Metal3ClusterV1Beta2StatusBuilder>{

  Metal3ClusterV1Beta2StatusFluent<?> fluent;

  public Metal3ClusterV1Beta2StatusBuilder() {
    this(new Metal3ClusterV1Beta2Status());
  }
  
  public Metal3ClusterV1Beta2StatusBuilder(Metal3ClusterV1Beta2StatusFluent<?> fluent) {
    this(fluent, new Metal3ClusterV1Beta2Status());
  }
  
  public Metal3ClusterV1Beta2StatusBuilder(Metal3ClusterV1Beta2Status instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3ClusterV1Beta2StatusBuilder(Metal3ClusterV1Beta2StatusFluent<?> fluent,Metal3ClusterV1Beta2Status instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3ClusterV1Beta2Status build() {
    Metal3ClusterV1Beta2Status buildable = new Metal3ClusterV1Beta2Status(fluent.getConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}