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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Generate an enhanced index for all Revapi reports with categorization.
 */
class GenerateRevapiIndex {

  static class Module implements Comparable<Module> {
    final String path;
    final String name;
    final RevapiStats stats;

    Module(String path, String name, RevapiStats stats) {
      this.path = path;
      this.name = name;
      this.stats = stats;
    }

    @Override
    public int compareTo(Module other) {
      return this.name.compareToIgnoreCase(other.name);
    }
  }

  static class RevapiStats {
    int totalChanges;
    int binaryBreaking;
    int sourceBreaking;
    int semanticBreaking;
    int potentiallyBreaking;
    int nonBreaking;

    RevapiStats() {
      this.totalChanges = 0;
      this.binaryBreaking = 0;
      this.sourceBreaking = 0;
      this.semanticBreaking = 0;
      this.potentiallyBreaking = 0;
      this.nonBreaking = 0;
    }

    boolean hasChanges() {
      return totalChanges > 0;
    }

    boolean hasBreakingChanges() {
      return binaryBreaking > 0 || sourceBreaking > 0 || semanticBreaking > 0;
    }
  }

  enum ChangeCategory {
    BREAKING("🔴 Modules with Breaking Changes"),
    NON_BREAKING("🟡 Modules with Non-Breaking Changes Only"),
    NO_CHANGES("🟢 Modules with No Changes");

    final String title;

    ChangeCategory(String title) {
      this.title = title;
    }
  }

  static ChangeCategory categorizeByChanges(Module module) {
    if (module.stats.hasBreakingChanges()) {
      return ChangeCategory.BREAKING;
    } else if (module.stats.hasChanges()) {
      return ChangeCategory.NON_BREAKING;
    } else {
      return ChangeCategory.NO_CHANGES;
    }
  }

  static RevapiStats parseRevapiJson(Path jsonPath) {
    RevapiStats stats = new RevapiStats();

    if (!Files.exists(jsonPath)) {
      return stats;
    }

    try {
      ObjectMapper mapper = new ObjectMapper();
      JsonNode root = mapper.readTree(jsonPath.toFile());

      if (!root.isArray()) {
        return stats;
      }

      for (JsonNode change : root) {
        stats.totalChanges++;

        // Track severity per change (not per classification)
        boolean hasBreaking = false;
        boolean hasPotentiallyBreaking = false;
        boolean hasNonBreaking = false;

        JsonNode classifications = change.get("classification");
        if (classifications != null && classifications.isArray()) {
          for (JsonNode classification : classifications) {
            JsonNode compatibilityNode = classification.get("compatibility");
            JsonNode severityNode = classification.get("severity");

            if (compatibilityNode == null || severityNode == null) {
              continue;
            }

            String compatibility = compatibilityNode.asText();
            String severity = severityNode.asText();

            // Count by compatibility type and severity
            if ("BREAKING".equals(severity)) {
              hasBreaking = true;
              if ("BINARY".equals(compatibility)) {
                stats.binaryBreaking++;
              } else if ("SOURCE".equals(compatibility)) {
                stats.sourceBreaking++;
              } else if ("SEMANTIC".equals(compatibility)) {
                stats.semanticBreaking++;
              }
            } else if ("POTENTIALLY_BREAKING".equals(severity)) {
              hasPotentiallyBreaking = true;
            } else if ("NON_BREAKING".equals(severity)) {
              hasNonBreaking = true;
            }
          }
        }

        // Count overall severities per change
        if (hasPotentiallyBreaking) {
          stats.potentiallyBreaking++;
        }
        if (hasNonBreaking) {
          stats.nonBreaking++;
        }
      }
    } catch (IOException e) {
      System.err.println("Warning: Failed to parse " + jsonPath + ": " + e.getMessage());
    }

    return stats;
  }

  static List<Module> findRevapiReports(Path stagingDir) throws IOException {
    return Files.walk(stagingDir)
      .filter(p -> p.getFileName().toString().equals("revapi-report.html"))
      .map(p -> {
        Path modulePath = stagingDir.relativize(p.getParent());
        String name = modulePath.getFileName().toString();

        // Try to find and parse the JSON report
        Path jsonPath = p.getParent().resolve("revapi-report.json");
        RevapiStats stats = parseRevapiJson(jsonPath);

        return new Module(modulePath.toString(), name, stats);
      })
      .collect(Collectors.toList());
  }

