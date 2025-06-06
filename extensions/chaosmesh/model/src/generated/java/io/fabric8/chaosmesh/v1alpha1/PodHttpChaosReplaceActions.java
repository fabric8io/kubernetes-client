
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodHttpChaosReplaceActions defines possible replace-actions of HttpChaos.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "body",
    "code",
    "headers",
    "method",
    "path",
    "queries"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class PodHttpChaosReplaceActions implements Editable<PodHttpChaosReplaceActionsBuilder>, KubernetesResource
{

    @JsonProperty("body")
    private String body;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> headers = new LinkedHashMap<>();
    @JsonProperty("method")
    private String method;
    @JsonProperty("path")
    private String path;
    @JsonProperty("queries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> queries = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodHttpChaosReplaceActions() {
    }

    public PodHttpChaosReplaceActions(String body, Integer code, Map<String, String> headers, String method, String path, Map<String, String> queries) {
        super();
        this.body = body;
        this.code = code;
        this.headers = headers;
        this.method = method;
        this.path = path;
        this.queries = queries;
    }

    /**
     * Body is a rule to replace http message body in target.
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * Body is a rule to replace http message body in target.
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Code is a rule to replace http status code in response.
     */
    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    /**
     * Code is a rule to replace http status code in response.
     */
    @JsonProperty("code")
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * Headers is a rule to replace http headers of target. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Headers is a rule to replace http headers of target. The key-value pairs represent header name and header value pairs.
     */
    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Method is a rule to replace http method in request.
     */
    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    /**
     * Method is a rule to replace http method in request.
     */
    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Path is rule to to replace uri path in http request.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path is rule to to replace uri path in http request.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Queries is a rule to replace uri queries in http request. For example, with value `{ "foo": "unknown" }`, the `/?foo=bar` will be altered to `/?foo=unknown`,
     */
    @JsonProperty("queries")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getQueries() {
        return queries;
    }

    /**
     * Queries is a rule to replace uri queries in http request. For example, with value `{ "foo": "unknown" }`, the `/?foo=bar` will be altered to `/?foo=unknown`,
     */
    @JsonProperty("queries")
    public void setQueries(Map<String, String> queries) {
        this.queries = queries;
    }

    @JsonIgnore
    public PodHttpChaosReplaceActionsBuilder edit() {
        return new PodHttpChaosReplaceActionsBuilder(this);
    }

    @JsonIgnore
    public PodHttpChaosReplaceActionsBuilder toBuilder() {
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

}
