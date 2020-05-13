package io.fabric8.kubernetes.client.dsl;

import io.fabric8.kubernetes.client.WaitRetryBackoffConfigurable;

public interface WatchingWaitableWithBackoff<T, P> extends Waitable<T, P>, WaitRetryBackoffConfigurable<WatchingWaitableWithBackoff<T, P>> {
}
