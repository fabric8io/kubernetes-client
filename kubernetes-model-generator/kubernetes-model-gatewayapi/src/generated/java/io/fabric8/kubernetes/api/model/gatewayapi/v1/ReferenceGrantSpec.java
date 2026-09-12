
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
 * ReferenceGrantSpec identifies a cross namespace relationship that is trusted for Gateway API.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "to"
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
public class ReferenceGrantSpec implements Editable<ReferenceGrantSpecBuilder>, KubernetesResource
{

    @JsonProperty("from")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReferenceGrantFrom> from = new ArrayList<>();
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReferenceGrantTo> to = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ReferenceGrantSpec() {
    }

    public ReferenceGrantSpec(List<ReferenceGrantFrom> from, List<ReferenceGrantTo> to) {
        super();
        this.from = from;
        this.to = to;
    }

    /**
     * From describes the trusted namespaces and kinds that can reference the resources described in "To". Each entry in this list MUST be considered to be an additional place that references can be valid from, or to put this another way, entries MUST be combined using OR.<br><p> <br><p> Support: Core
     */
    @JsonProperty("from")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ReferenceGrantFrom> getFrom() {
        return from;
    }

    /**
     * From describes the trusted namespaces and kinds that can reference the resources described in "To". Each entry in this list MUST be considered to be an additional place that references can be valid from, or to put this another way, entries MUST be combined using OR.<br><p> <br><p> Support: Core
     */
    @JsonProperty("from")
    public void setFrom(List<ReferenceGrantFrom> from) {
        this.from = from;
    }

    /**
     * To describes the resources that may be referenced by the resources described in "From". Each entry in this list MUST be considered to be an additional place that references can be valid to, or to put this another way, entries MUST be combined using OR.<br><p> <br><p> Support: Core
     */
    @JsonProperty("to")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ReferenceGrantTo> getTo() {
        return to;
    }

    /**
     * To describes the resources that may be referenced by the resources described in "From". Each entry in this list MUST be considered to be an additional place that references can be valid to, or to put this another way, entries MUST be combined using OR.<br><p> <br><p> Support: Core
     */
    @JsonProperty("to")
    public void setTo(List<ReferenceGrantTo> to) {
        this.to = to;
    }

    @JsonIgnore
    public ReferenceGrantSpecBuilder edit() {
        return new ReferenceGrantSpecBuilder(this);
    }

    @JsonIgnore
    public ReferenceGrantSpecBuilder toBuilder() {
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
        if (!(o instanceof ReferenceGrantSpec)) {
            return false;
        }
        ReferenceGrantSpec other = (ReferenceGrantSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$to = this.getTo();
        Object other$to = other.getTo();
        if (this$to == null ? other$to != null : !this$to.equals(other$to)) {
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
        return other instanceof ReferenceGrantSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $to = this.getTo();
        result = result * prime + ($to == null ? 43 : $to.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReferenceGrantSpec(" + "from=" + this.getFrom() + ", to=" + this.getTo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
