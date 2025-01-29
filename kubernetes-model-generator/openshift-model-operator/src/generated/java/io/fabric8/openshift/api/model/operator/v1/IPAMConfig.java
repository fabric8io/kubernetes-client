
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * IPAMConfig contains configurations for IPAM (IP Address Management)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "staticIPAMConfig",
    "type"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class IPAMConfig implements Editable<IPAMConfigBuilder>, KubernetesResource
{

    @JsonProperty("staticIPAMConfig")
    private StaticIPAMConfig staticIPAMConfig;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IPAMConfig() {
    }

    public IPAMConfig(StaticIPAMConfig staticIPAMConfig, String type) {
        super();
        this.staticIPAMConfig = staticIPAMConfig;
        this.type = type;
    }

    /**
     * IPAMConfig contains configurations for IPAM (IP Address Management)
     */
    @JsonProperty("staticIPAMConfig")
    public StaticIPAMConfig getStaticIPAMConfig() {
        return staticIPAMConfig;
    }

    /**
     * IPAMConfig contains configurations for IPAM (IP Address Management)
     */
    @JsonProperty("staticIPAMConfig")
    public void setStaticIPAMConfig(StaticIPAMConfig staticIPAMConfig) {
        this.staticIPAMConfig = staticIPAMConfig;
    }

    /**
     * Type is the type of IPAM module will be used for IP Address Management(IPAM). The supported values are IPAMTypeDHCP, IPAMTypeStatic
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the type of IPAM module will be used for IP Address Management(IPAM). The supported values are IPAMTypeDHCP, IPAMTypeStatic
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public IPAMConfigBuilder edit() {
        return new IPAMConfigBuilder(this);
    }

    @JsonIgnore
    public IPAMConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
