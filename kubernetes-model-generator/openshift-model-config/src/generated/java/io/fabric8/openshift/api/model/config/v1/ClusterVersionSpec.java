
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ClusterVersionSpec is the desired version state of the cluster. It includes the version the cluster should be at, how the cluster is identified, and where the cluster should look for version updates.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "capabilities",
    "channel",
    "clusterID",
    "desiredUpdate",
    "overrides",
    "signatureStores",
    "upstream"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClusterVersionSpec implements Editable<ClusterVersionSpecBuilder>, KubernetesResource
{

    @JsonProperty("capabilities")
    private ClusterVersionCapabilitiesSpec capabilities;
    @JsonProperty("channel")
    private String channel;
    @JsonProperty("clusterID")
    private String clusterID;
    @JsonProperty("desiredUpdate")
    private Update desiredUpdate;
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ComponentOverride> overrides = new ArrayList<>();
    @JsonProperty("signatureStores")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SignatureStore> signatureStores = new ArrayList<>();
    @JsonProperty("upstream")
    private String upstream;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterVersionSpec() {
    }

    public ClusterVersionSpec(ClusterVersionCapabilitiesSpec capabilities, String channel, String clusterID, Update desiredUpdate, List<ComponentOverride> overrides, List<SignatureStore> signatureStores, String upstream) {
        super();
        this.capabilities = capabilities;
        this.channel = channel;
        this.clusterID = clusterID;
        this.desiredUpdate = desiredUpdate;
        this.overrides = overrides;
        this.signatureStores = signatureStores;
        this.upstream = upstream;
    }

    /**
     * ClusterVersionSpec is the desired version state of the cluster. It includes the version the cluster should be at, how the cluster is identified, and where the cluster should look for version updates.
     */
    @JsonProperty("capabilities")
    public ClusterVersionCapabilitiesSpec getCapabilities() {
        return capabilities;
    }

    /**
     * ClusterVersionSpec is the desired version state of the cluster. It includes the version the cluster should be at, how the cluster is identified, and where the cluster should look for version updates.
     */
    @JsonProperty("capabilities")
    public void setCapabilities(ClusterVersionCapabilitiesSpec capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * channel is an identifier for explicitly requesting a non-default set of updates to be applied to this cluster. The default channel will contain stable updates that are appropriate for production clusters.
     */
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    /**
     * channel is an identifier for explicitly requesting a non-default set of updates to be applied to this cluster. The default channel will contain stable updates that are appropriate for production clusters.
     */
    @JsonProperty("channel")
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * clusterID uniquely identifies this cluster. This is expected to be an RFC4122 UUID value (xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx in hexadecimal values). This is a required field.
     */
    @JsonProperty("clusterID")
    public String getClusterID() {
        return clusterID;
    }

    /**
     * clusterID uniquely identifies this cluster. This is expected to be an RFC4122 UUID value (xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx in hexadecimal values). This is a required field.
     */
    @JsonProperty("clusterID")
    public void setClusterID(String clusterID) {
        this.clusterID = clusterID;
    }

    /**
     * ClusterVersionSpec is the desired version state of the cluster. It includes the version the cluster should be at, how the cluster is identified, and where the cluster should look for version updates.
     */
    @JsonProperty("desiredUpdate")
    public Update getDesiredUpdate() {
        return desiredUpdate;
    }

    /**
     * ClusterVersionSpec is the desired version state of the cluster. It includes the version the cluster should be at, how the cluster is identified, and where the cluster should look for version updates.
     */
    @JsonProperty("desiredUpdate")
    public void setDesiredUpdate(Update desiredUpdate) {
        this.desiredUpdate = desiredUpdate;
    }

    /**
     * overrides is list of overides for components that are managed by cluster version operator. Marking a component unmanaged will prevent the operator from creating or updating the object.
     */
    @JsonProperty("overrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ComponentOverride> getOverrides() {
        return overrides;
    }

    /**
     * overrides is list of overides for components that are managed by cluster version operator. Marking a component unmanaged will prevent the operator from creating or updating the object.
     */
    @JsonProperty("overrides")
    public void setOverrides(List<ComponentOverride> overrides) {
        this.overrides = overrides;
    }

    /**
     * signatureStores contains the upstream URIs to verify release signatures and optional reference to a config map by name containing the PEM-encoded CA bundle.<br><p> <br><p> By default, CVO will use existing signature stores if this property is empty. The CVO will check the release signatures in the local ConfigMaps first. It will search for a valid signature in these stores in parallel only when local ConfigMaps did not include a valid signature. Validation will fail if none of the signature stores reply with valid signature before timeout. Setting signatureStores will replace the default signature stores with custom signature stores. Default stores can be used with custom signature stores by adding them manually.<br><p> <br><p> A maximum of 32 signature stores may be configured.
     */
    @JsonProperty("signatureStores")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SignatureStore> getSignatureStores() {
        return signatureStores;
    }

    /**
     * signatureStores contains the upstream URIs to verify release signatures and optional reference to a config map by name containing the PEM-encoded CA bundle.<br><p> <br><p> By default, CVO will use existing signature stores if this property is empty. The CVO will check the release signatures in the local ConfigMaps first. It will search for a valid signature in these stores in parallel only when local ConfigMaps did not include a valid signature. Validation will fail if none of the signature stores reply with valid signature before timeout. Setting signatureStores will replace the default signature stores with custom signature stores. Default stores can be used with custom signature stores by adding them manually.<br><p> <br><p> A maximum of 32 signature stores may be configured.
     */
    @JsonProperty("signatureStores")
    public void setSignatureStores(List<SignatureStore> signatureStores) {
        this.signatureStores = signatureStores;
    }

    /**
     * upstream may be used to specify the preferred update server. By default it will use the appropriate update server for the cluster and region.
     */
    @JsonProperty("upstream")
    public String getUpstream() {
        return upstream;
    }

    /**
     * upstream may be used to specify the preferred update server. By default it will use the appropriate update server for the cluster and region.
     */
    @JsonProperty("upstream")
    public void setUpstream(String upstream) {
        this.upstream = upstream;
    }

    @JsonIgnore
    public ClusterVersionSpecBuilder edit() {
        return new ClusterVersionSpecBuilder(this);
    }

    @JsonIgnore
    public ClusterVersionSpecBuilder toBuilder() {
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
        if (!(o instanceof ClusterVersionSpec)) {
            return false;
        }
        ClusterVersionSpec other = (ClusterVersionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$capabilities = this.getCapabilities();
        Object other$capabilities = other.getCapabilities();
        if (this$capabilities == null ? other$capabilities != null : !this$capabilities.equals(other$capabilities)) {
            return false;
        }
        Object this$channel = this.getChannel();
        Object other$channel = other.getChannel();
        if (this$channel == null ? other$channel != null : !this$channel.equals(other$channel)) {
            return false;
        }
        Object this$clusterID = this.getClusterID();
        Object other$clusterID = other.getClusterID();
        if (this$clusterID == null ? other$clusterID != null : !this$clusterID.equals(other$clusterID)) {
            return false;
        }
        Object this$desiredUpdate = this.getDesiredUpdate();
        Object other$desiredUpdate = other.getDesiredUpdate();
        if (this$desiredUpdate == null ? other$desiredUpdate != null : !this$desiredUpdate.equals(other$desiredUpdate)) {
            return false;
        }
        Object this$overrides = this.getOverrides();
        Object other$overrides = other.getOverrides();
        if (this$overrides == null ? other$overrides != null : !this$overrides.equals(other$overrides)) {
            return false;
        }
        Object this$signatureStores = this.getSignatureStores();
        Object other$signatureStores = other.getSignatureStores();
        if (this$signatureStores == null ? other$signatureStores != null : !this$signatureStores.equals(other$signatureStores)) {
            return false;
        }
        Object this$upstream = this.getUpstream();
        Object other$upstream = other.getUpstream();
        if (this$upstream == null ? other$upstream != null : !this$upstream.equals(other$upstream)) {
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
        return other instanceof ClusterVersionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $capabilities = this.getCapabilities();
        result = result * prime + ($capabilities == null ? 43 : $capabilities.hashCode());
        Object $channel = this.getChannel();
        result = result * prime + ($channel == null ? 43 : $channel.hashCode());
        Object $clusterID = this.getClusterID();
        result = result * prime + ($clusterID == null ? 43 : $clusterID.hashCode());
        Object $desiredUpdate = this.getDesiredUpdate();
        result = result * prime + ($desiredUpdate == null ? 43 : $desiredUpdate.hashCode());
        Object $overrides = this.getOverrides();
        result = result * prime + ($overrides == null ? 43 : $overrides.hashCode());
        Object $signatureStores = this.getSignatureStores();
        result = result * prime + ($signatureStores == null ? 43 : $signatureStores.hashCode());
        Object $upstream = this.getUpstream();
        result = result * prime + ($upstream == null ? 43 : $upstream.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClusterVersionSpec(" + "capabilities=" + this.getCapabilities() + ", channel=" + this.getChannel() + ", clusterID=" + this.getClusterID() + ", desiredUpdate=" + this.getDesiredUpdate() + ", overrides=" + this.getOverrides() + ", signatureStores=" + this.getSignatureStores() + ", upstream=" + this.getUpstream() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
