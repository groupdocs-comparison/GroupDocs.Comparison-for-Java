package com.novoda.gradle.command
import org.gradle.testfixtures.ProjectBuilder

class AndroidCommandPluginExtensionTest extends GroovyTestCase {

    private static final String SDK_PATH = '/some/path'

    void testDefaultAdbPath() {
        def extension = createExtension()
        assert extension.adb != null
        assert extension.adb.contains('bbb')
    }

    void testDefaultMonkey() {
        def extension = createExtension()
        assert extension.monkey.events == MonkeyExtension.EVENTS_DEFAULT
    }

    private static AndroidCommandPluginExtension createExtension() {
        def project = ProjectBuilder.builder()
                .withProjectDir(new File('.'))
                .build()
        def extension = new AndroidCommandPluginExtension(project, SDK_PATH)
        extension
    }
}