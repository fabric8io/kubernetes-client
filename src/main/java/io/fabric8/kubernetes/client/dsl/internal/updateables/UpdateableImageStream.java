package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamBuilder;
import io.fabric8.openshift.api.model.ImageStreamFluent;

public class UpdateableImageStream extends ImageStreamFluent<UpdateableImageStream> implements Updateable<ImageStream> {

  private final ImageStreamBuilder builder;
  private final Update<ImageStream> update;

  public UpdateableImageStream(ImageStream imageStream, Update<ImageStream> update) {
    this.update = update;
    builder = new ImageStreamBuilder(this, imageStream);
  }

  @Override
  public ImageStream update() {
    return update.apply(builder.build());
  }
}
