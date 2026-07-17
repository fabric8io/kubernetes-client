package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeprecationBuilder extends DeprecationFluent<DeprecationBuilder> implements VisitableBuilder<Deprecation,DeprecationBuilder>{

  DeprecationFluent<?> fluent;

  public DeprecationBuilder() {
    this(new Deprecation());
  }
  
  public DeprecationBuilder(DeprecationFluent<?> fluent) {
    this(fluent, new Deprecation());
  }
  
  public DeprecationBuilder(Deprecation instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeprecationBuilder(DeprecationFluent<?> fluent,Deprecation instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Deprecation build() {
    Deprecation buildable = new Deprecation(fluent.getMessage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}