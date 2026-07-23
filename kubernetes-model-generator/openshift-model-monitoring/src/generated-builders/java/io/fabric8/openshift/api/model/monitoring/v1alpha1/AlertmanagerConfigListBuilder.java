package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertmanagerConfigListBuilder extends AlertmanagerConfigListFluent<AlertmanagerConfigListBuilder> implements VisitableBuilder<AlertmanagerConfigList,AlertmanagerConfigListBuilder>{

  AlertmanagerConfigListFluent<?> fluent;

  public AlertmanagerConfigListBuilder() {
    this(new AlertmanagerConfigList());
  }
  
  public AlertmanagerConfigListBuilder(AlertmanagerConfigListFluent<?> fluent) {
    this(fluent, new AlertmanagerConfigList());
  }
  
  public AlertmanagerConfigListBuilder(AlertmanagerConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertmanagerConfigListBuilder(AlertmanagerConfigListFluent<?> fluent,AlertmanagerConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertmanagerConfigList build() {
    AlertmanagerConfigList buildable = new AlertmanagerConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}