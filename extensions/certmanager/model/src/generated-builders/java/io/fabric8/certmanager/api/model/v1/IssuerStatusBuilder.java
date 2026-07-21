package io.fabric8.certmanager.api.model.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IssuerStatusBuilder extends IssuerStatusFluent<IssuerStatusBuilder> implements VisitableBuilder<IssuerStatus,IssuerStatusBuilder>{

  IssuerStatusFluent<?> fluent;

  public IssuerStatusBuilder() {
    this(new IssuerStatus());
  }
  
  public IssuerStatusBuilder(IssuerStatusFluent<?> fluent) {
    this(fluent, new IssuerStatus());
  }
  
  public IssuerStatusBuilder(IssuerStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IssuerStatusBuilder(IssuerStatusFluent<?> fluent,IssuerStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IssuerStatus build() {
    IssuerStatus buildable = new IssuerStatus(fluent.buildAcme(), fluent.buildConditions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}