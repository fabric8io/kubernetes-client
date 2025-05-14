
package io.fabric8.kubernetes.api.model.networking.v1;

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
 * HTTPIngressPath associates a path with a backend. Incoming urls matching the path are forwarded to the backend.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backend",
    "path",
    "pathType"
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
public class HTTPIngressPath implements Editable<HTTPIngressPathBuilder>, KubernetesResource
{

    @JsonProperty("backend")
    private IngressBackend backend;
    @JsonProperty("path")
    private String path;
    @JsonProperty("pathType")
    private String pathType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPIngressPath() {
    }

    public HTTPIngressPath(IngressBackend backend, String path, String pathType) {
        super();
        this.backend = backend;
        this.path = path;
        this.pathType = pathType;
    }

    /**
     * HTTPIngressPath associates a path with a backend. Incoming urls matching the path are forwarded to the backend.
     */
    @JsonProperty("backend")
    public IngressBackend getBackend() {
        return backend;
    }

    /**
     * HTTPIngressPath associates a path with a backend. Incoming urls matching the path are forwarded to the backend.
     */
    @JsonProperty("backend")
    public void setBackend(IngressBackend backend) {
        this.backend = backend;
    }

    /**
     * path is matched against the path of an incoming request. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/' and must be present when using PathType with value "Exact" or "Prefix".
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path is matched against the path of an incoming request. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/' and must be present when using PathType with value "Exact" or "Prefix".
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * pathType determines the interpretation of the path matching. PathType can be one of the following values: &#42; Exact: Matches the URL path exactly. &#42; Prefix: Matches based on a URL path prefix split by '/'. Matching is<br><p>   done on a path element by element basis. A path element refers is the<br><p>   list of labels in the path split by the '/' separator. A request is a<br><p>   match for path p if every p is an element-wise prefix of p of the<br><p>   request path. Note that if the last element of the path is a substring<br><p>   of the last element in request path, it is not a match (e.g. /foo/bar<br><p>   matches /foo/bar/baz, but does not match /foo/barbaz).<br><p> &#42; ImplementationSpecific: Interpretation of the Path matching is up to<br><p>   the IngressClass. Implementations can treat this as a separate PathType<br><p>   or treat it identically to Prefix or Exact path types.<br><p> Implementations are required to support all path types.
     */
    @JsonProperty("pathType")
    public String getPathType() {
        return pathType;
    }

    /**
     * pathType determines the interpretation of the path matching. PathType can be one of the following values: &#42; Exact: Matches the URL path exactly. &#42; Prefix: Matches based on a URL path prefix split by '/'. Matching is<br><p>   done on a path element by element basis. A path element refers is the<br><p>   list of labels in the path split by the '/' separator. A request is a<br><p>   match for path p if every p is an element-wise prefix of p of the<br><p>   request path. Note that if the last element of the path is a substring<br><p>   of the last element in request path, it is not a match (e.g. /foo/bar<br><p>   matches /foo/bar/baz, but does not match /foo/barbaz).<br><p> &#42; ImplementationSpecific: Interpretation of the Path matching is up to<br><p>   the IngressClass. Implementations can treat this as a separate PathType<br><p>   or treat it identically to Prefix or Exact path types.<br><p> Implementations are required to support all path types.
     */
    @JsonProperty("pathType")
    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    @JsonIgnore
    public HTTPIngressPathBuilder edit() {
        return new HTTPIngressPathBuilder(this);
    }

    @JsonIgnore
    public HTTPIngressPathBuilder toBuilder() {
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
