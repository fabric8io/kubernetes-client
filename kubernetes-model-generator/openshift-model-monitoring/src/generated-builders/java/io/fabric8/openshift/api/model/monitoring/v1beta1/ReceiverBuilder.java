package io.fabric8.openshift.api.model.monitoring.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReceiverBuilder extends ReceiverFluent<ReceiverBuilder> implements VisitableBuilder<Receiver,ReceiverBuilder>{

  ReceiverFluent<?> fluent;

  public ReceiverBuilder() {
    this(new Receiver());
  }
  
  public ReceiverBuilder(ReceiverFluent<?> fluent) {
    this(fluent, new Receiver());
  }
  
  public ReceiverBuilder(Receiver instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReceiverBuilder(ReceiverFluent<?> fluent,Receiver instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Receiver build() {
    Receiver buildable = new Receiver(fluent.buildDiscordConfigs(), fluent.buildEmailConfigs(), fluent.buildMsteamsConfigs(), fluent.buildMsteamsv2Configs(), fluent.getName(), fluent.buildOpsgenieConfigs(), fluent.buildPagerdutyConfigs(), fluent.buildPushoverConfigs(), fluent.buildRocketchatConfigs(), fluent.buildSlackConfigs(), fluent.buildSnsConfigs(), fluent.buildTelegramConfigs(), fluent.buildVictoropsConfigs(), fluent.buildWebexConfigs(), fluent.buildWebhookConfigs(), fluent.buildWechatConfigs());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}