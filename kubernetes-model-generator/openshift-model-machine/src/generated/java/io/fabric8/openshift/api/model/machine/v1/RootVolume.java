
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
 * RootVolume represents the volume metadata to boot from. The original RootVolume struct is defined in the v1alpha1 but it's not best practice to use it directly here so we define a new one that should stay in sync with the original one.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availabilityZone",
    "volumeType"
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
public class RootVolume implements Editable<RootVolumeBuilder>, KubernetesResource
{

    @JsonProperty("availabilityZone")
    private String availabilityZone;
    @JsonProperty("volumeType")
    private String volumeType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RootVolume() {
    }

    public RootVolume(String availabilityZone, String volumeType) {
        super();
        this.availabilityZone = availabilityZone;
        this.volumeType = volumeType;
    }

    /**
     * availabilityZone specifies the Cinder availability zone where the root volume will be created. If not specifified, the root volume will be created in the availability zone specified by the volume type in the cinder configuration. If the volume type (configured in the OpenStack cluster) does not specify an availability zone, the root volume will be created in the default availability zone specified in the cinder configuration. See https://docs.openstack.org/cinder/latest/admin/availability-zone-type.html for more details. If the OpenStack cluster is deployed with the cross_az_attach configuration option set to false, the root volume will have to be in the same availability zone as the VM (defined by OpenStackFailureDomain.AvailabilityZone). Availability zone names must NOT contain spaces otherwise it will lead to volume that belongs to this availability zone register failure, see kubernetes/cloud-provider-openstack#1379 for further information. The maximum length of availability zone name is 63 as per labels limits.
     */
    @JsonProperty("availabilityZone")
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * availabilityZone specifies the Cinder availability zone where the root volume will be created. If not specifified, the root volume will be created in the availability zone specified by the volume type in the cinder configuration. If the volume type (configured in the OpenStack cluster) does not specify an availability zone, the root volume will be created in the default availability zone specified in the cinder configuration. See https://docs.openstack.org/cinder/latest/admin/availability-zone-type.html for more details. If the OpenStack cluster is deployed with the cross_az_attach configuration option set to false, the root volume will have to be in the same availability zone as the VM (defined by OpenStackFailureDomain.AvailabilityZone). Availability zone names must NOT contain spaces otherwise it will lead to volume that belongs to this availability zone register failure, see kubernetes/cloud-provider-openstack#1379 for further information. The maximum length of availability zone name is 63 as per labels limits.
     */
    @JsonProperty("availabilityZone")
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    /**
     * volumeType specifies the type of the root volume that will be provisioned. The maximum length of a volume type name is 255 characters, as per the OpenStack limit.
     */
    @JsonProperty("volumeType")
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * volumeType specifies the type of the root volume that will be provisioned. The maximum length of a volume type name is 255 characters, as per the OpenStack limit.
     */
    @JsonProperty("volumeType")
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    @JsonIgnore
    public RootVolumeBuilder edit() {
        return new RootVolumeBuilder(this);
    }

    @JsonIgnore
    public RootVolumeBuilder toBuilder() {
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
