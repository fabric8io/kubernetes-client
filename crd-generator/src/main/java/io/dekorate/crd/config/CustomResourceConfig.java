package io.dekorate.crd.config;

import io.dekorate.project.Project;
import io.dekorate.crd.annotation.Autodetect;
import io.dekorate.kubernetes.config.ConfigKey;
import io.dekorate.kubernetes.config.Configuration;
import java.lang.Object;
import java.lang.String;
import java.util.Map;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder", refs = { @BuildableReference(Configuration.class) })
public class CustomResourceConfig extends Configuration {

  public static final String AUTODETECT = Autodetect.class.getName();

  private String group = "";
  private String kind = "";
  private String name = "";
  private String plural = "";
  private String shortName = "";
  private String version = "";
  private boolean served = false;
  private boolean storage = false;
  private Scope scope = io.dekorate.crd.config.Scope.Namespaced;
  private Scale scale = null;
  private String statusClassName = AUTODETECT;

  public CustomResourceConfig() {
  }

  public CustomResourceConfig(Project project, Map<ConfigKey, Object> attributes, String group, String kind,
      String name, String plural, String shortName, String version, boolean served, boolean storage, Scope scope,
      Scale scale, String statusClassName) {
    super(project, attributes);
    this.group = group != null ? group : "";
    this.kind = kind != null ? kind : "";
    this.name = name != null ? name : "";
    this.plural = plural != null ? plural : "";
    this.shortName = shortName != null ? shortName : "";
    this.version = version != null ? version : "";
    this.storage = storage;
    this.served = served;
    this.scope = scope != null ? scope : Scope.Namespaced;
    this.scale = scale != null ? scale : null;
    this.statusClassName = statusClassName != null ? statusClassName : AUTODETECT;
  }

  public String getGroup() {
    return this.group;
  }

  public String getKind() {
    return this.kind;
  }

  public String getName() {
    return this.name;
  }

  public String getPlural() {
    return this.plural;
  }

  public String getShortName() {
    return this.shortName;
  }

  public String getVersion() {
    return this.version;
  }

  public boolean isServed() {
    return this.served;
  }

  public boolean isStorage() {
    return this.storage;
  }

  public Scope getScope() {
    return this.scope;
  }

  public Scale getScale() {
    return this.scale;
  }

  public String getStatusClassName() {
    return this.statusClassName;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((group == null) ? 0 : group.hashCode());
    result = prime * result + ((kind == null) ? 0 : kind.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((plural == null) ? 0 : plural.hashCode());
    result = prime * result + ((scale == null) ? 0 : scale.hashCode());
    result = prime * result + ((scope == null) ? 0 : scope.hashCode());
    result = prime * result + (served ? 1231 : 1237);
    result = prime * result + ((shortName == null) ? 0 : shortName.hashCode());
    result = prime * result + ((statusClassName == null) ? 0 : statusClassName.hashCode());
    result = prime * result + (storage ? 1231 : 1237);
    result = prime * result + ((version == null) ? 0 : version.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CustomResourceConfig other = (CustomResourceConfig) obj;
    if (group == null) {
      if (other.group != null)
        return false;
    } else if (!group.equals(other.group))
      return false;
    if (kind == null) {
      if (other.kind != null)
        return false;
    } else if (!kind.equals(other.kind))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (plural == null) {
      if (other.plural != null)
        return false;
    } else if (!plural.equals(other.plural))
      return false;
    if (scale == null) {
      if (other.scale != null)
        return false;
    } else if (!scale.equals(other.scale))
      return false;
    if (scope != other.scope)
      return false;
    if (served != other.served)
      return false;
    if (shortName == null) {
      if (other.shortName != null)
        return false;
    } else if (!shortName.equals(other.shortName))
      return false;
    if (statusClassName == null) {
      if (other.statusClassName != null)
        return false;
    } else if (!statusClassName.equals(other.statusClassName))
      return false;
    if (storage != other.storage)
      return false;
    if (version == null) {
      if (other.version != null)
        return false;
    } else if (!version.equals(other.version))
      return false;
    return true;
  }
}
