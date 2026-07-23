package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class KubeletConfigSpecBuilder extends KubeletConfigSpecFluent<KubeletConfigSpecBuilder> implements VisitableBuilder<KubeletConfigSpec,KubeletConfigSpecBuilder>{

  KubeletConfigSpecFluent<?> fluent;

  public KubeletConfigSpecBuilder() {
    this(new KubeletConfigSpec());
  }
  
  public KubeletConfigSpecBuilder(KubeletConfigSpecFluent<?> fluent) {
    this(fluent, new KubeletConfigSpec());
  }
  
  public KubeletConfigSpecBuilder(KubeletConfigSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public KubeletConfigSpecBuilder(KubeletConfigSpecFluent<?> fluent,KubeletConfigSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public KubeletConfigSpec build() {
    KubeletConfigSpec buildable = new KubeletConfigSpec(fluent.getAutoSizingReserved(), fluent.getKubeletConfig(), fluent.getLogLevel(), fluent.buildMachineConfigPoolSelector(), fluent.getTlsSecurityProfile());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}