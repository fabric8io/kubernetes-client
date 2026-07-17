package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ControllerConfigListBuilder extends ControllerConfigListFluent<ControllerConfigListBuilder> implements VisitableBuilder<ControllerConfigList,ControllerConfigListBuilder>{

  ControllerConfigListFluent<?> fluent;

  public ControllerConfigListBuilder() {
    this(new ControllerConfigList());
  }
  
  public ControllerConfigListBuilder(ControllerConfigListFluent<?> fluent) {
    this(fluent, new ControllerConfigList());
  }
  
  public ControllerConfigListBuilder(ControllerConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ControllerConfigListBuilder(ControllerConfigListFluent<?> fluent,ControllerConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ControllerConfigList build() {
    ControllerConfigList buildable = new ControllerConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}