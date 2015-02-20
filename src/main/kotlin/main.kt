package patorash.gradle_kotlin_practice

import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration
import org.eclipse.jetty.plus.webapp.PlusConfiguration
import org.eclipse.jetty.webapp.FragmentConfiguration
import org.eclipse.jetty.plus.webapp.EnvConfiguration
import org.eclipse.jetty.webapp.MetaInfConfiguration
import org.eclipse.jetty.webapp.WebXmlConfiguration
import org.eclipse.jetty.webapp.WebInfConfiguration
import org.eclipse.jetty.annotations.AnnotationConfiguration
import org.eclipse.jetty.webapp.Configuration


fun main(args: Array<String>) {
    // 1. war ファイルの設定
    val war = WebAppContext()
    war.setContextPath("/sample")
    war.setWar("./GradleKotlinPractice.war")

    // 2. @WebServlet とかを有効にしている
    val configurations: Array<Configuration> = array(
            AnnotationConfiguration(),
            WebInfConfiguration(),
            WebXmlConfiguration(),
            MetaInfConfiguration(),
            FragmentConfiguration(),
            EnvConfiguration(),
            PlusConfiguration(),
            JettyWebXmlConfiguration()
    )

    war.setConfigurations(configurations)

    val server = Server(1234)
    server.setHandler(war);
    server.start();
    server.join();
}