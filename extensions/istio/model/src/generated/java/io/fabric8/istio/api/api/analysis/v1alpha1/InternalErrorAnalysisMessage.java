
package io.fabric8.istio.api.api.analysis.v1alpha1;

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
 * InternalErrorAnalysisMessage is a strongly-typed message representing some error in Istio code that prevented us from performing analysis at all.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "detail",
    "messageBase"
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
public class InternalErrorAnalysisMessage implements Editable<InternalErrorAnalysisMessageBuilder>, KubernetesResource
{

    @JsonProperty("detail")
    private String detail;
    @JsonProperty("messageBase")
    private AnalysisMessageBase messageBase;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InternalErrorAnalysisMessage() {
    }

    public InternalErrorAnalysisMessage(String detail, AnalysisMessageBase messageBase) {
        super();
        this.detail = detail;
        this.messageBase = messageBase;
    }

    /**
     * Any detail regarding specifics of the error. Should be human-readable.
     */
    @JsonProperty("detail")
    public String getDetail() {
        return detail;
    }

    /**
     * Any detail regarding specifics of the error. Should be human-readable.
     */
    @JsonProperty("detail")
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * InternalErrorAnalysisMessage is a strongly-typed message representing some error in Istio code that prevented us from performing analysis at all.
     */
    @JsonProperty("messageBase")
    public AnalysisMessageBase getMessageBase() {
        return messageBase;
    }

    /**
     * InternalErrorAnalysisMessage is a strongly-typed message representing some error in Istio code that prevented us from performing analysis at all.
     */
    @JsonProperty("messageBase")
    public void setMessageBase(AnalysisMessageBase messageBase) {
        this.messageBase = messageBase;
    }

    @JsonIgnore
    public InternalErrorAnalysisMessageBuilder edit() {
        return new InternalErrorAnalysisMessageBuilder(this);
    }

    @JsonIgnore
    public InternalErrorAnalysisMessageBuilder toBuilder() {
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
        if (!(o instanceof InternalErrorAnalysisMessage)) {
            return false;
        }
        InternalErrorAnalysisMessage other = (InternalErrorAnalysisMessage) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$detail = this.getDetail();
        Object other$detail = other.getDetail();
        if (this$detail == null ? other$detail != null : !this$detail.equals(other$detail)) {
            return false;
        }
        Object this$messageBase = this.getMessageBase();
        Object other$messageBase = other.getMessageBase();
        if (this$messageBase == null ? other$messageBase != null : !this$messageBase.equals(other$messageBase)) {
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
        return other instanceof InternalErrorAnalysisMessage;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $detail = this.getDetail();
        result = result * prime + ($detail == null ? 43 : $detail.hashCode());
        Object $messageBase = this.getMessageBase();
        result = result * prime + ($messageBase == null ? 43 : $messageBase.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InternalErrorAnalysisMessage(" + "detail=" + this.getDetail() + ", messageBase=" + this.getMessageBase() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
