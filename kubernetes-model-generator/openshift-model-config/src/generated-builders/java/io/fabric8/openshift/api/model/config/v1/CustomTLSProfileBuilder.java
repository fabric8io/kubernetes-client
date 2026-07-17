package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CustomTLSProfileBuilder extends CustomTLSProfileFluent<CustomTLSProfileBuilder> implements VisitableBuilder<CustomTLSProfile,CustomTLSProfileBuilder>{

  CustomTLSProfileFluent<?> fluent;

  public CustomTLSProfileBuilder() {
    this(new CustomTLSProfile());
  }
  
  public CustomTLSProfileBuilder(CustomTLSProfileFluent<?> fluent) {
    this(fluent, new CustomTLSProfile());
  }
  
  public CustomTLSProfileBuilder(CustomTLSProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CustomTLSProfileBuilder(CustomTLSProfileFluent<?> fluent,CustomTLSProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CustomTLSProfile build() {
    CustomTLSProfile buildable = new CustomTLSProfile(fluent.getCiphers(), fluent.getMinTLSVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}