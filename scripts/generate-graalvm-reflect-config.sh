#!/bin/bash

################################################################################
# GraalVM Reflection Config Generator for Fabric8 Kubernetes Client
#
# This script generates and aggregates reflect-config.json files for all
# Kubernetes and OpenShift model modules.
#
# Usage:
#   ./generate-graalvm-reflect-config.sh [options]
#
# Options:
#   -t, --tag TAG           Clone and checkout a specific git tag
#   -c, --commit COMMIT     Clone and checkout a specific commit
#   -b, --branch BRANCH     Clone and checkout a specific branch
#   -r, --repo URL          Git repository URL (default: fabric8io/kubernetes-client)
#   -o, --output DIR        Output directory for aggregated config (default: ./graalvm-config)
#   -w, --work-dir DIR      Working directory for clone (default: /tmp/k8s-client-build-XXXXX)
#   -k, --keep              Keep the cloned repository after completion
#   -h, --help              Show this help message
#
# Examples:
#   # Generate for current project
#   ./generate-graalvm-reflect-config.sh
#
#   # Generate for specific tag
#   ./generate-graalvm-reflect-config.sh --tag v6.9.0
#
#   # Generate for specific commit
#   ./generate-graalvm-reflect-config.sh --commit abc123def
#
#   # Generate for main branch
#   ./generate-graalvm-reflect-config.sh --branch main
#
#   # Clone from fork and generate
#   ./generate-graalvm-reflect-config.sh --repo https://github.com/myuser/kubernetes-client --branch my-feature
#
################################################################################

set -e  # Exit on error
set -u  # Exit on undefined variable

################################################################################
# Default Configuration
################################################################################

REPO_URL="https://github.com/fabric8io/kubernetes-client.git"
GIT_REF=""
GIT_REF_TYPE=""  # tag, commit, or branch
OUTPUT_DIR="./graalvm-config"
WORK_DIR=""
KEEP_WORK_DIR=false
USE_CURRENT_DIR=true
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

################################################################################
# Color Output
################################################################################

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

log_info() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

log_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

log_warn() {
    echo -e "${YELLOW}[WARN]${NC} $1"
}

log_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

################################################################################
# Help Message
################################################################################

show_help() {
    head -n 50 "$0" | grep "^#" | sed 's/^# //g' | sed 's/^#//g'
    exit 0
}

################################################################################
# Parse Arguments
################################################################################

parse_args() {
    while [[ $# -gt 0 ]]; do
        case $1 in
            -t|--tag)
                GIT_REF="$2"
                GIT_REF_TYPE="tag"
                USE_CURRENT_DIR=false
                shift 2
                ;;
            -c|--commit)
                GIT_REF="$2"
                GIT_REF_TYPE="commit"
                USE_CURRENT_DIR=false
                shift 2
                ;;
            -b|--branch)
                GIT_REF="$2"
                GIT_REF_TYPE="branch"
                USE_CURRENT_DIR=false
                shift 2
                ;;
            -r|--repo)
                REPO_URL="$2"
                shift 2
                ;;
            -o|--output)
                OUTPUT_DIR="$2"
                shift 2
                ;;
            -w|--work-dir)
                WORK_DIR="$2"
                shift 2
                ;;
            -k|--keep)
                KEEP_WORK_DIR=true
                shift
                ;;
            -h|--help)
                show_help
                ;;
            *)
                log_error "Unknown option: $1"
                show_help
                ;;
        esac
    done
}

################################################################################
# Validate Requirements
################################################################################

