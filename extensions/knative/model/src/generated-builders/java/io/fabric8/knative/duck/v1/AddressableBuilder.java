package io.fabric8.knative.duck.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddressableBuilder extends AddressableFluent<AddressableBuilder> implements VisitableBuilder<Addressable,AddressableBuilder>{

  AddressableFluent<?> fluent;

  public AddressableBuilder() {
    this(new Addressable());
  }
  
  public AddressableBuilder(AddressableFluent<?> fluent) {
    this(fluent, new Addressable());
  }
  
  public AddressableBuilder(Addressable instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddressableBuilder(AddressableFluent<?> fluent,Addressable instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Addressable build() {
    Addressable buildable = new Addressable(fluent.getCACerts(), fluent.getAudience(), fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}