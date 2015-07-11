package io.fabric8.kubernetes;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.base.Status;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NamedResource<ResourceListType extends KubernetesResourceList, ResourceType extends HasMetadata, ResourceBuilder extends Builder<ResourceType>>
  extends NamespacedResource<ResourceListType, ResourceType, ResourceBuilder> {

  private String resourceName;

  public NamedResource(String resourceName, ResourceList<ResourceListType, ResourceType, ResourceBuilder> resource) {
    super(resource.getNamespace(), resource);
    this.resourceName = resourceName;
  }

  public ResourceType get() throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + resourceName);
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

  public ResourceType delete(String resourceName) throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + resourceName);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareDelete(requestUrl.toString());
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
      throw new KubernetesClientException("Unable to delete resource", e);
    }
  }

  public ResourceType update(BuilderUpdate<ResourceType, ResourceBuilder> builder) throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + resourceName);

      ResourceType current = this.get();
      ResourceType updated = builder.update(getBuilderClazz().getDeclaredConstructor(getClazz()).newInstance(current));

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

  public ResourceListType update(Update<ResourceType> resourceUpdate) throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType() + "/" + resourceName);

      ResourceType current = this.get();
      ResourceType updated = resourceUpdate.update(current);

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

  public interface Update<ResourceType extends HasMetadata> {
    ResourceType update(ResourceType resource);
  }

  public interface BuilderUpdate<ResourceType extends HasMetadata, ResourceBuilder extends Builder<ResourceType>> {
    ResourceType update(ResourceBuilder builder);
  }

}
