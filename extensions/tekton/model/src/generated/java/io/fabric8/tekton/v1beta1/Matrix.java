
package io.fabric8.tekton.v1beta1;

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
 * Matrix is used to fan out Tasks in a Pipeline
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "include",
    "params"
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
public class Matrix implements Editable<MatrixBuilder>, KubernetesResource
{

    @JsonProperty("include")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IncludeParams> include = new ArrayList<>();
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Matrix() {
    }

    public Matrix(List<IncludeParams> include, List<Param> params) {
        super();
        this.include = include;
        this.params = params;
    }

    /**
     * Include is a list of IncludeParams which allows passing in specific combinations of Parameters into the Matrix.
     */
    @JsonProperty("include")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IncludeParams> getInclude() {
        return include;
    }

    /**
     * Include is a list of IncludeParams which allows passing in specific combinations of Parameters into the Matrix.
     */
    @JsonProperty("include")
    public void setInclude(List<IncludeParams> include) {
        this.include = include;
    }

    /**
     * Params is a list of parameters used to fan out the pipelineTask Params takes only `Parameters` of type `"array"` Each array element is supplied to the `PipelineTask` by substituting `params` of type `"string"` in the underlying `Task`. The names of the `params` in the `Matrix` must match the names of the `params` in the underlying `Task` that they will be substituting.
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Param> getParams() {
        return params;
    }

    /**
     * Params is a list of parameters used to fan out the pipelineTask Params takes only `Parameters` of type `"array"` Each array element is supplied to the `PipelineTask` by substituting `params` of type `"string"` in the underlying `Task`. The names of the `params` in the `Matrix` must match the names of the `params` in the underlying `Task` that they will be substituting.
     */
    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    @JsonIgnore
    public MatrixBuilder edit() {
        return new MatrixBuilder(this);
    }

    @JsonIgnore
    public MatrixBuilder toBuilder() {
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
        if (!(o instanceof Matrix)) {
            return false;
        }
        Matrix other = (Matrix) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$include = this.getInclude();
        Object other$include = other.getInclude();
        if (this$include == null ? other$include != null : !this$include.equals(other$include)) {
            return false;
        }
        Object this$params = this.getParams();
        Object other$params = other.getParams();
        if (this$params == null ? other$params != null : !this$params.equals(other$params)) {
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
        return other instanceof Matrix;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $include = this.getInclude();
        result = result * prime + ($include == null ? 43 : $include.hashCode());
        Object $params = this.getParams();
        result = result * prime + ($params == null ? 43 : $params.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Matrix(" + "include=" + this.getInclude() + ", params=" + this.getParams() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
