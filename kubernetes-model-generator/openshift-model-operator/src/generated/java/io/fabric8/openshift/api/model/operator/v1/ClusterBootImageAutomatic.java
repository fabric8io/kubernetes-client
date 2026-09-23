
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * ClusterBootImageAutomatic is used to describe the cluster boot image in Automatic mode. It stores the RHCOS version of the boot image and the OCP release version which shipped with that RHCOS boot image. At least one of these values are required. If ocpVersion and rhcosVersion are defined, both values will be used for checking skew compliance. If only ocpVersion is defined, only that value will be used for checking skew compliance. If only rhcosVersion is defined, only that value will be used for checking skew compliance.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ocpVersion",
    "rhcosVersion"
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
public class ClusterBootImageAutomatic implements Editable<ClusterBootImageAutomaticBuilder>, KubernetesResource
{

    @JsonProperty("ocpVersion")
    private String ocpVersion;
    @JsonProperty("rhcosVersion")
    private String rhcosVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterBootImageAutomatic() {
    }

    public ClusterBootImageAutomatic(String ocpVersion, String rhcosVersion) {
        super();
        this.ocpVersion = ocpVersion;
        this.rhcosVersion = rhcosVersion;
    }

    /**
     * ocpVersion provides a string which represents the OCP version of the boot image. This field must match the OCP semver compatible format of x.y.z. This field must be between 5 and 10 characters long.
     */
    @JsonProperty("ocpVersion")
    public String getOcpVersion() {
        return ocpVersion;
    }

    /**
     * ocpVersion provides a string which represents the OCP version of the boot image. This field must match the OCP semver compatible format of x.y.z. This field must be between 5 and 10 characters long.
     */
    @JsonProperty("ocpVersion")
    public void setOcpVersion(String ocpVersion) {
        this.ocpVersion = ocpVersion;
    }

    /**
     * rhcosVersion provides a string which represents the RHCOS version of the boot image This field must match rhcosVersion formatting of [major].[minor].[datestamp(YYYYMMDD)]-[buildnumber] or the legacy format of [major].[minor].[timestamp(YYYYMMDDHHmm)]-[buildnumber]. This field must be between 14 and 21 characters long.
     */
    @JsonProperty("rhcosVersion")
    public String getRhcosVersion() {
        return rhcosVersion;
    }

    /**
     * rhcosVersion provides a string which represents the RHCOS version of the boot image This field must match rhcosVersion formatting of [major].[minor].[datestamp(YYYYMMDD)]-[buildnumber] or the legacy format of [major].[minor].[timestamp(YYYYMMDDHHmm)]-[buildnumber]. This field must be between 14 and 21 characters long.
     */
    @JsonProperty("rhcosVersion")
    public void setRhcosVersion(String rhcosVersion) {
        this.rhcosVersion = rhcosVersion;
    }

    @JsonIgnore
    public ClusterBootImageAutomaticBuilder edit() {
        return new ClusterBootImageAutomaticBuilder(this);
    }

    @JsonIgnore
    public ClusterBootImageAutomaticBuilder toBuilder() {
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
