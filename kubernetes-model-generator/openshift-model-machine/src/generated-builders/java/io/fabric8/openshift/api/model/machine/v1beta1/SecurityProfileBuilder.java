package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SecurityProfileBuilder extends SecurityProfileFluent<SecurityProfileBuilder> implements VisitableBuilder<SecurityProfile,SecurityProfileBuilder>{

  SecurityProfileFluent<?> fluent;

  public SecurityProfileBuilder() {
    this(new SecurityProfile());
  }
  
  public SecurityProfileBuilder(SecurityProfileFluent<?> fluent) {
    this(fluent, new SecurityProfile());
  }
  
  public SecurityProfileBuilder(SecurityProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SecurityProfileBuilder(SecurityProfileFluent<?> fluent,SecurityProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SecurityProfile build() {
    SecurityProfile buildable = new SecurityProfile(fluent.getEncryptionAtHost(), fluent.buildSettings());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}