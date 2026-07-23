package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddOnRegistrationDriverBuilder extends AddOnRegistrationDriverFluent<AddOnRegistrationDriverBuilder> implements VisitableBuilder<AddOnRegistrationDriver,AddOnRegistrationDriverBuilder>{

  AddOnRegistrationDriverFluent<?> fluent;

  public AddOnRegistrationDriverBuilder() {
    this(new AddOnRegistrationDriver());
  }
  
  public AddOnRegistrationDriverBuilder(AddOnRegistrationDriverFluent<?> fluent) {
    this(fluent, new AddOnRegistrationDriver());
  }
  
  public AddOnRegistrationDriverBuilder(AddOnRegistrationDriver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddOnRegistrationDriverBuilder(AddOnRegistrationDriverFluent<?> fluent,AddOnRegistrationDriver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddOnRegistrationDriver build() {
    AddOnRegistrationDriver buildable = new AddOnRegistrationDriver(fluent.getAuthType(), fluent.buildToken());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}