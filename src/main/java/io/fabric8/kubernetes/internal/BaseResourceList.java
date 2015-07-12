package io.fabric8.kubernetes.internal;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.KubernetesClientException;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.base.Status;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public abstract class BaseResourceList<Type extends HasMetadata, TypeList extends KubernetesResourceList, TypeBuilder extends Builder<Type>>
  extends BaseResource<Type, TypeBuilder> {

  private Class<TypeList> listClazz;

  private Map<String, String> labels = new TreeMap<>();
  private Map<String, String> fields = new TreeMap<>();

  protected BaseResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<Type> clazz, Class<TypeList> listClazz, Class<TypeBuilder> builderClazz) {
    super(httpClient, rootUrl, resourceType, clazz, builderClazz);
    this.listClazz = listClazz;
  }

  protected Map<String, String> getFields() {
    return fields;
  }

  protected Map<String, String> getLabels() {
    return labels;
  }

  protected Class<TypeList> getListClazz() {
    return listClazz;
  }

  public TypeList list() throws KubernetesClientException {
    try {
      URL requestUrl = getRootUrl();
      if (getNamespace() != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + getNamespace() + "/");
      }
      requestUrl = new URL(requestUrl, getResourceType());
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
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException e) {
      throw new KubernetesClientException("Unable to delete resource", e);
    }
  }

  public void delete() throws KubernetesClientException {
    try {
      TypeList discoveredResources = list();

      for (Object resource : discoveredResources.getItems()) {
        // Dirty cast but should always be valid...
        HasMetadata metadataResource = (HasMetadata) resource;

        URL requestUrl = getRootUrl();
        if (metadataResource.getMetadata().getNamespace() != null) {
          requestUrl = new URL(requestUrl, "namespaces/" + metadataResource.getMetadata().getNamespace() + "/");
        }
        requestUrl = new URL(requestUrl, getResourceType() + "/" + metadataResource.getMetadata().getName());
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

}
