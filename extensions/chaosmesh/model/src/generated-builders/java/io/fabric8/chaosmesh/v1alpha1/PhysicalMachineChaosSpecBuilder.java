package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PhysicalMachineChaosSpecBuilder extends PhysicalMachineChaosSpecFluent<PhysicalMachineChaosSpecBuilder> implements VisitableBuilder<PhysicalMachineChaosSpec,PhysicalMachineChaosSpecBuilder>{

  PhysicalMachineChaosSpecFluent<?> fluent;

  public PhysicalMachineChaosSpecBuilder() {
    this(new PhysicalMachineChaosSpec());
  }
  
  public PhysicalMachineChaosSpecBuilder(PhysicalMachineChaosSpecFluent<?> fluent) {
    this(fluent, new PhysicalMachineChaosSpec());
  }
  
  public PhysicalMachineChaosSpecBuilder(PhysicalMachineChaosSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PhysicalMachineChaosSpecBuilder(PhysicalMachineChaosSpecFluent<?> fluent,PhysicalMachineChaosSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PhysicalMachineChaosSpec build() {
    PhysicalMachineChaosSpec buildable = new PhysicalMachineChaosSpec(fluent.getAction(), fluent.getAddress(), fluent.buildClock(), fluent.buildDiskFill(), fluent.buildDiskReadPayload(), fluent.buildDiskWritePayload(), fluent.getDuration(), fluent.buildFileAppend(), fluent.buildFileCreate(), fluent.buildFileDelete(), fluent.buildFileModify(), fluent.buildFileRename(), fluent.buildFileReplace(), fluent.buildHttpAbort(), fluent.buildHttpConfig(), fluent.buildHttpDelay(), fluent.buildHttpRequest(), fluent.buildJvmException(), fluent.buildJvmGc(), fluent.buildJvmLatency(), fluent.buildJvmMysql(), fluent.buildJvmReturn(), fluent.buildJvmRuleData(), fluent.buildJvmStress(), fluent.buildKafkaFill(), fluent.buildKafkaFlood(), fluent.buildKafkaIo(), fluent.getMode(), fluent.buildNetworkBandwidth(), fluent.buildNetworkCorrupt(), fluent.buildNetworkDelay(), fluent.buildNetworkDns(), fluent.buildNetworkDown(), fluent.buildNetworkDuplicate(), fluent.buildNetworkFlood(), fluent.buildNetworkLoss(), fluent.buildNetworkPartition(), fluent.buildProcess(), fluent.buildRedisCacheLimit(), fluent.buildRedisExpiration(), fluent.buildRedisPenetration(), fluent.buildRedisRestart(), fluent.buildRedisStop(), fluent.getRemoteCluster(), fluent.buildSelector(), fluent.buildStressCpu(), fluent.buildStressMem(), fluent.buildUserDefined(), fluent.getValue(), fluent.buildVm());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}