package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ChaosOnlyScheduleSpecBuilder extends ChaosOnlyScheduleSpecFluent<ChaosOnlyScheduleSpecBuilder> implements VisitableBuilder<ChaosOnlyScheduleSpec,ChaosOnlyScheduleSpecBuilder>{

  ChaosOnlyScheduleSpecFluent<?> fluent;

  public ChaosOnlyScheduleSpecBuilder() {
    this(new ChaosOnlyScheduleSpec());
  }
  
  public ChaosOnlyScheduleSpecBuilder(ChaosOnlyScheduleSpecFluent<?> fluent) {
    this(fluent, new ChaosOnlyScheduleSpec());
  }
  
  public ChaosOnlyScheduleSpecBuilder(ChaosOnlyScheduleSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ChaosOnlyScheduleSpecBuilder(ChaosOnlyScheduleSpecFluent<?> fluent,ChaosOnlyScheduleSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ChaosOnlyScheduleSpec build() {
    ChaosOnlyScheduleSpec buildable = new ChaosOnlyScheduleSpec(fluent.buildAwsChaos(), fluent.buildAzureChaos(), fluent.buildBlockChaos(), fluent.getConcurrencyPolicy(), fluent.buildDnsChaos(), fluent.buildGcpChaos(), fluent.getHistoryLimit(), fluent.buildHttpChaos(), fluent.buildIoChaos(), fluent.buildJvmChaos(), fluent.buildKernelChaos(), fluent.buildNetworkChaos(), fluent.buildPhysicalmachineChaos(), fluent.buildPodChaos(), fluent.getSchedule(), fluent.getStartingDeadlineSeconds(), fluent.buildStressChaos(), fluent.buildTimeChaos(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}