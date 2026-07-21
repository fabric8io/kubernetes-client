package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HiveConfigSpecBuilder extends HiveConfigSpecFluent<HiveConfigSpecBuilder> implements VisitableBuilder<HiveConfigSpec,HiveConfigSpecBuilder>{

  HiveConfigSpecFluent<?> fluent;

  public HiveConfigSpecBuilder() {
    this(new HiveConfigSpec());
  }
  
  public HiveConfigSpecBuilder(HiveConfigSpecFluent<?> fluent) {
    this(fluent, new HiveConfigSpec());
  }
  
  public HiveConfigSpecBuilder(HiveConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HiveConfigSpecBuilder(HiveConfigSpecFluent<?> fluent,HiveConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HiveConfigSpec build() {
    HiveConfigSpec buildable = new HiveConfigSpec(fluent.buildAdditionalCertificateAuthorities(), fluent.buildBackup(), fluent.buildExternalDNS(), fluent.buildFailedProvisionConfig(), fluent.buildGlobalPullSecret(), fluent.getMaintenanceMode());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}