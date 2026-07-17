package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AddPageBuilder extends AddPageFluent<AddPageBuilder> implements VisitableBuilder<AddPage,AddPageBuilder>{

  AddPageFluent<?> fluent;

  public AddPageBuilder() {
    this(new AddPage());
  }
  
  public AddPageBuilder(AddPageFluent<?> fluent) {
    this(fluent, new AddPage());
  }
  
  public AddPageBuilder(AddPage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AddPageBuilder(AddPageFluent<?> fluent,AddPage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AddPage build() {
    AddPage buildable = new AddPage(fluent.getDisabledActions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}