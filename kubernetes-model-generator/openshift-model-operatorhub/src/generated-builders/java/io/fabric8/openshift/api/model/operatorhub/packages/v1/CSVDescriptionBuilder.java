package io.fabric8.openshift.api.model.operatorhub.packages.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSVDescriptionBuilder extends CSVDescriptionFluent<CSVDescriptionBuilder> implements VisitableBuilder<CSVDescription,CSVDescriptionBuilder>{

  CSVDescriptionFluent<?> fluent;

  public CSVDescriptionBuilder() {
    this(new CSVDescription());
  }
  
  public CSVDescriptionBuilder(CSVDescriptionFluent<?> fluent) {
    this(fluent, new CSVDescription());
  }
  
  public CSVDescriptionBuilder(CSVDescription instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSVDescriptionBuilder(CSVDescriptionFluent<?> fluent,CSVDescription instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSVDescription build() {
    CSVDescription buildable = new CSVDescription(fluent.getAnnotations(), fluent.buildApiservicedefinitions(), fluent.buildCustomresourcedefinitions(), fluent.getDescription(), fluent.getDisplayName(), fluent.buildIcon(), fluent.buildInstallModes(), fluent.getKeywords(), fluent.buildLinks(), fluent.buildMaintainers(), fluent.getMaturity(), fluent.getMinKubeVersion(), fluent.getNativeApis(), fluent.buildProvider(), fluent.getRelatedImages(), fluent.getVersion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}