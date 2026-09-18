
package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

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
 * EndpointsVisibility contains region mapped endpoint for a service.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "private",
    "public"
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
public class EndpointsVisibility implements Editable<EndpointsVisibilityBuilder>, KubernetesResource
{

    @JsonProperty("private")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> _private = new LinkedHashMap<>();
    @JsonProperty("public")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> _public = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EndpointsVisibility() {
    }

    public EndpointsVisibility(Map<String, String> _private, Map<String, String> _public) {
        super();
        this._private = _private;
        this._public = _public;
    }

    /**
     * Private is a string-string map of a region name to endpoint URL To prevent maintaining a list of supported regions here, we simply use a map instead of a struct
     */
    @JsonProperty("private")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPrivate() {
        return _private;
    }

    /**
     * Private is a string-string map of a region name to endpoint URL To prevent maintaining a list of supported regions here, we simply use a map instead of a struct
     */
    @JsonProperty("private")
    public void setPrivate(Map<String, String> _private) {
        this._private = _private;
    }

    /**
     * Public is a string-string map of a region name to endpoint URL To prevent maintaining a list of supported regions here, we simply use a map instead of a struct
     */
    @JsonProperty("public")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPublic() {
        return _public;
    }

    /**
     * Public is a string-string map of a region name to endpoint URL To prevent maintaining a list of supported regions here, we simply use a map instead of a struct
     */
    @JsonProperty("public")
    public void setPublic(Map<String, String> _public) {
        this._public = _public;
    }

    @JsonIgnore
    public EndpointsVisibilityBuilder edit() {
        return new EndpointsVisibilityBuilder(this);
    }

    @JsonIgnore
    public EndpointsVisibilityBuilder toBuilder() {
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
        if (!(o instanceof EndpointsVisibility)) {
            return false;
        }
        EndpointsVisibility other = (EndpointsVisibility) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_private = this.getPrivate();
        Object other$_private = other.getPrivate();
        if (this$_private == null ? other$_private != null : !this$_private.equals(other$_private)) {
            return false;
        }
        Object this$_public = this.getPublic();
        Object other$_public = other.getPublic();
        if (this$_public == null ? other$_public != null : !this$_public.equals(other$_public)) {
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
        return other instanceof EndpointsVisibility;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_private = this.getPrivate();
        result = result * prime + ($_private == null ? 43 : $_private.hashCode());
        Object $_public = this.getPublic();
        result = result * prime + ($_public == null ? 43 : $_public.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EndpointsVisibility(" + "_private=" + this.getPrivate() + ", _public=" + this.getPublic() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
