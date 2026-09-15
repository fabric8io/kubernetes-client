
package io.fabric8.kubernetes.api.model.networking.v1beta1;

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
     * Path is matched against the path of an incoming request. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. When unspecified, all paths from incoming requests are matched.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path is matched against the path of an incoming request. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. When unspecified, all paths from incoming requests are matched.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * PathType determines the interpretation of the Path matching. PathType can be one of the following values: &#42; Exact: Matches the URL path exactly. &#42; Prefix: Matches based on a URL path prefix split by '/'. Matching is<br><p>   done on a path element by element basis. A path element refers is the<br><p>   list of labels in the path split by the '/' separator. A request is a<br><p>   match for path p if every p is an element-wise prefix of p of the<br><p>   request path. Note that if the last element of the path is a substring<br><p>   of the last element in request path, it is not a match (e.g. /foo/bar<br><p>   matches /foo/bar/baz, but does not match /foo/barbaz).<br><p> &#42; ImplementationSpecific: Interpretation of the Path matching is up to<br><p>   the IngressClass. Implementations can treat this as a separate PathType<br><p>   or treat it identically to Prefix or Exact path types.<br><p> Implementations are required to support all path types. Defaults to ImplementationSpecific.
     */
    @JsonProperty("pathType")
    public String getPathType() {
        return pathType;
    }

    /**
     * PathType determines the interpretation of the Path matching. PathType can be one of the following values: &#42; Exact: Matches the URL path exactly. &#42; Prefix: Matches based on a URL path prefix split by '/'. Matching is<br><p>   done on a path element by element basis. A path element refers is the<br><p>   list of labels in the path split by the '/' separator. A request is a<br><p>   match for path p if every p is an element-wise prefix of p of the<br><p>   request path. Note that if the last element of the path is a substring<br><p>   of the last element in request path, it is not a match (e.g. /foo/bar<br><p>   matches /foo/bar/baz, but does not match /foo/barbaz).<br><p> &#42; ImplementationSpecific: Interpretation of the Path matching is up to<br><p>   the IngressClass. Implementations can treat this as a separate PathType<br><p>   or treat it identically to Prefix or Exact path types.<br><p> Implementations are required to support all path types. Defaults to ImplementationSpecific.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HTTPIngressPath)) {
            return false;
        }
        HTTPIngressPath other = (HTTPIngressPath) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$backend = this.getBackend();
        Object other$backend = other.getBackend();
        if (this$backend == null ? other$backend != null : !this$backend.equals(other$backend)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$pathType = this.getPathType();
        Object other$pathType = other.getPathType();
        if (this$pathType == null ? other$pathType != null : !this$pathType.equals(other$pathType)) {
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
        return other instanceof HTTPIngressPath;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $backend = this.getBackend();
        result = result * prime + ($backend == null ? 43 : $backend.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $pathType = this.getPathType();
        result = result * prime + ($pathType == null ? 43 : $pathType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPIngressPath(" + "backend=" + this.getBackend() + ", path=" + this.getPath() + ", pathType=" + this.getPathType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
