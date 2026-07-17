package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSResourceFilterBuilder extends AWSResourceFilterFluent<AWSResourceFilterBuilder> implements VisitableBuilder<AWSResourceFilter,AWSResourceFilterBuilder>{

  AWSResourceFilterFluent<?> fluent;

  public AWSResourceFilterBuilder() {
    this(new AWSResourceFilter());
  }
  
  public AWSResourceFilterBuilder(AWSResourceFilterFluent<?> fluent) {
    this(fluent, new AWSResourceFilter());
  }
  
  public AWSResourceFilterBuilder(AWSResourceFilter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSResourceFilterBuilder(AWSResourceFilterFluent<?> fluent,AWSResourceFilter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSResourceFilter build() {
    AWSResourceFilter buildable = new AWSResourceFilter(fluent.getName(), fluent.getValues());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}