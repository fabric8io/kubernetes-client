package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InstallerManifestPatchBuilder extends InstallerManifestPatchFluent<InstallerManifestPatchBuilder> implements VisitableBuilder<InstallerManifestPatch,InstallerManifestPatchBuilder>{

  InstallerManifestPatchFluent<?> fluent;

  public InstallerManifestPatchBuilder() {
    this(new InstallerManifestPatch());
  }
  
  public InstallerManifestPatchBuilder(InstallerManifestPatchFluent<?> fluent) {
    this(fluent, new InstallerManifestPatch());
  }
  
  public InstallerManifestPatchBuilder(InstallerManifestPatch instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InstallerManifestPatchBuilder(InstallerManifestPatchFluent<?> fluent,InstallerManifestPatch instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public InstallerManifestPatch build() {
    InstallerManifestPatch buildable = new InstallerManifestPatch(fluent.buildManifestSelector(), fluent.buildPatches());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}