check_requirements() {
    log_info "Checking requirements..."

    local missing_tools=()

    if ! command -v git &> /dev/null; then
        missing_tools+=("git")
    fi

    if ! command -v jq &> /dev/null; then
        log_warn "jq not found - will use basic JSON parsing (less reliable)"
    fi

    if [ ${#missing_tools[@]} -gt 0 ]; then
        log_error "Missing required tools: ${missing_tools[*]}"
        log_error "Please install the missing tools and try again"
        exit 1
    fi

    log_success "All required tools are available"
}

################################################################################
# Clone Repository
################################################################################

clone_repository() {
    if [ "$USE_CURRENT_DIR" = true ]; then
        log_info "Using current directory: $(pwd)"
        # Check if we're in scripts directory
        if [[ "$(pwd)" == */scripts ]]; then
            BUILD_DIR="$(dirname "$(pwd)")"
            log_info "Detected scripts directory, using parent: $BUILD_DIR"
        # Check if we're already in kubernetes-model-generator directory
        elif [[ "$(pwd)" == */kubernetes-model-generator ]]; then
            BUILD_DIR="$(dirname "$(pwd)")"
            log_info "Detected kubernetes-model-generator directory, using parent: $BUILD_DIR"
        else
            BUILD_DIR="$(pwd)"
        fi
        return
    fi

    if [ -z "$WORK_DIR" ]; then
        WORK_DIR=$(mktemp -d /tmp/k8s-client-build-XXXXX)
        log_info "Created temporary work directory: $WORK_DIR"
    else
        mkdir -p "$WORK_DIR"
        log_info "Using work directory: $WORK_DIR"
    fi

    BUILD_DIR="$WORK_DIR/kubernetes-client"

    log_info "Cloning repository from: $REPO_URL"
    git clone --depth 1 "$REPO_URL" "$BUILD_DIR" 2>&1 | sed 's/^/  /'

    cd "$BUILD_DIR"

    case "$GIT_REF_TYPE" in
        tag)
            log_info "Checking out tag: $GIT_REF"
            git fetch --depth 1 origin "refs/tags/$GIT_REF:refs/tags/$GIT_REF"
            git checkout "tags/$GIT_REF"
            ;;
        commit)
            log_info "Checking out commit: $GIT_REF"
            git fetch --depth 1 origin "$GIT_REF"
            git checkout "$GIT_REF"
            ;;
        branch)
            log_info "Checking out branch: $GIT_REF"
            git fetch --depth 1 origin "$GIT_REF"
            git checkout "$GIT_REF"
            ;;
    esac

    log_success "Repository ready at: $BUILD_DIR"
}

################################################################################
# Generate Reflect Config Files from Generated Sources
################################################################################

generate_reflect_configs() {
    log_info "Generating GraalVM reflect-config.json files from generated classes..."

    cd "$BUILD_DIR/kubernetes-model-generator"

    # Find all module directories (those with src/generated/java)
    local modules
    modules=$(find . -type d -path "*/src/generated/java" -not -path "*/target/*" | sed 's|/src/generated/java||' | sort)

    if [ -z "$modules" ]; then
        log_error "No generated source directories found"
        log_error "Make sure model generation completed successfully"
        exit 1
    fi

    local config_count=0

    for module_dir in $modules; do
        local src_dir="$module_dir/src/generated/java"
        local output_dir="$module_dir/target/classes/META-INF/native-image"

        if [ ! -d "$src_dir" ]; then
            continue
        fi

        # Find all generated Java files in this module
        local java_files
        java_files=$(find "$src_dir" -name "*.java" -type f)

        if [ -z "$java_files" ]; then
            continue
        fi

        # Extract fully qualified class names from the Java files
        local class_names=""
        while IFS= read -r java_file; do
            # Extract package and class name
            local package
            package=$(grep -m 1 "^package " "$java_file" | sed 's/package //;s/;//')
            local classname
            classname=$(basename "$java_file" .java)

            if [ -n "$package" ] && [ -n "$classname" ]; then
                if [ -z "$class_names" ]; then
                    class_names="$package.$classname"
                else
                    class_names="$class_names"$'\n'"$package.$classname"
                fi
            fi
        done <<< "$java_files"

        if [ -z "$class_names" ]; then
            continue
        fi

        # Create output directory
        mkdir -p "$output_dir"

        # Generate reflect-config.json
        local config_file="$output_dir/reflect-config.json"
        echo "[" > "$config_file"

        local first_entry=true
        while IFS= read -r class_name; do
            if [ "$first_entry" = false ]; then
                echo "," >> "$config_file"
            fi

            cat >> "$config_file" <<CLASSEOF
  {
    "condition": {
      "typeReachable": "$class_name"
    },
    "name": "$class_name",
    "allDeclaredConstructors": true,
    "allDeclaredMethods": true,
    "allDeclaredFields": true
  }
CLASSEOF
            first_entry=false
        done <<< "$class_names"

        echo "" >> "$config_file"
        echo "]" >> "$config_file"

        local num_classes
        num_classes=$(echo "$class_names" | wc -l | tr -d ' ')
        local module_name
        module_name=$(basename "$module_dir")
        log_info "  Generated $config_file with $num_classes entries for $module_name"

        ((config_count++))
    done

    if [ $config_count -eq 0 ]; then
        log_error "No reflect-config.json files were generated!"
        log_error "Check that model generation created source files"
        exit 1
    fi

    log_success "Generated reflect-config.json files for $config_count modules"
}

