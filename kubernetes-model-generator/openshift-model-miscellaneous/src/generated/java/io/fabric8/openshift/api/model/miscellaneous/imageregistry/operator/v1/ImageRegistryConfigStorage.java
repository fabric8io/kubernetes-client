
package io.fabric8.openshift.api.model.miscellaneous.imageregistry.operator.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "azure",
    "emptyDir",
    "gcs",
    "managementState",
    "pvc",
    "s3",
    "swift"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ImageRegistryConfigStorage implements KubernetesResource
{

    @JsonProperty("azure")
    private ImageRegistryConfigStorageAzure azure;
    @JsonProperty("emptyDir")
    private ImageRegistryConfigStorageEmptyDir emptyDir;
    @JsonProperty("gcs")
    private ImageRegistryConfigStorageGCS gcs;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("pvc")
    private ImageRegistryConfigStoragePVC pvc;
    @JsonProperty("s3")
    private ImageRegistryConfigStorageS3 s3;
    @JsonProperty("swift")
    private ImageRegistryConfigStorageSwift swift;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageRegistryConfigStorage() {
    }

    /**
     * 
     * @param s3
     * @param gcs
     * @param emptyDir
     * @param pvc
     * @param azure
     * @param managementState
     * @param swift
     */
    public ImageRegistryConfigStorage(ImageRegistryConfigStorageAzure azure, ImageRegistryConfigStorageEmptyDir emptyDir, ImageRegistryConfigStorageGCS gcs, String managementState, ImageRegistryConfigStoragePVC pvc, ImageRegistryConfigStorageS3 s3, ImageRegistryConfigStorageSwift swift) {
        super();
        this.azure = azure;
        this.emptyDir = emptyDir;
        this.gcs = gcs;
        this.managementState = managementState;
        this.pvc = pvc;
        this.s3 = s3;
        this.swift = swift;
    }

    @JsonProperty("azure")
    public ImageRegistryConfigStorageAzure getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(ImageRegistryConfigStorageAzure azure) {
        this.azure = azure;
    }

    @JsonProperty("emptyDir")
    public ImageRegistryConfigStorageEmptyDir getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(ImageRegistryConfigStorageEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("gcs")
    public ImageRegistryConfigStorageGCS getGcs() {
        return gcs;
    }

    @JsonProperty("gcs")
    public void setGcs(ImageRegistryConfigStorageGCS gcs) {
        this.gcs = gcs;
    }

    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    @JsonProperty("pvc")
    public ImageRegistryConfigStoragePVC getPvc() {
        return pvc;
    }

    @JsonProperty("pvc")
    public void setPvc(ImageRegistryConfigStoragePVC pvc) {
        this.pvc = pvc;
    }

    @JsonProperty("s3")
    public ImageRegistryConfigStorageS3 getS3() {
        return s3;
    }

    @JsonProperty("s3")
    public void setS3(ImageRegistryConfigStorageS3 s3) {
        this.s3 = s3;
    }

    @JsonProperty("swift")
    public ImageRegistryConfigStorageSwift getSwift() {
        return swift;
    }

    @JsonProperty("swift")
    public void setSwift(ImageRegistryConfigStorageSwift swift) {
        this.swift = swift;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
