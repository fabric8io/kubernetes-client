package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TrafficPolicyTunnelSettingsBuilder extends TrafficPolicyTunnelSettingsFluent<TrafficPolicyTunnelSettingsBuilder> implements VisitableBuilder<TrafficPolicyTunnelSettings,TrafficPolicyTunnelSettingsBuilder>{

  TrafficPolicyTunnelSettingsFluent<?> fluent;

  public TrafficPolicyTunnelSettingsBuilder() {
    this(new TrafficPolicyTunnelSettings());
  }
  
  public TrafficPolicyTunnelSettingsBuilder(TrafficPolicyTunnelSettingsFluent<?> fluent) {
    this(fluent, new TrafficPolicyTunnelSettings());
  }
  
  public TrafficPolicyTunnelSettingsBuilder(TrafficPolicyTunnelSettings instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TrafficPolicyTunnelSettingsBuilder(TrafficPolicyTunnelSettingsFluent<?> fluent,TrafficPolicyTunnelSettings instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TrafficPolicyTunnelSettings build() {
    TrafficPolicyTunnelSettings buildable = new TrafficPolicyTunnelSettings(fluent.getProtocol(), fluent.getTargetHost(), fluent.getTargetPort());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}