
package io.fabric8.tekton.triggers.v1alpha1;

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
 * Do not generate Deepcopy(). See #827
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "continue",
    "extensions",
    "status"
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
public class InterceptorResponse implements Editable<InterceptorResponseBuilder>, KubernetesResource
{

    @JsonProperty("continue")
    private Boolean _continue;
    @JsonProperty("extensions")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> extensions = new LinkedHashMap<>();
    @JsonProperty("status")
    private Status status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InterceptorResponse() {
    }

    public InterceptorResponse(Boolean _continue, Map<String, Object> extensions, Status status) {
        super();
        this._continue = _continue;
        this.extensions = extensions;
        this.status = status;
    }

    /**
     * Continue indicates if the EventListener should continue processing the Trigger or not
     */
    @JsonProperty("continue")
    public Boolean getContinue() {
        return _continue;
    }

    /**
     * Continue indicates if the EventListener should continue processing the Trigger or not
     */
    @JsonProperty("continue")
    public void setContinue(Boolean _continue) {
        this._continue = _continue;
    }

    /**
     * Extensions are additional fields that is added to the interceptor event.
     */
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    /**
     * Extensions are additional fields that is added to the interceptor event.
     */
    @JsonProperty("extensions")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    /**
     * Do not generate Deepcopy(). See #827
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * Do not generate Deepcopy(). See #827
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonIgnore
    public InterceptorResponseBuilder edit() {
        return new InterceptorResponseBuilder(this);
    }

    @JsonIgnore
    public InterceptorResponseBuilder toBuilder() {
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
        if (!(o instanceof InterceptorResponse)) {
            return false;
        }
        InterceptorResponse other = (InterceptorResponse) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_continue = this.getContinue();
        Object other$_continue = other.getContinue();
        if (this$_continue == null ? other$_continue != null : !this$_continue.equals(other$_continue)) {
            return false;
        }
        Object this$extensions = this.getExtensions();
        Object other$extensions = other.getExtensions();
        if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof InterceptorResponse;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_continue = this.getContinue();
        result = result * prime + ($_continue == null ? 43 : $_continue.hashCode());
        Object $extensions = this.getExtensions();
        result = result * prime + ($extensions == null ? 43 : $extensions.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InterceptorResponse(" + "_continue=" + this.getContinue() + ", extensions=" + this.getExtensions() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
