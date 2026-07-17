package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScopeRestrictionBuilder extends ScopeRestrictionFluent<ScopeRestrictionBuilder> implements VisitableBuilder<ScopeRestriction,ScopeRestrictionBuilder>{

  ScopeRestrictionFluent<?> fluent;

  public ScopeRestrictionBuilder() {
    this(new ScopeRestriction());
  }
  
  public ScopeRestrictionBuilder(ScopeRestrictionFluent<?> fluent) {
    this(fluent, new ScopeRestriction());
  }
  
  public ScopeRestrictionBuilder(ScopeRestriction instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScopeRestrictionBuilder(ScopeRestrictionFluent<?> fluent,ScopeRestriction instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScopeRestriction build() {
    ScopeRestriction buildable = new ScopeRestriction(fluent.buildClusterRole(), fluent.getLiterals());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}