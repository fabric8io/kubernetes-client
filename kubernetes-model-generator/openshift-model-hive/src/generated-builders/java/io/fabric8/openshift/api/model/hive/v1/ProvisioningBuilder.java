package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ProvisioningBuilder extends ProvisioningFluent<ProvisioningBuilder> implements VisitableBuilder<Provisioning,ProvisioningBuilder>{

  ProvisioningFluent<?> fluent;

  public ProvisioningBuilder() {
    this(new Provisioning());
  }
  
  public ProvisioningBuilder(ProvisioningFluent<?> fluent) {
    this(fluent, new Provisioning());
  }
  
  public ProvisioningBuilder(Provisioning instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ProvisioningBuilder(ProvisioningFluent<?> fluent,Provisioning instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Provisioning build() {
    Provisioning buildable = new Provisioning(fluent.buildImageSetRef(), fluent.buildInstallConfigSecretRef(), fluent.buildInstallerEnv(), fluent.getInstallerImageOverride(), fluent.buildManifestsConfigMapRef(), fluent.buildManifestsSecretRef(), fluent.getReleaseImage(), fluent.getSshKnownHosts(), fluent.buildSshPrivateKeySecretRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}