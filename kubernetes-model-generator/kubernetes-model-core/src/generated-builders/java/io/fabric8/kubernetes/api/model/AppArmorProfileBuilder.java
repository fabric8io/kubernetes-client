package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AppArmorProfileBuilder extends AppArmorProfileFluent<AppArmorProfileBuilder> implements VisitableBuilder<AppArmorProfile,AppArmorProfileBuilder>{

  AppArmorProfileFluent<?> fluent;

  public AppArmorProfileBuilder() {
    this(new AppArmorProfile());
  }
  
  public AppArmorProfileBuilder(AppArmorProfileFluent<?> fluent) {
    this(fluent, new AppArmorProfile());
  }
  
  public AppArmorProfileBuilder(AppArmorProfile instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AppArmorProfileBuilder(AppArmorProfileFluent<?> fluent,AppArmorProfile instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AppArmorProfile build() {
    AppArmorProfile buildable = new AppArmorProfile(fluent.getLocalhostProfile(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}