package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistrationDriverBuilder extends RegistrationDriverFluent<RegistrationDriverBuilder> implements VisitableBuilder<RegistrationDriver,RegistrationDriverBuilder>{

  RegistrationDriverFluent<?> fluent;

  public RegistrationDriverBuilder() {
    this(new RegistrationDriver());
  }
  
  public RegistrationDriverBuilder(RegistrationDriverFluent<?> fluent) {
    this(fluent, new RegistrationDriver());
  }
  
  public RegistrationDriverBuilder(RegistrationDriver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistrationDriverBuilder(RegistrationDriverFluent<?> fluent,RegistrationDriver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistrationDriver build() {
    RegistrationDriver buildable = new RegistrationDriver(fluent.getAuthType(), fluent.buildAwsIrsa());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}