package io.fabric8.kubernetes.client.dsl;

public interface Watcher<Type> {

  void eventReceived(Action action, Type resource);

  enum Action {
    ADDED, MODIFIED, DELETED, ERROR
  }

}
