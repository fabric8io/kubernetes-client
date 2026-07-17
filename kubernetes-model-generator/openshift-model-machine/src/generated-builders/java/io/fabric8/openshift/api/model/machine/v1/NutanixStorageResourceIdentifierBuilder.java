package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixStorageResourceIdentifierBuilder extends NutanixStorageResourceIdentifierFluent<NutanixStorageResourceIdentifierBuilder> implements VisitableBuilder<NutanixStorageResourceIdentifier,NutanixStorageResourceIdentifierBuilder>{

  NutanixStorageResourceIdentifierFluent<?> fluent;

  public NutanixStorageResourceIdentifierBuilder() {
    this(new NutanixStorageResourceIdentifier());
  }
  
  public NutanixStorageResourceIdentifierBuilder(NutanixStorageResourceIdentifierFluent<?> fluent) {
    this(fluent, new NutanixStorageResourceIdentifier());
  }
  
  public NutanixStorageResourceIdentifierBuilder(NutanixStorageResourceIdentifier instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixStorageResourceIdentifierBuilder(NutanixStorageResourceIdentifierFluent<?> fluent,NutanixStorageResourceIdentifier instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixStorageResourceIdentifier build() {
    NutanixStorageResourceIdentifier buildable = new NutanixStorageResourceIdentifier(fluent.getType(), fluent.getUuid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}