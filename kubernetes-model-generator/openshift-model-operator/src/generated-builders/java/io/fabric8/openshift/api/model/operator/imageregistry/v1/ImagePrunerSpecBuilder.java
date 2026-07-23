package io.fabric8.openshift.api.model.operator.imageregistry.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ImagePrunerSpecBuilder extends ImagePrunerSpecFluent<ImagePrunerSpecBuilder> implements VisitableBuilder<ImagePrunerSpec,ImagePrunerSpecBuilder>{

  ImagePrunerSpecFluent<?> fluent;

  public ImagePrunerSpecBuilder() {
    this(new ImagePrunerSpec());
  }
  
  public ImagePrunerSpecBuilder(ImagePrunerSpecFluent<?> fluent) {
    this(fluent, new ImagePrunerSpec());
  }
  
  public ImagePrunerSpecBuilder(ImagePrunerSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ImagePrunerSpecBuilder(ImagePrunerSpecFluent<?> fluent,ImagePrunerSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ImagePrunerSpec build() {
    ImagePrunerSpec buildable = new ImagePrunerSpec(fluent.getAffinity(), fluent.getFailedJobsHistoryLimit(), fluent.getIgnoreInvalidImageReferences(), fluent.getKeepTagRevisions(), fluent.getKeepYoungerThan(), fluent.getKeepYoungerThanDuration(), fluent.getLogLevel(), fluent.getNodeSelector(), fluent.buildResources(), fluent.getSchedule(), fluent.getSuccessfulJobsHistoryLimit(), fluent.getSuspend(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}