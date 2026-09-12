
package io.fabric8.kubernetes.api.model.coordination.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.MicroTime;
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
 * LeaseCandidateSpec is a specification of a Lease.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "binaryVersion",
    "emulationVersion",
    "leaseName",
    "pingTime",
    "renewTime",
    "strategy"
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
public class LeaseCandidateSpec implements Editable<LeaseCandidateSpecBuilder>, KubernetesResource
{

    @JsonProperty("binaryVersion")
    private String binaryVersion;
    @JsonProperty("emulationVersion")
    private String emulationVersion;
    @JsonProperty("leaseName")
    private String leaseName;
    @JsonProperty("pingTime")
    private MicroTime pingTime;
    @JsonProperty("renewTime")
    private MicroTime renewTime;
    @JsonProperty("strategy")
    private String strategy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LeaseCandidateSpec() {
    }

    public LeaseCandidateSpec(String binaryVersion, String emulationVersion, String leaseName, MicroTime pingTime, MicroTime renewTime, String strategy) {
        super();
        this.binaryVersion = binaryVersion;
        this.emulationVersion = emulationVersion;
        this.leaseName = leaseName;
        this.pingTime = pingTime;
        this.renewTime = renewTime;
        this.strategy = strategy;
    }

    /**
     * binaryVersion is the binary version. It must be in a semver format without leading `v`. This field is required.
     */
    @JsonProperty("binaryVersion")
    public String getBinaryVersion() {
        return binaryVersion;
    }

    /**
     * binaryVersion is the binary version. It must be in a semver format without leading `v`. This field is required.
     */
    @JsonProperty("binaryVersion")
    public void setBinaryVersion(String binaryVersion) {
        this.binaryVersion = binaryVersion;
    }

    /**
     * emulationVersion is the emulation version. It must be in a semver format without leading `v`. EmulationVersion must be less than or equal to BinaryVersion. This field is required when strategy is "OldestEmulationVersion"
     */
    @JsonProperty("emulationVersion")
    public String getEmulationVersion() {
        return emulationVersion;
    }

    /**
     * emulationVersion is the emulation version. It must be in a semver format without leading `v`. EmulationVersion must be less than or equal to BinaryVersion. This field is required when strategy is "OldestEmulationVersion"
     */
    @JsonProperty("emulationVersion")
    public void setEmulationVersion(String emulationVersion) {
        this.emulationVersion = emulationVersion;
    }

    /**
     * leaseName is the name of the lease for which this candidate is contending. The limits on this field are the same as on Lease.name. Multiple lease candidates may reference the same Lease.name. This field is immutable.
     */
    @JsonProperty("leaseName")
    public String getLeaseName() {
        return leaseName;
    }

    /**
     * leaseName is the name of the lease for which this candidate is contending. The limits on this field are the same as on Lease.name. Multiple lease candidates may reference the same Lease.name. This field is immutable.
     */
    @JsonProperty("leaseName")
    public void setLeaseName(String leaseName) {
        this.leaseName = leaseName;
    }

    /**
     * LeaseCandidateSpec is a specification of a Lease.
     */
    @JsonProperty("pingTime")
    public MicroTime getPingTime() {
        return pingTime;
    }

    /**
     * LeaseCandidateSpec is a specification of a Lease.
     */
    @JsonProperty("pingTime")
    public void setPingTime(MicroTime pingTime) {
        this.pingTime = pingTime;
    }

    /**
     * LeaseCandidateSpec is a specification of a Lease.
     */
    @JsonProperty("renewTime")
    public MicroTime getRenewTime() {
        return renewTime;
    }

    /**
     * LeaseCandidateSpec is a specification of a Lease.
     */
    @JsonProperty("renewTime")
    public void setRenewTime(MicroTime renewTime) {
        this.renewTime = renewTime;
    }

    /**
     * strategy is the strategy that coordinated leader election will use for picking the leader. If multiple candidates for the same Lease return different strategies, the strategy provided by the candidate with the latest BinaryVersion will be used. If there is still conflict, this is a user error and coordinated leader election will not operate the Lease until resolved.
     */
    @JsonProperty("strategy")
    public String getStrategy() {
        return strategy;
    }

    /**
     * strategy is the strategy that coordinated leader election will use for picking the leader. If multiple candidates for the same Lease return different strategies, the strategy provided by the candidate with the latest BinaryVersion will be used. If there is still conflict, this is a user error and coordinated leader election will not operate the Lease until resolved.
     */
    @JsonProperty("strategy")
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    @JsonIgnore
    public LeaseCandidateSpecBuilder edit() {
        return new LeaseCandidateSpecBuilder(this);
    }

    @JsonIgnore
    public LeaseCandidateSpecBuilder toBuilder() {
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
        if (!(o instanceof LeaseCandidateSpec)) {
            return false;
        }
        LeaseCandidateSpec other = (LeaseCandidateSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$binaryVersion = this.getBinaryVersion();
        Object other$binaryVersion = other.getBinaryVersion();
        if (this$binaryVersion == null ? other$binaryVersion != null : !this$binaryVersion.equals(other$binaryVersion)) {
            return false;
        }
        Object this$emulationVersion = this.getEmulationVersion();
        Object other$emulationVersion = other.getEmulationVersion();
        if (this$emulationVersion == null ? other$emulationVersion != null : !this$emulationVersion.equals(other$emulationVersion)) {
            return false;
        }
        Object this$leaseName = this.getLeaseName();
        Object other$leaseName = other.getLeaseName();
        if (this$leaseName == null ? other$leaseName != null : !this$leaseName.equals(other$leaseName)) {
            return false;
        }
        Object this$pingTime = this.getPingTime();
        Object other$pingTime = other.getPingTime();
        if (this$pingTime == null ? other$pingTime != null : !this$pingTime.equals(other$pingTime)) {
            return false;
        }
        Object this$renewTime = this.getRenewTime();
        Object other$renewTime = other.getRenewTime();
        if (this$renewTime == null ? other$renewTime != null : !this$renewTime.equals(other$renewTime)) {
            return false;
        }
        Object this$strategy = this.getStrategy();
        Object other$strategy = other.getStrategy();
        if (this$strategy == null ? other$strategy != null : !this$strategy.equals(other$strategy)) {
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
        return other instanceof LeaseCandidateSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $binaryVersion = this.getBinaryVersion();
        result = result * prime + ($binaryVersion == null ? 43 : $binaryVersion.hashCode());
        Object $emulationVersion = this.getEmulationVersion();
        result = result * prime + ($emulationVersion == null ? 43 : $emulationVersion.hashCode());
        Object $leaseName = this.getLeaseName();
        result = result * prime + ($leaseName == null ? 43 : $leaseName.hashCode());
        Object $pingTime = this.getPingTime();
        result = result * prime + ($pingTime == null ? 43 : $pingTime.hashCode());
        Object $renewTime = this.getRenewTime();
        result = result * prime + ($renewTime == null ? 43 : $renewTime.hashCode());
        Object $strategy = this.getStrategy();
        result = result * prime + ($strategy == null ? 43 : $strategy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LeaseCandidateSpec(" + "binaryVersion=" + this.getBinaryVersion() + ", emulationVersion=" + this.getEmulationVersion() + ", leaseName=" + this.getLeaseName() + ", pingTime=" + this.getPingTime() + ", renewTime=" + this.getRenewTime() + ", strategy=" + this.getStrategy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
