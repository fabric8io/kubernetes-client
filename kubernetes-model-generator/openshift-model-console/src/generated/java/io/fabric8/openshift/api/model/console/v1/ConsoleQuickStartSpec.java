
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConsoleQuickStartSpec)) {
            return false;
        }
        ConsoleQuickStartSpec other = (ConsoleQuickStartSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessReviewResources = this.getAccessReviewResources();
        Object other$accessReviewResources = other.getAccessReviewResources();
        if (this$accessReviewResources == null ? other$accessReviewResources != null : !this$accessReviewResources.equals(other$accessReviewResources)) {
            return false;
        }
        Object this$conclusion = this.getConclusion();
        Object other$conclusion = other.getConclusion();
        if (this$conclusion == null ? other$conclusion != null : !this$conclusion.equals(other$conclusion)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$durationMinutes = this.getDurationMinutes();
        Object other$durationMinutes = other.getDurationMinutes();
        if (this$durationMinutes == null ? other$durationMinutes != null : !this$durationMinutes.equals(other$durationMinutes)) {
            return false;
        }
        Object this$icon = this.getIcon();
        Object other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) {
            return false;
        }
        Object this$introduction = this.getIntroduction();
        Object other$introduction = other.getIntroduction();
        if (this$introduction == null ? other$introduction != null : !this$introduction.equals(other$introduction)) {
            return false;
        }
        Object this$nextQuickStart = this.getNextQuickStart();
        Object other$nextQuickStart = other.getNextQuickStart();
        if (this$nextQuickStart == null ? other$nextQuickStart != null : !this$nextQuickStart.equals(other$nextQuickStart)) {
            return false;
        }
        Object this$prerequisites = this.getPrerequisites();
        Object other$prerequisites = other.getPrerequisites();
        if (this$prerequisites == null ? other$prerequisites != null : !this$prerequisites.equals(other$prerequisites)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$tasks = this.getTasks();
        Object other$tasks = other.getTasks();
        if (this$tasks == null ? other$tasks != null : !this$tasks.equals(other$tasks)) {
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
        return other instanceof ConsoleQuickStartSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessReviewResources = this.getAccessReviewResources();
        result = result * prime + ($accessReviewResources == null ? 43 : $accessReviewResources.hashCode());
        Object $conclusion = this.getConclusion();
        result = result * prime + ($conclusion == null ? 43 : $conclusion.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $durationMinutes = this.getDurationMinutes();
        result = result * prime + ($durationMinutes == null ? 43 : $durationMinutes.hashCode());
        Object $icon = this.getIcon();
        result = result * prime + ($icon == null ? 43 : $icon.hashCode());
        Object $introduction = this.getIntroduction();
        result = result * prime + ($introduction == null ? 43 : $introduction.hashCode());
        Object $nextQuickStart = this.getNextQuickStart();
        result = result * prime + ($nextQuickStart == null ? 43 : $nextQuickStart.hashCode());
        Object $prerequisites = this.getPrerequisites();
        result = result * prime + ($prerequisites == null ? 43 : $prerequisites.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $tasks = this.getTasks();
        result = result * prime + ($tasks == null ? 43 : $tasks.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleQuickStartSpec(" + "accessReviewResources=" + this.getAccessReviewResources() + ", conclusion=" + this.getConclusion() + ", description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", durationMinutes=" + this.getDurationMinutes() + ", icon=" + this.getIcon() + ", introduction=" + this.getIntroduction() + ", nextQuickStart=" + this.getNextQuickStart() + ", prerequisites=" + this.getPrerequisites() + ", tags=" + this.getTags() + ", tasks=" + this.getTasks() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
