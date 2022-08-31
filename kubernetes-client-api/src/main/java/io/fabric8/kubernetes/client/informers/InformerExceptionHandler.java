package io.fabric8.kubernetes.client.informers;

import io.fabric8.kubernetes.client.WatcherException;

public interface InformerExceptionHandler {

  void onWatchNonrecoverable(WatcherException e);

}
