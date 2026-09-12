
package io.fabric8.openclustermanagement.api.model.policy.v1;

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
 * DetailsPerTemplate reports the current compliance state and list of recent compliance messages for a given policy template.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compliant",
    "history",
    "templateMeta"
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
public class DetailsPerTemplate implements Editable<DetailsPerTemplateBuilder>, KubernetesResource
{

    @JsonProperty("compliant")
    private String compliant;
    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ComplianceHistory> history = new ArrayList<>();
    @JsonProperty("templateMeta")
    private ObjectMeta templateMeta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DetailsPerTemplate() {
    }

    public DetailsPerTemplate(String compliant, List<ComplianceHistory> history, ObjectMeta templateMeta) {
        super();
        this.compliant = compliant;
        this.history = history;
        this.templateMeta = templateMeta;
    }

    /**
     * DetailsPerTemplate reports the current compliance state and list of recent compliance messages for a given policy template.
     */
    @JsonProperty("compliant")
    public String getCompliant() {
        return compliant;
    }

    /**
     * DetailsPerTemplate reports the current compliance state and list of recent compliance messages for a given policy template.
     */
    @JsonProperty("compliant")
    public void setCompliant(String compliant) {
        this.compliant = compliant;
    }

    /**
     * DetailsPerTemplate reports the current compliance state and list of recent compliance messages for a given policy template.
     */
    @JsonProperty("history")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ComplianceHistory> getHistory() {
        return history;
    }

    /**
     * DetailsPerTemplate reports the current compliance state and list of recent compliance messages for a given policy template.
     */
    @JsonProperty("history")
    public void setHistory(List<ComplianceHistory> history) {
        this.history = history;
    }

    /**
     * DetailsPerTemplate reports the current compliance state and list of recent compliance messages for a given policy template.
     */
    @JsonProperty("templateMeta")
    public ObjectMeta getTemplateMeta() {
        return templateMeta;
    }

    /**
     * DetailsPerTemplate reports the current compliance state and list of recent compliance messages for a given policy template.
     */
    @JsonProperty("templateMeta")
    public void setTemplateMeta(ObjectMeta templateMeta) {
        this.templateMeta = templateMeta;
    }

    @JsonIgnore
    public DetailsPerTemplateBuilder edit() {
        return new DetailsPerTemplateBuilder(this);
    }

    @JsonIgnore
    public DetailsPerTemplateBuilder toBuilder() {
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
        if (!(o instanceof DetailsPerTemplate)) {
            return false;
        }
        DetailsPerTemplate other = (DetailsPerTemplate) o;
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
        Object this$templateMeta = this.getTemplateMeta();
        Object other$templateMeta = other.getTemplateMeta();
        if (this$templateMeta == null ? other$templateMeta != null : !this$templateMeta.equals(other$templateMeta)) {
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
        return other instanceof DetailsPerTemplate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $compliant = this.getCompliant();
        result = result * prime + ($compliant == null ? 43 : $compliant.hashCode());
        Object $history = this.getHistory();
        result = result * prime + ($history == null ? 43 : $history.hashCode());
        Object $templateMeta = this.getTemplateMeta();
        result = result * prime + ($templateMeta == null ? 43 : $templateMeta.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DetailsPerTemplate(" + "compliant=" + this.getCompliant() + ", history=" + this.getHistory() + ", templateMeta=" + this.getTemplateMeta() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
