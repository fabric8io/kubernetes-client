package io.fabric8.kubernetes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.common.Builder;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.base.Status;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Resource<ResourceListType extends KubernetesResource, ResourceType extends HasMetadata, ResourceBuilder extends Builder<ResourceType>> {

  private static final ObjectMapper mapper = new ObjectMapper();

  private AsyncHttpClient httpClient;
  private URL rootUrl;
  private String resourceType;
  private Class<ResourceListType> listClazz;
  private Class<ResourceType> clazz;
  private Class<ResourceBuilder> clazzBuilder;
  private Map<String, String> labels;
  private Map<String, String> fields;
  private String namespace;

  public Resource(AsyncHttpClient httpClient, URL rootUrl, String resourceType, Class<ResourceListType> listClazz, Class<ResourceType> clazz, Class<ResourceBuilder> clazzBuilder) {
    this.httpClient = httpClient;
    this.rootUrl = rootUrl;
    this.resourceType = resourceType;
    this.listClazz = listClazz;
    this.clazzBuilder = clazzBuilder;
    this.clazz = clazz;
  }

  public Resource<ResourceListType, ResourceType, ResourceBuilder> inNamespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

  public Resource<ResourceListType, ResourceType, ResourceBuilder> withLabels(Map<String, String> labels) {
    if (this.labels == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.labels = new TreeMap<>();
    }
    this.labels.putAll(labels);
    return this;
  }

  public Resource<ResourceListType, ResourceType, ResourceBuilder> withLabel(String key, String value) {
    if (this.labels == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.labels = new TreeMap<>();
    }
    this.labels.put(key, value);
    return this;
  }

  public Resource<ResourceListType, ResourceType, ResourceBuilder> withFields(Map<String, String> fields) {
    if (this.fields == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.labels = new TreeMap<>();
    }
    this.fields.putAll(fields);
    return this;
  }

  public Resource<ResourceListType, ResourceType, ResourceBuilder> withField(String key, String value) {
    if (this.fields == null) {
      // Use treemap so labels are sorted by key - bit easier to read when debugging
      this.fields = new TreeMap<>();
    }
    this.fields.put(key, value);
    return this;
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

  public ResourceType create(ResourceType resource) throws KubernetesClientException {
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
      throw new KubernetesClientException("Unable to create resource", e);
    }
  }

  public ResourceType get(String resourceName) throws KubernetesClientException {
    try {
      URL requestUrl = rootUrl;
      if (namespace != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
      }
      requestUrl = new URL(requestUrl, resourceType + "/" + resourceName);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.prepareGet(requestUrl.toString());
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

  public ResourceListType delete(String resourceName) throws KubernetesClientException {
    try {
      URL requestUrl = rootUrl;
      if (namespace != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
      }
      requestUrl = new URL(requestUrl, resourceType + "/" + resourceName);
      AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.prepareDelete(requestUrl.toString());
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
      throw new KubernetesClientException("Unable to delete resource", e);
    }
  }

  public ResourceType update(String resourceName, BuilderUpdate<ResourceType, ResourceBuilder> builder) throws KubernetesClientException {
    try {
      URL requestUrl = rootUrl;
      if (namespace != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
      }
      requestUrl = new URL(requestUrl, resourceType + "/" + resourceName);

      ResourceType current = this.get(resourceName);
      ResourceType updated = builder.update(clazzBuilder.getDeclaredConstructor(clazz).newInstance(current));

      AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.preparePut(requestUrl.toString());
      requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
      Future<Response> f = requestBuilder.execute();
      Response r = f.get();
      if (r.getStatusCode() != 200) {
        Status status = mapper.reader(Status.class).readValue(r.getResponseBodyAsStream());
        throw new KubernetesClientException(status.getMessage(), status.getCode(), status);
      }
      return mapper.reader(clazz).readValue(r.getResponseBodyAsStream());
    } catch (MalformedURLException e) {
      throw new KubernetesClientException("Malformed resource URL", e);
    } catch (InterruptedException | ExecutionException | IOException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
      throw new KubernetesClientException("Unable to update resource", e);
    }
  }

  public ResourceListType update(String resourceName, Update<ResourceType> resourceUpdate) throws KubernetesClientException {
    try {
      URL requestUrl = rootUrl;
      if (namespace != null) {
        requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
      }
      requestUrl = new URL(requestUrl, resourceType + "/" + resourceName);

      ResourceType current = this.get(resourceName);
      ResourceType updated = resourceUpdate.update(current);

      AsyncHttpClient.BoundRequestBuilder requestBuilder = httpClient.preparePut(requestUrl.toString());
      requestBuilder.setBody(mapper.writer().writeValueAsString(updated));
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
