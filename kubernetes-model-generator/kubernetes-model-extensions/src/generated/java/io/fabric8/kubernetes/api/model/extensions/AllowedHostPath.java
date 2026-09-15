
package io.fabric8.kubernetes.api.model.extensions;

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
 * AllowedHostPath defines the host volume conditions that will be enabled by a policy for pods to use. It requires the path prefix to be defined. Deprecated: use AllowedHostPath from policy API Group instead.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pathPrefix",
    "readOnly"
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
public class AllowedHostPath implements Editable<AllowedHostPathBuilder>, KubernetesResource
{

    @JsonProperty("pathPrefix")
    private String pathPrefix;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AllowedHostPath() {
    }

    public AllowedHostPath(String pathPrefix, Boolean readOnly) {
        super();
        this.pathPrefix = pathPrefix;
        this.readOnly = readOnly;
    }

    /**
     * pathPrefix is the path prefix that the host volume must match. It does not support `&#42;`. Trailing slashes are trimmed when validating the path prefix with a host path.<br><p> <br><p> Examples: `/foo` would allow `/foo`, `/foo/` and `/foo/bar` `/foo` would not allow `/food` or `/etc/foo`
     */
    @JsonProperty("pathPrefix")
    public String getPathPrefix() {
        return pathPrefix;
    }

    /**
     * pathPrefix is the path prefix that the host volume must match. It does not support `&#42;`. Trailing slashes are trimmed when validating the path prefix with a host path.<br><p> <br><p> Examples: `/foo` would allow `/foo`, `/foo/` and `/foo/bar` `/foo` would not allow `/food` or `/etc/foo`
     */
    @JsonProperty("pathPrefix")
    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    /**
     * when set to true, will allow host volumes matching the pathPrefix only if all volume mounts are readOnly.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * when set to true, will allow host volumes matching the pathPrefix only if all volume mounts are readOnly.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonIgnore
    public AllowedHostPathBuilder edit() {
        return new AllowedHostPathBuilder(this);
    }

    @JsonIgnore
    public AllowedHostPathBuilder toBuilder() {
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
        if (!(o instanceof AllowedHostPath)) {
            return false;
        }
        AllowedHostPath other = (AllowedHostPath) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pathPrefix = this.getPathPrefix();
        Object other$pathPrefix = other.getPathPrefix();
        if (this$pathPrefix == null ? other$pathPrefix != null : !this$pathPrefix.equals(other$pathPrefix)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
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
        return other instanceof AllowedHostPath;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $pathPrefix = this.getPathPrefix();
        result = result * prime + ($pathPrefix == null ? 43 : $pathPrefix.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AllowedHostPath(" + "pathPrefix=" + this.getPathPrefix() + ", readOnly=" + this.getReadOnly() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
