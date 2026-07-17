package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixCategoryBuilder extends NutanixCategoryFluent<NutanixCategoryBuilder> implements VisitableBuilder<NutanixCategory,NutanixCategoryBuilder>{

  NutanixCategoryFluent<?> fluent;

  public NutanixCategoryBuilder() {
    this(new NutanixCategory());
  }
  
  public NutanixCategoryBuilder(NutanixCategoryFluent<?> fluent) {
    this(fluent, new NutanixCategory());
  }
  
  public NutanixCategoryBuilder(NutanixCategory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixCategoryBuilder(NutanixCategoryFluent<?> fluent,NutanixCategory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixCategory build() {
    NutanixCategory buildable = new NutanixCategory(fluent.getKey(), fluent.getValue());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}