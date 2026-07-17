package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class BuildLogOptionsBuilder extends BuildLogOptionsFluent<BuildLogOptionsBuilder> implements VisitableBuilder<BuildLogOptions,BuildLogOptionsBuilder>{

  BuildLogOptionsFluent<?> fluent;

  public BuildLogOptionsBuilder() {
    this(new BuildLogOptions());
  }
  
  public BuildLogOptionsBuilder(BuildLogOptionsFluent<?> fluent) {
    this(fluent, new BuildLogOptions());
  }
  
  public BuildLogOptionsBuilder(BuildLogOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public BuildLogOptionsBuilder(BuildLogOptionsFluent<?> fluent,BuildLogOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public BuildLogOptions build() {
    BuildLogOptions buildable = new BuildLogOptions(fluent.getApiVersion(), fluent.getContainer(), fluent.getFollow(), fluent.getInsecureSkipTLSVerifyBackend(), fluent.getKind(), fluent.getLimitBytes(), fluent.getNowait(), fluent.getPrevious(), fluent.getSinceSeconds(), fluent.getSinceTime(), fluent.getTailLines(), fluent.getTimestamps(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}