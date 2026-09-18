
package io.fabric8.openclustermanagement.api.model.policy.v1beta1;

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
 * ReplicatedDetailsPerTemplate defines the replicated policy compliance details and history.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compliant",
    "history"
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
public class ReplicatedDetailsPerTemplate implements Editable<ReplicatedDetailsPerTemplateBuilder>, KubernetesResource
{

    @JsonProperty("compliant")
    private String compliant;
    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ReplicatedComplianceHistory> history = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ReplicatedDetailsPerTemplate() {
    }

    public ReplicatedDetailsPerTemplate(String compliant, List<ReplicatedComplianceHistory> history) {
        super();
        this.compliant = compliant;
        this.history = history;
    }

    /**
     * ReplicatedDetailsPerTemplate defines the replicated policy compliance details and history.
     */
    @JsonProperty("compliant")
    public String getCompliant() {
        return compliant;
    }

    /**
     * ReplicatedDetailsPerTemplate defines the replicated policy compliance details and history.
     */
    @JsonProperty("compliant")
    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    /**
     * ReplicatedDetailsPerTemplate defines the replicated policy compliance details and history.
     */
    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ReplicatedComplianceHistory> getHistory() {
        return history;
    }

    /**
     * ReplicatedDetailsPerTemplate defines the replicated policy compliance details and history.
     */
    @JsonProperty("history")
    public void setHistory(List<ReplicatedComplianceHistory> history) {
        this.history = history;
    }

    @JsonIgnore
    public ReplicatedDetailsPerTemplateBuilder edit() {
        return new ReplicatedDetailsPerTemplateBuilder(this);
    }

    @JsonIgnore
    public ReplicatedDetailsPerTemplateBuilder toBuilder() {
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
        if (!(o instanceof ReplicatedDetailsPerTemplate)) {
            return false;
        }
        ReplicatedDetailsPerTemplate other = (ReplicatedDetailsPerTemplate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$compliant = this.getCompliant();
        Object other$compliant = other.getCompliant();
        if (this$compliant == null ? other$compliant != null : !this$compliant.equals(other$compliant)) {
            return false;
        }
        Object this$history = this.getHistory();
        Object other$history = other.getHistory();
        if (this$history == null ? other$history != null : !this$history.equals(other$history)) {
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
        return other instanceof ReplicatedDetailsPerTemplate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $compliant = this.getCompliant();
        result = result * prime + ($compliant == null ? 43 : $compliant.hashCode());
        Object $history = this.getHistory();
        result = result * prime + ($history == null ? 43 : $history.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReplicatedDetailsPerTemplate(" + "compliant=" + this.getCompliant() + ", history=" + this.getHistory() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
