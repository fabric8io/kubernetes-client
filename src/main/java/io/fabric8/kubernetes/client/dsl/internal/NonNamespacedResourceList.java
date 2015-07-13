package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.base.Status;
import io.fabric8.kubernetes.client.dsl.NamedResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NonNamespacedResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>>
  extends DefaultResourceList<Type, TypeList, TypeBuilder>
  implements io.fabric8.kubernetes.client.dsl.NonNamespacedResourceList<Type, TypeList, TypeBuilder> {

  public NonNamespacedResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<Type> clazz, Class<TypeList> listClazz, Class<TypeBuilder> builderClazz) {
    super(httpClient, rootUrl, resourceType, clazz, listClazz, builderClazz);
  }

  @Override
  public NamedResource<Type, TypeBuilder> withName(String name) {
    return new io.fabric8.kubernetes.client.dsl.internal.NamedResource<Type, TypeBuilder>(name, this);
  }

  @Override
  public Type create(Type resource) throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      requestUrl = new URL(requestUrl, getResourceType());
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePost(requestUrl.toString());
      requestBuilder.setBody(mapper.writer().writeValueAsString(resource));
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 201) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(getClazz()).readValue(r.getResponseBodyAsStream());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to create resource", e);
    }
  }

}
