package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegistrationDriverHubBuilder extends RegistrationDriverHubFluent<RegistrationDriverHubBuilder> implements VisitableBuilder<RegistrationDriverHub,RegistrationDriverHubBuilder>{

  RegistrationDriverHubFluent<?> fluent;

  public RegistrationDriverHubBuilder() {
    this(new RegistrationDriverHub());
  }
  
  public RegistrationDriverHubBuilder(RegistrationDriverHubFluent<?> fluent) {
    this(fluent, new RegistrationDriverHub());
  }
  
  public RegistrationDriverHubBuilder(RegistrationDriverHub instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegistrationDriverHubBuilder(RegistrationDriverHubFluent<?> fluent,RegistrationDriverHub instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegistrationDriverHub build() {
    RegistrationDriverHub buildable = new RegistrationDriverHub(fluent.getAuthType(), fluent.buildAwsirsa(), fluent.buildCsr(), fluent.buildGrpc());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}