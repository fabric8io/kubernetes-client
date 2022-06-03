
package io.fabric8.camelk.v1;

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
    "consumer",
    "http",
    "id",
    "passive",
    "producer"
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
public class CamelScheme implements KubernetesResource
{

    @JsonProperty("consumer")
    private CamelSchemeScope consumer;
    @JsonProperty("http")
    private Boolean http;
    @JsonProperty("id")
    private String id;
    @JsonProperty("passive")
    private Boolean passive;
    @JsonProperty("producer")
    private CamelSchemeScope producer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CamelScheme() {
    }

    /**
     * 
     * @param http
     * @param producer
     * @param id
     * @param passive
     * @param consumer
     */
    public CamelScheme(CamelSchemeScope consumer, Boolean http, String id, Boolean passive, CamelSchemeScope producer) {
        super();
        this.consumer = consumer;
        this.http = http;
        this.id = id;
        this.passive = passive;
        this.producer = producer;
    }

    @JsonProperty("consumer")
    public CamelSchemeScope getConsumer() {
        return consumer;
    }

    @JsonProperty("consumer")
    public void setConsumer(CamelSchemeScope consumer) {
        this.consumer = consumer;
    }

    @JsonProperty("http")
    public Boolean getHttp() {
        return http;
    }

    @JsonProperty("http")
    public void setHttp(Boolean http) {
        this.http = http;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("passive")
    public Boolean getPassive() {
        return passive;
    }

    @JsonProperty("passive")
    public void setPassive(Boolean passive) {
        this.passive = passive;
    }

    @JsonProperty("producer")
    public CamelSchemeScope getProducer() {
        return producer;
    }

    @JsonProperty("producer")
    public void setProducer(CamelSchemeScope producer) {
        this.producer = producer;
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
