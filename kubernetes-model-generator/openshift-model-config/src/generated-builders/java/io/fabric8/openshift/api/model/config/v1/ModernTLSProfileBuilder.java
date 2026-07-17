package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ModernTLSProfileBuilder extends ModernTLSProfileFluent<ModernTLSProfileBuilder> implements VisitableBuilder<ModernTLSProfile,ModernTLSProfileBuilder>{

  ModernTLSProfileFluent<?> fluent;

  public ModernTLSProfileBuilder() {
    this(new ModernTLSProfile());
  }
  
  public ModernTLSProfileBuilder(ModernTLSProfileFluent<?> fluent) {
    this(fluent, new ModernTLSProfile());
  }
  
  public ModernTLSProfileBuilder(ModernTLSProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ModernTLSProfileBuilder(ModernTLSProfileFluent<?> fluent,ModernTLSProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ModernTLSProfile build() {
    ModernTLSProfile buildable = new ModernTLSProfile();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}