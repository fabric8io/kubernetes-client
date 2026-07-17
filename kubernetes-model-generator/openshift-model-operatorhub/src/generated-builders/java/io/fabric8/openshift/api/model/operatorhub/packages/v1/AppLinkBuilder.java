package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AppLinkBuilder extends AppLinkFluent<AppLinkBuilder> implements VisitableBuilder<AppLink,AppLinkBuilder>{

  AppLinkFluent<?> fluent;

  public AppLinkBuilder() {
    this(new AppLink());
  }
  
  public AppLinkBuilder(AppLinkFluent<?> fluent) {
    this(fluent, new AppLink());
  }
  
  public AppLinkBuilder(AppLink instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AppLinkBuilder(AppLinkFluent<?> fluent,AppLink instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AppLink build() {
    AppLink buildable = new AppLink(fluent.getName(), fluent.getUrl());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}