package io.fabric8.kubernetes.api.model.version;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class InfoBuilder extends InfoFluent<InfoBuilder> implements VisitableBuilder<Info,InfoBuilder>{

  InfoFluent<?> fluent;

  public InfoBuilder() {
    this(new Info());
  }
  
  public InfoBuilder(InfoFluent<?> fluent) {
    this(fluent, new Info());
  }
  
  public InfoBuilder(Info instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public InfoBuilder(InfoFluent<?> fluent,Info instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Info build() {
    Info buildable = new Info(fluent.getBuildDate(), fluent.getCompiler(), fluent.getEmulationMajor(), fluent.getEmulationMinor(), fluent.getGitCommit(), fluent.getGitTreeState(), fluent.getGitVersion(), fluent.getGoVersion(), fluent.getMajor(), fluent.getMinCompatibilityMajor(), fluent.getMinCompatibilityMinor(), fluent.getMinor(), fluent.getPlatform());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}