
package io.fabric8.openshift.api.model.console.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.authorization.v1.ResourceAttributes;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ConsoleQuickStartSpec is the desired quick start configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessReviewResources",
    "conclusion",
    "description",
    "displayName",
    "durationMinutes",
    "icon",
    "introduction",
    "nextQuickStart",
    "prerequisites",
    "tags",
    "tasks"
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
public class ConsoleQuickStartSpec implements Editable<ConsoleQuickStartSpecBuilder>, KubernetesResource
{

    @JsonProperty("accessReviewResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceAttributes> accessReviewResources = new ArrayList<>();
    @JsonProperty("conclusion")
    private String conclusion;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("durationMinutes")
    private Integer durationMinutes;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("introduction")
    private String introduction;
    @JsonProperty("nextQuickStart")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nextQuickStart = new ArrayList<>();
    @JsonProperty("prerequisites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> prerequisites = new ArrayList<>();
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("tasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConsoleQuickStartTask> tasks = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleQuickStartSpec() {
    }

    public ConsoleQuickStartSpec(List<ResourceAttributes> accessReviewResources, String conclusion, String description, String displayName, Integer durationMinutes, String icon, String introduction, List<String> nextQuickStart, List<String> prerequisites, List<String> tags, List<ConsoleQuickStartTask> tasks) {
        super();
        this.accessReviewResources = accessReviewResources;
        this.conclusion = conclusion;
        this.description = description;
        this.displayName = displayName;
        this.durationMinutes = durationMinutes;
        this.icon = icon;
        this.introduction = introduction;
        this.nextQuickStart = nextQuickStart;
        this.prerequisites = prerequisites;
        this.tags = tags;
        this.tasks = tasks;
    }

    /**
     * accessReviewResources contains a list of resources that the user's access will be reviewed against in order for the user to complete the Quick Start. The Quick Start will be hidden if any of the access reviews fail.
     */
    @JsonProperty("accessReviewResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceAttributes> getAccessReviewResources() {
        return accessReviewResources;
    }

    /**
     * accessReviewResources contains a list of resources that the user's access will be reviewed against in order for the user to complete the Quick Start. The Quick Start will be hidden if any of the access reviews fail.
     */
    @JsonProperty("accessReviewResources")
    public void setAccessReviewResources(List<ResourceAttributes> accessReviewResources) {
        this.accessReviewResources = accessReviewResources;
    }

    /**
     * conclusion sums up the Quick Start and suggests the possible next steps. (includes markdown)
     */
    @JsonProperty("conclusion")
    public String getConclusion() {
        return conclusion;
    }

    /**
     * conclusion sums up the Quick Start and suggests the possible next steps. (includes markdown)
     */
    @JsonProperty("conclusion")
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    /**
     * description is the description of the Quick Start. (includes markdown)
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description is the description of the Quick Start. (includes markdown)
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * displayName is the display name of the Quick Start.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * displayName is the display name of the Quick Start.
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * durationMinutes describes approximately how many minutes it will take to complete the Quick Start.
     */
    @JsonProperty("durationMinutes")
    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * durationMinutes describes approximately how many minutes it will take to complete the Quick Start.
     */
    @JsonProperty("durationMinutes")
    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    /**
     * icon is a base64 encoded image that will be displayed beside the Quick Start display name. The icon should be an vector image for easy scaling. The size of the icon should be 40x40.
     */
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    /**
     * icon is a base64 encoded image that will be displayed beside the Quick Start display name. The icon should be an vector image for easy scaling. The size of the icon should be 40x40.
     */
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * introduction describes the purpose of the Quick Start. (includes markdown)
     */
    @JsonProperty("introduction")
    public String getIntroduction() {
        return introduction;
    }

    /**
     * introduction describes the purpose of the Quick Start. (includes markdown)
     */
    @JsonProperty("introduction")
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * nextQuickStart is a list of the following Quick Starts, suggested for the user to try.
     */
    @JsonProperty("nextQuickStart")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNextQuickStart() {
        return nextQuickStart;
    }

    /**
     * nextQuickStart is a list of the following Quick Starts, suggested for the user to try.
     */
    @JsonProperty("nextQuickStart")
    public void setNextQuickStart(List<String> nextQuickStart) {
        this.nextQuickStart = nextQuickStart;
    }

    /**
     * prerequisites contains all prerequisites that need to be met before taking a Quick Start. (includes markdown)
     */
    @JsonProperty("prerequisites")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPrerequisites() {
        return prerequisites;
    }

    /**
     * prerequisites contains all prerequisites that need to be met before taking a Quick Start. (includes markdown)
     */
    @JsonProperty("prerequisites")
    public void setPrerequisites(List<String> prerequisites) {
        this.prerequisites = prerequisites;
    }

    /**
     * tags is a list of strings that describe the Quick Start.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * tags is a list of strings that describe the Quick Start.
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * tasks is the list of steps the user has to perform to complete the Quick Start.
     */
    @JsonProperty("tasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConsoleQuickStartTask> getTasks() {
        return tasks;
    }

    /**
     * tasks is the list of steps the user has to perform to complete the Quick Start.
     */
    @JsonProperty("tasks")
    public void setTasks(List<ConsoleQuickStartTask> tasks) {
        this.tasks = tasks;
    }

    @JsonIgnore
    public ConsoleQuickStartSpecBuilder edit() {
        return new ConsoleQuickStartSpecBuilder(this);
    }

    @JsonIgnore
    public ConsoleQuickStartSpecBuilder toBuilder() {
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
