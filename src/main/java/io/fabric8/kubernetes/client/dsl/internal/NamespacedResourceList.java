package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.client.dsl.FilteredNamespacedResourceList;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamedNamespacedResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NamespacedResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>>
  extends BaseResourceList<Type, TypeList, TypeBuilder>
  implements io.fabric8.kubernetes.client.dsl.NamespacedResourceList<Type, TypeList, TypeBuilder>,
  FilteredNamespacedResourceList<Type, TypeList> {

  NamespacedResourceList(String namespace, DefaultResourceList resourceList) {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceType(), resourceList.getClazz(), resourceList.getListClazz(), resourceList.getBuilderClazz());
    setNamespace(namespace);
  }

  @Override
  public Type create(Type resource) throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
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

  @Override
  public FilteredNamespacedResourceList<Type, TypeList> withLabels(Map<String, String> labels) {
    getLabels().putAll(labels);
    return this;
  }

  @Override
  public FilteredNamespacedResourceList<Type, TypeList> withLabel(String key, String value) {
    getLabels().put(key, value);
    return this;
  }

  @Override
  public FilteredNamespacedResourceList<Type, TypeList> withFields(Map<String, String> labels) {
    getFields().putAll(labels);
    return this;
  }

  @Override
  public FilteredNamespacedResourceList<Type, TypeList> withField(String key, String value) {
    getFields().put(key, value);
    return this;
  }

  @Override
  public NamedNamespacedResource<Type, TypeBuilder> withName(String name) throws KubernetesClientException {
    return new NamedResource<>(name, this);
  }

}
