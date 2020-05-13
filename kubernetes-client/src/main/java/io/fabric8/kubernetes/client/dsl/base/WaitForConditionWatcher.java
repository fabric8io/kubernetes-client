package io.fabric8.kubernetes.client.dsl.base;

import java.net.HttpURLConnection;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;

public class WaitForConditionWatcher<T extends HasMetadata> implements Watcher<T> {

  private final Predicate<T> condition;
  private final CompletableFuture<T> future;

  public WaitForConditionWatcher(Predicate<T> condition) {
    this.condition = condition;
    this.future = new CompletableFuture<>();
  }

  public CompletableFuture<T> getFuture() {
    return future;
  }

  @Override
  public void eventReceived(Action action, T resource) {
    switch (action) {
      case ADDED:
      case MODIFIED:
        if (condition.test(resource)) {
          future.complete(resource);
        }
        break;
      case DELETED:
        if (condition.test(null)) {
          future.complete(null);
        }
        break;
      case ERROR:
        future.completeExceptionally(new WatchException("Action.ERROR received"));
        break;
    }
  }

  @Override
  public void onClose(KubernetesClientException cause) {
    future.completeExceptionally(new WatchException("Watcher closed", cause));
  }

  public static class WatchException extends Exception {

    public WatchException(String message, KubernetesClientException cause) {
      super(message, cause);
    }

    public WatchException(String message) {
      super(message);
    }

    public boolean isShouldRetry() {
      return getCause() == null || !isHttpGone();
    }

    private boolean isHttpGone() {
      KubernetesClientException cause = ((KubernetesClientException) getCause());
      return cause.getCode() == HttpURLConnection.HTTP_GONE
        || (cause.getStatus() != null && cause.getStatus().getCode() == HttpURLConnection.HTTP_GONE);
    }
  }
}
