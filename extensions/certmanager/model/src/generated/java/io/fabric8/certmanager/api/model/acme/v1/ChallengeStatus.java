
package io.fabric8.certmanager.api.model.acme.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "presented",
    "presentedAt",
    "processing",
    "reason",
    "state"
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
public class ChallengeStatus implements Editable<ChallengeStatusBuilder>, KubernetesResource
{

    @JsonProperty("presented")
    private Boolean presented;
    @JsonProperty("presentedAt")
    private String presentedAt;
    @JsonProperty("processing")
    private Boolean processing;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ChallengeStatus() {
    }

    public ChallengeStatus(Boolean presented, String presentedAt, Boolean processing, String reason, String state) {
        super();
        this.presented = presented;
        this.presentedAt = presentedAt;
        this.processing = processing;
        this.reason = reason;
        this.state = state;
    }

    /**
     * Presented is true once cert-manager has configured the solver resources needed to expose this challenge's validation material. For example, the DNS01 TXT record has been created, or the HTTP01 solver has been configured to serve the challenge token. This does not imply the self check is passing, that the ACME server has validated the challenge, or that cert-manager has already accepted the challenge with the ACME server.
     */
    @JsonProperty("presented")
    public Boolean getPresented() {
        return presented;
    }

    /**
     * Presented is true once cert-manager has configured the solver resources needed to expose this challenge's validation material. For example, the DNS01 TXT record has been created, or the HTTP01 solver has been configured to serve the challenge token. This does not imply the self check is passing, that the ACME server has validated the challenge, or that cert-manager has already accepted the challenge with the ACME server.
     */
    @JsonProperty("presented")
    public void setPresented(Boolean presented) {
        this.presented = presented;
    }

    @JsonProperty("presentedAt")
    public String getPresentedAt() {
        return presentedAt;
    }

    @JsonProperty("presentedAt")
    public void setPresentedAt(String presentedAt) {
        this.presentedAt = presentedAt;
    }

    /**
     * Used to denote whether this challenge should be processed or not. This field will only be set to true by the 'scheduling' component. It will only be set to false by the 'challenges' controller, after the challenge has reached a final state or timed out. If this field is set to false, the challenge controller will not take any more action.
     */
    @JsonProperty("processing")
    public Boolean getProcessing() {
        return processing;
    }

    /**
     * Used to denote whether this challenge should be processed or not. This field will only be set to true by the 'scheduling' component. It will only be set to false by the 'challenges' controller, after the challenge has reached a final state or timed out. If this field is set to false, the challenge controller will not take any more action.
     */
    @JsonProperty("processing")
    public void setProcessing(Boolean processing) {
        this.processing = processing;
    }

    /**
     * Contains human readable information on why the Challenge is in the current state.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Contains human readable information on why the Challenge is in the current state.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Contains the current 'state' of the challenge. If not set, the state of the challenge is unknown.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * Contains the current 'state' of the challenge. If not set, the state of the challenge is unknown.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public ChallengeStatusBuilder edit() {
        return new ChallengeStatusBuilder(this);
    }

    @JsonIgnore
    public ChallengeStatusBuilder toBuilder() {
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
        if (!(o instanceof ChallengeStatus)) {
            return false;
        }
        ChallengeStatus other = (ChallengeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$presented = this.getPresented();
        Object other$presented = other.getPresented();
        if (this$presented == null ? other$presented != null : !this$presented.equals(other$presented)) {
            return false;
        }
        Object this$presentedAt = this.getPresentedAt();
        Object other$presentedAt = other.getPresentedAt();
        if (this$presentedAt == null ? other$presentedAt != null : !this$presentedAt.equals(other$presentedAt)) {
            return false;
        }
        Object this$processing = this.getProcessing();
        Object other$processing = other.getProcessing();
        if (this$processing == null ? other$processing != null : !this$processing.equals(other$processing)) {
            return false;
        }
        Object this$reason = this.getReason();
        Object other$reason = other.getReason();
        if (this$reason == null ? other$reason != null : !this$reason.equals(other$reason)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
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
        return other instanceof ChallengeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $presented = this.getPresented();
        result = result * prime + ($presented == null ? 43 : $presented.hashCode());
        Object $presentedAt = this.getPresentedAt();
        result = result * prime + ($presentedAt == null ? 43 : $presentedAt.hashCode());
        Object $processing = this.getProcessing();
        result = result * prime + ($processing == null ? 43 : $processing.hashCode());
        Object $reason = this.getReason();
        result = result * prime + ($reason == null ? 43 : $reason.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ChallengeStatus(" + "presented=" + this.getPresented() + ", presentedAt=" + this.getPresentedAt() + ", processing=" + this.getProcessing() + ", reason=" + this.getReason() + ", state=" + this.getState() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
