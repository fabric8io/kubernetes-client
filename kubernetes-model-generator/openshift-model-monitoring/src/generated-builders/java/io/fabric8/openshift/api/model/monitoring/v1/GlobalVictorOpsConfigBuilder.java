package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GlobalVictorOpsConfigBuilder extends GlobalVictorOpsConfigFluent<GlobalVictorOpsConfigBuilder> implements VisitableBuilder<GlobalVictorOpsConfig,GlobalVictorOpsConfigBuilder>{

  GlobalVictorOpsConfigFluent<?> fluent;

  public GlobalVictorOpsConfigBuilder() {
    this(new GlobalVictorOpsConfig());
  }
  
  public GlobalVictorOpsConfigBuilder(GlobalVictorOpsConfigFluent<?> fluent) {
    this(fluent, new GlobalVictorOpsConfig());
  }
  
  public GlobalVictorOpsConfigBuilder(GlobalVictorOpsConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GlobalVictorOpsConfigBuilder(GlobalVictorOpsConfigFluent<?> fluent,GlobalVictorOpsConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GlobalVictorOpsConfig build() {
    GlobalVictorOpsConfig buildable = new GlobalVictorOpsConfig(fluent.getApiKey(), fluent.getApiURL());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}