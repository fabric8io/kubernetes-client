
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
