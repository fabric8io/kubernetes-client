package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ConsoleNotificationListBuilder extends ConsoleNotificationListFluent<ConsoleNotificationListBuilder> implements VisitableBuilder<ConsoleNotificationList,ConsoleNotificationListBuilder>{

  ConsoleNotificationListFluent<?> fluent;

  public ConsoleNotificationListBuilder() {
    this(new ConsoleNotificationList());
  }
  
  public ConsoleNotificationListBuilder(ConsoleNotificationListFluent<?> fluent) {
    this(fluent, new ConsoleNotificationList());
  }
  
  public ConsoleNotificationListBuilder(ConsoleNotificationList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ConsoleNotificationListBuilder(ConsoleNotificationListFluent<?> fluent,ConsoleNotificationList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ConsoleNotificationList build() {
    ConsoleNotificationList buildable = new ConsoleNotificationList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}