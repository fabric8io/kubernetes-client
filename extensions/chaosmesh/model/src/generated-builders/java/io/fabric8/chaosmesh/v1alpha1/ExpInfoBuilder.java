package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ExpInfoBuilder extends ExpInfoFluent<ExpInfoBuilder> implements VisitableBuilder<ExpInfo,ExpInfoBuilder>{

  ExpInfoFluent<?> fluent;

  public ExpInfoBuilder() {
    this(new ExpInfo());
  }
  
  public ExpInfoBuilder(ExpInfoFluent<?> fluent) {
    this(fluent, new ExpInfo());
  }
  
  public ExpInfoBuilder(ExpInfo instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ExpInfoBuilder(ExpInfoFluent<?> fluent,ExpInfo instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ExpInfo build() {
    ExpInfo buildable = new ExpInfo(fluent.buildClock(), fluent.buildDiskFill(), fluent.buildDiskReadPayload(), fluent.buildDiskWritePayload(), fluent.buildFileAppend(), fluent.buildFileCreate(), fluent.buildFileDelete(), fluent.buildFileModify(), fluent.buildFileRename(), fluent.buildFileReplace(), fluent.buildHttpAbort(), fluent.buildHttpConfig(), fluent.buildHttpDelay(), fluent.buildHttpRequest(), fluent.buildJvmException(), fluent.buildJvmGc(), fluent.buildJvmLatency(), fluent.buildJvmMysql(), fluent.buildJvmReturn(), fluent.buildJvmRuleData(), fluent.buildJvmStress(), fluent.buildKafkaFill(), fluent.buildKafkaFlood(), fluent.buildKafkaIo(), fluent.buildNetworkBandwidth(), fluent.buildNetworkCorrupt(), fluent.buildNetworkDelay(), fluent.buildNetworkDns(), fluent.buildNetworkDown(), fluent.buildNetworkDuplicate(), fluent.buildNetworkFlood(), fluent.buildNetworkLoss(), fluent.buildNetworkPartition(), fluent.buildProcess(), fluent.buildRedisCacheLimit(), fluent.buildRedisExpiration(), fluent.buildRedisPenetration(), fluent.buildRedisRestart(), fluent.buildRedisStop(), fluent.buildStressCpu(), fluent.buildStressMem(), fluent.buildUserDefined(), fluent.buildVm());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}