################################################################################
# Find and Count Reflect Config Files
################################################################################

find_reflect_configs() {
    log_info "Searching for reflect-config.json files..."

    cd "$BUILD_DIR/kubernetes-model-generator"

    # Find all reflect-config.json files (excluding aggregator output)
    REFLECT_CONFIGS=$(find . -name "reflect-config.json" -path "*/META-INF/native-image/*" -not -path "*/graalvm-reflect-config-aggregator/*" 2>/dev/null || true)

    if [ -z "$REFLECT_CONFIGS" ]; then
        log_error "No reflect-config.json files found!"
        log_error "Make sure model generation completed successfully"
        exit 1
    fi

    CONFIG_COUNT=$(echo "$REFLECT_CONFIGS" | wc -l | tr -d ' ')
    log_success "Found $CONFIG_COUNT reflect-config.json files"
}

################################################################################
# Aggregate Reflect Configs
################################################################################

aggregate_configs() {
    log_info "Aggregating reflect-config.json files..."

    cd "$BUILD_DIR/kubernetes-model-generator"

    # Create output directory
    AGGREGATED_DIR="$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/target/classes/META-INF/native-image"
    mkdir -p "$AGGREGATED_DIR"

    AGGREGATED_FILE="$AGGREGATED_DIR/reflect-config.json"

    # Start JSON array
    echo "[" > "$AGGREGATED_FILE"

    # Track if this is the first entry
    FIRST_ENTRY=true

    # Aggregate all configs
    while IFS= read -r config_file; do
        if [ ! -f "$config_file" ]; then
            continue
        fi

        # Get the module name for logging
        MODULE_NAME=$(echo "$config_file" | cut -d'/' -f2)
        log_info "  Processing: $MODULE_NAME"

        # Read JSON array content (skip first '[' and last ']')
        CONTENT=$(sed '1d;$d' "$config_file")

        # Add comma separator if not first entry
        if [ "$FIRST_ENTRY" = false ]; then
            echo "," >> "$AGGREGATED_FILE"
        fi

        # Append content
        echo "$CONTENT" >> "$AGGREGATED_FILE"
        FIRST_ENTRY=false

    done <<< "$REFLECT_CONFIGS"

    # Close JSON array
    echo "]" >> "$AGGREGATED_FILE"

    # Count total entries
    TOTAL_ENTRIES=$(grep -c '"name"' "$AGGREGATED_FILE" || echo "0")

    # Get file size
    FILE_SIZE=$(du -h "$AGGREGATED_FILE" | cut -f1)

    log_success "Aggregation complete!"
    log_info "  Total entries: $TOTAL_ENTRIES"
    log_info "  File size: $FILE_SIZE"
    log_info "  Location: $AGGREGATED_FILE"
}

################################################################################
# Validate JSON
################################################################################

validate_json() {
    log_info "Validating aggregated JSON..."

    if command -v jq &> /dev/null; then
        if jq empty "$AGGREGATED_FILE" 2>/dev/null; then
            log_success "JSON is valid"
        else
            log_error "Generated JSON is invalid!"
            exit 1
        fi
    else
        log_warn "jq not available - skipping JSON validation"
    fi
}

################################################################################
# Copy to Output Directory
################################################################################

