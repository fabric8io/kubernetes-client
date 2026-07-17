package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerBuilder extends AlertmanagerFluent<AlertmanagerBuilder> implements VisitableBuilder<Alertmanager,AlertmanagerBuilder>{

  AlertmanagerFluent<?> fluent;

  public AlertmanagerBuilder() {
    this(new Alertmanager());
  }
  
  public AlertmanagerBuilder(AlertmanagerFluent<?> fluent) {
    this(fluent, new Alertmanager());
  }
  
  public AlertmanagerBuilder(Alertmanager instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerBuilder(AlertmanagerFluent<?> fluent,Alertmanager instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Alertmanager build() {
    Alertmanager buildable = new Alertmanager(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}