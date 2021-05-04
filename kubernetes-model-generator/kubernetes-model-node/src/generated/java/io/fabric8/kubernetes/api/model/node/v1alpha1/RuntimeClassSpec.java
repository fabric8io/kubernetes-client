
package io.fabric8.kubernetes.api.model.node.v1alpha1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "overhead",
    "runtimeHandler",
    "scheduling"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class RuntimeClassSpec implements KubernetesResource
{

    @JsonProperty("overhead")
    private Overhead overhead;
    @JsonProperty("runtimeHandler")
    private String runtimeHandler;
    @JsonProperty("scheduling")
    private Scheduling scheduling;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RuntimeClassSpec() {
    }

    /**
     * 
     * @param overhead
     * @param scheduling
     * @param runtimeHandler
     */
    public RuntimeClassSpec(Overhead overhead, String runtimeHandler, Scheduling scheduling) {
        super();
        this.overhead = overhead;
        this.runtimeHandler = runtimeHandler;
        this.scheduling = scheduling;
    }

    @JsonProperty("overhead")
    public Overhead getOverhead() {
        return overhead;
    }

    @JsonProperty("overhead")
    public void setOverhead(Overhead overhead) {
        this.overhead = overhead;
    }

    @JsonProperty("runtimeHandler")
    public String getRuntimeHandler() {
        return runtimeHandler;
    }

    @JsonProperty("runtimeHandler")
    public void setRuntimeHandler(String runtimeHandler) {
        this.runtimeHandler = runtimeHandler;
    }

    @JsonProperty("scheduling")
    public Scheduling getScheduling() {
        return scheduling;
    }

    @JsonProperty("scheduling")
    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
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
