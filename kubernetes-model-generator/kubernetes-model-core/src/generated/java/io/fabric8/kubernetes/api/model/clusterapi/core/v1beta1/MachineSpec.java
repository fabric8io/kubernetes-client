
package io.fabric8.kubernetes.api.model.clusterapi.core.v1beta1;

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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachineSpec)) {
            return false;
        }
        MachineSpec other = (MachineSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bootstrap = this.getBootstrap();
        Object other$bootstrap = other.getBootstrap();
        if (this$bootstrap == null ? other$bootstrap != null : !this$bootstrap.equals(other$bootstrap)) {
            return false;
        }
        Object this$clusterName = this.getClusterName();
        Object other$clusterName = other.getClusterName();
        if (this$clusterName == null ? other$clusterName != null : !this$clusterName.equals(other$clusterName)) {
            return false;
        }
        Object this$failureDomain = this.getFailureDomain();
        Object other$failureDomain = other.getFailureDomain();
        if (this$failureDomain == null ? other$failureDomain != null : !this$failureDomain.equals(other$failureDomain)) {
            return false;
        }
        Object this$infrastructureRef = this.getInfrastructureRef();
        Object other$infrastructureRef = other.getInfrastructureRef();
        if (this$infrastructureRef == null ? other$infrastructureRef != null : !this$infrastructureRef.equals(other$infrastructureRef)) {
            return false;
        }
        Object this$nodeDeletionTimeout = this.getNodeDeletionTimeout();
        Object other$nodeDeletionTimeout = other.getNodeDeletionTimeout();
        if (this$nodeDeletionTimeout == null ? other$nodeDeletionTimeout != null : !this$nodeDeletionTimeout.equals(other$nodeDeletionTimeout)) {
            return false;
        }
        Object this$nodeDrainTimeout = this.getNodeDrainTimeout();
        Object other$nodeDrainTimeout = other.getNodeDrainTimeout();
        if (this$nodeDrainTimeout == null ? other$nodeDrainTimeout != null : !this$nodeDrainTimeout.equals(other$nodeDrainTimeout)) {
            return false;
        }
        Object this$nodeVolumeDetachTimeout = this.getNodeVolumeDetachTimeout();
        Object other$nodeVolumeDetachTimeout = other.getNodeVolumeDetachTimeout();
        if (this$nodeVolumeDetachTimeout == null ? other$nodeVolumeDetachTimeout != null : !this$nodeVolumeDetachTimeout.equals(other$nodeVolumeDetachTimeout)) {
            return false;
        }
        Object this$providerID = this.getProviderID();
        Object other$providerID = other.getProviderID();
        if (this$providerID == null ? other$providerID != null : !this$providerID.equals(other$providerID)) {
            return false;
        }
        Object this$readinessGates = this.getReadinessGates();
        Object other$readinessGates = other.getReadinessGates();
        if (this$readinessGates == null ? other$readinessGates != null : !this$readinessGates.equals(other$readinessGates)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof MachineSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bootstrap = this.getBootstrap();
        result = result * prime + ($bootstrap == null ? 43 : $bootstrap.hashCode());
        Object $clusterName = this.getClusterName();
        result = result * prime + ($clusterName == null ? 43 : $clusterName.hashCode());
        Object $failureDomain = this.getFailureDomain();
        result = result * prime + ($failureDomain == null ? 43 : $failureDomain.hashCode());
        Object $infrastructureRef = this.getInfrastructureRef();
        result = result * prime + ($infrastructureRef == null ? 43 : $infrastructureRef.hashCode());
        Object $nodeDeletionTimeout = this.getNodeDeletionTimeout();
        result = result * prime + ($nodeDeletionTimeout == null ? 43 : $nodeDeletionTimeout.hashCode());
        Object $nodeDrainTimeout = this.getNodeDrainTimeout();
        result = result * prime + ($nodeDrainTimeout == null ? 43 : $nodeDrainTimeout.hashCode());
        Object $nodeVolumeDetachTimeout = this.getNodeVolumeDetachTimeout();
        result = result * prime + ($nodeVolumeDetachTimeout == null ? 43 : $nodeVolumeDetachTimeout.hashCode());
        Object $providerID = this.getProviderID();
        result = result * prime + ($providerID == null ? 43 : $providerID.hashCode());
        Object $readinessGates = this.getReadinessGates();
        result = result * prime + ($readinessGates == null ? 43 : $readinessGates.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineSpec(" + "bootstrap=" + this.getBootstrap() + ", clusterName=" + this.getClusterName() + ", failureDomain=" + this.getFailureDomain() + ", infrastructureRef=" + this.getInfrastructureRef() + ", nodeDeletionTimeout=" + this.getNodeDeletionTimeout() + ", nodeDrainTimeout=" + this.getNodeDrainTimeout() + ", nodeVolumeDetachTimeout=" + this.getNodeVolumeDetachTimeout() + ", providerID=" + this.getProviderID() + ", readinessGates=" + this.getReadinessGates() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