  static String renderModuleList(List<Module> modules) {
    if (modules.isEmpty()) {
      return "      <p style=\"color: #999; font-style: italic;\">No modules in this category</p>\n";
    }

    StringBuilder sb = new StringBuilder();
    for (Module module : modules) {
      String badgeHtml = "";
      RevapiStats stats = module.stats;

      if (stats.hasChanges()) {
        String badgeClass = stats.hasBreakingChanges() ? "badge-warning" : "badge-success";
        badgeHtml = String.format("<span class=\"change-badge %s\">%d changes</span>",
          badgeClass, stats.totalChanges);
      } else {
        badgeHtml = "<span class=\"change-badge badge-neutral\">no changes</span>";
      }

      String detailsHtml = "";
      if (stats.hasChanges()) {
        StringBuilder details = new StringBuilder("<div class=\"change-details\">");

        if (stats.binaryBreaking > 0) {
          details.append(String.format("<span class=\"detail-item breaking\">⚠ %d binary breaking</span>", stats.binaryBreaking));
        }
        if (stats.sourceBreaking > 0) {
          details.append(String.format("<span class=\"detail-item breaking\">⚠ %d source breaking</span>", stats.sourceBreaking));
        }
        if (stats.semanticBreaking > 0) {
          details.append(String.format("<span class=\"detail-item breaking\">⚠ %d semantic breaking</span>", stats.semanticBreaking));
        }
        if (stats.potentiallyBreaking > 0) {
          details.append(String.format("<span class=\"detail-item potentially\">⚡ %d potentially breaking</span>", stats.potentiallyBreaking));
        }
        if (stats.nonBreaking > 0) {
          details.append(String.format("<span class=\"detail-item safe\">✓ %d non-breaking</span>", stats.nonBreaking));
        }

        details.append("</div>");
        detailsHtml = details.toString();
      }

      sb.append(String.format("""
          <div class="module-item">
            <div class="module-header">
              <a href="%s/revapi-report.html">%s</a>
              %s
            </div>
            <div class="module-path">%s</div>
            %s
          </div>
        """, module.path, module.name, badgeHtml, module.path, detailsHtml));
    }
    return sb.toString();
  }

