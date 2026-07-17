package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StaticIPAMAddressesBuilder extends StaticIPAMAddressesFluent<StaticIPAMAddressesBuilder> implements VisitableBuilder<StaticIPAMAddresses,StaticIPAMAddressesBuilder>{

  StaticIPAMAddressesFluent<?> fluent;

  public StaticIPAMAddressesBuilder() {
    this(new StaticIPAMAddresses());
  }
  
  public StaticIPAMAddressesBuilder(StaticIPAMAddressesFluent<?> fluent) {
    this(fluent, new StaticIPAMAddresses());
  }
  
  public StaticIPAMAddressesBuilder(StaticIPAMAddresses instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StaticIPAMAddressesBuilder(StaticIPAMAddressesFluent<?> fluent,StaticIPAMAddresses instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StaticIPAMAddresses build() {
    StaticIPAMAddresses buildable = new StaticIPAMAddresses(fluent.getAddress(), fluent.getGateway());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}