package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AwsIrsaBuilder extends AwsIrsaFluent<AwsIrsaBuilder> implements VisitableBuilder<AwsIrsa,AwsIrsaBuilder>{

  AwsIrsaFluent<?> fluent;

  public AwsIrsaBuilder() {
    this(new AwsIrsa());
  }
  
  public AwsIrsaBuilder(AwsIrsaFluent<?> fluent) {
    this(fluent, new AwsIrsa());
  }
  
  public AwsIrsaBuilder(AwsIrsa instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AwsIrsaBuilder(AwsIrsaFluent<?> fluent,AwsIrsa instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AwsIrsa build() {
    AwsIrsa buildable = new AwsIrsa(fluent.getHubClusterArn(), fluent.getManagedClusterArn());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}