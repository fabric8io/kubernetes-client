
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
 * MachineOSBuildStatus describes the state of a build and other helpful information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildEnd",
    "buildStart",
    "builderReference",
    "conditions",
    "finalImagePullspec",
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
    @BuildableReference(ObjectReference.class),
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
    @JsonProperty("builderReference")
    private MachineOSBuilderReference builderReference;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("finalImagePullspec")
    private String finalImagePullspec;
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

    public MachineOSBuildStatus(String buildEnd, String buildStart, MachineOSBuilderReference builderReference, List<Condition> conditions, String finalImagePullspec, List<ObjectReference> relatedObjects) {
        super();
        this.buildEnd = buildEnd;
        this.buildStart = buildStart;
        this.builderReference = builderReference;
        this.conditions = conditions;
        this.finalImagePullspec = finalImagePullspec;
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
    @JsonProperty("builderReference")
    public MachineOSBuilderReference getBuilderReference() {
        return builderReference;
    }

    /**
     * MachineOSBuildStatus describes the state of a build and other helpful information.
     */
    @JsonProperty("builderReference")
    public void setBuilderReference(MachineOSBuilderReference builderReference) {
        this.builderReference = builderReference;
    }

    /**
     * conditions are state related conditions for the build. Valid types are: Prepared, Building, Failed, Interrupted, and Succeeded once a Build is marked as Failed, no future conditions can be set. This is enforced by the MCO.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions are state related conditions for the build. Valid types are: Prepared, Building, Failed, Interrupted, and Succeeded once a Build is marked as Failed, no future conditions can be set. This is enforced by the MCO.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * finalImagePushSpec describes the fully qualified pushspec produced by this build that the final image can be. Must be in sha format.
     */
    @JsonProperty("finalImagePullspec")
    public String getFinalImagePullspec() {
        return finalImagePullspec;
    }

    /**
     * finalImagePushSpec describes the fully qualified pushspec produced by this build that the final image can be. Must be in sha format.
     */
    @JsonProperty("finalImagePullspec")
    public void setFinalImagePullspec(String finalImagePullspec) {
        this.finalImagePullspec = finalImagePullspec;
    }

    /**
     * relatedObjects is a list of objects that are related to the build process.
     */
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getRelatedObjects() {
        return relatedObjects;
    }

    /**
     * relatedObjects is a list of objects that are related to the build process.
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
