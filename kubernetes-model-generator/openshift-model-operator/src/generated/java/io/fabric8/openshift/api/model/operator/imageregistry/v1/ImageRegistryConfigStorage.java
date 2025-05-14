
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
 * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "azure",
    "emptyDir",
    "gcs",
    "ibmcos",
    "managementState",
    "oss",
    "pvc",
    "s3",
    "swift"
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
public class ImageRegistryConfigStorage implements Editable<ImageRegistryConfigStorageBuilder>, KubernetesResource
{

    @JsonProperty("azure")
    private ImageRegistryConfigStorageAzure azure;
    @JsonProperty("emptyDir")
    private ImageRegistryConfigStorageEmptyDir emptyDir;
    @JsonProperty("gcs")
    private ImageRegistryConfigStorageGCS gcs;
    @JsonProperty("ibmcos")
    private ImageRegistryConfigStorageIBMCOS ibmcos;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("oss")
    private ImageRegistryConfigStorageAlibabaOSS oss;
    @JsonProperty("pvc")
    private ImageRegistryConfigStoragePVC pvc;
    @JsonProperty("s3")
    private ImageRegistryConfigStorageS3 s3;
    @JsonProperty("swift")
    private ImageRegistryConfigStorageSwift swift;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigStorage() {
    }

    public ImageRegistryConfigStorage(ImageRegistryConfigStorageAzure azure, ImageRegistryConfigStorageEmptyDir emptyDir, ImageRegistryConfigStorageGCS gcs, ImageRegistryConfigStorageIBMCOS ibmcos, String managementState, ImageRegistryConfigStorageAlibabaOSS oss, ImageRegistryConfigStoragePVC pvc, ImageRegistryConfigStorageS3 s3, ImageRegistryConfigStorageSwift swift) {
        super();
        this.azure = azure;
        this.emptyDir = emptyDir;
        this.gcs = gcs;
        this.ibmcos = ibmcos;
        this.managementState = managementState;
        this.oss = oss;
        this.pvc = pvc;
        this.s3 = s3;
        this.swift = swift;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("azure")
    public ImageRegistryConfigStorageAzure getAzure() {
        return azure;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("azure")
    public void setAzure(ImageRegistryConfigStorageAzure azure) {
        this.azure = azure;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("emptyDir")
    public ImageRegistryConfigStorageEmptyDir getEmptyDir() {
        return emptyDir;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("emptyDir")
    public void setEmptyDir(ImageRegistryConfigStorageEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("gcs")
    public ImageRegistryConfigStorageGCS getGcs() {
        return gcs;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("gcs")
    public void setGcs(ImageRegistryConfigStorageGCS gcs) {
        this.gcs = gcs;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("ibmcos")
    public ImageRegistryConfigStorageIBMCOS getIbmcos() {
        return ibmcos;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("ibmcos")
    public void setIbmcos(ImageRegistryConfigStorageIBMCOS ibmcos) {
        this.ibmcos = ibmcos;
    }

    /**
     * managementState indicates if the operator manages the underlying storage unit. If Managed the operator will remove the storage when this operator gets Removed.
     */
    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    /**
     * managementState indicates if the operator manages the underlying storage unit. If Managed the operator will remove the storage when this operator gets Removed.
     */
    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("oss")
    public ImageRegistryConfigStorageAlibabaOSS getOss() {
        return oss;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("oss")
    public void setOss(ImageRegistryConfigStorageAlibabaOSS oss) {
        this.oss = oss;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("pvc")
    public ImageRegistryConfigStoragePVC getPvc() {
        return pvc;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("pvc")
    public void setPvc(ImageRegistryConfigStoragePVC pvc) {
        this.pvc = pvc;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("s3")
    public ImageRegistryConfigStorageS3 getS3() {
        return s3;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("s3")
    public void setS3(ImageRegistryConfigStorageS3 s3) {
        this.s3 = s3;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("swift")
    public ImageRegistryConfigStorageSwift getSwift() {
        return swift;
    }

    /**
     * ImageRegistryConfigStorage describes how the storage should be configured for the image registry.
     */
    @JsonProperty("swift")
    public void setSwift(ImageRegistryConfigStorageSwift swift) {
        this.swift = swift;
    }

    @JsonIgnore
    public ImageRegistryConfigStorageBuilder edit() {
        return new ImageRegistryConfigStorageBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigStorageBuilder toBuilder() {
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
