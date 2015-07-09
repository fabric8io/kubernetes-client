package io.fabric8.kubernetes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.base.Status;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ResourceList<ResourceType extends KubernetesResource> {

    private static final ObjectMapper mapper = new ObjectMapper();

    private AsyncHttpClient httpClient;
    private URL rootUrl;
    private String resourceName;
    private Class<ResourceType> clazz;
    private Map<String, String> labels;
    private Map<String, String> fields;
    private String namespace;

    public ResourceList(AsyncHttpClient httpClient, URL rootUrl, String resourceName, Class<ResourceType> clazz) {
        this.httpClient = httpClient;
        this.rootUrl = rootUrl;
        this.resourceName = resourceName;
        this.clazz = clazz;
    }

    public ResourceList<ResourceType> withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public ResourceList<ResourceType> withLabels(Map<String, String> labels) {
        if (this.labels == null) {
            // Use treemap so labels are sorted by key - bit easier to read when debugging
            this.labels = new TreeMap<String, String>();
        }
        this.labels.putAll(labels);
        return this;
    }

    public ResourceList<ResourceType> withLabel(String key, String value) {
        if (this.labels == null) {
            // Use treemap so labels are sorted by key - bit easier to read when debugging
            this.labels = new TreeMap<String, String>();
        }
        this.labels.put(key, value);
        return this;
    }

    public ResourceList<ResourceType> withFields(Map<String, String> fields) {
        if (this.fields == null) {
            // Use treemap so labels are sorted by key - bit easier to read when debugging
            this.labels = new TreeMap<String, String>();
        }
        this.fields.putAll(fields);
        return this;
    }

    public ResourceList<ResourceType> withField(String key, String value) {
        if (this.fields == null) {
            // Use treemap so labels are sorted by key - bit easier to read when debugging
            this.fields = new TreeMap<String, String>();
        }
        this.fields.put(key, value);
        return this;
    }

    public ResourceType get() throws KubernetesClientException {
        try {
            URL requestUrl = rootUrl;
            if (namespace != null) {
                requestUrl = new URL(requestUrl, "namespaces/" + namespace + "/");
            }
            requestUrl = new URL(requestUrl, resourceName);
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
            return mapper.reader(clazz).readValue(r.getResponseBodyAsStream());
        } catch (MalformedURLException e) {
            throw new KubernetesClientException("Malformed resource URL", e);
        } catch (InterruptedException e) {
            throw new KubernetesClientException("Unable to delete resource", e);
        } catch (ExecutionException e) {
            throw new KubernetesClientException("Unable to delete resource", e);
        } catch (JsonProcessingException e) {
            throw new KubernetesClientException("Unable to delete resource", e);
        } catch (IOException e) {
            throw new KubernetesClientException("Unable to delete resource", e);
        }
    }

}
