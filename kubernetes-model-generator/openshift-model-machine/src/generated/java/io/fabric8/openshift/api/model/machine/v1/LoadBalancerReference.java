
package io.fabric8.openshift.api.model.machine.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * LoadBalancerReference is a reference to a load balancer on IBM Cloud virtual private cloud(VPC).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
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
public class LoadBalancerReference implements Editable<LoadBalancerReferenceBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerReference() {
    }

    public LoadBalancerReference(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    /**
     * name of the LoadBalancer in IBM Cloud VPC. The name should be between 1 and 63 characters long and may consist of lowercase alphanumeric characters and hyphens only. The value must not end with a hyphen. It is a reference to existing LoadBalancer created by openshift installer component.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the LoadBalancer in IBM Cloud VPC. The name should be between 1 and 63 characters long and may consist of lowercase alphanumeric characters and hyphens only. The value must not end with a hyphen. It is a reference to existing LoadBalancer created by openshift installer component.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * type of the LoadBalancer service supported by IBM Cloud VPC. Currently, only Application LoadBalancer is supported. More details about Application LoadBalancer https://cloud.ibm.com/docs/vpc?topic=vpc-load-balancers-about&amp;interface=ui Supported values are Application.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of the LoadBalancer service supported by IBM Cloud VPC. Currently, only Application LoadBalancer is supported. More details about Application LoadBalancer https://cloud.ibm.com/docs/vpc?topic=vpc-load-balancers-about&amp;interface=ui Supported values are Application.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public LoadBalancerReferenceBuilder edit() {
        return new LoadBalancerReferenceBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerReferenceBuilder toBuilder() {
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
