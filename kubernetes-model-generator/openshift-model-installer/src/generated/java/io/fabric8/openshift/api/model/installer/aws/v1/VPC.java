
package io.fabric8.openshift.api.model.installer.aws.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * VPC configures the VPC for the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "subnets"
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
public class VPC implements Editable<VPCBuilder>, KubernetesResource
{

    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Subnet> subnets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VPC() {
    }

    public VPC(List<Subnet> subnets) {
        super();
        this.subnets = subnets;
    }

    /**
     * Subnets defines the subnets in an existing VPC and can optionally specify their intended roles. If no roles are specified on any subnet, then the subnet roles are decided automatically. In this case, the VPC must not contain any other non-cluster subnets without the kubernetes.io/cluster/&lt;cluster-id&gt; tag.<br><p> <br><p> For manually specified subnet role selection, each subnet must have at least one assigned role, and the ClusterNode, BootstrapNode, IngressControllerLB, ControlPlaneExternalLB, and ControlPlaneInternalLB roles must be assigned to at least one subnet. However, if the cluster scope is internal, then ControlPlaneExternalLB is not required.<br><p> <br><p> Subnets must contain unique IDs, and can include no more than 10 subnets with the IngressController role.<br><p> <br><p> Leave this field unset to have the installer create subnets in a new VPC on your behalf.
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Subnet> getSubnets() {
        return subnets;
    }

    /**
     * Subnets defines the subnets in an existing VPC and can optionally specify their intended roles. If no roles are specified on any subnet, then the subnet roles are decided automatically. In this case, the VPC must not contain any other non-cluster subnets without the kubernetes.io/cluster/&lt;cluster-id&gt; tag.<br><p> <br><p> For manually specified subnet role selection, each subnet must have at least one assigned role, and the ClusterNode, BootstrapNode, IngressControllerLB, ControlPlaneExternalLB, and ControlPlaneInternalLB roles must be assigned to at least one subnet. However, if the cluster scope is internal, then ControlPlaneExternalLB is not required.<br><p> <br><p> Subnets must contain unique IDs, and can include no more than 10 subnets with the IngressController role.<br><p> <br><p> Leave this field unset to have the installer create subnets in a new VPC on your behalf.
     */
    @JsonProperty("subnets")
    public void setSubnets(List<Subnet> subnets) {
        this.subnets = subnets;
    }

    @JsonIgnore
    public VPCBuilder edit() {
        return new VPCBuilder(this);
    }

    @JsonIgnore
    public VPCBuilder toBuilder() {
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
