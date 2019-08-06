package io.fabric8.kubernetes.client.utils;

import io.fabric8.kubernetes.api.model.ListOptions;
import io.fabric8.kubernetes.client.KubernetesClientException;
import okhttp3.Call;

/**
 * The interface Call generator. It's for homogenizing client interface so that we invoke a
 * generized adapter interface elsewhere.
 *
 */
@FunctionalInterface
public interface CallGenerator {

  Call generate(ListOptions params) throws KubernetesClientException;
}
