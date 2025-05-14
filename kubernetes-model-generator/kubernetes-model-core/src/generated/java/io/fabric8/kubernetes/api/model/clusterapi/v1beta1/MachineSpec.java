
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
import io.fabric8.kubernetes.api.model.Duration;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootstrap",
    "clusterName",
    "failureDomain",
    "infrastructureRef",
    "nodeDeletionTimeout",
    "nodeDrainTimeout",
    "nodeVolumeDetachTimeout",
    "providerID",
    "readinessGates",
    "version"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class MachineSpec implements Editable<MachineSpecBuilder>, KubernetesResource
{

    @JsonProperty("bootstrap")
    private Bootstrap bootstrap;
    @JsonProperty("clusterName")
    private String clusterName;
    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("infrastructureRef")
    private ObjectReference infrastructureRef;
    @JsonProperty("nodeDeletionTimeout")
    private Duration nodeDeletionTimeout;
    @JsonProperty("nodeDrainTimeout")
    private Duration nodeDrainTimeout;
    @JsonProperty("nodeVolumeDetachTimeout")
    private Duration nodeVolumeDetachTimeout;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineReadinessGate> readinessGates = new ArrayList<>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineSpec() {
    }

    public MachineSpec(Bootstrap bootstrap, String clusterName, String failureDomain, ObjectReference infrastructureRef, Duration nodeDeletionTimeout, Duration nodeDrainTimeout, Duration nodeVolumeDetachTimeout, String providerID, List<MachineReadinessGate> readinessGates, String version) {
        super();
        this.bootstrap = bootstrap;
        this.clusterName = clusterName;
        this.failureDomain = failureDomain;
        this.infrastructureRef = infrastructureRef;
        this.nodeDeletionTimeout = nodeDeletionTimeout;
        this.nodeDrainTimeout = nodeDrainTimeout;
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
        this.providerID = providerID;
        this.readinessGates = readinessGates;
        this.version = version;
    }

    @JsonProperty("bootstrap")
    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    @JsonProperty("bootstrap")
    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    @JsonProperty("clusterName")
    public String getClusterName() {
        return clusterName;
    }

    @JsonProperty("clusterName")
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    @JsonProperty("infrastructureRef")
    public ObjectReference getInfrastructureRef() {
        return infrastructureRef;
    }

    @JsonProperty("infrastructureRef")
    public void setInfrastructureRef(ObjectReference infrastructureRef) {
        this.infrastructureRef = infrastructureRef;
    }

    @JsonProperty("nodeDeletionTimeout")
    public Duration getNodeDeletionTimeout() {
        return nodeDeletionTimeout;
    }

    @JsonProperty("nodeDeletionTimeout")
    public void setNodeDeletionTimeout(Duration nodeDeletionTimeout) {
        this.nodeDeletionTimeout = nodeDeletionTimeout;
    }

    @JsonProperty("nodeDrainTimeout")
    public Duration getNodeDrainTimeout() {
        return nodeDrainTimeout;
    }

    @JsonProperty("nodeDrainTimeout")
    public void setNodeDrainTimeout(Duration nodeDrainTimeout) {
        this.nodeDrainTimeout = nodeDrainTimeout;
    }

    @JsonProperty("nodeVolumeDetachTimeout")
    public Duration getNodeVolumeDetachTimeout() {
        return nodeVolumeDetachTimeout;
    }

    @JsonProperty("nodeVolumeDetachTimeout")
    public void setNodeVolumeDetachTimeout(Duration nodeVolumeDetachTimeout) {
        this.nodeVolumeDetachTimeout = nodeVolumeDetachTimeout;
    }

    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    @JsonProperty("readinessGates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineReadinessGate> getReadinessGates() {
        return readinessGates;
    }

    @JsonProperty("readinessGates")
    public void setReadinessGates(List<MachineReadinessGate> readinessGates) {
        this.readinessGates = readinessGates;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public MachineSpecBuilder edit() {
        return new MachineSpecBuilder(this);
    }

    @JsonIgnore
    public MachineSpecBuilder toBuilder() {
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
