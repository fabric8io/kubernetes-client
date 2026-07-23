package io.fabric8.openshift.api.model.operator.network.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OperatorPKIBuilder extends OperatorPKIFluent<OperatorPKIBuilder> implements VisitableBuilder<OperatorPKI,OperatorPKIBuilder>{

  OperatorPKIFluent<?> fluent;

  public OperatorPKIBuilder() {
    this(new OperatorPKI());
  }
  
  public OperatorPKIBuilder(OperatorPKIFluent<?> fluent) {
    this(fluent, new OperatorPKI());
  }
  
  public OperatorPKIBuilder(OperatorPKI instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OperatorPKIBuilder(OperatorPKIFluent<?> fluent,OperatorPKI instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OperatorPKI build() {
    OperatorPKI buildable = new OperatorPKI(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}