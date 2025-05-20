
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceptContentTypes",
    "burst",
    "contentType",
    "qps"
})
@ToString
@EqualsAndHashCode
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClientConnectionOverrides implements Editable<ClientConnectionOverridesBuilder>, KubernetesResource
{

    @JsonProperty("acceptContentTypes")
    private String acceptContentTypes;
    @JsonProperty("burst")
    private Integer burst;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("qps")
    private Float qps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClientConnectionOverrides() {
    }

    public ClientConnectionOverrides(String acceptContentTypes, Integer burst, String contentType, Float qps) {
        super();
        this.acceptContentTypes = acceptContentTypes;
        this.burst = burst;
        this.contentType = contentType;
        this.qps = qps;
    }

    /**
     * acceptContentTypes defines the Accept header sent by clients when connecting to a server, overriding the default value of 'application/json'. This field will control all connections to the server used by a particular client.
     */
    @JsonProperty("acceptContentTypes")
    public String getAcceptContentTypes() {
        return acceptContentTypes;
    }

    /**
     * acceptContentTypes defines the Accept header sent by clients when connecting to a server, overriding the default value of 'application/json'. This field will control all connections to the server used by a particular client.
     */
    @JsonProperty("acceptContentTypes")
    public void setAcceptContentTypes(String acceptContentTypes) {
        this.acceptContentTypes = acceptContentTypes;
    }

    /**
     * burst allows extra queries to accumulate when a client is exceeding its rate.
     */
    @JsonProperty("burst")
    public Integer getBurst() {
        return burst;
    }

    /**
     * burst allows extra queries to accumulate when a client is exceeding its rate.
     */
    @JsonProperty("burst")
    public void setBurst(Integer burst) {
        this.burst = burst;
    }

    /**
     * contentType is the content type used when sending data to the server from this client.
     */
    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    /**
     * contentType is the content type used when sending data to the server from this client.
     */
    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * qps controls the number of queries per second allowed for this connection.
     */
    @JsonProperty("qps")
    public Float getQps() {
        return qps;
    }

    /**
     * qps controls the number of queries per second allowed for this connection.
     */
    @JsonProperty("qps")
    public void setQps(Float qps) {
        this.qps = qps;
    }

    @JsonIgnore
    public ClientConnectionOverridesBuilder edit() {
        return new ClientConnectionOverridesBuilder(this);
    }

    @JsonIgnore
    public ClientConnectionOverridesBuilder toBuilder() {
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

}
