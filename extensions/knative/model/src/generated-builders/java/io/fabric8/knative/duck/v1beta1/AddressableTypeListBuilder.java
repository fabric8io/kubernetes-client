package io.fabric8.knative.duck.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddressableTypeListBuilder extends AddressableTypeListFluent<AddressableTypeListBuilder> implements VisitableBuilder<AddressableTypeList,AddressableTypeListBuilder>{

  AddressableTypeListFluent<?> fluent;

  public AddressableTypeListBuilder() {
    this(new AddressableTypeList());
  }
  
  public AddressableTypeListBuilder(AddressableTypeListFluent<?> fluent) {
    this(fluent, new AddressableTypeList());
  }
  
  public AddressableTypeListBuilder(AddressableTypeList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddressableTypeListBuilder(AddressableTypeListFluent<?> fluent,AddressableTypeList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddressableTypeList build() {
    AddressableTypeList buildable = new AddressableTypeList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}