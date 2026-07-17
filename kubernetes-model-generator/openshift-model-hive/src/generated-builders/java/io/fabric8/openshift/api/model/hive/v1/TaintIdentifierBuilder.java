package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TaintIdentifierBuilder extends TaintIdentifierFluent<TaintIdentifierBuilder> implements VisitableBuilder<TaintIdentifier,TaintIdentifierBuilder>{

  TaintIdentifierFluent<?> fluent;

  public TaintIdentifierBuilder() {
    this(new TaintIdentifier());
  }
  
  public TaintIdentifierBuilder(TaintIdentifierFluent<?> fluent) {
    this(fluent, new TaintIdentifier());
  }
  
  public TaintIdentifierBuilder(TaintIdentifier instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TaintIdentifierBuilder(TaintIdentifierFluent<?> fluent,TaintIdentifier instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TaintIdentifier build() {
    TaintIdentifier buildable = new TaintIdentifier(fluent.getEffect(), fluent.getKey());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}