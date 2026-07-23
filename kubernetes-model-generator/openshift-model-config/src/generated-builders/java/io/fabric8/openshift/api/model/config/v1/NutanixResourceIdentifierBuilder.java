package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixResourceIdentifierBuilder extends NutanixResourceIdentifierFluent<NutanixResourceIdentifierBuilder> implements VisitableBuilder<NutanixResourceIdentifier,NutanixResourceIdentifierBuilder>{

  NutanixResourceIdentifierFluent<?> fluent;

  public NutanixResourceIdentifierBuilder() {
    this(new NutanixResourceIdentifier());
  }
  
  public NutanixResourceIdentifierBuilder(NutanixResourceIdentifierFluent<?> fluent) {
    this(fluent, new NutanixResourceIdentifier());
  }
  
  public NutanixResourceIdentifierBuilder(NutanixResourceIdentifier instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixResourceIdentifierBuilder(NutanixResourceIdentifierFluent<?> fluent,NutanixResourceIdentifier instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixResourceIdentifier build() {
    NutanixResourceIdentifier buildable = new NutanixResourceIdentifier(fluent.getName(), fluent.getType(), fluent.getUuid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}