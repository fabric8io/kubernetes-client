package io.fabric8.kubernetes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.base.Status;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ResourceCreate<ResourceType extends HasMetadata> {

  private static final ObjectMapper mapper = new ObjectMapper();
  private AsyncHttpClient httpClient;
  private URL rootUrl;
  private String resourceType;
  private String namespace;
  private ResourceType resource;
  private Class<ResourceType> clazz;

  public ResourceCreate(AsyncHttpClient httpClient, URL rootUrl, String resourceType, ResourceType resource) {
    this.httpClient = httpClient;
    this.rootUrl = rootUrl;
    this.resourceType = resourceType;
    this.resource = resource;
    if (resource.getMetadata().getNamespace() != null) {
      this.namespace = resource.getMetadata().getNamespace();
    }
    this.clazz = (Class<ResourceType>) resource.getClass();
  }

  public ResourceCreate<ResourceType> inNamespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

  public ResourceType create() throws KubernetesClientException {
    try {
      URL requestUrl = rootUrl;
      if (namespace != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
      }
      requestUrl = new URL(requestUrl, resourceType);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.prepareGet(requestUrl.toString());
      requestBuilder.setBody(mapper.writer().writeValueAsString(resource));
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(clazz).readValue(r.getResponseBodyAsStream());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to get resource", e);
    }
  }

}
