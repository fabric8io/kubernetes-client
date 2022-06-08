
package io.fabric8.camelk.v1alpha1;

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
import io.fabric8.camelk.v1.IntegrationSpec;
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
    "errorHandler",
    "integration",
    "replicas",
    "sink",
    "source",
    "steps"
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
public class KameletBindingSpec implements KubernetesResource
{

    @JsonProperty("errorHandler")
    private ErrorHandlerSpec errorHandler;
    @JsonProperty("integration")
    private IntegrationSpec integration;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("sink")
    private Endpoint sink;
    @JsonProperty("source")
    private Endpoint source;
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Endpoint> steps = new ArrayList<Endpoint>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KameletBindingSpec() {
    }

    /**
     * 
     * @param replicas
     * @param sink
     * @param integration
     * @param errorHandler
     * @param source
     * @param steps
     */
    public KameletBindingSpec(ErrorHandlerSpec errorHandler, IntegrationSpec integration, Integer replicas, Endpoint sink, Endpoint source, List<Endpoint> steps) {
        super();
        this.errorHandler = errorHandler;
        this.integration = integration;
        this.replicas = replicas;
        this.sink = sink;
        this.source = source;
        this.steps = steps;
    }

    @JsonProperty("errorHandler")
    public ErrorHandlerSpec getErrorHandler() {
        return errorHandler;
    }

    @JsonProperty("errorHandler")
    public void setErrorHandler(ErrorHandlerSpec errorHandler) {
        this.errorHandler = errorHandler;
    }

    @JsonProperty("integration")
    public IntegrationSpec getIntegration() {
        return integration;
    }

    @JsonProperty("integration")
    public void setIntegration(IntegrationSpec integration) {
        this.integration = integration;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("sink")
    public Endpoint getSink() {
        return sink;
    }

    @JsonProperty("sink")
    public void setSink(Endpoint sink) {
        this.sink = sink;
    }

    @JsonProperty("source")
    public Endpoint getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Endpoint source) {
        this.source = source;
    }

    @JsonProperty("steps")
    public List<Endpoint> getSteps() {
        return steps;
    }

    @JsonProperty("steps")
    public void setSteps(List<Endpoint> steps) {
        this.steps = steps;
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
