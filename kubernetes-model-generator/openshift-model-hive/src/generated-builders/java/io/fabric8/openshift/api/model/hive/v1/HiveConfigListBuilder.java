package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HiveConfigListBuilder extends HiveConfigListFluent<HiveConfigListBuilder> implements VisitableBuilder<HiveConfigList,HiveConfigListBuilder>{

  HiveConfigListFluent<?> fluent;

  public HiveConfigListBuilder() {
    this(new HiveConfigList());
  }
  
  public HiveConfigListBuilder(HiveConfigListFluent<?> fluent) {
    this(fluent, new HiveConfigList());
  }
  
  public HiveConfigListBuilder(HiveConfigList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HiveConfigListBuilder(HiveConfigListFluent<?> fluent,HiveConfigList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HiveConfigList build() {
    HiveConfigList buildable = new HiveConfigList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}