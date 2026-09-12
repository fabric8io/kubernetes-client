
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "body",
    "criteria",
    "headers",
    "method",
    "url"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HTTPStatusCheck implements Editable<HTTPStatusCheckBuilder>, KubernetesResource
{

    @JsonProperty("body")
    private String body;
    @JsonProperty("criteria")
    private HTTPCriteria criteria;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> headers = new LinkedHashMap<>();
    @JsonProperty("method")
    private String method;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPStatusCheck() {
    }

    public HTTPStatusCheck(String body, HTTPCriteria criteria, Map<String, List<String>> headers, String method, String url) {
        super();
        this.body = body;
        this.criteria = criteria;
        this.headers = headers;
        this.method = method;
        this.url = url;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("criteria")
    public HTTPCriteria getCriteria() {
        return criteria;
    }

    @JsonProperty("criteria")
    public void setCriteria(HTTPCriteria criteria) {
        this.criteria = criteria;
    }

    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public HTTPStatusCheckBuilder edit() {
        return new HTTPStatusCheckBuilder(this);
    }

    @JsonIgnore
    public HTTPStatusCheckBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HTTPStatusCheck)) {
            return false;
        }
        HTTPStatusCheck other = (HTTPStatusCheck) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$body = this.getBody();
        Object other$body = other.getBody();
        if (this$body == null ? other$body != null : !this$body.equals(other$body)) {
            return false;
        }
        Object this$criteria = this.getCriteria();
        Object other$criteria = other.getCriteria();
        if (this$criteria == null ? other$criteria != null : !this$criteria.equals(other$criteria)) {
            return false;
        }
        Object this$headers = this.getHeaders();
        Object other$headers = other.getHeaders();
        if (this$headers == null ? other$headers != null : !this$headers.equals(other$headers)) {
            return false;
        }
        Object this$method = this.getMethod();
        Object other$method = other.getMethod();
        if (this$method == null ? other$method != null : !this$method.equals(other$method)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof HTTPStatusCheck;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $body = this.getBody();
        result = result * prime + ($body == null ? 43 : $body.hashCode());
        Object $criteria = this.getCriteria();
        result = result * prime + ($criteria == null ? 43 : $criteria.hashCode());
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPStatusCheck(" + "body=" + this.getBody() + ", criteria=" + this.getCriteria() + ", headers=" + this.getHeaders() + ", method=" + this.getMethod() + ", url=" + this.getUrl() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
