package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterManagerDeployOptionBuilder extends ClusterManagerDeployOptionFluent<ClusterManagerDeployOptionBuilder> implements VisitableBuilder<ClusterManagerDeployOption,ClusterManagerDeployOptionBuilder>{

  ClusterManagerDeployOptionFluent<?> fluent;

  public ClusterManagerDeployOptionBuilder() {
    this(new ClusterManagerDeployOption());
  }
  
  public ClusterManagerDeployOptionBuilder(ClusterManagerDeployOptionFluent<?> fluent) {
    this(fluent, new ClusterManagerDeployOption());
  }
  
  public ClusterManagerDeployOptionBuilder(ClusterManagerDeployOption instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterManagerDeployOptionBuilder(ClusterManagerDeployOptionFluent<?> fluent,ClusterManagerDeployOption instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterManagerDeployOption build() {
    ClusterManagerDeployOption buildable = new ClusterManagerDeployOption(fluent.buildDefault(), fluent.buildHosted(), fluent.getMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}