
package io.fabric8.chaosmesh.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
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
 * AttrOverrideSpec represents an override of attribution
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "atime",
    "blocks",
    "ctime",
    "gid",
    "ino",
    "mtime",
    "nlink",
    "perm",
    "rdev",
    "size",
    "uid"
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
public class AttrOverrideSpec implements Editable<AttrOverrideSpecBuilder>, KubernetesResource
{

    @JsonProperty("atime")
    private Timespec atime;
    @JsonProperty("blocks")
    private Long blocks;
    @JsonProperty("ctime")
    private Timespec ctime;
    @JsonProperty("gid")
    private Long gid;
    @JsonProperty("ino")
    private Long ino;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("mtime")
    private Timespec mtime;
    @JsonProperty("nlink")
    private Long nlink;
    @JsonProperty("perm")
    private Integer perm;
    @JsonProperty("rdev")
    private Long rdev;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("uid")
    private Long uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AttrOverrideSpec() {
    }

    public AttrOverrideSpec(Timespec atime, Long blocks, Timespec ctime, Long gid, Long ino, String kind, Timespec mtime, Long nlink, Integer perm, Long rdev, Long size, Long uid) {
        super();
        this.atime = atime;
        this.blocks = blocks;
        this.ctime = ctime;
        this.gid = gid;
        this.ino = ino;
        this.kind = kind;
        this.mtime = mtime;
        this.nlink = nlink;
        this.perm = perm;
        this.rdev = rdev;
        this.size = size;
        this.uid = uid;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("atime")
    public Timespec getAtime() {
        return atime;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("atime")
    public void setAtime(Timespec atime) {
        this.atime = atime;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("blocks")
    public Long getBlocks() {
        return blocks;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("blocks")
    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("ctime")
    public Timespec getCtime() {
        return ctime;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("ctime")
    public void setCtime(Timespec ctime) {
        this.ctime = ctime;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("gid")
    public Long getGid() {
        return gid;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("gid")
    public void setGid(Long gid) {
        this.gid = gid;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("ino")
    public Long getIno() {
        return ino;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("ino")
    public void setIno(Long ino) {
        this.ino = ino;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("mtime")
    public Timespec getMtime() {
        return mtime;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("mtime")
    public void setMtime(Timespec mtime) {
        this.mtime = mtime;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("nlink")
    public Long getNlink() {
        return nlink;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("nlink")
    public void setNlink(Long nlink) {
        this.nlink = nlink;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("perm")
    public Integer getPerm() {
        return perm;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("perm")
    public void setPerm(Integer perm) {
        this.perm = perm;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("rdev")
    public Long getRdev() {
        return rdev;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("rdev")
    public void setRdev(Long rdev) {
        this.rdev = rdev;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("size")
    public Long getSize() {
        return size;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("size")
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("uid")
    public Long getUid() {
        return uid;
    }

    /**
     * AttrOverrideSpec represents an override of attribution
     */
    @JsonProperty("uid")
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public AttrOverrideSpecBuilder edit() {
        return new AttrOverrideSpecBuilder(this);
    }

    @JsonIgnore
    public AttrOverrideSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
