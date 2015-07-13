package io.fabric8.kubernetes.client.dsl.internal;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.client.dsl.BuilderUpdate;
import io.fabric8.kubernetes.client.dsl.KubernetesClientException;
import io.fabric8.kubernetes.client.dsl.NamedNamespacedResource;
import io.fabric8.kubernetes.client.dsl.Update;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.base.Status;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NamedResource<Type extends HasMetadata, TypeBuilder extends Builder<Type>>
  extends BaseResource<Type, TypeBuilder>
  implements io.fabric8.kubernetes.client.dsl.NamedResource<Type, TypeBuilder>,
  NamedNamespacedResource<Type, TypeBuilder> {

  private String name;
  private String namespace;

  NamedResource(String name, DefaultResourceList<Type, ?, TypeBuilder> resourceList) {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceType(), resourceList.getClazz(), resourceList.getBuilderClazz());
    this.name = name;
  }

  NamedResource(String name, NamespacedResourceList<Type, ?, TypeBuilder> resourceList) {
    super(resourceList.getHttpClient(), resourceList.getRootUrl(), resourceList.getResourceType(), resourceList.getClazz(), resourceList.getBuilderClazz());
    setNamespace(resourceList.getNamespace());
    this.name = name;
  }

  @Override
  public Type get() throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + name);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareGet(requestUrl.toString());
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(getClazz()).readValue(r.getResponseBodyAsStream());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to get resource", e);
    }
  }

  @Override
  public Type update(BuilderUpdate<Type, TypeBuilder> update) throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + name);

      Type current = this.get();
      Type updated = update.apply(getBuilderClazz().getDeclaredConstructor(getClazz()).newInstance(current));

      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePut(requestUrl.toString());
      requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(getClazz()).readValue(r.getResponseBodyAsStream());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new KubernetesClientException("Unable to update resource", e);
    }
  }

  @Override
  public Type update(Update<Type> update) throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + name);

      Type current = this.get();
      Type updated = update.apply(current);

      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().preparePut(requestUrl.toString());
      requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(getClazz()).readValue(r.getResponseBodyAsStream());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to update resource", e);
    }
  }

  @Override
  public void delete() throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + name);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareDelete(requestUrl.toString());
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to delete resource", e);
    }
  }
}
