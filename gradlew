#!/bin/bash

##############################################################################
# Gradle Wrapper Script
##############################################################################

set -o nounset
set -o errexit

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

# Add default JVM options here
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

warn () {
    echo "$*"
}

die () {
    echo
    echo "$*"
    echo
    exit 1
}

GRADLE_HOME="${GRADLE_HOME:-}"
if [ -n "$GRADLE_HOME" ] ; then
    if [ -x "$GRADLE_HOME/bin/gradle" ] ; then
        GRADLE_CMD="$GRADLE_HOME/bin/gradle"
    else
        die "ERROR: GRADLE_HOME is set to an invalid directory: $GRADLE_HOME"
    fi
else
    GRADLE_CMD="gradle"
fi

# Check for Gradle wrapper jar
CLASSPATH="$PWD/gradle/wrapper/gradle-wrapper.jar"

if [ ! -f "$CLASSPATH" ]; then
    echo "Gradle wrapper not found. Downloading..."
    mkdir -p gradle/wrapper
    curl -L -o gradle/wrapper/gradle-wrapper.jar \
        https://services.gradle.org/distributions/gradle-8.4-bin.zip 2>/dev/null || \
    wget -O gradle/wrapper/gradle-wrapper.jar \
        https://services.gradle.org/distributions/gradle-8.4-bin.zip 2>/dev/null || \
    die "ERROR: Could not download Gradle wrapper"
fi

# Determine the Java command to use to start the JVM.
JAVACMD="${JAVA_HOME:-}/bin/java"
if [ ! -x "$JAVACMD" ] ; then
    JAVACMD="java"
fi

# Escape application args
APP_ARGS=""
for arg in "$@"; do
    APP_ARGS="$APP_ARGS \"$arg\""
done

eval "exec \"$JAVACMD\" $DEFAULT_JVM_OPTS -classpath \"$CLASSPATH\" org.gradle.wrapper.GradleWrapperMain $APP_ARGS"
