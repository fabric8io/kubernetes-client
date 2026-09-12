
package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "failures",
    "outages",
    "successes"
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
public class PodNetworkConnectivityCheckStatus implements Editable<PodNetworkConnectivityCheckStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodNetworkConnectivityCheckCondition> conditions = new ArrayList<>();
    @JsonProperty("failures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LogEntry> failures = new ArrayList<>();
    @JsonProperty("outages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OutageEntry> outages = new ArrayList<>();
    @JsonProperty("successes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LogEntry> successes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodNetworkConnectivityCheckStatus() {
    }

    public PodNetworkConnectivityCheckStatus(List<PodNetworkConnectivityCheckCondition> conditions, List<LogEntry> failures, List<OutageEntry> outages, List<LogEntry> successes) {
        super();
        this.conditions = conditions;
        this.failures = failures;
        this.outages = outages;
        this.successes = successes;
    }

    /**
     * conditions summarize the status of the check
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodNetworkConnectivityCheckCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions summarize the status of the check
     */
    @JsonProperty("conditions")
    public void setConditions(List<PodNetworkConnectivityCheckCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * failures contains logs of unsuccessful check actions
     */
    @JsonProperty("failures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getFailures() {
        return failures;
    }

    /**
     * failures contains logs of unsuccessful check actions
     */
    @JsonProperty("failures")
    public void setFailures(List<LogEntry> failures) {
        this.failures = failures;
    }

    /**
     * outages contains logs of time periods of outages
     */
    @JsonProperty("outages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OutageEntry> getOutages() {
        return outages;
    }

    /**
     * outages contains logs of time periods of outages
     */
    @JsonProperty("outages")
    public void setOutages(List<OutageEntry> outages) {
        this.outages = outages;
    }

    /**
     * successes contains logs successful check actions
     */
    @JsonProperty("successes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getSuccesses() {
        return successes;
    }

    /**
     * successes contains logs successful check actions
     */
    @JsonProperty("successes")
    public void setSuccesses(List<LogEntry> successes) {
        this.successes = successes;
    }

    @JsonIgnore
    public PodNetworkConnectivityCheckStatusBuilder edit() {
        return new PodNetworkConnectivityCheckStatusBuilder(this);
    }

    @JsonIgnore
    public PodNetworkConnectivityCheckStatusBuilder toBuilder() {
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
        if (!(o instanceof PodNetworkConnectivityCheckStatus)) {
            return false;
        }
        PodNetworkConnectivityCheckStatus other = (PodNetworkConnectivityCheckStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$failures = this.getFailures();
        Object other$failures = other.getFailures();
        if (this$failures == null ? other$failures != null : !this$failures.equals(other$failures)) {
            return false;
        }
        Object this$outages = this.getOutages();
        Object other$outages = other.getOutages();
        if (this$outages == null ? other$outages != null : !this$outages.equals(other$outages)) {
            return false;
        }
        Object this$successes = this.getSuccesses();
        Object other$successes = other.getSuccesses();
        if (this$successes == null ? other$successes != null : !this$successes.equals(other$successes)) {
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
        return other instanceof PodNetworkConnectivityCheckStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $failures = this.getFailures();
        result = result * prime + ($failures == null ? 43 : $failures.hashCode());
        Object $outages = this.getOutages();
        result = result * prime + ($outages == null ? 43 : $outages.hashCode());
        Object $successes = this.getSuccesses();
        result = result * prime + ($successes == null ? 43 : $successes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodNetworkConnectivityCheckStatus(" + "conditions=" + this.getConditions() + ", failures=" + this.getFailures() + ", outages=" + this.getOutages() + ", successes=" + this.getSuccesses() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
