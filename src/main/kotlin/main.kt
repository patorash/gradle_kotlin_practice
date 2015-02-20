package patorash.gradle_kotlin_practice

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Request
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.eclipse.jetty.servlet.ServletHandler
import javax.servlet.http.HttpServlet

fun main(args: Array<String>) {
    val server = Server(1234)

    // 単純に全てのアクセスをHelloJettyHandlerに丸投げする
    // server.setHandler(HelloJettyHandler())

    // ServeletHandlerを定義して、URLごとにクラスをマッピングして処理を行う
    val handler = ServletHandler()
    handler.addServletWithMapping(javaClass<SampleServlet>(), "/sample")

    server.setHandler(handler)
    server.start()
    server.join()
}

class HelloJettyHandler : AbstractHandler() {
    override fun handle(target: String?, baseRequest: Request?, request: HttpServletRequest?, response: HttpServletResponse?) {
        System.out.println("target = " + target)

        response!!.setContentType("text/html;charset=utf-8")
        response.setStatus(HttpServletResponse.SC_OK)
        baseRequest!!.setHandled(true)
        response.getWriter().println("<h1>Hello Jetty!!</h1>")
    }
}

class SampleServlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp!!.getWriter().println("Servlet on Jetty.")
    }
}