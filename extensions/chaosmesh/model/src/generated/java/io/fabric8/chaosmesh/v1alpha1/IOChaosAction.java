
package io.fabric8.chaosmesh.v1alpha1;

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

/**
 * IOChaosAction defines a possible action of IOChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "atime",
    "blocks",
    "ctime",
    "faults",
    "gid",
    "ino",
    "latency",
    "methods",
    "mistake",
    "mtime",
    "nlink",
    "path",
    "percent",
    "perm",
    "rdev",
    "size",
    "source",
    "type",
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
public class IOChaosAction implements Editable<IOChaosActionBuilder>, KubernetesResource
{

    @JsonProperty("atime")
    private Timespec atime;
    @JsonProperty("blocks")
    private Long blocks;
    @JsonProperty("ctime")
    private Timespec ctime;
    @JsonProperty("faults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IoFault> faults = new ArrayList<>();
    @JsonProperty("gid")
    private Long gid;
    @JsonProperty("ino")
    private Long ino;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("latency")
    private String latency;
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> methods = new ArrayList<>();
    @JsonProperty("mistake")
    private MistakeSpec mistake;
    @JsonProperty("mtime")
    private Timespec mtime;
    @JsonProperty("nlink")
    private Long nlink;
    @JsonProperty("path")
    private String path;
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("perm")
    private Integer perm;
    @JsonProperty("rdev")
    private Long rdev;
    @JsonProperty("size")
    private Long size;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uid")
    private Long uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IOChaosAction() {
    }

    public IOChaosAction(Timespec atime, Long blocks, Timespec ctime, List<IoFault> faults, Long gid, Long ino, String kind, String latency, List<String> methods, MistakeSpec mistake, Timespec mtime, Long nlink, String path, Integer percent, Integer perm, Long rdev, Long size, String source, String type, Long uid) {
        super();
        this.atime = atime;
        this.blocks = blocks;
        this.ctime = ctime;
        this.faults = faults;
        this.gid = gid;
        this.ino = ino;
        this.kind = kind;
        this.latency = latency;
        this.methods = methods;
        this.mistake = mistake;
        this.mtime = mtime;
        this.nlink = nlink;
        this.path = path;
        this.percent = percent;
        this.perm = perm;
        this.rdev = rdev;
        this.size = size;
        this.source = source;
        this.type = type;
        this.uid = uid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("atime")
    public Timespec getAtime() {
        return atime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("atime")
    public void setAtime(Timespec atime) {
        this.atime = atime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("blocks")
    public Long getBlocks() {
        return blocks;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("blocks")
    public void setBlocks(Long blocks) {
        this.blocks = blocks;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ctime")
    public Timespec getCtime() {
        return ctime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ctime")
    public void setCtime(Timespec ctime) {
        this.ctime = ctime;
    }

    /**
     * Faults represents the fault to inject
     */
    @JsonProperty("faults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IoFault> getFaults() {
        return faults;
    }

    /**
     * Faults represents the fault to inject
     */
    @JsonProperty("faults")
    public void setFaults(List<IoFault> faults) {
        this.faults = faults;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("gid")
    public Long getGid() {
        return gid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("gid")
    public void setGid(Long gid) {
        this.gid = gid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ino")
    public Long getIno() {
        return ino;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("ino")
    public void setIno(Long ino) {
        this.ino = ino;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Latency represents the latency to inject
     */
    @JsonProperty("latency")
    public String getLatency() {
        return latency;
    }

    /**
     * Latency represents the latency to inject
     */
    @JsonProperty("latency")
    public void setLatency(String latency) {
        this.latency = latency;
    }

    /**
     * Methods represents the method that the action will inject in
     */
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMethods() {
        return methods;
    }

    /**
     * Methods represents the method that the action will inject in
     */
    @JsonProperty("methods")
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mistake")
    public MistakeSpec getMistake() {
        return mistake;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mistake")
    public void setMistake(MistakeSpec mistake) {
        this.mistake = mistake;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mtime")
    public Timespec getMtime() {
        return mtime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("mtime")
    public void setMtime(Timespec mtime) {
        this.mtime = mtime;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("nlink")
    public Long getNlink() {
        return nlink;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("nlink")
    public void setNlink(Long nlink) {
        this.nlink = nlink;
    }

    /**
     * Path represents a glob of injecting path
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path represents a glob of injecting path
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Percent represents the percent probability of injecting this action
     */
    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    /**
     * Percent represents the percent probability of injecting this action
     */
    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("perm")
    public Integer getPerm() {
        return perm;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("perm")
    public void setPerm(Integer perm) {
        this.perm = perm;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("rdev")
    public Long getRdev() {
        return rdev;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("rdev")
    public void setRdev(Long rdev) {
        this.rdev = rdev;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("size")
    public Long getSize() {
        return size;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("size")
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * Source represents the source of current rules
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Source represents the source of current rules
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("uid")
    public Long getUid() {
        return uid;
    }

    /**
     * IOChaosAction defines a possible action of IOChaos
     */
    @JsonProperty("uid")
    public void setUid(Long uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public IOChaosActionBuilder edit() {
        return new IOChaosActionBuilder(this);
    }

    @JsonIgnore
    public IOChaosActionBuilder toBuilder() {
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
        if (!(o instanceof IOChaosAction)) {
            return false;
        }
        IOChaosAction other = (IOChaosAction) o;
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
        Object this$faults = this.getFaults();
        Object other$faults = other.getFaults();
        if (this$faults == null ? other$faults != null : !this$faults.equals(other$faults)) {
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
        Object this$latency = this.getLatency();
        Object other$latency = other.getLatency();
        if (this$latency == null ? other$latency != null : !this$latency.equals(other$latency)) {
            return false;
        }
        Object this$methods = this.getMethods();
        Object other$methods = other.getMethods();
        if (this$methods == null ? other$methods != null : !this$methods.equals(other$methods)) {
            return false;
        }
        Object this$mistake = this.getMistake();
        Object other$mistake = other.getMistake();
        if (this$mistake == null ? other$mistake != null : !this$mistake.equals(other$mistake)) {
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
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$percent = this.getPercent();
        Object other$percent = other.getPercent();
        if (this$percent == null ? other$percent != null : !this$percent.equals(other$percent)) {
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
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof IOChaosAction;
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
        Object $faults = this.getFaults();
        result = result * prime + ($faults == null ? 43 : $faults.hashCode());
        Object $gid = this.getGid();
        result = result * prime + ($gid == null ? 43 : $gid.hashCode());
        Object $ino = this.getIno();
        result = result * prime + ($ino == null ? 43 : $ino.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $latency = this.getLatency();
        result = result * prime + ($latency == null ? 43 : $latency.hashCode());
        Object $methods = this.getMethods();
        result = result * prime + ($methods == null ? 43 : $methods.hashCode());
        Object $mistake = this.getMistake();
        result = result * prime + ($mistake == null ? 43 : $mistake.hashCode());
        Object $mtime = this.getMtime();
        result = result * prime + ($mtime == null ? 43 : $mtime.hashCode());
        Object $nlink = this.getNlink();
        result = result * prime + ($nlink == null ? 43 : $nlink.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $percent = this.getPercent();
        result = result * prime + ($percent == null ? 43 : $percent.hashCode());
        Object $perm = this.getPerm();
        result = result * prime + ($perm == null ? 43 : $perm.hashCode());
        Object $rdev = this.getRdev();
        result = result * prime + ($rdev == null ? 43 : $rdev.hashCode());
        Object $size = this.getSize();
        result = result * prime + ($size == null ? 43 : $size.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IOChaosAction(" + "atime=" + this.getAtime() + ", blocks=" + this.getBlocks() + ", ctime=" + this.getCtime() + ", faults=" + this.getFaults() + ", gid=" + this.getGid() + ", ino=" + this.getIno() + ", kind=" + this.getKind() + ", latency=" + this.getLatency() + ", methods=" + this.getMethods() + ", mistake=" + this.getMistake() + ", mtime=" + this.getMtime() + ", nlink=" + this.getNlink() + ", path=" + this.getPath() + ", percent=" + this.getPercent() + ", perm=" + this.getPerm() + ", rdev=" + this.getRdev() + ", size=" + this.getSize() + ", source=" + this.getSource() + ", type=" + this.getType() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
