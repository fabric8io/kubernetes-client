
package io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "ArrayVal",
    "ObjectVal",
    "StringVal",
    "Type"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class ParamValue implements KubernetesResource
{

    @JsonProperty("ArrayVal")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> arrayVal = new ArrayList<java.lang.String>();
    @JsonProperty("ObjectVal")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> objectVal = new LinkedHashMap<String, String>();
    @JsonProperty("StringVal")
    private java.lang.String stringVal;
    @JsonProperty("Type")
    private java.lang.String type;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ParamValue() {
    }

    public ParamValue(List<java.lang.String> arrayVal, Map<String, String> objectVal, java.lang.String stringVal, java.lang.String type) {
        super();
        this.arrayVal = arrayVal;
        this.objectVal = objectVal;
        this.stringVal = stringVal;
        this.type = type;
    }

    @JsonProperty("ArrayVal")
    public List<java.lang.String> getArrayVal() {
        return arrayVal;
    }

    @JsonProperty("ArrayVal")
    public void setArrayVal(List<java.lang.String> arrayVal) {
        this.arrayVal = arrayVal;
    }

    @JsonProperty("ObjectVal")
    public Map<String, String> getObjectVal() {
        return objectVal;
    }

    @JsonProperty("ObjectVal")
    public void setObjectVal(Map<String, String> objectVal) {
        this.objectVal = objectVal;
    }

    @JsonProperty("StringVal")
    public java.lang.String getStringVal() {
        return stringVal;
    }

    @JsonProperty("StringVal")
    public void setStringVal(java.lang.String stringVal) {
        this.stringVal = stringVal;
    }

    @JsonProperty("Type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(java.lang.String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
