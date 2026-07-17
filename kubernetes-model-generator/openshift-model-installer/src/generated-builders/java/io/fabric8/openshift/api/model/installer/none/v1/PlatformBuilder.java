package io.fabric8.openshift.api.model.installer.none.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformBuilder extends PlatformFluent<PlatformBuilder> implements VisitableBuilder<Platform,PlatformBuilder>{

  PlatformFluent<?> fluent;

  public PlatformBuilder() {
    this(new Platform());
  }
  
  public PlatformBuilder(PlatformFluent<?> fluent) {
    this(fluent, new Platform());
  }
  
  public PlatformBuilder(Platform instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformBuilder(PlatformFluent<?> fluent,Platform instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Platform build() {
    Platform buildable = new Platform();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}