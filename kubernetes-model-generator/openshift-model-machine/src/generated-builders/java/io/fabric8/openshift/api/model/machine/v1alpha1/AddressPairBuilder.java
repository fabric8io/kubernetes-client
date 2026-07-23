package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddressPairBuilder extends AddressPairFluent<AddressPairBuilder> implements VisitableBuilder<AddressPair,AddressPairBuilder>{

  AddressPairFluent<?> fluent;

  public AddressPairBuilder() {
    this(new AddressPair());
  }
  
  public AddressPairBuilder(AddressPairFluent<?> fluent) {
    this(fluent, new AddressPair());
  }
  
  public AddressPairBuilder(AddressPair instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddressPairBuilder(AddressPairFluent<?> fluent,AddressPair instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddressPair build() {
    AddressPair buildable = new AddressPair(fluent.getIpAddress(), fluent.getMacAddress());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}