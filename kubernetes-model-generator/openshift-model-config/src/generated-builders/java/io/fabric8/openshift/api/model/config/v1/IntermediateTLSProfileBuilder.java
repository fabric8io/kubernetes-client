package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class IntermediateTLSProfileBuilder extends IntermediateTLSProfileFluent<IntermediateTLSProfileBuilder> implements VisitableBuilder<IntermediateTLSProfile,IntermediateTLSProfileBuilder>{

  IntermediateTLSProfileFluent<?> fluent;

  public IntermediateTLSProfileBuilder() {
    this(new IntermediateTLSProfile());
  }
  
  public IntermediateTLSProfileBuilder(IntermediateTLSProfileFluent<?> fluent) {
    this(fluent, new IntermediateTLSProfile());
  }
  
  public IntermediateTLSProfileBuilder(IntermediateTLSProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public IntermediateTLSProfileBuilder(IntermediateTLSProfileFluent<?> fluent,IntermediateTLSProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public IntermediateTLSProfile build() {
    IntermediateTLSProfile buildable = new IntermediateTLSProfile();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}