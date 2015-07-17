package io.fabric8.kubernetes.client.internal;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import com.ning.http.client.ws.DefaultWebSocketListener;
import com.ning.http.client.ws.WebSocket;
import com.ning.http.client.ws.WebSocketUpgradeHandler;
import io.fabric8.kubernetes.api.builder.Builder;
import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.WatchEvent;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
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

public abstract class BaseResourceList<T extends HasMetadata, L extends KubernetesResourceList, B extends Builder<T>, D extends Doneable<T>>
  extends BaseResource<T, B, D> {

  private Class<L> listClazz;

  private Map<String, String> labels = new TreeMap<>();
  private Map<String, String> fields = new TreeMap<>();

  protected BaseResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceT, Class<T> clazz, Class<L> listClazz, Class<B> builderClazz, Class<D> updateableClazz) {
    super(httpClient, rootUrl, resourceT, clazz, builderClazz, updateableClazz);
    this.listClazz = listClazz;
  }

  protected Map<String, String> getFields() {
    return fields;
  }

  protected Map<String, String> getLabels() {
    return labels;
  }

  protected Class<L> getListClazz() {
    return listClazz;
  }

  public L list() throws KubernetesClientException {
    try {
      URL requestUrl = getNamespacedUrl();
      AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareGet(requestUrl.toString());
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
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to delete resource", e);
    }
  }

  public void delete() throws KubernetesClientException {
    try {
      L discoveredResources = list();

      for (Object resource : discoveredResources.getItems()) {
        // Dirty cast but should always be valid...
        HasMetadata metadataResource = (HasMetadata) resource;

        URL requestUrl = getRootUrl();
        if (metadataResource.getMetadata().getNamespace() != null) {
          requestUrl = new URL(requestUrl, "namespaces/" + metadataResource.getMetadata().getNamespace() + "/");
        }
        requestUrl = new URL(requestUrl, getResourceT() + "/" + metadataResource.getMetadata().getName());
        AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareDelete(requestUrl.toString());
        Future<Response> f = requestBuilder.execute();
        Response r = f.get();
        if (r.getStatusCode() != 200) {
          Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
          throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
        }
      }
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to delete resources", e);
    }
  }

    public WebSocket watch(final Watcher<T> watcher) throws KubernetesClientException {
      try {
        URL requestUrl = getNamespacedUrl();
        AsyncHttpClient.BoundRequestBuilder requestBuilder = getHttpClient().prepareGet(requestUrl.toString().replaceFirst("^http", "ws"));
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
                  T obj = (T) event.getObject();
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

}
