package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BareMetalHostSpecBuilder extends BareMetalHostSpecFluent<BareMetalHostSpecBuilder> implements VisitableBuilder<BareMetalHostSpec,BareMetalHostSpecBuilder>{

  BareMetalHostSpecFluent<?> fluent;

  public BareMetalHostSpecBuilder() {
    this(new BareMetalHostSpec());
  }
  
  public BareMetalHostSpecBuilder(BareMetalHostSpecFluent<?> fluent) {
    this(fluent, new BareMetalHostSpec());
  }
  
  public BareMetalHostSpecBuilder(BareMetalHostSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BareMetalHostSpecBuilder(BareMetalHostSpecFluent<?> fluent,BareMetalHostSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BareMetalHostSpec build() {
    BareMetalHostSpec buildable = new BareMetalHostSpec(fluent.getArchitecture(), fluent.getAutomatedCleaningMode(), fluent.buildBmc(), fluent.getBootMACAddress(), fluent.getBootMode(), fluent.buildConsumerRef(), fluent.buildCustomDeploy(), fluent.getDescription(), fluent.getDisablePowerOff(), fluent.getExternallyProvisioned(), fluent.buildFirmware(), fluent.getHardwareProfile(), fluent.buildImage(), fluent.getInspectionMode(), fluent.getMetaData(), fluent.getNetworkData(), fluent.getOnline(), fluent.getPreprovisioningNetworkDataName(), fluent.buildRaid(), fluent.buildRootDeviceHints(), fluent.getTaints(), fluent.getUserData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}