package io.fabric8.kubernetes.api.model.ovn.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EgressServiceStatusBuilder extends EgressServiceStatusFluent<EgressServiceStatusBuilder> implements VisitableBuilder<EgressServiceStatus,EgressServiceStatusBuilder>{

  EgressServiceStatusFluent<?> fluent;

  public EgressServiceStatusBuilder() {
    this(new EgressServiceStatus());
  }
  
  public EgressServiceStatusBuilder(EgressServiceStatusFluent<?> fluent) {
    this(fluent, new EgressServiceStatus());
  }
  
  public EgressServiceStatusBuilder(EgressServiceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EgressServiceStatusBuilder(EgressServiceStatusFluent<?> fluent,EgressServiceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EgressServiceStatus build() {
    EgressServiceStatus buildable = new EgressServiceStatus(fluent.getHost());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}