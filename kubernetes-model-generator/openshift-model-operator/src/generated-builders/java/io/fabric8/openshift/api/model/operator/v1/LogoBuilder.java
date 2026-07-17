package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LogoBuilder extends LogoFluent<LogoBuilder> implements VisitableBuilder<Logo,LogoBuilder>{

  LogoFluent<?> fluent;

  public LogoBuilder() {
    this(new Logo());
  }
  
  public LogoBuilder(LogoFluent<?> fluent) {
    this(fluent, new Logo());
  }
  
  public LogoBuilder(Logo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LogoBuilder(LogoFluent<?> fluent,Logo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Logo build() {
    Logo buildable = new Logo(fluent.buildThemes(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}