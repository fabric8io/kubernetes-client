
package io.fabric8.kubernetes.api.model.discovery.v1beta1;

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
 * EndpointConditions represents the current condition of an endpoint.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ready",
    "serving",
    "terminating"
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
public class EndpointConditions implements Editable<EndpointConditionsBuilder>, KubernetesResource
{

    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("serving")
    private Boolean serving;
    @JsonProperty("terminating")
    private Boolean terminating;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EndpointConditions() {
    }

    public EndpointConditions(Boolean ready, Boolean serving, Boolean terminating) {
        super();
        this.ready = ready;
        this.serving = serving;
        this.terminating = terminating;
    }

    /**
     * ready indicates that this endpoint is prepared to receive traffic, according to whatever system is managing the endpoint. A nil value indicates an unknown state. In most cases consumers should interpret this unknown state as ready. For compatibility reasons, ready should never be "true" for terminating endpoints.
     */
    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    /**
     * ready indicates that this endpoint is prepared to receive traffic, according to whatever system is managing the endpoint. A nil value indicates an unknown state. In most cases consumers should interpret this unknown state as ready. For compatibility reasons, ready should never be "true" for terminating endpoints.
     */
    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    /**
     * serving is identical to ready except that it is set regardless of the terminating state of endpoints. This condition should be set to true for a ready endpoint that is terminating. If nil, consumers should defer to the ready condition. This field can be enabled with the EndpointSliceTerminatingCondition feature gate.
     */
    @JsonProperty("serving")
    public Boolean getServing() {
        return serving;
    }

    /**
     * serving is identical to ready except that it is set regardless of the terminating state of endpoints. This condition should be set to true for a ready endpoint that is terminating. If nil, consumers should defer to the ready condition. This field can be enabled with the EndpointSliceTerminatingCondition feature gate.
     */
    @JsonProperty("serving")
    public void setServing(Boolean serving) {
        this.serving = serving;
    }

    /**
     * terminating indicates that this endpoint is terminating. A nil value indicates an unknown state. Consumers should interpret this unknown state to mean that the endpoint is not terminating. This field can be enabled with the EndpointSliceTerminatingCondition feature gate.
     */
    @JsonProperty("terminating")
    public Boolean getTerminating() {
        return terminating;
    }

    /**
     * terminating indicates that this endpoint is terminating. A nil value indicates an unknown state. Consumers should interpret this unknown state to mean that the endpoint is not terminating. This field can be enabled with the EndpointSliceTerminatingCondition feature gate.
     */
    @JsonProperty("terminating")
    public void setTerminating(Boolean terminating) {
        this.terminating = terminating;
    }

    @JsonIgnore
    public EndpointConditionsBuilder edit() {
        return new EndpointConditionsBuilder(this);
    }

    @JsonIgnore
    public EndpointConditionsBuilder toBuilder() {
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
        if (!(o instanceof EndpointConditions)) {
            return false;
        }
        EndpointConditions other = (EndpointConditions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ready = this.getReady();
        Object other$ready = other.getReady();
        if (this$ready == null ? other$ready != null : !this$ready.equals(other$ready)) {
            return false;
        }
        Object this$serving = this.getServing();
        Object other$serving = other.getServing();
        if (this$serving == null ? other$serving != null : !this$serving.equals(other$serving)) {
            return false;
        }
        Object this$terminating = this.getTerminating();
        Object other$terminating = other.getTerminating();
        if (this$terminating == null ? other$terminating != null : !this$terminating.equals(other$terminating)) {
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
        return other instanceof EndpointConditions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ready = this.getReady();
        result = result * prime + ($ready == null ? 43 : $ready.hashCode());
        Object $serving = this.getServing();
        result = result * prime + ($serving == null ? 43 : $serving.hashCode());
        Object $terminating = this.getTerminating();
        result = result * prime + ($terminating == null ? 43 : $terminating.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EndpointConditions(" + "ready=" + this.getReady() + ", serving=" + this.getServing() + ", terminating=" + this.getTerminating() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
