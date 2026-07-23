package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.openshift.api.model.config.v1.ConfigMapFileReference;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConsoleCustomizationFluent<A extends io.fabric8.openshift.api.model.operator.v1.ConsoleCustomizationFluent<A>> extends BaseFluent<A>{

  private AddPageBuilder addPage;
  private Map<String,Object> additionalProperties;
  private String brand;
  private ArrayList<CapabilityBuilder> capabilities = new ArrayList<CapabilityBuilder>();
  private ConfigMapFileReference customLogoFile;
  private String customProductName;
  private DeveloperConsoleCatalogCustomizationBuilder developerCatalog;
  private String documentationBaseURL;
  private ArrayList<LogoBuilder> logos = new ArrayList<LogoBuilder>();
  private ArrayList<PerspectiveBuilder> perspectives = new ArrayList<PerspectiveBuilder>();
  private ProjectAccessBuilder projectAccess;
  private QuickStartsBuilder quickStarts;

  public ConsoleCustomizationFluent() {
  }
  
  public ConsoleCustomizationFluent(ConsoleCustomization instance) {
    this.copyInstance(instance);
  }

  public A addAllToCapabilities(Collection<Capability> items) {
    if (this.capabilities == null) {
      this.capabilities = new ArrayList();
    }
    for (Capability item : items) {
        CapabilityBuilder builder = new CapabilityBuilder(item);
        _visitables.get("capabilities").add(builder);
        this.capabilities.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToLogos(Collection<Logo> items) {
    if (this.logos == null) {
      this.logos = new ArrayList();
    }
    for (Logo item : items) {
        LogoBuilder builder = new LogoBuilder(item);
        _visitables.get("logos").add(builder);
        this.logos.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPerspectives(Collection<Perspective> items) {
    if (this.perspectives == null) {
      this.perspectives = new ArrayList();
    }
    for (Perspective item : items) {
        PerspectiveBuilder builder = new PerspectiveBuilder(item);
        _visitables.get("perspectives").add(builder);
        this.perspectives.add(builder);
    }
    return (A) this;
  }
  
  public CapabilitiesNested<A> addNewCapability() {
    return new CapabilitiesNested(-1, null);
  }
  
  public CapabilitiesNested<A> addNewCapabilityLike(Capability item) {
    return new CapabilitiesNested(-1, item);
  }
  
  public LogosNested<A> addNewLogo() {
    return new LogosNested(-1, null);
  }
  
  public LogosNested<A> addNewLogoLike(Logo item) {
    return new LogosNested(-1, item);
  }
  
  public PerspectivesNested<A> addNewPerspective() {
    return new PerspectivesNested(-1, null);
  }
  
  public PerspectivesNested<A> addNewPerspectiveLike(Perspective item) {
    return new PerspectivesNested(-1, item);
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
  
  public A addToCapabilities(Capability... items) {
    if (this.capabilities == null) {
      this.capabilities = new ArrayList();
    }
    for (Capability item : items) {
        CapabilityBuilder builder = new CapabilityBuilder(item);
        _visitables.get("capabilities").add(builder);
        this.capabilities.add(builder);
    }
    return (A) this;
  }
  
  public A addToCapabilities(int index,Capability item) {
    if (this.capabilities == null) {
      this.capabilities = new ArrayList();
    }
    CapabilityBuilder builder = new CapabilityBuilder(item);
    if (index < 0 || index >= capabilities.size()) {
        _visitables.get("capabilities").add(builder);
        capabilities.add(builder);
    } else {
        _visitables.get("capabilities").add(builder);
        capabilities.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToLogos(Logo... items) {
    if (this.logos == null) {
      this.logos = new ArrayList();
    }
    for (Logo item : items) {
        LogoBuilder builder = new LogoBuilder(item);
        _visitables.get("logos").add(builder);
        this.logos.add(builder);
    }
    return (A) this;
  }
  
  public A addToLogos(int index,Logo item) {
    if (this.logos == null) {
      this.logos = new ArrayList();
    }
    LogoBuilder builder = new LogoBuilder(item);
    if (index < 0 || index >= logos.size()) {
        _visitables.get("logos").add(builder);
        logos.add(builder);
    } else {
        _visitables.get("logos").add(builder);
        logos.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPerspectives(Perspective... items) {
    if (this.perspectives == null) {
      this.perspectives = new ArrayList();
    }
    for (Perspective item : items) {
        PerspectiveBuilder builder = new PerspectiveBuilder(item);
        _visitables.get("perspectives").add(builder);
        this.perspectives.add(builder);
    }
    return (A) this;
  }
  
  public A addToPerspectives(int index,Perspective item) {
    if (this.perspectives == null) {
      this.perspectives = new ArrayList();
    }
    PerspectiveBuilder builder = new PerspectiveBuilder(item);
    if (index < 0 || index >= perspectives.size()) {
        _visitables.get("perspectives").add(builder);
        perspectives.add(builder);
    } else {
        _visitables.get("perspectives").add(builder);
        perspectives.add(index, builder);
    }
    return (A) this;
  }
  
  public AddPage buildAddPage() {
    return this.addPage != null ? this.addPage.build() : null;
  }
  
  public List<Capability> buildCapabilities() {
    return this.capabilities != null ? build(capabilities) : null;
  }
  
  public Capability buildCapability(int index) {
    return this.capabilities.get(index).build();
  }
  
  public DeveloperConsoleCatalogCustomization buildDeveloperCatalog() {
    return this.developerCatalog != null ? this.developerCatalog.build() : null;
  }
  
  public Capability buildFirstCapability() {
    return this.capabilities.get(0).build();
  }
  
  public Logo buildFirstLogo() {
    return this.logos.get(0).build();
  }
  
  public Perspective buildFirstPerspective() {
    return this.perspectives.get(0).build();
  }
  
  public Capability buildLastCapability() {
    return this.capabilities.get(capabilities.size() - 1).build();
  }
  
  public Logo buildLastLogo() {
    return this.logos.get(logos.size() - 1).build();
  }
  
  public Perspective buildLastPerspective() {
    return this.perspectives.get(perspectives.size() - 1).build();
  }
  
  public Logo buildLogo(int index) {
    return this.logos.get(index).build();
  }
  
  public List<Logo> buildLogos() {
    return this.logos != null ? build(logos) : null;
  }
  
  public Capability buildMatchingCapability(Predicate<CapabilityBuilder> predicate) {
      for (CapabilityBuilder item : capabilities) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Logo buildMatchingLogo(Predicate<LogoBuilder> predicate) {
      for (LogoBuilder item : logos) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Perspective buildMatchingPerspective(Predicate<PerspectiveBuilder> predicate) {
      for (PerspectiveBuilder item : perspectives) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Perspective buildPerspective(int index) {
    return this.perspectives.get(index).build();
  }
  
  public List<Perspective> buildPerspectives() {
    return this.perspectives != null ? build(perspectives) : null;
  }
  
  public ProjectAccess buildProjectAccess() {
    return this.projectAccess != null ? this.projectAccess.build() : null;
  }
  
  public QuickStarts buildQuickStarts() {
    return this.quickStarts != null ? this.quickStarts.build() : null;
  }
  
  protected void copyInstance(ConsoleCustomization instance) {
    instance = instance != null ? instance : new ConsoleCustomization();
    if (instance != null) {
        this.withAddPage(instance.getAddPage());
        this.withBrand(instance.getBrand());
        this.withCapabilities(instance.getCapabilities());
        this.withCustomLogoFile(instance.getCustomLogoFile());
        this.withCustomProductName(instance.getCustomProductName());
        this.withDeveloperCatalog(instance.getDeveloperCatalog());
        this.withDocumentationBaseURL(instance.getDocumentationBaseURL());
        this.withLogos(instance.getLogos());
        this.withPerspectives(instance.getPerspectives());
        this.withProjectAccess(instance.getProjectAccess());
        this.withQuickStarts(instance.getQuickStarts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddPageNested<A> editAddPage() {
    return this.withNewAddPageLike(Optional.ofNullable(this.buildAddPage()).orElse(null));
  }
  
  public CapabilitiesNested<A> editCapability(int index) {
    if (capabilities.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "capabilities"));
    }
    return this.setNewCapabilityLike(index, this.buildCapability(index));
  }
  
  public DeveloperCatalogNested<A> editDeveloperCatalog() {
    return this.withNewDeveloperCatalogLike(Optional.ofNullable(this.buildDeveloperCatalog()).orElse(null));
  }
  
  public CapabilitiesNested<A> editFirstCapability() {
    if (capabilities.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "capabilities"));
    }
    return this.setNewCapabilityLike(0, this.buildCapability(0));
  }
  
  public LogosNested<A> editFirstLogo() {
    if (logos.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "logos"));
    }
    return this.setNewLogoLike(0, this.buildLogo(0));
  }
  
  public PerspectivesNested<A> editFirstPerspective() {
    if (perspectives.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "perspectives"));
    }
    return this.setNewPerspectiveLike(0, this.buildPerspective(0));
  }
  
  public CapabilitiesNested<A> editLastCapability() {
    int index = capabilities.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "capabilities"));
    }
    return this.setNewCapabilityLike(index, this.buildCapability(index));
  }
  
  public LogosNested<A> editLastLogo() {
    int index = logos.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "logos"));
    }
    return this.setNewLogoLike(index, this.buildLogo(index));
  }
  
  public PerspectivesNested<A> editLastPerspective() {
    int index = perspectives.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "perspectives"));
    }
    return this.setNewPerspectiveLike(index, this.buildPerspective(index));
  }
  
  public LogosNested<A> editLogo(int index) {
    if (logos.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "logos"));
    }
    return this.setNewLogoLike(index, this.buildLogo(index));
  }
  
  public CapabilitiesNested<A> editMatchingCapability(Predicate<CapabilityBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < capabilities.size();i++) {
      if (predicate.test(capabilities.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "capabilities"));
    }
    return this.setNewCapabilityLike(index, this.buildCapability(index));
  }
  
  public LogosNested<A> editMatchingLogo(Predicate<LogoBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < logos.size();i++) {
      if (predicate.test(logos.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "logos"));
    }
    return this.setNewLogoLike(index, this.buildLogo(index));
  }
  
  public PerspectivesNested<A> editMatchingPerspective(Predicate<PerspectiveBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < perspectives.size();i++) {
      if (predicate.test(perspectives.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "perspectives"));
    }
    return this.setNewPerspectiveLike(index, this.buildPerspective(index));
  }
  
  public AddPageNested<A> editOrNewAddPage() {
    return this.withNewAddPageLike(Optional.ofNullable(this.buildAddPage()).orElse(new AddPageBuilder().build()));
  }
  
  public AddPageNested<A> editOrNewAddPageLike(AddPage item) {
    return this.withNewAddPageLike(Optional.ofNullable(this.buildAddPage()).orElse(item));
  }
  
  public DeveloperCatalogNested<A> editOrNewDeveloperCatalog() {
    return this.withNewDeveloperCatalogLike(Optional.ofNullable(this.buildDeveloperCatalog()).orElse(new DeveloperConsoleCatalogCustomizationBuilder().build()));
  }
  
  public DeveloperCatalogNested<A> editOrNewDeveloperCatalogLike(DeveloperConsoleCatalogCustomization item) {
    return this.withNewDeveloperCatalogLike(Optional.ofNullable(this.buildDeveloperCatalog()).orElse(item));
  }
  
  public ProjectAccessNested<A> editOrNewProjectAccess() {
    return this.withNewProjectAccessLike(Optional.ofNullable(this.buildProjectAccess()).orElse(new ProjectAccessBuilder().build()));
  }
  
  public ProjectAccessNested<A> editOrNewProjectAccessLike(ProjectAccess item) {
    return this.withNewProjectAccessLike(Optional.ofNullable(this.buildProjectAccess()).orElse(item));
  }
  
  public QuickStartsNested<A> editOrNewQuickStarts() {
    return this.withNewQuickStartsLike(Optional.ofNullable(this.buildQuickStarts()).orElse(new QuickStartsBuilder().build()));
  }
  
  public QuickStartsNested<A> editOrNewQuickStartsLike(QuickStarts item) {
    return this.withNewQuickStartsLike(Optional.ofNullable(this.buildQuickStarts()).orElse(item));
  }
  
  public PerspectivesNested<A> editPerspective(int index) {
    if (perspectives.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "perspectives"));
    }
    return this.setNewPerspectiveLike(index, this.buildPerspective(index));
  }
  
  public ProjectAccessNested<A> editProjectAccess() {
    return this.withNewProjectAccessLike(Optional.ofNullable(this.buildProjectAccess()).orElse(null));
  }
  
  public QuickStartsNested<A> editQuickStarts() {
    return this.withNewQuickStartsLike(Optional.ofNullable(this.buildQuickStarts()).orElse(null));
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
    ConsoleCustomizationFluent that = (ConsoleCustomizationFluent) o;
    if (!(Objects.equals(addPage, that.addPage))) {
      return false;
    }
    if (!(Objects.equals(brand, that.brand))) {
      return false;
    }
    if (!(Objects.equals(capabilities, that.capabilities))) {
      return false;
    }
    if (!(Objects.equals(customLogoFile, that.customLogoFile))) {
      return false;
    }
    if (!(Objects.equals(customProductName, that.customProductName))) {
      return false;
    }
    if (!(Objects.equals(developerCatalog, that.developerCatalog))) {
      return false;
    }
    if (!(Objects.equals(documentationBaseURL, that.documentationBaseURL))) {
      return false;
    }
    if (!(Objects.equals(logos, that.logos))) {
      return false;
    }
    if (!(Objects.equals(perspectives, that.perspectives))) {
      return false;
    }
    if (!(Objects.equals(projectAccess, that.projectAccess))) {
      return false;
    }
    if (!(Objects.equals(quickStarts, that.quickStarts))) {
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
  
  public String getBrand() {
    return this.brand;
  }
  
  public ConfigMapFileReference getCustomLogoFile() {
    return this.customLogoFile;
  }
  
  public String getCustomProductName() {
    return this.customProductName;
  }
  
  public String getDocumentationBaseURL() {
    return this.documentationBaseURL;
  }
  
  public boolean hasAddPage() {
    return this.addPage != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBrand() {
    return this.brand != null;
  }
  
  public boolean hasCapabilities() {
    return this.capabilities != null && !(this.capabilities.isEmpty());
  }
  
  public boolean hasCustomLogoFile() {
    return this.customLogoFile != null;
  }
  
  public boolean hasCustomProductName() {
    return this.customProductName != null;
  }
  
  public boolean hasDeveloperCatalog() {
    return this.developerCatalog != null;
  }
  
  public boolean hasDocumentationBaseURL() {
    return this.documentationBaseURL != null;
  }
  
  public boolean hasLogos() {
    return this.logos != null && !(this.logos.isEmpty());
  }
  
  public boolean hasMatchingCapability(Predicate<CapabilityBuilder> predicate) {
      for (CapabilityBuilder item : capabilities) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingLogo(Predicate<LogoBuilder> predicate) {
      for (LogoBuilder item : logos) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPerspective(Predicate<PerspectiveBuilder> predicate) {
      for (PerspectiveBuilder item : perspectives) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPerspectives() {
    return this.perspectives != null && !(this.perspectives.isEmpty());
  }
  
  public boolean hasProjectAccess() {
    return this.projectAccess != null;
  }
  
  public boolean hasQuickStarts() {
    return this.quickStarts != null;
  }
  
  public int hashCode() {
    return Objects.hash(addPage, brand, capabilities, customLogoFile, customProductName, developerCatalog, documentationBaseURL, logos, perspectives, projectAccess, quickStarts, additionalProperties);
  }
  
  public A removeAllFromCapabilities(Collection<Capability> items) {
    if (this.capabilities == null) {
      return (A) this;
    }
    for (Capability item : items) {
        CapabilityBuilder builder = new CapabilityBuilder(item);
        _visitables.get("capabilities").remove(builder);
        this.capabilities.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromLogos(Collection<Logo> items) {
    if (this.logos == null) {
      return (A) this;
    }
    for (Logo item : items) {
        LogoBuilder builder = new LogoBuilder(item);
        _visitables.get("logos").remove(builder);
        this.logos.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPerspectives(Collection<Perspective> items) {
    if (this.perspectives == null) {
      return (A) this;
    }
    for (Perspective item : items) {
        PerspectiveBuilder builder = new PerspectiveBuilder(item);
        _visitables.get("perspectives").remove(builder);
        this.perspectives.remove(builder);
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
  
  public A removeFromCapabilities(Capability... items) {
    if (this.capabilities == null) {
      return (A) this;
    }
    for (Capability item : items) {
        CapabilityBuilder builder = new CapabilityBuilder(item);
        _visitables.get("capabilities").remove(builder);
        this.capabilities.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromLogos(Logo... items) {
    if (this.logos == null) {
      return (A) this;
    }
    for (Logo item : items) {
        LogoBuilder builder = new LogoBuilder(item);
        _visitables.get("logos").remove(builder);
        this.logos.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPerspectives(Perspective... items) {
    if (this.perspectives == null) {
      return (A) this;
    }
    for (Perspective item : items) {
        PerspectiveBuilder builder = new PerspectiveBuilder(item);
        _visitables.get("perspectives").remove(builder);
        this.perspectives.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCapabilities(Predicate<CapabilityBuilder> predicate) {
    if (capabilities == null) {
      return (A) this;
    }
    Iterator<CapabilityBuilder> each = capabilities.iterator();
    List visitables = _visitables.get("capabilities");
    while (each.hasNext()) {
        CapabilityBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromLogos(Predicate<LogoBuilder> predicate) {
    if (logos == null) {
      return (A) this;
    }
    Iterator<LogoBuilder> each = logos.iterator();
    List visitables = _visitables.get("logos");
    while (each.hasNext()) {
        LogoBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPerspectives(Predicate<PerspectiveBuilder> predicate) {
    if (perspectives == null) {
      return (A) this;
    }
    Iterator<PerspectiveBuilder> each = perspectives.iterator();
    List visitables = _visitables.get("perspectives");
    while (each.hasNext()) {
        PerspectiveBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CapabilitiesNested<A> setNewCapabilityLike(int index,Capability item) {
    return new CapabilitiesNested(index, item);
  }
  
  public LogosNested<A> setNewLogoLike(int index,Logo item) {
    return new LogosNested(index, item);
  }
  
  public PerspectivesNested<A> setNewPerspectiveLike(int index,Perspective item) {
    return new PerspectivesNested(index, item);
  }
  
  public A setToCapabilities(int index,Capability item) {
    if (this.capabilities == null) {
      this.capabilities = new ArrayList();
    }
    CapabilityBuilder builder = new CapabilityBuilder(item);
    if (index < 0 || index >= capabilities.size()) {
        _visitables.get("capabilities").add(builder);
        capabilities.add(builder);
    } else {
        _visitables.get("capabilities").add(builder);
        capabilities.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToLogos(int index,Logo item) {
    if (this.logos == null) {
      this.logos = new ArrayList();
    }
    LogoBuilder builder = new LogoBuilder(item);
    if (index < 0 || index >= logos.size()) {
        _visitables.get("logos").add(builder);
        logos.add(builder);
    } else {
        _visitables.get("logos").add(builder);
        logos.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPerspectives(int index,Perspective item) {
    if (this.perspectives == null) {
      this.perspectives = new ArrayList();
    }
    PerspectiveBuilder builder = new PerspectiveBuilder(item);
    if (index < 0 || index >= perspectives.size()) {
        _visitables.get("perspectives").add(builder);
        perspectives.add(builder);
    } else {
        _visitables.get("perspectives").add(builder);
        perspectives.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(addPage == null)) {
        sb.append("addPage:");
        sb.append(addPage);
        sb.append(",");
    }
    if (!(brand == null)) {
        sb.append("brand:");
        sb.append(brand);
        sb.append(",");
    }
    if (!(capabilities == null) && !(capabilities.isEmpty())) {
        sb.append("capabilities:");
        sb.append(capabilities);
        sb.append(",");
    }
    if (!(customLogoFile == null)) {
        sb.append("customLogoFile:");
        sb.append(customLogoFile);
        sb.append(",");
    }
    if (!(customProductName == null)) {
        sb.append("customProductName:");
        sb.append(customProductName);
        sb.append(",");
    }
    if (!(developerCatalog == null)) {
        sb.append("developerCatalog:");
        sb.append(developerCatalog);
        sb.append(",");
    }
    if (!(documentationBaseURL == null)) {
        sb.append("documentationBaseURL:");
        sb.append(documentationBaseURL);
        sb.append(",");
    }
    if (!(logos == null) && !(logos.isEmpty())) {
        sb.append("logos:");
        sb.append(logos);
        sb.append(",");
    }
    if (!(perspectives == null) && !(perspectives.isEmpty())) {
        sb.append("perspectives:");
        sb.append(perspectives);
        sb.append(",");
    }
    if (!(projectAccess == null)) {
        sb.append("projectAccess:");
        sb.append(projectAccess);
        sb.append(",");
    }
    if (!(quickStarts == null)) {
        sb.append("quickStarts:");
        sb.append(quickStarts);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAddPage(AddPage addPage) {
    this._visitables.remove("addPage");
    if (addPage != null) {
        this.addPage = new AddPageBuilder(addPage);
        this._visitables.get("addPage").add(this.addPage);
    } else {
        this.addPage = null;
        this._visitables.get("addPage").remove(this.addPage);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBrand(String brand) {
    this.brand = brand;
    return (A) this;
  }
  
  public A withCapabilities(List<Capability> capabilities) {
    if (this.capabilities != null) {
      this._visitables.get("capabilities").clear();
    }
    if (capabilities != null) {
        this.capabilities = new ArrayList();
        for (Capability item : capabilities) {
          this.addToCapabilities(item);
        }
    } else {
      this.capabilities = null;
    }
    return (A) this;
  }
  
  public A withCapabilities(Capability... capabilities) {
    if (this.capabilities != null) {
        this.capabilities.clear();
        _visitables.remove("capabilities");
    }
    if (capabilities != null) {
      for (Capability item : capabilities) {
        this.addToCapabilities(item);
      }
    }
    return (A) this;
  }
  
  public A withCustomLogoFile(ConfigMapFileReference customLogoFile) {
    this.customLogoFile = customLogoFile;
    return (A) this;
  }
  
  public A withCustomProductName(String customProductName) {
    this.customProductName = customProductName;
    return (A) this;
  }
  
  public A withDeveloperCatalog(DeveloperConsoleCatalogCustomization developerCatalog) {
    this._visitables.remove("developerCatalog");
    if (developerCatalog != null) {
        this.developerCatalog = new DeveloperConsoleCatalogCustomizationBuilder(developerCatalog);
        this._visitables.get("developerCatalog").add(this.developerCatalog);
    } else {
        this.developerCatalog = null;
        this._visitables.get("developerCatalog").remove(this.developerCatalog);
    }
    return (A) this;
  }
  
  public A withDocumentationBaseURL(String documentationBaseURL) {
    this.documentationBaseURL = documentationBaseURL;
    return (A) this;
  }
  
  public A withLogos(List<Logo> logos) {
    if (this.logos != null) {
      this._visitables.get("logos").clear();
    }
    if (logos != null) {
        this.logos = new ArrayList();
        for (Logo item : logos) {
          this.addToLogos(item);
        }
    } else {
      this.logos = null;
    }
    return (A) this;
  }
  
  public A withLogos(Logo... logos) {
    if (this.logos != null) {
        this.logos.clear();
        _visitables.remove("logos");
    }
    if (logos != null) {
      for (Logo item : logos) {
        this.addToLogos(item);
      }
    }
    return (A) this;
  }
  
  public AddPageNested<A> withNewAddPage() {
    return new AddPageNested(null);
  }
  
  public AddPageNested<A> withNewAddPageLike(AddPage item) {
    return new AddPageNested(item);
  }
  
  public A withNewCustomLogoFile(String key,String name) {
    return (A) this.withCustomLogoFile(new ConfigMapFileReference(key, name));
  }
  
  public DeveloperCatalogNested<A> withNewDeveloperCatalog() {
    return new DeveloperCatalogNested(null);
  }
  
  public DeveloperCatalogNested<A> withNewDeveloperCatalogLike(DeveloperConsoleCatalogCustomization item) {
    return new DeveloperCatalogNested(item);
  }
  
  public ProjectAccessNested<A> withNewProjectAccess() {
    return new ProjectAccessNested(null);
  }
  
  public ProjectAccessNested<A> withNewProjectAccessLike(ProjectAccess item) {
    return new ProjectAccessNested(item);
  }
  
  public QuickStartsNested<A> withNewQuickStarts() {
    return new QuickStartsNested(null);
  }
  
  public QuickStartsNested<A> withNewQuickStartsLike(QuickStarts item) {
    return new QuickStartsNested(item);
  }
  
  public A withPerspectives(List<Perspective> perspectives) {
    if (this.perspectives != null) {
      this._visitables.get("perspectives").clear();
    }
    if (perspectives != null) {
        this.perspectives = new ArrayList();
        for (Perspective item : perspectives) {
          this.addToPerspectives(item);
        }
    } else {
      this.perspectives = null;
    }
    return (A) this;
  }
  
  public A withPerspectives(Perspective... perspectives) {
    if (this.perspectives != null) {
        this.perspectives.clear();
        _visitables.remove("perspectives");
    }
    if (perspectives != null) {
      for (Perspective item : perspectives) {
        this.addToPerspectives(item);
      }
    }
    return (A) this;
  }
  
  public A withProjectAccess(ProjectAccess projectAccess) {
    this._visitables.remove("projectAccess");
    if (projectAccess != null) {
        this.projectAccess = new ProjectAccessBuilder(projectAccess);
        this._visitables.get("projectAccess").add(this.projectAccess);
    } else {
        this.projectAccess = null;
        this._visitables.get("projectAccess").remove(this.projectAccess);
    }
    return (A) this;
  }
  
  public A withQuickStarts(QuickStarts quickStarts) {
    this._visitables.remove("quickStarts");
    if (quickStarts != null) {
        this.quickStarts = new QuickStartsBuilder(quickStarts);
        this._visitables.get("quickStarts").add(this.quickStarts);
    } else {
        this.quickStarts = null;
        this._visitables.get("quickStarts").remove(this.quickStarts);
    }
    return (A) this;
  }
  public class AddPageNested<N> extends AddPageFluent<AddPageNested<N>> implements Nested<N>{
  
    AddPageBuilder builder;
  
    AddPageNested(AddPage item) {
      this.builder = new AddPageBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCustomizationFluent.this.withAddPage(builder.build());
    }
    
    public N endAddPage() {
      return and();
    }
    
  }
  public class CapabilitiesNested<N> extends CapabilityFluent<CapabilitiesNested<N>> implements Nested<N>{
  
    CapabilityBuilder builder;
    int index;
  
    CapabilitiesNested(int index,Capability item) {
      this.index = index;
      this.builder = new CapabilityBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCustomizationFluent.this.setToCapabilities(index, builder.build());
    }
    
    public N endCapability() {
      return and();
    }
    
  }
  public class DeveloperCatalogNested<N> extends DeveloperConsoleCatalogCustomizationFluent<DeveloperCatalogNested<N>> implements Nested<N>{
  
    DeveloperConsoleCatalogCustomizationBuilder builder;
  
    DeveloperCatalogNested(DeveloperConsoleCatalogCustomization item) {
      this.builder = new DeveloperConsoleCatalogCustomizationBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCustomizationFluent.this.withDeveloperCatalog(builder.build());
    }
    
    public N endDeveloperCatalog() {
      return and();
    }
    
  }
  public class LogosNested<N> extends LogoFluent<LogosNested<N>> implements Nested<N>{
  
    LogoBuilder builder;
    int index;
  
    LogosNested(int index,Logo item) {
      this.index = index;
      this.builder = new LogoBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCustomizationFluent.this.setToLogos(index, builder.build());
    }
    
    public N endLogo() {
      return and();
    }
    
  }
  public class PerspectivesNested<N> extends PerspectiveFluent<PerspectivesNested<N>> implements Nested<N>{
  
    PerspectiveBuilder builder;
    int index;
  
    PerspectivesNested(int index,Perspective item) {
      this.index = index;
      this.builder = new PerspectiveBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCustomizationFluent.this.setToPerspectives(index, builder.build());
    }
    
    public N endPerspective() {
      return and();
    }
    
  }
  public class ProjectAccessNested<N> extends ProjectAccessFluent<ProjectAccessNested<N>> implements Nested<N>{
  
    ProjectAccessBuilder builder;
  
    ProjectAccessNested(ProjectAccess item) {
      this.builder = new ProjectAccessBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCustomizationFluent.this.withProjectAccess(builder.build());
    }
    
    public N endProjectAccess() {
      return and();
    }
    
  }
  public class QuickStartsNested<N> extends QuickStartsFluent<QuickStartsNested<N>> implements Nested<N>{
  
    QuickStartsBuilder builder;
  
    QuickStartsNested(QuickStarts item) {
      this.builder = new QuickStartsBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleCustomizationFluent.this.withQuickStarts(builder.build());
    }
    
    public N endQuickStarts() {
      return and();
    }
    
  }
}