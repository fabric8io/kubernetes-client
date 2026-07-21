package io.fabric8.certmanager.api.model.acme.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.SELinuxOptions;
import io.fabric8.kubernetes.api.model.SeccompProfile;
import io.fabric8.kubernetes.api.model.Sysctl;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent<A extends io.fabric8.certmanager.api.model.acme.v1.ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Long fsGroup;
  private String fsGroupChangePolicy;
  private Long runAsGroup;
  private Boolean runAsNonRoot;
  private Long runAsUser;
  private SELinuxOptions seLinuxOptions;
  private SeccompProfile seccompProfile;
  private List<Long> supplementalGroups = new ArrayList<Long>();
  private List<Sysctl> sysctls = new ArrayList<Sysctl>();

  public ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent() {
  }
  
  public ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent(ACMEChallengeSolverHTTP01IngressPodSecurityContext instance) {
    this.copyInstance(instance);
  }

  public A addAllToSupplementalGroups(Collection<Long> items) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    for (Long item : items) {
      this.supplementalGroups.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSysctls(Collection<Sysctl> items) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    for (Sysctl item : items) {
      this.sysctls.add(item);
    }
    return (A) this;
  }
  
  public A addNewSysctl(String name,String value) {
    return (A) this.addToSysctls(new Sysctl(name, value));
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToSupplementalGroups(Long... items) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    for (Long item : items) {
      this.supplementalGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToSupplementalGroups(int index,Long item) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    this.supplementalGroups.add(index, item);
    return (A) this;
  }
  
  public A addToSysctls(Sysctl... items) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    for (Sysctl item : items) {
      this.sysctls.add(item);
    }
    return (A) this;
  }
  
  public A addToSysctls(int index,Sysctl item) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    this.sysctls.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(ACMEChallengeSolverHTTP01IngressPodSecurityContext instance) {
    instance = instance != null ? instance : new ACMEChallengeSolverHTTP01IngressPodSecurityContext();
    if (instance != null) {
        this.withFsGroup(instance.getFsGroup());
        this.withFsGroupChangePolicy(instance.getFsGroupChangePolicy());
        this.withRunAsGroup(instance.getRunAsGroup());
        this.withRunAsNonRoot(instance.getRunAsNonRoot());
        this.withRunAsUser(instance.getRunAsUser());
        this.withSeLinuxOptions(instance.getSeLinuxOptions());
        this.withSeccompProfile(instance.getSeccompProfile());
        this.withSupplementalGroups(instance.getSupplementalGroups());
        this.withSysctls(instance.getSysctls());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent that = (ACMEChallengeSolverHTTP01IngressPodSecurityContextFluent) o;
    if (!(Objects.equals(fsGroup, that.fsGroup))) {
      return false;
    }
    if (!(Objects.equals(fsGroupChangePolicy, that.fsGroupChangePolicy))) {
      return false;
    }
    if (!(Objects.equals(runAsGroup, that.runAsGroup))) {
      return false;
    }
    if (!(Objects.equals(runAsNonRoot, that.runAsNonRoot))) {
      return false;
    }
    if (!(Objects.equals(runAsUser, that.runAsUser))) {
      return false;
    }
    if (!(Objects.equals(seLinuxOptions, that.seLinuxOptions))) {
      return false;
    }
    if (!(Objects.equals(seccompProfile, that.seccompProfile))) {
      return false;
    }
    if (!(Objects.equals(supplementalGroups, that.supplementalGroups))) {
      return false;
    }
    if (!(Objects.equals(sysctls, that.sysctls))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Long getFirstSupplementalGroup() {
    return this.supplementalGroups.get(0);
  }
  
  public Sysctl getFirstSysctl() {
    return this.sysctls.get(0);
  }
  
  public Long getFsGroup() {
    return this.fsGroup;
  }
  
  public String getFsGroupChangePolicy() {
    return this.fsGroupChangePolicy;
  }
  
  public Long getLastSupplementalGroup() {
    return this.supplementalGroups.get(supplementalGroups.size() - 1);
  }
  
  public Sysctl getLastSysctl() {
    return this.sysctls.get(sysctls.size() - 1);
  }
  
  public Long getMatchingSupplementalGroup(Predicate<Long> predicate) {
      for (Long item : supplementalGroups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Sysctl getMatchingSysctl(Predicate<Sysctl> predicate) {
      for (Sysctl item : sysctls) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getRunAsGroup() {
    return this.runAsGroup;
  }
  
  public Boolean getRunAsNonRoot() {
    return this.runAsNonRoot;
  }
  
  public Long getRunAsUser() {
    return this.runAsUser;
  }
  
  public SELinuxOptions getSeLinuxOptions() {
    return this.seLinuxOptions;
  }
  
  public SeccompProfile getSeccompProfile() {
    return this.seccompProfile;
  }
  
  public Long getSupplementalGroup(int index) {
    return this.supplementalGroups.get(index);
  }
  
  public List<Long> getSupplementalGroups() {
    return this.supplementalGroups;
  }
  
  public Sysctl getSysctl(int index) {
    return this.sysctls.get(index);
  }
  
  public List<Sysctl> getSysctls() {
    return this.sysctls;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFsGroup() {
    return this.fsGroup != null;
  }
  
  public boolean hasFsGroupChangePolicy() {
    return this.fsGroupChangePolicy != null;
  }
  
  public boolean hasMatchingSupplementalGroup(Predicate<Long> predicate) {
      for (Long item : supplementalGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSysctl(Predicate<Sysctl> predicate) {
      for (Sysctl item : sysctls) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRunAsGroup() {
    return this.runAsGroup != null;
  }
  
  public boolean hasRunAsNonRoot() {
    return this.runAsNonRoot != null;
  }
  
  public boolean hasRunAsUser() {
    return this.runAsUser != null;
  }
  
  public boolean hasSeLinuxOptions() {
    return this.seLinuxOptions != null;
  }
  
  public boolean hasSeccompProfile() {
    return this.seccompProfile != null;
  }
  
  public boolean hasSupplementalGroups() {
    return this.supplementalGroups != null && !(this.supplementalGroups.isEmpty());
  }
  
  public boolean hasSysctls() {
    return this.sysctls != null && !(this.sysctls.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(fsGroup, fsGroupChangePolicy, runAsGroup, runAsNonRoot, runAsUser, seLinuxOptions, seccompProfile, supplementalGroups, sysctls, additionalProperties);
  }
  
  public A removeAllFromSupplementalGroups(Collection<Long> items) {
    if (this.supplementalGroups == null) {
      return (A) this;
    }
    for (Long item : items) {
      this.supplementalGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSysctls(Collection<Sysctl> items) {
    if (this.sysctls == null) {
      return (A) this;
    }
    for (Sysctl item : items) {
      this.sysctls.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromSupplementalGroups(Long... items) {
    if (this.supplementalGroups == null) {
      return (A) this;
    }
    for (Long item : items) {
      this.supplementalGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSysctls(Sysctl... items) {
    if (this.sysctls == null) {
      return (A) this;
    }
    for (Sysctl item : items) {
      this.sysctls.remove(item);
    }
    return (A) this;
  }
  
  public A setToSupplementalGroups(int index,Long item) {
    if (this.supplementalGroups == null) {
      this.supplementalGroups = new ArrayList();
    }
    this.supplementalGroups.set(index, item);
    return (A) this;
  }
  
  public A setToSysctls(int index,Sysctl item) {
    if (this.sysctls == null) {
      this.sysctls = new ArrayList();
    }
    this.sysctls.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(fsGroup == null)) {
        sb.append("fsGroup:");
        sb.append(fsGroup);
        sb.append(",");
    }
    if (!(fsGroupChangePolicy == null)) {
        sb.append("fsGroupChangePolicy:");
        sb.append(fsGroupChangePolicy);
        sb.append(",");
    }
    if (!(runAsGroup == null)) {
        sb.append("runAsGroup:");
        sb.append(runAsGroup);
        sb.append(",");
    }
    if (!(runAsNonRoot == null)) {
        sb.append("runAsNonRoot:");
        sb.append(runAsNonRoot);
        sb.append(",");
    }
    if (!(runAsUser == null)) {
        sb.append("runAsUser:");
        sb.append(runAsUser);
        sb.append(",");
    }
    if (!(seLinuxOptions == null)) {
        sb.append("seLinuxOptions:");
        sb.append(seLinuxOptions);
        sb.append(",");
    }
    if (!(seccompProfile == null)) {
        sb.append("seccompProfile:");
        sb.append(seccompProfile);
        sb.append(",");
    }
    if (!(supplementalGroups == null) && !(supplementalGroups.isEmpty())) {
        sb.append("supplementalGroups:");
        sb.append(supplementalGroups);
        sb.append(",");
    }
    if (!(sysctls == null) && !(sysctls.isEmpty())) {
        sb.append("sysctls:");
        sb.append(sysctls);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withFsGroup(Long fsGroup) {
    this.fsGroup = fsGroup;
    return (A) this;
  }
  
  public A withFsGroupChangePolicy(String fsGroupChangePolicy) {
    this.fsGroupChangePolicy = fsGroupChangePolicy;
    return (A) this;
  }
  
  public A withNewSeLinuxOptions(String level,String role,String type,String user) {
    return (A) this.withSeLinuxOptions(new SELinuxOptions(level, role, type, user));
  }
  
  public A withNewSeccompProfile(String localhostProfile,String type) {
    return (A) this.withSeccompProfile(new SeccompProfile(localhostProfile, type));
  }
  
  public A withRunAsGroup(Long runAsGroup) {
    this.runAsGroup = runAsGroup;
    return (A) this;
  }
  
  public A withRunAsNonRoot() {
    return withRunAsNonRoot(true);
  }
  
  public A withRunAsNonRoot(Boolean runAsNonRoot) {
    this.runAsNonRoot = runAsNonRoot;
    return (A) this;
  }
  
  public A withRunAsUser(Long runAsUser) {
    this.runAsUser = runAsUser;
    return (A) this;
  }
  
  public A withSeLinuxOptions(SELinuxOptions seLinuxOptions) {
    this.seLinuxOptions = seLinuxOptions;
    return (A) this;
  }
  
  public A withSeccompProfile(SeccompProfile seccompProfile) {
    this.seccompProfile = seccompProfile;
    return (A) this;
  }
  
  public A withSupplementalGroups(List<Long> supplementalGroups) {
    if (supplementalGroups != null) {
        this.supplementalGroups = new ArrayList();
        for (Long item : supplementalGroups) {
          this.addToSupplementalGroups(item);
        }
    } else {
      this.supplementalGroups = null;
    }
    return (A) this;
  }
  
  public A withSupplementalGroups(Long... supplementalGroups) {
    if (this.supplementalGroups != null) {
        this.supplementalGroups.clear();
        _visitables.remove("supplementalGroups");
    }
    if (supplementalGroups != null) {
      for (Long item : supplementalGroups) {
        this.addToSupplementalGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withSysctls(List<Sysctl> sysctls) {
    if (sysctls != null) {
        this.sysctls = new ArrayList();
        for (Sysctl item : sysctls) {
          this.addToSysctls(item);
        }
    } else {
      this.sysctls = null;
    }
    return (A) this;
  }
  
  public A withSysctls(Sysctl... sysctls) {
    if (this.sysctls != null) {
        this.sysctls.clear();
        _visitables.remove("sysctls");
    }
    if (sysctls != null) {
      for (Sysctl item : sysctls) {
        this.addToSysctls(item);
      }
    }
    return (A) this;
  }
  
}