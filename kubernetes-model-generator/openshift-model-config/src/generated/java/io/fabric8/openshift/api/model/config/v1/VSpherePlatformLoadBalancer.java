
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

/**
 * VSpherePlatformLoadBalancer defines the load balancer used by the cluster on VSphere platform.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VSpherePlatformLoadBalancer implements Editable<VSpherePlatformLoadBalancerBuilder>, KubernetesResource
{

    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VSpherePlatformLoadBalancer() {
    }

    public VSpherePlatformLoadBalancer(String type) {
        super();
        this.type = type;
    }

    /**
     * type defines the type of load balancer used by the cluster on VSphere platform which can be a user-managed or openshift-managed load balancer that is to be used for the OpenShift API and Ingress endpoints. When set to OpenShiftManagedDefault the static pods in charge of API and Ingress traffic load-balancing defined in the machine config operator will be deployed. When set to UserManaged these static pods will not be deployed and it is expected that the load balancer is configured out of band by the deployer. When omitted, this means no opinion and the platform is left to choose a reasonable default. The default value is OpenShiftManagedDefault.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type defines the type of load balancer used by the cluster on VSphere platform which can be a user-managed or openshift-managed load balancer that is to be used for the OpenShift API and Ingress endpoints. When set to OpenShiftManagedDefault the static pods in charge of API and Ingress traffic load-balancing defined in the machine config operator will be deployed. When set to UserManaged these static pods will not be deployed and it is expected that the load balancer is configured out of band by the deployer. When omitted, this means no opinion and the platform is left to choose a reasonable default. The default value is OpenShiftManagedDefault.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public VSpherePlatformLoadBalancerBuilder edit() {
        return new VSpherePlatformLoadBalancerBuilder(this);
    }

    @JsonIgnore
    public VSpherePlatformLoadBalancerBuilder toBuilder() {
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
