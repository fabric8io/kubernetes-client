package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NetworkSpecBuilder extends NetworkSpecFluent<NetworkSpecBuilder> implements VisitableBuilder<NetworkSpec,NetworkSpecBuilder>{

  NetworkSpecFluent<?> fluent;

  public NetworkSpecBuilder() {
    this(new NetworkSpec());
  }
  
  public NetworkSpecBuilder(NetworkSpecFluent<?> fluent) {
    this(fluent, new NetworkSpec());
  }
  
  public NetworkSpecBuilder(NetworkSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NetworkSpecBuilder(NetworkSpecFluent<?> fluent,NetworkSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NetworkSpec build() {
    NetworkSpec buildable = new NetworkSpec(fluent.buildAdditionalNetworks(), fluent.buildAdditionalRoutingCapabilities(), fluent.buildClusterNetwork(), fluent.buildDefaultNetwork(), fluent.getDeployKubeProxy(), fluent.getDisableMultiNetwork(), fluent.getDisableNetworkDiagnostics(), fluent.buildExportNetworkFlows(), fluent.buildKubeProxyConfig(), fluent.getLogLevel(), fluent.getManagementState(), fluent.buildMigration(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getServiceNetwork(), fluent.getUnsupportedConfigOverrides(), fluent.getUseMultiNetworkPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}