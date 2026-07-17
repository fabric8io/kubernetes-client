package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorHubSpecBuilder extends OperatorHubSpecFluent<OperatorHubSpecBuilder> implements VisitableBuilder<OperatorHubSpec,OperatorHubSpecBuilder>{

  OperatorHubSpecFluent<?> fluent;

  public OperatorHubSpecBuilder() {
    this(new OperatorHubSpec());
  }
  
  public OperatorHubSpecBuilder(OperatorHubSpecFluent<?> fluent) {
    this(fluent, new OperatorHubSpec());
  }
  
  public OperatorHubSpecBuilder(OperatorHubSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorHubSpecBuilder(OperatorHubSpecFluent<?> fluent,OperatorHubSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorHubSpec build() {
    OperatorHubSpec buildable = new OperatorHubSpec(fluent.getDisableAllDefaultSources(), fluent.buildSources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}