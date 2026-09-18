
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * UpdateHistory is a single attempted update to the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceptedRisks",
    "completionTime",
    "image",
    "startedTime",
    "state",
    "verified",
    "version"
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
public class UpdateHistory implements Editable<UpdateHistoryBuilder>, KubernetesResource
{

    @JsonProperty("acceptedRisks")
    private String acceptedRisks;
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("image")
    private String image;
    @JsonProperty("startedTime")
    private String startedTime;
    @JsonProperty("state")
    private String state;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public UpdateHistory() {
    }

    public UpdateHistory(String acceptedRisks, String completionTime, String image, String startedTime, String state, Boolean verified, String version) {
        super();
        this.acceptedRisks = acceptedRisks;
        this.completionTime = completionTime;
        this.image = image;
        this.startedTime = startedTime;
        this.state = state;
        this.verified = verified;
        this.version = version;
    }

    /**
     * acceptedRisks records risks which were accepted to initiate the update. For example, it may menition an Upgradeable=False or missing signature that was overriden via desiredUpdate.force, or an update that was initiated despite not being in the availableUpdates set of recommended update targets.
     */
    @JsonProperty("acceptedRisks")
    public String getAcceptedRisks() {
        return acceptedRisks;
    }

    /**
     * acceptedRisks records risks which were accepted to initiate the update. For example, it may menition an Upgradeable=False or missing signature that was overriden via desiredUpdate.force, or an update that was initiated despite not being in the availableUpdates set of recommended update targets.
     */
    @JsonProperty("acceptedRisks")
    public void setAcceptedRisks(String acceptedRisks) {
        this.acceptedRisks = acceptedRisks;
    }

    /**
     * UpdateHistory is a single attempted update to the cluster.
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * UpdateHistory is a single attempted update to the cluster.
     */
    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * image is a container image location that contains the update. This value is always populated.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is a container image location that contains the update. This value is always populated.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * UpdateHistory is a single attempted update to the cluster.
     */
    @JsonProperty("startedTime")
    public String getStartedTime() {
        return startedTime;
    }

    /**
     * UpdateHistory is a single attempted update to the cluster.
     */
    @JsonProperty("startedTime")
    public void setStartedTime(String startedTime) {
        this.startedTime = startedTime;
    }

    /**
     * state reflects whether the update was fully applied. The Partial state indicates the update is not fully applied, while the Completed state indicates the update was successfully rolled out at least once (all parts of the update successfully applied).
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state reflects whether the update was fully applied. The Partial state indicates the update is not fully applied, while the Completed state indicates the update was successfully rolled out at least once (all parts of the update successfully applied).
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * verified indicates whether the provided update was properly verified before it was installed. If this is false the cluster may not be trusted. Verified does not cover upgradeable checks that depend on the cluster state at the time when the update target was accepted.
     */
    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    /**
     * verified indicates whether the provided update was properly verified before it was installed. If this is false the cluster may not be trusted. Verified does not cover upgradeable checks that depend on the cluster state at the time when the update target was accepted.
     */
    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    /**
     * version is a semantic version identifying the update version. If the requested image does not define a version, or if a failure occurs retrieving the image, this value may be empty.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is a semantic version identifying the update version. If the requested image does not define a version, or if a failure occurs retrieving the image, this value may be empty.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public UpdateHistoryBuilder edit() {
        return new UpdateHistoryBuilder(this);
    }

    @JsonIgnore
    public UpdateHistoryBuilder toBuilder() {
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
        if (!(o instanceof UpdateHistory)) {
            return false;
        }
        UpdateHistory other = (UpdateHistory) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$acceptedRisks = this.getAcceptedRisks();
        Object other$acceptedRisks = other.getAcceptedRisks();
        if (this$acceptedRisks == null ? other$acceptedRisks != null : !this$acceptedRisks.equals(other$acceptedRisks)) {
            return false;
        }
        Object this$completionTime = this.getCompletionTime();
        Object other$completionTime = other.getCompletionTime();
        if (this$completionTime == null ? other$completionTime != null : !this$completionTime.equals(other$completionTime)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$startedTime = this.getStartedTime();
        Object other$startedTime = other.getStartedTime();
        if (this$startedTime == null ? other$startedTime != null : !this$startedTime.equals(other$startedTime)) {
            return false;
        }
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
            return false;
        }
        Object this$verified = this.getVerified();
        Object other$verified = other.getVerified();
        if (this$verified == null ? other$verified != null : !this$verified.equals(other$verified)) {
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
        return other instanceof UpdateHistory;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $acceptedRisks = this.getAcceptedRisks();
        result = result * prime + ($acceptedRisks == null ? 43 : $acceptedRisks.hashCode());
        Object $completionTime = this.getCompletionTime();
        result = result * prime + ($completionTime == null ? 43 : $completionTime.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $startedTime = this.getStartedTime();
        result = result * prime + ($startedTime == null ? 43 : $startedTime.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $verified = this.getVerified();
        result = result * prime + ($verified == null ? 43 : $verified.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "UpdateHistory(" + "acceptedRisks=" + this.getAcceptedRisks() + ", completionTime=" + this.getCompletionTime() + ", image=" + this.getImage() + ", startedTime=" + this.getStartedTime() + ", state=" + this.getState() + ", verified=" + this.getVerified() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
