package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleNotificationSpecBuilder extends ConsoleNotificationSpecFluent<ConsoleNotificationSpecBuilder> implements VisitableBuilder<ConsoleNotificationSpec,ConsoleNotificationSpecBuilder>{

  ConsoleNotificationSpecFluent<?> fluent;

  public ConsoleNotificationSpecBuilder() {
    this(new ConsoleNotificationSpec());
  }
  
  public ConsoleNotificationSpecBuilder(ConsoleNotificationSpecFluent<?> fluent) {
    this(fluent, new ConsoleNotificationSpec());
  }
  
  public ConsoleNotificationSpecBuilder(ConsoleNotificationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleNotificationSpecBuilder(ConsoleNotificationSpecFluent<?> fluent,ConsoleNotificationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleNotificationSpec build() {
    ConsoleNotificationSpec buildable = new ConsoleNotificationSpec(fluent.getBackgroundColor(), fluent.getColor(), fluent.buildLink(), fluent.getLocation(), fluent.getText());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}