/*
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 17+
//DEPS com.fasterxml.jackson.core:jackson-databind:2.20.0
//DEPS org.freemarker:freemarker:2.3.34

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Reads revapi-report.json files from target/staging/, generates a per-module
 * HTML page (tables grouped by severity) for each, then writes revapi-index.html
 * summarising all modules.
 * <p>
 * HTML is produced via FreeMarker templates located in scripts/templates/.
 * Data records are used for internal logic; toMap() converters are used at the
 * FreeMarker boundary because FreeMarker cannot reflectively access methods on
 * non-public nested types (a constraint of JBang single-file scripts).
 */
class GenerateRevapiIndex {

  // ── Severity ────────────────────────────────────────────────────────────────

  static final List<String> SEVERITY_ORDER = List.of(
    "BREAKING", "POTENTIALLY_BREAKING", "NON_BREAKING", "EQUIVALENT");

  static final Map<String, String> SEVERITY_LABELS = Map.of(
    "BREAKING", "Breaking Changes",
    "POTENTIALLY_BREAKING", "Potentially Breaking Changes",
    "NON_BREAKING", "Non-Breaking Changes",
    "EQUIVALENT", "Equivalent Changes");

  static String maxSeverity(JsonNode change) {
    JsonNode classifications = change.get("classification");
    if (classifications == null || !classifications.isArray()) return "EQUIVALENT";
    int best = SEVERITY_ORDER.size() - 1;
    for (JsonNode cls : classifications) {
      int idx = SEVERITY_ORDER.indexOf(cls.path("severity").asText("EQUIVALENT"));
      if (idx >= 0 && idx < best) best = idx;
    }
    return SEVERITY_ORDER.get(best);
  }

  static String renderClassifications(JsonNode change) {
    JsonNode classifications = change.get("classification");
    if (classifications == null || !classifications.isArray()) return "";
    List<String> parts = new ArrayList<>();
    for (JsonNode cls : classifications) {
      String compat = cls.path("compatibility").asText("");
      String sev = cls.path("severity").asText("");
      if (!compat.isEmpty() && !sev.isEmpty()) parts.add(compat + ": " + sev);
    }
    return String.join(", ", parts);
  }

  // ── Data records ─────────────────────────────────────────────────────────────

  record RevapiStats(int total, int breaking, int potentiallyBreaking, int nonBreaking) {
    boolean hasChanges () {
      return total > 0;
    }
    boolean hasBreakingChanges () {
      return breaking > 0;
    }
  }

  record Change(String code, String name, String old, String newElement,
                String description, String compatibility, String severity) {
    static Change from (JsonNode node){
      return new Change(
        node.path("code").asText(""),
        node.path("name").asText(""),
        node.path("old").asText(""),
        node.path("new").asText(""),
        node.path("description").asText(""),
        renderClassifications(node),
        maxSeverity(node));
    }
  }

  record Module(String path, String name, RevapiStats stats,
                String oldArchive, String newArchive) implements Comparable<Module>

  {
    @Override
    public int compareTo (Module other){
    return this.name.compareToIgnoreCase(other.name);
  }
  }

  enum ChangeCategory {
    BREAKING("Modules with Breaking Changes", "cat-breaking"),
    NON_BREAKING("Modules with Non-Breaking Changes Only", "cat-non-breaking"),
    NO_CHANGES("Modules with No API Changes", "cat-no-changes");

    final String title;
    final String cssClass;

    ChangeCategory(String title, String cssClass) {
      this.title = title;
      this.cssClass = cssClass;
    }
  }

  // ── toMap() converters (FreeMarker boundary) ─────────────────────────────────
  // FreeMarker's ClassIntrospector requires the declaring class to be public before
  // it will expose any methods via reflection.  Since JBang single-file scripts
  // cannot have multiple public top-level classes, all nested types here are
  // package-private.  Passing plain Maps avoids reflection entirely.

  static Map<String, Object> toMap(RevapiStats s) {
    var m = new HashMap<String, Object>();
    m.put("total", s.total());
    m.put("breaking", s.breaking());
    m.put("potentiallyBreaking", s.potentiallyBreaking());
    m.put("nonBreaking", s.nonBreaking());
    return m;
  }

  static Map<String, Object> toMap(Change c) {
    var m = new HashMap<String, Object>();
    m.put("code", c.code());
    m.put("name", c.name());
    m.put("old", c.old());
    m.put("newElement", c.newElement());
    m.put("description", c.description());
    m.put("compatibility", c.compatibility());
    return m;
  }

