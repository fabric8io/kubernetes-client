package io.fabric8.kubernetes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import com.ning.http.client.ws.DefaultWebSocketListener;
import com.ning.http.client.ws.WebSocket;
import com.ning.http.client.ws.WebSocketUpgradeHandler;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.base.Status;
import io.fabric8.kubernetes.api.watch.WatchEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class ResourceList<ResourceListType extends KubernetesResourceList, ResourceType extends HasMetadata, ResourceBuilder extends Builder<ResourceType>> {

  protected static final ObjectMapper mapper = new ObjectMapper();

  private URL rootUrl;
  private Class<ResourceListType> listClazz;

  private Class<ResourceType> clazz;
  private Class<ResourceBuilder> builderClazz;
  private String namespace;
  private String resourceType;

  private AsyncHttpClient httpClient;

  private Map<String, String> labels;
  private Map<String, String> fields;

  protected ResourceList(URL rootUrl, Class<ResourceListType> listClazz, Class<ResourceType> clazz, Class<ResourceBuilder> clazzBuilder, String resourceType, AsyncHttpClient httpClient) {
    this.rootUrl = rootUrl;
    this.builderClazz = builderClazz;
    this.clazz = clazz;
    this.listClazz = listClazz;
    this.resourceType = resourceType;
    this.httpClient = httpClient;
  }

  protected ResourceList(String namespace, ResourceList<ResourceListType, ResourceType, ResourceBuilder> resource) {
    this.namespace = namespace;
    this.rootUrl = resource.getRootUrl();
    this.clazz = resource.getClazz();
    this.builderClazz = resource.getBuilderClazz();
    this.listClazz = resource.getListClazz();
    this.resourceType = resource.getResourceType();
    this.httpClient = resource.getHttpClient();
  }

  protected URL getRootUrl() {
    return rootUrl;
  }

  protected Class<ResourceListType> getListClazz() {
    return listClazz;
  }

  protected Class<ResourceType> getClazz() {
    return clazz;
  }

  protected Class<ResourceBuilder> getBuilderClazz() {
    return builderClazz;
  }

  protected String getNamespace() {
    return namespace;
  }

  protected String getResourceType() {
    return resourceType;
  }

  protected AsyncHttpClient getHttpClient() {
    return httpClient;
  }

  public ResourceListType list() throws KubernetesClientException {
    try {
      URL requestUrl = rootUrl;
      if (namespace != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
      }
      requestUrl = new URL(requestUrl, resourceType);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.prepareGet(requestUrl.toString());
      if (labels != null && !labels.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> iter = labels.entrySet().iterator(); iter.hasNext(); ) {
          Map.Entry<String, String> entry = iter.next();
          sb.append(entry.getKey()).append("=").append(entry.getValue());
          if (iter.hasNext()) {
            sb.append(",");
          }
        }
        requestBuilder.addQueryParam("labelSelector", sb.toString());
      }
      if (fields != null && !fields.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (Iterator<Map.Entry<String, String>> iter = fields.entrySet().iterator(); iter.hasNext(); ) {
          Map.Entry<String, String> entry = iter.next();
          sb.append(entry.getKey()).append("=").append(entry.getValue());
          if (iter.hasNext()) {
            sb.append(",");
          }
        }
        requestBuilder.addQueryParam("fieldSelector", sb.toString());
      }
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(listClazz).readValue(r.getResponseBodyAsStream());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to delete resource", e);
    }
  }

  public ResourceListType delete() throws KubernetesClientException {
      try {
        ResourceListType discoveredResources = list();

        for (Object resource : discoveredResources.getItems()) {
          // Dirty cast but should always be valid...
          HasMetadata metadataResource = (HasMetadata) resource;

          URL requestUrl = rootUrl;
          if (metadataResource.getMetadata().getNamespace() != null) {
            requestUrl = new URL(requestUrl, "namespaces/" + metadataResource.getMetadata().getNamespace() + "/");
          }
          requestUrl = new URL(requestUrl, resourceType + "/" + metadataResource.getMetadata().getName());
          AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.prepareDelete(requestUrl.toString());
          Future<Response> f = requestBuilder.execute();
          Response r = f.get();
          if (r.getStatusCode() != 200) {
            Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
            throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
          }
        }

        return discoveredResources;
      } catch (MalformedURLException e) {
        throw new KubernetesClientException("Malformed resource URL", e);
      } catch (InterruptedException | ExecutionException | IOException e) {
        throw new KubernetesClientException("Unable to delete resources", e);
      }
  }

  public WebSocket watch(final Watcher<ResourceType> watcher) throws KubernetesClientException {
    try {
      URL requestUrl = rootUrl;
    if (namespace != null) {
      requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
    }
    requestUrl = new URL(requestUrl, resourceType);
    AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.prepareGet(requestUrl.toString().replaceFirst("^http", "ws"));
    if (labels != null && !labels.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      for (Iterator<Map.Entry<String, String>> iter = labels.entrySet().iterator(); iter.hasNext(); ) {
        Map.Entry<String, String> entry = iter.next();
        sb.append(entry.getKey()).append("=").append(entry.getValue());
        if (iter.hasNext()) {
          sb.append(",");
        }
      }
      requestBuilder.addQueryParam("labelSelector", sb.toString());
    }
    if (fields != null && !fields.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      for (Iterator<Map.Entry<String, String>> iter = fields.entrySet().iterator(); iter.hasNext(); ) {
        Map.Entry<String, String> entry = iter.next();
        sb.append(entry.getKey()).append("=").append(entry.getValue());
        if (iter.hasNext()) {
          sb.append(",");
        }
      }
      requestBuilder.addQueryParam("fieldSelector", sb.toString());
    }
    requestBuilder.addQueryParam("watch", "true");
    Future<WebSocket> f = requestBuilder.execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(
        new DefaultWebSocketListener() {

          private final Logger logger = LoggerFactory.getLogger(this.getClass());

          @Override
          public void onMessage(String message) {
            try {
              WatchEvent event = mapper.reader(WatchEvent.class).readValue(message);
              ResourceType obj = (ResourceType) event.getObject();
              Watcher.Action action = Watcher.Action.valueOf(event.getType());
              watcher.eventReceived(action, obj);
            } catch (IOException e) {
              logger.error("Could not deserialize watch event: {}", message, e);
            } catch (ClassCastException e) {
              logger.error("Received wrong type of object for watch", e);
            } catch (IllegalArgumentException e) {
              logger.error("Invalid event type", e);
            }
          }
        }).build()
    );
      return f.get();
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException e) {
      throw new KubernetesClientException("Unable to watch resources", e);
    }
  }

  public ResourceType create(ResourceType resource) throws KubernetesClientException {
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

  public ResourceList<ResourceListType, ResourceType, ResourceBuilder> withLabels(Map<String, String> labels) {
    if (this.labels == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.labels = new TreeMap<>();
    }
    this.labels.putAll(labels);
    return this;
  }

  public ResourceList<ResourceListType, ResourceType, ResourceBuilder> withLabel(String key, String value) {
    if (this.labels == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.labels = new TreeMap<>();
    }
    this.labels.put(key, value);
    return this;
  }

  public ResourceList<ResourceListType, ResourceType, ResourceBuilder> withFields(Map<String, String> fields) {
    if (this.fields == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.labels = new TreeMap<>();
    }
    this.fields.putAll(fields);
    return this;
  }

  public ResourceList<ResourceListType, ResourceType, ResourceBuilder> withField(String key, String value) {
    if (this.fields == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.fields = new TreeMap<>();
    }
    this.fields.put(key, value);
    return this;
  }

}
