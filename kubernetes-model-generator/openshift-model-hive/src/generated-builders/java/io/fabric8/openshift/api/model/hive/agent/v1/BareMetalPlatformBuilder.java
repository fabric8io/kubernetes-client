package io.fabric8.openshift.api.model.hive.agent.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalPlatformBuilder extends BareMetalPlatformFluent<BareMetalPlatformBuilder> implements VisitableBuilder<BareMetalPlatform,BareMetalPlatformBuilder>{

  BareMetalPlatformFluent<?> fluent;

  public BareMetalPlatformBuilder() {
    this(new BareMetalPlatform());
  }
  
  public BareMetalPlatformBuilder(BareMetalPlatformFluent<?> fluent) {
    this(fluent, new BareMetalPlatform());
  }
  
  public BareMetalPlatformBuilder(BareMetalPlatform instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalPlatformBuilder(BareMetalPlatformFluent<?> fluent,BareMetalPlatform instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalPlatform build() {
    BareMetalPlatform buildable = new BareMetalPlatform(fluent.buildAgentSelector());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}