#!/usr/bin/env bash
#
# Updates GroupDocs.Comparison version across all projects, Dockerfiles, and README.
#
# Usage:
#   ./scripts/update-version.sh 24.7
#   ./scripts/update-version.sh          # prints current version

set -euo pipefail

REPO_ROOT="$(cd "$(dirname "$0")/.." && pwd)"

POMS=(
  Examples/GroupDocs.Comparison.Examples.Java/pom.xml
  Demos/Spring/pom.xml
  Demos/Dropwizard/pom.xml
  Demos/demos-api-tests/pom.xml
)

GRADLES=(
  Demos/Javalin/build.gradle.kts
  Demos/Ktor/build.gradle.kts
  Demos/Micronaut/build.gradle.kts
  Demos/Compose/build.gradle.kts
)

DOCKERFILES=(
  Demos/Spring/docker/Dockerfile-openjdk8-bullseye
  Demos/Spring/docker/Dockerfile-openjdk11-bullseye
  Demos/Spring/docker/Dockerfile-openjdk18-bullseye
  Demos/Dropwizard/docker/Dockerfile-openjdk8-bullseye
  Demos/Dropwizard/docker/Dockerfile-openjdk11-bullseye
  Demos/Dropwizard/docker/Dockerfile-openjdk18-bullseye
)

README_FILES=(
  Demos/Spring/README.md
  Demos/Dropwizard/README.md
  Demos/Javalin/README.md
  Demos/Ktor/README.md
  Demos/Micronaut/README.md
  Demos/Compose/README.md
)

extract_pom_version() {
  grep -m1 '<version>[0-9]\+\.[0-9]\+</version>' "$1" | sed 's/.*<version>\([0-9]\+\.[0-9]\+\)<\/version>.*/\1/'
}

extract_gradle_version() {
  grep '^version = "' "$1" | sed 's/version = "\([0-9]\+\.[0-9]\+\)".*/\1/'
}

extract_dockerfile_version() {
  grep 'LABEL version="' "$1" | sed 's/.*LABEL version="\([0-9]\+\.[0-9]\+\)".*/\1/'
}

print_current_version() {
  echo "Current versions:"
  echo ""
  echo "  pom.xml:"
  for pom in "${POMS[@]}"; do
    ver=$(extract_pom_version "${REPO_ROOT}/${pom}" || echo "?")
    printf "    %-55s %s\n" "${pom}" "${ver}"
  done
  echo ""
  echo "  build.gradle.kts:"
  for gradle in "${GRADLES[@]}"; do
    ver=$(extract_gradle_version "${REPO_ROOT}/${gradle}" || echo "?")
    printf "    %-55s %s\n" "${gradle}" "${ver}"
  done
  echo ""
  echo "  Dockerfiles:"
  for df in "${DOCKERFILES[@]}"; do
    ver=$(extract_dockerfile_version "${REPO_ROOT}/${df}" || echo "?")
    printf "    %-55s %s\n" "${df}" "${ver}"
  done
  echo ""
  echo "  README.md:"
  grep -n '| [0-9]\+\.[0-9]\+ |$' "${REPO_ROOT}/README.md" | head -1 | sed 's/^/    /' || true
}

update_version() {
  local VERSION="$1"

  echo "Updating all versions to ${VERSION}..."
  echo ""

  for pom in "${POMS[@]}"; do
    sed -i "0,/<version>[0-9]\+\.[0-9]\+<\/version>/s/<version>[0-9]\+\.[0-9]\+<\/version>/<version>${VERSION}<\/version>/" "${REPO_ROOT}/${pom}"
    echo "  ${pom}"
  done

  for gradle in "${GRADLES[@]}"; do
    sed -i "s/^version = \"[0-9]\+\.[0-9]\+\"/version = \"${VERSION}\"/" "${REPO_ROOT}/${gradle}"
    echo "  ${gradle}"
  done

  for df in "${DOCKERFILES[@]}"; do
    sed -i "s/LABEL version=\"[0-9]\+\.[0-9]\+\"/LABEL version=\"${VERSION}\"/" "${REPO_ROOT}/${df}"
    echo "  ${df}"
  done

  sed -i "s/| [0-9]\+\.[0-9]\+ |$/| ${VERSION} |/" "${REPO_ROOT}/README.md"
  sed -i "s/<version>[0-9]\+\.[0-9]\+<\/version>/<version>${VERSION}<\/version>/" "${REPO_ROOT}/README.md"
  echo "  README.md"

  for readme in "${README_FILES[@]}"; do
    sed -i "s/^###### version [0-9]\+\.[0-9]\+/###### version ${VERSION}/" "${REPO_ROOT}/${readme}"
    sed -i "s/groupdocs\/comparison:[0-9]\+\.[0-9]\+-java-/groupdocs\/comparison:${VERSION}-java-/g" "${REPO_ROOT}/${readme}"
    echo "  ${readme}"
  done

  echo ""
  echo "Done. Verify with: $0"
}

if [[ $# -eq 0 ]]; then
  print_current_version
elif [[ $# -eq 1 ]]; then
  if ! [[ "$1" =~ ^[0-9]+\.[0-9]+$ ]]; then
    echo "Error: version must match pattern XX.YY (e.g. 24.7)" >&2
    exit 1
  fi
  update_version "$1"
else
  echo "Usage: $0 [version]" >&2
  echo "  No arguments  — print current versions" >&2
  echo "  version        — update all versions (e.g. $0 24.7)" >&2
  exit 1
fi
