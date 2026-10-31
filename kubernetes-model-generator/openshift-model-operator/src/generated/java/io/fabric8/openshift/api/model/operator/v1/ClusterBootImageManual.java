
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
 * ClusterBootImageManual is used to describe the cluster boot image in Manual mode.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mode",
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
public class ClusterBootImageManual implements Editable<ClusterBootImageManualBuilder>, KubernetesResource
{

    @JsonProperty("mode")
    private String mode;
    @JsonProperty("ocpVersion")
    private String ocpVersion;
    @JsonProperty("rhcosVersion")
    private String rhcosVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterBootImageManual() {
    }

    public ClusterBootImageManual(String mode, String ocpVersion, String rhcosVersion) {
        super();
        this.mode = mode;
        this.ocpVersion = ocpVersion;
        this.rhcosVersion = rhcosVersion;
    }

    /**
     * mode is used to configure which boot image field is defined in Manual mode. Valid values are OCPVersion and RHCOSVersion. OCPVersion means that the cluster admin is expected to set the OCP version associated with the last boot image update in the OCPVersion field. RHCOSVersion means that the cluster admin is expected to set the RHCOS version associated with the last boot image update in the RHCOSVersion field. This field is required.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * mode is used to configure which boot image field is defined in Manual mode. Valid values are OCPVersion and RHCOSVersion. OCPVersion means that the cluster admin is expected to set the OCP version associated with the last boot image update in the OCPVersion field. RHCOSVersion means that the cluster admin is expected to set the RHCOS version associated with the last boot image update in the RHCOSVersion field. This field is required.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * ocpVersion provides a string which represents the OCP version of the boot image. This field must match the OCP semver compatible format of x.y.z. This field must be between 5 and 10 characters long. Required when mode is set to "OCPVersion" and forbidden otherwise.
     */
    @JsonProperty("ocpVersion")
    public String getOcpVersion() {
        return ocpVersion;
    }

    /**
     * ocpVersion provides a string which represents the OCP version of the boot image. This field must match the OCP semver compatible format of x.y.z. This field must be between 5 and 10 characters long. Required when mode is set to "OCPVersion" and forbidden otherwise.
     */
    @JsonProperty("ocpVersion")
    public void setOcpVersion(String ocpVersion) {
        this.ocpVersion = ocpVersion;
    }

    /**
     * rhcosVersion provides a string which represents the RHCOS version of the boot image This field must match rhcosVersion formatting of [major].[minor].[datestamp(YYYYMMDD)]-[buildnumber] or the legacy format of [major].[minor].[timestamp(YYYYMMDDHHmm)]-[buildnumber]. This field must be between 14 and 21 characters long. Required when mode is set to "RHCOSVersion" and forbidden otherwise.
     */
    @JsonProperty("rhcosVersion")
    public String getRhcosVersion() {
        return rhcosVersion;
    }

    /**
     * rhcosVersion provides a string which represents the RHCOS version of the boot image This field must match rhcosVersion formatting of [major].[minor].[datestamp(YYYYMMDD)]-[buildnumber] or the legacy format of [major].[minor].[timestamp(YYYYMMDDHHmm)]-[buildnumber]. This field must be between 14 and 21 characters long. Required when mode is set to "RHCOSVersion" and forbidden otherwise.
     */
    @JsonProperty("rhcosVersion")
    public void setRhcosVersion(String rhcosVersion) {
        this.rhcosVersion = rhcosVersion;
    }

    @JsonIgnore
    public ClusterBootImageManualBuilder edit() {
        return new ClusterBootImageManualBuilder(this);
    }

    @JsonIgnore
    public ClusterBootImageManualBuilder toBuilder() {
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
