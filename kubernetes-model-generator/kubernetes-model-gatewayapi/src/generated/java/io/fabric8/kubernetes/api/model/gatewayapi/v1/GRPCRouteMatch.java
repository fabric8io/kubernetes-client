
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import java.util.ArrayList;
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GRPCRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.<br><p> <br><p> For example, the match below will match a gRPC request only if its service is `foo` AND it contains the `version: v1` header:<br><p> <br><p> ``` matches:<br><p>   - method:<br><p>     type: Exact<br><p>     service: "foo"<br><p>   - headers:<br><p>     name: "version"<br><p>     value "v1"<br><p> <br><p> ```
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "headers",
    "method"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GRPCRouteMatch implements Editable<GRPCRouteMatchBuilder>, KubernetesResource
{

    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GRPCHeaderMatch> headers = new ArrayList<>();
    @JsonProperty("method")
    private GRPCMethodMatch method;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GRPCRouteMatch() {
    }

    public GRPCRouteMatch(List<GRPCHeaderMatch> headers, GRPCMethodMatch method) {
        super();
        this.headers = headers;
        this.method = method;
    }

    /**
     * Headers specifies gRPC request header matchers. Multiple match values are ANDed together, meaning, a request MUST match all the specified headers to select the route.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GRPCHeaderMatch> getHeaders() {
        return headers;
    }

    /**
     * Headers specifies gRPC request header matchers. Multiple match values are ANDed together, meaning, a request MUST match all the specified headers to select the route.
     */
    @JsonProperty("headers")
    public void setHeaders(List<GRPCHeaderMatch> headers) {
        this.headers = headers;
    }

    /**
     * GRPCRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.<br><p> <br><p> For example, the match below will match a gRPC request only if its service is `foo` AND it contains the `version: v1` header:<br><p> <br><p> ``` matches:<br><p>   - method:<br><p>     type: Exact<br><p>     service: "foo"<br><p>   - headers:<br><p>     name: "version"<br><p>     value "v1"<br><p> <br><p> ```
     */
    @JsonProperty("method")
    public GRPCMethodMatch getMethod() {
        return method;
    }

    /**
     * GRPCRouteMatch defines the predicate used to match requests to a given action. Multiple match types are ANDed together, i.e. the match will evaluate to true only if all conditions are satisfied.<br><p> <br><p> For example, the match below will match a gRPC request only if its service is `foo` AND it contains the `version: v1` header:<br><p> <br><p> ``` matches:<br><p>   - method:<br><p>     type: Exact<br><p>     service: "foo"<br><p>   - headers:<br><p>     name: "version"<br><p>     value "v1"<br><p> <br><p> ```
     */
    @JsonProperty("method")
    public void setMethod(GRPCMethodMatch method) {
        this.method = method;
    }

    @JsonIgnore
    public GRPCRouteMatchBuilder edit() {
        return new GRPCRouteMatchBuilder(this);
    }

    @JsonIgnore
    public GRPCRouteMatchBuilder toBuilder() {
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
        if (!(o instanceof GRPCRouteMatch)) {
            return false;
        }
        GRPCRouteMatch other = (GRPCRouteMatch) o;
        if (!other.canEqual(this)) {
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
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof GRPCRouteMatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
        Object $method = this.getMethod();
        result = result * prime + ($method == null ? 43 : $method.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GRPCRouteMatch(" + "headers=" + this.getHeaders() + ", method=" + this.getMethod() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
