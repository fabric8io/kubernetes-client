
package io.fabric8.openshift.api.model.console.v1;

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

/**
 * ConsoleQuickStartTask is a single step in a Quick Start.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "review",
    "summary",
    "title"
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
public class ConsoleQuickStartTask implements Editable<ConsoleQuickStartTaskBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("review")
    private ConsoleQuickStartTaskReview review;
    @JsonProperty("summary")
    private ConsoleQuickStartTaskSummary summary;
    @JsonProperty("title")
    private String title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleQuickStartTask() {
    }

    public ConsoleQuickStartTask(String description, ConsoleQuickStartTaskReview review, ConsoleQuickStartTaskSummary summary, String title) {
        super();
        this.description = description;
        this.review = review;
        this.summary = summary;
        this.title = title;
    }

    /**
     * description describes the steps needed to complete the task. (includes markdown)
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description describes the steps needed to complete the task. (includes markdown)
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * ConsoleQuickStartTask is a single step in a Quick Start.
     */
    @JsonProperty("review")
    public ConsoleQuickStartTaskReview getReview() {
        return review;
    }

    /**
     * ConsoleQuickStartTask is a single step in a Quick Start.
     */
    @JsonProperty("review")
    public void setReview(ConsoleQuickStartTaskReview review) {
        this.review = review;
    }

    /**
     * ConsoleQuickStartTask is a single step in a Quick Start.
     */
    @JsonProperty("summary")
    public ConsoleQuickStartTaskSummary getSummary() {
        return summary;
    }

    /**
     * ConsoleQuickStartTask is a single step in a Quick Start.
     */
    @JsonProperty("summary")
    public void setSummary(ConsoleQuickStartTaskSummary summary) {
        this.summary = summary;
    }

    /**
     * title describes the task and is displayed as a step heading.
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * title describes the task and is displayed as a step heading.
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonIgnore
    public ConsoleQuickStartTaskBuilder edit() {
        return new ConsoleQuickStartTaskBuilder(this);
    }

    @JsonIgnore
    public ConsoleQuickStartTaskBuilder toBuilder() {
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
        if (!(o instanceof ConsoleQuickStartTask)) {
            return false;
        }
        ConsoleQuickStartTask other = (ConsoleQuickStartTask) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$review = this.getReview();
        Object other$review = other.getReview();
        if (this$review == null ? other$review != null : !this$review.equals(other$review)) {
            return false;
        }
        Object this$summary = this.getSummary();
        Object other$summary = other.getSummary();
        if (this$summary == null ? other$summary != null : !this$summary.equals(other$summary)) {
            return false;
        }
        Object this$title = this.getTitle();
        Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
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
        return other instanceof ConsoleQuickStartTask;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $review = this.getReview();
        result = result * prime + ($review == null ? 43 : $review.hashCode());
        Object $summary = this.getSummary();
        result = result * prime + ($summary == null ? 43 : $summary.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleQuickStartTask(" + "description=" + this.getDescription() + ", review=" + this.getReview() + ", summary=" + this.getSummary() + ", title=" + this.getTitle() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
