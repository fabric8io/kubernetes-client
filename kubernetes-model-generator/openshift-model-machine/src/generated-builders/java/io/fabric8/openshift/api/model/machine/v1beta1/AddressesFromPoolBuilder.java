package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddressesFromPoolBuilder extends AddressesFromPoolFluent<AddressesFromPoolBuilder> implements VisitableBuilder<AddressesFromPool,AddressesFromPoolBuilder>{

  AddressesFromPoolFluent<?> fluent;

  public AddressesFromPoolBuilder() {
    this(new AddressesFromPool());
  }
  
  public AddressesFromPoolBuilder(AddressesFromPoolFluent<?> fluent) {
    this(fluent, new AddressesFromPool());
  }
  
  public AddressesFromPoolBuilder(AddressesFromPool instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddressesFromPoolBuilder(AddressesFromPoolFluent<?> fluent,AddressesFromPool instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddressesFromPool build() {
    AddressesFromPool buildable = new AddressesFromPool(fluent.getGroup(), fluent.getName(), fluent.getResource());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}