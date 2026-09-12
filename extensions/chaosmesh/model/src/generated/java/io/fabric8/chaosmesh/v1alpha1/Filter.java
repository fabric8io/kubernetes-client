
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

/**
 * Filter represents a filter of IOChaos action, which will define the scope of an IOChaosAction
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "methods",
    "path",
    "percent"
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
public class Filter implements Editable<FilterBuilder>, KubernetesResource
{

    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> methods = new ArrayList<>();
    @JsonProperty("path")
    private String path;
    @JsonProperty("percent")
    private Integer percent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Filter() {
    }

    public Filter(List<String> methods, String path, Integer percent) {
        super();
        this.methods = methods;
        this.path = path;
        this.percent = percent;
    }

    /**
     * Methods represents the method that the action will inject in
     */
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMethods() {
        return methods;
    }

    /**
     * Methods represents the method that the action will inject in
     */
    @JsonProperty("methods")
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    /**
     * Path represents a glob of injecting path
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path represents a glob of injecting path
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Percent represents the percent probability of injecting this action
     */
    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    /**
     * Percent represents the percent probability of injecting this action
     */
    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @JsonIgnore
    public FilterBuilder edit() {
        return new FilterBuilder(this);
    }

    @JsonIgnore
    public FilterBuilder toBuilder() {
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
        if (!(o instanceof Filter)) {
            return false;
        }
        Filter other = (Filter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$methods = this.getMethods();
        Object other$methods = other.getMethods();
        if (this$methods == null ? other$methods != null : !this$methods.equals(other$methods)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$percent = this.getPercent();
        Object other$percent = other.getPercent();
        if (this$percent == null ? other$percent != null : !this$percent.equals(other$percent)) {
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
        return other instanceof Filter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $methods = this.getMethods();
        result = result * prime + ($methods == null ? 43 : $methods.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $percent = this.getPercent();
        result = result * prime + ($percent == null ? 43 : $percent.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Filter(" + "methods=" + this.getMethods() + ", path=" + this.getPath() + ", percent=" + this.getPercent() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