  static Map<String, Object> toMap(Module mod) {
    var m = new HashMap<String, Object>();
    m.put("path", mod.path());
    m.put("name", mod.name());
    m.put("stats", toMap(mod.stats()));
    m.put("oldArchive", mod.oldArchive() != null ? versionOf(mod.oldArchive()) : "");
    m.put("newArchive", mod.newArchive() != null ? versionOf(mod.newArchive()) : "");
    return m;
  }

  /**
   * Extracts the version from a Maven coordinate (last colon-separated segment).
   * Returns the input unchanged if it contains no colon (already a bare version).
   */
  static String versionOf(String archive) {
    if (archive == null) return "";
    int idx = archive.lastIndexOf(':');
    return idx >= 0 ? archive.substring(idx + 1) : archive;
  }

  // ── Entry point ─────────────────────────────────────────────────────────────

  public static void main(String[] args) throws Exception {
    String oldVersion = args.length > 0 ? args[0] : System.getenv("REVAPI_OLD_VERSION");
    String newVersion = args.length > 1 ? args[1] : System.getenv("REVAPI_NEW_VERSION");

    Path stagingDir = Paths.get("target/staging");
    if (!Files.exists(stagingDir)) {
      System.err.println("Error: target/staging does not exist. Run AggregateRevapiReports first.");
      System.exit(1);
    }

    Configuration fmCfg = createFreeMarkerConfig();
    ObjectMapper mapper = new ObjectMapper();

    List<Path> jsonFiles = Files.walk(stagingDir)
      .filter(p -> p.getFileName().toString().equals("revapi-report.json"))
      .sorted()
      .toList();

    System.out.println("Generating HTML for " + jsonFiles.size() + " modules...");

    List<Module> modules = new ArrayList<>();
    Template moduleTemplate = fmCfg.getTemplate("module-report.ftl");

    for (Path jsonFile : jsonFiles) {
      Path moduleDir = jsonFile.getParent();
      Path relativePath = stagingDir.relativize(moduleDir);
      String modulePath = relativePath.toString();
      String moduleName = relativePath.getFileName().toString();

      // Parse raw JSON changes
      List<JsonNode> rawChanges = new ArrayList<>();
      JsonNode root = mapper.readTree(jsonFile.toFile());
      if (root.isArray()) root.forEach(rawChanges::add);

      String[] archives = extractArchives(rawChanges);
      String oldArchive = archives[0];
      String newArchive = archives[1];

      List<Change> changes = rawChanges.stream().map(Change::from).collect(Collectors.toList());
      RevapiStats stats = computeStats(changes);
      modules.add(new Module(modulePath, moduleName, stats, oldArchive, newArchive));

      // Group changes by severity
      Map<String, List<Map<String, Object>>> bySeverity = new HashMap<>();
      for (String sev : SEVERITY_ORDER) bySeverity.put(sev, new ArrayList<>());
      for (Change c : changes) bySeverity.get(c.severity()).add(toMap(c));

      int depth = modulePath.isEmpty() ? 1 : modulePath.split("[/\\\\]").length;
      String backLink = "../".repeat(depth) + "revapi-index.html";

      String moduleOld = oldArchive != null ? oldArchive : oldVersion;
      String moduleNew = newArchive != null ? newArchive : newVersion;

      Map<String, Object> model = new HashMap<>();
      model.put("moduleName", moduleName);
      model.put("modulePath", modulePath);
      model.put("backLink", backLink);
      model.put("oldArchive", moduleOld != null ? moduleOld : "");
      model.put("newArchive", moduleNew != null ? moduleNew : "");
      model.put("stats", toMap(stats));
      model.put("changes", changes.stream().map(GenerateRevapiIndex::toMap).collect(Collectors.toList()));
      model.put("changesBySeverity", bySeverity);
      model.put("severityOrder", SEVERITY_ORDER);
      model.put("severityLabels", SEVERITY_LABELS);

      Files.writeString(moduleDir.resolve("revapi-report.html"), renderTemplate(moduleTemplate, model));
      System.out.println("  Generated: " + modulePath + "/revapi-report.html");
    }

    // Index header: prefer env-var versions; fall back to first module's archive (version only)
    String indexOld = (oldVersion != null && !oldVersion.isEmpty()) ? oldVersion
      : modules.stream().filter(m -> m.oldArchive() != null).map(m -> versionOf(m.oldArchive())).findFirst().orElse(null);
    String indexNew = (newVersion != null && !newVersion.isEmpty()) ? newVersion
      : modules.stream().filter(m -> m.newArchive() != null).map(m -> versionOf(m.newArchive())).findFirst().orElse(null);

    // Group modules into categories
    Map<ChangeCategory, List<Module>> grouped = modules.stream()
      .sorted()
      .collect(Collectors.groupingBy(
        m -> {
          if (m.stats().hasBreakingChanges()) return ChangeCategory.BREAKING;
          else if (m.stats().hasChanges()) return ChangeCategory.NON_BREAKING;
          else return ChangeCategory.NO_CHANGES;
        },
        () -> new EnumMap<>(ChangeCategory.class),
        Collectors.toList()));

    List<Map<String, Object>> categories = new ArrayList<>();
    for (ChangeCategory cat : new ChangeCategory[]{ChangeCategory.BREAKING, ChangeCategory.NON_BREAKING, ChangeCategory.NO_CHANGES}) {
      var moduleMaps = grouped.getOrDefault(cat, List.of()).stream()
        .map(GenerateRevapiIndex::toMap).toList();
      // NO_CHANGES is collapsed by default — it is usually large and low-value
      boolean open = cat != ChangeCategory.NO_CHANGES;
      categories.add(Map.of("title", cat.title, "cssClass", cat.cssClass, "modules", moduleMaps, "open", open));
    }

    int totalChanges = modules.stream().mapToInt(m -> m.stats().total()).sum();
    int modulesWithChanges = (int) modules.stream().filter(m -> m.stats().hasChanges()).count();
    int modulesWithBreaking = (int) modules.stream().filter(m -> m.stats().hasBreakingChanges()).count();

    Map<String, Object> indexModel = new HashMap<>();
    indexModel.put("indexOld", indexOld != null ? indexOld : "");
    indexModel.put("indexNew", indexNew != null ? indexNew : "");
    indexModel.put("totalModules", modules.size());
    indexModel.put("modulesWithChanges", modulesWithChanges);
    indexModel.put("modulesWithBreaking", modulesWithBreaking);
    indexModel.put("totalChanges", totalChanges);
    indexModel.put("categories", categories);

    Template indexTemplate = fmCfg.getTemplate("revapi-index.ftl");
    Path indexFile = stagingDir.resolve("revapi-index.html");
    Files.writeString(indexFile, renderTemplate(indexTemplate, indexModel));

    System.out.println("✓ Index written: " + indexFile);
    System.out.println("✓ " + modules.size() + " module reports generated");
  }

