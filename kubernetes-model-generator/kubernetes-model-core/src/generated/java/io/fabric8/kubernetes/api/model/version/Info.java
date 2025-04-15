
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Info contains versioning information. how we'll want to distribute that information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildDate",
    "compiler",
    "gitCommit",
    "gitTreeState",
    "gitVersion",
    "goVersion",
    "major",
    "minor",
    "platform"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Info implements Editable<InfoBuilder>, KubernetesResource
{

    @JsonProperty("buildDate")
    private String buildDate;
    @JsonProperty("compiler")
    private String compiler;
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

    public Info(String buildDate, String compiler, String gitCommit, String gitTreeState, String gitVersion, String goVersion, String major, String minor, String platform) {
        super();
        this.buildDate = buildDate;
        this.compiler = compiler;
        this.gitCommit = gitCommit;
        this.gitTreeState = gitTreeState;
        this.gitVersion = gitVersion;
        this.goVersion = goVersion;
        this.major = major;
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
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("major")
    public String getMajor() {
        return major;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("major")
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
     */
    @JsonProperty("minor")
    public String getMinor() {
        return minor;
    }

    /**
     * Info contains versioning information. how we'll want to distribute that information.
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
