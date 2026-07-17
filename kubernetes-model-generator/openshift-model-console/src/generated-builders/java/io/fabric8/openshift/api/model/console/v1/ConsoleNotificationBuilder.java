package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleNotificationBuilder extends ConsoleNotificationFluent<ConsoleNotificationBuilder> implements VisitableBuilder<ConsoleNotification,ConsoleNotificationBuilder>{

  ConsoleNotificationFluent<?> fluent;

  public ConsoleNotificationBuilder() {
    this(new ConsoleNotification());
  }
  
  public ConsoleNotificationBuilder(ConsoleNotificationFluent<?> fluent) {
    this(fluent, new ConsoleNotification());
  }
  
  public ConsoleNotificationBuilder(ConsoleNotification instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleNotificationBuilder(ConsoleNotificationFluent<?> fluent,ConsoleNotification instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleNotification build() {
    ConsoleNotification buildable = new ConsoleNotification(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}