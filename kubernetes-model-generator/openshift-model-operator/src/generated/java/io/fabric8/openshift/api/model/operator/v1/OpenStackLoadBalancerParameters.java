
package io.fabric8.openshift.api.model.operator.v1;

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
 * OpenStackLoadBalancerParameters provides configuration settings that are specific to OpenStack load balancers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "floatingIP"
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
public class OpenStackLoadBalancerParameters implements Editable<OpenStackLoadBalancerParametersBuilder>, KubernetesResource
{

    @JsonProperty("floatingIP")
    private String floatingIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OpenStackLoadBalancerParameters() {
    }

    public OpenStackLoadBalancerParameters(String floatingIP) {
        super();
        this.floatingIP = floatingIP;
    }

    /**
     * floatingIP specifies the IP address that the load balancer will use. When not specified, an IP address will be assigned randomly by the OpenStack cloud provider. When specified, the floating IP has to be pre-created.  If the specified value is not a floating IP or is already claimed, the OpenStack cloud provider won't be able to provision the load balancer. This field may only be used if the IngressController has External scope. This value must be a valid IPv4 or IPv6 address.
     */
    @JsonProperty("floatingIP")
    public String getFloatingIP() {
        return floatingIP;
    }

    /**
     * floatingIP specifies the IP address that the load balancer will use. When not specified, an IP address will be assigned randomly by the OpenStack cloud provider. When specified, the floating IP has to be pre-created.  If the specified value is not a floating IP or is already claimed, the OpenStack cloud provider won't be able to provision the load balancer. This field may only be used if the IngressController has External scope. This value must be a valid IPv4 or IPv6 address.
     */
    @JsonProperty("floatingIP")
    public void setFloatingIP(String floatingIP) {
        this.floatingIP = floatingIP;
    }

    @JsonIgnore
    public OpenStackLoadBalancerParametersBuilder edit() {
        return new OpenStackLoadBalancerParametersBuilder(this);
    }

    @JsonIgnore
    public OpenStackLoadBalancerParametersBuilder toBuilder() {
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
