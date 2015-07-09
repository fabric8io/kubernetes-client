package io.fabric8.kubernetes;

import com.fasterxml.jackson.core.JsonProcessingException;
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

public class Resource<ResourceType extends HasMetadata> {

    private static final ObjectMapper mapper = new ObjectMapper();

    private AsyncHttpClient httpClient;
    private URL rootUrl;
    private String resourceType;
    private String resourceName;
    private Class<ResourceType> clazz;
    private String namespace;

    public Resource(AsyncHttpClient httpClient, URL rootUrl, String resourceType, String resourceName, Class<ResourceType> clazz) {
        this.httpClient = httpClient;
        this.rootUrl = rootUrl;
        this.resourceType = resourceType;
        this.resourceName = resourceName;
        this.clazz = clazz;
    }

    public Resource<ResourceType> withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public ResourceType get() throws KubernetesClientException {
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

    public ResourceType delete() throws KubernetesClientException {
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
