
package io.fabric8.openshift.api.model.machineconfiguration.v1;

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
import io.fabric8.kubernetes.api.model.Condition;
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

/**
 * MachineOSBuildStatus describes the state of a build and other helpful information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildEnd",
    "buildStart",
    "builder",
    "conditions",
    "digestedImagePushSpec",
    "relatedObjects"
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
public class MachineOSBuildStatus implements Editable<MachineOSBuildStatusBuilder>, KubernetesResource
{

    @JsonProperty("buildEnd")
    private String buildEnd;
    @JsonProperty("buildStart")
    private String buildStart;
    @JsonProperty("builder")
    private MachineOSBuilderReference builder;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("digestedImagePushSpec")
    private String digestedImagePushSpec;
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> relatedObjects = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineOSBuildStatus() {
    }

    public MachineOSBuildStatus(String buildEnd, String buildStart, MachineOSBuilderReference builder, List<Condition> conditions, String digestedImagePushSpec, List<ObjectReference> relatedObjects) {
        super();
        this.buildEnd = buildEnd;
        this.buildStart = buildStart;
        this.builder = builder;
        this.conditions = conditions;
        this.digestedImagePushSpec = digestedImagePushSpec;
        this.relatedObjects = relatedObjects;
    }

    /**
     * MachineOSBuildStatus describes the state of a build and other helpful information.
     */
    @JsonProperty("buildEnd")
    public String getBuildEnd() {
        return buildEnd;
    }

    /**
     * MachineOSBuildStatus describes the state of a build and other helpful information.
     */
    @JsonProperty("buildEnd")
    public void setBuildEnd(String buildEnd) {
        this.buildEnd = buildEnd;
    }

    /**
     * MachineOSBuildStatus describes the state of a build and other helpful information.
     */
    @JsonProperty("buildStart")
    public String getBuildStart() {
        return buildStart;
    }

    /**
     * MachineOSBuildStatus describes the state of a build and other helpful information.
     */
    @JsonProperty("buildStart")
    public void setBuildStart(String buildStart) {
        this.buildStart = buildStart;
    }

    /**
     * MachineOSBuildStatus describes the state of a build and other helpful information.
     */
    @JsonProperty("builder")
    public MachineOSBuilderReference getBuilder() {
        return builder;
    }

    /**
     * MachineOSBuildStatus describes the state of a build and other helpful information.
     */
    @JsonProperty("builder")
    public void setBuilder(MachineOSBuilderReference builder) {
        this.builder = builder;
    }

    /**
     * conditions are state related conditions for the build. Valid types are: Prepared, Building, Failed, Interrupted, and Succeeded. Once a Build is marked as Failed, Interrupted or Succeeded, no future conditions can be set.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions are state related conditions for the build. Valid types are: Prepared, Building, Failed, Interrupted, and Succeeded. Once a Build is marked as Failed, Interrupted or Succeeded, no future conditions can be set.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * digestedImagePushSpec describes the fully qualified push spec produced by this build. The format of the push spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("digestedImagePushSpec")
    public String getDigestedImagePushSpec() {
        return digestedImagePushSpec;
    }

    /**
     * digestedImagePushSpec describes the fully qualified push spec produced by this build. The format of the push spec is: host[:port][/namespace]/name@sha256:&lt;digest&gt;, where the digest must be 64 characters long, and consist only of lowercase hexadecimal characters, a-f and 0-9. The length of the whole spec must be between 1 to 447 characters.
     */
    @JsonProperty("digestedImagePushSpec")
    public void setDigestedImagePushSpec(String digestedImagePushSpec) {
        this.digestedImagePushSpec = digestedImagePushSpec;
    }

    /**
     * relatedObjects is a list of references to ephemeral objects such as ConfigMaps or Secrets that are meant to be consumed while the build process runs. After a successful build or when this MachineOSBuild is deleted, these ephemeral objects will be removed. In the event of a failed build, the objects will remain until the build is removed to allow for inspection.
     */
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getRelatedObjects() {
        return relatedObjects;
    }

    /**
     * relatedObjects is a list of references to ephemeral objects such as ConfigMaps or Secrets that are meant to be consumed while the build process runs. After a successful build or when this MachineOSBuild is deleted, these ephemeral objects will be removed. In the event of a failed build, the objects will remain until the build is removed to allow for inspection.
     */
    @JsonProperty("relatedObjects")
    public void setRelatedObjects(List<ObjectReference> relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    @JsonIgnore
    public MachineOSBuildStatusBuilder edit() {
        return new MachineOSBuildStatusBuilder(this);
    }

    @JsonIgnore
    public MachineOSBuildStatusBuilder toBuilder() {
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
