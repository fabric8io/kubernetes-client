
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * VolumeMount describes a mounting of a Volume within a container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindMountOptions",
    "mountPath",
    "mountPropagation",
    "name",
    "readOnly",
    "recursiveReadOnly",
    "subPath",
    "subPathExpr"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class VolumeMount implements Editable<VolumeMountBuilder>, KubernetesResource
{

    @JsonProperty("bindMountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindMountOptions = new ArrayList<>();
    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("mountPropagation")
    private String mountPropagation;
    @JsonProperty("name")
    private String name;
    @JsonProperty("readOnly")
    private Boolean readOnly;
    @JsonProperty("recursiveReadOnly")
    private String recursiveReadOnly;
    @JsonProperty("subPath")
    private String subPath;
    @JsonProperty("subPathExpr")
    private String subPathExpr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeMount() {
    }

    public VolumeMount(List<String> bindMountOptions, String mountPath, String mountPropagation, String name, Boolean readOnly, String recursiveReadOnly, String subPath, String subPathExpr) {
        super();
        this.bindMountOptions = bindMountOptions;
        this.mountPath = mountPath;
        this.mountPropagation = mountPropagation;
        this.name = name;
        this.readOnly = readOnly;
        this.recursiveReadOnly = recursiveReadOnly;
        this.subPath = subPath;
        this.subPathExpr = subPathExpr;
    }

    /**
     * bindMountOptions is the list of additional bind mount options to apply when mounting this volume into the container. Allowed values are noexec, nodev, and nosuid. These are Linux mount options and have no effect on Windows nodes. This field is not supported with image volumes. This is an alpha field and requires enabling the VolumeBindMountOptions feature gate.
     */
    @JsonProperty("bindMountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBindMountOptions() {
        return bindMountOptions;
    }

    /**
     * bindMountOptions is the list of additional bind mount options to apply when mounting this volume into the container. Allowed values are noexec, nodev, and nosuid. These are Linux mount options and have no effect on Windows nodes. This field is not supported with image volumes. This is an alpha field and requires enabling the VolumeBindMountOptions feature gate.
     */
    @JsonProperty("bindMountOptions")
    public void setBindMountOptions(List<String> bindMountOptions) {
        this.bindMountOptions = bindMountOptions;
    }

    /**
     * Path within the container at which the volume should be mounted.
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * Path within the container at which the volume should be mounted.
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    /**
     * mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10. When RecursiveReadOnly is set to IfPossible or to Enabled, MountPropagation must be None or unspecified (which defaults to None).
     */
    @JsonProperty("mountPropagation")
    public String getMountPropagation() {
        return mountPropagation;
    }

    /**
     * mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10. When RecursiveReadOnly is set to IfPossible or to Enabled, MountPropagation must be None or unspecified (which defaults to None).
     */
    @JsonProperty("mountPropagation")
    public void setMountPropagation(String mountPropagation) {
        this.mountPropagation = mountPropagation;
    }

    /**
     * This must match the Name of a Volume.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * This must match the Name of a Volume.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
     */
    @JsonProperty("readOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
     */
    @JsonProperty("readOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * RecursiveReadOnly specifies whether read-only mounts should be handled recursively.<br><p> <br><p> If ReadOnly is false, this field has no meaning and must be unspecified.<br><p> <br><p> If ReadOnly is true, and this field is set to Disabled, the mount is not made recursively read-only.  If this field is set to IfPossible, the mount is made recursively read-only, if it is supported by the container runtime.  If this field is set to Enabled, the mount is made recursively read-only if it is supported by the container runtime, otherwise the pod will not be started and an error will be generated to indicate the reason.<br><p> <br><p> If this field is set to IfPossible or Enabled, MountPropagation must be set to None (or be unspecified, which defaults to None).<br><p> <br><p> If this field is not specified, it is treated as an equivalent of Disabled.
     */
    @JsonProperty("recursiveReadOnly")
    public String getRecursiveReadOnly() {
        return recursiveReadOnly;
    }

    /**
     * RecursiveReadOnly specifies whether read-only mounts should be handled recursively.<br><p> <br><p> If ReadOnly is false, this field has no meaning and must be unspecified.<br><p> <br><p> If ReadOnly is true, and this field is set to Disabled, the mount is not made recursively read-only.  If this field is set to IfPossible, the mount is made recursively read-only, if it is supported by the container runtime.  If this field is set to Enabled, the mount is made recursively read-only if it is supported by the container runtime, otherwise the pod will not be started and an error will be generated to indicate the reason.<br><p> <br><p> If this field is set to IfPossible or Enabled, MountPropagation must be set to None (or be unspecified, which defaults to None).<br><p> <br><p> If this field is not specified, it is treated as an equivalent of Disabled.
     */
    @JsonProperty("recursiveReadOnly")
    public void setRecursiveReadOnly(String recursiveReadOnly) {
        this.recursiveReadOnly = recursiveReadOnly;
    }

    /**
     * Path within the volume from which the container's volume should be mounted. Defaults to "" (volume's root).
     */
    @JsonProperty("subPath")
    public String getSubPath() {
        return subPath;
    }

    /**
     * Path within the volume from which the container's volume should be mounted. Defaults to "" (volume's root).
     */
    @JsonProperty("subPath")
    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    /**
     * Expanded path within the volume from which the container's volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container's environment. Defaults to "" (volume's root). SubPathExpr and SubPath are mutually exclusive.
     */
    @JsonProperty("subPathExpr")
    public String getSubPathExpr() {
        return subPathExpr;
    }

    /**
     * Expanded path within the volume from which the container's volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container's environment. Defaults to "" (volume's root). SubPathExpr and SubPath are mutually exclusive.
     */
    @JsonProperty("subPathExpr")
    public void setSubPathExpr(String subPathExpr) {
        this.subPathExpr = subPathExpr;
    }

    @JsonIgnore
    public VolumeMountBuilder edit() {
        return new VolumeMountBuilder(this);
    }

    @JsonIgnore
    public VolumeMountBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VolumeMount)) {
            return false;
        }
        VolumeMount other = (VolumeMount) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bindMountOptions = this.getBindMountOptions();
        Object other$bindMountOptions = other.getBindMountOptions();
        if (this$bindMountOptions == null ? other$bindMountOptions != null : !this$bindMountOptions.equals(other$bindMountOptions)) {
            return false;
        }
        Object this$mountPath = this.getMountPath();
        Object other$mountPath = other.getMountPath();
        if (this$mountPath == null ? other$mountPath != null : !this$mountPath.equals(other$mountPath)) {
            return false;
        }
        Object this$mountPropagation = this.getMountPropagation();
        Object other$mountPropagation = other.getMountPropagation();
        if (this$mountPropagation == null ? other$mountPropagation != null : !this$mountPropagation.equals(other$mountPropagation)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$readOnly = this.getReadOnly();
        Object other$readOnly = other.getReadOnly();
        if (this$readOnly == null ? other$readOnly != null : !this$readOnly.equals(other$readOnly)) {
            return false;
        }
        Object this$recursiveReadOnly = this.getRecursiveReadOnly();
        Object other$recursiveReadOnly = other.getRecursiveReadOnly();
        if (this$recursiveReadOnly == null ? other$recursiveReadOnly != null : !this$recursiveReadOnly.equals(other$recursiveReadOnly)) {
            return false;
        }
        Object this$subPath = this.getSubPath();
        Object other$subPath = other.getSubPath();
        if (this$subPath == null ? other$subPath != null : !this$subPath.equals(other$subPath)) {
            return false;
        }
        Object this$subPathExpr = this.getSubPathExpr();
        Object other$subPathExpr = other.getSubPathExpr();
        if (this$subPathExpr == null ? other$subPathExpr != null : !this$subPathExpr.equals(other$subPathExpr)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof VolumeMount;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bindMountOptions = this.getBindMountOptions();
        result = result * prime + ($bindMountOptions == null ? 43 : $bindMountOptions.hashCode());
        Object $mountPath = this.getMountPath();
        result = result * prime + ($mountPath == null ? 43 : $mountPath.hashCode());
        Object $mountPropagation = this.getMountPropagation();
        result = result * prime + ($mountPropagation == null ? 43 : $mountPropagation.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $readOnly = this.getReadOnly();
        result = result * prime + ($readOnly == null ? 43 : $readOnly.hashCode());
        Object $recursiveReadOnly = this.getRecursiveReadOnly();
        result = result * prime + ($recursiveReadOnly == null ? 43 : $recursiveReadOnly.hashCode());
        Object $subPath = this.getSubPath();
        result = result * prime + ($subPath == null ? 43 : $subPath.hashCode());
        Object $subPathExpr = this.getSubPathExpr();
        result = result * prime + ($subPathExpr == null ? 43 : $subPathExpr.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeMount(" + "bindMountOptions=" + this.getBindMountOptions() + ", mountPath=" + this.getMountPath() + ", mountPropagation=" + this.getMountPropagation() + ", name=" + this.getName() + ", readOnly=" + this.getReadOnly() + ", recursiveReadOnly=" + this.getRecursiveReadOnly() + ", subPath=" + this.getSubPath() + ", subPathExpr=" + this.getSubPathExpr() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
