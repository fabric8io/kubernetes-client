
package io.fabric8.chaosmesh.v1alpha1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "entry",
    "templates"
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
public class WorkflowSpec implements Editable<WorkflowSpecBuilder>, KubernetesResource
{

    @JsonProperty("entry")
    private String entry;
    @JsonProperty("templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Template> templates = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkflowSpec() {
    }

    public WorkflowSpec(String entry, List<Template> templates) {
        super();
        this.entry = entry;
        this.templates = templates;
    }

    @JsonProperty("entry")
    public String getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(String entry) {
        this.entry = entry;
    }

    @JsonProperty("templates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Template> getTemplates() {
        return templates;
    }

    @JsonProperty("templates")
    public void setTemplates(List<Template> templates) {
        this.templates = templates;
    }

    @JsonIgnore
    public WorkflowSpecBuilder edit() {
        return new WorkflowSpecBuilder(this);
    }

    @JsonIgnore
    public WorkflowSpecBuilder toBuilder() {
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
        if (!(o instanceof WorkflowSpec)) {
            return false;
        }
        WorkflowSpec other = (WorkflowSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$entry = this.getEntry();
        Object other$entry = other.getEntry();
        if (this$entry == null ? other$entry != null : !this$entry.equals(other$entry)) {
            return false;
        }
        Object this$templates = this.getTemplates();
        Object other$templates = other.getTemplates();
        if (this$templates == null ? other$templates != null : !this$templates.equals(other$templates)) {
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
        return other instanceof WorkflowSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $entry = this.getEntry();
        result = result * prime + ($entry == null ? 43 : $entry.hashCode());
        Object $templates = this.getTemplates();
        result = result * prime + ($templates == null ? 43 : $templates.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WorkflowSpec(" + "entry=" + this.getEntry() + ", templates=" + this.getTemplates() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
