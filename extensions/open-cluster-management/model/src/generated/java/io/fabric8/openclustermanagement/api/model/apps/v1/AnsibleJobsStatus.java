
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
 * AnsibleJobsStatus defines status of ansible jobs propagated by the subscription
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastposthookjob",
    "lastprehookjob",
    "posthookjobshistory",
    "prehookjobshistory"
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
public class AnsibleJobsStatus implements Editable<AnsibleJobsStatusBuilder>, KubernetesResource
{

    @JsonProperty("lastposthookjob")
    private String lastposthookjob;
    @JsonProperty("lastprehookjob")
    private String lastprehookjob;
    @JsonProperty("posthookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> posthookjobshistory = new ArrayList<>();
    @JsonProperty("prehookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> prehookjobshistory = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AnsibleJobsStatus() {
    }

    public AnsibleJobsStatus(String lastposthookjob, String lastprehookjob, List<String> posthookjobshistory, List<String> prehookjobshistory) {
        super();
        this.lastposthookjob = lastposthookjob;
        this.lastprehookjob = lastprehookjob;
        this.posthookjobshistory = posthookjobshistory;
        this.prehookjobshistory = prehookjobshistory;
    }

    /**
     * The lastly propagated posthook job
     */
    @JsonProperty("lastposthookjob")
    public String getLastposthookjob() {
        return lastposthookjob;
    }

    /**
     * The lastly propagated posthook job
     */
    @JsonProperty("lastposthookjob")
    public void setLastposthookjob(String lastposthookjob) {
        this.lastposthookjob = lastposthookjob;
    }

    /**
     * The lastly propagated prehook job
     */
    @JsonProperty("lastprehookjob")
    public String getLastprehookjob() {
        return lastprehookjob;
    }

    /**
     * The lastly propagated prehook job
     */
    @JsonProperty("lastprehookjob")
    public void setLastprehookjob(String lastprehookjob) {
        this.lastprehookjob = lastprehookjob;
    }

    /**
     * reserved for backward compatibility
     */
    @JsonProperty("posthookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPosthookjobshistory() {
        return posthookjobshistory;
    }

    /**
     * reserved for backward compatibility
     */
    @JsonProperty("posthookjobshistory")
    public void setPosthookjobshistory(List<String> posthookjobshistory) {
        this.posthookjobshistory = posthookjobshistory;
    }

    /**
     * reserved for backward compatibility
     */
    @JsonProperty("prehookjobshistory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPrehookjobshistory() {
        return prehookjobshistory;
    }

    /**
     * reserved for backward compatibility
     */
    @JsonProperty("prehookjobshistory")
    public void setPrehookjobshistory(List<String> prehookjobshistory) {
        this.prehookjobshistory = prehookjobshistory;
    }

    @JsonIgnore
    public AnsibleJobsStatusBuilder edit() {
        return new AnsibleJobsStatusBuilder(this);
    }

    @JsonIgnore
    public AnsibleJobsStatusBuilder toBuilder() {
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
        if (!(o instanceof AnsibleJobsStatus)) {
            return false;
        }
        AnsibleJobsStatus other = (AnsibleJobsStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lastposthookjob = this.getLastposthookjob();
        Object other$lastposthookjob = other.getLastposthookjob();
        if (this$lastposthookjob == null ? other$lastposthookjob != null : !this$lastposthookjob.equals(other$lastposthookjob)) {
            return false;
        }
        Object this$lastprehookjob = this.getLastprehookjob();
        Object other$lastprehookjob = other.getLastprehookjob();
        if (this$lastprehookjob == null ? other$lastprehookjob != null : !this$lastprehookjob.equals(other$lastprehookjob)) {
            return false;
        }
        Object this$posthookjobshistory = this.getPosthookjobshistory();
        Object other$posthookjobshistory = other.getPosthookjobshistory();
        if (this$posthookjobshistory == null ? other$posthookjobshistory != null : !this$posthookjobshistory.equals(other$posthookjobshistory)) {
            return false;
        }
        Object this$prehookjobshistory = this.getPrehookjobshistory();
        Object other$prehookjobshistory = other.getPrehookjobshistory();
        if (this$prehookjobshistory == null ? other$prehookjobshistory != null : !this$prehookjobshistory.equals(other$prehookjobshistory)) {
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
        return other instanceof AnsibleJobsStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lastposthookjob = this.getLastposthookjob();
        result = result * prime + ($lastposthookjob == null ? 43 : $lastposthookjob.hashCode());
        Object $lastprehookjob = this.getLastprehookjob();
        result = result * prime + ($lastprehookjob == null ? 43 : $lastprehookjob.hashCode());
        Object $posthookjobshistory = this.getPosthookjobshistory();
        result = result * prime + ($posthookjobshistory == null ? 43 : $posthookjobshistory.hashCode());
        Object $prehookjobshistory = this.getPrehookjobshistory();
        result = result * prime + ($prehookjobshistory == null ? 43 : $prehookjobshistory.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AnsibleJobsStatus(" + "lastposthookjob=" + this.getLastposthookjob() + ", lastprehookjob=" + this.getLastprehookjob() + ", posthookjobshistory=" + this.getPosthookjobshistory() + ", prehookjobshistory=" + this.getPrehookjobshistory() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
