
package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "failures",
    "outages",
    "successes"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
public class PodNetworkConnectivityCheckStatus implements Editable<PodNetworkConnectivityCheckStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodNetworkConnectivityCheckCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<PodNetworkConnectivityCheckCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("failures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getFailures() {
        return failures;
    }

    @JsonProperty("failures")
    public void setFailures(List<LogEntry> failures) {
        this.failures = failures;
    }

    @JsonProperty("outages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OutageEntry> getOutages() {
        return outages;
    }

    @JsonProperty("outages")
    public void setOutages(List<OutageEntry> outages) {
        this.outages = outages;
    }

    @JsonProperty("successes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LogEntry> getSuccesses() {
        return successes;
    }

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

}
