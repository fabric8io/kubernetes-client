package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ACMEExternalAccountBindingBuilder extends ACMEExternalAccountBindingFluent<ACMEExternalAccountBindingBuilder> implements VisitableBuilder<ACMEExternalAccountBinding,ACMEExternalAccountBindingBuilder>{

  ACMEExternalAccountBindingFluent<?> fluent;

  public ACMEExternalAccountBindingBuilder() {
    this(new ACMEExternalAccountBinding());
  }
  
  public ACMEExternalAccountBindingBuilder(ACMEExternalAccountBindingFluent<?> fluent) {
    this(fluent, new ACMEExternalAccountBinding());
  }
  
  public ACMEExternalAccountBindingBuilder(ACMEExternalAccountBinding instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ACMEExternalAccountBindingBuilder(ACMEExternalAccountBindingFluent<?> fluent,ACMEExternalAccountBinding instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ACMEExternalAccountBinding build() {
    ACMEExternalAccountBinding buildable = new ACMEExternalAccountBinding(fluent.getKeyAlgorithm(), fluent.getKeyID(), fluent.buildKeySecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}