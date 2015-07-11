package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;

import java.net.URL;

public class ReplicationControllerResource extends Resource<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> {

  public ReplicationControllerResource(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class listClazz, Class clazz, Class clazzBuilder) {
    super(httpClient, rootUrl, resourceType, listClazz, clazz, clazzBuilder);
  }

  public ReplicationController scale(String name, final int replicas) throws KubernetesClientException {
    return update(name, new BuilderUpdate<ReplicationController, ReplicationControllerBuilder>() {
      @Override
      public ReplicationController update(ReplicationControllerBuilder builder) {
        return builder.editSpec().withReplicas(replicas).endSpec().build();
      }
    });
  }

  public ReplicationControllerResource inNamespace(String namespace) {
    this.namespace = namespace;
    return this;
  }
}