copy_to_output() {
    log_info "Copying aggregated config to output directory..."

    # Create output directory (resolve to absolute path)
    if [[ "$OUTPUT_DIR" != /* ]]; then
        OUTPUT_DIR="$SCRIPT_DIR/$OUTPUT_DIR"
    fi

    mkdir -p "$OUTPUT_DIR"

    # Copy the aggregated file
    cp "$AGGREGATED_FILE" "$OUTPUT_DIR/reflect-config.json"

    # Copy documentation if available
    if [ -f "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/README.md" ]; then
        cp "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/README.md" "$OUTPUT_DIR/"
    fi

    if [ -f "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/NATIVE_IMAGE_USAGE.md" ]; then
        cp "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/NATIVE_IMAGE_USAGE.md" "$OUTPUT_DIR/"
    fi

    if [ -f "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/QUICK_START.md" ]; then
        cp "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/QUICK_START.md" "$OUTPUT_DIR/"
    fi

    if [ -f "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/pom-example.xml" ]; then
        cp "$BUILD_DIR/kubernetes-model-generator/graalvm-reflect-config-aggregator/pom-example.xml" "$OUTPUT_DIR/"
    fi

    log_success "Output saved to: $OUTPUT_DIR/reflect-config.json"
}

################################################################################
# Create Summary Report
################################################################################

create_summary() {
    log_info "Creating summary report..."

    SUMMARY_FILE="$OUTPUT_DIR/GENERATION_SUMMARY.txt"

    cat > "$SUMMARY_FILE" <<EOF
================================================================================
GraalVM Reflection Config Generation Summary
================================================================================

Generated: $(date)
Script Version: 1.0

Project Information:
  Repository: $REPO_URL
  Reference: ${GIT_REF:-"current directory"}
  Reference Type: ${GIT_REF_TYPE:-"local"}
  Build Directory: $BUILD_DIR

Generation Results:
  Source Modules: $CONFIG_COUNT modules
  Total Entries: $TOTAL_ENTRIES reflection configurations
  File Size: $FILE_SIZE

Output Files:
  Configuration: $OUTPUT_DIR/reflect-config.json
  Summary: $OUTPUT_DIR/GENERATION_SUMMARY.txt
$([ -f "$OUTPUT_DIR/README.md" ] && echo "  Documentation: $OUTPUT_DIR/README.md")
$([ -f "$OUTPUT_DIR/NATIVE_IMAGE_USAGE.md" ] && echo "  Usage Guide: $OUTPUT_DIR/NATIVE_IMAGE_USAGE.md")
$([ -f "$OUTPUT_DIR/QUICK_START.md" ] && echo "  Quick Start: $OUTPUT_DIR/QUICK_START.md")
$([ -f "$OUTPUT_DIR/pom-example.xml" ] && echo "  POM Example: $OUTPUT_DIR/pom-example.xml")

Usage:
  Copy reflect-config.json to your application's META-INF/native-image/ directory
  or reference it directly in your GraalVM native-image build configuration.

  See NATIVE_IMAGE_USAGE.md for detailed instructions.

Sample Configuration Entry:
EOF

    # Add a sample entry from the config
    if command -v jq &> /dev/null; then
        echo "" >> "$SUMMARY_FILE"
        jq '.[0]' "$OUTPUT_DIR/reflect-config.json" >> "$SUMMARY_FILE" 2>/dev/null || true
    fi

    cat >> "$SUMMARY_FILE" <<EOF

================================================================================
EOF

    # Display summary to console
    cat "$SUMMARY_FILE"
}

################################################################################
# Cleanup
################################################################################

cleanup() {
    if [ "$USE_CURRENT_DIR" = false ] && [ "$KEEP_WORK_DIR" = false ] && [ -n "$WORK_DIR" ]; then
        log_info "Cleaning up work directory..."
        rm -rf "$WORK_DIR"
        log_success "Cleanup complete"
    elif [ "$KEEP_WORK_DIR" = true ]; then
        log_info "Work directory preserved at: $WORK_DIR"
    fi
}

################################################################################
# Main Execution
################################################################################

main() {
    echo "================================================================================"
    echo "  GraalVM Reflection Config Generator for Fabric8 Kubernetes Client"
    echo "================================================================================"
    echo ""

    parse_args "$@"
    check_requirements
    clone_repository
    generate_reflect_configs
    find_reflect_configs
    aggregate_configs
    validate_json
    copy_to_output
    create_summary
    cleanup

    echo ""
    echo "================================================================================"
    log_success "Generation completed successfully!"
    echo "================================================================================"
    echo ""
    log_info "Output directory: $OUTPUT_DIR"
    log_info "Configuration file: $OUTPUT_DIR/reflect-config.json"
    log_info "Total entries: $TOTAL_ENTRIES"
    echo ""
}

# Trap errors and cleanup
trap cleanup EXIT

# Run main function
main "$@"
