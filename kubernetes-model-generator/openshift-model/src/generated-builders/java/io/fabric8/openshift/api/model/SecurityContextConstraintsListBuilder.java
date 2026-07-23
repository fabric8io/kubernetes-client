package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecurityContextConstraintsListBuilder extends SecurityContextConstraintsListFluent<SecurityContextConstraintsListBuilder> implements VisitableBuilder<SecurityContextConstraintsList,SecurityContextConstraintsListBuilder>{

  SecurityContextConstraintsListFluent<?> fluent;

  public SecurityContextConstraintsListBuilder() {
    this(new SecurityContextConstraintsList());
  }
  
  public SecurityContextConstraintsListBuilder(SecurityContextConstraintsListFluent<?> fluent) {
    this(fluent, new SecurityContextConstraintsList());
  }
  
  public SecurityContextConstraintsListBuilder(SecurityContextConstraintsList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecurityContextConstraintsListBuilder(SecurityContextConstraintsListFluent<?> fluent,SecurityContextConstraintsList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecurityContextConstraintsList build() {
    SecurityContextConstraintsList buildable = new SecurityContextConstraintsList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}