  static String generateHtml(List<Module> allModules, String oldVersion, String newVersion) {
    // Group modules by change type
    Map<ChangeCategory, List<Module>> byChangeType = allModules.stream()
      .sorted()
      .collect(Collectors.groupingBy(
        GenerateRevapiIndex::categorizeByChanges,
        () -> new EnumMap<>(ChangeCategory.class),
        Collectors.toList()));

    // Calculate overall statistics
    int totalChanges = allModules.stream().mapToInt(m -> m.stats.totalChanges).sum();
    int modulesWithChanges = (int) allModules.stream().filter(m -> m.stats.hasChanges()).count();
    int modulesWithBreaking = (int) allModules.stream().filter(m -> m.stats.hasBreakingChanges()).count();

    // Generate version comparison text
    String versionInfo = "";
    if (oldVersion != null && !oldVersion.isEmpty()) {
      if (newVersion != null && !newVersion.isEmpty()) {
        versionInfo = String.format("<p><strong>Comparing:</strong> <code>%s</code> → <code>%s</code></p>", oldVersion, newVersion);
      } else {
        versionInfo = String.format("<p><strong>Comparing:</strong> Current code vs. published version <code>%s</code></p>", oldVersion);
      }
    }

    StringBuilder html = new StringBuilder();

    // Header
    html.append("""
      <!DOCTYPE html>
      <html lang="en">
      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Revapi API Compatibility Reports</title>
        <link rel="stylesheet" href="css/maven-base.css">
        <link rel="stylesheet" href="css/maven-theme.css">
        <style>
          body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            line-height: 1.6;
            max-width: 1400px;
            margin: 0 auto;
            padding: 20px;
            background: #f5f5f5;
          }
          .container {
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
          }
          h1 {
            color: #333;
            border-bottom: 3px solid #4CAF50;
            padding-bottom: 10px;
            margin-top: 0;
          }
          h2 {
            color: #555;
            margin-top: 30px;
            border-bottom: 2px solid #ddd;
            padding-bottom: 5px;
          }
          .stats {
            background: #e8f5e9;
            padding: 15px;
            border-radius: 5px;
            margin: 20px 0;
            border-left: 4px solid #4CAF50;
          }
          .module-list {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(350px, 1fr));
            gap: 12px;
            margin-top: 15px;
          }
          .module-item {
            background: #fafafa;
            border: 1px solid #e0e0e0;
            border-radius: 6px;
            padding: 12px 16px;
            transition: all 0.2s;
          }
          .module-item:hover {
            border-color: #4CAF50;
            box-shadow: 0 3px 8px rgba(0,0,0,0.15);
            background: white;
          }
          .module-item a {
            color: #1976d2;
            text-decoration: none;
            font-weight: 500;
            font-size: 0.95em;
          }
          .module-item a:hover {
            text-decoration: underline;
          }
          .module-path {
            font-size: 0.8em;
            color: #757575;
            font-family: 'Monaco', 'Menlo', 'Ubuntu Mono', monospace;
            margin-top: 4px;
          }
          .module-header {
            display: flex;
            align-items: center;
            gap: 8px;
            flex-wrap: wrap;
          }
          .change-badge {
            font-size: 0.75em;
            padding: 3px 8px;
            border-radius: 12px;
            font-weight: 600;
            white-space: nowrap;
          }
          .badge-success {
            background: #d4edda;
            color: #155724;
          }
          .badge-warning {
            background: #fff3cd;
            color: #856404;
          }
          .badge-neutral {
            background: #e9ecef;
            color: #6c757d;
          }
          .change-details {
            display: flex;
            flex-wrap: wrap;
            gap: 6px;
            margin-top: 8px;
          }
          .detail-item {
            font-size: 0.72em;
            padding: 2px 6px;
            border-radius: 3px;
            font-weight: 500;
          }
          .detail-item.breaking {
            background: #f8d7da;
            color: #721c24;
          }
          .detail-item.potentially {
            background: #fff3cd;
            color: #856404;
          }
          .detail-item.safe {
            background: #d4edda;
            color: #155724;
          }
          .summary-box {
            background: #fff9e6;
            border-left: 4px solid #ffc107;
            padding: 15px;
            border-radius: 4px;
            margin: 15px 0;
          }
          .summary-box h3 {
            margin-top: 0;
            color: #333;
            font-size: 1.1em;
          }
          .summary-stats {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
            margin-top: 10px;
          }
          .summary-stat {
            display: flex;
            flex-direction: column;
          }
          .summary-stat-value {
            font-size: 1.5em;
            font-weight: bold;
            color: #333;
          }
          .summary-stat-label {
            font-size: 0.85em;
            color: #666;
          }
          .back-link {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 20px;
            background: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 500;
          }
          .back-link:hover {
            background: #45a049;
          }
          .category-count {
            color: #757575;
            font-size: 0.9em;
            font-weight: normal;
          }
          .stat-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 15px;
            margin: 25px 0;
          }
          .stat-box {
            background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%);
            color: white;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
          }
          .stat-box.core {
            background: linear-gradient(135deg, #4CAF50 0%%, #45a049 100%%);
          }
          .stat-box.models {
            background: linear-gradient(135deg, #2196F3 0%%, #1976d2 100%%);
          }
          .stat-box.extensions {
            background: linear-gradient(135deg, #FF9800 0%%, #F57C00 100%%);
          }
          .stat-box.testing {
            background: linear-gradient(135deg, #9C27B0 0%%, #7B1FA2 100%%);
          }
          .stat-number {
            font-size: 2.5em;
            font-weight: bold;
            line-height: 1;
            margin-bottom: 5px;
          }
          .stat-label {
            font-size: 0.9em;
            opacity: 0.9;
            text-transform: uppercase;
            letter-spacing: 1px;
          }
          .intro {
            background: #f9f9f9;
            border-left: 4px solid #4CAF50;
            padding: 20px;
            margin: 20px 0;
            border-radius: 4px;
          }
          .intro p {
            margin: 8px 0;
            color: #555;
          }
          .intro code {
            background: #e3f2fd;
            color: #1565c0;
            padding: 2px 6px;
            border-radius: 3px;
            font-weight: 600;
            font-size: 0.95em;
          }
          .module-header {
            display: flex;
            align-items: center;
            gap: 8px;
            flex-wrap: wrap;
          }
          .change-badge {
            font-size: 0.75em;
            padding: 3px 8px;
            border-radius: 12px;
            font-weight: 600;
            white-space: nowrap;
          }
          .badge-success {
            background: #d4edda;
            color: #155724;
          }
          .badge-warning {
            background: #fff3cd;
            color: #856404;
          }
          .badge-neutral {
            background: #e9ecef;
            color: #6c757d;
          }
          .change-details {
            display: flex;
            flex-wrap: wrap;
            gap: 6px;
            margin-top: 8px;
          }
          .detail-item {
            font-size: 0.72em;
            padding: 2px 6px;
            border-radius: 3px;
            font-weight: 500;
          }
          .detail-item.breaking {
            background: #f8d7da;
            color: #721c24;
          }
          .detail-item.potentially {
            background: #fff3cd;
            color: #856404;
          }
          .detail-item.safe {
            background: #d4edda;
            color: #155724;
          }
          .summary-box {
            background: #fff9e6;
            border-left: 4px solid #ffc107;
            padding: 15px;
            border-radius: 4px;
            margin: 15px 0;
          }
          .summary-box h3 {
            margin-top: 0;
            color: #333;
            font-size: 1.1em;
          }
          .summary-stats {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
            margin-top: 10px;
          }
          .summary-stat {
            display: flex;
            flex-direction: column;
          }
          .summary-stat-value {
            font-size: 1.5em;
            font-weight: bold;
            color: #333;
          }
          .summary-stat-label {
            font-size: 0.85em;
            color: #666;
          }
        </style>
      </head>
      <body>
        <div class="container">
          <h1>Revapi API Compatibility Reports</h1>

          <div class="intro">
            <p><strong>Binary API Compatibility Analysis</strong> - Compare bytecode-level API changes between versions</p>
            <p>These reports identify breaking changes that would cause runtime errors (NoSuchMethodError, NoClassDefFoundError, etc.) when upgrading library versions without recompiling dependent code.</p>
            %s
          </div>

          <div class="summary-box">
            <h3>📊 API Changes Summary</h3>
            <div class="summary-stats">
              <div class="summary-stat">
                <span class="summary-stat-value">%d</span>
                <span class="summary-stat-label">Total Changes</span>
              </div>
              <div class="summary-stat">
                <span class="summary-stat-value">%d</span>
                <span class="summary-stat-label">Modules with Changes</span>
              </div>
              <div class="summary-stat">
                <span class="summary-stat-value">%d</span>
                <span class="summary-stat-label">Modules with Breaking Changes</span>
              </div>
            </div>
          </div>
      """.formatted(versionInfo, totalChanges, modulesWithChanges, modulesWithBreaking));

    // Render each change category
    for (ChangeCategory changeCategory : ChangeCategory.values()) {
      List<Module> modules = byChangeType.getOrDefault(changeCategory, List.of());
      html.append(String.format("""
            <h2>%s <span class="category-count">(%d)</span></h2>
            <div class="module-list">
        %s    </div>
        """, changeCategory.title, modules.size(), renderModuleList(modules)));
    }

    // Footer
    html.append("""
        </div>
      </body>
      </html>
      """);

    return html.toString();
  }

  public static void main(String[] args) throws IOException {
    System.out.println("Generating enhanced Revapi index...");

    // Get version information from environment variables or command-line arguments
    String oldVersion = args.length > 0 ? args[0] : System.getenv("REVAPI_OLD_VERSION");
    String newVersion = args.length > 1 ? args[1] : System.getenv("REVAPI_NEW_VERSION");

    Path stagingDir = Paths.get("target/staging");
    if (!Files.exists(stagingDir)) {
      System.err.println("Error: target/staging does not exist");
      System.exit(1);
    }

    // Find all modules with Revapi reports
    List<Module> modules = findRevapiReports(stagingDir);

    // Generate HTML
    String html = generateHtml(modules, oldVersion, newVersion);

    // Write to file
    Path outputFile = stagingDir.resolve("revapi-index.html");
    Files.writeString(outputFile, html);

    System.out.println("✓ Enhanced index created at: " + outputFile);
    System.out.println("✓ Found " + modules.size() + " modules with Revapi reports");
    if (oldVersion != null) {
      System.out.println("✓ Comparing versions: " + oldVersion + (newVersion != null ? " → " + newVersion : " → current"));
    }
  }
}
