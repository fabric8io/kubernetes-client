
package io.fabric8.knative.eventing.v1alpha1;

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
 * ReplySpec is the configurations on how to handle responses from Sink.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "discard",
    "jsonata"
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
public class ReplySpec implements Editable<ReplySpecBuilder>, KubernetesResource
{

    @JsonProperty("discard")
    private Boolean discard;
    @JsonProperty("jsonata")
    private JsonataEventTransformationSpec jsonata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ReplySpec() {
    }

    public ReplySpec(Boolean discard, JsonataEventTransformationSpec jsonata) {
        super();
        this.discard = discard;
        this.jsonata = jsonata;
    }

    /**
     * Discard discards responses from Sink and return empty response body.<br><p> <br><p> When set to false, it returns the exact sink response body. When set to true, Discard is mutually exclusive with EventTransformations in the reply section, it can either be discarded or transformed.<br><p> <br><p> Default: false.
     */
    @JsonProperty("discard")
    public Boolean getDiscard() {
        return discard;
    }

    /**
     * Discard discards responses from Sink and return empty response body.<br><p> <br><p> When set to false, it returns the exact sink response body. When set to true, Discard is mutually exclusive with EventTransformations in the reply section, it can either be discarded or transformed.<br><p> <br><p> Default: false.
     */
    @JsonProperty("discard")
    public void setDiscard(Boolean discard) {
        this.discard = discard;
    }

    /**
     * ReplySpec is the configurations on how to handle responses from Sink.
     */
    @JsonProperty("jsonata")
    public JsonataEventTransformationSpec getJsonata() {
        return jsonata;
    }

    /**
     * ReplySpec is the configurations on how to handle responses from Sink.
     */
    @JsonProperty("jsonata")
    public void setJsonata(JsonataEventTransformationSpec jsonata) {
        this.jsonata = jsonata;
    }

    @JsonIgnore
    public ReplySpecBuilder edit() {
        return new ReplySpecBuilder(this);
    }

    @JsonIgnore
    public ReplySpecBuilder toBuilder() {
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
        if (!(o instanceof ReplySpec)) {
            return false;
        }
        ReplySpec other = (ReplySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$discard = this.getDiscard();
        Object other$discard = other.getDiscard();
        if (this$discard == null ? other$discard != null : !this$discard.equals(other$discard)) {
            return false;
        }
        Object this$jsonata = this.getJsonata();
        Object other$jsonata = other.getJsonata();
        if (this$jsonata == null ? other$jsonata != null : !this$jsonata.equals(other$jsonata)) {
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
        return other instanceof ReplySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $discard = this.getDiscard();
        result = result * prime + ($discard == null ? 43 : $discard.hashCode());
        Object $jsonata = this.getJsonata();
        result = result * prime + ($jsonata == null ? 43 : $jsonata.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReplySpec(" + "discard=" + this.getDiscard() + ", jsonata=" + this.getJsonata() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
