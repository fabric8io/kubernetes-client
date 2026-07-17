package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PowerVSSecretReferenceBuilder extends PowerVSSecretReferenceFluent<PowerVSSecretReferenceBuilder> implements VisitableBuilder<PowerVSSecretReference,PowerVSSecretReferenceBuilder>{

  PowerVSSecretReferenceFluent<?> fluent;

  public PowerVSSecretReferenceBuilder() {
    this(new PowerVSSecretReference());
  }
  
  public PowerVSSecretReferenceBuilder(PowerVSSecretReferenceFluent<?> fluent) {
    this(fluent, new PowerVSSecretReference());
  }
  
  public PowerVSSecretReferenceBuilder(PowerVSSecretReference instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PowerVSSecretReferenceBuilder(PowerVSSecretReferenceFluent<?> fluent,PowerVSSecretReference instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PowerVSSecretReference build() {
    PowerVSSecretReference buildable = new PowerVSSecretReference(fluent.getName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}