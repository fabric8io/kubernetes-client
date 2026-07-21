package io.fabric8.knative.pkg.tracker;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReferenceBuilder extends ReferenceFluent<ReferenceBuilder> implements VisitableBuilder<Reference,ReferenceBuilder>{

  ReferenceFluent<?> fluent;

  public ReferenceBuilder() {
    this(new Reference());
  }
  
  public ReferenceBuilder(ReferenceFluent<?> fluent) {
    this(fluent, new Reference());
  }
  
  public ReferenceBuilder(Reference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReferenceBuilder(ReferenceFluent<?> fluent,Reference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Reference build() {
    Reference buildable = new Reference(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.buildSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}