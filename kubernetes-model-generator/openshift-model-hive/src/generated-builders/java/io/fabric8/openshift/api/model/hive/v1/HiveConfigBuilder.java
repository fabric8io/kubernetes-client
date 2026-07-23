package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HiveConfigBuilder extends HiveConfigFluent<HiveConfigBuilder> implements VisitableBuilder<HiveConfig,HiveConfigBuilder>{

  HiveConfigFluent<?> fluent;

  public HiveConfigBuilder() {
    this(new HiveConfig());
  }
  
  public HiveConfigBuilder(HiveConfigFluent<?> fluent) {
    this(fluent, new HiveConfig());
  }
  
  public HiveConfigBuilder(HiveConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HiveConfigBuilder(HiveConfigFluent<?> fluent,HiveConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HiveConfig build() {
    HiveConfig buildable = new HiveConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}