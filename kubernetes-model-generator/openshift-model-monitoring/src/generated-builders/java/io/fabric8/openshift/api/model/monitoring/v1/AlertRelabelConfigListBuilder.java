package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlertRelabelConfigListBuilder extends AlertRelabelConfigListFluent<AlertRelabelConfigListBuilder> implements VisitableBuilder<AlertRelabelConfigList,AlertRelabelConfigListBuilder>{

  AlertRelabelConfigListFluent<?> fluent;

  public AlertRelabelConfigListBuilder() {
    this(new AlertRelabelConfigList());
  }
  
  public AlertRelabelConfigListBuilder(AlertRelabelConfigListFluent<?> fluent) {
    this(fluent, new AlertRelabelConfigList());
  }
  
  public AlertRelabelConfigListBuilder(AlertRelabelConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlertRelabelConfigListBuilder(AlertRelabelConfigListFluent<?> fluent,AlertRelabelConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlertRelabelConfigList build() {
    AlertRelabelConfigList buildable = new AlertRelabelConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}