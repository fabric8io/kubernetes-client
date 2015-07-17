package io.fabric8.kubernetes.client;

public interface Watcher<T> {

  void eventReceived(Action action, T resource);

  enum Action {
    ADDED, MODIFIED, DELETED, ERROR
  }

}
