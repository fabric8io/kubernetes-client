package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LifecycleHandlerBuilder extends LifecycleHandlerFluent<LifecycleHandlerBuilder> implements VisitableBuilder<LifecycleHandler,LifecycleHandlerBuilder>{

  LifecycleHandlerFluent<?> fluent;

  public LifecycleHandlerBuilder() {
    this(new LifecycleHandler());
  }
  
  public LifecycleHandlerBuilder(LifecycleHandlerFluent<?> fluent) {
    this(fluent, new LifecycleHandler());
  }
  
  public LifecycleHandlerBuilder(LifecycleHandler instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LifecycleHandlerBuilder(LifecycleHandlerFluent<?> fluent,LifecycleHandler instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public LifecycleHandler build() {
    LifecycleHandler buildable = new LifecycleHandler(fluent.buildExec(), fluent.buildHttpGet(), fluent.buildSleep(), fluent.buildTcpSocket());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}