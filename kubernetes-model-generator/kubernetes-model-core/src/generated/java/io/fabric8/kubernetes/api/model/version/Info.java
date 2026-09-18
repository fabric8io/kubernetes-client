
package io.fabric8.kubernetes.api.model.version;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;

/**
 * Info contains versioning information. how we'll want to distribute that information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildDate",
    "compiler",
    "emulationMajor",
    "emulationMinor",
    "gitCommit",
    "gitTreeState",
    "gitVersion",
    "goVersion",
    "major",
    "minCompatibilityMajor",
    "minCompatibilityMinor",
    "minor",
    "platform"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Info implements Editable<InfoBuilder>, KubernetesResource
{

    @JsonProperty("buildDate")
    private String buildDate;
    @JsonProperty("compiler")
    private String compiler;
    @JsonProperty("emulationMajor")
    private String emulationMajor;
    @JsonProperty("emulationMinor")
    private String emulationMinor;
    @JsonProperty("gitCommit")
    private String gitCommit;
    @JsonProperty("gitTreeState")
    private String gitTreeState;
    @JsonProperty("gitVersion")
    private String gitVersion;
    @JsonProperty("goVersion")
    private String goVersion;
    @JsonProperty("major")
    private String major;
    @JsonProperty("minCompatibilityMajor")
    private String minCompatibilityMajor;
    @JsonProperty("minCompatibilityMinor")
    private String minCompatibilityMinor;
    @JsonProperty("minor")
    private String minor;
    @JsonProperty("platform")
    private String platform;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Info() {
    }

    public Info(String buildDate, String compiler, String emulationMajor, String emulationMinor, String gitCommit, String gitTreeState, String gitVersion, String goVersion, String major, String minCompatibilityMajor, String minCompatibilityMinor, String minor, String platform) {
        super();
        this.buildDate = buildDate;
        this.compiler = compiler;
        this.emulationMajor = emulationMajor;
        this.emulationMinor = emulationMinor;
        this.gitCommit = gitCommit;
        this.gitTreeState = gitTreeState;
        this.gitVersion = gitVersion;
        this.goVersion = goVersion;
        this.major = major;
        this.minCompatibilityMajor = minCompatibilityMajor;
        this.minCompatibilityMinor = minCompatibilityMinor;
        this.minor = minor;
        this.platform = platform;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("buildDate")
    public String getBuildDate() {
        return buildDate;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("buildDate")
    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("compiler")
    public String getCompiler() {
        return compiler;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("compiler")
    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    /**
     * EmulationMajor is the major version of the emulation version
     */
    @JsonProperty("emulationMajor")
    public String getEmulationMajor() {
        return emulationMajor;
    }

    /**
     * EmulationMajor is the major version of the emulation version
     */
    @JsonProperty("emulationMajor")
    public void setEmulationMajor(String emulationMajor) {
        this.emulationMajor = emulationMajor;
    }

    /**
     * EmulationMinor is the minor version of the emulation version
     */
    @JsonProperty("emulationMinor")
    public String getEmulationMinor() {
        return emulationMinor;
    }

    /**
     * EmulationMinor is the minor version of the emulation version
     */
    @JsonProperty("emulationMinor")
    public void setEmulationMinor(String emulationMinor) {
        this.emulationMinor = emulationMinor;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("gitCommit")
    public String getGitCommit() {
        return gitCommit;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("gitCommit")
    public void setGitCommit(String gitCommit) {
        this.gitCommit = gitCommit;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("gitTreeState")
    public String getGitTreeState() {
        return gitTreeState;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("gitTreeState")
    public void setGitTreeState(String gitTreeState) {
        this.gitTreeState = gitTreeState;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("gitVersion")
    public String getGitVersion() {
        return gitVersion;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("gitVersion")
    public void setGitVersion(String gitVersion) {
        this.gitVersion = gitVersion;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("goVersion")
    public String getGoVersion() {
        return goVersion;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("goVersion")
    public void setGoVersion(String goVersion) {
        this.goVersion = goVersion;
    }

    /**
     * Major is the major version of the binary version
     */
    @JsonProperty("major")
    public String getMajor() {
        return major;
    }

    /**
     * Major is the major version of the binary version
     */
    @JsonProperty("major")
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * MinCompatibilityMajor is the major version of the minimum compatibility version
     */
    @JsonProperty("minCompatibilityMajor")
    public String getMinCompatibilityMajor() {
        return minCompatibilityMajor;
    }

    /**
     * MinCompatibilityMajor is the major version of the minimum compatibility version
     */
    @JsonProperty("minCompatibilityMajor")
    public void setMinCompatibilityMajor(String minCompatibilityMajor) {
        this.minCompatibilityMajor = minCompatibilityMajor;
    }

    /**
     * MinCompatibilityMinor is the minor version of the minimum compatibility version
     */
    @JsonProperty("minCompatibilityMinor")
    public String getMinCompatibilityMinor() {
        return minCompatibilityMinor;
    }

    /**
     * MinCompatibilityMinor is the minor version of the minimum compatibility version
     */
    @JsonProperty("minCompatibilityMinor")
    public void setMinCompatibilityMinor(String minCompatibilityMinor) {
        this.minCompatibilityMinor = minCompatibilityMinor;
    }

    /**
     * Minor is the minor version of the binary version
     */
    @JsonProperty("minor")
    public String getMinor() {
        return minor;
    }

    /**
     * Minor is the minor version of the binary version
     */
    @JsonProperty("minor")
    public void setMinor(String minor) {
        this.minor = minor;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonIgnore
    public InfoBuilder edit() {
        return new InfoBuilder(this);
    }

    @JsonIgnore
    public InfoBuilder toBuilder() {
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
        if (!(o instanceof Info)) {
            return false;
        }
        Info other = (Info) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$buildDate = this.getBuildDate();
        Object other$buildDate = other.getBuildDate();
        if (this$buildDate == null ? other$buildDate != null : !this$buildDate.equals(other$buildDate)) {
            return false;
        }
        Object this$compiler = this.getCompiler();
        Object other$compiler = other.getCompiler();
        if (this$compiler == null ? other$compiler != null : !this$compiler.equals(other$compiler)) {
            return false;
        }
        Object this$emulationMajor = this.getEmulationMajor();
        Object other$emulationMajor = other.getEmulationMajor();
        if (this$emulationMajor == null ? other$emulationMajor != null : !this$emulationMajor.equals(other$emulationMajor)) {
            return false;
        }
        Object this$emulationMinor = this.getEmulationMinor();
        Object other$emulationMinor = other.getEmulationMinor();
        if (this$emulationMinor == null ? other$emulationMinor != null : !this$emulationMinor.equals(other$emulationMinor)) {
            return false;
        }
        Object this$gitCommit = this.getGitCommit();
        Object other$gitCommit = other.getGitCommit();
        if (this$gitCommit == null ? other$gitCommit != null : !this$gitCommit.equals(other$gitCommit)) {
            return false;
        }
        Object this$gitTreeState = this.getGitTreeState();
        Object other$gitTreeState = other.getGitTreeState();
        if (this$gitTreeState == null ? other$gitTreeState != null : !this$gitTreeState.equals(other$gitTreeState)) {
            return false;
        }
        Object this$gitVersion = this.getGitVersion();
        Object other$gitVersion = other.getGitVersion();
        if (this$gitVersion == null ? other$gitVersion != null : !this$gitVersion.equals(other$gitVersion)) {
            return false;
        }
        Object this$goVersion = this.getGoVersion();
        Object other$goVersion = other.getGoVersion();
        if (this$goVersion == null ? other$goVersion != null : !this$goVersion.equals(other$goVersion)) {
            return false;
        }
        Object this$major = this.getMajor();
        Object other$major = other.getMajor();
        if (this$major == null ? other$major != null : !this$major.equals(other$major)) {
            return false;
        }
        Object this$minCompatibilityMajor = this.getMinCompatibilityMajor();
        Object other$minCompatibilityMajor = other.getMinCompatibilityMajor();
        if (this$minCompatibilityMajor == null ? other$minCompatibilityMajor != null : !this$minCompatibilityMajor.equals(other$minCompatibilityMajor)) {
            return false;
        }
        Object this$minCompatibilityMinor = this.getMinCompatibilityMinor();
        Object other$minCompatibilityMinor = other.getMinCompatibilityMinor();
        if (this$minCompatibilityMinor == null ? other$minCompatibilityMinor != null : !this$minCompatibilityMinor.equals(other$minCompatibilityMinor)) {
            return false;
        }
        Object this$minor = this.getMinor();
        Object other$minor = other.getMinor();
        if (this$minor == null ? other$minor != null : !this$minor.equals(other$minor)) {
            return false;
        }
        Object this$platform = this.getPlatform();
        Object other$platform = other.getPlatform();
        if (this$platform == null ? other$platform != null : !this$platform.equals(other$platform)) {
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
        return other instanceof Info;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $buildDate = this.getBuildDate();
        result = result * prime + ($buildDate == null ? 43 : $buildDate.hashCode());
        Object $compiler = this.getCompiler();
        result = result * prime + ($compiler == null ? 43 : $compiler.hashCode());
        Object $emulationMajor = this.getEmulationMajor();
        result = result * prime + ($emulationMajor == null ? 43 : $emulationMajor.hashCode());
        Object $emulationMinor = this.getEmulationMinor();
        result = result * prime + ($emulationMinor == null ? 43 : $emulationMinor.hashCode());
        Object $gitCommit = this.getGitCommit();
        result = result * prime + ($gitCommit == null ? 43 : $gitCommit.hashCode());
        Object $gitTreeState = this.getGitTreeState();
        result = result * prime + ($gitTreeState == null ? 43 : $gitTreeState.hashCode());
        Object $gitVersion = this.getGitVersion();
        result = result * prime + ($gitVersion == null ? 43 : $gitVersion.hashCode());
        Object $goVersion = this.getGoVersion();
        result = result * prime + ($goVersion == null ? 43 : $goVersion.hashCode());
        Object $major = this.getMajor();
        result = result * prime + ($major == null ? 43 : $major.hashCode());
        Object $minCompatibilityMajor = this.getMinCompatibilityMajor();
        result = result * prime + ($minCompatibilityMajor == null ? 43 : $minCompatibilityMajor.hashCode());
        Object $minCompatibilityMinor = this.getMinCompatibilityMinor();
        result = result * prime + ($minCompatibilityMinor == null ? 43 : $minCompatibilityMinor.hashCode());
        Object $minor = this.getMinor();
        result = result * prime + ($minor == null ? 43 : $minor.hashCode());
        Object $platform = this.getPlatform();
        result = result * prime + ($platform == null ? 43 : $platform.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Info(" + "buildDate=" + this.getBuildDate() + ", compiler=" + this.getCompiler() + ", emulationMajor=" + this.getEmulationMajor() + ", emulationMinor=" + this.getEmulationMinor() + ", gitCommit=" + this.getGitCommit() + ", gitTreeState=" + this.getGitTreeState() + ", gitVersion=" + this.getGitVersion() + ", goVersion=" + this.getGoVersion() + ", major=" + this.getMajor() + ", minCompatibilityMajor=" + this.getMinCompatibilityMajor() + ", minCompatibilityMinor=" + this.getMinCompatibilityMinor() + ", minor=" + this.getMinor() + ", platform=" + this.getPlatform() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
