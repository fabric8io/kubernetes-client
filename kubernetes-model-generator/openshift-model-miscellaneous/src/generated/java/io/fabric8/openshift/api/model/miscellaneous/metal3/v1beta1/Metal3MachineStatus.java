
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.clusterapi.v1beta1.Condition;
import io.fabric8.kubernetes.api.model.clusterapi.v1beta1.MachineAddress;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "conditions",
    "failureMessage",
    "failureReason",
    "lastUpdated",
    "metaData",
    "networkData",
    "phase",
    "ready",
    "renderedData",
    "userData"
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
public class Metal3MachineStatus implements Editable<Metal3MachineStatusBuilder> , KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineAddress> addresses = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("failureMessage")
    private String failureMessage;
    @JsonProperty("failureReason")
    private String failureReason;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("metaData")
    private SecretReference metaData;
    @JsonProperty("networkData")
    private SecretReference networkData;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("renderedData")
    private ObjectReference renderedData;
    @JsonProperty("userData")
    private SecretReference userData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Metal3MachineStatus() {
    }

    public Metal3MachineStatus(List<MachineAddress> addresses, List<Condition> conditions, String failureMessage, String failureReason, String lastUpdated, SecretReference metaData, SecretReference networkData, String phase, Boolean ready, ObjectReference renderedData, SecretReference userData) {
        super();
        this.addresses = addresses;
        this.conditions = conditions;
        this.failureMessage = failureMessage;
        this.failureReason = failureReason;
        this.lastUpdated = lastUpdated;
        this.metaData = metaData;
        this.networkData = networkData;
        this.phase = phase;
        this.ready = ready;
        this.renderedData = renderedData;
        this.userData = userData;
    }

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<MachineAddress> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("failureMessage")
    public String getFailureMessage() {
        return failureMessage;
    }

    @JsonProperty("failureMessage")
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    @JsonProperty("failureReason")
    public String getFailureReason() {
        return failureReason;
    }

    @JsonProperty("failureReason")
    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("metaData")
    public SecretReference getMetaData() {
        return metaData;
    }

    @JsonProperty("metaData")
    public void setMetaData(SecretReference metaData) {
        this.metaData = metaData;
    }

    @JsonProperty("networkData")
    public SecretReference getNetworkData() {
        return networkData;
    }

    @JsonProperty("networkData")
    public void setNetworkData(SecretReference networkData) {
        this.networkData = networkData;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    @JsonProperty("renderedData")
    public ObjectReference getRenderedData() {
        return renderedData;
    }

    @JsonProperty("renderedData")
    public void setRenderedData(ObjectReference renderedData) {
        this.renderedData = renderedData;
    }

    @JsonProperty("userData")
    public SecretReference getUserData() {
        return userData;
    }

    @JsonProperty("userData")
    public void setUserData(SecretReference userData) {
        this.userData = userData;
    }

    @JsonIgnore
    public Metal3MachineStatusBuilder edit() {
        return new Metal3MachineStatusBuilder(this);
    }

    @JsonIgnore
    public Metal3MachineStatusBuilder toBuilder() {
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
