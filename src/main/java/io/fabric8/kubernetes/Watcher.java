package io.fabric8.kubernetes;

public interface Watcher<Type> {

  void eventReceived(Action action, Type resource);

  enum Action {
    ADDED, MODIFIED, DELETED, ERROR
  }

}
