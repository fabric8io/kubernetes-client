package io.fabric8.kubernetes;

import io.fabric8.kubernetes.api.model.HasMetadata;

public interface Watcher<ResourceType extends HasMetadata> {

  enum Action {
    ADDED, MODIFIED, DELETED, ERROR
  }

  void eventReceived(Action action, ResourceType resource);

}
