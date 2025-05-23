
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.clusterapi.v1beta1.Condition;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Metal3ClusterStatus defines the observed state of Metal3Cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "failureMessage",
    "failureReason",
    "lastUpdated",
    "ready"
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
public class Metal3ClusterStatus implements Editable<Metal3ClusterStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("failureMessage")
    private String failureMessage;
    @JsonProperty("failureReason")
    private String failureReason;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metal3ClusterStatus() {
    }

    public Metal3ClusterStatus(List<Condition> conditions, String failureMessage, String failureReason, String lastUpdated, Boolean ready) {
        super();
        this.conditions = conditions;
        this.failureMessage = failureMessage;
        this.failureReason = failureReason;
        this.lastUpdated = lastUpdated;
        this.ready = ready;
    }

    /**
     * Conditions defines current service state of the Metal3Cluster.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines current service state of the Metal3Cluster.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * FailureMessage indicates that there is a fatal problem reconciling the state, and will be set to a descriptive error message.
     */
    @JsonProperty("failureMessage")
    public String getFailureMessage() {
        return failureMessage;
    }

    /**
     * FailureMessage indicates that there is a fatal problem reconciling the state, and will be set to a descriptive error message.
     */
    @JsonProperty("failureMessage")
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    /**
     * FailureReason indicates that there is a fatal problem reconciling the state, and will be set to a token value suitable for programmatic interpretation.
     */
    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    /**
     * FailureReason indicates that there is a fatal problem reconciling the state, and will be set to a token value suitable for programmatic interpretation.
     */
    @JsonProperty("failureReason")
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    /**
     * Metal3ClusterStatus defines the observed state of Metal3Cluster.
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Metal3ClusterStatus defines the observed state of Metal3Cluster.
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * Ready denotes that the Metal3 cluster (infrastructure) is ready. In Baremetal case, it does not mean anything for now as no infrastructure steps need to be performed. Required by Cluster API. Set to True by the metal3Cluster controller after creation.
     */
    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    /**
     * Ready denotes that the Metal3 cluster (infrastructure) is ready. In Baremetal case, it does not mean anything for now as no infrastructure steps need to be performed. Required by Cluster API. Set to True by the metal3Cluster controller after creation.
     */
    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    @JsonIgnore
    public Metal3ClusterStatusBuilder edit() {
        return new Metal3ClusterStatusBuilder(this);
    }

    @JsonIgnore
    public Metal3ClusterStatusBuilder toBuilder() {
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

}