  // ── FreeMarker ──────────────────────────────────────────────────────────────

  static Configuration createFreeMarkerConfig() throws IOException {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_33);
    cfg.setDirectoryForTemplateLoading(new File("scripts/templates"));
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    return cfg;
  }

  static String renderTemplate(Template template, Map<String, Object> model) throws Exception {
    StringWriter writer = new StringWriter();
    template.process(model, writer);
    return writer.toString();
  }

  // ── Helpers ──────────────────────────────────────────────────────────────────

  static RevapiStats computeStats(List<Change> changes) {
    int breaking = 0, potentiallyBreaking = 0, nonBreaking = 0;
    for (Change c : changes) {
      switch (c.severity()) {
        case "BREAKING" -> breaking++;
        case "POTENTIALLY_BREAKING" -> potentiallyBreaking++;
        case "NON_BREAKING" -> nonBreaking++;
      }
    }
    return new RevapiStats(changes.size(), breaking, potentiallyBreaking, nonBreaking);
  }

  /**
   * Extracts oldArchive / newArchive coordinates from the first change entry's attachments.
   */
  static String[] extractArchives(List<JsonNode> changes) {
    for (JsonNode change : changes) {
      JsonNode attachments = change.get("attachments");
      if (attachments == null || !attachments.isArray()) continue;
      String oldArchive = null, newArchive = null;
      for (JsonNode att : attachments) {
        String attName = att.path("name").asText("");
        String attValue = att.path("value").asText("");
        if ("oldArchive".equals(attName)) oldArchive = attValue;
        if ("newArchive".equals(attName)) newArchive = attValue;
      }
      if (oldArchive != null && newArchive != null) return new String[]{oldArchive, newArchive};
    }
    return new String[]{null, null};
  }
}
