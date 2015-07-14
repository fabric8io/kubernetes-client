package io.fabric8.kubernetes.client.dsl.internal.updateables;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceFluent;
import io.fabric8.kubernetes.client.dsl.Updateable;
import io.fabric8.openshift.api.model.ImageStream;
import io.fabric8.openshift.api.model.ImageStreamFluent;

public class UpdateableImageStream extends ImageStreamFluent<UpdateableImageStream> implements Updateable<ImageStream> {

  @Override
  public ImageStream update() {
    return null;
  }
}
