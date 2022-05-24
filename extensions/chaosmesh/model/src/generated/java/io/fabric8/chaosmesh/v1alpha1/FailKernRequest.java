
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    "callchain",
    "failtype",
    "headers",
    "probability",
    "times"
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
public class FailKernRequest implements KubernetesResource
{

    @JsonProperty("callchain")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Frame> callchain = new ArrayList<Frame>();
    @JsonProperty("failtype")
    private Integer failtype;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> headers = new ArrayList<String>();
    @JsonProperty("probability")
    private Integer probability;
    @JsonProperty("times")
    private Integer times;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public FailKernRequest() {
    }

    /**
     * 
     * @param failtype
     * @param headers
     * @param times
     * @param probability
     * @param callchain
     */
    public FailKernRequest(List<Frame> callchain, Integer failtype, List<String> headers, Integer probability, Integer times) {
        super();
        this.callchain = callchain;
        this.failtype = failtype;
        this.headers = headers;
        this.probability = probability;
        this.times = times;
    }

    @JsonProperty("callchain")
    public List<Frame> getCallchain() {
        return callchain;
    }

    @JsonProperty("callchain")
    public void setCallchain(List<Frame> callchain) {
        this.callchain = callchain;
    }

    @JsonProperty("failtype")
    public Integer getFailtype() {
        return failtype;
    }

    @JsonProperty("failtype")
    public void setFailtype(Integer failtype) {
        this.failtype = failtype;
    }

    @JsonProperty("headers")
    public List<String> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    @JsonProperty("probability")
    public Integer getProbability() {
        return probability;
    }

    @JsonProperty("probability")
    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    @JsonProperty("times")
    public Integer getTimes() {
        return times;
    }

    @JsonProperty("times")
    public void setTimes(Integer times) {
        this.times = times;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
