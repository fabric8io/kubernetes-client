
package io.fabric8.chaosmesh.v1alpha1;

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
 * Frame defines the function signature and predicate in function's body
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "funcname",
    "parameters",
    "predicate"
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
public class Frame implements Editable<FrameBuilder>, KubernetesResource
{

    @JsonProperty("funcname")
    private String funcname;
    @JsonProperty("parameters")
    private String parameters;
    @JsonProperty("predicate")
    private String predicate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Frame() {
    }

    public Frame(String funcname, String parameters, String predicate) {
        super();
        this.funcname = funcname;
        this.parameters = parameters;
        this.predicate = predicate;
    }

    /**
     * Funcname can be find from kernel source or `/proc/kallsyms`, such as `ext4_mount`
     */
    @JsonProperty("funcname")
    public String getFuncname() {
        return funcname;
    }

    /**
     * Funcname can be find from kernel source or `/proc/kallsyms`, such as `ext4_mount`
     */
    @JsonProperty("funcname")
    public void setFuncname(String funcname) {
        this.funcname = funcname;
    }

    /**
     * Parameters is used with predicate, for example, if you want to inject slab error in `d_alloc_parallel(struct dentry &#42;parent, const struct qstr &#42;name)` with a special name `bananas`, you need to set it to `struct dentry &#42;parent, const struct qstr &#42;name` otherwise omit it.
     */
    @JsonProperty("parameters")
    public String getParameters() {
        return parameters;
    }

    /**
     * Parameters is used with predicate, for example, if you want to inject slab error in `d_alloc_parallel(struct dentry &#42;parent, const struct qstr &#42;name)` with a special name `bananas`, you need to set it to `struct dentry &#42;parent, const struct qstr &#42;name` otherwise omit it.
     */
    @JsonProperty("parameters")
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    /**
     * Predicate will access the arguments of this Frame, example with Parameters's, you can set it to `STRNCMP(name-&gt;name, "bananas", 8)` to make inject only with it, or omit it to inject for all d_alloc_parallel call chain.
     */
    @JsonProperty("predicate")
    public String getPredicate() {
        return predicate;
    }

    /**
     * Predicate will access the arguments of this Frame, example with Parameters's, you can set it to `STRNCMP(name-&gt;name, "bananas", 8)` to make inject only with it, or omit it to inject for all d_alloc_parallel call chain.
     */
    @JsonProperty("predicate")
    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    @JsonIgnore
    public FrameBuilder edit() {
        return new FrameBuilder(this);
    }

    @JsonIgnore
    public FrameBuilder toBuilder() {
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
        if (!(o instanceof Frame)) {
            return false;
        }
        Frame other = (Frame) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$funcname = this.getFuncname();
        Object other$funcname = other.getFuncname();
        if (this$funcname == null ? other$funcname != null : !this$funcname.equals(other$funcname)) {
            return false;
        }
        Object this$parameters = this.getParameters();
        Object other$parameters = other.getParameters();
        if (this$parameters == null ? other$parameters != null : !this$parameters.equals(other$parameters)) {
            return false;
        }
        Object this$predicate = this.getPredicate();
        Object other$predicate = other.getPredicate();
        if (this$predicate == null ? other$predicate != null : !this$predicate.equals(other$predicate)) {
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
        return other instanceof Frame;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $funcname = this.getFuncname();
        result = result * prime + ($funcname == null ? 43 : $funcname.hashCode());
        Object $parameters = this.getParameters();
        result = result * prime + ($parameters == null ? 43 : $parameters.hashCode());
        Object $predicate = this.getPredicate();
        result = result * prime + ($predicate == null ? 43 : $predicate.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Frame(" + "funcname=" + this.getFuncname() + ", parameters=" + this.getParameters() + ", predicate=" + this.getPredicate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
