package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import io.fabric8.kubernetes.api.model.ReplicationController;
import io.fabric8.kubernetes.api.model.ReplicationControllerBuilder;
import io.fabric8.kubernetes.api.model.ReplicationControllerList;

import java.net.URL;

public class ReplicationControllerResource extends Resource<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> {

  public ReplicationControllerResource(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<ReplicationControllerList> listClazz, Class<ReplicationController> clazz, Class<ReplicationControllerBuilder> clazzBuilder) {
    super(httpClient, rootUrl, resourceType, listClazz, clazz, clazzBuilder);
  }

  public ReplicationControllerNamespacedResource inNamespace(String namespace) {
    return new ReplicationControllerNamespacedResource(namespace, this);
  }

  public class ReplicationControllerNamespacedResource extends NamespacedResource<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> {
    public ReplicationControllerNamespacedResource(String namespace, ResourceList<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> resource) {
      super(namespace, resource);
    }

    @Override
    public ReplicationControllerNamedResource withName(String resourceName) {
      return new ReplicationControllerNamedResource(resourceName, this);
    }
  }

  public class ReplicationControllerNamedResource extends NamedResource<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> {
    public ReplicationControllerNamedResource(String namespace, ResourceList<ReplicationControllerList, ReplicationController, ReplicationControllerBuilder> resource) {
      super(namespace, resource);
    }

    public ReplicationController scale(final int replicas) throws KubernetesClientException {
      return update(new NamedResource.BuilderUpdate<ReplicationController, ReplicationControllerBuilder>() {
        @Override
        public ReplicationController update(ReplicationControllerBuilder builder) {
          return builder.editSpec().withReplicas(replicas).endSpec().build();
        }
      });
    }
  }
}
