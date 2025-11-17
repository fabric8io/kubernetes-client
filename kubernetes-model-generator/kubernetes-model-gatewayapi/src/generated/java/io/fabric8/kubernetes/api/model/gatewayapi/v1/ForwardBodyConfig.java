
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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

/**
 * ForwardBody configures if requests to the authorization server should include the body of the client request; and if so, how big that body is allowed to be.<br><p> <br><p> If empty or unset, do not forward the body.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxSize"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ForwardBodyConfig implements Editable<ForwardBodyConfigBuilder>, KubernetesResource
{

    @JsonProperty("maxSize")
    private Integer maxSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ForwardBodyConfig() {
    }

    public ForwardBodyConfig(Integer maxSize) {
        super();
        this.maxSize = maxSize;
    }

    /**
     * MaxSize specifies how large in bytes the largest body that will be buffered and sent to the authorization server. If the body size is larger than `maxSize`, then the body sent to the authorization server must be truncated to `maxSize` bytes.<br><p> <br><p> Experimental note: This behavior needs to be checked against various dataplanes; it may need to be changed. See https://github.com/kubernetes-sigs/gateway-api/pull/4001#discussion_r2291405746 for more.<br><p> <br><p> If 0, the body will not be sent to the authorization server.
     */
    @JsonProperty("maxSize")
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * MaxSize specifies how large in bytes the largest body that will be buffered and sent to the authorization server. If the body size is larger than `maxSize`, then the body sent to the authorization server must be truncated to `maxSize` bytes.<br><p> <br><p> Experimental note: This behavior needs to be checked against various dataplanes; it may need to be changed. See https://github.com/kubernetes-sigs/gateway-api/pull/4001#discussion_r2291405746 for more.<br><p> <br><p> If 0, the body will not be sent to the authorization server.
     */
    @JsonProperty("maxSize")
    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    @JsonIgnore
    public ForwardBodyConfigBuilder edit() {
        return new ForwardBodyConfigBuilder(this);
    }

    @JsonIgnore
    public ForwardBodyConfigBuilder toBuilder() {
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
