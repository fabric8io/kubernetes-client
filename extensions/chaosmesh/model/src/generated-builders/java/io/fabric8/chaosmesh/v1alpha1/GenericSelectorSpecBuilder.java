package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GenericSelectorSpecBuilder extends GenericSelectorSpecFluent<GenericSelectorSpecBuilder> implements VisitableBuilder<GenericSelectorSpec,GenericSelectorSpecBuilder>{

  GenericSelectorSpecFluent<?> fluent;

  public GenericSelectorSpecBuilder() {
    this(new GenericSelectorSpec());
  }
  
  public GenericSelectorSpecBuilder(GenericSelectorSpecFluent<?> fluent) {
    this(fluent, new GenericSelectorSpec());
  }
  
  public GenericSelectorSpecBuilder(GenericSelectorSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GenericSelectorSpecBuilder(GenericSelectorSpecFluent<?> fluent,GenericSelectorSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GenericSelectorSpec build() {
    GenericSelectorSpec buildable = new GenericSelectorSpec(fluent.getAnnotationSelectors(), fluent.getFieldSelectors(), fluent.getLabelSelectors(), fluent.getNamespaces());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}