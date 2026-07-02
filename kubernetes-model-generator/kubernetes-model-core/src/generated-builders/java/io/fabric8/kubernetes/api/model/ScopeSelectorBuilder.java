package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ScopeSelectorBuilder extends ScopeSelectorFluent<ScopeSelectorBuilder> implements VisitableBuilder<ScopeSelector,ScopeSelectorBuilder>{

  ScopeSelectorFluent<?> fluent;

  public ScopeSelectorBuilder() {
    this(new ScopeSelector());
  }
  
  public ScopeSelectorBuilder(ScopeSelectorFluent<?> fluent) {
    this(fluent, new ScopeSelector());
  }
  
  public ScopeSelectorBuilder(ScopeSelector instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ScopeSelectorBuilder(ScopeSelectorFluent<?> fluent,ScopeSelector instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ScopeSelector build() {
    ScopeSelector buildable = new ScopeSelector(fluent.buildMatchExpressions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}