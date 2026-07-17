package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OldTLSProfileBuilder extends OldTLSProfileFluent<OldTLSProfileBuilder> implements VisitableBuilder<OldTLSProfile,OldTLSProfileBuilder>{

  OldTLSProfileFluent<?> fluent;

  public OldTLSProfileBuilder() {
    this(new OldTLSProfile());
  }
  
  public OldTLSProfileBuilder(OldTLSProfileFluent<?> fluent) {
    this(fluent, new OldTLSProfile());
  }
  
  public OldTLSProfileBuilder(OldTLSProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OldTLSProfileBuilder(OldTLSProfileFluent<?> fluent,OldTLSProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OldTLSProfile build() {
    OldTLSProfile buildable = new OldTLSProfile();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}