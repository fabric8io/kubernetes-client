
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * Update represents an administrator update request.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceptRisks",
    "architecture",
    "force",
    "image",
    "mode",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Update implements Editable<UpdateBuilder>, KubernetesResource
{

    @JsonProperty("acceptRisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AcceptRisk> acceptRisks = new ArrayList<>();
    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("force")
    private Boolean force;
    @JsonProperty("image")
    private String image;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Update() {
    }

    public Update(List<AcceptRisk> acceptRisks, String architecture, Boolean force, String image, String mode, String version) {
        super();
        this.acceptRisks = acceptRisks;
        this.architecture = architecture;
        this.force = force;
        this.image = image;
        this.mode = mode;
        this.version = version;
    }

    /**
     * acceptRisks is an optional set of names of conditional update risks that are considered acceptable. A conditional update is performed only if all of its risks are acceptable. This list may contain entries that apply to current, previous or future updates. The entries therefore may not map directly to a risk in .status.conditionalUpdateRisks. acceptRisks must not contain more than 1000 entries. Entries in this list must be unique.
     */
    @JsonProperty("acceptRisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AcceptRisk> getAcceptRisks() {
        return acceptRisks;
    }

    /**
     * acceptRisks is an optional set of names of conditional update risks that are considered acceptable. A conditional update is performed only if all of its risks are acceptable. This list may contain entries that apply to current, previous or future updates. The entries therefore may not map directly to a risk in .status.conditionalUpdateRisks. acceptRisks must not contain more than 1000 entries. Entries in this list must be unique.
     */
    @JsonProperty("acceptRisks")
    public void setAcceptRisks(List<AcceptRisk> acceptRisks) {
        this.acceptRisks = acceptRisks;
    }

    /**
     * architecture is an optional field that indicates the desired value of the cluster architecture. In this context cluster architecture means either a single architecture or a multi architecture. architecture can only be set to Multi thereby only allowing updates from single to multi architecture. If architecture is set, image cannot be set and version must be set. Valid values are 'Multi' and empty.
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * architecture is an optional field that indicates the desired value of the cluster architecture. In this context cluster architecture means either a single architecture or a multi architecture. architecture can only be set to Multi thereby only allowing updates from single to multi architecture. If architecture is set, image cannot be set and version must be set. Valid values are 'Multi' and empty.
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * force allows an administrator to update to an image that has failed verification or upgradeable checks that are designed to keep your cluster safe. Only use this if: &#42; you are testing unsigned release images in short-lived test clusters or &#42; you are working around a known bug in the cluster-version<br><p>   operator and you have verified the authenticity of the provided<br><p>   image yourself.<br><p> The provided image will run with full administrative access to the cluster. Do not use this flag with images that come from unknown or potentially malicious sources.
     */
    @JsonProperty("force")
    public Boolean getForce() {
        return force;
    }

    /**
     * force allows an administrator to update to an image that has failed verification or upgradeable checks that are designed to keep your cluster safe. Only use this if: &#42; you are testing unsigned release images in short-lived test clusters or &#42; you are working around a known bug in the cluster-version<br><p>   operator and you have verified the authenticity of the provided<br><p>   image yourself.<br><p> The provided image will run with full administrative access to the cluster. Do not use this flag with images that come from unknown or potentially malicious sources.
     */
    @JsonProperty("force")
    public void setForce(Boolean force) {
        this.force = force;
    }

    /**
     * image is a container image location that contains the update. image should be used when the desired version does not exist in availableUpdates or history. When image is set, architecture cannot be specified. If both version and image are set, the version extracted from the referenced image must match the specified version.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is a container image location that contains the update. image should be used when the desired version does not exist in availableUpdates or history. When image is set, architecture cannot be specified. If both version and image are set, the version extracted from the referenced image must match the specified version.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * mode determines how an update should be processed. The only valid value is "Preflight". When omitted, the cluster performs a normal update by applying the specified version or image to the cluster. This is the standard update behavior. When set to "Preflight", the cluster runs compatibility checks against the target release without performing an actual update. Compatibility results, including any detected risks, are reported in status.conditionalUpdates and status.conditionalUpdateRisks alongside risks from the update recommendation service. This allows administrators to assess update readiness and address issues before committing to the update. Preflight mode is particularly useful for skip-level updates where upgrade compatibility needs to be verified across multiple minor versions. When mode is set to "Preflight", the same rules for version, image, and architecture apply as for normal updates.<br><p> <br><p> Possible enum values:<br><p>  - `"Preflight"` allows an update to be checked for compatibility without committing to updating the cluster.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode determines how an update should be processed. The only valid value is "Preflight". When omitted, the cluster performs a normal update by applying the specified version or image to the cluster. This is the standard update behavior. When set to "Preflight", the cluster runs compatibility checks against the target release without performing an actual update. Compatibility results, including any detected risks, are reported in status.conditionalUpdates and status.conditionalUpdateRisks alongside risks from the update recommendation service. This allows administrators to assess update readiness and address issues before committing to the update. Preflight mode is particularly useful for skip-level updates where upgrade compatibility needs to be verified across multiple minor versions. When mode is set to "Preflight", the same rules for version, image, and architecture apply as for normal updates.<br><p> <br><p> Possible enum values:<br><p>  - `"Preflight"` allows an update to be checked for compatibility without committing to updating the cluster.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * version is a semantic version identifying the update version. version is required if architecture is specified. If both version and image are set, the version extracted from the referenced image must match the specified version.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is a semantic version identifying the update version. version is required if architecture is specified. If both version and image are set, the version extracted from the referenced image must match the specified version.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public UpdateBuilder edit() {
        return new UpdateBuilder(this);
    }

    @JsonIgnore
    public UpdateBuilder toBuilder() {
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
