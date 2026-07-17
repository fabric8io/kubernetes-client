package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerListBuilder extends AlertmanagerListFluent<AlertmanagerListBuilder> implements VisitableBuilder<AlertmanagerList,AlertmanagerListBuilder>{

  AlertmanagerListFluent<?> fluent;

  public AlertmanagerListBuilder() {
    this(new AlertmanagerList());
  }
  
  public AlertmanagerListBuilder(AlertmanagerListFluent<?> fluent) {
    this(fluent, new AlertmanagerList());
  }
  
  public AlertmanagerListBuilder(AlertmanagerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerListBuilder(AlertmanagerListFluent<?> fluent,AlertmanagerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerList build() {
    AlertmanagerList buildable = new AlertmanagerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}