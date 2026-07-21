package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddressableTypeBuilder extends AddressableTypeFluent<AddressableTypeBuilder> implements VisitableBuilder<AddressableType,AddressableTypeBuilder>{

  AddressableTypeFluent<?> fluent;

  public AddressableTypeBuilder() {
    this(new AddressableType());
  }
  
  public AddressableTypeBuilder(AddressableTypeFluent<?> fluent) {
    this(fluent, new AddressableType());
  }
  
  public AddressableTypeBuilder(AddressableType instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddressableTypeBuilder(AddressableTypeFluent<?> fluent,AddressableType instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddressableType build() {
    AddressableType buildable = new AddressableType(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}