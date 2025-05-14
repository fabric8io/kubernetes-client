
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
 * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "driverType",
    "gcp",
    "ibmcloud",
    "vSphere"
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
public class CSIDriverConfigSpec implements Editable<CSIDriverConfigSpecBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private AWSCSIDriverConfigSpec aws;
    @JsonProperty("azure")
    private AzureCSIDriverConfigSpec azure;
    @JsonProperty("driverType")
    private String driverType;
    @JsonProperty("gcp")
    private GCPCSIDriverConfigSpec gcp;
    @JsonProperty("ibmcloud")
    private IBMCloudCSIDriverConfigSpec ibmcloud;
    @JsonProperty("vSphere")
    private VSphereCSIDriverConfigSpec vSphere;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CSIDriverConfigSpec() {
    }

    public CSIDriverConfigSpec(AWSCSIDriverConfigSpec aws, AzureCSIDriverConfigSpec azure, String driverType, GCPCSIDriverConfigSpec gcp, IBMCloudCSIDriverConfigSpec ibmcloud, VSphereCSIDriverConfigSpec vSphere) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.driverType = driverType;
        this.gcp = gcp;
        this.ibmcloud = ibmcloud;
        this.vSphere = vSphere;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("aws")
    public AWSCSIDriverConfigSpec getAws() {
        return aws;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("aws")
    public void setAws(AWSCSIDriverConfigSpec aws) {
        this.aws = aws;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("azure")
    public AzureCSIDriverConfigSpec getAzure() {
        return azure;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("azure")
    public void setAzure(AzureCSIDriverConfigSpec azure) {
        this.azure = azure;
    }

    /**
     * driverType indicates type of CSI driver for which the driverConfig is being applied to. Valid values are: AWS, Azure, GCP, IBMCloud, vSphere and omitted. Consumers should treat unknown values as a NO-OP.
     */
    @JsonProperty("driverType")
    public String getDriverType() {
        return driverType;
    }

    /**
     * driverType indicates type of CSI driver for which the driverConfig is being applied to. Valid values are: AWS, Azure, GCP, IBMCloud, vSphere and omitted. Consumers should treat unknown values as a NO-OP.
     */
    @JsonProperty("driverType")
    public void setDriverType(String driverType) {
        this.driverType = driverType;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("gcp")
    public GCPCSIDriverConfigSpec getGcp() {
        return gcp;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("gcp")
    public void setGcp(GCPCSIDriverConfigSpec gcp) {
        this.gcp = gcp;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("ibmcloud")
    public IBMCloudCSIDriverConfigSpec getIbmcloud() {
        return ibmcloud;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("ibmcloud")
    public void setIbmcloud(IBMCloudCSIDriverConfigSpec ibmcloud) {
        this.ibmcloud = ibmcloud;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("vSphere")
    public VSphereCSIDriverConfigSpec getVSphere() {
        return vSphere;
    }

    /**
     * CSIDriverConfigSpec defines configuration spec that can be used to optionally configure a specific CSI Driver.
     */
    @JsonProperty("vSphere")
    public void setVSphere(VSphereCSIDriverConfigSpec vSphere) {
        this.vSphere = vSphere;
    }

    @JsonIgnore
    public CSIDriverConfigSpecBuilder edit() {
        return new CSIDriverConfigSpecBuilder(this);
    }

    @JsonIgnore
    public CSIDriverConfigSpecBuilder toBuilder() {
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
