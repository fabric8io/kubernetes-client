
package io.fabric8.chaosmesh.v1alpha1;

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
        if (!(o instanceof AttrOverrideSpec)) {
            return false;
        }
        AttrOverrideSpec other = (AttrOverrideSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$atime = this.getAtime();
        Object other$atime = other.getAtime();
        if (this$atime == null ? other$atime != null : !this$atime.equals(other$atime)) {
            return false;
        }
        Object this$blocks = this.getBlocks();
        Object other$blocks = other.getBlocks();
        if (this$blocks == null ? other$blocks != null : !this$blocks.equals(other$blocks)) {
            return false;
        }
        Object this$ctime = this.getCtime();
        Object other$ctime = other.getCtime();
        if (this$ctime == null ? other$ctime != null : !this$ctime.equals(other$ctime)) {
            return false;
        }
        Object this$gid = this.getGid();
        Object other$gid = other.getGid();
        if (this$gid == null ? other$gid != null : !this$gid.equals(other$gid)) {
            return false;
        }
        Object this$ino = this.getIno();
        Object other$ino = other.getIno();
        if (this$ino == null ? other$ino != null : !this$ino.equals(other$ino)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$mtime = this.getMtime();
        Object other$mtime = other.getMtime();
        if (this$mtime == null ? other$mtime != null : !this$mtime.equals(other$mtime)) {
            return false;
        }
        Object this$nlink = this.getNlink();
        Object other$nlink = other.getNlink();
        if (this$nlink == null ? other$nlink != null : !this$nlink.equals(other$nlink)) {
            return false;
        }
        Object this$perm = this.getPerm();
        Object other$perm = other.getPerm();
        if (this$perm == null ? other$perm != null : !this$perm.equals(other$perm)) {
            return false;
        }
        Object this$rdev = this.getRdev();
        Object other$rdev = other.getRdev();
        if (this$rdev == null ? other$rdev != null : !this$rdev.equals(other$rdev)) {
            return false;
        }
        Object this$size = this.getSize();
        Object other$size = other.getSize();
        if (this$size == null ? other$size != null : !this$size.equals(other$size)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
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
        return other instanceof AttrOverrideSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $atime = this.getAtime();
        result = result * prime + ($atime == null ? 43 : $atime.hashCode());
        Object $blocks = this.getBlocks();
        result = result * prime + ($blocks == null ? 43 : $blocks.hashCode());
        Object $ctime = this.getCtime();
        result = result * prime + ($ctime == null ? 43 : $ctime.hashCode());
        Object $gid = this.getGid();
        result = result * prime + ($gid == null ? 43 : $gid.hashCode());
        Object $ino = this.getIno();
        result = result * prime + ($ino == null ? 43 : $ino.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $mtime = this.getMtime();
        result = result * prime + ($mtime == null ? 43 : $mtime.hashCode());
        Object $nlink = this.getNlink();
        result = result * prime + ($nlink == null ? 43 : $nlink.hashCode());
        Object $perm = this.getPerm();
        result = result * prime + ($perm == null ? 43 : $perm.hashCode());
        Object $rdev = this.getRdev();
        result = result * prime + ($rdev == null ? 43 : $rdev.hashCode());
        Object $size = this.getSize();
        result = result * prime + ($size == null ? 43 : $size.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AttrOverrideSpec(" + "atime=" + this.getAtime() + ", blocks=" + this.getBlocks() + ", ctime=" + this.getCtime() + ", gid=" + this.getGid() + ", ino=" + this.getIno() + ", kind=" + this.getKind() + ", mtime=" + this.getMtime() + ", nlink=" + this.getNlink() + ", perm=" + this.getPerm() + ", rdev=" + this.getRdev() + ", size=" + this.getSize() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
