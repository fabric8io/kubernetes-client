package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NameConstraintsBuilder extends NameConstraintsFluent<NameConstraintsBuilder> implements VisitableBuilder<NameConstraints,NameConstraintsBuilder>{

  NameConstraintsFluent<?> fluent;

  public NameConstraintsBuilder() {
    this(new NameConstraints());
  }
  
  public NameConstraintsBuilder(NameConstraintsFluent<?> fluent) {
    this(fluent, new NameConstraints());
  }
  
  public NameConstraintsBuilder(NameConstraints instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NameConstraintsBuilder(NameConstraintsFluent<?> fluent,NameConstraints instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NameConstraints build() {
    NameConstraints buildable = new NameConstraints(fluent.getCritical(), fluent.buildExcluded(), fluent.buildPermitted());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}