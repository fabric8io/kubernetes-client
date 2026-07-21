package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddressStatusBuilder extends AddressStatusFluent<AddressStatusBuilder> implements VisitableBuilder<AddressStatus,AddressStatusBuilder>{

  AddressStatusFluent<?> fluent;

  public AddressStatusBuilder() {
    this(new AddressStatus());
  }
  
  public AddressStatusBuilder(AddressStatusFluent<?> fluent) {
    this(fluent, new AddressStatus());
  }
  
  public AddressStatusBuilder(AddressStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddressStatusBuilder(AddressStatusFluent<?> fluent,AddressStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddressStatus build() {
    AddressStatus buildable = new AddressStatus(fluent.buildAddress(), fluent.buildAddresses());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}