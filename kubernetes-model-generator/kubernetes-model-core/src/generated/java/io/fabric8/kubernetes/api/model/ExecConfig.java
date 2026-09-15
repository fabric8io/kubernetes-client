
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "args",
    "command",
    "env",
    "installHint",
    "interactiveMode",
    "provideClusterInfo"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ExecConfig implements Editable<ExecConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> args = new ArrayList<>();
    @JsonProperty("command")
    private String command;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ExecEnvVar> env = new ArrayList<>();
    @JsonProperty("installHint")
    private String installHint;
    @JsonProperty("interactiveMode")
    private String interactiveMode;
    @JsonProperty("provideClusterInfo")
    private Boolean provideClusterInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ExecConfig() {
    }

    public ExecConfig(String apiVersion, List<String> args, String command, List<ExecEnvVar> env, String installHint, String interactiveMode, Boolean provideClusterInfo) {
        super();
        this.apiVersion = apiVersion;
        this.args = args;
        this.command = command;
        this.env = env;
        this.installHint = installHint;
        this.interactiveMode = interactiveMode;
        this.provideClusterInfo = provideClusterInfo;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("args")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getArgs() {
        return args;
    }

    @JsonProperty("args")
    public void setArgs(List<String> args) {
        this.args = args;
    }

    @JsonProperty("command")
    public String getCommand() {
        return command;
    }

    @JsonProperty("command")
    public void setCommand(String command) {
        this.command = command;
    }

    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ExecEnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<ExecEnvVar> env) {
        this.env = env;
    }

    @JsonProperty("installHint")
    public String getInstallHint() {
        return installHint;
    }

    @JsonProperty("installHint")
    public void setInstallHint(String installHint) {
        this.installHint = installHint;
    }

    @JsonProperty("interactiveMode")
    public String getInteractiveMode() {
        return interactiveMode;
    }

    @JsonProperty("interactiveMode")
    public void setInteractiveMode(String interactiveMode) {
        this.interactiveMode = interactiveMode;
    }

    @JsonProperty("provideClusterInfo")
    public Boolean getProvideClusterInfo() {
        return provideClusterInfo;
    }

    @JsonProperty("provideClusterInfo")
    public void setProvideClusterInfo(Boolean provideClusterInfo) {
        this.provideClusterInfo = provideClusterInfo;
    }

    @JsonIgnore
    public ExecConfigBuilder edit() {
        return new ExecConfigBuilder(this);
    }

    @JsonIgnore
    public ExecConfigBuilder toBuilder() {
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
        if (!(o instanceof ExecConfig)) {
            return false;
        }
        ExecConfig other = (ExecConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$args = this.getArgs();
        Object other$args = other.getArgs();
        if (this$args == null ? other$args != null : !this$args.equals(other$args)) {
            return false;
        }
        Object this$command = this.getCommand();
        Object other$command = other.getCommand();
        if (this$command == null ? other$command != null : !this$command.equals(other$command)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$installHint = this.getInstallHint();
        Object other$installHint = other.getInstallHint();
        if (this$installHint == null ? other$installHint != null : !this$installHint.equals(other$installHint)) {
            return false;
        }
        Object this$interactiveMode = this.getInteractiveMode();
        Object other$interactiveMode = other.getInteractiveMode();
        if (this$interactiveMode == null ? other$interactiveMode != null : !this$interactiveMode.equals(other$interactiveMode)) {
            return false;
        }
        Object this$provideClusterInfo = this.getProvideClusterInfo();
        Object other$provideClusterInfo = other.getProvideClusterInfo();
        if (this$provideClusterInfo == null ? other$provideClusterInfo != null : !this$provideClusterInfo.equals(other$provideClusterInfo)) {
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
        return other instanceof ExecConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $args = this.getArgs();
        result = result * prime + ($args == null ? 43 : $args.hashCode());
        Object $command = this.getCommand();
        result = result * prime + ($command == null ? 43 : $command.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $installHint = this.getInstallHint();
        result = result * prime + ($installHint == null ? 43 : $installHint.hashCode());
        Object $interactiveMode = this.getInteractiveMode();
        result = result * prime + ($interactiveMode == null ? 43 : $interactiveMode.hashCode());
        Object $provideClusterInfo = this.getProvideClusterInfo();
        result = result * prime + ($provideClusterInfo == null ? 43 : $provideClusterInfo.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ExecConfig(" + "apiVersion=" + this.getApiVersion() + ", args=" + this.getArgs() + ", command=" + this.getCommand() + ", env=" + this.getEnv() + ", installHint=" + this.getInstallHint() + ", interactiveMode=" + this.getInteractiveMode() + ", provideClusterInfo=" + this.getProvideClusterInfo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
