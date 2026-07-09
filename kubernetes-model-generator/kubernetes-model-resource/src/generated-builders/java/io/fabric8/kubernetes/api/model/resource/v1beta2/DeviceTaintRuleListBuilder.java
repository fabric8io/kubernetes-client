package io.fabric8.kubernetes.api.model.resource.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeviceTaintRuleListBuilder extends DeviceTaintRuleListFluent<DeviceTaintRuleListBuilder> implements VisitableBuilder<DeviceTaintRuleList,DeviceTaintRuleListBuilder>{

  DeviceTaintRuleListFluent<?> fluent;

  public DeviceTaintRuleListBuilder() {
    this(new DeviceTaintRuleList());
  }
  
  public DeviceTaintRuleListBuilder(DeviceTaintRuleListFluent<?> fluent) {
    this(fluent, new DeviceTaintRuleList());
  }
  
  public DeviceTaintRuleListBuilder(DeviceTaintRuleList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeviceTaintRuleListBuilder(DeviceTaintRuleListFluent<?> fluent,DeviceTaintRuleList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeviceTaintRuleList build() {
    DeviceTaintRuleList buildable = new DeviceTaintRuleList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}