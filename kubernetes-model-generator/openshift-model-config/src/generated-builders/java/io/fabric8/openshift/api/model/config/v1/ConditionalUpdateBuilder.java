package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConditionalUpdateBuilder extends ConditionalUpdateFluent<ConditionalUpdateBuilder> implements VisitableBuilder<ConditionalUpdate,ConditionalUpdateBuilder>{

  ConditionalUpdateFluent<?> fluent;

  public ConditionalUpdateBuilder() {
    this(new ConditionalUpdate());
  }
  
  public ConditionalUpdateBuilder(ConditionalUpdateFluent<?> fluent) {
    this(fluent, new ConditionalUpdate());
  }
  
  public ConditionalUpdateBuilder(ConditionalUpdate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConditionalUpdateBuilder(ConditionalUpdateFluent<?> fluent,ConditionalUpdate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConditionalUpdate build() {
    ConditionalUpdate buildable = new ConditionalUpdate(fluent.getConditions(), fluent.buildRelease(), fluent.buildRisks());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}